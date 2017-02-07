package eu.vicci.process.graphiti.types;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import eu.vicci.process.model.sofia.SetType;

public class SetTypeAddFeature extends DataTypeAddFeature {

    private static final IColorConstant CLASS_BACKGROUND =
            new ColorConstant(120, 200, 120);

    public SetTypeAddFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canAdd(IAddContext context) {

        return context.getNewObject() instanceof SetType;
    }

    @Override
    public PictogramElement add(IAddContext context) {

        return super.makeShape(CLASS_BACKGROUND, context, "Set");
    }

}
