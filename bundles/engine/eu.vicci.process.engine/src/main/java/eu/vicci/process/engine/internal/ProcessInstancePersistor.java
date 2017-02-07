package eu.vicci.process.engine.internal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONProcessStepInstanceSerializer;

public class ProcessInstancePersistor {
	private final IProcessManagerInternal processManager;
	private final IProcessManager publicManager;
	
	public ProcessInstancePersistor(IProcessManagerInternal processManager, IProcessManager publicManager) {
		this.processManager = processManager;	
		this.publicManager = publicManager;
	}
	
	public synchronized String persistInstance(ProcessInstance pi) {		
		String path = "./processes/instances/"+pi.getInstanceId()+".sofiainstance";
		Path filepath = FileSystems.getDefault().getPath(path);
		String serialized = JSONProcessStepInstanceSerializer.serialize(pi);
		
		try {
			Files.write(filepath, serialized.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		processManager.getPersistedinstances().put(pi.getInstanceId(), path);
		
		return path;
	}
	
	public synchronized ProcessInstance readPersistedInstance(String instanceId) {
		String path = processManager.getPersistedinstances().get(instanceId);
		File file = new File(path);
		FileReader fr;
		String stream = "";
		try {
			fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			stream = reader.readLine(); 
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ProcessInstance pi = (ProcessInstance)JSONProcessStepInstanceSerializer.deserialize(stream, SofiaInstanceFactoryImplCustom.getInstance());
		Process p = publicManager.getProcessInfos(pi.getProcessModelID());
		
		pi.setProcessStepType(p);
		return pi;
	}
	
}
