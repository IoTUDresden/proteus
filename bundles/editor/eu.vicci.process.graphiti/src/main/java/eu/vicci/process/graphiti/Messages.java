package eu.vicci.process.graphiti;

import org.eclipse.osgi.util.NLS;

/**
 * Localized messages.
 * 
 * @author andre
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "eu.vicci.process.graphiti.messages"; //$NON-NLS-1$

	// Wizard Stuff
	public static String WIZARD_WINDOW_TITLE;
	public static String PAGE_NAME_DIAGRAM_TYPE;
	public static String PAGE_NAME_DIAGRAM_NAME;
	public static String PAGE_NAME_DESC;
	public static String PAGE_NAME_TITLE;
	public static String PAGE_TEMPLATE_DESC;
	public static String PAGE_TEMPLATE_TITLE;
	
	public static String DiagramNameWizardPage_Message;
	public static String DiagramNameWizardPage_Label;

	public static String CreateDiagramWizard_NoProjectFoundError;
	public static String CreateDiagramWizard_NoProjectFoundErrorTitle;
	public static String CreateDiagramWizard_OpeningEditorError;
	public static String CreateDiagramWizard_ErrorOccuredTitle;

	public static String DiagramTypeWizardPage_DiagramTypeField;
	
	//Address
	public static String PROTEUS_GH_PAGE;
	
	//help
	public static String ERROR_OPENING_HELP;


	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
