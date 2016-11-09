package eu.vicci.process.model.sofiainstance.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcSunHttpTransportFactory;

import eu.vicci.process.model.sofia.XMLRPCInvoke;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

@SuppressWarnings({"rawtypes", "unchecked"})
public class XMLRPCInvokeWorker {
	
	XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
	static XmlRpcClient client = new XmlRpcClient();
	private List<DataTypeInstance> returnedValues = new LinkedList<DataTypeInstance>();
	
	public List<DataTypeInstance> work(ProcessStepInstance xsi) {
		
		XMLRPCInvoke inv = (XMLRPCInvoke) xsi.getProcessStepType();
		Vector params = new Vector();

		// Assuming only simple types at startdataports,
		// sequence is in attribute parameterSequence!
		// Ex.: startParameterSequence =
		// port1name;port2name;port3name
		// Assuming process modeller knows signature of service
		// call

		// TODO: this is nasty, better way?
		
		for (PortInstance pi : xsi.getPorts()) {
			if (pi instanceof StartDataPortInstance) {
				StartDataPortInstance sdpi = (StartDataPortInstance)pi;
				DataTypeInstance dti = sdpi.getDataInstance(); 
				if (dti instanceof StringTypeInstance) {
					StringTypeInstance sti = (StringTypeInstance) dti;
					params.add(new String(sti.getValue()));
				} else if (dti instanceof IntegerTypeInstance) {
					IntegerTypeInstance iti = (IntegerTypeInstance) dti;
					params.add(new Integer(iti.getValue()));
				} else if (dti instanceof DoubleTypeInstance) {
					DoubleTypeInstance doti = (DoubleTypeInstance) dti;
					params.add(new Double(doti.getValue()));
				} else if (dti instanceof BooleanTypeInstance) {
					BooleanTypeInstance bti = (BooleanTypeInstance) dti;
					params.add(new Boolean(bti.isValue()));
				}
			}	
		
		}

		Vector result = null;
		
		try {
			// create configuration
			config.setServerURL(new URL(inv.getServerUri()));
			config.setEnabledForExtensions(true);
			config.setConnectionTimeout(60 * 1000);
			config.setReplyTimeout(60 * 1000);
			// use Commons HttpClient as transport
			client.setTransportFactory(new XmlRpcSunHttpTransportFactory(client));
			// set configuration
			client.setConfig(config);
			
			result = (Vector) client.execute(inv.getMethodName(), params);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
		
		String endParameterSequence = inv.getEndParameterSequence();
		List<String> endParameters = new ArrayList<String>();
		// TODO what happen if transferred data consists of ";"?
		Collections.addAll(endParameters,
				endParameterSequence.split(";"));

		for (int i = 0; i < result.size(); i++) {
			for (PortInstance portie : xsi.getPorts()) {
				if (portie instanceof EndDataPortInstance) {
					EndDataPortInstance porte = (EndDataPortInstance)portie;
					if (porte.getPortType().getName()
							.equals(endParameters.get(i))) {
						DataTypeInstance dti = ((DataPortInstance) porte)
								.getDataInstance();
						if (dti instanceof StringTypeInstance) {
							StringTypeInstance sti = (StringTypeInstance) dti;
							String str = (String) result.get(i);
							sti.setValue(str);
							porte.setDataInstance(sti);
						} else if (dti instanceof IntegerTypeInstance) {
							IntegerTypeInstance iti = (IntegerTypeInstance) dti;
							Integer integ = (Integer) result
									.get(i);
							iti.setValue(integ);
							porte.setDataInstance(iti);
						} else if (dti instanceof DoubleTypeInstance) {
							DoubleTypeInstance doti = (DoubleTypeInstance) dti;
							Double doub = (Double) result
									.get(i);
							doti.setValue(doub);
							porte.setDataInstance(doti);
						} else if (dti instanceof BooleanTypeInstance) {
							BooleanTypeInstance bti = (BooleanTypeInstance) dti;
							Boolean bool = (Boolean) result
									.get(i);
							bti.setValue(bool);
							porte.setDataInstance(bti);
						}
					}
				}
			}
		}
		
		for (PortInstance pi : xsi.getPorts()) {
			if (pi instanceof EndDataPortInstance) {
				EndDataPortInstance edpi = (EndDataPortInstance)pi;
				DataTypeInstance dti = edpi.getDataInstance();
				returnedValues.add(dti);
			}
		}
		
		return returnedValues;
		
	}

}
