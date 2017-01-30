package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.List;

import eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;

/**
 * Custom implementation for sending commands to openhab, with the help of a semantic select statement.
 * This class extends the functionality provided by {@link OpenHabSemanticResultSetReceiverInvokeInstanceImplCustom},
 * so the result of a select can also be present on the dataendports of this process step.
 * 
 * At the moment there is no check if the command was correctly received by the openhab item, 
 * or if selected items even exists or can receive the given command.
 * 
 * @author André Kühnert
 *
 */
public class OpenHabSemanticCommandInvokeInstanceImplCustom extends OpenHabSemanticResultSetReceiverInvokeInstanceImplCustom
implements OpenHabSemanticCommandInvokeInstance {
	
	private String command;
	
	@Override
	public void work() {
		if(!fillPrivateMembersAndStartClient(startParameter))
			return;
		queryResult = client.postCommandSemantic(query, command, withLatest);
		client.close();		
	}	
	
	@Override
	protected boolean fillPrivateMembers(List<DataTypeInstance> startParameter) {
		if(!super.fillPrivateMembers(startParameter))
			return false;
		if (!(getProcessStepType() instanceof OpenHabSemanticCommandInvoke)) {
			LOGGER.error("OpenHabSemanticCommandInvoke cannot be mapped");
			return false;
		}
		OpenHabSemanticCommandInvoke openhab = (OpenHabSemanticCommandInvoke) getProcessStepType();
		command = replacePlaceholder(openhab.getCommand(), startParameter);
		return true;
	}

}
