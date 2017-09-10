package model;

public abstract class Stanje {
	private KonkretnaTura konkretnaTura;
	public void entry(){}
	public void exit(){}
	
	public KonkretnaTura getKonkretnaTura() {
		return konkretnaTura;
	}
	public void setKonkretnaTura(KonkretnaTura konkretnaTura) {
		this.konkretnaTura = konkretnaTura;
	}
	
	
}
