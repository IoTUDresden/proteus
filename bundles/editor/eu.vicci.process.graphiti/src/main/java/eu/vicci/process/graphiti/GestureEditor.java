package eu.vicci.process.graphiti;

import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

//FIXME update or drop support
//extend from gesture editor!
public class GestureEditor extends DiagramEditor {

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
    	throw new UnsupportedOperationException("dropped support for gestures for now, cause xmlpull is too old");
//        return new SofiaDiagramBehaviour(this);
    }
}
