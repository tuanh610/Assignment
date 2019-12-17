import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DefenderArcadeTest {
	private DefenderArcade solver;
	
	@Before
	public void init() {
		solver = new DefenderArcade();
	}
	
	@Test
	public void testCountArcades_OnePlayer() {
		List<String> input = new ArrayList<String>();
		input.add("900 915");
		assertEquals(1, solver.countArcades(input));
	}
	
	@Test 
	public void testTimeStringToMinutes(){
		String input1 = "2115";
		String input2 = "723";
		assertEquals(1275, solver.timeStringToMinute(input1));
		assertEquals(443, solver.timeStringToMinute(input2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTimeStringToMinute_WrongInput() {
		String input1 = "12345";
		solver.timeStringToMinute(input1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTimeStringToMinute_WrongInput2() {
		String input1 = "6015";
		solver.timeStringToMinute(input1);
	}
	
	@Test
	public void testCountArcades_ManyPlayer() {
		List<String> input = new ArrayList<String>();
		input.add("900 915");
		input.add("940 1200");
		input.add("950 1120");
		input.add("1100 1130");
		input.add("1300 1400");
		input.add("1350 1420");
		assertEquals(3, solver.countArcades(input));
	}
	
	@Test
	public void testIgnoreWrongInput() {
		List<String> input = new ArrayList<String>();
		input.add("900 915");
		input.add("940 1200 1300");
		input.add("950 1120");
		assertEquals(1, solver.countArcades(input));
	}
}
