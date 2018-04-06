package test.ws.ws.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Template Entity
 * @author LoganPhan
 *
 */
@Entity
@Table(name="configuration")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name  = "Configuration")
public class Configuration extends IdEntity {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	@Column(name="property")
	private String property;
	
	@XmlElement(required = true)
	@Column(name="value")
	private String value;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}	

