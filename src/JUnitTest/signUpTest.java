package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Application;
import model.Korisnik;

public class signUpTest {

	@Test
	public void test() {
		Korisnik k = new Korisnik("pera", null, null, null, null);
		Application app = new Application();
		app.addKorisnik(k);
		boolean res1 = app.checkIfKorisnikExists("per");
		assertEquals(false, res1);
		boolean res2 = app.checkIfKorisnikExists("pera");
		assertEquals(true, res2);
	}

}
