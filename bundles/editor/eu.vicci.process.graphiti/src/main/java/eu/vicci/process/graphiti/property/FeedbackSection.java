package eu.vicci.process.graphiti.property;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class FeedbackSection extends PropertySectionBase {
	/**
	 * Templates must always contain one more than compensationData!
	 * Position 0 is for no value on selection
	 */	
	private static final String[] templateNames = {"Custom", "LightValue-Template", "ProcessCompensation-Template"};	
	private static final String[] compensationData = {"###lighttemplate", "###processcompensationtemplate"};
	
	private static final int GOAL_HEIGHT = 100;
	private static final int TEMPLATE_WIDTH_PERCENTAGE = 40;
	
	private CCombo cTemplate;
	private Text cGoal;
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
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
		data.top = new FormAttachment(0, VSPACE);
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
	
	private void writeToModel(){
		//TODO implement		
	}

}
