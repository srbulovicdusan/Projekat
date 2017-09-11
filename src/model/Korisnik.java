package model;

public class Korisnik {
	private String korisnickoIme;
	private String lozinka;
	private String email;
	private String slika;
	
	public Osoba osoba;
	
	public void izmeniProfil() {
	      // TODO: implement
	}
	
	public Korisnik(String korisnickoIme, String lozinka, String email, String slika, Osoba osoba) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.slika = slika;
		this.osoba = osoba;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSlika() {
		return slika;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	public Osoba getOsoba() {
		return osoba;
	}
	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
}
