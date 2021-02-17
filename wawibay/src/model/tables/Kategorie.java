package model.tables;

public class Kategorie {

	/*
	 * Variablen
	 */
	private int kategorie_ID;
	private String name;

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
}
