package model;
import java.util.ArrayList;

public class Turista extends Osoba {
	private ArrayList<Rezervacija> rezervacije;
	
	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	public void pregledTura() {
	      
	}
	public void prijaviSeZaTuru(Tura tura) {
		
    }
	public void postaviKomentar(Tura tura, String kom) {

	}
	public void oceniTuru(Tura tura, int ocena) {

	}
	public void odjaviSe(Tura tura) {

	}
}
