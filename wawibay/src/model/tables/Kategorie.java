package model.tables;

public class Kategorie {

	/*
	 * Variablen
	 */
	private int kategorie_ID;
	private String name;

	private static String[][] struktur = { { "Kategorie_ID", "Integer" }, { "Kategoriename", "String" } };

	/*
	 * Konstruktoren
	 */

	// Standard
	public Kategorie(int kategorie_ID, String name) {
		this.kategorie_ID = kategorie_ID;
		this.name = name;
	}

	/*
	 * Methoden
	 */

	// Alle Daten
	public static String alles() {
		return "Select * from kategorie";
	}

	/*
	 * Getter und Setter
	 */

	public int getKategorie_ID() {
		return kategorie_ID;
	}

	public void setKategorie_ID(int kategorie_ID) {
		this.kategorie_ID = kategorie_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String[][] getStruktur() {
		return struktur;
	}

	@Override
	public String toString() {
		return kategorie_ID + "," + name;
	}

}
