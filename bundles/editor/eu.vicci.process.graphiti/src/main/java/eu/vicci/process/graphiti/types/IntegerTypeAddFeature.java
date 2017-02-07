package eu.vicci.process.graphiti.types;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import eu.vicci.process.model.sofia.IntegerType;

public class IntegerTypeAddFeature extends DataTypeAddFeature {

    private static final IColorConstant CLASS_BACKGROUND =
            new ColorConstant(230, 160, 160);

    public IntegerTypeAddFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean canAdd(IAddContext context) {

        return context.getNewObject() instanceof IntegerType;
    }

    @Override
    public PictogramElement add(IAddContext context) {
        return super.makeShape(CLASS_BACKGROUND, context, "Integer");
    }

}
