package eu.vicci.process.adapter.wizard;

import static eu.vicci.process.adapter.AdapterConstants.PREF_HOST;
import static eu.vicci.process.adapter.AdapterConstants.PREF_NAMESPACE;
import static eu.vicci.process.adapter.AdapterConstants.PREF_PORT;
import static eu.vicci.process.adapter.AdapterConstants.PREF_REALM;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import eu.vicci.process.adapter.EngineAdapter;
import eu.vicci.process.adapter.control.ConnectionFieldsControl;

public class ConnectPage extends WizardPage{	
	private ConnectionFieldsControl fields;		

	public ConnectPage(String pageName) {
		super(pageName);
		setTitle("Connect to PROtEUS");
		setDescription("Specify the connection settings, to connect to PROtEUS");
	}

	@Override
	public void createControl(Composite parent) {		
		IPreferenceStore store = EngineAdapter.getDefault().getPreferenceStore();

		fields = new ConnectionFieldsControl(parent);		
		fields.getHost().setText(store.getString(PREF_HOST));
		fields.getPort().setText(store.getString(PREF_PORT));
		fields.getRealm().setText(store.getString(PREF_REALM));
		fields.getNamespace().setText(store.getString(PREF_NAMESPACE));
		setControl(fields);
	}	
	
	public String getHost(){
		return fields.getHost().getText();
	}
	
	public String getPort(){
		return fields.getPort().getText();
	}
	
	public String getRealm(){
		return fields.getRealm().getText();
	}
	
	public String getNamespace(){
		return fields.getNamespace().getText();
	}	
	
}
