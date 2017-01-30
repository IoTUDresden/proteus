package eu.vicci.process.model.util;

import eu.vicci.process.model.util.core.IDataMappingUtil;

public class DataMappingUtil implements IDataMappingUtil {
	
	private String sourceTypeId;
	private String targetTypeId;
	private String sourcePortId;
	private String targetPortId;

	public DataMappingUtil() {
		
	}
	
	public DataMappingUtil(String sourceTypeId, String targetTypeId,
			String sourcePortId, String targetPortId) {
		super();
		this.sourceTypeId = sourceTypeId;
		this.targetTypeId = targetTypeId;
		this.sourcePortId = sourcePortId;
		this.targetPortId = targetPortId;
	}

	/* (non-Javadoc)
	 * @see eu.vicci.process.model.util.IDataMappingUtil#getSourceTypeId()
	 */
	@Override
	public String getSourceTypeId() {
		return sourceTypeId;
	}

	/* (non-Javadoc)
	 * @see eu.vicci.process.model.util.IDataMappingUtil#setSourceTypeId(java.lang.String)
	 */
	@Override
	public void setSourceTypeId(String sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
	}

	/* (non-Javadoc)
	 * @see eu.vicci.process.model.util.IDataMappingUtil#getTargetTypeId()
	 */
	@Override
	public String getTargetTypeId() {
		return targetTypeId;
	}

	/* (non-Javadoc)
	 * @see eu.vicci.process.model.util.IDataMappingUtil#setTargetTypeId(java.lang.String)
	 */
	@Override
	public void setTargetTypeId(String targetTypeId) {
		this.targetTypeId = targetTypeId;
	}

	/* (non-Javadoc)
	 * @see eu.vicci.process.model.util.IDataMappingUtil#getSourcePortId()
	 */
	@Override
	public String getSourcePortId() {
		return sourcePortId;
	}

	/* (non-Javadoc)
	 * @see eu.vicci.process.model.util.IDataMappingUtil#setSourcePortId(java.lang.String)
	 */
	@Override
	public void setSourcePortId(String sourcePortId) {
		this.sourcePortId = sourcePortId;
	}

	/* (non-Javadoc)
	 * @see eu.vicci.process.model.util.IDataMappingUtil#getTargetPortId()
	 */
	@Override
	public String getTargetPortId() {
		return targetPortId;
	}

	/* (non-Javadoc)
	 * @see eu.vicci.process.model.util.IDataMappingUtil#setTargetPortId(java.lang.String)
	 */
	@Override
	public void setTargetPortId(String targetPortId) {
		this.targetPortId = targetPortId;
	}
	
	

}
