package eu.vicci.process.model.sofiainstance.impl.custom;

import akka.actor.ActorRef;
import eu.vicci.process.model.sofiainstance.MapeKInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.Compensation;

public class MapeKInstanceImplCustom extends ProcessStepInstanceImplCustom
	implements MapeKInstance {
	
	private Compensation cs = null;
	
	@Override
	public void onDeploy(MappingUtil mapper, ActorRef parent) {
		super.onDeploy(mapper, parent);
		cs = new Compensation();
		cs.deploy();
	}
	
	@Override
	public void work() {
		returnValues = cs.work(startParameter);
	}

}
