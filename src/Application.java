import java.util.ArrayList;

public class Application {
	private ArrayList<Korisnik> korisnici;
	private ArrayList<Osoba> osobe;
	private ArrayList<Tura> ture;
	

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
}
