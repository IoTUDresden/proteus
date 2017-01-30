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

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.IntegerTypeInstanceImpl;

public class IntegerTypeInstanceImplCustom extends IntegerTypeInstanceImpl{
	
	@Override
	public DataTypeInstance copy() {
		IntegerTypeInstanceImplCustom newIntegerTypeInstance = new IntegerTypeInstanceImplCustom();
		newIntegerTypeInstance.setValue(value);
		newIntegerTypeInstance.setTypeId(getTypeId());
		newIntegerTypeInstance.setDataTypeType(getDataTypeType());
		newIntegerTypeInstance.setInstanceId(UUID.randomUUID().toString());
		newIntegerTypeInstance.setName(getName());
		return newIntegerTypeInstance;
	}
	
	@Override
	public void parse(String text) {
		this.value = new Integer(text).intValue();
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
		try {		
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
		parse(new Integer(Double.toString(Math.random()*1000)).toString());
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}
	
	@Override
	public String serializeToJSON() {
		String json="'"+this.getDataTypeType().getName()+"': "+this.getValue();
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
			int value = gson.fromJson(jsonString, Integer.class);
			this.value=value;
		}
		return success;
	}
	
	@Override
	public Integer getValueAsObject() {
		return this.value;
	}
	
	@Override
	public void setValueFromString(String value) {
		this.value = Integer.parseInt(value);
	}
	
	@Override
	public int compareTo(EObject o)	{
		IntegerTypeInstance other = (IntegerTypeInstance)o;
		return getValueAsObject().compareTo(other.getValue());
	}
}
