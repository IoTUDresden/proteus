package eu.vicci.process.model.sofiainstance.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import eu.vicci.process.devices.util.NodeThread;
import eu.vicci.process.devices.util.SeMiWaListener;
import eu.vicci.process.model.sofia.SeMiWaInvoke;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.semiwa.common.messages.CallResult;
import eu.vicci.semiwa.node.tasking.server.AsynchronousTask;
import eu.vicci.semiwa.node.tasking.server.TaskingServiceStub;

public class SeMiWaInvokeWorker {
	
	private List<DataTypeInstance> returnedValues = new LinkedList<DataTypeInstance>();
	
	public List<DataTypeInstance> work(ProcessStepInstance sii) {
		
		NodeThread node = SeMiWaListener.getInstance().getRpcCallerNode();
		SeMiWaInvoke si = (SeMiWaInvoke)sii.getProcessStepType();
		String serviceName = si.getServiceName();
		String uid = node.getNode().getDataSheet().get("uid");
		TaskingServiceStub taskingServiceStub = new TaskingServiceStub();
		taskingServiceStub.setNode(uid);
		taskingServiceStub.setProcedureName(serviceName);
		HashMap<String, String> input = new HashMap<String, String>();
		HashMap<String, String> params = new HashMap<String, String>();
		for (PortInstance pi : sii.getPorts()) {
			if (pi instanceof StartDataPortInstance) {
				DataPortInstance dpi = (DataPortInstance)pi;
				String datatype = "";
				String value = "";
				DataTypeInstance dti = dpi.getDataInstance();
				if (dti instanceof StringTypeInstance) {
					datatype = "String";
					StringTypeInstance sti = (StringTypeInstance)dti;
					value = sti.getValue();
				} else if (dti instanceof IntegerTypeInstance) {
						datatype = "Integer";
						IntegerTypeInstance iti = (IntegerTypeInstance)dti;
						value = Integer.toString(iti.getValue());
				} else if (dti instanceof DoubleTypeInstance) {
							datatype = "Double";
							DoubleTypeInstance doti = (DoubleTypeInstance)dti;
							value = Double.toString(doti.getValue());
				} else if (dti instanceof BooleanTypeInstance) {
							datatype = "Boolean";				
							BooleanTypeInstance bti = (BooleanTypeInstance)dti;
							value = Boolean.toString(bti.isValue());
				}		
				input.put(datatype, dti.getDataTypeType().getName());
				params.put(dti.getDataTypeType().getName(), value);
			}
		}
	
		taskingServiceStub.setInput(input);
		for (PortInstance pie : sii.getPorts()) {
			if (pie instanceof EndDataPortInstance) {
				DataPortInstance dpie = (DataPortInstance)pie;
				DataTypeInstance dtie = dpie.getDataInstance();
				if (dtie instanceof IntegerTypeInstance) {
					taskingServiceStub.setOutput("Integer");
					AsynchronousTask<Integer> task = new AsynchronousTask<Integer>(params, taskingServiceStub);
					CallResult<Integer> result = task.start(node.getNode());
					if (result.getResult().getClass().equals(Integer.class)) {
						IntegerTypeInstance iti = (IntegerTypeInstance)dtie;
						iti.setValue((Integer)result.getResult());
					}
				} else if (dtie instanceof StringTypeInstance) {
					taskingServiceStub.setOutput("String");
					AsynchronousTask<String> task = new AsynchronousTask<String>(params, taskingServiceStub);
					CallResult<String> result = task.start(node.getNode());
					if (result.getResult().getClass().equals(String.class)) {
						StringTypeInstance iti = (StringTypeInstance)dtie;
						iti.setValue((String)result.getResult());
					}
				} else if (dtie instanceof DoubleTypeInstance) {
					taskingServiceStub.setOutput("Double");
					AsynchronousTask<Double> task = new AsynchronousTask<Double>(params, taskingServiceStub);
					CallResult<Double> result = task.start(node.getNode());
					if (result.getResult().getClass().equals(Double.class)) {
						DoubleTypeInstance iti = (DoubleTypeInstance)dtie;
						iti.setValue((Double)result.getResult());
					}
				} else if (dtie instanceof BooleanTypeInstance) {
					taskingServiceStub.setOutput("Boolean");
					AsynchronousTask<Boolean> task = new AsynchronousTask<Boolean>(params, taskingServiceStub);
					CallResult<Boolean> result = task.start(node.getNode());
					if (result.getResult().getClass().equals(Boolean.class)) {
						BooleanTypeInstance iti = (BooleanTypeInstance)dtie;
						iti.setValue((Boolean)result.getResult());
					}
				}
			}
		}
		node.getNode().disconnectFromSeMiWa();	
		
		for (PortInstance pi : sii.getPorts()) {
			if (pi instanceof EndDataPortInstance) {
				EndDataPortInstance edpi = (EndDataPortInstance)pi;
				DataTypeInstance dti = edpi.getDataInstance();
				returnedValues.add(dti);
			}
		}
		
		return returnedValues;
	}
}
