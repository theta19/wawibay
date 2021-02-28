package controller.main;

import controller.Controller;
import view.AnmeldeView;
import view.ArtikelView;
import view.HauptView;

//WICHTIG: 	Es gibt derzeit noch einen Bug, nachdem man das Artikelfenster nicht per "X" oben rechts schlie�en darf (Mainframe wird sonst nicht mehr klickbar sein)
//			Leider hat die Zeit da nicht mehr gereicht, aber f�r sp�ter: Man muss wahrscheinlich die "windowClosing"-Methode �berschreiben
//			leider war das nicht so einfach wie gedacht, deshalb habe ich es wieder gel�scht... LG Chris
//			Quelle: https://stackoverflow.com/questions/9093448/how-to-capture-a-jframes-close-button-click-event

/*
 * Sollte gefixt sein. Auswirkungen auf andere Fenster bisher nicht erforscht.
 */

public class Launcher {

	public static void main(String[] args) {
		AnmeldeView anmeldeView = new AnmeldeView();
		HauptView hauptView = new HauptView();
		ArtikelView artikelView = new ArtikelView();
		Controller controller = new Controller(hauptView, anmeldeView, artikelView);

		

		//Anmeldefenster - kommt nach Hauptfenster, damit es dar�ber liegt
		anmeldeView.initialise(controller);
		
		// Hauptfenster
		hauptView.initialise(controller);
		hauptView.setEnabled(false);
		
		anmeldeView.toFront();

	}

}
