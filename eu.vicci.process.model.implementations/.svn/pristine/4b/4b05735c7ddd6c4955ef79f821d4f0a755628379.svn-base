package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.sofia.impl.SofiaFactoryImpl;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.BooleanTypeInstanceImplCustom;

public abstract class AbstractStep implements ProcessStepWorker {

    private List<DataTypeInstance> input;

    private List<DataTypeInstance> output = new ArrayList<>();

    @Override
    public List<DataTypeInstance> work(List<DataTypeInstance> input) {
        this.input = input;
        work();
        return this.output;
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
        BooleanTypeInstance instance = new BooleanTypeInstanceImplCustom();
        BooleanType type = SofiaFactoryImpl.eINSTANCE.createBooleanType();

        type.setName(typeName);
        instance.setValue(value);
        instance.setDataTypeType(type);

        return instance;
    }

    @Override
    public void deploy() {}

    protected abstract void work();

}
