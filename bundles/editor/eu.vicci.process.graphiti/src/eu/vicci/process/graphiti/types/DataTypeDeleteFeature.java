package eu.vicci.process.graphiti.types;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;

public class DataTypeDeleteFeature extends DefaultDeleteFeature {

    public DataTypeDeleteFeature(IFeatureProvider fp) {

        super(fp);
    }

    @Override
    public boolean canDelete(IDeleteContext context) {

        boolean canDelete = super.canDelete(context);

        if (canDelete) {

            Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());
            return (object instanceof DataType);
        }

        return canDelete;
    }

    PictogramElement getProcessPictogram(PictogramElement element) {

        Object object = getBusinessObjectForPictogramElement(element);

        if (object instanceof ComplexType)
            return element;

        else if (element.eContainer() instanceof PictogramElement)
            return getProcessPictogram((PictogramElement) element.eContainer());

        return null;
    }

    /**
     * @see org.eclipse.graphiti.func.IDelete#delete(org.eclipse.graphiti.features
     *      .context.IDeleteContext)
     */
    @Override
    public void delete(IDeleteContext context) {

        Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());

        if (!(object instanceof DataType)) {

            return;
        }

        ComplexType parent = ((DataType) object).getBelongsTo();

        super.delete(context);

        if (parent != null) {
            DataTypeAddFeature.resizeWholeType(getDiagram(),
                    Util.getContainerForBusinessObject(getDiagram(), parent));
        }
    }
}
