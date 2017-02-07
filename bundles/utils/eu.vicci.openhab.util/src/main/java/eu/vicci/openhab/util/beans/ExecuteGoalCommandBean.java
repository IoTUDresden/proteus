package eu.vicci.openhab.util.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExecuteGoalCommandBean {

    @XmlElement
    public Goal goal;
    @XmlElement
    public List<Quality> qualities;
    @XmlElement
    public SemanticLocation location;

}
