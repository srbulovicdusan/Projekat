package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import contoller.Controller;
import view.KreiranjeOpsteTureGui;
import view.MainWindow;
public class main {

	public static void main(String[] args) {

		Application app = new Application();
		
		ArrayList<Integer> ocene = new ArrayList<Integer>(Arrays.asList(2, 12));
		KonkretnaTura kt = new KonkretnaTura();
		
		//Vodic

		Korisnik k = new Korisnik("p" , "k" , "email", null, new Vodic("Petar", "Petrovic"));
		Tura t = new Tura(ocene, "fdfd", "fds", "dsf", null, new ArrayList<String>(Arrays.asList("vg", "fjg")),
				new ArrayList<KonkretnaTura>(Arrays.asList(kt)));
		t.setVodic((Vodic)k.getOsoba());
		((Vodic) k.getOsoba()).addTour(t);
		app.addKorisnik(k);
		app.addTour(t);

		
		//Turista
		Korisnik turista = new Korisnik("k" , "p" , "email", null, new Turista("Petar", "Petrovic"));

		//Rezervacija rez = new Rezervacija();
		//rez.setKonkretnaTura(kt);
		//rez.setTurista((Turista)turista.getOsoba());
		
		//((Turista) turista.getOsoba()).rezervisiTuru(rez);
		app.addKorisnik(turista);
		
		MainWindow mainW = new MainWindow(app.getTure());
		Controller controller = new Controller(mainW, app);
		//TuraWindowGui tGui = new TuraWindowGui(null);
		
		
	}

}
