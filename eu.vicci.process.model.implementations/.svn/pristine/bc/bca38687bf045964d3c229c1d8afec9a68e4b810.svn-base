package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance;

/**
 * Process Step for executing a select query on the openhab semantic layer.
 * This class extends the functionality provided by {@link OpenHabSemanticResultSetReceiverInvokeInstanceImplCustom},
 * so the result of a select can also be present on the dataendports of this process step.
 * 
 * @author André Kühnert
 *
 */
public class OpenHabSemanticSelectInvokeInstanceImplCustom extends
		OpenHabSemanticResultSetReceiverInvokeInstanceImplCustom implements OpenHabSemanticSelectInvokeInstance {

	@Override
	public void work() {
		if (!fillPrivateMembersAndStartClient(startParameter))
			return;
		queryResult = client.executeSelect(query, withLatest);
		client.close();
	}
}
