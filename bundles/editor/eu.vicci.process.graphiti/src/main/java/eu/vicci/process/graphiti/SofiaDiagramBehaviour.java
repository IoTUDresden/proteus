package eu.vicci.process.graphiti;

import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;

import eu.vicci.process.gesture.GesturePaletteBehavior;

public class SofiaDiagramBehaviour extends DiagramBehavior {

    public SofiaDiagramBehaviour(IDiagramContainerUI diagramContainer) {

        super(diagramContainer);
    }

    @Override
    protected DefaultPersistencyBehavior createPersistencyBehavior() {

        return new SofiaPersistencyBehavior(this);
    }

    protected DefaultPaletteBehavior createPaletteBehaviour() {

        return new GesturePaletteBehavior(this);
    }
}
