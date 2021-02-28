package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.Controller;

// Klasse für die Anmeldemaske

public class AnmeldeView extends JFrame{

public void initialise(Controller controller) {
	
	// Designeinstellung nach "Systemstandard"
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (UnsupportedLookAndFeelException e) {
		e.printStackTrace();
	}
	
	//Erstellung des Anmeldepanels
	JPanel anmeldePanel = new JPanel();
	anmeldePanel.setBorder(BorderFactory.createTitledBorder("Anmeldedaten"));
	anmeldePanel.setLayout(new BoxLayout(anmeldePanel, BoxLayout.PAGE_AXIS));
	
	//Benutzername
	JLabel nameLabel = new JLabel("Benutzername/Serveradresse");
	JTextField nameField = new JTextField(40);
	nameField.setMaximumSize(nameField.getPreferredSize());
	
	//Passwort
	JLabel passwortLabel = new JLabel("Passwort");
	JTextField passwordField = new JTextField(40);
	passwordField.setMaximumSize(passwordField.getPreferredSize());
	
	//Hinzufügen zum Anmeldepanel
	anmeldePanel.add(nameLabel);
	anmeldePanel.add(nameField);
	anmeldePanel.add(passwortLabel);
	anmeldePanel.add(passwordField);
	
	//Erstellung Buttons
	JButton anmeldeButton = new JButton("Anmelden");
	JButton abbrechenButton = new JButton("Abbrechen");
	abbrechenButton.addActionListener(controller);
	abbrechenButton.setActionCommand("beenden");
	anmeldeButton.addActionListener(controller);
	anmeldeButton.setActionCommand("anmelden");
	
	//Erstellung des Buttonpanels (Layoutgründe...)
	JPanel buttonPanel = new JPanel(new BorderLayout());
	buttonPanel.add(anmeldeButton, BorderLayout.WEST);
	buttonPanel.add(abbrechenButton, BorderLayout.EAST);
	
	this.setResizable(false);
	this.add(anmeldePanel);
	this.add(buttonPanel, BorderLayout.SOUTH);
	this.setSize(350, 350);
	this.setTitle("Anmelden bei WaWiBay");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	

	
}

}