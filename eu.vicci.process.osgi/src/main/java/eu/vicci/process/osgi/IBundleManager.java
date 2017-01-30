package eu.vicci.process.osgi;

import java.util.List;

public interface IBundleManager {
	
	public String installBundle(String bundlejar); //TODO: upload jar-file via XML-RPC
	
	public void startBundle(Long bundleid);
	
	public void stopBundle(Long bundleid);
	
	public void removeBundle(Long bundleid);
	
	public List<String> listInstalledBundles();
	
	public List<String> listRunningBundles();

}
