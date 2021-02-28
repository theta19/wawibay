package model.tables;

public class Lager {

	/*
	 * Variablen
	 */

	private int artikel_ID;
	private int anzahl;

	private static String[][] struktur = { { "Artikel_ID_Fremd", "Integer", "Artikelnummer" }, { "Anzahl", "Integer","Anzahl auf Lager" } };

	/*
	 * Konstruktoren
	 */

	// Standard
	public Lager(int artikel_ID, int anzahl) {
		this.artikel_ID = artikel_ID;
		this.anzahl = anzahl;
	}

	// Konstruktor um ein Lagerobjekt aus einem passendem Objekt-Array zu erzeugen
	public Lager(Object[] objekte) {
		this.artikel_ID = (int) objekte[0];
		this.anzahl = (int) objekte[1];
	}

	/*
	 * Methoden
	 */

	// Alle Daten
	public static String alles() {
		return "Select * from lager";
	}

	// Einfügen
	public String neuesImLager() {
		return "Insert into lager ("+struktur[0][0]+", " + struktur[1][0] + ") values ("+artikel_ID+", " + anzahl + ")";
	}

	// Ändern
	public String aendereImLager() {
		return "update artikel set " + struktur[1][0] + " = '" + anzahl + "' where " + struktur[0][0] + " = "
				+ artikel_ID;
	}

	// Umwandlung in Objekt-Array
	public Object[] inArrayUmwandeln() {
		Object[] objekte = { artikel_ID, anzahl };
		return objekte;
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

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public static String[][] getStruktur() {
		return struktur;
	}

	@Override
	public String toString() {
		return artikel_ID + "," + anzahl;
	}

}
