package model.tables;

public class Kategorie {

	/*
	 * Variablen
	 */
	private int kategorie_ID;
	private String name;

	private static String[][] struktur = { { "Kategorie_ID", "Integer","Kategorienummer" }, { "Kategoriename", "String","Bezeichnung" } };

	/*
	 * Konstruktoren
	 */

	// Standard
	public Kategorie(int kategorie_ID, String name) {
		this.kategorie_ID = kategorie_ID;
		this.name = name;
	}
	
	// Standard ohne ID
		public Kategorie(String name) {
			this.name = name;
		}

	// Konstruktor um eine Kategorie aus einem passendem Objekt-Array zu erzeugen
	public Kategorie(Object[] objekte) {
		this.kategorie_ID = (int) objekte[0];
		this.name = (String) objekte[0];
	}

	/*
	 * Methoden
	 */

	// Umwandlung in Objekt-Array
	public Object[] inArrayUmwandeln() {
		Object[] objekte = { kategorie_ID, name };
		return objekte;
	}
	
	//Neue Kategorie
	public String neueKategorie() {
		return "Insert into kategorie ("+struktur[1][0]+") values ('"+name+"')";
	}
	
	//Ändern
	public String aendereKategorie() {
		return "update artikel set " + struktur[1][0] + " = '" + name + "' where " + struktur[0][0] + " = " + kategorie_ID;
	}

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
