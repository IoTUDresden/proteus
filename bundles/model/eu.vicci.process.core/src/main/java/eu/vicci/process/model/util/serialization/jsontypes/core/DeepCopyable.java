package eu.vicci.process.model.util.serialization.jsontypes.core;

public interface DeepCopyable {
	
	/**
	 * Makes a deep copy of the object
	 * @return
	 */
	Object makeCopy();

}
