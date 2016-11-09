package eu.vicci.process.model.util.dto;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.model.sofia.CollectionType;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofiainstance.CollectionTypeInstance;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;

/**
 * Global Mappping Util
 */
// TODO add this also in the Custom Mapping util
public class MappingUtil {
	private static final Logger logger = LoggerFactory.getLogger(MappingUtil.class);
	private static final String CREATE_PREFIX = "create";
	private static final String INSTANCE_SUFFIX = "Instance";
	private static final String IMPL_SUFFIX = "Impl";
	private static final String INSTANCE_ID_SUFFIX = "_Instance_";

	public static DataTypeInstance mapDataType(DataType dataType, int instanceNumber, SofiaInstanceFactory instanceFactory) {
		DataTypeInstance dataTypeInstance = null;
		try {
			dataTypeInstance = createRawInstance(dataType, instanceFactory);
			setGeneralValues(dataTypeInstance, dataType, instanceNumber);
			setCollectionTypeValues(dataTypeInstance, dataType);
			setComplexTypeValues(dataTypeInstance, dataType, instanceNumber, instanceFactory);
		} catch (Exception e) {
			String errMesg = "cant create datatype instance from dto " + dataType.getClass().getCanonicalName();
			logger.error(errMesg);
			e.printStackTrace();
			throw new IllegalArgumentException(errMesg);
		}
		return dataTypeInstance;
	}

	private static void setGeneralValues(DataTypeInstance dataTypeinstance, DataType dataType, int instanceNumber) {
		dataTypeinstance.setTypeId(dataType.getId());
		dataTypeinstance.setDataTypeType(dataType);
		dataTypeinstance.setName(dataType.getName());
		dataTypeinstance.setIdOfOrigin(dataType.getId());
		dataTypeinstance.setInstancenumber(instanceNumber);
		String instanceId = dataType.getId() + INSTANCE_ID_SUFFIX + dataTypeinstance.getInstancenumber();
		dataTypeinstance.setInstanceId(instanceId);
	}

	private static void setCollectionTypeValues(DataTypeInstance dataTypeinstance, DataType dataType) {
		if (!(dataType instanceof CollectionType))
			return;
		CollectionType collt = (CollectionType) dataType;
		CollectionTypeInstance collti = (CollectionTypeInstance) dataTypeinstance;
		DataType colldti = collt.getCollectionItemType();
		DataType colldtiCopy = EcoreUtil.copy(colldti);
		collti.setCollectionItemType(colldtiCopy);
	}

	private static void setComplexTypeValues(DataTypeInstance dataTypeInstance, DataType dataType, int instanceNumber, SofiaInstanceFactory instanceFactory) {
		if (!(dataType instanceof ComplexType))
			return;
		ComplexType ct = (ComplexType) dataType;
		for (DataType dt : ct.getSubtypes()) {
			if (dataTypeInstance instanceof ComplexTypeInstance) {
				ComplexTypeInstance cti = (ComplexTypeInstance) dataTypeInstance;
				cti.getSubtypes().add(mapDataType(dt, instanceNumber, instanceFactory));
			}
		}
	}

	private static DataTypeInstance createRawInstance(DataType dataType, SofiaInstanceFactory instanceFactory)
			throws Exception {
		//e.g. StringTypeImpl
		String classname = dataType.getClass().getSimpleName(); 
		int pos = classname.lastIndexOf(IMPL_SUFFIX);
		String tmp1 = classname.substring(0, pos);
		String classinstancename = tmp1 + INSTANCE_SUFFIX;
		String factorymethod = CREATE_PREFIX + classinstancename;
		Method method = instanceFactory.getClass().getMethod(factorymethod);
		return (DataTypeInstance) method.invoke(instanceFactory);
	}

}
