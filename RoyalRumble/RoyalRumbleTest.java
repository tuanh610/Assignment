import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class RoyalRumbleTest {

	@Test
	public void testOrdToInt_x() {
		ordinalComperator b = new ordinalComperator();
		String a = "IX";
		assertEquals(9, b.ordToInt(a));
	}
	@Test
	public void testOrdToInt_x0() {
		ordinalComperator b = new ordinalComperator();
		String a = "XXL";
		assertEquals(50, b.ordToInt(a));
	}
	@Test
	public void testOrdToInt_xx() {
		ordinalComperator b = new ordinalComperator();
		String a = "XLIV";
		assertEquals(44, b.ordToInt(a));
	}
	
	@Test 
	public void RoyalRumbleTest() {
		String[] input = {"George VI", "William XLVI", "Elizabeth XI", "William I", 
							"Louis XLVIII", "Louis XXL", "David VI"};
		String[] output = {"David VI", "Elizabeth XI", "George VI", "Louis XLVIII",
							"Louis XXL", "William I", "William XLVI"};
		RoyalRumble solver = new RoyalRumble();
		
		assertArrayEquals(output, solver.getSortedList(Arrays.asList(input)).toArray());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void RoyalRumbleTest_WrongInput() {
		String[] input = {"GeorgeVI", "William XLVI XX", "Elizabeth XI", "William I", 
				"Louis XLVIII", "Louis XXL", "David VI"};
		RoyalRumble solver = new RoyalRumble();
		solver.getSortedList(Arrays.asList(input));
	}
}
