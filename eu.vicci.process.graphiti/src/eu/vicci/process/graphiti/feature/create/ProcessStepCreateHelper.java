package eu.vicci.process.graphiti.feature.create;

import java.util.Map;

import eu.vicci.process.graphiti.AttributeMap;
import eu.vicci.process.model.sofia.ProcessStep;

public class ProcessStepCreateHelper {
	public static void drawNameAndType(ProcessStep bo){
		final Map<String, org.eclipse.graphiti.mm.algorithms.Text> map =
                AttributeMap.instance().getObjectMap(bo);
		
		if (map != null) {
            org.eclipse.graphiti.mm.algorithms.Text typeText = map.get("type");
            if (typeText != null && bo.getType() != null)
                typeText.setValue("type: " + bo.getType());
            
            org.eclipse.graphiti.mm.algorithms.Text nameText = map.get("name");
            if (nameText != null && bo.getName() != null)
                nameText.setValue("name: " + bo.getName());
        }
	}
}
