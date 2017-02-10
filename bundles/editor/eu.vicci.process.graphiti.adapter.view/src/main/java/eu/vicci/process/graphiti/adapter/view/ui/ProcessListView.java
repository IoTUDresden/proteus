package eu.vicci.process.graphiti.adapter.view.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.part.ViewPart;

import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.graphiti.adapter.view.Activator;

//https://eclipse.org/articles/viewArticle/ViewArticle2.html
//http://www.eclipse.org/articles/article.php?file=Article-Understanding-Layouts/index.html
//https://www.eclipse.org/swt/widgets/
public class ProcessListView extends ViewPart implements IProcessListView {
	private static final String IMAGE_PATH = "media/";
	private Action connectAction, startProcessAction, stopProcessAction, forceConnectAction, showPeersAction;

	private TableViewer lProcesses;
	private TableViewer lInstances;

	private ProcessListViewController controller = new ProcessListViewController(this);

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		// Create the SashForm
		Composite sash = new Composite(parent, SWT.NONE);
		sash.setLayout(new FillLayout());
		sash.setLayoutData(new GridData(GridData.FILL_BOTH));

		final SashForm sashForm = new SashForm(sash, SWT.HORIZONTAL);

		Composite compProcesses = new Composite(sashForm, SWT.NONE);
		GridLayout layoutProcess = new GridLayout(1, false);
		compProcesses.setLayout(layoutProcess);

		Composite compInstances = new Composite(sashForm, SWT.NONE);
		GridLayout layoutInstances = new GridLayout(1, false);
		compInstances.setLayout(layoutInstances);

		Label lblProcesses = new Label(compProcesses, SWT.NONE);
		lblProcesses.setText("Available Processes");
		GridData dataProcesses = new GridData();
		dataProcesses.horizontalAlignment = SWT.FILL;
		dataProcesses.grabExcessHorizontalSpace = true;
		lblProcesses.setLayoutData(dataProcesses);

		Label lblInstances = new Label(compInstances, SWT.NONE);
		lblInstances.setText("Process Instances");
		GridData dataInstances = new GridData();
		dataInstances.horizontalAlignment = SWT.FILL;
		dataInstances.grabExcessHorizontalSpace = true;
		lblInstances.setLayoutData(dataInstances);

		lProcesses = new TableViewer(compProcesses);
		GridData dataLProc = new GridData();
		dataLProc.horizontalAlignment = SWT.FILL;
		dataLProc.grabExcessHorizontalSpace = true;
		dataLProc.verticalAlignment = SWT.FILL;
		dataLProc.grabExcessVerticalSpace = true;
		lProcesses.getTable().setLayoutData(dataLProc);

		lInstances = new TableViewer(compInstances);
		GridData dataLIns = new GridData();
		dataLIns.horizontalAlignment = SWT.FILL;
		dataLIns.grabExcessHorizontalSpace = true;
		dataLIns.verticalAlignment = SWT.FILL;
		dataLIns.grabExcessVerticalSpace = true;
		lInstances.getTable().setLayoutData(dataLIns);

		createListColumns();
		createClickListeners();

		createActions();
		createMenu();
		createToolBar();
		createContextMenu(processesMenuListener, lProcesses);
		createContextMenu(instancesMenuListener, lInstances);

		initListData();

		setHeaderVisibility(true);
		setListsEnabled(false);

		new Thread(() -> {
			controller.viewLoaded();
		}).start();
	}

	@Override
	public void dispose() {
		super.dispose();
		controller.viewDisposed();
	}

	private void createClickListeners() {
		lProcesses.addDoubleClickListener(event -> {
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();
			IProcessInfo pi = (IProcessInfo) selection.getFirstElement();
			controller.showProcessInModelEditor(pi);
		}); // processes double Click

		lInstances.addDoubleClickListener(event -> {
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();
			IProcessInstanceInfo pi = (IProcessInstanceInfo) selection.getFirstElement();
			controller.showProcessInExecutionEditor(pi);
		}); // instances double Click

	}

	@Override
	public void clientIsConnected(boolean connected) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				String pic = connected ? "connect-ok-16.png" : "connect-error-16.png";
				forceConnectAction.setImageDescriptor(getImageDescriptor(pic));
				setListsEnabled(connected);
			}
		});
	}

	private void initListData() {
		lProcesses.setContentProvider(ArrayContentProvider.getInstance());
		lProcesses.setInput(controller.getProcessInfos());

		lInstances.setContentProvider(ArrayContentProvider.getInstance());
		lInstances.setInput(controller.getInstanceInfos());
	}

	private void createListColumns() {
		TableViewerColumn lProcessC1 = new TableViewerColumn(lProcesses, SWT.NONE);
		lProcessC1.getColumn().setWidth(200);
		lProcessC1.getColumn().setText("Process");
		lProcessC1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IProcessInfo) element).getProcessName();
			}
		});

		TableViewerColumn lInstancesC1 = new TableViewerColumn(lInstances, SWT.NONE);
		lInstancesC1.getColumn().setWidth(200);
		lInstancesC1.getColumn().setText("Process Instance");
		lInstancesC1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IProcessInstanceInfo) element).getProcessName();
			}
		});

		TableViewerColumn lInstancesC2 = new TableViewerColumn(lInstances, SWT.NONE);
		lInstancesC2.getColumn().setWidth(120);
		lInstancesC2.getColumn().setText("Instance Number");
		lInstancesC2.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return Integer.toString(((IProcessInstanceInfo) element).getInstanceNumber());
			}
		});

		TableViewerColumn lInstancesC3 = new TableViewerColumn(lInstances, SWT.NONE);
		lInstancesC3.getColumn().setWidth(200);
		lInstancesC3.getColumn().setText("State");
		lInstancesC3.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IProcessInstanceInfo) element).getState().toString();
			}
		});
	}

	@Override
	public void setFocus() {

	}

	private void createMenu() {
		IMenuManager mgr = getViewSite().getActionBars().getMenuManager();
		mgr.add(connectAction);
		mgr.add(showPeersAction);
	}

	private void createToolBar() {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		mgr.add(forceConnectAction);
	}

	private void createActions() {
		forceConnectAction = new Action() {
			@Override
			public void run() {
				controller.tryConnect(getSite().getShell());
			}
		};
		forceConnectAction.setImageDescriptor(getImageDescriptor("connect-error-16.png"));

		connectAction = new Action() {
			@Override
			public void run() {
				controller.showConnectWizard(getSite().getShell());
			}
		};
		connectAction.setText("Connect...");
		connectAction.setImageDescriptor(getImageDescriptor("vicci-logo-small.png"));

		startProcessAction = new Action() {
			@Override
			public void run() {
				startProcessFromProcessList();
			}
		};
		startProcessAction.setText("Start");
		startProcessAction.setImageDescriptor(getImageDescriptor("start-process-small.png"));

		stopProcessAction = new Action() {
			@Override
			public void run() {
				String reason = "Cant stop the Process. Not implemented yet.";
				IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, reason);

				ErrorDialog.openError(getViewShell(), "Error", reason, status);
			}
		};
		stopProcessAction.setText("Stop");
		stopProcessAction.setImageDescriptor(getImageDescriptor("stop-process-small.png"));

		showPeersAction = new Action() {
			@Override
			public void run() {
				controller.showPeers();
			}
		};
		showPeersAction.setText("Show Peers...");
		connectAction.setImageDescriptor(getImageDescriptor("vicci-logo-small.png"));
	}

	public void setListsEnabled(boolean enabled) {
		lProcesses.getTable().setEnabled(enabled);
		lInstances.getTable().setEnabled(enabled);
	}

	private void createContextMenu(IMenuListener listener, TableViewer viewer) {
		// Create menu manager.
		MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(listener);

		// Create menu.
		Menu menu = menuMgr.createContextMenu(viewer.getTable());
		viewer.getTable().setMenu(menu);

		// Register menu for extension.
		// getSite().registerContextMenu(menuMgr, text);
	}

	private void setHeaderVisibility(boolean visible) {
		lProcesses.getTable().setHeaderVisible(visible);
		lInstances.getTable().setHeaderVisible(visible);
	}

	private void startProcessFromProcessList() {
		IStructuredSelection selection = (IStructuredSelection) lProcesses.getSelection();
		IProcessInfo pi = (IProcessInfo) selection.getFirstElement();
		if (pi == null)
			return;
		controller.startProcess(pi.getProcessId());
	}

	private IMenuListener processesMenuListener = new IMenuListener() {
		@Override
		public void menuAboutToShow(IMenuManager manager) {
			manager.add(startProcessAction);
		}
	};

	private IMenuListener instancesMenuListener = new IMenuListener() {
		@Override
		public void menuAboutToShow(IMenuManager manager) {
			manager.add(stopProcessAction);
		}
	};

	/**
	 * Returns the image descriptor with the given relative path.
	 */
	private ImageDescriptor getImageDescriptor(String relativePath) {
		return Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, IMAGE_PATH + relativePath);
	}

	@Override
	public void refreshLists() {
		refreshLists(true);
	}

	@Override
	public void refreshLists(boolean updateLabels) {
		lInstances.getTable().getDisplay().asyncExec(() -> {
			lInstances.refresh(updateLabels);
			lProcesses.refresh(updateLabels);
		});

	}

	@Override
	public Shell getViewShell() {
		return getSite().getShell();
	}
}
