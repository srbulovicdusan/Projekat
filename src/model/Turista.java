package model;
import java.util.ArrayList;

public class Turista extends Osoba {
	
	public Turista(String ime, String prezime) {
		super(ime, prezime);
	}
	private ArrayList<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
	
	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	public void pregledTura() {
	      
	}
	public void rezervisiTuru(Rezervacija rezervacija) {
		rezervacije.add(rezervacija);
    }
	public void postaviKomentar(Tura tura, String kom) {

	}
	public void oceniTuru(Tura tura, int ocena) {

	}
	public void odjaviSe(Tura tura) {

	}
}
