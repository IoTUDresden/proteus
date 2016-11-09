package eu.vicci.process.model.sofiainstance.impl.custom;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.ComplexTypeInstanceImpl;

public class ComplexTypeInstanceImplCustom extends ComplexTypeInstanceImpl {

	@Override
	public DataTypeInstance copy() {
		ComplexTypeInstanceImpl newComplexTypeInstance = new ComplexTypeInstanceImplCustom();
		for (DataTypeInstance instance : this.getSubtypes()) {
			DataTypeInstance subType = instance.copy();
			subType.setBelongsTo(newComplexTypeInstance);
			newComplexTypeInstance.getSubtypes().add(subType);
		}
		newComplexTypeInstance.setDataTypeType(this.getDataTypeType());
		newComplexTypeInstance.setTypeId(this.getTypeId());
		newComplexTypeInstance.setInstanceId(UUID.randomUUID().toString());
		return newComplexTypeInstance;
	}

	@Override
	public String serializeToXML() {
		String serializedType = "<" + getDataTypeType().getName() + ">";
		for (DataTypeInstance subType : getSubtypes()) {
			serializedType = serializedType + subType.serializeToXML();
		}
		serializedType = serializedType + "</" + getDataTypeType().getName()
				+ ">";
		return serializedType;
	}

	@Override
	public void parse(String text) {
		if (text != null && !text.equals("")) {
			deserializeFromXML(text);
		}
	}

	@Override
	public boolean deserializeFromXML(String xmlInstance) {
//		System.out.println("ComplexType.deserialize(): " + xmlInstance);
		
		xmlInstance = removeXmlDeclaration(xmlInstance);
		
		if(xmlInstance.trim().equals("") || xmlInstance== null)return false;
		
		try {

			// initialize DOM utility
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream inStreamTemp = new ByteArrayInputStream(
					xmlInstance.getBytes());
			InputSource inputSourceTemp = new InputSource(inStreamTemp);
			Document dataTypeDOM = db.parse(inputSourceTemp);

			String nodeName = dataTypeDOM.getFirstChild().getNodeName().toLowerCase();
			String localName = getDataTypeType().getName().toLowerCase();
			
			// check if the XML node complies to this DataType
			if (localName.equals(nodeName)) {

				// try to deserialize all sub-nodes
				NodeList subTypes = dataTypeDOM.getFirstChild().getChildNodes();

				for (DataTypeInstance dti : this.getSubtypes()) {
					boolean deserialized = false;
					for (int i = 0; i < subTypes.getLength(); i++) {
						Node n = subTypes.item(i);
						String nodeString = nodeToString(n);
						if(!nodeString.equals("\r\n  ")){
							
							deserialized = dti.deserializeFromXML(nodeString);
						}
						if (deserialized)
							break;
					}
					// a SubDataType had no equivalent in XML the
					// deserialization failed
//					if (!deserialized)
//						return false;

				}
			}

		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
			return false;
		} catch (SAXException e) {
//			e.printStackTrace();
			return false;
		} catch (IOException e) {
//			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void createDummyData(){
		for(DataTypeInstance dti : this.getSubtypes()){
			if(dti instanceof ComplexTypeInstanceImplCustom){
				ComplexTypeInstanceImplCustom ctiic = (ComplexTypeInstanceImplCustom)dti;
				ctiic.createDummyData();
			}else if(dti instanceof BooleanTypeInstanceImplCustom){
				BooleanTypeInstanceImplCustom btiic = (BooleanTypeInstanceImplCustom)dti;
				btiic.createDummyData();
			}else if(dti instanceof DoubleTypeInstanceImplCustom){
				DoubleTypeInstanceImplCustom dtiic = (DoubleTypeInstanceImplCustom)dti;
				dtiic.createDummyData();
			}else if(dti instanceof StringTypeInstanceImplCustom){
				StringTypeInstanceImplCustom stiic = (StringTypeInstanceImplCustom)dti;
				stiic.createDummyData();
			}else if(dti instanceof IntegerTypeInstanceImplCustom){
				IntegerTypeInstanceImplCustom itiic = (IntegerTypeInstanceImplCustom)dti;
				itiic.createDummyData();
			}else if (dti instanceof ListTypeInstanceImplCustom) {
				ListTypeInstanceImplCustom ltiic = (ListTypeInstanceImplCustom) dti;
				ltiic.createDummyData();
			}
			
		}
	}

	private String removeXmlDeclaration(String xml){
//		System.out.println("removeXmlDeclaration() of " + xml);
		if(xml.startsWith("<?xml")){
			xml = xml.substring(xml.indexOf(">")+1);
		}
//		System.out.println("-> " + xml);
		return xml;
		
	}

	private static String nodeToString(Node node) {
		StringWriter sw = new StringWriter();
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.transform(new DOMSource(node), new StreamResult(sw));
		} catch (TransformerException te) {
			System.out.println("nodeToString Transformer Exception");
		}
		return sw.toString();
	}
	
	
	@Override
	public String serializeToJSON() {
		String json="";
		return json;
	}
	
	@Override
	public boolean deserializeFromJSON(String jsonString) {
		boolean success=false;
		return success;
	}
	
	@Override
	public Object getValueAsObject() {
		//avoids unsupported operation exception
		return null;
	}
}
