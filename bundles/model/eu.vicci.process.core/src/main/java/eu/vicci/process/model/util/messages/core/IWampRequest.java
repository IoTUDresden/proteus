package eu.vicci.process.model.util.messages.core;

public interface IWampRequest extends IWampMessage {

	boolean isResponded();

	void setResponded(boolean responded);

}