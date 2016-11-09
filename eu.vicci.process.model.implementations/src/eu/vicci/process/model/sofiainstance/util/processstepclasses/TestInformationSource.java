package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.ArrayList;
import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.StringTypeInstanceImpl;
import eu.vicci.process.model.sofiainstance.impl.custom.StringTypeInstanceImplCustom;

public class TestInformationSource implements ProcessStepWorker{

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		System.out.println("TestInformationSource workes");
		List<DataTypeInstance> testinformation = new ArrayList<DataTypeInstance>();
		StringTypeInstanceImpl stringType = new StringTypeInstanceImplCustom();
		stringType.setValue("TestStringInformation");
		testinformation.add(stringType);
        return testinformation;
	}

	@Override
	public void deploy() {
		System.out.println("A ProcessStepWorker-Class was deployed by a generic ProcessStep and says: 'Hello, I am a source for test information!'");		
	}

}
