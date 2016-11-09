package eu.vicci.process.runtime;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
	private VicciRuntime vicciRuntime;

	@Override
	public void start(BundleContext context) throws Exception {
		vicciRuntime = new VicciRuntime();
		println("starting vicci runtime...\n");
		boolean started = vicciRuntime.start();
		if(!started){
			printlnErr("\n\nfailed to start vicci runtime");
			return;
		}
		println("\n\nvicci runtime started");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if(vicciRuntime != null){
			println("\n\nstopping the vicci runtime...\n");		
			vicciRuntime.stop();
		}
	}
	
	private static void printlnErr(Object txt){
		System.err.print(txt);
	}
	
	private static void println(Object txt){
		System.out.println(txt);
	}

}
