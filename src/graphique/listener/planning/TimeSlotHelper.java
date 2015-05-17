package graphique.listener.planning;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class TimeSlotHelper {

	private static Map<Integer, String> columns = new HashMap<Integer, String>();

	static {
		columns.put(0, "08:00 - 9:00");
		columns.put(1, "09:00 - 10:00");
		columns.put(2, "10:00 - 11:00");
		columns.put(3, "11:00 - 12:00");
		columns.put(4, "13:00 - 14:00");
		columns.put(5, "14:00 - 15:00");
		columns.put(6, "15:00 - 16:00");
		columns.put(7, "16:00 - 17:00");
		columns.put(8, "17:00 - 18:00");
		columns.put(9, "18:00 - 19:00");
	}
	
	public static int getTotalSlotsCount() {
		return columns.size();
	}
	
	public static String getSlotLabel(int i) {
		return columns.get(i);
	}

	public static Map<Integer, Boolean> getAvailableSlots(int availability) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int mask = 0b0000000001;
		int i = 0;
		while(mask < 0b1000000001) {
			int p = availability & mask;
			map.put(i++, p > 0);;
			mask = mask << 1;
		}
		return map;
	}
	
	public static Integer getKeyBySlot(String value) {
	    for (Entry<Integer, String> entry : columns.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getAvailableSlots(4));
	}
}
