package eu.vicci.process.model.sofiainstance.impl.custom;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.osgi.framework.Bundle;

import akka.actor.ActorRef;
import eu.vicci.process.model.implementations.internal.Activator;
import eu.vicci.process.model.sofia.impl.LoadClassStepImpl;
import eu.vicci.process.model.sofiainstance.LoadClassStepInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.ProcessStepWorker;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.ProcessStepWorker.Context;

public class LoadClassStepInstanceImplCustom extends ProcessStepInstanceImplCustom implements LoadClassStepInstance {

	private static final String classLoc = "./processDirectories/aProcessDir/classes/";

	private ProcessStepWorker processStepWorker = null;
	private String delegateName = null;

	@Override
	public void onDeploy(MappingUtil mapper, ActorRef parent) {
		super.onDeploy(mapper, parent);

		delegateName = ((LoadClassStepImpl) getProcessStepType()).getDelegateClassName();
		
		boolean runInOSGI = Activator.getDefault() != null;
		
		if(runInOSGI){
			if(!tryLoadFromBundles())
				throwClassNotFound();
		}
		else
			if(!tryLoadLocal())
				throwClassNotFound();

		// calling generic deployment functionality
		processStepWorker.deploy();
	}

	/**
	 * The work to be done by the ProcessStep.<br>
	 * <br>
	 * Please fill in here all necessary business logic.
	 */
	@Override
	public void work() {
		ProcessStepWorker.Context context = new Context();
		
		context.startParameter = startParameter;
		context.endParameter = endParameter;
		context.instanceId = getInstanceId();
		
		returnValues = processStepWorker.work(context);
	}

	private ClassLoader getClassLoader() {
		File file = new File(classLoc);
		URL[] urls = null;
		try {
			URL url = file.toURI().toURL();
			urls = new URL[] { url };
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		if (urls == null)
			return getClass().getClassLoader();
		return new URLClassLoader(urls);
	}
	
	private boolean tryLoadFromBundles(){
		for (Bundle bundle : Activator.getDefault().getContext().getBundles()) {
			try {
				processStepWorker = (ProcessStepWorker)bundle.loadClass(delegateName).newInstance();
				return true;
			} catch (ClassNotFoundException e) {
				//no problem at this point
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}		
		return false;		
	}

	private boolean tryLoadLocal() {
		ClassLoader cl = getClassLoader();
		try {
			processStepWorker = (ProcessStepWorker) Class.forName(delegateName, true, cl).newInstance();
			return true;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		}
		return false;
	}
	
	private void throwClassNotFound(){
		throw new IllegalStateException("Process Step Worker with delegate '" + delegateName + "' cannot be found.");
	}
}
