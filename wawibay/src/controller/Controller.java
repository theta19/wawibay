package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import model.database.DatenbankVerbindung;
import model.tables.Artikel;
import model.tables.Kategorie;
import model.tables.Kunden;
import model.tables.Lager;
import view.AnmeldeView;
import view.ArtikelView;
import view.HauptView;

public class Controller implements ActionListener,WindowListener {

	HauptView hauptview;
	AnmeldeView anmeldeview;
	ArtikelView artikelview;
	
	DatenbankVerbindung verbindung = new DatenbankVerbindung();

	public Controller(HauptView hauptview, AnmeldeView anmeldeview, ArtikelView artikelview) {
		this.hauptview = hauptview;
		this.anmeldeview = anmeldeview;
		this.artikelview = artikelview;

		//Eigentlich unten im anmelden...geht aber gearde nicht anders
		verbindung.verbindeZurDatenbank("127.0.0.1:3306", "wawibay", "wawibay", "wawibay");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		
		//Derzeit zu Testzwecken (Stand 27.02.) einfach per Klick auf "Anmelden" startbar. Später Abfrage der Zugangsdaten nötig
		case "anmelden":
			
			anmeldeview.dispose();
//			for (Kunden kunde : verbindung.alleKunden()) {
//				System.out.println(kunde.toString());
//			}
//			System.out.println("");
//			for (Artikel artikel : verbindung.alleArtikel()) {
//				System.out.println(artikel.toString());
//			}
//			System.out.println("");
//			for (Kategorie kategorie : verbindung.alleKategorie()) {
//				System.out.println(kategorie.toString());
//			}
//			System.out.println("");
//			for (Lager lager : verbindung.alleLager()) {
//				System.out.println(lager.toString());
//			}
			hauptview.setEnabled(true);
		
		case "artikel":
			
			hauptview.add(hauptview.getArtikelFrame());
			schliesseInternalFrames();
			hauptview.getArtikelFrame().setVisible(true);

			break;

		case "kunden":
			
			hauptview.add(hauptview.getKundenFrame());
			schliesseInternalFrames();
			hauptview.getKundenFrame().setVisible(true);
			
			break;
		
		case "neuerArtikel":
			
			artikelview.initialise(this);
			artikelview.setAlwaysOnTop(true);
			hauptview.setEnabled(false);
			
			break;
			
		case "beenden":
			
			hauptview.dispose();
			anmeldeview.dispose();
			artikelview.dispose();
			
			break;
			
		case "arikelFensterSchliessen":
			
			//hierzu siehe Nachricht im Launcher. Nur über "Beenden" Button das Fenster schließen.
			
			hauptview.setEnabled(true);
			artikelview.setAlwaysOnTop(false);
			artikelview.dispose();
			
			
			break;
			
		case "bearbeiteArtikel":
			artikelview.initialise(this);
			
			break;

		default:
			break;
		}

	}

	private void schliesseInternalFrames() {
		hauptview.getArtikelFrame().dispose();
		hauptview.getKundenFrame().dispose();

	}
	
	public String[] alleKategorienNurNamenAlsStringArray() {
		Kategorie[] alleKategorien= verbindung.alleKategorie();
		String[] kategorieNamen = new String[alleKategorien.length];
		for (int i = 0; i < alleKategorien.length; i++) {
			kategorieNamen[i]=alleKategorien[i].getName();
		}
		return kategorieNamen;
	}
	
	public Object[] holeArtikelKoepfe() {
		String[][] artikelStruktur = Artikel.getStruktur();
		Object[] artikelKopf = new Object[artikelStruktur.length];
		for (int i = 0; i < artikelStruktur.length; i++) {
			artikelKopf[i]=artikelStruktur[i][2];
		}
		return artikelKopf;
	}
	
	public Object[] holeKundenKoepfe() {
		String[][] kundenStruktur = Kunden.getStruktur();
		Object[] kundenKopf = new Object[kundenStruktur.length];
		for (int i = 0; i < kundenStruktur.length; i++) {
			kundenKopf[i]=kundenStruktur[i][2];
		}
		return kundenKopf;
	}
	
	public Object[][] holeArtikelDaten(){
		Artikel[] alleArtikel = verbindung.alleArtikel();
		Object[][] alleObjekte = new Object[alleArtikel.length][];
		for (int i = 0; i < alleArtikel.length; i++) {
			alleObjekte[i]=alleArtikel[i].inArrayUmwandeln();
		}
		return alleObjekte;
	}
	
	public Object[][] holeKundenDaten(){
		Kunden[] alleKunden = verbindung.alleKunden();
		Object[][] alleObjekte = new Object[alleKunden.length][];
		for (int i = 0; i < alleKunden.length; i++) {
			alleObjekte[i]=alleKunden[i].inArrayUmwandeln();
		}
		return alleObjekte;
	}
	
	
	//WindowListener Overrides
	@Override
	public void windowClosing(WindowEvent e) {
		hauptview.setEnabled(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
