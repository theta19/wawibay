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
			
			break;
			
		case "beenden":
			hauptview.dispose();
			anmeldeview.dispose();
			artikelview.dispose();
			
			break;
			
		case "arikelFensterSchliessen":
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
