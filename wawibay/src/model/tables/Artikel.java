package model.tables;

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

	private static String[][] struktur = { { "Artikel_ID", "Integer", "Artikelnummer" },
			{ "Bezeichnung", "String", "Bezeichnung" }, { "Stueckpreis", "Float", "Stückpreis" },
			{ "Artikelbeschreibung", "String", "Artikelbeschreibung" }, { "Material", "String", "Material" },
			{ "Farbe", "String", "Farbe" }, { "Steuersatz", "Integer", "Steuersatz" },
			{ "Groesse", "String", "Größe" },{"Kategorie_ID_Fremd", "Integer","Kategorienummer"} };

	/*
	 * Konstruktoren
	 */

	// Standard
	public Artikel(int artikel_ID, String bezeichnung, int stueckpreis, String artikelbeschreibung, String material,
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

	// Standard ohne ID
	public Artikel(String bezeichnung, int stueckpreis, String artikelbeschreibung, String material, String farbe,
			int steuersatz, String groesse, int kategorie_ID) {
		this.bezeichnung = bezeichnung;
		this.stueckpreis = stueckpreis;
		this.artikelbeschreibung = artikelbeschreibung;
		this.material = material;
		this.farbe = farbe;
		this.steuersatz = steuersatz;
		this.groesse = groesse;
		this.kategorie_ID = kategorie_ID;
	}

	// Konstruktor um einen Artikel aus einem passendem Objekt-Array zu erzeugen
	public Artikel(Object[] objekte) {
		this.artikel_ID = (int) objekte[0];
		this.bezeichnung = (String) objekte[1];
		this.stueckpreis = (float) objekte[2];
		this.artikelbeschreibung = (String) objekte[3];
		this.material = (String) objekte[4];
		this.farbe = (String) objekte[5];
		this.steuersatz = (int) objekte[6];
		this.groesse = (String) objekte[7];
		this.kategorie_ID = (int) objekte[8];
	}

	/*
	 * Methoden
	 */

	// Umwandlung in Objekt-Array
	public Object[] inArrayUmwandeln() {
		Object[] objekte = { artikel_ID, bezeichnung, stueckpreis, artikelbeschreibung, material, farbe, steuersatz,
				groesse, kategorie_ID };
		return objekte;

	}

	// Alle Daten
	public static String alles() {
		return "Select * from artikel";
	}

	// Neuer Artikel
//	public String neuerArtikel() {
//		return "Insert into artikel values (" + artikel_ID + ", " + bezeichnung + ", " + stueckpreis + ", " + artikelbeschreibung
//				+ ", " + material + ", " + farbe + ", " + steuersatz + ", " + groesse + ", " + kategorie_ID + ") ";
//	}
	public String neuerArtikel() {
		return "Insert into artikel (" + struktur[1][0] + ", " + struktur[2][0] + ", " + struktur[3][0] + ", "
				+ struktur[4][0] + ", " + struktur[5][0] + ", " + struktur[6][0] + ", " + struktur[7][0] + ", "
				+ struktur[8][0] + ") values ('" + bezeichnung + "', " + stueckpreis + ", '" + artikelbeschreibung
				+ "', '" + material + "', '" + farbe + "', " + steuersatz + ", '" + groesse + "', " + kategorie_ID
				+ ") ";
	}

	// Ändern
	public String aendereArtikel() {
		return "update artikel set " + struktur[1][0] + " = '" + bezeichnung + "' " + struktur[2][0] + " = "
				+ stueckpreis + " " + struktur[3][0] + " = '" + artikelbeschreibung + "' " + struktur[4][0] + " = '"
				+ material + "' " + struktur[5][0] + " = '" + farbe + "' " + struktur[6][0] + " = " + steuersatz + " "
				+ struktur[7][0] + " = '" + bezeichnung + "' " + struktur[8][0] + " = " + kategorie_ID + " where "
				+ struktur[0][0] + " = " + artikel_ID;
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
		return artikel_ID + "," + bezeichnung + "," + stueckpreis + "," + artikelbeschreibung + "," + material + ","
				+ farbe + "," + steuersatz + "," + groesse + "," + kategorie_ID;
	}

}
