package model.tables;

public class Lager {

	/*
	 * Variablen
	 */

	private int artikel_ID;
	private int anzahl;

	private static String[][] struktur = { { "Artikel_ID_Fremd", "Integer" }, { "Anzahl", "Integer" } };
	
	/*
	 * Konstruktoren
	 */

	// Standardkonstruktor
	public Lager(int artikel_ID, int anzahl) {
		this.artikel_ID = artikel_ID;
		this.anzahl = anzahl;
	}

	/*
	 * Methoden
	 */
	
	// Alle Daten
		public static String alles() {
			return "Select * from lager";
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
