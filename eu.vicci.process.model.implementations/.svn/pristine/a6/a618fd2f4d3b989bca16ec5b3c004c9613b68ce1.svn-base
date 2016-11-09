package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public class ConsoleInput implements ProcessStepWorker{

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		System.out.println("ConsoleInput says: 'please enter something:'");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String zeile = null;
		try {
			zeile = console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(DataTypeInstance s : parameter){
			s.parse(zeile);
		}
		
		return parameter;
	}

	@Override
	public void deploy() {
		System.out.println("A ProcessStepWorker-Class was deployed by a generic ProcessStep and says: 'Hello, I am a CONSOLE-INPUT!'");		
	}
}