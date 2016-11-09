package eu.vicci.process.engine.core;

import eu.vicci.process.client.core.AbstractClientBuilder;

/**
 * this factory creates a new {@link AbstractClientBuilder}
 */
public interface ClientBuilderFactory {
	
	/**
	 * Creates a new instance of a {@link AbstractClientBuilder}
	 * @return
	 */
	AbstractClientBuilder createClientBuilder();

}
