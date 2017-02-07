package eu.vicci.process.graphiti.upload;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class UploadToEngineView extends ViewPart {
	private static final int PADDING = 10;

	private Text editIP;
	private Text editPort;
	private Text editName;
	private Button btnUpload;
	private Button btnConnect;
	private static boolean connected = false;

	public UploadToEngineView() {
		super();
	}

	public void setFocus() {
	}

	public void createPartControl(Composite parent) {
		parent.setLayout(new FormLayout());
		
		editName = new Text(parent, SWT.BORDER);
		editIP = new Text(parent, SWT.BORDER);
		editPort = new Text(parent, SWT.BORDER);
		btnConnect = new Button(parent, SWT.NONE);
		btnUpload = new Button(parent, SWT.NONE);

		
		Label lblName = new Label(parent, SWT.NONE);
		FormData fd_lblName = new FormData();
		lblName.setLayoutData(fd_lblName);
		lblName.setText("Name");

		
		editName.setText("testClient");
		fd_lblName.top = new FormAttachment(editName, 3, SWT.TOP);
		fd_lblName.right = new FormAttachment(editName, -6);
		FormData fd_editName = new FormData();
		fd_editName.right = new FormAttachment(100, -PADDING);
		fd_editName.left = new FormAttachment(0, 48);
		fd_editName.top = new FormAttachment(0, PADDING);
		editName.setLayoutData(fd_editName);

		
		editIP.setText("127.0.0.1");
		FormData fd_editIP = new FormData();
		fd_editIP.top = new FormAttachment(editName, 6);
		fd_editIP.left = new FormAttachment(editName, 0, SWT.LEFT);
		editIP.setLayoutData(fd_editIP);

		Label lblIp = new Label(parent, SWT.NONE);
		FormData fd_lblIp = new FormData();
		fd_lblIp.top = new FormAttachment(lblName, 12);
		fd_lblIp.left = new FormAttachment(lblName, 0, SWT.LEFT);
		lblIp.setLayoutData(fd_lblIp);
		lblIp.setText("IP");

		FormData fd_btnConnect = new FormData();
		fd_btnConnect.top = new FormAttachment(editName, 4);
		fd_btnConnect.right = new FormAttachment(editName, 0, SWT.RIGHT);
		btnConnect.setLayoutData(fd_btnConnect);
		btnConnect.setText("Connect");
		btnConnect.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					connected = UploadToEngineController.connect(editName.getText(), editIP.getText(), editPort.getText());
					btnUpload.setEnabled(connected);
				} catch (NoClassDefFoundError err) {
					err.printStackTrace();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		editPort.setText("8081");
		FormData fd_editPort = new FormData();
		fd_editPort.left = new FormAttachment(btnConnect, -38, SWT.LEFT);
		fd_editPort.right = new FormAttachment(btnConnect, -6);
		fd_editPort.top = new FormAttachment(editName, 6);
		editPort.setLayoutData(fd_editPort);

		Label label = new Label(parent, SWT.NONE);
		fd_editIP.right = new FormAttachment(label, -6);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(editName, 9);
		fd_label.right = new FormAttachment(editPort, -6);
		label.setLayoutData(fd_label);
		label.setText(":");

		FormData fd_btnUpload = new FormData();
		fd_btnUpload.left = new FormAttachment(100, -67);
		fd_btnUpload.top = new FormAttachment(btnConnect, 6);
		fd_btnUpload.right = new FormAttachment(100, -PADDING);
		btnUpload.setLayoutData(fd_btnUpload);
		btnUpload.setText("Upload");
		btnUpload.setEnabled(connected);
		btnUpload.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UploadToEngineController.upload();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

	}
}