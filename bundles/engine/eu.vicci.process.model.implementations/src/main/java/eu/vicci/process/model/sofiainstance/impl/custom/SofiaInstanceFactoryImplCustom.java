package eu.vicci.process.model.sofiainstance.impl.custom;


import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.ConditionInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.ForLoopInstance;
import eu.vicci.process.model.sofiainstance.HumanTaskInstance;
import eu.vicci.process.model.sofiainstance.IfInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.MapeKInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.SetTypeInstance;
import eu.vicci.process.model.sofiainstance.StartControlPortInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.WhileLoopInstance;
import eu.vicci.process.model.sofiainstance.impl.SofiaInstanceFactoryImpl;

public class SofiaInstanceFactoryImplCustom extends SofiaInstanceFactoryImpl {
	
	//private static SofiaInstanceFactoryImplCustom instance = null;
	
	@Override
	public DoubleTypeInstance createDoubleTypeInstance() {
		return new DoubleTypeInstanceImplCustom();
	}
	
	@Override
	public ProcessInstance createProcessInstance() {
		return new ProcessInstanceImplCustom();
	}
	
	@Override
	public TransitionInstance createTransitionInstance() {
		return new TransitionInstanceImplCustom();
	}

	@Override
	public EndControlPortInstance createEndControlPortInstance() {
		return new EndControlPortInstanceImplCustom();
	}

	@Override
	public EndDataPortInstance createEndDataPortInstance() {
		return new EndDataPortInstanceImplCustom();
	}
	
	@Override
	public EscalationPortInstance createEscalationPortInstance() {
		return new EscalationPortInstanceImplCustom();
	}

	@Override
	public StartControlPortInstance createStartControlPortInstance() {
		return new StartControlPortInstanceImplCustom();
	}

	@Override
	public StartDataPortInstance createStartDataPortInstance() {
		return new StartDataPortInstanceImplCustom();
	}

	@Override
	public MappingUtil createMappingUtil() {
		return new MappingUtilImplCustom();
	}

	
	public ProcessStepInstance createTriggeredEventInstance() {
		return new TriggeredEventInstanceImplCustom();
	}
	
	
	public IfInstance createIfInstance() {
		return new IfInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createSOAPInvokeInstance() {
		return new SOAPInvokeInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createXMLRPCInvokeInstance() {
		return new XMLRPCInvokeInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createOrInstance() {
		return new OrInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createAndInstance() {
		return new AndInstanceImplCustom();
	}

	
	public ProcessStepInstance createLoadClassStepInstance() {
		return new LoadClassStepInstanceImplCustom();
	}
	
	@Override
	public StringTypeInstance createStringTypeInstance() {
		return new StringTypeInstanceImplCustom();
	}
	
	public ProcessStepInstance createSeMiWaInvokeInstance() {
		return new SeMiWaInvokeInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createSeMiWaRequestInstance() {
		return new SeMiWaRequestInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createRESTInvokeInstance() {
		return new RESTInvokeInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createOSGiInvokeInstance() {
		return new OSGiInvokeInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createROSInvokeInstance() {
		return new ROSInvokeInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createProcessSlotInstance() {
		return new ProcessSlotInstanceImplCustom();
	}
	
	
	public  ProcessStepInstance createDataMappingStepInstance() {
		return new DataMappingStepInstanceImplCustom();
	}
	
	
	public ProcessStepInstance createDataDuplicationStepInstance() {
		return new DataDuplicationStepInstanceImplCustom();
	}
	
	@Override
	public ComplexTypeInstance createComplexTypeInstance() {
		return new ComplexTypeInstanceImplCustom();
	}
	
	@Override
	public IntegerTypeInstance createIntegerTypeInstance() {
		return new IntegerTypeInstanceImplCustom();
	}
	
	@Override
	public ListTypeInstance createListTypeInstance() {
		return new ListTypeInstanceImplCustom();
	}
	
	@Override
	public SetTypeInstance createSetTypeInstance() {
		return new SetTypeInstanceImplCustom();
	}
	
	@Override
	public BooleanTypeInstance createBooleanTypeInstance() {
		return new BooleanTypeInstanceImplCustom();
	}
	
	@Override
	public ConditionInstance createConditionInstance(){
		return new ConditionInstanceImplCustom();
	}
	
	@Override
	public HumanTaskInstance createHumanTaskInstance() {
		return new HumanTaskInstanceImplCustom();
	}
	
	public ForLoopInstance createForLoopInstance(){
		return new ForLoopInstanceImplCustom();
	}
	
	public WhileLoopInstance createWhileLoopInstance(){
		return new WhileLoopInstanceImplCustom();
	}
	
	public OpenHabSemanticCommandInvokeInstance createOpenHabSemanticCommandInvokeInstance(){
		return new OpenHabSemanticCommandInvokeInstanceImplCustom();
	}
	
	public OpenHabSemanticSelectInvokeInstance createOpenHabSemanticSelectInvokeInstance(){
		return new OpenHabSemanticSelectInvokeInstanceImplCustom();
	}
	
	public OpenHabSemanticAskInvokeInstance createOpenHabSemanticAskInvokeInstance(){
		return new OpenHabSemanticAskInvokeInstanceImplCustom();
	}
	
	public MapeKInstance createMapeKInstance(){
		return new MapeKInstanceImplCustom();
	}
	
	public static SofiaInstanceFactoryImplCustom getInstance() {
		return Loader.INSTANCE;
	}
	
	//threadsafe singleton implementation, without locks (synchronize)
	private static class Loader{
		static SofiaInstanceFactoryImplCustom INSTANCE = new SofiaInstanceFactoryImplCustom();
	}	
}
