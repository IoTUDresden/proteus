package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.ArrayList;
import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.BooleanTypeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ComplexTypeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.DoubleTypeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.IntegerTypeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.StringTypeInstanceImplCustom;

public class RandomDummyDataGenerator implements ProcessStepWorker{

	@Override
	public void deploy() {
		System.out.println("A ProcessStepWorker-Class was deployed by a generic ProcessStep and says: 'Hello, I am a RandomDummyDataGenerator!'");		
	}

	@Override
	public List<DataTypeInstance> work(Context context) {
		System.out.println("RandomDummyDataGenerator workes");
		List<DataTypeInstance> testinformation = new ArrayList<DataTypeInstance>();
		
		for(DataTypeInstance dti1 : context.startParameter){
			System.out.println("����������");
			DataTypeInstance dti = dti1.copy();
			if(dti instanceof ComplexTypeInstanceImplCustom){
				ComplexTypeInstanceImplCustom ctiic = (ComplexTypeInstanceImplCustom)dti;
				ctiic.createDummyData();
				testinformation.add(ctiic);
			}else if(dti instanceof BooleanTypeInstanceImplCustom){
				BooleanTypeInstanceImplCustom btiic = (BooleanTypeInstanceImplCustom)dti;
				btiic.createDummyData();
				testinformation.add(btiic);
			}else if(dti instanceof DoubleTypeInstanceImplCustom){
				DoubleTypeInstanceImplCustom dtiic = (DoubleTypeInstanceImplCustom)dti;
				dtiic.createDummyData();
				testinformation.add(dtiic);
			}else if(dti instanceof StringTypeInstanceImplCustom){
				StringTypeInstanceImplCustom stiic = (StringTypeInstanceImplCustom)dti;
				stiic.createDummyData();
				
				testinformation.add(stiic);
			}else if(dti instanceof IntegerTypeInstanceImplCustom){
				IntegerTypeInstanceImplCustom itiic = (IntegerTypeInstanceImplCustom)dti;
				itiic.createDummyData();
				testinformation.add(itiic);
			}
			
		}
		
//		StringTypeInstanceImpl stringType = new StringTypeInstanceImplCustom();
//		stringType.setValue("TestStringInformation");
//		testinformation.add(stringType);
        return testinformation;
	}

}
