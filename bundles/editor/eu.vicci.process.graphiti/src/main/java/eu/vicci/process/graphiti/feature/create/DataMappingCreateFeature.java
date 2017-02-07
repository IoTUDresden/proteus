package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

import eu.vicci.process.model.sofia.CollectionType;
import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.SofiaFactory;

/**
 */
public class DataMappingCreateFeature extends AbstractCreateConnectionFeature {

    /**
     * Constructor for a transition create feature.
     * 
     * @param fp
     *            the feature provider for which the feature is created
     */
    public DataMappingCreateFeature(IFeatureProvider fp) {

        super(fp, "DataMapping", "Create a DataMapping");
    }

    /**
     * Retrieve the task linked with the given anchor's parent.
     * 
     * @param anchor
     *            an anchor for the source or target of the new connection
     * @return the corresponding task, or {@code null} if there is none
     */
    private DataType getState(Anchor anchor) {

        if (anchor != null) {
            Object object = getBusinessObjectForPictogramElement(anchor
                    .getParent());

            if (object instanceof DataType)
                return (DataType) object;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canStartConnection(ICreateConnectionContext context) {

        DataType type = getState(context.getSourceAnchor());
        return (type != null);
    }

    boolean typeMapped(DataType type) {

        if (type == null)
            return false;

        if (type.getMappings().size() != 0)
            return true;

        return typeMapped(type.getBelongsTo());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCreate(ICreateConnectionContext context) {
        Object source = getState(context.getSourceAnchor());
        Object target = getState(context.getTargetAnchor());

        if ((source instanceof DataType) && (target instanceof DataType)
                && (source != target) && source.getClass().equals(
                target.getClass())) {
        	return true;
        	//Creating a mapping from a collection to another type of the collection item type (1 out of N selection)
        } else if ((source instanceof DataType) && (target instanceof DataType)
                && (source != target)) {
        	if (source instanceof CollectionType) {
        		CollectionType ct = (CollectionType)source;
        		if (ct.getCollectionItemType().getClass().equals(target.getClass())) {
        			return true;	
        		}
        		return false;	
        	}
        	return false; 
        } else {
        	return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connection create(ICreateConnectionContext context) {

        DataType source = getState(context.getSourceAnchor());
        DataType target = getState(context.getTargetAnchor());

        if (source == null || target == null)
            throw new IllegalStateException(
                    "Cannot retrieve the source or target.");

        DataMapping mapping = SofiaFactory.eINSTANCE.createDataMapping();
        mapping.setId(EcoreUtil.generateUUID());
        mapping.setName(source.getName() + " to " + target.getName());
        
        getDiagram().eResource().getContents().add(mapping);
        mapping.setSource(source);
        mapping.setTarget(target);
        
        AddConnectionContext addContext = new AddConnectionContext(
                context.getSourceAnchor(), context.getTargetAnchor());
        addContext.setNewObject(mapping);

        return (Connection) getFeatureProvider().addIfPossible(addContext);
    }
}