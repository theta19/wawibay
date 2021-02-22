package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.HauptView;

public class Controller implements ActionListener {

	HauptView hauptview;

	public Controller(HauptView hauptview) {
		this.hauptview = hauptview;
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
			hauptview.getTest().setText("Hallo Welt");
			hauptview.getKundenFrame().setVisible(true);
			break;

		case "lager":
			hauptview.add(hauptview.getLagerFrame());
			schliesseInternalFrames();
			
			hauptview.getLagerFrame().setVisible(true);

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
