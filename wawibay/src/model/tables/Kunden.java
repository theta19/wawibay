package model.tables;

public class Kunden {

	/*
	 * Variablen
	 */

	private int kunden_ID;
	private String anrede;
	private String nachname;
	private String vorname;
	private String ebay_nutzername;
	private String strasse_nr;
	private String plz;
	private String ort;
	private String land;
	private String telefonnummer;
	private String adresszusatz;
	private String email;

	/*
	 * Konstruktoren
	 */

	// Standard
	public Kunden(int kunden_ID, String anrede, String nachname, String vorname, String ebay_nutzername,
			String strasse_nr, String plz, String ort, String land, String telefonnummer, String adresszusatz,
			String email) {
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

	/*
	 * Methoden
	 */

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

}
