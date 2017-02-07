package eu.vicci.process.graphiti.execution;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	// TODO cancel all running jobs
	// http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Fguide%2Fruntime_jobs.htm

	// The plug-in ID
	public static final String PLUGIN_ID = "eu.vicci.process.graphiti.execution"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	private Map<String, Image> imageMap = new HashMap<String, Image>();
	
	/**
	 * The constructor
	 */
	public Activator() {
	}


	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	/**
	 * Gets the image from the given path
	 * @param path
	 * @return
	 */
	public Image getImage(String path){
		Image result = imageMap.get(path);
		if (result == null) {
			ImageDescriptor descriptor = imageDescriptorFromPlugin(PLUGIN_ID, path);
			if (descriptor != null) {
				result = descriptor.createImage();
				imageMap.put(path, result);
			}
		}
		return result;
	}

}
