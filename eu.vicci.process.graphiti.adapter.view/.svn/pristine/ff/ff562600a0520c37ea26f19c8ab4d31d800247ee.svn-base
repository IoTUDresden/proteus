package eu.vicci.process.graphiti.adapter.view.ui;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Shell;

public interface IProcessListView {

	/**
	 * set all stuff to a state, where the client is connected or disconnected
	 * (e.g. enable lists if connected)
	 * 
	 * @param connected
	 *            true if connected
	 */
	void clientIsConnected(boolean connected);
	
	/**
	 * forces the table views to refresh, e.g. if the data has changed.
	 */
	void refreshLists();
	
	/**
	 * calls the method {@link TableViewer#refresh(boolean)} for the underlying TableViewers
	 * @param updateLabels
	 */
	void refreshLists(boolean updateLabels);
	
	Shell getViewShell();

}
