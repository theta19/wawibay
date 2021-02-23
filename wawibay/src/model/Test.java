package model;

import model.database.DatenbankVerbindung;
import model.tables.*;

public class Test {

	public static void main(String[] args) {
		DatenbankVerbindung con = new DatenbankVerbindung();
		con.verbindeZurDatenbank("127.0.0.1:3306", "wawibay", "wawibay", "wawibay");
		for (Kunden kunde : con.alleKunden()) {
			System.out.println(kunde.toString());
		}
		System.out.println("");
		for (Artikel artikel : con.alleArtikel()) {
			System.out.println(artikel.toString());
		}
		System.out.println("");
		for (Kategorie kategorie : con.alleKategorie()) {
			System.out.println(kategorie.toString());
		}
		
		System.out.println("");
		for (Lager lager : con.alleLager()) {
			System.out.println(lager.toString());
		}
	}
}
