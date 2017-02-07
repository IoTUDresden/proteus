package eu.vicci.openhab.util.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Quality {

    @XmlElement
    public String name;

}
