package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofia.FalseTransition;
import eu.vicci.process.model.sofia.Transition;
import eu.vicci.process.model.sofia.TrueTransition;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

/**
 * Custom Implementation of a semantic ask. Controlendports must contain outgoing true or
 * false transitions. Endports with true transitions are activated if the semantic ask
 * query provides true as result. In this case Endports with outgoing false transition
 * will be deactivated.
 * 
 * Endports with false transitions are activated if the semantic ask
 * query provides false as result. In this case Endports with outgoing true transition
 * will be deactivated.
 * 
 * @author André Kühnert
 *
 */
public class OpenHabSemanticAskInvokeInstanceImplCustom extends OpenHabSemanticInvokeInstanceImplCustom
		implements OpenHabSemanticAskInvokeInstance {

	private boolean askResult;

	@Override
	public void work() {
		if (!fillPrivateMembersAndStartClient(startParameter))
			return;
		askResult = client.executeAsk(query, withLatest);
		client.close();
	}

	/**
	 * If this step executes a ask query, this is like an if-step. E.g. if the ask result
	 * is true, all true transitions will be activated and false transitions deactivated.
	 */
	@Override
	public void activateControlEndPorts() {
		getPorts().stream().filter(port -> port instanceof EndControlPortInstance)
				.forEach(port -> activateEndControlPort((EndControlPortInstance) port));
	}

	// activating control endport if askResult == true
	private void activateEndControlPort(EndControlPortInstance port) {
		if (port.getOutTransitionInstances().size() == 0) {
			LifeCycleManager.INSTANCE.deactivatePort(port);
			return;
		}
		Transition transition = port.getOutTransitionInstances().get(0).getTransitionType();
		if ((askResult && transition instanceof TrueTransition)
				|| (!askResult && transition instanceof FalseTransition))
			LifeCycleManager.INSTANCE.activatePort(port);
		else
			LifeCycleManager.INSTANCE.deactivatePort(port);
	}

}
