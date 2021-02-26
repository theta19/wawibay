package model.tables;

public class Kunden {

	/*
	 * Variablen
	 */

	private int kunden_ID;
	private String ebay_nutzername;
	private String anrede;
	private String vorname;
	private String nachname;
	private String strasse_nr;
	private String plz;
	private String ort;
	private String adresszusatz;
	private String land;
	private String email;
	private String telefonnummer;

	private static String[][] struktur = { { "Kunden_ID", "Integer" }, { "EBay_Benutzername", "String" },
			{ "Anrede", "String" }, { "Vorname", "String" }, { "Nachname", "String" },
			{ "Strasse_Hausnummer", "String" }, { "Postleitzahl", "String" }, { "Wohnort", "String" },
			{ "Adresszusatz", "String" }, { "Land", "String" }, { "Email_Adresse", "String" },
			{ "Telefonnummer", "String" } };

	/*
	 * Konstruktoren
	 */

	// Standard
	public Kunden(int kunden_ID, String ebay_nutzername, String anrede, String vorname, String nachname,
			String strasse_nr, String plz, String ort, String land, String adresszusatz, String email,
			String telefonnummer) {
		this.kunden_ID = kunden_ID;
		this.anrede = anrede;
		this.nachname = nachname;
		this.vorname = vorname;
		this.ebay_nutzername = ebay_nutzername;
		this.strasse_nr = strasse_nr;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		this.telefonnummer = telefonnummer;
		this.adresszusatz = adresszusatz;
		this.email = email;
	}

	// Standard ohne ID
	public Kunden(String ebay_nutzername, String anrede, String vorname, String nachname, String strasse_nr, String plz,
			String ort, String land, String adresszusatz, String email, String telefonnummer) {
		this.anrede = anrede;
		this.nachname = nachname;
		this.vorname = vorname;
		this.ebay_nutzername = ebay_nutzername;
		this.strasse_nr = strasse_nr;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		this.telefonnummer = telefonnummer;
		this.adresszusatz = adresszusatz;
		this.email = email;
	}

	// Konstruktor um einen Kunden aus einem passendem Objekt-Array zu erzeugen
	public Kunden(Object[] objekte) {
		this.kunden_ID = (int) objekte[0];
		this.anrede = (String) objekte[1];
		this.nachname = (String) objekte[2];
		this.vorname = (String) objekte[3];
		this.ebay_nutzername = (String) objekte[4];
		this.strasse_nr = (String) objekte[5];
		this.plz = (String) objekte[6];
		this.ort = (String) objekte[7];
		this.land = (String) objekte[8];
		this.telefonnummer = (String) objekte[9];
		this.adresszusatz = (String) objekte[10];
		this.email = (String) objekte[11];
	}

	/*
	 * Methoden
	 */

	// Umwandlung in Objekt-Array
	public Object[] inArrayUmwandeln() {
		Object[] objekte = { kunden_ID, ebay_nutzername, anrede, vorname, nachname, strasse_nr, plz, ort, adresszusatz,
				land, email, telefonnummer };
		return objekte;

	}

	// Einfügen
	public String neuerKunde() {
		return "Insert into kunden (" + struktur[1][0] + ", " + struktur[2][0] + ", " + struktur[3][0] + ", "
				+ struktur[4][0] + ", " + struktur[5][0] + ", " + struktur[6][0] + ", " + struktur[7][0] + ", "
				+ struktur[8][0] + ", " + struktur[9][0] + ", " + struktur[10][0] + ", " + struktur[11][0]
				+ ")values ('" + anrede + "', '" + nachname + "', '" + vorname + "', '" + ebay_nutzername + "', '"
				+ strasse_nr + "', '" + plz + "', '" + ort + "', '" + land + "', '" + telefonnummer + "', '" + adresszusatz
				+ "', '" + email + "') ";
	}

	// Ändern
	public String aendereKunde() {
		return "update kunden set " + struktur[1][0] + " = '" + anrede + "', " + struktur[2][0] + " = '" + nachname
				+ "', " + struktur[3][0] + " = '" + vorname + "', " + struktur[4][0] + " = '" + ebay_nutzername + "', "
				+ struktur[5][0] + " = '" + strasse_nr + "', " + struktur[6][0] + " = '" + plz + "', " + struktur[7][0]
				+ " = '" + ort + "', " + struktur[8][0] + " = '" + land + "', " + struktur[9][0] + " = '"
				+ telefonnummer + "', " + struktur[10][0] + " = '" + adresszusatz + "', " + struktur[11][0] + " = '"
				+ email + "' where " + struktur[0][0] + " = " + kunden_ID;
	}

	// Alle Daten
	public static String alles() {
		return "Select * from kunden";
	}

	/*
	 * Getter und Setter
	 */
	public int getKunden_ID() {
		return kunden_ID;
	}

	public void setKunden_ID(int kunden_ID) {
		this.kunden_ID = kunden_ID;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getEbay_nutzername() {
		return ebay_nutzername;
	}

	public void setEbay_nutzername(String ebay_nutzername) {
		this.ebay_nutzername = ebay_nutzername;
	}

	public String getStrasse_nr() {
		return strasse_nr;
	}

	public void setStrasse_nr(String strasse_nr) {
		this.strasse_nr = strasse_nr;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getAdresszusatz() {
		return adresszusatz;
	}

	public void setAdresszusatz(String adresszusatz) {
		this.adresszusatz = adresszusatz;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static String[][] getStruktur() {
		return struktur;
	}

	/*
	 * Overrides
	 */

	@Override
	public String toString() {
		return kunden_ID + "," + ebay_nutzername + "," + anrede + "," + vorname + "," + nachname + "," + strasse_nr
				+ "," + plz + "," + ort + "," + adresszusatz + "," + land + "," + email + "," + telefonnummer;
	}
}
