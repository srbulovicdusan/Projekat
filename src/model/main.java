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
		

		Korisnik k = new Korisnik("p" , "k" , "email", null, new Vodic("Petar", "Petrovic"));
		app.addKorisnik(k);

		Korisnik turista = new Korisnik("k" , "p" , "email", null, new Turista("Petar", "Petrovic"));

		app.addKorisnik(turista);
		
		MainWindow mainW = new MainWindow(app.getTure());
		Controller controller = new Controller(mainW, app);
		
		
	}

}
