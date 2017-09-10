package model;

public class MestoObilaska {
	private String opis;
	private String adresa;
	private String slike;
	private Mesto mesto;
	
	
	public MestoObilaska(String opis, String adresa, String slike, Mesto mesto) {
		super();
		this.opis = opis;
		this.adresa = adresa;
		this.slike = slike;
		this.mesto = mesto;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getSlike() {
		return slike;
	}
	public void setSlike(String slike) {
		this.slike = slike;
	}
	public Mesto getMesto() {
		return mesto;
	}
	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}
}
