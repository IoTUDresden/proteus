package eu.vicci.process.graphiti;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Font;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Or;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.Transition;

public class Util {

	/**
	 * Opens an simple input dialog with OK and Cancel buttons.
	 * 
	 * @param dialogTitle
	 *            the dialog title, or <code>null</code> if none
	 * @param dialogMessage
	 *            the dialog message, or <code>null</code> if none
	 * @param initialValue
	 *            the initial input value, or <code>null</code> if none
	 *            (equivalent to the empty string)
	 * @return the string
	 */
	public static String askString(String dialogTitle, String dialogMessage, String initialValue) {

		String ret = null;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		InputDialog inputDialog = new InputDialog(shell, dialogTitle, dialogMessage, initialValue, null);

		int retDialog = inputDialog.open();

		if (retDialog == Window.OK)
			ret = inputDialog.getValue();

		return ret;
	}

	public static void messageDialog(String title, String message) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MessageDialog dialog = new MessageDialog(shell, title, null, message, 0, new String[] { "Ok" }, 0);
		dialog.open();
	}

	public static void resizeContainerOnPortAdd(IAddContext context, PictogramElement element) {
		// should be called after adding a port

		EObject target = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getTargetContainer());

		int initialHeight = context.getTargetContainer().getGraphicsAlgorithm().getHeight();
		int width = context.getTargetContainer().getGraphicsAlgorithm().getWidth();
		int height = Math.max(context.getTargetContainer().getGraphicsAlgorithm().getHeight(), element.getGraphicsAlgorithm().getY()
				+ (int) (element.getGraphicsAlgorithm().getHeight() * 1.5));

		Graphiti.getGaService().setSize(context.getTargetContainer().getGraphicsAlgorithm(), width, height);

		if (target instanceof If || target instanceof Or) {
			resizeAndIfOr(context.getTargetContainer(), initialHeight, height);
		}
	}

	public static void resizeAndIfOr(ContainerShape targetContainer, float initialHeight, float height) {
		Graphiti.getGaService().setSize(targetContainer.getGraphicsAlgorithm(), targetContainer.getGraphicsAlgorithm().getWidth(), (int) height);
		float yScale = targetContainer.getGraphicsAlgorithm().getHeight() / initialHeight;
		System.out.println(yScale);
		GraphicsAlgorithm ga = targetContainer.getGraphicsAlgorithm();

		if (ga instanceof Polyline) {
			Polyline polygon = (Polyline) ga;
			for (Point point : polygon.getPoints()) {
				point.setY((int) (point.getY() * yScale));
			}
		}
		for (Shape child : targetContainer.getChildren()) {

			ga = child.getGraphicsAlgorithm();

			int targetHeight = targetContainer.getGraphicsAlgorithm().getHeight();
			if (ga instanceof Ellipse) {
				Ellipse ellipse = (Ellipse) ga;
				ellipse.setY(targetHeight / 2 - ellipse.getHeight() / 2);
			}
			if (ga instanceof Text) {
				Text text = (Text) ga;
				text.setY(targetHeight / 2 - text.getHeight() / 2);
			}
			if (ga instanceof Polyline) {
				Polyline polyLine = (Polyline) ga;
				for (Point point : polyLine.getPoints()) {
					point.setY((int) (point.getY() * yScale));
				}
			}
		}

	}

	public static void redrawConnectionDecorator(EObject bo, Diagram diagram) {

		// delete Connection text start
		LinkedList<EObject> objs = new LinkedList<EObject>();
		objs.push(bo);
		IGaService gaService = Graphiti.getGaService();
		if (Graphiti.getLinkService().getPictogramElements(diagram, objs, false).size() == 0)
			return;
		Connection connection = (Connection) Graphiti.getLinkService().getPictogramElements(diagram, objs, false).get(0);

		for (int i = 0; i < connection.getConnectionDecorators().size(); i++)
			if (connection.getConnectionDecorators().get(i).getGraphicsAlgorithm() instanceof Text)
				// deleting is done here
				Graphiti.getPeService().deletePictogramElement(connection.getConnectionDecorators().get(i));

		// delete Connection text end

		// draw new Connection text
		ConnectionDecorator textDecorator = Graphiti.getPeCreateService().createConnectionDecorator(connection, true, 0.5, true);
		/* org.eclipse.graphiti.mm.algorithms.Text text = */
		if (bo instanceof Transition)
			gaService.createDefaultText(diagram, textDecorator, ((Transition) bo).getId());
		if (bo instanceof DataMapping) {
			gaService.createDefaultText(diagram, textDecorator, ((DataMapping) bo).getName());
		}
	}

	/**
	 * shortens a string to a limited amount of chars and puts "..." at the end
	 * of it, if it was shortened
	 * 
	 * @param s
	 *            the {@link String} to be shortened
	 * @return s if s was already short enough, otherwise a shortened version
	 *         with "..." at the end
	 */
	public static String shortenString(String s) {
		int charCount = 7;
		if (s.length() > charCount + 3)
			return s.substring(0, charCount) + "...";
		return s;
	}

	public static Image loadImage(String path, boolean inJar) {

		Image newImage = null;
		try {
			if (inJar)
				newImage = new Image(null, Util.class.getClassLoader().getResourceAsStream(path));
			else
				newImage = new Image(null, path);
		} catch (SWTException ex) {
			System.out.println("Couldn't find " + path);
			ex.printStackTrace();
		}

		return newImage;
	}

	public static int getTextWidth(Diagram diagram, String text, Font font) {

		return getTextWidth(diagram, text, font.isItalic(), font.isBold());
	}

	public static int getTextWidth(Diagram diagram, String text, boolean italic, boolean bold) {

		if (text == null)
			return 0;

		String useText = text.replace("null", "");

		IGaService gaService = Graphiti.getGaService();
		Font font = gaService.manageDefaultFont(diagram, italic, bold);
		int result = GraphitiUi.getUiLayoutService().calculateTextSize(useText, font).getWidth();
		return result;
	}

	/**
	 * warning: This method just gives the first container shape. Due to a
	 * possibly faulty link-service, the ContainerShape might not be the correct
	 * one
	 * 
	 * @param diagram
	 * @param bo
	 * @return
	 */
	public static ContainerShape getContainerForBusinessObject(Diagram diagram, Object bo) {
		List<PictogramElement> list = Graphiti.getLinkService().getPictogramElements(diagram, (EObject) bo);

		for (PictogramElement element : list) {
			if (element instanceof ContainerShape)
				return (ContainerShape) element;
		}
		return null;
	}

	public static ArrayList<ContainerShape> getContainersForBusinessObject(Diagram diagram, Object bo) {

		List<PictogramElement> list = Graphiti.getLinkService().getPictogramElements(diagram, (EObject) bo);
		ArrayList<ContainerShape> result = new ArrayList<ContainerShape>();

		for (PictogramElement element : list) {
			if (element instanceof ContainerShape)
				result.add((ContainerShape) element);
		}
		return result;
	}

	public static List<DataType> getAllReferableDataTypes(Diagram diagram, PictogramElement pe) {
		DataType root = (DataType) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		while (root.getBelongsTo() != null) {
			root = (DataType) root.eContainer();
		}
		try {
			PictogramElement rootPe = getContainerForBusinessObject(diagram, root).getGraphicsAlgorithm().getPictogramElement();
			PictogramElement parent = Graphiti.getPeService().getPictogramElementParent(rootPe);

			if (parent != null) {
				EObject parentObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(parent);
				if (parentObject instanceof Process) {
					return getAllTypesAccessible(parent);
				}
			}
		} catch (NullPointerException e) {
		}
		return new ArrayList<DataType>();

	}

	public static List<DataType> getAllTypesAccessible(PictogramElement pe) {
		ArrayList<DataType> result = new ArrayList<DataType>();
		// ProcessStep parent = null;

		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

		// if (bo instanceof DataPort){
		// parent = ((DataPort)bo).getProcessStep();
		//
		// }

		if (bo instanceof Diagram) {
			return result;
		}

		if (bo instanceof Process) {
			Process process = (Process) bo;
			EList<DataType> currentList = process.getDataTypeDefinitions();
			for (DataType dt : currentList) {
				if (dt instanceof DataType) {

					result.add((DataType) dt);
				}
			}
		}

		if (pe != null) {
			PictogramElement parentPe = Graphiti.getPeService().getPictogramElementParent(pe);
			if (parentPe != null) {
				result.addAll(getAllTypesAccessible(parentPe));
			}
		}

		return result;
	}
	
	public static List<Process> getAllProcessesAccessible(PictogramElement pe) {
		ArrayList<Process> result = new ArrayList<Process>();

		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

		if (bo instanceof Diagram) {
			return result;
		}

		if (bo instanceof Process) {
			Process process = (Process) bo;
			EList<ProcessStep> currentList = process.getSubSteps();
			for (ProcessStep ps : currentList) {
				if (ps instanceof Process) {

					result.add((Process) ps);
				}
			}
		}

		if (pe != null) {
			PictogramElement parentPe = Graphiti.getPeService().getPictogramElementParent(pe);
			if (parentPe != null) {
				result.addAll(getAllProcessesAccessible(parentPe));
			}
		}

		return result;
	}

	public static String getOperator(Comparator comparator) {
		String operator = "";
		switch (comparator.getValue()) {

		case Comparator.GREATER_THAN_VALUE:
			operator = ">";
			break;

		case Comparator.DISTINCT_VALUE:
			operator = "!=";
			break;

		case Comparator.EQUAL_VALUE:
			operator = "equals";
			break;

		case Comparator.GREATER_THAN_OR_EQUAL_VALUE:
			operator = ">=";
			break;

		case Comparator.IDENTIC_VALUE:
			operator = "==";
			break;

		case Comparator.SMALLER_THAN_OR_EQUAL_VALUE:
			operator = "<=";
			break;

		case Comparator.SMALLER_THAN_VALUE:
			operator = "<";
			break;

		}

		return operator;
	}

}
