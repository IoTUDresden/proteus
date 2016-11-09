package eu.vicci.process.client.core;

public abstract class AbstractClientBuilder {	
	protected String ip;
	protected String port;
	protected String name = "Process Engine Client";
	protected String namespace;
	protected String realmName;
	protected boolean isServer;
	
	public AbstractClientBuilder() {
	}
	
	public AbstractClientBuilder withIp(String ip){
		this.ip = ip;
		return this;
	}
	
	public AbstractClientBuilder withPort(String port){
		this.port = port;	
		return this;
	}
	
	public AbstractClientBuilder withName(String name){
		this.name = name;
		return this;
	}
	
	public AbstractClientBuilder withNamespace(String namespace){
		this.namespace = namespace;
		return this;
	}

	public AbstractClientBuilder withRealmName(String realmName){
		this.realmName = realmName;
		return this;
	}
	
	public AbstractClientBuilder isServer(boolean value){
		this.isServer = value;
		return this;
	}
	
	public abstract IProcessEngineClient build();
	
	public abstract AbstractClientBuilder fromConfig(IConfigurationReader configReader);

}
