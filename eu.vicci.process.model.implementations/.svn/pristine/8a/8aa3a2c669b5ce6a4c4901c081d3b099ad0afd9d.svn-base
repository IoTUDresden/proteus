package eu.vicci.process.model.sofiainstance.impl.custom;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import akka.actor.ActorRef;
import eu.vicci.process.model.sofia.SOAPInvoke;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.EndPortInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.SOAPInvokeInstance;
import eu.vicci.process.model.sofiainstance.util.SOAPWorker;

/**
 * The following jars are required for implementation: from reficio project -
 * soap-client-1.0.0-SNAPSHOT; soap-common-1.0.0-SNAPSHOT;
 * soap-legacy-1.0.0-SNAPSHOT, reficio-legacy (the soap-legacy project packed as
 * an executable jar file; soap-builder-1.0.0-SNAPSHOT
 * 
 * others - httpcore-4.3 httpclient-4.3 com.google.common_1.0.0.201004262004
 * wsdl4j-1.6.2 commons-logging-1.1.1 log4j-1.2.17
 * 
 * @author Reik M�ller
 * 
 */
public class SOAPInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements
		SOAPInvokeInstance {

	private DocumentBuilder db;
	private String returnMessage = null;
	private String exampleMessage = null;
	private SOAPWorker soapWorker = null;

	@Override
	public void onDeploy(MappingUtil mapper, ActorRef parent) {
		super.deploy(mapper);
		SOAPInvoke si = (SOAPInvoke) getProcessStepType();
		soapWorker = new SOAPWorker(si.getServerUri(), si.getWsdlUri(), null, si.getMethodName(),
				100);
		exampleMessage = soapWorker.getDummyRequestString();
	}

	/**
	 * The work to be done by the ProcessStep.<br>
	 * <br>
	 * Please fill in here all necessary business logic.
	 */
	@Override
	public void work() {
		// create request message
		String requestMessage = createRequest();
		// perform SOAP call
		returnMessage = soapWorker.sendRequest(requestMessage);
		System.out.println("����������������������" + returnMessage);
	}

	/**
	 * Activating outgoing data ports.<br>
	 * <br>
	 * This method fills all EndDataPorts with their respective information
	 * simply by matching the names of all items of the field 'returnValue' and
	 * the names of the data fields of all EndDataPorts.
	 */
	public void activateDataEndPorts() {
		for (PortInstance port : ports) {
			DataTypeInstance dataInstance = null;
			if (port instanceof EndPortInstance) {
				if (port instanceof EndDataPortInstance) {
					// try to deserialize the returnMessage with
					// a DataType.
					dataInstance = ((EndDataPortInstance) port).getDataInstance();
					if (dataInstance.deserializeFromXML(returnMessage)) {
						port.activate(dataInstance);
					}
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private String printSOAPResponse(SOAPMessage soapResponse) {

		String value = null;

		try {

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			StringWriter sw = new StringWriter();
			if (soapResponse.getSOAPPart().getFirstChild().getFirstChild().getFirstChild() != null) {
				transformer.transform(new DOMSource(soapResponse.getSOAPPart().getFirstChild()
						.getFirstChild().getFirstChild()), new StreamResult(sw));
				value = sw.toString();
				value = removeXmlDeclaration(value);
				int numberOfEntries = soapResponse.getSOAPPart().getFirstChild().getFirstChild()
						.getFirstChild().getChildNodes().getLength();
				System.out.println("Number of entries: " + numberOfEntries);
				if (numberOfEntries == 1) {
					value = removeRootTag(value);
				}
				value = value.replace("\r\n", "");
				System.out.println("\n Response SOAP Message = " + value);
			} else {
				System.out.println("\n Response SOAP Message -> only acknowledgment?");
			}

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (DOMException e) {
			e.printStackTrace();
		}
		return value;
	}

	private String removeNameSpace(String s) {
		if (s.contains(":")) {
			return s.split(":")[1];
		}
		return s;
	}

	private String createRequest() {
		System.out.println("Build request!");
		String finalRequest = "";
		try {

			SOAPInvoke si = (SOAPInvoke) getProcessStepType();

			// initialize DOM utility
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();

			String operationName = si.getMethodName();

			// create DOM-Model of the example request for
			// inserting parameter values
			InputStream inStream = new ByteArrayInputStream(exampleMessage.getBytes());
			InputSource inputSource = new InputSource(inStream);
			Document exampleRequestDOM = db.parse(inputSource);

			// Selecting the body part
			Node bodyPart = exampleRequestDOM.getElementsByTagName("soapenv:Body").item(0);

			// Selecting the wanted operation
			NodeList operationNodes = bodyPart.getChildNodes();

			for (int i = 0; i < operationNodes.getLength(); i++) {

				String listedOperation = operationNodes.item(i).getNodeName();
				listedOperation = removeNameSpace(listedOperation);

				if (listedOperation.equals(operationName)) {
					// -> wanted Operation found
					// iterating over operation parameters
					NodeList operationParameters = operationNodes.item(i).getChildNodes();

					for (int a = 0; a < operationParameters.getLength(); a++) {
						String xmlName = operationParameters.item(a).getNodeName();
						xmlName = removeNameSpace(xmlName);

						// check for equality of operation parameter
						// names and names of data to send
						for (DataTypeInstance dataType : startParameter) {
							dataType.toString();

							String dataTypeName = dataType.getDataTypeType().getName();

							if (dataTypeName.equals(xmlName)) {
								// -> wanted parameter found
								String dataTypeSerializedToXML = dataType.serializeToXML();
								InputStream inStreamTemp = new ByteArrayInputStream(
										dataTypeSerializedToXML.getBytes());
								InputSource inputSourceTemp = new InputSource(inStreamTemp);
								Document dataTypeDOM = db.parse(inputSourceTemp);

								operationNodes.item(i).removeChild(operationParameters.item(a));

								Node importedNode = exampleRequestDOM.importNode(
										dataTypeDOM.getFirstChild(), true);
								operationNodes.item(i).appendChild(importedNode);
							}
						}
					}
				}
			}

			// print DOM to XML-String
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(exampleRequestDOM), new StreamResult(writer));
			finalRequest = writer.getBuffer().toString();
			// .replaceAll("\n|\r", "");

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n Final Request: " + finalRequest + " end");
		return finalRequest;
	}

	private String removeXmlDeclaration(String xml) {
		// System.out.println("removeXmlDeclaration() of " + xml);
		if (xml.startsWith("<?xml")) {
			xml = xml.substring(xml.indexOf(">") + 1);
		}
		// System.out.println("-> " + xml);
		return xml;

	}

	private String removeRootTag(String xmlIn) {
		// System.out.println("Remove root tag of " + xmlIn);
		String xmlOut = xmlIn.substring(xmlIn.indexOf(">") + 1, xmlIn.lastIndexOf("<"));
		xmlOut = xmlOut.trim();
		// System.out.println("-> " + xmlOut);
		return xmlOut;
	}
}