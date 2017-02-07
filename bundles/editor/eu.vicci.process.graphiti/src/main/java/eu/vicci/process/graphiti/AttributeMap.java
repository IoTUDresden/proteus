package eu.vicci.process.graphiti;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.graphiti.mm.MmFactory;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Text;

public class AttributeMap {

    private static AttributeMap _instance = null;
    private Map<Object, Map<String, Text>> _map = null;

    private AttributeMap() {

        _map = new HashMap<Object, Map<String, Text>>();
    }

    public static AttributeMap instance() {

        if (_instance == null)
            _instance = new AttributeMap();

        return _instance;
    }

    public Map<String, Text> getObjectMap(Object object) {

        return _map.get(object);
    }

    public boolean addObjectMapItem(Object object, String key, Text value) {

        return addObjectMapItem(object, key, value, true);
    }

    public boolean addObjectMapItem(Object object, String key, Text value, boolean addProperty) {

        Map<String, Text> map = null;
        if (_map.containsKey(object))
            map = _map.get(object);
        else {
            map = new TreeMap<String, Text>();
            _map.put(object, map);
        }

        if (addProperty) {
            Property prop = MmFactory.eINSTANCE.createProperty();
            prop.setKey("name");
            prop.setValue(key);
            value.getProperties().add(prop);
        }
        map.put(key, value);

        return true;
    }

    public void clear() {

        _map.clear();
    }
}
