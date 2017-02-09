package eu.vicci.process.server.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;

public class Util {
	
	
	/**
	 * Tries to get the IP, with the Filter specified in the config.
	 * E.g. Filter 192.168, will return the first IP match which starts with 192.168.
	 * 
	 * If no filter is specified, the value of <code>Inet4Address.getLocalHost().getHostAddress()</code> is returned.
	 * 
	 * @return null if no IP was found
	 */
	public static String getLocalIpWithFilter(){
		String filter = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.IP_FILTER);
		String ip = null;
		
		try {
			ip = loopIpAddresses(filter);
		} catch (UnknownHostException | SocketException e) {
			e.printStackTrace(); //if no IP was found, the error is handled on an other point
		}
		return ip;
	}
	
	private static String loopIpAddresses(String filter) throws UnknownHostException, SocketException {
		if(filter == null || filter.isEmpty()) return Inet4Address.getLocalHost().getHostAddress();
		
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while(e.hasMoreElements())
		{
		    NetworkInterface n = e.nextElement();
		    Enumeration<InetAddress> ee = n.getInetAddresses();
		    while (ee.hasMoreElements())
		    {
		        InetAddress i = ee.nextElement();
		        String candidate = i.getHostAddress();
		        if(candidate.startsWith(filter))
		        	return candidate;
		    }
		}
		return null;
	}

}
