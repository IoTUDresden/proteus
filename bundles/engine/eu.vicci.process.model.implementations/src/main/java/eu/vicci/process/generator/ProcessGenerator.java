package eu.vicci.process.generator;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.EndControlPort;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.MapeK;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.StartControlPort;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.sofia.Transition;

public class ProcessGenerator {
	
	public static Process generateProcessStub(String name, String description, String type) {
		
		Process p = SofiaFactory.eINSTANCE.createProcess();
		p.setName(name);
		p.setDescription(description);
		p.setType(type);
		p.setId(EcoreUtil.generateUUID());
		
		StartControlPort scp = SofiaFactory.eINSTANCE.createStartControlPort();
		scp.setId(EcoreUtil.generateUUID());
		scp.setName("cps1");
		EndControlPort ecp = SofiaFactory.eINSTANCE.createEndControlPort();
		ecp.setId(EcoreUtil.generateUUID());
		ecp.setName("cpe1");
		p.getPorts().add(scp);
		p.getPorts().add(ecp);
		
		return p;
	}
	
	public static Process generateMapeKProcess(String goal, String originalId, String wfName) {
		
		Process p = generateProcessStub("mapek-for-"+originalId, "MAPE-K control process", "controlprocess");
		MapeK mp = SofiaFactory.eINSTANCE.createMapeK();
		mp.setId(EcoreUtil.generateUUID());
		p.getSubSteps().add(mp);
		StartControlPort scp = SofiaFactory.eINSTANCE.createStartControlPort();
		scp.setId(EcoreUtil.generateUUID());
		scp.setName("Feedback Loop");
		EndControlPort ecp = SofiaFactory.eINSTANCE.createEndControlPort();
		ecp.setId(EcoreUtil.generateUUID());
		ecp.setName("mape-ecp");
		mp.getPorts().add(scp);
		mp.getPorts().add(ecp);
		Transition ts1 = SofiaFactory.eINSTANCE.createTransition();
		ts1.setId(EcoreUtil.generateUUID());
		ts1.setName("ts1");
		scp.setInTransitions(ts1);
		Transition ts2 = SofiaFactory.eINSTANCE.createTransition();
		ts2.setId(EcoreUtil.generateUUID());
		ts2.setName("ts2");
		ecp.getOutTransitions().add(ts2);
		
		for (Port port : p.getPorts()) {
			if (port instanceof StartControlPort) {
				StartControlPort scp1 = (StartControlPort)port;
				scp1.getOutTransitions().add(ts1);
				ts1.setSourcePort(port);
			} else if (port instanceof EndControlPort) {
				EndControlPort ecp1 = (EndControlPort)port;
				ecp1.setInTransitions(ts2);
				ts2.setTargetPort(ecp1);
			}
		}
		
		StringType stgoal = SofiaFactory.eINSTANCE.createStringType();
		stgoal.setId(EcoreUtil.generateUUID());
		stgoal.setName("Goal");
		p.getDataTypeDefinitions().add(stgoal);
		StartDataPort sdpgoal = SofiaFactory.eINSTANCE.createStartDataPort();
		sdpgoal.setOptional(true);
		sdpgoal.setId(EcoreUtil.generateUUID());
		sdpgoal.setName("goal");
		sdpgoal.setValue(goal);
		sdpgoal.setPortDatatype(stgoal);
		mp.getPorts().add(sdpgoal);
		
		StringType stwfName = SofiaFactory.eINSTANCE.createStringType();
		stwfName.setId(EcoreUtil.generateUUID());
		stwfName.setName("WorkflowName");
		p.getDataTypeDefinitions().add(stwfName);
		StartDataPort sdpwfName = SofiaFactory.eINSTANCE.createStartDataPort();
		sdpwfName.setOptional(true);
		sdpwfName.setId(EcoreUtil.generateUUID());
		sdpwfName.setName("start_3");
		sdpwfName.setValue(wfName);
		sdpwfName.setPortDatatype(stwfName);
		mp.getPorts().add(sdpwfName);
		
		StringType stcuri = SofiaFactory.eINSTANCE.createStringType();
		stcuri.setId(EcoreUtil.generateUUID());
		stcuri.setName("ContextUri");
		p.getDataTypeDefinitions().add(stcuri);
		StartDataPort sdpcuri = SofiaFactory.eINSTANCE.createStartDataPort();
		sdpcuri.setOptional(true);
		sdpcuri.setId(EcoreUtil.generateUUID());
		sdpcuri.setName("start_4");
		sdpcuri.setValue("http://localhost:9000/contexts/3");	//TODO put into config file
		sdpcuri.setPortDatatype(stcuri);
		mp.getPorts().add(sdpcuri);
		
		StringType stfburi = SofiaFactory.eINSTANCE.createStringType();
		stfburi.setId(EcoreUtil.generateUUID());
		stfburi.setName("FeedbackServiceUri");
		p.getDataTypeDefinitions().add(stfburi);
		StartDataPort sdpfburi = SofiaFactory.eINSTANCE.createStartDataPort();
		sdpfburi.setOptional(true);
		sdpfburi.setId(EcoreUtil.generateUUID());
		sdpfburi.setName("start_2");
		sdpfburi.setValue("http://localhost:9000");		//TODO put into config file
		sdpfburi.setPortDatatype(stfburi);
		mp.getPorts().add(sdpfburi);
		
		BooleanType satis = SofiaFactory.eINSTANCE.createBooleanType();
		satis.setId(EcoreUtil.generateUUID());
		satis.setName("HasBeenSatisfied");
		p.getDataTypeDefinitions().add(satis);
		EndDataPort edpsatis = SofiaFactory.eINSTANCE.createEndDataPort();
		edpsatis.setOptional(true);
		edpsatis.setId(EcoreUtil.generateUUID());
		edpsatis.setName("hasBeenSatisfied");
		edpsatis.setPortDatatype(satis);
		mp.getPorts().add(edpsatis);
		
		BooleanType finis = SofiaFactory.eINSTANCE.createBooleanType();
		finis.setId(EcoreUtil.generateUUID());
		finis.setName("HasBeenFinished");
		p.getDataTypeDefinitions().add(finis);
		EndDataPort edpfinis = SofiaFactory.eINSTANCE.createEndDataPort();
		edpfinis.setOptional(true);
		edpfinis.setId(EcoreUtil.generateUUID());
		edpfinis.setName("hasBeenFinished");
		edpfinis.setPortDatatype(finis);
		mp.getPorts().add(edpfinis);
		
		return p;
		
	}

}
