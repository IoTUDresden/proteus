package eu.vicci.process.graphiti.execution.ui;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ProcessVariableView extends ViewPart {
	private TreeViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
	    Composite sash = new Composite(parent, SWT.NONE);
	    sash.setLayout(new FillLayout());
	    sash.setLayoutData(new GridData(GridData.FILL_BOTH));
	    
	    final SashForm sashForm = new SashForm(sash, SWT.VERTICAL);
	    
	    Composite viewerComposite = new Composite(sashForm, SWT.NONE);
	    GridLayout layoutProcess = new GridLayout(1, false);
	    viewerComposite.setLayout(layoutProcess);
	    
	    Composite stringViewComposite = new Composite(sashForm, SWT.NONE);
	    GridLayout layoutInstances = new GridLayout(1, false);
	    stringViewComposite.setLayout(layoutInstances);	
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
