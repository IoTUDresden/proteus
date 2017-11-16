package eu.vicci.process.model.util.serialization.jsonprocesssteps;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.eclipse.emf.common.util.EList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import eu.vicci.process.model.sofia.Identifiable;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONProcessStep;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class JSONProcessStep implements IJSONProcessStep {
	@JsonDeserialize(contentAs=JSONProcessStep.class)
	public static Map<String, IJSONProcessStep> alreadyDone = new HashMap<String, IJSONProcessStep>();	
	
	private Map<String, Object> fieldMap = new HashMap<String, Object>();
	

	public JSONProcessStep(Identifiable ident) {
//		Class<? extends Identifiable> clss = ident.getClass();
		List<Field> fields = getAllFields(new ArrayList<Field>(), ident.getClass());

		for (Field field : fields) {
			if(fieldMap.containsKey(field.getName()))
					continue;
			field.setAccessible(true);
			Object fieldValue = null;
			try {
				fieldValue = field.get(ident);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(fieldValue == null)
				continue;
			if(fieldValue instanceof Identifiable){
				fieldMap.put(field.getName(), new JSONProcessStep((Identifiable) fieldValue));
				continue;
			}
			if(fieldValue instanceof EList<?>){
				EList<?> elist = (EList<?>) fieldValue;
				List<IJSONProcessStep> list = new ArrayList<IJSONProcessStep>();
				for(Object itemOb : elist){
					Identifiable item = (Identifiable) itemOb;
					IJSONProcessStep putin;
					if(alreadyDone.containsKey(item.getId())){
						putin = alreadyDone.get(item.getId());
					}
					else{
						putin = new JSONProcessStep(item);
					}
					list.add(putin);
				}
				fieldMap.put(field.getName(), list);
				continue;
			}
			
				fieldMap.put(field.getName(), fieldValue);
			
		}
	}
	
	public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
	    fields.addAll(Arrays.asList(type.getDeclaredFields()));

	    if (type.getSuperclass() != null) {
	        fields = getAllFields(fields, type.getSuperclass());
	    }

	    return fields;
	}
}
