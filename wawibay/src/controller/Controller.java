package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.AnmeldeView;
import view.HauptView;

public class Controller implements ActionListener {

	HauptView hauptview;
	AnmeldeView anmeldeview;

	

	public Controller(HauptView hauptview, AnmeldeView anmeldeview) {
		this.hauptview = hauptview;
		this.anmeldeview = anmeldeview;
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

		case "lager":
			hauptview.add(hauptview.getLagerFrame());
			schliesseInternalFrames();

			hauptview.getLagerFrame().setVisible(true);

			break;

		case "beenden":
			hauptview.dispose();
			anmeldeview.dispose();
			break;

		default:
			break;
		}

	}

	private void schliesseInternalFrames() {
		hauptview.getArtikelFrame().dispose();
		hauptview.getKundenFrame().dispose();
		hauptview.getLagerFrame().dispose();

	}

}
