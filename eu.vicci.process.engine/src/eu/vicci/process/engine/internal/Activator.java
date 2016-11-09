package eu.vicci.process.engine.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	
	public static final String PLUGIN_ID = "eu.vicci.process.engine";
	
	private static Activator plugin;
	private BundleContext context;
	
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		this.context = context;
		plugin = this;		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		this.context = null;
		plugin = null;		
	}

	public static Activator getDefault() {
		return plugin;
	}
	
	public BundleContext getContext(){
		return context;
	}

}
