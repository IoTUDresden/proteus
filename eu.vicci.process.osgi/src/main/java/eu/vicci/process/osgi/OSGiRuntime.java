package eu.vicci.process.osgi;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;



public class OSGiRuntime {
	
		private static OSGiRuntime runtime;
		
		private String state;
		private Framework framework;
		
		private OSGiRuntime() {
			this.setState("uninitialized");
		}
		
		public static synchronized OSGiRuntime getInstance() {
		    if (runtime == null) {
		    	System.out.println("OSGiRuntime was null - new one created");
		      runtime = new OSGiRuntime();
		    }
		    if (runtime == null) {
		    	System.out.println("What the hack?!");
		    }
		    return runtime;
		  }
		
		public void start() {
			
			if (this.getState()!="started") {
				FrameworkFactory frameworkFactory = ServiceLoader.load(FrameworkFactory.class).iterator().next();
				Map<String, String> config = new HashMap<String, String>();
				config.put("osgi.console", "true");
				config.put("osgi.console.enable.builtin", "true");
				//TODO: add some config properties
				Framework framework = frameworkFactory.newFramework(config);
				try {
					framework.start();
				} catch (BundleException e) {
					e.printStackTrace();
				}
				this.setFramework(framework);
				this.setState("started");
				
			}
		}
		
		
		public void stop() {
			try {
				this.getFramework().stop();
				this.setState("stopped");
			} catch (BundleException e) {
				e.printStackTrace();
			}
		}
		
		public void shutDown() {
			try {
			    this.getFramework().waitForStop(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.setState("shutdown");
			    System.exit(0);
			}

		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Framework getFramework() {
			return framework;
		}

		public void setFramework(Framework fw) {
			this.framework = fw;
		}
	
}


