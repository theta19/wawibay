package controller.main;

import controller.Controller;
import view.AnmeldeView;
import view.ArtikelView;
import view.HauptView;

public class Launcher {

	public static void main(String[] args) {
		AnmeldeView anmeldeView = new AnmeldeView();
		HauptView hauptView = new HauptView();
		ArtikelView artikelView = new ArtikelView();
		Controller controller = new Controller(hauptView, anmeldeView, artikelView);

		// Hauptfenster
		hauptView.initialise(controller);

		// Anmeldefenster - kommt nach Hauptfenster, damit es darüber liegt
		//anmeldeView.initialise(controller);

	}

}
