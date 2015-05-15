package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.DateUtil;

import container.Planning;

public class PlanningGenerator {
	
	public static List<Planning> getWholeYear(Date now) {
		List<Planning> plannings = new ArrayList<Planning>();
		
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(now);
	    int year = cal.get(Calendar.YEAR);
	    cal.set(year, 7, 31, 0, 0, 0);  

	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(now);
	    int endYear = cal.get(Calendar.YEAR) + 1;
	    endCal.set(endYear, 7, 31, 0, 0, 0);  
	    
	    Date date = cal.getTime();
	    do {
	    	date = DateUtil.addSomeDays(date, 1);
	    	Planning planning  = new Planning(date);
	    	plannings.add(planning);
	    } while(date.compareTo(endCal.getTime()) < 0);
		
		return plannings;
			
	}
	
	public static List<Planning> getWorkingDays(Date now) {
		List<Planning> plannings = new ArrayList<Planning>();
		
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(now);
	    int year = cal.get(Calendar.YEAR);
	    cal.set(year, 7, 31, 0, 0, 0);  

	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(now);
	    int endYear = cal.get(Calendar.YEAR) + 1;
	    endCal.set(endYear, 7, 31, 0, 0, 0);  
	    
	    Date date = cal.getTime();
	    do {
	    	date = DateUtil.addSomeBusinessDay(date, 1);
	    	Planning planning  = new Planning(date);
	    	plannings.add(planning);
	    } while(date.compareTo(endCal.getTime()) < 0);
		
		return plannings;
			
	}
	
	public static List<Planning> getHolidays(Date now) {
		Set<Planning> symmetricDiff = new HashSet<Planning>(getWholeYear(now));
		symmetricDiff.removeAll(getWorkingDays(now));
		Collections.disjoint(symmetricDiff, getWorkingDays(now));
		List<Planning> result = new ArrayList<Planning>(symmetricDiff);
		Collections.sort(result);
		return result;
	}

}
