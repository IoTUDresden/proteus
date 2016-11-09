package eu.vicci.process.model.sofiainstance.impl.custom;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;
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

import com.google.gson.Gson;

import eu.vicci.process.model.sofia.ListType;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.ListTypeInstanceImpl;

public class ListTypeInstanceImplCustom extends ListTypeInstanceImpl {

	private String xmlRootTagName = null;

	@Override
	public DataTypeInstance copy() {
		ListTypeInstance newListTypeInstance = new ListTypeInstanceImplCustom();
		for (DataTypeInstance instance : this.getSubtypes()) {
			DataTypeInstance subType = instance.copy();
			subType.setBelongsTo(newListTypeInstance);
			newListTypeInstance.getSubtypes().add(subType);
		}
		newListTypeInstance.setDataTypeType(this.getDataTypeType());
		newListTypeInstance.setTypeId(this.getTypeId());
		newListTypeInstance.setInstanceId(UUID.randomUUID().toString());
		newListTypeInstance.setCollectionItemType(this.getCollectionItemType());
		return newListTypeInstance;
	}

	@Override
	public String serializeToXML() {
		String xml = "";
		if (this.getDataTypeType().getBelongsTo() == null) {
			xml = "<?xml version='1.0' encoding='UTF-8'?>";
		}
		if (xmlRootTagName == null) {
			if (!getSubtypes().isEmpty()) {
				xmlRootTagName = getSubtypes().get(0).getDataTypeType()
						.getName()
						+ "es";
			} else {
				xmlRootTagName = "root";
			}
		}
		xml = xml + "<" + xmlRootTagName + ">";
		for (DataTypeInstance subType : getSubtypes()) {
			xml = xml + subType.serializeToXML();
		}
		xml = xml + "</" + xmlRootTagName + ">";
		return xml;
	}

	@Override
	public void parse(String text) {
		if (text != null && !text.equals("")) {
			deserializeFromXML(text);
		}
	}

	@Override
	public boolean deserializeFromXML(String xmlInstance) {
		// System.out.println("ComplexType.deserialize(): " + xmlInstance);

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

//			xmlRootTagName = dataTypeDOM.getFirstChild().getNodeName()
//					.toLowerCase();

			// try to deserialize all sub-nodes
			NodeList subTypes = dataTypeDOM.getFirstChild()
					.getChildNodes();

			for (int i = 0; i < subTypes.getLength(); i++) {
				ListType lt = (ListType) this.getDataTypeType();
				MappingUtilImplCustom mappingUtil = new MappingUtilImplCustom();
				DataTypeInstance newDTI = mappingUtil.mapDataType(lt
						.getCollectionItemType());

				Node n = subTypes.item(i);
				if(newDTI.deserializeFromXML(nodeToString(n))){
					this.getSubtypes().add(newDTI);
				}
			}
			// a SubDataType had no equivalent in XML the
			// deserialization failed
			// if (!deserialized)
			// return false;

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return false;
		} catch (SAXException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void createDummyData() {
		for (DataTypeInstance dti : this.getSubtypes()) {
			if (dti instanceof ComplexTypeInstanceImplCustom) {
				ComplexTypeInstanceImplCustom ctiic = (ComplexTypeInstanceImplCustom) dti;
				ctiic.createDummyData();
			} else if (dti instanceof BooleanTypeInstanceImplCustom) {
				BooleanTypeInstanceImplCustom btiic = (BooleanTypeInstanceImplCustom) dti;
				btiic.createDummyData();
			} else if (dti instanceof DoubleTypeInstanceImplCustom) {
				DoubleTypeInstanceImplCustom dtiic = (DoubleTypeInstanceImplCustom) dti;
				dtiic.createDummyData();
			} else if (dti instanceof StringTypeInstanceImplCustom) {
				StringTypeInstanceImplCustom stiic = (StringTypeInstanceImplCustom) dti;
				stiic.createDummyData();
			} else if (dti instanceof IntegerTypeInstanceImplCustom) {
				IntegerTypeInstanceImplCustom itiic = (IntegerTypeInstanceImplCustom) dti;
				itiic.createDummyData();
			} else if (dti instanceof ListTypeInstanceImplCustom) {
				ListTypeInstanceImplCustom ltiic = (ListTypeInstanceImplCustom) dti;
				ltiic.createDummyData();
			}
		}
	}

	private String removeXmlDeclaration(String xml) {
		System.out.println("removeXmlDeclaration() of " + xml);
		if (xml.startsWith("<?xml")) {
			xml = xml.substring(xml.indexOf(">") + 1);
		}
		System.out.println("-> " + xml);
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
		int i=0;
		json = json + "{ '" + this.getDataTypeType().getName() + "': [";
		for (DataTypeInstance subType : getSubtypes()) {
			i++;
			String subjson = subType.serializeToJSON();
			if (i==getSubtypes().size()) {
				json = json + subjson;	
			} else {
				json = json + subjson + ",";
			}
		}
		json = json + "]}";
		json = json.replace("'", "\"");
		return json;
	}
	
	@SuppressWarnings({"unused", "rawtypes"})
	@Override
	public boolean deserializeFromJSON(String jsonString) {
		boolean success=false;
		int pos=jsonString.indexOf("\"")+1;
		int pos2=jsonString.indexOf(":")-1;
		String name = jsonString.substring(pos, pos2);
		if (name.equals(this.getDataTypeType().getName())) {
			success=true;
			Gson gson = new Gson();
			List subTypes = gson.fromJson(jsonString, List.class);
		}		
		return success;
	}
	
	@Override
	public Object getValueAsObject() {
		return subtypes;
	}

}
