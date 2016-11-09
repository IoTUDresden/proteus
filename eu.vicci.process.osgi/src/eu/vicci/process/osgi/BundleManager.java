package eu.vicci.process.osgi;

import java.util.LinkedList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

public class BundleManager {
	
	private static BundleManager bm;
		
	private Framework fw =  OSGiRuntime.getInstance().getFramework();
	private List<Bundle> installedBundles = new LinkedList<Bundle>();
	
	public BundleManager() {
	}
	
	public static synchronized BundleManager getInstance() {
		if (bm == null) {
			bm = new BundleManager();
		}
		return bm;
	}
	
	public String installBundle(String bundlejar) {
		try {
			BundleContext context = fw.getBundleContext();
			Bundle newbundle = context.installBundle(bundlejar);
			this.getInstalledBundles().add(newbundle);
			return newbundle.getSymbolicName();
		} catch (BundleException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void startBundle(Long bundleid) {
		try {
			for (Bundle b : this.getInstalledBundles()) {
				if (b.getBundleId()==bundleid) b.start();
			}
			
		} catch (BundleException e) {
			e.printStackTrace();
		}
	}
	
	public void stopBundle(Long bundleid) {
		try {
			for (Bundle b : this.getInstalledBundles()) {
				if (b.getBundleId()==bundleid) b.stop();
			}
		} catch (BundleException e) {
			e.printStackTrace();
		}
		
	}

	public List<Bundle> getInstalledBundles() {
		return installedBundles;
	}

	public void setInstalledBundles(List<Bundle> installedBundles) {
		this.installedBundles = installedBundles;
	}
}
