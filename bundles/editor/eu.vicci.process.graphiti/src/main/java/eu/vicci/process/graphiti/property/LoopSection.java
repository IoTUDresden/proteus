package eu.vicci.process.graphiti.property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.Loop;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.StartDataPort;


// FIXME Event Loop Exception happens only on Ubuntu. Seems to be a problem in the native SWT libs :(
//BootLoader constants: OS=linux, ARCH=x86_64, WS=gtk, NL=de_DE
//Framework arguments:  -product org.eclipse.platform.ide
//Command-line arguments:  -product org.eclipse.platform.ide -data /home/andkue/vicci-process-master/ws/../runtime-ProcessEngineEditor -dev file:/home/andkue/vicci-process-master/ws/.metadata/.plugins/org.eclipse.pde.core/Process_Engine_ Editor/dev.properties -os linux -ws gtk -arch x86_64 -consoleLog
//
//!ENTRY org.eclipse.ui 4 0 2016-02-11 17:05:19.569
//!MESSAGE Unhandled event loop exception
//!STACK 0
//java.lang.StackOverflowError
//	at org.eclipse.swt.widgets.Control.isEnabled(Control.java:3629)
//	at org.eclipse.swt.widgets.Control.isEnabled(Control.java:3630)
//	at org.eclipse.swt.widgets.Control.isEnabled(Control.java:3630)
//	at org.eclipse.swt.widgets.Control.isEnabled(Control.java:3630)
//	at org.eclipse.swt.widgets.Control.isEnabled(Control.java:3630)
//	at org.eclipse.swt.widgets.Display.getFocusControl(Display.java:1803)
//	at org.eclipse.swt.widgets.Control.hasFocus(Control.java:299)
//	at org.eclipse.swt.widgets.Control.isFocusControl(Control.java:3657)
//  at org.eclipse.swt.custom.ControlEditor.layout(ControlEditor.java:219)
//	at org.eclipse.swt.custom.TableEditor.layout(TableEditor.java:265)
//	at org.eclipse.swt.custom.TableEditor$1.controlResized(TableEditor.java:98)
//	at org.eclipse.swt.widgets.TypedListener.handleEvent(TypedListener.java:235)
//	at org.eclipse.swt.widgets.EventTable.sendEvent(EventTable.java:84)
//	at org.eclipse.swt.widgets.Display.sendEvent(Display.java:4481)
//	at org.eclipse.swt.widgets.Widget.sendEvent(Widget.java:1329)
//	at org.eclipse.swt.widgets.Widget.sendEvent(Widget.java:1353)
//	at org.eclipse.swt.widgets.Widget.sendEvent(Widget.java:1334)
public class LoopSection extends PropertySectionBase {
	private TabbedPropertySheetWidgetFactory factory;
	private Composite flatFormComposite;
	private Table copyTable;
	private TableViewer copyTableViewer;
	private Group copyGroup;
	private Button addNewDropDownsButton;
	private Map<EndDataPort, StartDataPort> portsToCopy = new HashMap<EndDataPort, StartDataPort>();
	private Map<Object, CCombo> combos = new HashMap<Object, CCombo>();
	private Map<Object, Button> buttons = new HashMap<Object, Button>();
	private List<Port> startDataPorts = new ArrayList<Port>();
	private List<Port> endDataPorts = new ArrayList<Port>();

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		factory = getWidgetFactory();
		flatFormComposite = factory.createFlatFormComposite(parent);
		copyGroup = factory.createGroup(flatFormComposite, "Values to Copy on each step");
		FillLayout layout = new FillLayout(CENTER_SPACE);
		layout.marginHeight = 20;
		layout.marginWidth = 20;
		layout.spacing = 10;
		copyGroup.setLayout(layout);

		createTable();
		createAddButton();

		copyGroup.pack();
		copyGroup.update();
	}

	@Override
	public void refresh() {
		super.refresh();
		Loop loop = getLoopElement();
		startDataPorts.clear();
		endDataPorts.clear();
		portsToCopy.clear();
		if (loop == null)
			return;
		portsToCopy.putAll(loop.getPortsCopyToStartsport().map());
		for (Port port : loop.getPorts())
			if (port instanceof StartDataPort)
				startDataPorts.add(port);

		for (Port port : loop.getPorts())
			if (port instanceof EndDataPort)
				if (!portsToCopy.containsKey(port))
					endDataPorts.add(port);

		copyTableViewer.setInput(portsToCopy.entrySet());
	}

	private void createAddButton() {
		addNewDropDownsButton = factory.createButton(copyGroup, "add copy", SWT.PUSH);
		addNewDropDownsButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				onAddButtonClick(e);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				onAddButtonClick(e);
			}
		});
		addNewDropDownsButton.pack();
		addNewDropDownsButton.update();
	}

	private void onAddButtonClick(SelectionEvent e) {
		if (!portsToCopy.containsKey(null))
			portsToCopy.put(null, null);
		copyTableViewer.refresh();
	}

	private void createTable() {
		copyTableViewer = new TableViewer(copyGroup);
		copyTable = copyTableViewer.getTable();
		TableColumn left = new TableColumn(copyTable, SWT.CENTER);
		TableColumn center = new TableColumn(copyTable, SWT.CENTER);
		TableColumn right = new TableColumn(copyTable, SWT.CENTER);
		left.setWidth(500);
		center.setWidth(500);
		right.setWidth(100);
		left.setText("from endport");
		center.setText("to startport");
		right.setText("remove");
		copyTable.setHeaderVisible(true);
		copyTable.pack();

		TableViewerColumn leftTVC = new TableViewerColumn(copyTableViewer, left);
		leftTVC.setLabelProvider(new CustomComboLabelProvider());
		TableViewerColumn centerTVC = new TableViewerColumn(copyTableViewer, center);
		centerTVC.setLabelProvider(new CustomComboLabelProvider());
		TableViewerColumn rightTVC = new TableViewerColumn(copyTableViewer, right);
		rightTVC.setLabelProvider(new CustomButtonLabelProvider());
		copyTableViewer.setContentProvider(ArrayContentProvider.getInstance());
		copyTableViewer.refresh();
	}

	private void onRemoveButtonClick(SelectionEvent e) {
		if (e.widget == null)
			return;
		Entry<?, ?> entry = (Entry<?, ?>) e.widget.getData();
		Object key = entry.getKey();
		portsToCopy.remove(key);

		for (Button b : buttons.values())
			b.dispose();
		buttons.clear();
		for (CCombo c : combos.values())
			c.dispose();
		combos.clear();

		Loop loop = getLoopElement();
		if (loop != null) {
			writeToModel(loop);
			refresh();
		}
		copyTableViewer.refresh();
	}

	private void writeToModel(final Loop loop) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(loop);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

			@Override
			protected void doExecute() {
				try {
					loop.getPortsCopyToStartsport().clear();
					loop.getPortsCopyToStartsport().map().putAll(portsToCopy);
				} catch (ArrayIndexOutOfBoundsException e) {
				}

				featureProvider.layoutIfPossible(new LayoutContext(getSelectedPictogramElement()));
			}
		});
	}

	private void onComboFocusLostOrWidgetSelected(TypedEvent e, int column) {
		CCombo combo = (CCombo) e.widget;
		final Loop loop = getLoopElement();
		if (loop == null)
			return;
		if (combo.getSelectionIndex() == -1)
			return;

		EndDataPort key = (EndDataPort) combo.getData();

		if (column == 0) {
			StartDataPort old = null;
			EndDataPort port = (EndDataPort) endDataPorts.get(combo.getSelectionIndex());
			if (key == null) {
				old = portsToCopy.remove(null);
				key = port;
				combo.setData(key);
			}
			portsToCopy.put(key, old);
		} else {
			StartDataPort port = (StartDataPort) startDataPorts.get(combo.getSelectionIndex());
			portsToCopy.put(key, port);
		}
		if (key != null && portsToCopy.get(key) != null) {
			writeToModel(loop);
			refresh();
		}

		copyTableViewer.refresh();
	}

	private Loop getLoopElement() {
		EObject bo = Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
		if (bo != null)
			return (Loop) bo;
		return null;
	}

	private class CustomComboLabelProvider extends ColumnLabelProvider {

		@Override
		public void update(ViewerCell cell) {
			TableItem item = (TableItem) cell.getItem();
			Entry<?, ?> portEntry = (Entry<?, ?>) item.getData();
			Port key = (Port) portEntry.getKey();
			Port value = (Port) portEntry.getValue();

			CCombo combo;
			if (combos.containsKey(cell))
				combo = combos.get(cell);
			else
				combo = createCombo(cell, item, cell.getColumnIndex());

			if (cell.getColumnIndex() == 0)
				setComboTextAndValue(key, combo, cell.getColumnIndex());
			else if (cell.getColumnIndex() == 1)
				setComboTextAndValue(value, combo, cell.getColumnIndex());

			combo.setData(key);
			if (combo.getText().equals("select port!"))
				combo.setEnabled(true);
			else
				combo.setEnabled(false);

			TableEditor editor = new TableEditor(item.getParent());
			editor.grabHorizontal = true;
			editor.grabVertical = true;
			editor.setEditor(combo, item, cell.getColumnIndex());
			editor.layout();
		}

		private void setComboTextAndValue(Port port, CCombo combo, int column) {
			combo.removeAll();
			List<Port> toAdd = null;
			if (column == 0)
				toAdd = endDataPorts;
			else
				toAdd = startDataPorts;

			for (Port p : toAdd)
				combo.add(p.getName());

			if (port == null || port.getName() == null || port.getName().isEmpty())
				combo.setText("select port!");
			else
				combo.setText(port.getName());
		}

		private CCombo createCombo(ViewerCell cell, TableItem item, final int column) {
			CCombo combo = factory.createCCombo((Composite) cell.getViewerRow().getControl());
			combo.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					onComboFocusLostOrWidgetSelected(e, column);
				}

				@Override
				public void focusGained(FocusEvent e) {
				}
			});
			combos.put(cell, combo);
			return combo;
		}
	}

	private class CustomButtonLabelProvider extends ColumnLabelProvider {
		@Override
		public void update(ViewerCell cell) {
			TableItem item = (TableItem) cell.getItem();
			Button button;

			if (buttons.containsKey(cell))
				button = buttons.get(cell);
			else
				button = createButton(cell, item);
			button.setData(item.getData());
			TableEditor editor = new TableEditor(item.getParent());
			editor.grabHorizontal = true;
			editor.grabVertical = true;
			editor.setEditor(button, item, cell.getColumnIndex());
			editor.layout();
		}

		private Button createButton(ViewerCell cell, TableItem item) {
			Button button = new Button((Composite) cell.getViewerRow().getControl(), SWT.NONE);
			button.setText("Remove");
			button.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					onRemoveButtonClick(e);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					onRemoveButtonClick(e);
				}
			});
			buttons.put(cell, button);
			return button;
		}
	}
}
