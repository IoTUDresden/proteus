package eu.vicci.process.graphiti.property;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.AttributeMap;
import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.OpenHabSemanticAskInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticSelectInvoke;

public class OpenHabSemanticInvokeSection extends PropertySectionBase {
	private static final String DEFAULT_BASE_URI = "not needed anymore (field only for backwards comp.)";
	private static final String[] COMMANDS = new String[] { "ON", "OFF", "TOGGLE", "UP", "DOWN" };
	private static final String DEFAULT_PREFIX = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>\n" 
			+ "PREFIX dogont:<http://elite.polito.it/ontologies/dogont.owl#>\n"
			+ "PREFIX instance:<http://openhab-semantic/0.1/instance#>\n"
			+ "PREFIX vicci:<http://openhab-semantic/0.1/dogont-vicci-extension#>\n"
			+ "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#>\n\n";

	private static final String DEFAULT_SELECT_STMT = DEFAULT_PREFIX + "SELECT *\n" 
			+ "WHERE {\n"
			+ "?subject rdfs:subClassOf ?object .\n" 
			+ "}";
	
	private static final String DEFAULT_ASK_STMT = DEFAULT_PREFIX + "ASK\n{...}";

	private static final String DEFAULT_COMMAND_STMT = DEFAULT_PREFIX + "SELECT ?func\nWHERE {\n"
			+ "?subject dogont:hasFunctionality ?func.\n}";

	// height and width for the query text, width for the uri part and the type part
	private static final int QUERY_TEXT_WIDTH = 900;
	private static final int QUERY_TEXT_HEIGHT = 500;
	private static final int URI_WIDTH = 1000;
	private static final int TYPE_WIDTH = 125;

	// Widgets
	private Text baseUriText;
	private Text queryText;
	private CCombo commandCombo;
	private Button radioSelect;
	private Button radioAsk;
	private Button radioCommand;
	private Button checkWithLatest;

	// Temp vars for restoring query
	private String oldSelectStmt = null;
	private String oldAskStmt = null;
	private String oldCommandStmt = null;
	private Button oldSelectedButton = null;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.fill = true;
		layout.wrap = false;
		layout.justify = false;
		parent.setLayout(layout);

		// uri
		createUriPart(factory, parent);

		// Types
		Composite queryAndCommandAndTypeComposite = factory.createFlatFormComposite(parent);
		queryAndCommandAndTypeComposite.setLayout(new GridLayout(2, false));
		RowData rowData = new RowData();
		queryAndCommandAndTypeComposite.setLayoutData(rowData);
		
		Composite typeAndWithLatestComposite = factory.createFlatFormComposite(queryAndCommandAndTypeComposite);
		typeAndWithLatestComposite.setLayout(new RowLayout(SWT.VERTICAL));
		GridData typeGridData = new GridData(SWT.BEGINNING, SWT.TOP, true, true);
		typeGridData.widthHint = TYPE_WIDTH;
		typeAndWithLatestComposite.setLayoutData(typeGridData);
		
		createTypePart(factory, typeAndWithLatestComposite);
		createWithLatestPart(factory, typeAndWithLatestComposite);

		// Command, Query
		Composite queryAndCommandComposite = factory.createComposite(queryAndCommandAndTypeComposite,
				SWT.NONE);
		RowLayout queryAndCommandLayout = new RowLayout(SWT.VERTICAL);
		queryAndCommandLayout.fill = true;
		queryAndCommandComposite.setLayout(queryAndCommandLayout);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		queryAndCommandComposite.setLayoutData(gridData);

		createCommandPart(factory, queryAndCommandComposite);
		createQueryPart(factory, queryAndCommandComposite);
	}

	@Override
	public void refresh() {
		super.refresh();
		OpenHabSemanticInvoke openhab = getOpenHabElement();
		if (openhab == null)
			return;
		setServerBaseAddress(openhab);
		setTargetTypeAndQuery(openhab);
		setCommand(openhab);
		checkWithLatest.setSelection(openhab.isWithLatest());
	}

	private void setCommand(OpenHabSemanticInvoke openhab) {

	}

	//the targettype is used for refactoring. it should not be used anymore
	private void setTargetTypeAndQuery(OpenHabSemanticInvoke openhab) {
		
		if(openhab instanceof OpenHabSemanticSelectInvoke){
			radioSelect.setSelection(true);
			resetQuery(openhab.getQuery(), DEFAULT_SELECT_STMT);
			oldSelectedButton = radioSelect;
			commandCombo.setEnabled(false);			
		}
		else if (openhab instanceof OpenHabSemanticAskInvoke) {
			radioAsk.setSelection(true);
			resetQuery(openhab.getQuery(), DEFAULT_ASK_STMT);
			oldSelectedButton = radioAsk;
			commandCombo.setEnabled(false);			
		}
		else if (openhab instanceof OpenHabSemanticCommandInvoke) {
			radioCommand.setSelection(true);
			resetQuery(openhab.getQuery(), DEFAULT_COMMAND_STMT);
			oldSelectedButton = radioCommand;
			commandCombo.setEnabled(true);			
		}
	}

	private void setServerBaseAddress(OpenHabSemanticInvoke openhab) {
		if (openhab.getServerBaseAddress() == null || openhab.getServerBaseAddress().isEmpty())
			baseUriText.setText(DEFAULT_BASE_URI);
		else
			baseUriText.setText(openhab.getServerBaseAddress());
	}
	
	private void createWithLatestPart(TabbedPropertySheetWidgetFactory factory, Composite parent){
		checkWithLatest = factory.createButton(parent, "with Latest", SWT.CHECK);
		checkWithLatest.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				writeToModel();
			}
		});
		
	}

	//FIXME not used anymore
	private void createTypePart(TabbedPropertySheetWidgetFactory factory, Composite parent) {
		Group group = factory.createGroup(parent, "Type");
		group.setLayout(new FillLayout(SWT.VERTICAL));
		radioSelect = factory.createButton(group, "Select", SWT.RADIO);
		radioAsk = factory.createButton(group, "Ask", SWT.RADIO);
		radioCommand = factory.createButton(group, "Command", SWT.RADIO);
		radioSelect.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onRadioSelectSelection(event);
			}
		});
		radioAsk.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onRadioAskSelection(event);
			}
		});
		radioCommand.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				onRadioCommandSelection(event);
			}
		});
		group.setVisible(false);
	}

	private void createCommandPart(TabbedPropertySheetWidgetFactory factory, Composite parent) {
		Composite commandComposite = factory.createFlatFormComposite(parent);
		RowData rowData = new RowData();
		commandComposite.setLayoutData(rowData);
		Label commandLabel = factory.createLabel(commandComposite, "Command:");
		commandCombo = factory.createCCombo(commandComposite, SWT.READ_ONLY);
		commandCombo.setItems(COMMANDS);
		commandCombo.select(0);
		commandCombo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToModel();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				writeToModel();
			}
		});
		
		//FIXME the command is not used anymore on this point
		commandLabel.setVisible(false);
		commandCombo.setVisible(false);
		// combo
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		formData.right = new FormAttachment(100, 0);
		formData.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		commandCombo.setLayoutData(formData);
		// label
		formData = new FormData();
		formData.left = new FormAttachment(0, 0);
		formData.right = new FormAttachment(commandCombo, ITabbedPropertyConstants.HSPACE);
		formData.top = new FormAttachment(commandCombo, 0, SWT.CENTER);
		commandLabel.setLayoutData(formData);
	}

	private void createQueryPart(TabbedPropertySheetWidgetFactory factory, Composite parent) {
		Composite queryComposite = factory.createFlatFormComposite(parent);
		queryComposite.setLayout(new FillLayout());
		RowData rowData = new RowData();
		rowData.height = QUERY_TEXT_HEIGHT;
		rowData.width = QUERY_TEXT_WIDTH;
		queryComposite.setLayoutData(rowData);
		queryText = factory.createText(queryComposite, "", SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
		queryText.addFocusListener(new FocusListener() {
			private String oldValue = "";

			@Override
			public void focusLost(FocusEvent e) {
				if (!oldValue.equals(queryText.getText()))
					writeToModel();
			}

			@Override
			public void focusGained(FocusEvent e) {
				oldValue = queryText.getText();

			}
		});
	}

	private void createUriPart(TabbedPropertySheetWidgetFactory factory, Composite parent) {
		Composite uriComposite = factory.createFlatFormComposite(parent);
		RowData data = new RowData();
		data.width = URI_WIDTH;
		uriComposite.setLayoutData(data);
		Label uriLabel = factory.createLabel(uriComposite, "Base Uri: ");
		baseUriText = factory.createText(uriComposite, DEFAULT_BASE_URI);
		baseUriText.addFocusListener(new FocusListener() {
			private String oldValue = "";

			@Override
			public void focusLost(FocusEvent e) {
				if (!oldValue.equals(baseUriText.getText()))
					writeToModel();
			}

			@Override
			public void focusGained(FocusEvent e) {
				oldValue = baseUriText.getText();
			}
		});
		// Uri
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		formData.right = new FormAttachment(100, 0);
		formData.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		baseUriText.setLayoutData(formData);
		// label
		formData = new FormData();
		formData.left = new FormAttachment(0, 0);
		formData.right = new FormAttachment(baseUriText, -ITabbedPropertyConstants.HSPACE);
		formData.top = new FormAttachment(baseUriText, 0, SWT.CENTER);
		uriLabel.setLayoutData(formData);
	}

	private void onRadioCommandSelection(Event event) {
		setOldQueryToTemp();
		resetQuery(oldCommandStmt, DEFAULT_COMMAND_STMT);
		oldSelectedButton = radioCommand;
		commandCombo.setEnabled(true);
		writeToModel();
	}

	private void onRadioAskSelection(Event event) {
		setOldQueryToTemp();
		resetQuery(oldAskStmt, DEFAULT_ASK_STMT);
		oldSelectedButton = radioAsk;
		commandCombo.setEnabled(false);
		writeToModel();
	}

	private void onRadioSelectSelection(Event event) {
		setOldQueryToTemp();
		resetQuery(oldSelectStmt, DEFAULT_SELECT_STMT);
		oldSelectedButton = radioSelect;
		commandCombo.setEnabled(false);
		writeToModel();
	}

	private void resetQuery(String oldStmt, String defaultStmt) {
		if (oldStmt == null || oldStmt.isEmpty())
			queryText.setText(defaultStmt);
		else
			queryText.setText(oldStmt);
	}

	private void setOldQueryToTemp() {
		if (radioAsk.equals(oldSelectedButton))
			oldAskStmt = queryText.getText();
		else if (radioCommand.equals(oldSelectedButton))
			oldCommandStmt = queryText.getText();
		else if (radioSelect.equals(oldSelectedButton))
			oldSelectStmt = queryText.getText();
	}

	private OpenHabSemanticInvoke getOpenHabElement() {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());
		if (bo != null)
			return (OpenHabSemanticInvoke) bo;
		return null;
	}

	private void writeToModel() {
		final OpenHabSemanticInvoke openhab = getOpenHabElement(); 		
		if (openhab == null)
			return;
		
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(openhab);
        final Map<String, org.eclipse.graphiti.mm.algorithms.Text> map =
                AttributeMap.instance().getObjectMap(openhab);
		
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

			@Override
			protected void doExecute() {
				try {
					openhab.setQuery(queryText.getText());
					openhab.setServerBaseAddress(baseUriText.getText());
					openhab.setWithLatest(checkWithLatest.getSelection());
                    if (map != null) {
                        org.eclipse.graphiti.mm.algorithms.Text text = map.get("baseuri");
                        if (text != null)
                            text.setValue("baseuri: " + baseUriText.getText());
                    }
					
				} catch (ArrayIndexOutOfBoundsException e) {
				}

				featureProvider.layoutIfPossible(new LayoutContext(getSelectedPictogramElement()));
			}
		});
	}

}
