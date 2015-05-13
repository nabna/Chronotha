package container;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Formation {

	private int year;
	private List<Planning> workingDays = new ArrayList<Planning>();
	private List<Planning> holidays = new ArrayList<Planning>();

	public int getYear() {
		return year;
	}

	@XmlElement
	public void setYear(Date time) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(time);
	    this.year = cal.get(Calendar.YEAR);
	}

	public List<Planning> getWorkingDays() {
		return workingDays;
	}

	@XmlElement
	public void setWorkingDays(List<Planning> workingDays) {
		this.workingDays = workingDays;
	}
	
	public void addWorkingDays(List<Planning> workingDays) {
		this.workingDays.addAll(workingDays);
		Collections.sort(this.workingDays);
	}

	public List<Planning> getHolidays() {
		return holidays;
	}

	@XmlElement
	public void setHolidays(List<Planning> holidays) {
		this.holidays = holidays;
	}
	
	public void addHolidays(List<Planning> holidays) {
		this.holidays.addAll(holidays);
		Collections.sort(this.holidays);
	}
	

}
