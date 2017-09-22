package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class KonkretnaTura {
	private ArrayList<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
	private Tura tura;
	private double cena;
	//private Date datumPocetka;
	//private Date datumZavrsetka;
	private Calendar datumPocetka;
	private Calendar datumZavrsetka;
	private String dodatniOpis;
	private Stanje aktivnoStanje;
	
	
	public KonkretnaTura() {
		
	}
	
	
	public KonkretnaTura(Tura tura, double cena, Calendar datumPocetka, Calendar datumZavrsetka, String dodatniOpis) {
		super();
		this.tura = tura;
		this.cena = cena;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.dodatniOpis = dodatniOpis;
	}




	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	public Tura getTura() {
		return tura;
	}
	public void setTura(Tura tura) {
		this.tura = tura;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public Calendar getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Calendar datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public Calendar getDatumZavrsetka() {
		return datumZavrsetka;
	}
	public void setDatumZavrsetka(Calendar datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}
	public String getDodatniOpis() {
		return dodatniOpis;
	}
	public void setDodatniOpis(String dodatniOpis) {
		this.dodatniOpis = dodatniOpis;
	}
	public Stanje getAktivnoStanje() {
		return aktivnoStanje;
	}
	public void setAktivnoStanje(Stanje aktivnoStanje) {
		this.aktivnoStanje = aktivnoStanje;
	}
	
	public void ispisKonkretneTure() {
		Calendar c = datumPocetka.getInstance();
		Date d1 = c.getTime();
		c = datumZavrsetka.getInstance();
		Date d2 = c.getTime();
		System.out.println("Opsta tura: " + tura.getNaziv() + "\nCena: " + cena + "\nDatum poc:" +
	              d1.toString() + "\nDatum zavrsetka: " + d2.toString());
	}
	
	public void dodajRezervaciju(Rezervacija rezervacija){
		this.rezervacije.add(rezervacija);
	}
	
}
