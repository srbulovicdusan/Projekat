package JUnitTest;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import contoller.Controller;

public class DodavanjeKonkretneTure {
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Controller controller = new Controller();
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();;
		c1.setTime(new Date(1900, 11, 10));
		
		c2.setTime(new Date(2019, 11, 10));
		boolean result = controller.checkDate(c2, c1);
		assertEquals(false, result);
		
		boolean result1 = controller.checkDate(c1, c2);
		assertEquals(true, result1);
	}
}
