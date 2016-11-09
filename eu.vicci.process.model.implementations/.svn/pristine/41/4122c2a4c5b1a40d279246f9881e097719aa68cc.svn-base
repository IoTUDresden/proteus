package eu.vicci.process.model.sofiainstance.impl.custom;

import java.net.URI;

import eu.vicci.process.model.sofia.ROSInvoke;
import eu.vicci.process.model.sofiainstance.ROSInvokeInstance;
import eu.vicci.process.model.sofiainstance.util.ROSInvokeWorker;

public class ROSInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements ROSInvokeInstance{

	@Override
	public void work() {
		ROSInvoke inv=null;
		
		if (this.getProcessStepType() instanceof ROSInvoke) {
			inv = (ROSInvoke)this.getProcessStepType();
		}
		URI uri = URI.create("ws://"+inv.getServerUri());				
		ROSInvokeWorker riw = new ROSInvokeWorker(uri);
		riw.connect();
		while (!riw.isConnected()) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		returnValues = riw.work(this);
		riw.close();
	}
}
