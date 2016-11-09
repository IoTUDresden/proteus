package eu.vicci.process.adapter.preferences;

import static eu.vicci.process.adapter.AdapterConstants.DEFAULT_PREF_HOST;
import static eu.vicci.process.adapter.AdapterConstants.DEFAULT_PREF_NAMESPACE;
import static eu.vicci.process.adapter.AdapterConstants.DEFAULT_PREF_PORT;
import static eu.vicci.process.adapter.AdapterConstants.DEFAULT_PREF_REALM;
import static eu.vicci.process.adapter.AdapterConstants.PREF_HOST;
import static eu.vicci.process.adapter.AdapterConstants.PREF_NAMESPACE;
import static eu.vicci.process.adapter.AdapterConstants.PREF_PORT;
import static eu.vicci.process.adapter.AdapterConstants.PREF_REALM;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import eu.vicci.process.adapter.EngineAdapter;

public class ProteusPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		// the pref store uses a scoped pref store - instance scope with node = plugin id is used
		IPreferenceStore store = EngineAdapter.getDefault().getPreferenceStore();
		
		store.setDefault(PREF_HOST, DEFAULT_PREF_HOST);	
		store.setDefault(PREF_PORT, DEFAULT_PREF_PORT);	
		store.setDefault(PREF_REALM, DEFAULT_PREF_REALM);	
		store.setDefault(PREF_NAMESPACE, DEFAULT_PREF_NAMESPACE);	
	}

}
