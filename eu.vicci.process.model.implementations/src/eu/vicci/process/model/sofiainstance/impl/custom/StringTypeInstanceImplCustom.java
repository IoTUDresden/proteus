package eu.vicci.process.model.sofiainstance.impl.custom;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.StringTypeInstanceImpl;

public class StringTypeInstanceImplCustom extends StringTypeInstanceImpl {
	
	@Override
	public DataTypeInstance copy() {
		StringTypeInstanceImplCustom newStringTypeInstance = new StringTypeInstanceImplCustom();
		if(value!=null){
			newStringTypeInstance.setValue(String.copyValueOf(value.toCharArray()));
		}else{
			newStringTypeInstance.setValue("");//TODO Back to null
		}
		
		newStringTypeInstance.setDataTypeType(getDataTypeType());
		newStringTypeInstance.setTypeId(getTypeId());
		newStringTypeInstance.setInstanceId(UUID.randomUUID().toString());
		return newStringTypeInstance;
	}

	@Override
	public void parse(String text) {
		this.value = text;
	}

	@Override
	public String serializeToXML() {
		String xml = "";
		if(this.getDataTypeType().getBelongsTo()== null){
			xml = "<?xml version='1.0' encoding='UTF-8'?>";
		}
		xml = xml + "<"
				+ this.getDataTypeType().getName() + ">" + this.getValue()
				+ "</" + this.getDataTypeType().getName() + ">";
		return xml;
	}

	@Override
	public boolean deserializeFromXML(String xmlInstance) {
	//	System.out.println("StringTypeInst.deserialize()" + xmlInstance);
		try {
			if(xmlInstance.trim().equals(""))return false;
			xmlInstance = removeXmlDeclaration(xmlInstance);

			// initialize DOM utility
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			InputStream inStreamTemp = new ByteArrayInputStream(
					xmlInstance.getBytes());
			InputSource inputSourceTemp = new InputSource(inStreamTemp);
			Document dataTypeDOM = db.parse(inputSourceTemp);

			String nodeName = dataTypeDOM.getFirstChild().getNodeName();
			String localName = getDataTypeType().getName();
			
			// check if the XML node complies to this DataType
			if (localName.equals(nodeName))  {
				// parse value
				parse(dataTypeDOM.getFirstChild().getTextContent());
			} else {
				return false;
			}
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
	
	public void createDummyData(){
		parse(UUID.randomUUID().toString());
	}

	private String removeXmlDeclaration(String xml){
//		System.out.println("removeXmlDeclaration() of " + xml);
		if(xml.startsWith("<?xml")){
			xml = xml.substring(xml.indexOf(">")+1);
		}
//		System.out.println("-> " + xml);
		return xml;
		
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public String serializeToJSON() {
		String json="'"+this.getDataTypeType().getName()+"': '"+this.getValue()+"'";
		json = json.replace("'", "\"");
		return json;
	}
	
	@Override
	public boolean deserializeFromJSON(String jsonString) {
		boolean success=false;
		int pos=jsonString.indexOf("\"")+1;
		int pos2=jsonString.indexOf(":")-1;
		String name = jsonString.substring(pos, pos2);
		if (name.equals(this.getDataTypeType().getName())) {
			success=true;
			Gson gson = new Gson();
			String value = gson.fromJson(jsonString, String.class);
			this.value=value;
		}
		return success;
	}
	
	/**
	 * Small hack to enable deserializing of openhab2 rest informations, provided by json strings.
	 * Maybe this can be reused for general deserialization.
	 * 
	 * Asigns the returned json to the new value. At the moment no arrays (groups) are supported.
	 * Use the direct link to the openhab channel of the item, <br>
	 * eg.  http://localhost:8080/rest/items/yahooweather_weather_74686d3a_temperature
	 * 
	 * @param jsonString
	 * @return
	 */
	public boolean deserializeFromOpenHabJason(String jsonString){
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(jsonString).getAsJsonObject();
		if(obj == null || obj.isJsonNull())
			return false;
		
		JsonElement element = obj.get(dataTypeType.getName());
		if(element == null || element.isJsonNull() || !element.isJsonPrimitive())
			return false;
		
		value = element.getAsString();
		return true;		
	}
	
	@Override
	public String getValueAsObject() {
		return this.value;
	}
	
	@Override
	public void setValueFromString(String value) {
		this.value = value;
	}
	
	@Override
	public int compareTo(EObject o) {
		StringTypeInstance other = (StringTypeInstance)o;
		return getValue().compareTo(other.getValue());
	}
}
