package model.tables;

import java.awt.Image;

public class Artikel {

	/*
	 * Variablen
	 */
	private int artikel_ID;
	private String bezeichnung;
	private float stueckpreis;
	private String artikelbeschreibung;
	private String material;
	private Image bild;
	private String farbe;
	private float steuersatz;
	private String groesse;

	/*
	 * Konstruktoren
	 */

	// Standard
	public Artikel(int artikel_ID, String bezeichnung, float stueckpreis, String artikelbeschreibung, String material,
			Image bild, String farbe, float steuersatz, String groesse) {
		this.artikel_ID = artikel_ID;
		this.bezeichnung = bezeichnung;
		this.stueckpreis = stueckpreis;
		this.artikelbeschreibung = artikelbeschreibung;
		this.material = material;
		this.bild = bild;
		this.farbe = farbe;
		this.steuersatz = steuersatz;
		this.groesse = groesse;
	}

	/*
	 * Methoden
	 */

	/*
	 * Getter und Setter
	 */

	public int getArtikel_ID() {
		return artikel_ID;
	}

	public void setArtikel_ID(int artikel_ID) {
		this.artikel_ID = artikel_ID;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public float getStueckpreis() {
		return stueckpreis;
	}

	public void setStueckpreis(float stueckpreis) {
		this.stueckpreis = stueckpreis;
	}

	public String getArtikelbeschreibung() {
		return artikelbeschreibung;
	}

	public void setArtikelbeschreibung(String artikelbeschreibung) {
		this.artikelbeschreibung = artikelbeschreibung;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Image getBild() {
		return bild;
	}

	public void setBild(Image bild) {
		this.bild = bild;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public float getSteuersatz() {
		return steuersatz;
	}

	public void setSteuersatz(float steuersatz) {
		this.steuersatz = steuersatz;
	}

	public String getGroesse() {
		return groesse;
	}

	public void setGroesse(String groesse) {
		this.groesse = groesse;
	}

}
