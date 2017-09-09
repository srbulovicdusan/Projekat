
public abstract class Osoba {

   private String ime;
   private String prezime;
   public Korisnik korisnik;
   public String getIme() {
	return ime;
   }
   public void setIme(String ime) {
	   this.ime = ime;
   }
   public String getPrezime() {
	   return prezime;
   }
   public void setPrezime(String prezime) {
	   this.prezime = prezime;
   }
   public Korisnik getKorisnik() {
	   return korisnik;
   }
   public void setKorisnik(Korisnik korisnik) {
	   this.korisnik = korisnik;
   }
	
}
