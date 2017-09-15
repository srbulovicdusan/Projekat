package model;
import java.util.ArrayList;

public class Tura {
	private ArrayList<Integer> ocene;
	private String opis;
	private String grad;
	private String naziv;
	private String slika;
	ArrayList<String > komentari;
	ArrayList<KonkretnaTura> konkretneTure;
	
	public Tura(){
		
	}
	
	public Tura(ArrayList<Integer> ocene, String opis, String grad, String naziv, String slika, ArrayList<String> komentari,
			ArrayList<KonkretnaTura> konkretneTure) {
		super();
		this.slika = slika;
		this.ocene = ocene;
		this.opis = opis;
		this.grad = grad;
		this.naziv = naziv;
		this.komentari = komentari;
		this.konkretneTure = konkretneTure;
	}
	
	
	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public ArrayList<Integer> getOcene() {
		return ocene;
	}
	public void setOcene(ArrayList<Integer> ocene) {
		this.ocene = ocene;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public ArrayList<String> getKomentari() {
		return komentari;
	}
	public void setKomentari(ArrayList<String> komentari) {
		this.komentari = komentari;
	}
	public ArrayList<KonkretnaTura> getKonkretneTure() {
		return konkretneTure;
	}
	public void setKonkretneTure(ArrayList<KonkretnaTura> konkretneTure) {
		this.konkretneTure = konkretneTure;
	}
	
	
}
