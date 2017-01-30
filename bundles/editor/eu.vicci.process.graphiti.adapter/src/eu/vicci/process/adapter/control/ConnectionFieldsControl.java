package eu.vicci.process.adapter.control;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ConnectionFieldsControl extends Composite {
	private Text host, port, realm, namespace;
	private Composite container;
	
	
	public ConnectionFieldsControl(Composite parent) {
		super(parent, SWT.NONE);
		createControls();
	}
	
	private void createControls(){
		this.setLayout(new FillLayout());
		container = new Composite(this, SWT.NONE);
		
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		
		Label lblHost = new Label(container, SWT.NONE);
		lblHost.setText("Host");
		
		host = new Text(container, SWT.BORDER);
		host.setLayoutData(createTextGridData());
		
		Label lblPort = new Label(container, SWT.NONE);
		lblPort.setText("Port");
		
		port = new Text(container, SWT.BORDER);
		port.setLayoutData(createTextGridData());
		
		Label lblRealm = new Label(container, SWT.NONE);
		lblRealm.setText("Realm");	
		
		realm = new Text(container, SWT.BORDER);
		realm.setLayoutData(createTextGridData());
		
		Label lblNS = new Label(container, SWT.NONE);
		lblNS.setText("Namespace");	
		
		namespace = new Text(container, SWT.BORDER);
		namespace.setLayoutData(createTextGridData());
	}
	
	public Composite getContainerControl(){
		return container;
	}

	public Text getHost() {
		return host;
	}

	public Text getPort() {
		return port;
	}

	public Text getRealm() {
		return realm;
	}

	public Text getNamespace() {
		return namespace;
	}
	
	private static GridData createTextGridData(){
		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		return data;
	}
}
