package eu.vicci.process.graphiti.execution.interpreter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.AbstractStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.util.IColorConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.graphiti.execution.ui.ExecuteProcessEditor;
import eu.vicci.process.graphiti.execution.util.StringResource;
import eu.vicci.process.model.sofia.Identifiable;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.State;

public abstract class AbstractProcessInterpreter extends Job {
	protected static final Logger logger = LoggerFactory.getLogger(AbstractProcessInterpreter.class);
	private static final String name = "Process Runner";

	protected final ExecuteProcessEditor editor;	
	private final Map<IColorConstant, Color> colors = new HashMap<IColorConstant, Color>(); 
	
	// maps the ids of process contents to their shapes
	protected Map<String, Shape> objectsMap = Collections.synchronizedMap(new HashMap<String, Shape>());
	
	private Process process;

	public AbstractProcessInterpreter(ExecuteProcessEditor editor) {
		super(name);
		this.editor = editor;
	}
	
	public void init(){
		logger.debug("initializing process runner");
		setColors();
		process = getEditorProcess();
		createMapping();
	}
	
	protected void changeBorderColor(final Shape shape, final Color color) {
		CommandStack stack = editor.getEditingDomain().getCommandStack();
		stack.execute(new RecordingCommand(editor.getEditingDomain()) {
			@Override
			protected void doExecute() {
				GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();		
				if (ga instanceof AbstractStyle)
					((AbstractStyle) ga).setForeground(color);
			}
		});
	}

	protected Color getStateColor(State state) {
		switch (state) {
		case INACTIVE:
			 return colors.get(IColorConstant.BLACK);
		case EXECUTING:
			 return colors.get(IColorConstant.YELLOW);			
		case ACTIVE:
			 return colors.get(IColorConstant.BLUE);
		case EXECUTED:
			return colors.get(IColorConstant.GREEN);
		case DEACTIVATED:
			return colors.get(IColorConstant.ORANGE);
		default:
			return colors.get(IColorConstant.RED);
		}
	}
	
	protected Diagram getDiagram(){
		return editor.getDiagramTypeProvider().getDiagram();
	}
	
	//must get the colors within a transaction. Otherwise illegalStateException is thrown
	private void setColor(final IColorConstant colorConstant){
		CommandStack stack = editor.getEditingDomain().getCommandStack();	
		stack.execute(new RecordingCommand(editor.getEditingDomain()) {
			@Override
			protected void doExecute() {
				Color color = Graphiti.getGaService().manageColor(getDiagram(), colorConstant);
				colors.put(colorConstant, color);				
			}
		});		
	}
	
	private void setColors(){
		setColor(IColorConstant.BLACK);
		setColor(IColorConstant.YELLOW);		
		setColor(IColorConstant.BLUE);		
		setColor(IColorConstant.GREEN);
		setColor(IColorConstant.ORANGE);		
		setColor(IColorConstant.RED);				
	}
	
	private void createMapping() {
		Diagram diagram = editor.getDiagramTypeProvider().getDiagram();
		List<Shape> shapes = diagram.getChildren();
		if (shapes.size() != 1) {
			logger.error(StringResource.ERR_ROOT_PROCESS_NOT_FOUND);
			return;
		}
		addShapeContentToMap(shapes.get(0));
	}

	private void addShapeContentToMap(Shape shape) {
		if (shape instanceof ContainerShape)
			for (Shape child : ((ContainerShape) shape).getChildren())
				addShapeContentToMap(child);
		PictogramElement element = shape.getLink().getPictogramElement();
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(element);

		if (bo == null)
			logger.error("can not get the business object for '{}'", shape.toString());

		String uid = null;
		if (bo instanceof Identifiable)
			uid = ((Identifiable) bo).getId();
		else
			logger.warn("'{}' is no Identifiable", bo.toString());

		if (uid != null)
			objectsMap.put(uid, shape);
	}
	
	private Process getEditorProcess() {
		EList<Shape> children = getDiagram().getChildren();
		Process process = (Process) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement((PictogramElement) children.get(0));
		return process;
	}
	
	/**
	 * Gets the root process from the diagram. The process should only be
	 * accessed in a reading state. Write operations should be done within a
	 * EditingDomain.
	 * 
	 * @return
	 */
	public Process getVicciProcess() {
		return process;
	}

}
