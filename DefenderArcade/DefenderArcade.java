import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * Since the assignment does not specify the behavior of overlap includes the edge of time period or not
 * In this solution, I assume that it does count. 
 * Example 10:00->12:00 and 12:00->13:00 still counts as overlap
 */
public class DefenderArcade {
  public int countArcades(List<String> times) {
	  //Edge case 
	  if (times.size()<2) {
		  return times.size();
	  }
	  //Preprocess data
	  List<Integer> start = new ArrayList<Integer>();
	  List<Integer> end = new ArrayList<Integer>();
	  for (String time : times) {
		  String[] temp = time.split(" ");
		  if (temp.length != 2) {
			  continue;
		  }
		  start.add(timeStringToMinute(temp[0]));
		  end.add(timeStringToMinute(temp[1]));
	  }
	  //Sort the start and endTime 
	  Collections.sort(start);
	  Collections.sort(end);
	  //PlayerIn indicate the number of player at a time 
	  int playerIn = 1, maxMachine = 1, time = start.get(0), n = start.size();
	  int i = 1, j = 0;
	  while (i < n && j < n) {
		  if (start.get(i) <= end.get(j)) {
			  playerIn++;
			  //Update maxMachine if needed 
			  if (playerIn > maxMachine) {
				  maxMachine = playerIn;
				  time = start.get(i);
			  }
			  //Increment the index of startArray
			  i++;
		  }
		  else {
			  playerIn--;
			  //Increment the index of endArray
			  j++;
		  }
	  }
	  return maxMachine;
  }
  
  int timeStringToMinute(String time) {
	  if (time.length() > 4 || time.length() < 3) {
		  throw new IllegalArgumentException("Time String is incorrect");
	  }
	  else {
		  int idx = time.length()/2;
		  int hours = Integer.parseInt(time.substring(0, idx));
		  int minutes = Integer.parseInt(time.substring(idx));
		  if (hours < 0 || hours > 24 || minutes < 0 || minutes > 60) {
			  throw new IllegalArgumentException("Time String is incorrect");
		  }
		  return hours*60+minutes;
	  }
  }
}

