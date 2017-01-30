package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public abstract class AbstractStep implements ProcessStepWorker {

    private List<DataTypeInstance> input;
    private List<DataTypeInstance> outPorts = new ArrayList<>();
    private List<DataTypeInstance> output = new ArrayList<>();
	
    protected String instanceId;

    @Override
    public List<DataTypeInstance> work(Context context) {
        input = context.startParameter;
        outPorts = context.endParameter;
        instanceId = context.instanceId;
        
        work();
        
        return output;
    }

    protected void addOutgoing(DataTypeInstance instance) {
        output.add(instance);
    }

    protected Stream<Object> parameters(String name, Class<? extends DataType> typeClass) {
        return input.stream()
                .filter(it -> name.equals(it.getDataTypeType().getName()))
                .filter(it -> typeClass.isInstance(it.getDataTypeType()))
                .map(DataTypeInstance::getValueAsObject)
                .filter(it -> {
                    if (it != null && it instanceof String)
                        return !((String) it).isEmpty();
                    else
                        return it != null;
                });
    }

    protected String stringParameter(String name) {
        return parameters(name, StringType.class)
                .map(it -> (String) it)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(name + " missing"));
    }

    protected BooleanTypeInstance booleanNamed(String typeName, boolean value) {
        
        for (DataTypeInstance dti : outPorts) {
        	
        	if (typeName.equals(dti.getName())) {
        		((BooleanTypeInstance)dti).setValue(value);
        		return (BooleanTypeInstance)dti;
        	}
        }
        
        throw new RuntimeException("No DataTypeInstance found for " + typeName);
    }

    @Override
    public void deploy() {}

    protected abstract void work();

}
