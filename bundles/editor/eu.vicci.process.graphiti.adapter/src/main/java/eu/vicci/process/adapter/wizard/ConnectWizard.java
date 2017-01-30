package eu.vicci.process.adapter.wizard;

import static eu.vicci.process.adapter.AdapterConstants.PREF_HOST;
import static eu.vicci.process.adapter.AdapterConstants.PREF_NAMESPACE;
import static eu.vicci.process.adapter.AdapterConstants.PREF_PORT;
import static eu.vicci.process.adapter.AdapterConstants.PREF_REALM;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.Wizard;

import eu.vicci.process.adapter.EngineAdapter;

public class ConnectWizard extends Wizard {	
	private ConnectPage connectPage = new ConnectPage("Connect");

	
	public ConnectWizard() {
		super();
		setHelpAvailable(false);
		setNeedsProgressMonitor(false);
	}
	
	@Override
	public void addPages() {
		addPage(connectPage);
	}
	
	
	@Override
	public boolean performFinish() {
		IPreferenceStore store = EngineAdapter.getDefault().getPreferenceStore();		
		store.setValue(PREF_HOST, connectPage.getHost());
		store.setValue(PREF_PORT, connectPage.getPort());
		store.setValue(PREF_REALM, connectPage.getRealm());
		store.setValue(PREF_NAMESPACE, connectPage.getNamespace());		
		return true;
	}


}
