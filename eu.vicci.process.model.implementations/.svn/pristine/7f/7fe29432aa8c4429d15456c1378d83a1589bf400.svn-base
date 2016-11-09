package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.DataMappingStepInstance;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;

public class DataMappingStepInstanceImplCustom extends
		ProcessStepInstanceImplCustom implements DataMappingStepInstance{

	/**
	 * The work to be done by the ProcessStep.<br>
	 * <br>
	 * Please fill in here all necessary business logic.
	 */
	public void work() {
		// Create lists of startDataPorts and endDataPorts
		List<DataPortInstance> startDataPorts = new LinkedList<DataPortInstance>();
		List<DataPortInstance> endDataPorts = new LinkedList<DataPortInstance>();

		// System.out.println("DataMapping.StartDataInstances: ");
		for (PortInstance port : getPorts()) {
			if (port instanceof StartDataPortInstance) {
				DataPortInstance dataPortInstance = (DataPortInstance) port;
				System.out.println(dataPortInstance.getDataInstance()
						.serializeToXML());
				startDataPorts.add(dataPortInstance);
			} else if (port instanceof EndDataPortInstance) {
				DataPortInstance dataPortInstance = (DataPortInstance) port;
				endDataPorts.add(dataPortInstance);
			}
		}

		// Create Set with all Mappings
		Set<DataMapping> allMappings = new HashSet<DataMapping>();
		allMappings.addAll(getAllDataMappings(startDataPorts));
		allMappings.addAll(getAllDataMappings(endDataPorts));

		// mapping
		for (DataPortInstance edpi : endDataPorts) {
			DataTypeInstance finalDataTypeInstance = mapp(startDataPorts,
					allMappings, edpi.getDataInstance());
			edpi.setDataInstance(finalDataTypeInstance);
		}
	}

	private DataTypeInstance getDataTypeInstanceByDataTypeId(String id,
			DataTypeInstance dti) {
		if (dti.getDataTypeType().getId().equals(id))
			return dti;

		if (dti instanceof ComplexTypeInstance) {
			ComplexTypeInstance ct = (ComplexTypeInstance) dti;
			for (DataTypeInstance dataTypeInstance : ct.getSubtypes()) {
				DataTypeInstance d = getDataTypeInstanceByDataTypeId(id,
						dataTypeInstance);
				if (d != null)
					return d;
			}
		}
		return null;
	}

	private Set<DataMapping> getAllDataMappings(Collection<DataPortInstance> pis) {
		Set<DataMapping> allMappings = new HashSet<DataMapping>();
		for (DataPortInstance dpi : pis) {
			Port p = dpi.getPortType();
			if (p instanceof EndDataPort) {
				EndDataPort edp = (EndDataPort) p;
				allMappings.addAll(edp.getMappings());
			}
		}
		return allMappings;
	}

	private DataTypeInstance mapp(List<DataPortInstance> startDataPorts,
			Set<DataMapping> allMappings, DataTypeInstance dataTypeInstance) {

		for (DataMapping dm : allMappings) {
			String sourceId = dm.getTarget().getId();
			String targetId = dm.getSource().getId();

			for (DataPortInstance sdpi : startDataPorts) {
				DataTypeInstance dtiSource = getDataTypeInstanceByDataTypeId(
						sourceId, sdpi.getDataInstance());
				if (dtiSource != null) {
					DataTypeInstance dtiTarget = getDataTypeInstanceByDataTypeId(
							targetId, dataTypeInstance);
					String classSource = dtiSource.getClass().getSimpleName();
					String classTarget = dtiTarget.getClass().getSimpleName();

					if (dtiTarget != null && classSource.equals(classTarget)) {
						dtiTarget.parse(dtiSource.toString());
					}
				}
			}
		}
		return dataTypeInstance;
	}
}