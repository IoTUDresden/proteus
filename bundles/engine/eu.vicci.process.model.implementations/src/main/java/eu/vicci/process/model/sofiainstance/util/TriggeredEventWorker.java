package eu.vicci.process.model.sofiainstance.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;

import eu.vicci.process.model.cep.EsperManager;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;

/**
 * The worker blocks till the event which is specified in the EPL statement is received.
 * If there are any enddataports, values which are received by the event are get and
 * datatypeinstances are created.
 * 
 * To receive a value, the endport must have a datatype, which name equals the var in the
 * select (e.g. datatype name = 'value', epl stmt = select value from...).
 * 
 * The datatype should be the type of the value you want to receive (e.g. value is double -> DoubleType for the port)
 * 
 * @author André Kühnert
 *
 */
public class TriggeredEventWorker {
	private final static Logger logger = LoggerFactory.getLogger(TriggeredEventWorker.class);
	private final static String SELECT = "select";
	private final static String FROM = "from";

	private final static String PLACEHOLDER_START = "<{";
	private final static String PLACEHOLDER_END = "}>";
	private final static String MISSING_END = "The given EPL statement contains the start tag for a placeholder "
			+ "but no endtag. Check the epl statement! \nStatement: '%s'";
	private final static String MISSING_VALUE = "A value for the placeholder name '%s' can not be found. "
			+ "The EPL statement wont compile!";

	private final static String MISSING_FIELD = "The field '{}' was not found in the epl statement (select). "
			+ "It is possible that the enport '{}' is never activated.";

	private final static String MISSING_TYPE = "The datatype of a port should not be empty. Check your process model!";

	private CountDownLatch eventTriggeredLatch = new CountDownLatch(1);
	private EventBean[] newData = null;
	private EPStatement stmt = null;

	/**
	 * Blocks till a Event matches the given EPL Stmt
	 * 
	 * @param eplStatement
	 * @return
	 */
	public List<DataTypeInstance> work(String eplStatement, List<DataTypeInstance> startParameter,
			List<EndDataPortInstance> endports) {
		String replacedEpl = replacePlaceholder(eplStatement, startParameter);
		stmt = EsperManager.getInstance().addEPLStatement(replacedEpl, this);

		try {
			eventTriggeredLatch.await();
//			stmt.removeAllListeners();
		} catch (InterruptedException e1) {
			logger.error("waiting for event was interrupted");
			e1.printStackTrace();
			return null;
		}

		return getReturnedValues(replacedEpl, endports);
	}

	/**
	 * Activate this worker if the event occurs.
	 * 
	 * @param newData
	 * @param oldData
	 */
	public void activate(EventBean[] newData, EventBean[] oldData) {

		// TODO all listeners are removed. what happens when the same stmt (string
		// representation) is used in different process steps? are they also removed?
		EsperManager.getInstance().removeEPLStatement(stmt);

		// TODO this should be threading safe but their is maybe a better way to set the
		// local vars in a threadsafe way and only once (the processstep should use the
		// values
		// from the first event)
		safeSetNewData(newData);
		eventTriggeredLatch.countDown();
	}

	/**
	 * Unregister all listeners on the encapsulated epl stmt. Reset all local vars.
	 */
	public void reset() {
		eventTriggeredLatch = new CountDownLatch(1);
		newData = null;
		if (stmt != null)
			EsperManager.getInstance().removeEPLStatement(stmt);
		stmt = null;
	}

	private synchronized void safeSetNewData(EventBean[] received) {
		if (newData == null)
			newData = received;
	}

	private List<DataTypeInstance> getReturnedValues(String eplStmt, List<EndDataPortInstance> endports) {
		List<DataTypeInstance> returnedValues = new LinkedList<DataTypeInstance>();
		if (newData == null || newData.length == 0)
			return returnedValues;
		List<String> selection = getSelection(eplStmt);

		for (EndDataPortInstance endport : endports)
			addToListIfMatches(endport, selection, returnedValues);
		return returnedValues;
	}

	private void addToListIfMatches(EndDataPortInstance endport, List<String> selection,
			List<DataTypeInstance> returnedValues) {
		
		DataTypeInstance dti = endport.getDataInstance();
		if (dti == null)
			throw new IllegalArgumentException(MISSING_TYPE);
		
		String name = dti.getDataTypeType().getName();

		// TODO implement a case if there is select *
		if (!selection.contains(name)) {
			logger.warn(MISSING_FIELD, name, endport.getName());
			return;
		}

		Object value = newData[0].get(name);
		
		if (value == null) {
			logger.error("The value received by the select was NULL. DataInstance can not be created!");
			return;
		}
		
		dti.parse(value.toString());		
		returnedValues.add(dti);
	}

	private static List<String> getSelection(String eplStmt) {
		List<String> selections = new ArrayList<String>();
		String lowerString = eplStmt.toLowerCase();
		int start = lowerString.indexOf(SELECT);
		int end = lowerString.indexOf(FROM);
		String tmp = eplStmt.substring(start + SELECT.length(), end);
		String[] split = tmp.split(",");

		for (String string : split)
			selections.add(string.trim());
		return selections;
	}

	private static String replacePlaceholder(String eplStmt, List<DataTypeInstance> startParameter) {
		if (!eplStmt.contains(PLACEHOLDER_START))
			return eplStmt;
		int start = eplStmt.indexOf(PLACEHOLDER_START);
		int end = eplStmt.indexOf(PLACEHOLDER_END);
		if (end < 0)
			throw new IllegalArgumentException(String.format(MISSING_END, eplStmt));
		String name = eplStmt.substring(start + PLACEHOLDER_START.length(), end);
		String trimmedName = name.trim();
		Object value = getValueForPlaceholder(trimmedName, startParameter);
		if (value == null)
			throw new IllegalArgumentException(String.format(MISSING_VALUE, trimmedName));
		String newEpl = eplStmt.replace(PLACEHOLDER_START + name + PLACEHOLDER_END, value.toString());

		// recursive replacement
		return replacePlaceholder(newEpl, startParameter);
	}

	// gets a value from a datatypeinstance which name equals the placeholder name
	private static Object getValueForPlaceholder(String name, List<DataTypeInstance> startParameter) {
		Optional<DataTypeInstance> valueHolder = startParameter.stream()
				.filter(d -> d.getName().equals(name)).findFirst();
		if (valueHolder.isPresent())
			return valueHolder.get().getValueAsObject();
		return null;
	}
}
