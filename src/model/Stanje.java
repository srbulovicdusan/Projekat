package model;

public abstract class Stanje {
	//private KonkretnaTura konkretnaTura;
	
	public abstract void entry();
	public abstract void exit();
	public abstract void cekanjeNaAktivaciju();
	public abstract void aktiviranjeTure();
	public abstract void otkazivanjeTure();
	
	
	/*
	public KonkretnaTura getKonkretnaTura() {
		return konkretnaTura;
	}
	public void setKonkretnaTura(KonkretnaTura konkretnaTura) {
		this.konkretnaTura = konkretnaTura;
	}
	*/
	
}
