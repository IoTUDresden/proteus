package eu.vicci.process.model.util.messages.core;

public interface IWampResponse extends IWampMessage{

	String getRequestId();

	void setRequestId(String requestId);

	boolean isCompleted();

	void setCompleted(boolean completed);

}