package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

public class FillEndPortsWithSomeValues implements ProcessStepWorker {

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		// TODO remove
		return null;
	}

	@Override
	public List<DataTypeInstance> work(Context context) {
		System.out.println("################# StartData #################");
		context.startParameter.forEach(dti -> printDataType(dti));
		System.out.println("#############################################");
		
		context.endParameter.forEach(dti -> fillDataType(dti));
		return context.endParameter;
	}

	@Override
	public void deploy() {		
	}
	
	private void printDataType(DataTypeInstance dti) {
		System.out.println(dti.getName() + ": " + dti.toString());
	}
	
	private void fillDataType(DataTypeInstance dti){
		if(dti instanceof StringTypeInstance)
			dti.parse("hello you wonderful port");
		else if (dti instanceof IntegerTypeInstance)
			dti.parse("21");
		else if (dti instanceof DoubleTypeInstance)
			dti.parse("99.999");
		else if (dti instanceof BooleanTypeInstance)
			dti.parse("true");
		else
			throw new RuntimeException("cant fill the given endport with data: no implemented type");
	
	}



}
