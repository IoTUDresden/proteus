package eu.vicci.process.graphiti;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveConnectionDecoratorFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveConnectionDecoratorContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import eu.vicci.process.graphiti.feature.DirectEditFeature;
import eu.vicci.process.graphiti.feature.PortDeleteFeature;
import eu.vicci.process.graphiti.feature.ProcessLayoutFeature;
import eu.vicci.process.graphiti.feature.ProcessMoveShapeFeature;
import eu.vicci.process.graphiti.feature.add.AndAddFeature;
import eu.vicci.process.graphiti.feature.add.DataDuplicationStepAddFeature;
import eu.vicci.process.graphiti.feature.add.DataMappingAddFeature;
import eu.vicci.process.graphiti.feature.add.DataMappingStepAddFeature;
import eu.vicci.process.graphiti.feature.add.EndControlPortAddFeature;
import eu.vicci.process.graphiti.feature.add.EndDataPortAddFeature;
import eu.vicci.process.graphiti.feature.add.EscalationPortAddFeature;
import eu.vicci.process.graphiti.feature.add.FalseTransitionAddFeature;
import eu.vicci.process.graphiti.feature.add.ForLoopAddFeature;
import eu.vicci.process.graphiti.feature.add.GoalInvokeAddFeature;
import eu.vicci.process.graphiti.feature.add.HumanTaskAddFeature;
import eu.vicci.process.graphiti.feature.add.IfAddFeature;
import eu.vicci.process.graphiti.feature.add.LoadClassStepAddFeature;
import eu.vicci.process.graphiti.feature.add.OSGiInvokeAddFeature;
import eu.vicci.process.graphiti.feature.add.OpenHabSemanticInvokeAddFeature;
import eu.vicci.process.graphiti.feature.add.OrAddFeature;
import eu.vicci.process.graphiti.feature.add.ProcessAddFeature;
import eu.vicci.process.graphiti.feature.add.ProcessSlotAddFeature;
import eu.vicci.process.graphiti.feature.add.RESTInvokeAddFeature;
import eu.vicci.process.graphiti.feature.add.ROSInvokeAddFeature;
import eu.vicci.process.graphiti.feature.add.RepeatLoopAddFeature;
import eu.vicci.process.graphiti.feature.add.SOAPInvokeAddFeature;
import eu.vicci.process.graphiti.feature.add.SeMiWaInvokeAddFeature;
import eu.vicci.process.graphiti.feature.add.SeMiWaRequestAddFeature;
import eu.vicci.process.graphiti.feature.add.StartControlPortAddFeature;
import eu.vicci.process.graphiti.feature.add.StartDataPortAddFeature;
import eu.vicci.process.graphiti.feature.add.TransitionAddFeature;
import eu.vicci.process.graphiti.feature.add.TriggeredEventAddFeature;
import eu.vicci.process.graphiti.feature.add.TrueTransitionAddFeature;
import eu.vicci.process.graphiti.feature.add.WhileLoopAddFeature;
import eu.vicci.process.graphiti.feature.add.XMLRPCInvokeAddFeature;
import eu.vicci.process.graphiti.feature.create.AndCreateFeature;
import eu.vicci.process.graphiti.feature.create.DataDuplicationStepCreateFeature;
import eu.vicci.process.graphiti.feature.create.DataMappingCreateFeature;
import eu.vicci.process.graphiti.feature.create.DataMappingStepCreateFeature;
import eu.vicci.process.graphiti.feature.create.EndControlPortCreateFeature;
import eu.vicci.process.graphiti.feature.create.EndDataPortCreateFeature;
import eu.vicci.process.graphiti.feature.create.EscalationPortCreateFeature;
import eu.vicci.process.graphiti.feature.create.FalseTransitionCreateFeature;
import eu.vicci.process.graphiti.feature.create.ForLoopCreateFeature;
import eu.vicci.process.graphiti.feature.create.GoalInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.HumanTaskCreateFeature;
import eu.vicci.process.graphiti.feature.create.IfCreateFeature;
import eu.vicci.process.graphiti.feature.create.LoadClassStepCreateFeature;
import eu.vicci.process.graphiti.feature.create.OSGiInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.OpenHabSemanticAskInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.OpenHabSemanticCommandInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.OpenHabSemanticSelectInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.OrCreateFeature;
import eu.vicci.process.graphiti.feature.create.ProcessCreateFeature;
import eu.vicci.process.graphiti.feature.create.ProcessSlotCreateFeature;
import eu.vicci.process.graphiti.feature.create.RESTInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.ROSInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.RepeatLoopCreateFeature;
import eu.vicci.process.graphiti.feature.create.SOAPInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.SeMiWaInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.SeMiWaRequestCreateFeature;
import eu.vicci.process.graphiti.feature.create.StartControlPortCreateFeature;
import eu.vicci.process.graphiti.feature.create.StartDataPortCreateFeature;
import eu.vicci.process.graphiti.feature.create.TransitionCreateFeature;
import eu.vicci.process.graphiti.feature.create.TriggeredEventCreateFeature;
import eu.vicci.process.graphiti.feature.create.TrueTransitionCreateFeature;
import eu.vicci.process.graphiti.feature.create.WhileLoopCreateFeature;
import eu.vicci.process.graphiti.feature.create.XMLRPCInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.resize.PictogramResizeShapeFeature;
import eu.vicci.process.graphiti.feature.resize.ProcessResizeShapeFeature;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;
import eu.vicci.process.graphiti.types.BooleanTypeAddFeature;
import eu.vicci.process.graphiti.types.BooleanTypeCreateFeature;
import eu.vicci.process.graphiti.types.ComplexTypeAddFeature;
import eu.vicci.process.graphiti.types.ComplexTypeCreateFeature;
import eu.vicci.process.graphiti.types.DataTypeDeleteFeature;
import eu.vicci.process.graphiti.types.DataTypeMoveShapeFeature;
import eu.vicci.process.graphiti.types.DoubleTypeAddFeature;
import eu.vicci.process.graphiti.types.DoubleTypeCreateFeature;
import eu.vicci.process.graphiti.types.IntegerTypeAddFeature;
import eu.vicci.process.graphiti.types.IntegerTypeCreateFeature;
import eu.vicci.process.graphiti.types.ListTypeAddFeature;
import eu.vicci.process.graphiti.types.ListTypeCreateFeature;
import eu.vicci.process.graphiti.types.SetTypeAddFeature;
import eu.vicci.process.graphiti.types.SetTypeCreateFeature;
import eu.vicci.process.graphiti.types.StringTypeAddFeature;
import eu.vicci.process.graphiti.types.StringTypeCreateFeature;
import eu.vicci.process.graphiti.types.SubreferenceHelper;
//import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;
import eu.vicci.process.graphiti.validation.ValidateFeature;
import eu.vicci.process.model.sofia.And;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Or;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;

public class ProcessFeatureProvider extends DefaultFeatureProvider {

    private IAddFeature[] addFeatures = null;
    private ILayoutFeature[] layoutFeatures = null;

    public ProcessFeatureProvider(IDiagramTypeProvider dtp) {

        super(dtp);
        SofiagraphicsPackage.eINSTANCE.eClass();
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        reg.getExtensionToFactoryMap().put("sofiagraphics", new XMIResourceFactoryImpl());

        layoutFeatures = new ILayoutFeature[] { new ProcessLayoutFeature(this) };

        addFeatures = new IAddFeature[] { new ProcessAddFeature(this), new ProcessSlotAddFeature(this),
        		new HumanTaskAddFeature(this),
                new DataDuplicationStepAddFeature(this), new DataMappingStepAddFeature(this),
                new SOAPInvokeAddFeature(this), new RESTInvokeAddFeature(this), new SeMiWaInvokeAddFeature(this),
                new SeMiWaRequestAddFeature(this), new OSGiInvokeAddFeature(this), new XMLRPCInvokeAddFeature(this),
                new ROSInvokeAddFeature(this),
                new OpenHabSemanticInvokeAddFeature(this),
                new LoadClassStepAddFeature(this), 
                new GoalInvokeAddFeature(this),
                
                new OrAddFeature(this), new AndAddFeature(this), new IfAddFeature(this),

                new StartDataPortAddFeature(this), new StartControlPortAddFeature(this),
                new EndDataPortAddFeature(this), new EndControlPortAddFeature(this),
                new EscalationPortAddFeature(this),
                
                new ForLoopAddFeature(this), new WhileLoopAddFeature(this), new RepeatLoopAddFeature(this),
                new TriggeredEventAddFeature(this), 

                new ComplexTypeAddFeature(this), new IntegerTypeAddFeature(this), new BooleanTypeAddFeature(this),
                new DoubleTypeAddFeature(this), new StringTypeAddFeature(this), new ListTypeAddFeature(this),
                new SetTypeAddFeature(this),

                new TransitionAddFeature(this), new TrueTransitionAddFeature(this),
                new FalseTransitionAddFeature(this), new DataMappingAddFeature(this) };
    }

    @Override
    public ICustomFeature[] getCustomFeatures(ICustomContext context) {

        return new ICustomFeature[] { new ValidateFeature(this) };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ICreateFeature[] getCreateFeatures() {
        return new ICreateFeature[] { new ProcessCreateFeature(this), new ProcessSlotCreateFeature(this),
        		new HumanTaskCreateFeature(this),
                new DataDuplicationStepCreateFeature(this), new DataMappingStepCreateFeature(this),
                new SOAPInvokeCreateFeature(this), new RESTInvokeCreateFeature(this),
                new SeMiWaInvokeCreateFeature(this), new SeMiWaRequestCreateFeature(this),
                new OSGiInvokeCreateFeature(this), new XMLRPCInvokeCreateFeature(this),
                new ROSInvokeCreateFeature(this),
                new OpenHabSemanticSelectInvokeCreateFeature(this),
                new OpenHabSemanticAskInvokeCreateFeature(this),
                new OpenHabSemanticCommandInvokeCreateFeature(this),
                new LoadClassStepCreateFeature(this), 
                new GoalInvokeCreateFeature(this),
                
                new OrCreateFeature(this), new AndCreateFeature(this), new IfCreateFeature(this),

                new StartDataPortCreateFeature(this), new StartControlPortCreateFeature(this),
                new EndDataPortCreateFeature(this), new EndControlPortCreateFeature(this), 
                new EscalationPortCreateFeature(this),

                new ForLoopCreateFeature(this), new WhileLoopCreateFeature(this), new RepeatLoopCreateFeature(this),
                new TriggeredEventCreateFeature(this), 

                new ComplexTypeCreateFeature(this), new IntegerTypeCreateFeature(this),
                new BooleanTypeCreateFeature(this), new DoubleTypeCreateFeature(this),
                new StringTypeCreateFeature(this), new ListTypeCreateFeature(this),
                new SetTypeCreateFeature(this)};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IAddFeature getAddFeature(IAddContext context) {

        for (IAddFeature feature : addFeatures)
            if (feature.canAdd(context))
                return feature;

        return super.getAddFeature(context);
    }

    public IAddFeature[] getAddFeatures() {

        return addFeatures;
    }

    @Override
    public ILayoutFeature getLayoutFeature(ILayoutContext context) {

        for (ILayoutFeature feature : layoutFeatures)
            if (feature.canLayout(context))
                return feature;

        return super.getLayoutFeature(context);
    }

    @Override
    public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {

        PictogramElement element = context.getPictogramElement();
        Object object = getBusinessObjectForPictogramElement(element);

        if (object instanceof Port || object instanceof SubreferenceHelper || (object instanceof DataType && ((DataType) object).getBelongsTo() != null))
            return null;
        if (object instanceof DataType)
        	return new DataTypeMoveShapeFeature(this);
        if (object instanceof Process)
            return new ProcessMoveShapeFeature(this);

        return super.getMoveShapeFeature(context);
    }

    @Override
    public IMoveConnectionDecoratorFeature getMoveConnectionDecoratorFeature(IMoveConnectionDecoratorContext context) {

        return null;
    }

    @Override
    public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {

        Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());
        if (object == null)
            return null;

        Class<?> noResize[] = new Class[] { Port.class, 
                ComplexType.class, DataType.class, SubreferenceHelper.class };

        for (Class<?> c : noResize)
            if (c.isAssignableFrom(object.getClass()))
                return null;

        if (object instanceof If || object instanceof Or || object instanceof And){
        	return new PictogramResizeShapeFeature(this);
        }
        else if (object instanceof Process || object instanceof ProcessStep)
            return new ProcessResizeShapeFeature(this);

        return super.getResizeShapeFeature(context);
    }

    @Override
    public IDeleteFeature getDeleteFeature(IDeleteContext context) {

        Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());

        if (object instanceof Port)
            return new PortDeleteFeature(this);

        if (object instanceof DataType)
            return new DataTypeDeleteFeature(this);
        
        if (object instanceof SubreferenceHelper)
        	return new SubreferenceHelper.SubreferenceDeleteFeature(this);

        return super.getDeleteFeature(context);
    }

    /**
     * {@inheritDoc}r
     */
    @Override
    public ICreateConnectionFeature[] getCreateConnectionFeatures() {

        return new ICreateConnectionFeature[] { new TransitionCreateFeature(this),
                new TrueTransitionCreateFeature(this), new FalseTransitionCreateFeature(this),
                new DataMappingCreateFeature(this) };
    }

    @Override
    public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {

        PictogramElement pe = context.getPictogramElement();
        Object object = getBusinessObjectForPictogramElement(pe);

        if (object instanceof ProcessStep)
            return new DirectEditFeature(this);

        return super.getDirectEditingFeature(context);
    }

    @Override
    public IUpdateFeature getUpdateFeature(IUpdateContext context) {

        /*
         * PictogramElement pictogramElement = context.getPictogramElement(); if
         * (pictogramElement instanceof ContainerShape) { Object object =
         * getBusinessObjectForPictogramElement(pictogramElement); if (object
         * instanceof ProcessStep) return new UpdateProcessStepFeature(this); }
         */
        return super.getUpdateFeature(context);
    }
}
