package eu.vicci.process.wampserver.handlers;

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.xml.sax.InputSource;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.util.ExecuteProcessStepRequest;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONProcessStepInstanceSerializer;
import ws.wamp.jawampa.Request;

/**
 * @deprecated seems this is not used so we will drop this in the future.
 */
@Deprecated
public class ExecuteProcessStepServerHandler extends AbstractRpcHandlerManageable {

	public ExecuteProcessStepServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		
		ExecuteProcessStepRequest epsr = convertFromJson(t.arguments().get(0), ExecuteProcessStepRequest.class);
		String modelString = epsr.getProcessStepModel();
		
		XMLResourceImpl res = new XMLResourceImpl();
		
		try {
			res.load(new InputSource(new StringReader(modelString)),null);
		} catch (IOException e) {
//			e.printStackTrace();
		}
		
		ProcessStep ps = (ProcessStep)res.getContents().get(0);
		ProcessStepInstance psi = JSONProcessStepInstanceSerializer.deserialize(epsr.getProcessStepInstance(), SofiaInstanceFactoryImplCustom.getInstance());
		String modelStepId = psi.getModelID();
		ProcessStep psexec=ps;
		if (ps instanceof CompositeStep) {
			CompositeStep cs = (CompositeStep)ps;
			for (ProcessStep pssub : cs.getSubSteps()) {
				if (pssub.getId().equals(modelStepId)) {
					psexec = pssub;
					psi.setProcessStepType(pssub);					
				}
			}
		}		
		ProcessStepInstance psidone = processManager.executeProcessStep(psi,psexec,epsr.isAlreadyExecuting());
		String psidoneString = JSONProcessStepInstanceSerializer.serialize(psidone);
		t.reply(psidoneString);		
	}

}
