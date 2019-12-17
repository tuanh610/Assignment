import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class RoyalRumble {
	
	public List<String> getSortedList(List<String> names) {
		Collections.sort(names, new ordinalComperator());
		return names;
  }
}

class ordinalComperator implements Comparator<String>{
	Map<String, Integer> dict1Digit = new HashMap<>((Map.of("I", 1, "II", 2, "III", 3, "IV", 4, "V", 5, "VI", 6, "VII", 7, "VIII", 8, "IX", 9)));
	Map<String, Integer> dict2Digit = new HashMap<>((Map.of("X", 10, "XX", 20, "XXX", 30, "XL", 40, "XXL", 50)));
	@Override
	public int compare(String a, String b){
		String[] temp1 = a.split(" ");
		String[] temp2 = b.split(" ");
		if (temp1.length != 2 || temp2.length != 2) {
			throw new IllegalArgumentException("Input is wrong");
		}
		int res = temp1[0].compareTo(temp2[0]);
		if (res != 0) {
			return res;
		}
		else {
			return ordToInt(temp1[1]) - ordToInt(temp2[1]);
		}
	}
	
	int ordToInt(String ord) {
		int idx = 0; 
		while (idx < ord.length()) {
			if (!dict2Digit.containsKey(ord.substring(0, idx+1))){
				break;
			}
			idx+=1;
		}
		if (idx == 0) {
			return dict1Digit.get(ord);
		}
		else if (idx == ord.length()) {
			return dict2Digit.get(ord);
		}
		else {
			return dict2Digit.get(ord.substring(0,idx)) + dict1Digit.get(ord.substring(idx, ord.length()));
		}
	}
}
