package eu.vicci.process.model.implementation.tests.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class TestBundleActivator implements BundleActivator {
	
	private BundleContext context;
	
	private static TestBundleActivator plugin = null;
	
	public static TestBundleActivator getDefault(){
		return plugin;		
	}

	@Override
	public void start(BundleContext context){
		plugin = this;
		this.context = context;
	}

	@Override
	public void stop(BundleContext context){		
		this.context = null;
		plugin = null;
	}
	
	public BundleContext getContext(){
		return context;
	}

}
