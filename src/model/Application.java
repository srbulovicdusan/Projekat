package model;
import java.util.ArrayList;

public class Application {
	private ArrayList<Korisnik> korisnici;
	private ArrayList<Osoba> osobe;
	private ArrayList<Tura> ture;
	private Korisnik ulogovanKorisnik;

	public Application(){
		korisnici = new ArrayList<Korisnik>();
		ture = new ArrayList<Tura>();
		osobe = new ArrayList<Osoba>();
	}
	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}
	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	public ArrayList<Osoba> getOsobe() {
		return osobe;
	}
	public void setOsobe(ArrayList<Osoba> osobe) {
		this.osobe = osobe;
	}
	public ArrayList<Tura> getTure() {
		return ture;
	}
	public void setTure(ArrayList<Tura> ture) {
		this.ture = ture;
	}
	public void addKorisnik(Korisnik k){
		korisnici.add(k);
	}
	public boolean checkIfKorisnikExists(String userName){
		for (Korisnik k : korisnici){
			if (k.getKorisnickoIme().compareTo(userName) == 0){
				return true;
			}
		}
		return false;
	}
	
	public void addTour(Tura tura) {
		ture.add(tura);
	}
	public void removeTour(Tura tura){
		this.ture.remove(tura);
	}
	
	public boolean checkTourName(String name){
		for(Tura t : ture){
			if(t.getNaziv().compareToIgnoreCase(name) == 0){
				return true;
			}
		}
		return false;
	}
	public Korisnik getUlogovanKorisnik() {
		return ulogovanKorisnik;
	}
	public void setUlogovanKorisnik(Korisnik ulogovanKorisnik) {
		this.ulogovanKorisnik = ulogovanKorisnik;
	}
	public boolean checkLogin(String userName, String password){
		for (Korisnik k : korisnici){
			if (k.getKorisnickoIme() == userName && k.getLozinka() == password){
				return true;
			}
		}
		return false;
	}
	
}
