package container;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import common.DbObject;

@XmlRootElement
public class Module extends DbObject{

	private String name;
	private String abbreviation;
	private String color;
	private int nbSeance;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getColor() {
		return color;
	}

	@XmlElement
	public void setColor(String color) {
		this.color = color;
	}

	public int getNbSeance() {
		return nbSeance;
	}

	@XmlElement
	public void setNbSeance(int nbSeance) {
		this.nbSeance = nbSeance;
	}

	@Override
	public String toString() {
		return "Module [name=" + name + ", abbreviation=" + abbreviation
				+ ", color=" + color + ", nbSeances=" + nbSeance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
