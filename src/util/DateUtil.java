package util;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	private static double NB_MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;

	public static final String FR_DATE_FORMAT = "dd/MM/yyyy";
	public static final String US_DATE_FORMAT = "MM/dd/yyyy";
	public static final String FR_TIME_FORMAT = "HH:mm:ss";
	public static final String US_TIME_FORMAT = "KK:mm:ss a";

	private static String slashDateFormat = "dd/MM/yyyy";
	private static String timeDateFormat = "HH:mm:ss";

	public static Date getDateWithoutHour(Date d) {
		if (d == null)
			return null;

		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(HOUR_OF_DAY, 0);
		c.set(MINUTE, 0);
		c.set(SECOND, 0);
		c.set(MILLISECOND, 0);

		return c.getTime();
	}

	public static Date buildDate(int year, int month, int date, int hrs, int min) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, date, hrs, min);
		return c.getTime();
	}

	public static boolean areSameDay(Date d1, Date d2) {
		boolean equal = false;
		Date daily1 = getDateWithoutHour(d1);
		Date daily2 = getDateWithoutHour(d2);
		if (daily1 != null && daily2 != null) {
			equal = daily1.equals(daily2);
		}
		return equal;
	}

	public static String getYYYYMMDD(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(d);
	}

	public static String getYYYYMMDDhhmmss(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		return df.format(d);
	}


	public static String getYYYYMMDDHHmmss(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(d);
	}
	
	public static String getYYYYMMDDHHmmss2(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);

		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

		return df.format(d);
	}
	
	public static String getWithSlash(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		DateFormat df = new SimpleDateFormat(slashDateFormat);
		return df.format(d);
	}

	public static String getTimeOnly(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		DateFormat df = new SimpleDateFormat(timeDateFormat);
		return df.format(d);
	}

	public static String getDateWithUserPattern(Date d, String userPattern) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		DateFormat df = new SimpleDateFormat(userPattern);
		return df.format(d);
	}

	/**
	 * Compare 2 dates. null is considered before any other date.
	 * 
	 * @param d1
	 *            date1
	 * @param d2
	 *            date2
	 * @return -1 if d1 < d2, +1 if d1 > d2, 0 if d1=d2
	 */
	public static int compareNullDates(Date d1, Date d2) {
		if (d1 == null) {
			if (d2 == null) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (d2 == null) {
				return 1;
			} else {
				return d1.compareTo(d2);
			}
		}
	}

	/**
	 * Return a formatted date according to the current locale. If the locale is
	 * 'Fr' then format the date with FR_DATE_FORMAT otherwise US_DATE_FORMAT is
	 * used.
	 * 
	 * @param d
	 *            date to format
	 * @return formatted date
	 */
	public static String getFormattedDate(Date d) {
		DateFormat df = null;
		if (Locale.getDefault().equals(Locale.FRANCE)) {
			df = new SimpleDateFormat(FR_DATE_FORMAT);
		} else {
			df = new SimpleDateFormat(US_DATE_FORMAT);
		}

		return df.format(d);
	}

	public static Date addOneDay(Date input) {
		return addSomeDays(input, 1);
	}

	public static Date addSomeDays(Date input, int nbDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(input);
		cal.add(Calendar.DATE, nbDays);
		return cal.getTime();
	}

	/**
	 * Add or remove nbDays to the input date. This method skips the weekends.
	 * 
	 * @param input
	 *            date
	 * @param nbDays
	 *            number of days to add or remove
	 * @return the new date
	 */
	public static Date addSomeBusinessDay(Date input, int nbDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(input);

		if (nbDays < 0) {

			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				cal.add(Calendar.DATE, -1);
			}

			nbDays = Math.abs(nbDays);
			for (int i = 0; i < nbDays; i++) {
				if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
					cal.add(Calendar.DATE, -3);
				} else {
					cal.add(Calendar.DATE, -1);
				}
			}
		} else {

			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				cal.add(Calendar.DATE, +1);
			}

			for (int i = 0; i < nbDays; i++) {
				if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
					cal.add(Calendar.DATE, 3);
				} else {
					cal.add(Calendar.DATE, 1);
				}
			}
		}

		return cal.getTime();
	}

	public static long getNbOfDaysBetweenTwoDates(Date date1, Date date2) {
		double diffMillis = (double) (date2.getTime() - date1.getTime());
		double nbDays = diffMillis / NB_MILLISECONDS_IN_A_DAY;
		return Math.round(nbDays);
	}
}