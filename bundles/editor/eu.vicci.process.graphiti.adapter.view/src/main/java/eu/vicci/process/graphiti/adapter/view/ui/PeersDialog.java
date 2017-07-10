package eu.vicci.process.graphiti.adapter.view.ui;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.distribution.core.PeerProfile;

public class PeersDialog extends Dialog {
	private final IProcessEngineClient client;
	private TableViewer tableViewer;
	
	private Composite dialogComposite;

	protected PeersDialog(Shell parentShell, IProcessEngineClient client) {
		super(parentShell);
		this.client = client;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		dialogComposite = parent.getParent();
		
		boolean viewEnabled = client != null && client.isConnected();
		
		tableViewer = new TableViewer(container, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		tableViewer.getTable().setEnabled(viewEnabled);
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.getTable().setHeaderVisible(true);
		
		createColumns();
		
		if(viewEnabled)
			loadPeers();			
		
		return container;
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Connected Peers");
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Ok", true);
	}
	
	private void createColumns(){
		TableViewerColumn cIP = new TableViewerColumn(tableViewer, SWT.NONE);
		cIP.getColumn().setWidth(200);
		cIP.getColumn().setText("IP");
		cIP.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				return ((PeerProfile)element).getIp();
			}
		});
		
		TableViewerColumn cName = new TableViewerColumn(tableViewer, SWT.NONE);
		cName.getColumn().setWidth(200);
		cName.getColumn().setText("Hostname");
		cName.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				return ((PeerProfile)element).getHostName();
			}
		});
		
		TableViewerColumn cID = new TableViewerColumn(tableViewer, SWT.NONE);
		cID.getColumn().setWidth(200);
		cID.getColumn().setText("ID");
		cID.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				return ((PeerProfile)element).getPeerId();
			}
		});	
	}
	
	private void loadPeers(){
		Job loadingPeers = new Job("Load Peers") {			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				List<PeerProfile> peers = client.getRegisteredPeers();
				updateUI(peers);
				return Status.OK_STATUS;
			}
		};	
		loadingPeers.schedule();
	}
	
	
	
	private void updateUI(final List<PeerProfile> peers){
		tableViewer.getTable().getDisplay().asyncExec(() -> {
			tableViewer.setInput(peers);
			tableViewer.refresh();
			dialogComposite.pack();
		});		
	}

}
