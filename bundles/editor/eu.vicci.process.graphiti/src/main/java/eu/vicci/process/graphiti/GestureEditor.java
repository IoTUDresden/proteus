package eu.vicci.process.graphiti;

import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

import eu.vicci.process.gesture.Editor;

public class GestureEditor extends Editor {

	/**
	 * The ID of the {@link DiagramEditor} as it is registered with the
	 * org.eclipse.ui.editors extension point.
	 */
	public static final String GESTURE_EDITOR_ID = "eu.vicci.process.graphiti.gestureEditor";

    public GestureEditor() {

        super();
    }

    @Override
    protected DiagramBehavior createDiagramBehavior() {

        return new SofiaDiagramBehaviour(this);
    }
}
