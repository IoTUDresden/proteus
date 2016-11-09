package eu.vicci.process.graphiti.property;

import org.eclipse.graphiti.features.ConfigurableFeatureProviderWrapper;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import eu.vicci.process.graphiti.ProcessFeatureProvider;

public abstract class PropertySectionBase extends GFPropertySection implements ITabbedPropertyConstants {
	
	/**
	 * Gets the feature provider
	 * @return
	 */
    protected ProcessFeatureProvider getProcessFeatureProvider(){
    	return (ProcessFeatureProvider)((ConfigurableFeatureProviderWrapper)getDiagramTypeProvider()
    			.getFeatureProvider())
    			.getInnerFeatureProvider();
    }

}
