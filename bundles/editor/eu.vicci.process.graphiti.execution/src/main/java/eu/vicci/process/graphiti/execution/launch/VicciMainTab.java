package eu.vicci.process.graphiti.execution.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import eu.vicci.process.graphiti.execution.util.StringResource;

public class VicciMainTab extends AbstractLaunchConfigurationTab{
	public static final String TAB_NAME = "Main Runtime Configuration";
	public static final String ID = "eu.vicci.process.graphiti.execution.launch.vicciMainTab";
	
	public static final String CFG_FILE = "File";
	public static final String CFG_PROJECT = "Project";
	public static final String CFG_RUN_IN_LOOP = "RunInLoop";
	
	public static final String DEFAULT_FILE  = "";
	public static final String DEFAULT_PROJECT  = "";
	public static final boolean DEFAULT_RUN_IN_LOOP = false;
	
	//widgets
	private Text fFileText;
	private Text fProjectText;
	private Button fRunInLoop;
	
	private Label projTextLabel;
	private Label fileTextLabel;
	
	
	/**
	 * Modify listener that simply updates the owning launch configuration dialog.
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		public void modifyText(ModifyEvent evt) {
			scheduleUpdateJob();
		}
	};	

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		comp.setLayout(new FormLayout());
		
		createProjectTextComponent(comp);
		createFileTextComponent(comp);
		createRunInLoopComponent(comp);
		//add more controls here
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {		
		configuration.setContainer(null);
		configuration.setAttribute(CFG_FILE,  DEFAULT_FILE);
		configuration.setAttribute(CFG_PROJECT, DEFAULT_PROJECT);
		configuration.setAttribute(CFG_RUN_IN_LOOP, DEFAULT_RUN_IN_LOOP);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		fProjectText.setText(getProjectFromConfig(configuration));
		fFileText.setText(getFileFromConfig(configuration));
		fRunInLoop.setSelection(getRunInLoopFromConfig(configuration));
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(CFG_FILE, fFileText.getText());
		configuration.setAttribute(CFG_PROJECT, fProjectText.getText());
		configuration.setAttribute(CFG_RUN_IN_LOOP, fRunInLoop.getSelection());
	}

	@Override
	public String getName() {
		return TAB_NAME;
	}	
	
	@Override
	public String getId() {
		return ID;
	}	
	
	public static String getStringValueFromConfig(String attribute, String defaultValue, ILaunchConfiguration configuration) {
		String config = defaultValue;
		try {
			config = configuration.getAttribute(attribute, defaultValue);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return config;		
	}
	
	public static boolean getBooleanValueFromConfig(String attribute, boolean defaultValue, ILaunchConfiguration configuration){
		boolean config = defaultValue;
		try {
			config = configuration.getAttribute(attribute, defaultValue);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return config;		
	}
	
	public static String getFileFromConfig(ILaunchConfiguration configuration){
		return getStringValueFromConfig(CFG_FILE, DEFAULT_FILE, configuration);
	}
	
	public static String getProjectFromConfig(ILaunchConfiguration configuration){
		return getStringValueFromConfig(CFG_PROJECT, DEFAULT_PROJECT, configuration);
	}
	
	public static boolean getRunInLoopFromConfig(ILaunchConfiguration configuration){
		return getBooleanValueFromConfig(CFG_RUN_IN_LOOP, DEFAULT_RUN_IN_LOOP, configuration);
	}
	
	private void createFileTextComponent(Composite parent){
		fFileText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		fileTextLabel = new Label(parent, SWT.CENTER);
		fileTextLabel.setText("File");
		
		FormData fd_fileTextLabel = new FormData();
		fd_fileTextLabel.top = new FormAttachment(projTextLabel, 16);
		fd_fileTextLabel.left = new FormAttachment(0, 10);
		fileTextLabel.setLayoutData(fd_fileTextLabel);			
		//text data
		FormData formData2 = new FormData();
		formData2.left = new FormAttachment(fileTextLabel, 73);
		formData2.top = new FormAttachment(fileTextLabel, 0, SWT.TOP);
		formData2.right = new FormAttachment(100, -10);
		fFileText.setLayoutData(formData2);	
		fFileText.addModifyListener(fBasicModifyListener);
	}
	
	private void createProjectTextComponent(Composite parent){
		fProjectText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		projTextLabel = new Label(parent, SWT.CENTER);
		projTextLabel.setText("Project");
		
		FormData fd_projTextLabel = new FormData();
		fd_projTextLabel.top = new FormAttachment(0, 10);
		fd_projTextLabel.left = new FormAttachment(0, 10);
		projTextLabel.setLayoutData(fd_projTextLabel);			
		//text data
		FormData formData2 = new FormData();
		formData2.left = new FormAttachment(projTextLabel, 54);
		formData2.top = new FormAttachment(projTextLabel, 0, SWT.TOP);
		formData2.right = new FormAttachment(100, -10);
		fProjectText.setLayoutData(formData2);	
		fProjectText.addModifyListener(fBasicModifyListener);
	}
	
	private void createRunInLoopComponent(Composite parent) {
		fRunInLoop = new Button(parent, SWT.CHECK);
		fRunInLoop.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				scheduleUpdateJob();
			}
		});
		Label runInLoopLabel = new Label(parent, SWT.CENTER);
		runInLoopLabel.setText("Run in Loop");
		
		FormData formData1 = new FormData();
		formData1.top = new FormAttachment(fileTextLabel, 16);
		formData1.left = new FormAttachment(0, 10);
		runInLoopLabel.setLayoutData(formData1);			
		//text data
		FormData formData2 = new FormData();
		formData2.top = new FormAttachment(runInLoopLabel, 0, SWT.TOP);
		formData2.left = new FormAttachment(runInLoopLabel, 10);
		formData2.right = new FormAttachment(100, -10);
		fRunInLoop.setLayoutData(formData2);	
		
		runInLoopLabel.setToolTipText(StringResource.TT_RUN_IN_LOOP);
		fRunInLoop.setToolTipText(StringResource.TT_RUN_IN_LOOP);
	}
}
