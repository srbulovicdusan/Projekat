package model;

public class Rezervacija {
	private Turista turista;
	private KonkretnaTura konkretnaTura;
	
	public KonkretnaTura getKonkretnaTura(){
		return konkretnaTura;
	}
	
	public void setKonkretnaTura(KonkretnaTura konT){
		this.konkretnaTura = konT;
	}
	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}
	
}
