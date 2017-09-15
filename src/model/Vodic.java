package model;
import java.util.ArrayList;

public class Vodic extends Osoba{
	
	private ArrayList<Tura> ture;
	
	public Vodic(String ime, String prezime) {
		super(ime, prezime);
		ture = new ArrayList<Tura>();
	}
	
	
	public Tura napraviTuru(){
		return null;
	}
	public void zavrsiTuru(Tura t){
		
	}
	public void prihvatiRezervaciju(){
		
	}
	public void pregledTurista(Tura tura){
		
	}
	public void otkaziTuru(Tura tura){
		
	}


	public ArrayList<Tura> getTure() {
		return ture;
	}


	public void setTure(ArrayList<Tura> ture) {
		this.ture = ture;
	}
	
	public void addTura(Tura t){
		this.ture.add(t);
	}
	
}
