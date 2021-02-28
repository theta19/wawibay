package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.Controller;

// Das hier ist das Fenster beim Klicken von "neuer Artikel..."

public class ArtikelView extends JFrame {

	Controller controller;
	HauptView hauptview;
	ArtikelView artikelview;
	JTextField 
	//artikelNrTextfield,
	nameTextfield, beschreibungTextfield, bruttoPreisTextfield, bestandTextfield,
			groesseTextfield, farbeTextfield, materialTextfield;
	JComboBox<String> kategorieCombobox, steuersatzCombobox;

	public void initialise(Controller controller) {

		this.addWindowListener(controller);

		this.controller = controller;

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

		// Hier sind die Reiter inkl. Panels
		JTabbedPane artikelTabbedPane = new JTabbedPane();
		JPanel allgemeinReiterPanel = new JPanel();
		allgemeinReiterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		JPanel variationReiterPanel = new JPanel();
		variationReiterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		artikelTabbedPane.addTab("Allgemein", allgemeinReiterPanel);
		artikelTabbedPane.addTab("Variationen", variationReiterPanel);

		Dimension buttonDimension = new Dimension(150, 50);

		// Reiter "Allgemein" befüllen
//		JPanel artikelNrPanel = new JPanel();
//		artikelNrPanel.setLayout(new BorderLayout());
//		artikelNrPanel.setBorder(BorderFactory.createTitledBorder("Bevorzugte Artikelnummer"));
//		artikelNrTextfield = new JTextField(50);
//		artikelNrTextfield.setMaximumSize(artikelNrTextfield.getPreferredSize());
//		artikelNrPanel.add(artikelNrTextfield);

		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BorderLayout());
		namePanel.setBorder(BorderFactory.createTitledBorder("Artikelbezeichnung"));
		namePanel.setPreferredSize(new Dimension(200, 80));
		nameTextfield = new JTextField(50);
		nameTextfield.setMaximumSize(nameTextfield.getPreferredSize());
		namePanel.add(nameTextfield);

		JPanel beschreibungPanel = new JPanel();
		beschreibungPanel.setLayout(new BorderLayout());
		beschreibungPanel.setBorder(BorderFactory.createTitledBorder("Beschreibung"));
		beschreibungTextfield = new JTextField(50);
		beschreibungTextfield.setPreferredSize(new Dimension(200, 200));
		beschreibungTextfield.setMaximumSize(beschreibungTextfield.getPreferredSize());
		beschreibungPanel.add(beschreibungTextfield);

		String waehrungsListe[] = { "€", "$", "£" };
		JComboBox<String> waehrungsCombobox = new JComboBox<String>(waehrungsListe);
		waehrungsCombobox.setPreferredSize(new Dimension(80, 20));

		JPanel bruttopreisPanel = new JPanel();
		bruttopreisPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		bruttopreisPanel.setBorder(BorderFactory.createTitledBorder("Bruttopreis"));
		bruttoPreisTextfield = new JTextField(50);
		bruttoPreisTextfield.setMaximumSize(bruttoPreisTextfield.getPreferredSize());
		bruttopreisPanel.add(bruttoPreisTextfield);
		bruttopreisPanel.add(waehrungsCombobox);

		JPanel steuersatzPanel = new JPanel();
		steuersatzPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		steuersatzPanel.setBorder(BorderFactory.createTitledBorder("Steuersatz"));
		String steuerSatzListe[] = { "19", "16", "7", "5" };
		steuersatzCombobox = new JComboBox<String>(steuerSatzListe);
		JLabel prozentLabel = new JLabel("%");

		steuersatzPanel.add(steuersatzCombobox);
		steuersatzPanel.add(prozentLabel);

		JPanel bestandPanel = new JPanel();
		bestandPanel.setLayout(new BorderLayout());
		bestandPanel.setBorder(BorderFactory.createTitledBorder("Bestand"));
		bestandTextfield = new JTextField(10);
		bestandTextfield.setMaximumSize(bestandTextfield.getPreferredSize());
		bestandPanel.add(bestandTextfield);

		// @Basti: Kategorien müssen später per Stream o.ä. gezogen werden - hier zur
		// Demo paar Beispiele
		// Done
		JPanel kategoriePanel = new JPanel();
		kategoriePanel.setLayout(new BorderLayout());
		kategoriePanel.setBorder(BorderFactory.createTitledBorder("Kategorie"));
//		String kategorieListe[] = {"Kategorie1", "Kategorie2", "Kategorie3", "Kategorie4"};
		String kategorieListe[] = controller.alleKategorienNurNamenAlsStringArray();
		kategorieCombobox = new JComboBox<String>(kategorieListe);
		kategoriePanel.add(kategorieCombobox);

		// Unterteilung mit Panels
		JPanel allgemeinEintragenPanel = new JPanel();
		allgemeinEintragenPanel.setLayout(new BoxLayout(allgemeinEintragenPanel, BoxLayout.Y_AXIS));
		allgemeinEintragenPanel.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.black));

		allgemeinEintragenPanel.add(kategoriePanel);
//		allgemeinEintragenPanel.add(Box.createVerticalStrut(10));
//		allgemeinEintragenPanel.add(artikelNrPanel);
		allgemeinEintragenPanel.add(Box.createVerticalStrut(10));
		allgemeinEintragenPanel.add(namePanel);
		allgemeinEintragenPanel.add(Box.createVerticalStrut(10));
		allgemeinEintragenPanel.add(beschreibungPanel);
		allgemeinEintragenPanel.add(Box.createVerticalStrut(10));
		allgemeinEintragenPanel.add(bruttopreisPanel);
		allgemeinEintragenPanel.add(Box.createVerticalStrut(10));
		allgemeinEintragenPanel.add(steuersatzPanel);
		allgemeinEintragenPanel.add(Box.createVerticalStrut(10));
		allgemeinEintragenPanel.add(bestandPanel);

		JPanel allgemeinButtonPanel = new JPanel();
		allgemeinButtonPanel.setLayout(new BoxLayout(allgemeinButtonPanel, BoxLayout.Y_AXIS));
		allgemeinButtonPanel.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.black));

		// Buttons
		JButton artikelSpeichernButton = new JButton("Speichern");
		artikelSpeichernButton.setPreferredSize(buttonDimension);
		artikelSpeichernButton.setMaximumSize(buttonDimension);
		artikelSpeichernButton.addActionListener(controller);
		artikelSpeichernButton.setActionCommand("artikelSpeichern");

		JButton allesLoeschenButton = new JButton("Alles löschen");
		allesLoeschenButton.setPreferredSize(buttonDimension);
		allesLoeschenButton.setMaximumSize(buttonDimension);
		allesLoeschenButton.addActionListener(controller);
		allesLoeschenButton.setActionCommand("artikelAllesLoeschen");

		JButton artikelSchließenButton = new JButton("Schließen");
		artikelSchließenButton.setPreferredSize(buttonDimension);
		artikelSchließenButton.setMaximumSize(buttonDimension);
		artikelSchließenButton.addActionListener(controller);
		artikelSchließenButton.setActionCommand("arikelFensterSchliessen");

		allgemeinButtonPanel.add(artikelSpeichernButton);
		allgemeinButtonPanel.add(Box.createVerticalStrut(10));
		allgemeinButtonPanel.add(allesLoeschenButton);
		allgemeinButtonPanel.add(Box.createVerticalStrut(10));
		allgemeinButtonPanel.add(artikelSchließenButton);

		allgemeinReiterPanel.add(allgemeinEintragenPanel);
		allgemeinReiterPanel.add(allgemeinButtonPanel);

		// Reiter "Variationen"

		JPanel variationenEintragenPanel = new JPanel();
		variationenEintragenPanel.setLayout(new BoxLayout(variationenEintragenPanel, BoxLayout.Y_AXIS));
		variationenEintragenPanel.setBorder(BorderFactory.createEtchedBorder(Color.GREEN, Color.black));

		// Befüllen des Variationsreiters

		JPanel groessePanel = new JPanel();
		groessePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		groessePanel.setBorder(BorderFactory.createTitledBorder("Größe"));
		groesseTextfield = new JTextField(20);
		groesseTextfield.setMaximumSize(groesseTextfield.getPreferredSize());
		String einheitenListe[] = { "mm", "cm", "m", "Zoll", "Stück" };
		JComboBox<String> einheitenCombobox = new JComboBox<String>(einheitenListe);
		einheitenCombobox.setPreferredSize(new Dimension(80, 20));
		groessePanel.add(groesseTextfield);
		groessePanel.add(einheitenCombobox);

		JPanel farbePanel = new JPanel();
		farbePanel.setLayout(new BorderLayout());
		farbePanel.setBorder(BorderFactory.createTitledBorder("Farbe"));
		farbeTextfield = new JTextField(20);
		farbeTextfield.setMaximumSize(farbeTextfield.getPreferredSize());
		farbePanel.add(farbeTextfield);

		JPanel materialPanel = new JPanel();
		materialPanel.setLayout(new BorderLayout());
		materialPanel.setBorder(BorderFactory.createTitledBorder("Material"));
		materialTextfield = new JTextField(20);
		materialTextfield.setMaximumSize(materialTextfield.getPreferredSize());
		materialPanel.add(materialTextfield);

		variationenEintragenPanel.add(groessePanel);
		variationenEintragenPanel.add(Box.createVerticalStrut(10));
		variationenEintragenPanel.add(farbePanel);
		variationenEintragenPanel.add(Box.createVerticalStrut(10));
		variationenEintragenPanel.add(materialPanel);

		JPanel variationenButtonPanel = new JPanel();
		variationenButtonPanel.setLayout(new BoxLayout(variationenButtonPanel, BoxLayout.Y_AXIS));
		variationenButtonPanel.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.black));

		JButton variationenSpeichernButton = new JButton("Speichern");
		variationenSpeichernButton.setPreferredSize(buttonDimension);
		variationenSpeichernButton.setMaximumSize(buttonDimension);
		variationenSpeichernButton.addActionListener(controller);
		variationenSpeichernButton.setActionCommand("artikelSpeichern");

		JButton variationenLoeschenButton = new JButton("Alles Löschen");
		variationenLoeschenButton.setPreferredSize(buttonDimension);
		variationenLoeschenButton.setMaximumSize(buttonDimension);
		variationenLoeschenButton.addActionListener(controller);
		variationenLoeschenButton.setActionCommand("artikelAllesLoeschen");

		JButton variationenSchliessenButton = new JButton("Schließen");
		variationenSchliessenButton.setPreferredSize(buttonDimension);
		variationenSchliessenButton.setMaximumSize(buttonDimension);
		variationenSchliessenButton.addActionListener(controller);
		variationenSchliessenButton.setActionCommand("arikelFensterSchliessen");

		variationenButtonPanel.add(variationenSpeichernButton);
		variationenButtonPanel.add(Box.createVerticalStrut(6));
		variationenButtonPanel.add(variationenLoeschenButton);
		variationenButtonPanel.add(Box.createVerticalStrut(6));
		variationenButtonPanel.add(variationenSchliessenButton);

		variationReiterPanel.add(variationenEintragenPanel);
		variationReiterPanel.add(variationenButtonPanel);

		this.add(artikelTabbedPane);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Artikel anlegen/bearbeiten");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

//	public JTextField getArtikelNrTextfield() {
//		return artikelNrTextfield;
//	}
//
//	public void setArtikelNrTextfield(JTextField artikelNrTextfield) {
//		this.artikelNrTextfield = artikelNrTextfield;
//	}

	public JTextField getNameTextfield() {
		return nameTextfield;
	}

	public void setNameTextfield(JTextField nameTextfield) {
		this.nameTextfield = nameTextfield;
	}

	public JTextField getBeschreibungTextfield() {
		return beschreibungTextfield;
	}

	public void setBeschreibungTextfield(JTextField beschreibungTextfield) {
		this.beschreibungTextfield = beschreibungTextfield;
	}

	public JTextField getBruttoPreisTextfield() {
		return bruttoPreisTextfield;
	}

	public void setBruttoPreisTextfield(JTextField bruttoPreisTextfield) {
		this.bruttoPreisTextfield = bruttoPreisTextfield;
	}

	public JTextField getBestandTextfield() {
		return bestandTextfield;
	}

	public void setBestandTextfield(JTextField bestandTextfield) {
		this.bestandTextfield = bestandTextfield;
	}

	public JTextField getGroesseTextfield() {
		return groesseTextfield;
	}

	public void setGroesseTextfield(JTextField groesseTextfield) {
		this.groesseTextfield = groesseTextfield;
	}

	public JTextField getFarbeTextfield() {
		return farbeTextfield;
	}

	public void setFarbeTextfield(JTextField farbeTextfield) {
		this.farbeTextfield = farbeTextfield;
	}

	public JTextField getMaterialTextfield() {
		return materialTextfield;
	}

	public void setMaterialTextfield(JTextField materialTextfield) {
		this.materialTextfield = materialTextfield;
	}

	public JComboBox<String> getKategorieCombobox() {
		return kategorieCombobox;
	}

	public void setKategorieCombobox(JComboBox<String> kategorieCombobox) {
		this.kategorieCombobox = kategorieCombobox;
	}

	public JComboBox<String> getSteuersatzCombobox() {
		return steuersatzCombobox;
	}

	public void setSteuersatzCombobox(JComboBox<String> steuersatzCombobox) {
		this.steuersatzCombobox = steuersatzCombobox;
	}
	
	

}
