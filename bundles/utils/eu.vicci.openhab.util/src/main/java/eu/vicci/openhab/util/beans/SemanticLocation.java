package eu.vicci.openhab.util.beans;

public final class SemanticLocation {
    private String semanticUri;
    private String realLocationName;
    private String clazz;

    public SemanticLocation() {

    }

    public SemanticLocation(String semanticUri, String realLocationName, String clazz) {
        this.semanticUri = semanticUri;
        this.realLocationName = realLocationName;
        this.clazz = clazz;
    }

    public String getSemanticUri() {
        return semanticUri;
    }

    public void setSemanticUri(String semanticUri) {
        this.semanticUri = semanticUri;
    }

    public String getRealLocationName() {
        return realLocationName;
    }

    public void setRealLocationName(String realLocationName) {
        this.realLocationName = realLocationName;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

}
