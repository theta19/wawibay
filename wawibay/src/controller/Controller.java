package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.AnmeldeView;
import view.ArtikelView;
import view.HauptView;

public class Controller implements ActionListener {

	HauptView hauptview;
	AnmeldeView anmeldeview;
	ArtikelView artikelview;

	public Controller(HauptView hauptview, AnmeldeView anmeldeview, ArtikelView artikelview) {
		this.hauptview = hauptview;
		this.anmeldeview = anmeldeview;
		this.artikelview = artikelview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		
		//Derzeit zu Testzwecken (Stand 27.02.) einfach per Klick auf "Anmelden" startbar. Später Abfrage der Zugangsdaten nötig
		case "anmelden":
			
			anmeldeview.dispose();
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

}
