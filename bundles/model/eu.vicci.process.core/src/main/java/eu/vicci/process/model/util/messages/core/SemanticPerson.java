package eu.vicci.process.model.util.messages.core;

public final class SemanticPerson {

    private String firstName;
    private String uid;
    
    public SemanticPerson() {
	}

    public SemanticPerson(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUid() {
        return uid;
    }
    
    public void setUid(String uid){
    	this.uid = uid;
    }
}
