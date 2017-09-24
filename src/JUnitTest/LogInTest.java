package JUnitTest;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import model.Application;
import model.Korisnik;



public class LogInTest {

	@Test
	public void test() {
		Korisnik k = new Korisnik("pera", "123", null, null, null);
		Application app = new Application();
		app.addKorisnik(k);
		boolean result = app.checkLogin("per", "12");
		assertEquals(false, result);

		boolean result1 = app.checkLogin( "pera", "123");
		assertEquals(true, result1);
		
		boolean result2 = app.checkLogin( "pera", "12");
		assertEquals(false, result2);
		
		boolean result3 = app.checkLogin( "per", "123");
		assertEquals(false, result3);
	}

}
