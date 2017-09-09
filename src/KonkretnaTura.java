import java.util.ArrayList;
import java.util.Date;

public class KonkretnaTura {
	private ArrayList<Rezervacija> rezervacije;
	private Tura tura;
	private int cena;
	private Date datumPocetka;
	private Date datumZavrsetka;
	private String dodatniOpis;
	
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
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public Date getDatumZavrsetka() {
		return datumZavrsetka;
	}
	public void setDatumZavrsetka(Date datumZavrsetka) {
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
	private Stanje aktivnoStanje;
	
}
