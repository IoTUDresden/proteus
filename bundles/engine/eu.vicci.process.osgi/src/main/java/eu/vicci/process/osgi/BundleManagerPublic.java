package eu.vicci.process.osgi;

import java.util.List;


public class BundleManagerPublic implements IBundleManager {

	@Override
	public String installBundle(String bundlejar) {
		return null;
	}

	@Override
	public void startBundle(Long bundleid) {
		
	}

	@Override
	public void stopBundle(Long bundleid) {
		
	}

	@Override
	public void removeBundle(Long bundleid) {
		
	}

	@Override
	public List<String> listInstalledBundles() {
		return null;
	}

	@Override
	public List<String> listRunningBundles() {
		return null;
	}

}
