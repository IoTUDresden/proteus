package eu.vicci.process.adapter.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import static eu.vicci.process.adapter.AdapterConstants.*;

import eu.vicci.process.adapter.EngineAdapter;

public class ProteusPreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public ProteusPreferencesPage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(EngineAdapter.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		addField(new StringFieldEditor(PREF_HOST, "Host", getFieldEditorParent()));
		addField(new StringFieldEditor(PREF_PORT, "Port", getFieldEditorParent()));
		addField(new StringFieldEditor(PREF_REALM, "Realm", getFieldEditorParent()));
		addField(new StringFieldEditor(PREF_NAMESPACE, "Namespace", getFieldEditorParent()));

		Label label = new Label(getFieldEditorParent(), SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1));

		addField(new StringFieldEditor(PREF_OPENHAB_HOST, "OpenHAB Host", getFieldEditorParent()));
	}

}
