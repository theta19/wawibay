package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.tables.*;

/*
 * Klasse für die MySQL-Datenbank
 */
public class DatenbankVerbindung {

	Connection verbindung;

	/*
	 * Methoden für die Datenbankverbindung
	 */

	// Aufbau der Verbindung
	public boolean verbindeZurDatenbank(String host, String datenbank, String benutzer, String passwort) {
		try {
			verbindung = DriverManager.getConnection("jdbc:mysql://" + host + "/" + datenbank, benutzer, passwort);
			System.out.println("success");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// Schließen der Verbindung
	public boolean schliesseVerbindung() {
		try {
			verbindung.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Abfragemethoden
	 */

	//Holt alle Informationen zu allen Kunden
	public Kunden[] alleKunden() {
		try (Statement statement = verbindung.createStatement();
				ResultSet ergebnis = statement.executeQuery(Kunden.alles())) {
			ArrayList<Kunden> kunden = new ArrayList<>();
			while (ergebnis.next()) {
				Kunden kunde = new Kunden(ergebnis.getInt(1), ergebnis.getString(2), ergebnis.getString(3),
						ergebnis.getString(4), ergebnis.getString(5), ergebnis.getString(6), ergebnis.getString(7),
						ergebnis.getString(8), ergebnis.getString(9), ergebnis.getString(10), ergebnis.getString(11),
						ergebnis.getString(12));
				kunden.add(kunde);
			}
			return kunden.toArray(new Kunden[0]);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	//Holt alle Informationen zu allen Artikeln
	public Artikel[] alleArtikel() {
		try (Statement statement = verbindung.createStatement();
				ResultSet ergebnis = statement.executeQuery(Artikel.alles())) {
			ArrayList<Artikel> artikels = new ArrayList<>();
			while (ergebnis.next()) {
				Artikel artikel = new Artikel(ergebnis.getInt(1), ergebnis.getString(2), ergebnis.getFloat(3),
						ergebnis.getString(4), ergebnis.getString(5), ergebnis.getString(6), ergebnis.getInt(7),
						ergebnis.getString(8),ergebnis.getInt(9));
				artikels.add(artikel);
			}
			return artikels.toArray(new Artikel[0]);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Holt alle Informationen zu allen Kategorien
	public Kategorie[] alleKategorie() {
		try(Statement statement = verbindung.createStatement();
				ResultSet ergebnis = statement.executeQuery(Kategorie.alles())){
			ArrayList<Kategorie>kategorien = new ArrayList<>();
			while (ergebnis.next()) {
				Kategorie kategorie = new Kategorie(ergebnis.getInt(1), ergebnis.getString(2));
				kategorien.add(kategorie);
			}
			return kategorien.toArray(new Kategorie[0]);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Holt alle Informationen zu allen Lagern
		public Lager[] alleLager() {
			try(Statement statement = verbindung.createStatement();
					ResultSet ergebnis = statement.executeQuery(Lager.alles())){
				ArrayList<Lager>lagers = new ArrayList<>();
				while (ergebnis.next()) {
					Lager lager = new Lager(ergebnis.getInt(1), ergebnis.getInt(2));
					lagers.add(lager);
				}
				return lagers.toArray(new Lager[0]);
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

}
