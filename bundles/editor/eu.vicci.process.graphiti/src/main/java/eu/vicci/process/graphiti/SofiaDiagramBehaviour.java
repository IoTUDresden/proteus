package eu.vicci.process.graphiti;

import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;

public class SofiaDiagramBehaviour extends DiagramBehavior {

    public SofiaDiagramBehaviour(IDiagramContainerUI diagramContainer) {

        super(diagramContainer);
    }

    @Override
    protected DefaultPersistencyBehavior createPersistencyBehavior() {

        return new SofiaPersistencyBehavior(this);
    }

    protected DefaultPaletteBehavior createPaletteBehaviour() {
    	//FIXME update or drop support for gestures
    	return new DefaultPaletteBehavior(this);
//        return new GesturePaletteBehavior(this);
    }
}
