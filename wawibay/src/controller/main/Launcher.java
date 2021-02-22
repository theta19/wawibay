package controller.main;

import controller.Controller;
import view.AnmeldeView;
import view.HauptView;

public class Launcher {

	public static void main(String[] args) {
		AnmeldeView anmeldeView = new AnmeldeView();
		HauptView hauptView = new HauptView();
		Controller controller = new Controller(hauptView);
		
		//Hauptfenster
		hauptView.initialise(controller);
		
		//Anmeldefenster - kommt nach Hauptfenster, damit es darüber liegt
		//anmeldeView.initialise(controller);

	}

}
