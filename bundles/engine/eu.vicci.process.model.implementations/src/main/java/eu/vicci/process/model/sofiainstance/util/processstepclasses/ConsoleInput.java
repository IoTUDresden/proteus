package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public class ConsoleInput implements ProcessStepWorker{

	@Override
	public void deploy() {
		System.out.println("A ProcessStepWorker-Class was deployed by a generic ProcessStep and says: 'Hello, I am a CONSOLE-INPUT!'");		
	}

	@Override
	public List<DataTypeInstance> work(Context context) {
		System.out.println("ConsoleInput says: 'please enter something:'");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String zeile = null;
		try {
			zeile = console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(DataTypeInstance s : context.startParameter){
			s.parse(zeile);
		}
		
		return context.startParameter;
	}

}