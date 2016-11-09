package eu.vicci.process.model.implementations.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	public static final String PLUGIN_ID = "eu.vicci.process.model.implementations"; //$NON-NLS-1$
	
	private static Activator plugin;
	
	private BundleContext context;
	
	public Activator(){
	}
	
	/**
	 * Gets the Activator. Null if the Bundle is not started.
	 * @return
	 */
	public static Activator getDefault(){
		return plugin;		
	}

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		this.context = context;		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		this.context = null;
		plugin = null;		
	}
	
	public BundleContext getContext(){
		return context;		
	}

}
