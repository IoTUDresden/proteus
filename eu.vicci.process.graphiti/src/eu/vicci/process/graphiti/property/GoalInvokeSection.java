package eu.vicci.process.graphiti.property;

import java.util.HashMap;
import java.util.Map;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.GoalInvoke;

public class GoalInvokeSection extends PropertySectionBase {
	private static final String REST_GOALS = "/rest/goal/goals";
	private static final String REST_QUALITIES = "/rest/goal/qualities";
	private static final String REST_LOCATIONS = "/rest/semantic/extended/locations";	
	
	private static final String LABEL_GOAL = "Invoke Goal: ";
	private static final String LABEL_LOCATION = "Location: ";
	
	private CCombo wGoal;
	private Section wQualitySection;
	private CCombo wLocation;
	private Composite wQualityClient;
	
	private Map<String, Button> qualityMap = new HashMap<>();
	
	
	private void addQualities(){
		addSingleQuality("Quality_1");		
		addSingleQuality("Quality_2");	
		addSingleQuality("Quality_3");	
		addSingleQuality("Quality_4");	
	}
	
	private void addSingleQuality(String txt){
		Button button = new Button(wQualityClient, SWT.CHECK);
		button.setLayoutData(new RowData());
		button.setText(txt);
		button.addSelectionListener(selectionAdapter);
		qualityMap.put(txt, button);
	}
	
	private void addGoals(){
		wGoal.setItems(new String[]{"Goal_1", "Goal_2"});		
	}
	
	private void addLocations(){
		wLocation.setItems(new String[]{"Location_1", "Location_2"});
	}
	
	private GoalInvoke getOpenHabElement() {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());
		if (bo != null)
			return (GoalInvoke) bo;
		return null;
	}
	
	private void writeToModel() {
		final GoalInvoke goalInvoke = getOpenHabElement();
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
				} catch (ArrayIndexOutOfBoundsException e) {
				}

				featureProvider.layoutIfPossible(new LayoutContext(getSelectedPictogramElement()));
			}
		});
	}
	
	
	private SelectionAdapter selectionAdapter = new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			writeToModel();			
		};
	};	
	
	// -----------------------------------------------------------------------------------------
	// OH Connection ---------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------
	
	
	
	
	
	// -----------------------------------------------------------------------------------------
	// create controls -------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		//container and layout
		Composite container = getWidgetFactory().createFlatFormComposite(parent);
		GridLayout containerLayout = new GridLayout(2, true);
		container.setLayout(containerLayout);
		
		//
		//goal
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
		//location		
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
		//quality
		wQualitySection = getWidgetFactory().createSection(container, Section.DESCRIPTION|Section.TITLE_BAR|
				  Section.TWISTIE);
		wQualitySection.setText("Quality");
		GridData gridDataQuality = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridDataQuality.horizontalSpan = 2;
		wQualitySection.setLayoutData(gridDataQuality);	
		wQualitySection.setLayout(new FillLayout());
		
		wQualityClient = getWidgetFactory().createComposite(wQualitySection);
		wQualityClient.setLayout(new RowLayout(SWT.HORIZONTAL));
		wQualitySection.setClient(wQualityClient);
		
		//
		//init data
		fillData();	
	}
	
	private void fillData(){
		addGoals();
		addLocations();
		addQualities();			
	}



}
