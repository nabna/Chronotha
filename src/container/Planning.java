package container;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.DateUtil;

@XmlRootElement
public class Planning implements Comparable<Planning>{

	private String identity;
	private Date date;
	private List<Seance> seance = new ArrayList<Seance>();

	public Planning(Date date, String id) {
		this.date = date;
		this.identity = DateUtil.getFormattedDate(date) + " " + id;
	}

	public Planning() {
	}

	public Date getDate() {
		return date;
	}
	
	public List<Seance> getSeance() {
		return seance;
	}
	
	public String getIdentity() {
		return identity;
	}

	@XmlElement
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@XmlElement
	public void setSeance(List<Seance> seance) {
		this.seance = seance;
	}
	
	public void addSeance(Seance seance) {
		this.seance.add(seance);
	}

	@Override
	public String toString() {
		return "Planning [date=" + identity + ", seance=" + seance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
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
		if (identity == null) {
			if (DateUtil.getFormattedDate(other.date) != null)
				return false;
		} else if (!identity.equals(DateUtil.getFormattedDate(other.date)))
			return false;
		return true;
	}

	@Override
	public int compareTo(Planning a) {
		return this.date.compareTo(a.date);
	}
	
	

}
