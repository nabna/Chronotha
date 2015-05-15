package container;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import common.DbObject;

import util.DateUtil;

@XmlRootElement
public class Planning extends DbObject implements Comparable<Planning> {

	private static final long serialVersionUID = 1L;
	
	private Date date;
	@XmlElement
	private String formattedDate; // Date formatteé
	private int availability; // Représentation binaire de la disponibilité, i.e. 1111001110
	private List<Seance> seances = new ArrayList<Seance>();

	public Planning(Date date) {
		this.date = date;
	}

	public Planning() {
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public List<Seance> getSeances() {
		return seances;
	}
	
	@XmlElement
	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	
	public void addSeance(Seance seance) {
		this.seances.add(seance);
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Planning [date=" + getFormattedDate()  + ", seances=" + seances + "]";
	}

	public String getFormattedDate() {
		if(formattedDate == null) {
			formattedDate = DateUtil.getFormattedDate(date);
		}
		return formattedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getFormattedDate() == null) ? 0 : getFormattedDate().hashCode());
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
		Planning other = (Planning) obj;
		if (getFormattedDate() == null) {
			if (DateUtil.getFormattedDate(other.date) != null)
				return false;
		} else if (!getFormattedDate().equals(DateUtil.getFormattedDate(other.date)))
			return false;
		return true;
	}

	@Override
	public int compareTo(Planning a) {
		return this.date.compareTo(a.date);
	}
	
	

}
