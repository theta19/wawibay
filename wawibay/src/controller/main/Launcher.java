package controller.main;

import controller.Controller;
import view.AnmeldeView;
import view.StartView;

public class Launcher {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		AnmeldeView anmeldeView = new AnmeldeView();
		StartView startView = new StartView();
		
		//@Basti: Die Methode aufrufen für Hauptfenster
		startView.initialise(controller);
		
		//Auskommentiert zu Testzwecken:
		anmeldeView.initialise(controller);

	}

}
