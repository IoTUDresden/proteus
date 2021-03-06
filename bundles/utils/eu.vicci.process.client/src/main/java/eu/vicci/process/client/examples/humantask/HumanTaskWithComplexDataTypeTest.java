package eu.vicci.process.client.examples.humantask;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import eu.vicci.process.client.examples.AbstractProcessRunner;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

public class HumanTaskWithComplexDataTypeTest extends AbstractProcessRunner {

	@Override
	protected String getModelFilePath() {
		return "processes/humanTask/complexTypeHumanTask.diagram";
	}
	
	public static void main(String[] args) {
		HumanTaskWithComplexDataTypeTest test = new HumanTaskWithComplexDataTypeTest();
		test.run();
	}
	
	@Override
	protected Map<String, DataTypeInstance> getInputParameter() {
		Map<String, DataTypeInstance> parameters = new HashMap<String, DataTypeInstance>();
		int instanceNumber = processInstanceInfo.getInstancenumber();
		String idSuffix = "_Instance_" + instanceNumber;
		ComplexTypeInstance personInfo = addPersonInfo(instanceNumber, idSuffix, parameters);
		addPersonName(instanceNumber, idSuffix, parameters, personInfo);
		addPhoneNumber(instanceNumber, idSuffix, parameters, personInfo);
		addAge(instanceNumber, idSuffix, parameters, personInfo);
		return parameters;
	}
	
	private ComplexTypeInstance addPersonInfo(int instanceNumber, String idSuffix, Map<String, DataTypeInstance> parameters){
		ComplexTypeInstance personInfo = SofiaInstanceFactory.eINSTANCE.createComplexTypeInstance();
		ComplexType personInfoType = (ComplexType)getDataTypeByName("PersonInfo");
		copyBaseInfosToInstance(personInfoType, personInfo, instanceNumber);
		parameters.put(personInfo.getIdOfOrigin(), personInfo);
		return personInfo;
	}
	
	private void addPersonName(int instanceNumber, String idSuffix, 
			Map<String, DataTypeInstance> parameters, ComplexTypeInstance personInfo){
		StringTypeInstance personName = SofiaInstanceFactory.eINSTANCE.createStringTypeInstance();
		StringType personNameType = (StringType)getDataTypeByName("PersonName");
		copyBaseInfosToInstance(personNameType, personName, instanceNumber);
		personName.setBelongsTo(personInfo);
		personName.setValue("Klaus");
		personName.setName("PersonName");
		personInfo.getSubtypes().add(personName);
		parameters.put(personName.getIdOfOrigin(), personName);
	}
	
	private void addPhoneNumber(int instanceNumber, String idSuffix, 
			Map<String, DataTypeInstance> parameters, ComplexTypeInstance personInfo){
		StringTypeInstance phoneNumber = SofiaInstanceFactory.eINSTANCE.createStringTypeInstance();
		StringType phoneNumberType = (StringType)getDataTypeByName("PhoneNumber");
		copyBaseInfosToInstance(phoneNumberType, phoneNumber, instanceNumber);
		phoneNumber.setBelongsTo(personInfo);
		phoneNumber.setValue("555-6673");
		phoneNumber.setName("PhoneNumber");
		personInfo.getSubtypes().add(phoneNumber);
		parameters.put(phoneNumber.getIdOfOrigin(), phoneNumber);
	}
	
	private void addAge(int instanceNumber, String idSuffix, Map<String, 
			DataTypeInstance> parameters, ComplexTypeInstance personInfo){
		IntegerTypeInstance age = SofiaInstanceFactory.eINSTANCE.createIntegerTypeInstance();
		IntegerType ageType = (IntegerType)getDataTypeByName("Age");
		copyBaseInfosToInstance(ageType, age, instanceNumber);
		age.setBelongsTo(personInfo);
		age.setValue(66);
		age.setName("Age");
		personInfo.getSubtypes().add(age);
		parameters.put(age.getIdOfOrigin(), age);
	}
	
	private DataType getDataTypeByName(String name){
		Optional<DataType> typeInstance = processInfo.getDataTypeDefinitions().stream()
		.filter(type -> name.equals(type.getName()))
		.findFirst();
		if(typeInstance.isPresent())
			return typeInstance.get();
		
		ComplexType personInfo = (ComplexType)processInfo.getDataTypeDefinitions().stream()
		.filter(type -> "PersonInfo".equals(type.getName()))
		.findFirst().get();
		
		return personInfo.getSubtypes().stream()
		.filter(type -> name.equals(type.getName()))
		.findFirst().get();
	}

}
