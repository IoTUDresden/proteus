package eu.vicci.process.model.sofiainstance.impl.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.model.sofia.CollectionType;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.ForLoop;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Loop;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofia.Transition;
import eu.vicci.process.model.sofiainstance.CollectionTypeInstance;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.ConditionInstance;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.ExecutionPermission;
import eu.vicci.process.model.sofiainstance.ForLoopInstance;
import eu.vicci.process.model.sofiainstance.IfInstance;
import eu.vicci.process.model.sofiainstance.LoopInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.WhileLoopInstance;
import eu.vicci.process.model.sofiainstance.impl.MappingUtilImpl;
import eu.vicci.process.model.sofia.Process;

/**
 * MappingUtilImplCustom is used to create instance versions of process elements
 * such as PortInstance for Port or ProcessStepInstance for ProcessStep.
 * Moreover it avoids unwanted duplicates that can occur for example when
 * several InPorts of the same ProcessStep create ProcessStepInstances. In this
 * case the respective ProcessStepInstance should only created once and after
 * that be referenced.
 * 
 * @author Reik Mueller
 * 
 */
public class MappingUtilImplCustom extends MappingUtilImpl {	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass().getSimpleName());
	private List<ProcessStepInstance> processStepInstances = new ArrayList<ProcessStepInstance>();
	private Set<PortInstance> portInstances = new HashSet<PortInstance>();
	private Set<TransitionInstance> transitionInstances = new HashSet<TransitionInstance>();
	private String processInstanceID = null;
	private String processModelID = null;
	private int instanceNumber;
	
	public ConditionInstance mapCondition(Condition condition) {
		ConditionInstance conditionInstance = null;
		try {
			String classname = condition.getClass().getSimpleName(); // e.g.
			// EndDataPortImpl
			int pos = classname.lastIndexOf("Impl");
			String tmp1 = classname.substring(0, pos);
			String classinstancename = tmp1 + "Instance";
			String factorymethod = "create" + classinstancename;

			// Create PortTypeInstance accordingly
			Method method = null;
			method = SofiaInstanceFactoryImplCustom.getInstance().getClass().getMethod(
					factorymethod);

			conditionInstance = (ConditionInstance) method
					.invoke(SofiaInstanceFactoryImplCustom.getInstance());
			
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return conditionInstance;
	}

	/**
	 * Creates a PortInstance accordingly to a given Port.
	 * 
	 * @param port
	 *            The Port Element of the sofia-model
	 */
	@Override
	public PortInstance mapPort(Port port) {
		PortInstance portinstance = null;
		if(port == null)
			return portinstance;

		try {
			for (PortInstance p : portInstances)
				if (port.getId().equals(p.getPortType().getId()))
					return p;			
			
			LOGGER.debug("Mapping Port: {}", port.getId());
			
			// Find out PortType via reflection
			String classname = port.getClass().getSimpleName(); // e.g.
																// EndDataPortImpl
			int pos = classname.lastIndexOf("Impl");
			String tmp1 = classname.substring(0, pos);
			String classinstancename = tmp1 + "Instance";
			String factorymethod = "create" + classinstancename;

			// Create PortTypeInstance accordingly
			Method method = null;
			method = SofiaInstanceFactoryImplCustom.getInstance().getClass().getMethod(
					factorymethod);

			portinstance = (PortInstance) method
					.invoke(SofiaInstanceFactoryImplCustom.getInstance());
			
			portinstance.setTypeId(port.getId());
			portinstance.setName(port.getName());
			
			if(portinstance instanceof DataPortInstance){
				DataPortInstance dataPortInstance = (DataPortInstance) portinstance;
				DataPort dataPort = (DataPort) port;
				dataPortInstance.setDataInstance(this.mapDataType(dataPort.
						getPortDatatype()));
			}	

			// set PortType to bind together the two model versions (make
			// the attributes of modeling model accessible)
			portinstance.setDecoupled(false);
			portinstance.setPortType(port);
			portinstance.setExecutionState(State.INACTIVE);
			portinstance.setInstancenumber(instanceNumber);
			portinstance.setInstanceId(port.getId()+"_Instance_"+portinstance.getInstancenumber());
			portInstances.add(portinstance);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return portinstance;
	}

	/**
	 * Creates a TransitionInstance accordingly to a given Transition.
	 * 
	 * @param transition
	 *            Transition element of the model
	 */
	@Override
	public TransitionInstance mapTransition(Transition transition) {
		for (TransitionInstance t : transitionInstances) {
			if (transition.getId().equals(t.getTransitionType().getId())) {
				LOGGER.info("Transition already mapped! {}", transition.getId());
				return t;
			}
		}
		TransitionInstance ti = SofiaInstanceFactoryImplCustom.getInstance()
				.createTransitionInstance();
		ti.setTransitionType(transition);
		ti.setSourcePortInstance(mapPort(transition.getSourcePort()));
		ti.setTargetPortInstance(mapPort(transition.getTargetPort()));
		ti.setInstancenumber(instanceNumber);
		ti.setInstanceId(transition.getId() + "_Instance_" + instanceNumber);
		transitionInstances.add(ti);
		return ti;
	}

	/**
	 * Creates a ProcessStepInstance accordingly to a given ProcessStep
	 * 
	 * @param processStep
	 *            ProcessStep element of the model
	 */
	@Override
	public ProcessStepInstance mapProcessStep(ProcessStep processStep) {
		ProcessStepInstance psi = null;
		try {
			for (ProcessStepInstance instance : processStepInstances) 
				if (instance.getProcessStepType().getId().equals(processStep.getId())) 
					return instance;		
			
			psi = createProcessStepInstance(processStep);

			psi.setProcessStepType(processStep);
			psi.setPermission(ExecutionPermission.GRANTED);
			psi.setProcessInstanceID(getProcessInstanceID());
			psi.setProcessModelID(getProcessModelID());
			psi.setInstancenumber(instanceNumber);
			psi.setInstanceId(psi.getProcessStepType().getId()+"_Instance_"+psi.getInstancenumber());
			psi.setCyberPhysical(processStep.isCyberPhysical());

			// in the case that the ProcessStep is an If-Step its COnidtion needs to be mapped, too.
			if(psi instanceof IfInstance)
				mapIfInstance(processStep, psi);
			
			if(psi instanceof ForLoopInstance)
				mapForLoopInstance(processStep, psi);
			else if(psi instanceof WhileLoopInstance)
				mapWhileLoopInstance(processStep, psi);
			
			processStepInstances.add(psi);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return psi;
	}
	
	private ProcessStepInstance createProcessStepInstance(ProcessStep processStep) throws Exception{
		if(processStep instanceof Process)
			return createProcessInstance((Process)processStep);
		
		String classname = processStep.getClass().getSimpleName(); // e.g. EndDataPortImpl
		int pos = classname.lastIndexOf("Impl");
		String tmp1 = classname.substring(0, pos);
		String classinstancename = tmp1 + "Instance";
		String factorymethod = "create" + classinstancename;

		Method method = SofiaInstanceFactoryImplCustom.getInstance().getClass().getMethod(
				factorymethod);

		return (ProcessStepInstance) method
				.invoke(SofiaInstanceFactoryImplCustom.getInstance());		
	}
	
	//special case for processes cause they can be distributed
	private ProcessStepInstance createProcessInstance(Process process){
		if(process.isRemoteExecuting())
			return new DistributedProcessInstanceImplCustom();
		if(process.isDistributed())
			return new DistributingProcessInstanceImplCustom();
		
		return new ProcessInstanceImplCustom();
	}
	
	private void mapWhileLoopInstance(ProcessStep processStep, ProcessStepInstance psi) {
		mapLoopInstance(processStep, psi);		
	}

	//Condition & portsCopyToStartport Mapping for Loops
	private void mapLoopInstance(ProcessStep processStep, ProcessStepInstance psi){
		Loop loop = (Loop)processStep;
		LoopInstance loopInstance = (LoopInstance)psi;
		ConditionInstance conditionInstance = getConditionInstance(loop.getLoopCondition());
		
		StartDataPortInstance value;
		EndDataPortInstance key;
		for (Entry<EndDataPort, StartDataPort> entry : loop.getPortsCopyToStartsport().entrySet()) {
			key = (EndDataPortInstance)mapPort(entry.getKey());
			value = (StartDataPortInstance)mapPort(entry.getValue());
			loopInstance.getPortsCopyToStartport().put(key, value);			
		}
		
		loopInstance.setLoopConditionInstance(conditionInstance);
		psi = loopInstance;
	}	
	
	private void mapForLoopInstance(ProcessStep processStep, ProcessStepInstance psi) {
		mapLoopInstance(processStep, psi);
		ForLoop forLoop = (ForLoop)processStep;
		ForLoopInstance forLoopInstance = (ForLoopInstance)psi;
		forLoopInstance.setLoopStepWidth((StartDataPortInstance) mapPort(forLoop.getLoopStepWidth()));
		psi = forLoopInstance;		
	}

	private void mapIfInstance(ProcessStep processStep, ProcessStepInstance psi)
	{
		If ifStep = (If)processStep;
		IfInstance ifInstance = ((IfInstance) psi);
		ConditionInstance conditionInstance = getConditionInstance(ifStep.getIfCondition());		
		// putting it together
		ifInstance.setIfConditionInstance(conditionInstance);
		psi = ifInstance;		
	}
	
	private ConditionInstance getConditionInstance(Condition condition){
		ConditionInstance conditionInstance = this.mapCondition(condition);
		conditionInstance.setLeftSide((StartDataPortInstance)this.mapPort(condition.getLeftSide()));
		conditionInstance.setRightSide((StartDataPortInstance)this.mapPort(condition.getRightSide()));
		conditionInstance.setIfConditionType(condition);
		return conditionInstance;
	}

	@Override
	public DataTypeInstance mapDataType(DataType dataType) {
		DataTypeInstance dataTypeinstance = null;
		try {

			// Find out DataType via reflection
			String classname = dataType.getClass().getSimpleName(); // e.g.
			// DataTypeImpl
			int pos = classname.lastIndexOf("Impl");
			String tmp1 = classname.substring(0, pos);
			String classinstancename = tmp1 + "Instance";
			String factorymethod = "create" + classinstancename;

			// Create DataTypeInstance accordingly
			Method method = null;
			method = SofiaInstanceFactoryImplCustom.getInstance().getClass().getMethod(
					factorymethod);

			dataTypeinstance = (DataTypeInstance) method
					.invoke(SofiaInstanceFactoryImplCustom.getInstance());
			
			dataTypeinstance.setTypeId(dataType.getId());
			dataTypeinstance.setDataTypeType(dataType);
			dataTypeinstance.setName(dataType.getName());
			dataTypeinstance.setIdOfOrigin(dataType.getId());
			dataTypeinstance.setInstancenumber(instanceNumber);
			dataTypeinstance.setInstanceId(dataType.getId()+"_Instance_"+dataTypeinstance.getInstancenumber());
			
			if (dataType instanceof CollectionType) {
				CollectionType collt = (CollectionType)dataType;
				CollectionTypeInstance collti = (CollectionTypeInstance)dataTypeinstance;
				DataType colldti = collt.getCollectionItemType();
				DataType colldtiCopy = EcoreUtil.copy(colldti);
				collti.setCollectionItemType(colldtiCopy);
			}
			
			if(dataType instanceof ComplexType){
				ComplexType ct = (ComplexType)dataType;
				
				for(DataType dt : ct.getSubtypes()){
					if(dataTypeinstance instanceof ComplexTypeInstance){
						ComplexTypeInstance cti = (ComplexTypeInstance) dataTypeinstance;
						cti.getSubtypes().add(mapDataType(dt));
					}
				}
			}

		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return dataTypeinstance;
	}
	
	private String getProcessInstanceID(){
		if(processInstanceID == null){
			for(ProcessStepInstance psi : processStepInstances){
				ProcessInstance pi = null;
				if(psi instanceof ProcessInstance){
					pi = (ProcessInstance) psi;
				}
				processInstanceID = pi.getInstanceId();
			}
		}

		return processInstanceID;
	}
	
	private String getProcessModelID() {
		if (processModelID == null) {
			for (ProcessStepInstance psi : processStepInstances) {
				ProcessInstance pi = null;
				if (psi instanceof ProcessInstance) {
					pi = (ProcessInstance) psi;
				}
				processModelID = pi.getProcessStepType().getId();
			}
		}
		this.setProcessModelID(processModelID);
		return processModelID;
	}

	public void setProcessStepInstances(List<ProcessStepInstance> processStepInstances) {
		this.processStepInstances = processStepInstances;
	}

	public void setPortInstances(Set<PortInstance> portInstances) {
		this.portInstances = portInstances;
	}

	public void setTransitionInstances(Set<TransitionInstance> transitionInstances) {
		this.transitionInstances = transitionInstances;
	}

	public void setProcessInstanceID(String processInstanceID) {
		this.processInstanceID = processInstanceID;
	}

	public void setProcessModelID(String processModelID) {
		this.processModelID = processModelID;
	}

	public void setInstanceNumber(int number) {
		this.instanceNumber = number;
	}
}
