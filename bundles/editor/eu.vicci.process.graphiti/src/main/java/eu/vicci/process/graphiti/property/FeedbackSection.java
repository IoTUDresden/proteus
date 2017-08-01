package eu.vicci.process.graphiti.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.CpsStep;

public class FeedbackSection extends PropertySectionBase {
	/**
	 * Templates must always contain one more than compensationData!
	 * Position 0 is for no value on selection
	 */	
	private static final String[] templateNames = {"Custom", "LightValue-Template", "ProcessCompensation-Template"};	
	
	private static final int GOAL_HEIGHT = 160;
	private static final int TEMPLATE_WIDTH_PERCENTAGE = 40;
	
	private CCombo cTemplate;
	private Text cGoal;
	private Text cContext;
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		createContext(composite);
		createTemplate(composite);
		createGoal(composite);	
	}
	
	private void createTemplate(Composite parent){
		cTemplate = getWidgetFactory().createCCombo(parent);
		cTemplate.setEditable(true);
		cTemplate.addSelectionListener(selectionListener);
		
		for (int i = 0; i < templateNames.length; i++)
			cTemplate.add(templateNames[i]);			
		
		FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(TEMPLATE_WIDTH_PERCENTAGE, 0);
		data.top = new FormAttachment(cContext, VSPACE);
		cTemplate.setLayoutData(data);

		CLabel valueLabel = getWidgetFactory().createCLabel(parent, "Templates(FBS):"); //$NON-NLS-1$
		FormData labelData = new FormData();
		labelData.left = new FormAttachment(0, 0);
		labelData.right = new FormAttachment(cTemplate, -HSPACE);
		labelData.top = new FormAttachment(cTemplate, 0, SWT.CENTER);
		valueLabel.setLayoutData(labelData);		
	}
	
	private void createGoal(Composite parent){
		cGoal = getWidgetFactory().createText(parent, "", SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
		cGoal.addModifyListener(simpleModifyListener);

		FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(cTemplate, VSPACE);
		data.bottom = new FormAttachment(0, GOAL_HEIGHT);
		cGoal.setLayoutData(data);

		CLabel valueLabel = getWidgetFactory().createCLabel(parent, "Goal(FBS):"); //$NON-NLS-1$
		FormData labelData = new FormData();
		labelData.left = new FormAttachment(0, 0);
		labelData.right = new FormAttachment(cGoal, -HSPACE);
		labelData.top = new FormAttachment(cGoal, 0, SWT.CENTER);
		valueLabel.setLayoutData(labelData);		
	}
	
	private void createContext(Composite parent) {
		cContext = getWidgetFactory().createText(parent, "", SWT.SINGLE);
		cContext.addModifyListener(simpleModifyListener);
		
		FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(TEMPLATE_WIDTH_PERCENTAGE, 0);
		data.top = new FormAttachment(0, VSPACE);
		cContext.setLayoutData(data);

		CLabel valueLabel = getWidgetFactory().createCLabel(parent, "Context(FBS)"); //$NON-NLS-1$
		FormData labelData = new FormData();
		labelData.left = new FormAttachment(0, 0);
		labelData.right = new FormAttachment(cContext, -HSPACE);
		labelData.top = new FormAttachment(cContext, 0, SWT.CENTER);
		valueLabel.setLayoutData(labelData);			
	}
	
	private SelectionListener selectionListener = new SelectionListener() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			int index = cTemplate.getSelectionIndex();
			if(index == 0) return;
			cGoal.setText(compensationData[index-1]);
			writeToModel();			
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e){}
	};
	
	private CpsStep getCpsStepElement(){
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());
		if (bo != null)
			return (CpsStep) bo;
		return null;
	}
	
	private ModifyListener simpleModifyListener = new ModifyListener() {		
		@Override
		public void modifyText(ModifyEvent e) {
			writeToModel();			
		}
	};
	
	
	@Override
	public void refresh() {
		super.refresh();
		CpsStep processStep = getCpsStepElement();
		if (processStep == null)
			return;
		String sGoal = processStep.getGoal() == null ? "" : processStep.getGoal();
		String sContext = processStep.getContext() == null ? "" : processStep.getContext();
		
		//removing and adding the listener should prevent, that the write to model is called after refreshing
		cContext.removeModifyListener(simpleModifyListener);
		cGoal.removeModifyListener(simpleModifyListener);
		
		cContext.setText(sContext);
		cGoal.setText(sGoal);		
		
		cContext.addModifyListener(simpleModifyListener);
		cGoal.addModifyListener(simpleModifyListener);
	}
	
	private void writeToModel() {
		final CpsStep processStep = getCpsStepElement(); 		
		if (processStep == null)
			return;
		
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(processStep);		
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

			@Override
			protected void doExecute() {
				try {
					processStep.setGoal(cGoal.getText());		
					processStep.setContext(cContext.getText());
				} catch (ArrayIndexOutOfBoundsException e) {
				}

				featureProvider.layoutIfPossible(new LayoutContext(getSelectedPictogramElement()));
			}
		});
	}
	
	private static final String tLight = ""
		+ "{\n"
		+ "	   \"name\":\"enough light for cooking2\",\n"
		+ "	   \"objectives\":[\n"  
		+ "	      {  \n"
		+ "	         \"name\":\"kitchen light intensity > 700 lux within two seconds\",\n"
		+ "	         \"satisfiedExpression\":\"#lightIntensity > 700\",\n"
		+ "	         \"compensateExpression\":\"#objective.created.isBefore(#now.minusSeconds(5))\",\n"
		+ "	         \"testNodeIdExpression\":\"#stateId\",\n"
		+ "	         \"contextExpressions\":[  \n"
		+ "	            \"MATCH (thing)-[:type]->(sensor {name: 'LightSensor'})\",\n"
		+ "	            \"MATCH (thing)-[:isIn]->(room {name: 'Kitchen_Mueller'})\",\n"
		+ "	            \"MATCH (thing)-[:hasState]->(state:LightIntensityState)\",\n"
		+ "	            \"MATCH (state)-[:hasStateValue]->(value)\",\n"
		+ "	            \"WHERE toFloat(value.realStateValue) > 0\",\n"
		+ "	            \"RETURN avg(toFloat(value.realStateValue)) AS lightIntensity, head(collect(id(state))) AS stateId\"\n"
		+ "	         ]\n"
		+ "	      }\n"
		+ "    ]\n"
		+ "}";
	
//	MATCH (n:NeoProcess {processId:"_Fq5jsMi5EeSKccvjc0DMJA_Instance_1"}) RETURN n.state
	private static final String tProcess = ""
			+ "{\n"
			+ "	   \"name\":\"process executed\",\n"
			+ "	   \"objectives\":[\n"  
			+ "	      {  \n"
			+ "	         \"name\":\"process executed within 5 seconds\",\n"
			+ "	         \"satisfiedExpression\":\"#state == 'executed'\",\n"
			+ "	         \"compensateExpression\":\"#objective.created.isBefore(#now.minusSeconds(5))\",\n"
			+ "	         \"testNodeIdExpression\":\"#state\",\n"
			+ "	         \"contextExpressions\":[  \n"
			+ "             \"MATCH (n:NeoProcess {processId:'$piid'})\",\n"
			+ "             \"RETURN n.state AS state\"\n"
			+ "	         ]\n"
			+ "	      }\n"
			+ "    ]\n"
			+ "}";
	
	private static final String[] compensationData = {tLight, tProcess};

}
