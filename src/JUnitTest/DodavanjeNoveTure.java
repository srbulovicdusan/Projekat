package JUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Application;
import model.Tura;

public class DodavanjeNoveTure {

	@Test
	public void test() {
		Tura t = new Tura(null, null, null, "naziv", null, null, null);
		Application app = new Application();
		app.addTour(t);
		boolean result = app.checkTourName("naz");
		assertEquals(false, result);
		
		boolean result1 = app.checkTourName("naziv");
		assertEquals(true, result1);
	}

}
