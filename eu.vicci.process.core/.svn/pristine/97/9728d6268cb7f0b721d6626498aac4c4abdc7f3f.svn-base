package eu.vicci.process.model.util.messages.core;

import java.util.List;

import eu.vicci.process.model.util.core.IDataMappingUtil;

public interface IHumanTaskRequest extends IWampRequest, IHumanTaskMessage {

	/**
	 * Gets the instance Id of the root process 
	 * @return
	 */
	String getRootProcessId();

	/**
	 * Sets the instance Id of the root process 
	 */
	void setRootProcessId(String processInstanceId);
	
	/**
	 * Gets the DataMappingUtil
	 * @return
	 */
	List<IDataMappingUtil> getDataMappingUtils();
	
	/**
	 * Sets the DataMappingUtils
	 * @param dataMappingUtils
	 */
	void setDataMappingUtils(List<IDataMappingUtil> dataMappingUtils);
}