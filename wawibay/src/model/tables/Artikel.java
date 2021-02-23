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
	private String farbe;
	private int steuersatz;
	private String groesse;
	private int kategorie_ID;

	private static String[][] struktur = { { "Artikel_ID", "Integer" }, { "Bezeichnung", "String" },
			{ "Stueckpreis", "Float" }, { "Artikelbeschreibung", "String" }, { "Material", "String" },
			{ "Farbe", "String" }, { "Steuersatz", "Integer" }, { "Groesse", "String" } };

	/*
	 * Konstruktoren
	 */

	// Standard
	public Artikel(int artikel_ID, String bezeichnung, float stueckpreis, String artikelbeschreibung, String material,
			String farbe, int steuersatz, String groesse, int kategorie_ID) {
		this.artikel_ID = artikel_ID;
		this.bezeichnung = bezeichnung;
		this.stueckpreis = stueckpreis;
		this.artikelbeschreibung = artikelbeschreibung;
		this.material = material;
		this.farbe = farbe;
		this.steuersatz = steuersatz;
		this.groesse = groesse;
		this.kategorie_ID = kategorie_ID;
	}

	/*
	 * Methoden
	 */

	// Alle Daten
	public static String alles() {
		return "Select * from artikel";
	}

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

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getSteuersatz() {
		return steuersatz;
	}

	public void setSteuersatz(int steuersatz) {
		this.steuersatz = steuersatz;
	}

	public String getGroesse() {
		return groesse;
	}

	public void setGroesse(String groesse) {
		this.groesse = groesse;
	}

	public int getKategorie_ID() {
		return kategorie_ID;
	}

	public void setKategorie_ID(int kategorie_ID) {
		this.kategorie_ID = kategorie_ID;
	}

	public static String[][] getStruktur() {
		return struktur;
	}
	/*
	 * Overrides
	 */

	@Override
	public String toString() {
		return artikel_ID + "," + bezeichnung + "," + stueckpreis + "," + artikelbeschreibung + "," + material + "," + farbe
				+ "," + steuersatz + "," + groesse+ "," + kategorie_ID;
	}

}
