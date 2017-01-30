package eu.vicci.process.graphiti.property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import eu.vicci.openhab.util.IOpenHabRestClient;
import eu.vicci.openhab.util.OpenHabRestClient;
import eu.vicci.openhab.util.beans.Goal;
import eu.vicci.openhab.util.beans.Quality;
import eu.vicci.openhab.util.beans.SemanticLocation;
import eu.vicci.process.adapter.AdapterConstants;
import eu.vicci.process.adapter.EngineAdapter;
import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.GoalInvoke;

public class GoalInvokeSection extends PropertySectionBase {
	private static final String LABEL_GOAL = "Invoke Goal: ";
	private static final String LABEL_LOCATION = "Location: ";

	private CCombo wGoal;
	private Section wQualitySection;
	private CCombo wLocation;
	private Composite wQualityClient;

	private Map<String, Button> qualityMap = new HashMap<>();

	private IOpenHabRestClient client;

	// for locking widgets and map
	private Object mLock = new Object();

	private SelectionAdapter selectionAdapter = new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			writeToModel();
		};
	};

	private void addQualities() {
		List<Quality> qs = client.getAllQualities();
		if (qs == null || qs.isEmpty())
			return;
		qs.stream().forEach(q -> addQualityIfNotExists(q.name));
	}

	private void addQualityIfNotExists(String name) {
		if (name == null)
			return;
		if (qualityMap.containsKey(name))
			return;
		addSingleQuality(name);
	}

	/**
	 * same as addSingleQuality(txt, false)
	 * 
	 * @param txt
	 */
	private void addSingleQuality(String txt) {
		addSingleQuality(txt, false);
	}

	private void addSingleQuality(String txt, boolean checked) {
		Button button = new Button(wQualityClient, SWT.CHECK);
		button.setLayoutData(new RowData());
		button.setText(txt);
		button.addSelectionListener(selectionAdapter);
		button.setSelection(checked);
		qualityMap.put(txt, button);
	}

	private void addGoals() {
		List<Goal> goals = client.getAllGoals();
		if (goals == null || goals.isEmpty())
			return;
		goals.stream().forEach(g -> addItemToCombo(wGoal, g.name));
	}

	private void addLocations() {
		List<SemanticLocation> locs = client.getAllLocations();
		if (locs == null || locs.isEmpty())
			return;
		locs.stream().forEach(l -> addItemToCombo(wLocation, l.getSemanticUri()));
	}

	private void addItemToCombo(CCombo box, String item) {
		if (item == null || item.isEmpty())
			return;
		box.add(item);
	}

	private GoalInvoke getGoalInvoke() {
		EObject bo = Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
		if (bo != null)
			return (GoalInvoke) bo;
		return null;
	}

	private void writeToModel() {
		final GoalInvoke goalInvoke = getGoalInvoke();
		if (goalInvoke == null)
			return;
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(goalInvoke);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

			@Override
			protected void doExecute() {
				try {
					goalInvoke.setInvokeGoal(wGoal.getText());
					goalInvoke.setLocation(wLocation.getText());
					goalInvoke.getQualities().clear();
					goalInvoke.getQualities().addAll(aggregateQualities(goalInvoke));
				} catch (ArrayIndexOutOfBoundsException e) {
				}

				featureProvider.layoutIfPossible(new LayoutContext(getSelectedPictogramElement()));
			}
		});
	}

	private List<String> aggregateQualities(GoalInvoke goalInvoke) {
		List<String> qualities = new ArrayList<>();
		qualityMap.values().stream().filter(b -> b.getSelection() && b.getText() != null && !b.getText().isEmpty())
				.forEach(b -> qualities.add(b.getText()));
		return qualities;
	}

	@Override
	public void refresh() {
		super.refresh();
		synchronized (mLock) {
			GoalInvoke goalInvoke = getGoalInvoke();
			if (goalInvoke == null)
				return;
			wGoal.setText(goalInvoke.getInvokeGoal() == null ? "" : goalInvoke.getInvokeGoal());
			setQualities(goalInvoke.getQualities());
			wLocation.setText(goalInvoke.getLocation() == null ? "" : goalInvoke.getLocation());
		}
	}

	private void setQualities(EList<String> quality) {
		if (quality == null)
			return;
		quality.stream().forEach(q -> addQualityCheckboxOrSetValue(q, true));
	}

	// adds a new checkbox or just sets the checked state
	private void addQualityCheckboxOrSetValue(String quality, boolean checked) {
		if (quality == null || quality.isEmpty())
			return;
		Button chkBox = qualityMap.get(quality);
		if (chkBox == null) {
			addSingleQuality(quality, checked);
		} else {
			chkBox.setSelection(checked);
		}
	}
	
	private String getOpenHABHostFromPrefs(){
		return EngineAdapter.getDefault().getPreferenceStore().getString(AdapterConstants.PREF_OPENHAB_HOST);
	}

	// -----------------------------------------------------------------------------------------
	// OH Connection
	// ---------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------
	private void fillDataAsync() {
		Display.getDefault().asyncExec(() -> {
			String host = getOpenHABHostFromPrefs();
			client = new OpenHabRestClient(host);
			//simple check, if we can connect to openhab
			if(client.getOpenHabRestVersion() == null)
				return;
			synchronized (mLock) {
				addGoals();
				addLocations();
				addQualities();
			}
			client.close();
		});
	}

	// -----------------------------------------------------------------------------------------
	// create controls
	// -------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		// container and layout
		Composite container = getWidgetFactory().createFlatFormComposite(parent);
		GridLayout containerLayout = new GridLayout(2, true);
		container.setLayout(containerLayout);

		//
		// goal
		Composite cGoalContainer = getWidgetFactory().createComposite(container);
		cGoalContainer.setLayout(new GridLayout(2, false));
		GridData cGoalData = new GridData(SWT.FILL, SWT.FILL, true, false);
		cGoalContainer.setLayoutData(cGoalData);

		Label lGoal = getWidgetFactory().createLabel(cGoalContainer, LABEL_GOAL);
		lGoal.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		wGoal = getWidgetFactory().createCCombo(cGoalContainer, SWT.NONE);
		wGoal.setText("Fill me with data");
		GridData gridDataGoal = new GridData(SWT.FILL, SWT.FILL, true, false);
		wGoal.setLayoutData(gridDataGoal);
		wGoal.addSelectionListener(selectionAdapter);

		//
		// location
		Composite cLocationContainer = getWidgetFactory().createComposite(container);
		cLocationContainer.setLayout(new GridLayout(2, false));
		GridData cLocationData = new GridData(SWT.FILL, SWT.FILL, true, false);
		cLocationContainer.setLayoutData(cLocationData);

		Label lLocation = getWidgetFactory().createLabel(cLocationContainer, LABEL_LOCATION);
		lLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		wLocation = getWidgetFactory().createCCombo(cLocationContainer, SWT.NONE);
		wLocation.setText("fill me too");
		GridData gridDataLocation = new GridData(SWT.FILL, SWT.FILL, true, false);
		wLocation.setLayoutData(gridDataLocation);
		wLocation.addSelectionListener(selectionAdapter);

		//
		// quality
		wQualitySection = getWidgetFactory().createSection(container,
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE);
		wQualitySection.setText("Quality");
		GridData gridDataQuality = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridDataQuality.horizontalSpan = 2;
		wQualitySection.setLayoutData(gridDataQuality);
		wQualitySection.setLayout(new FillLayout());

		wQualityClient = getWidgetFactory().createComposite(wQualitySection);
		wQualityClient.setLayout(new RowLayout(SWT.HORIZONTAL));
		wQualitySection.setClient(wQualityClient);

		//
		// init data
		fillData();
	}

	private void fillData() {
		fillDataAsync();
	}

}
