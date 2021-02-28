package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.JTableHeader;

import controller.Controller;

public class HauptView extends JFrame {

	JInternalFrame artikelFrame, kundenFrame, lagerFrame;
	JTable artikelTable;

	Controller controller;
	Object [][] tabellendaten;

	public void initialise(Controller controller) {

		this.controller = controller;
//		this.addWindowListener(controller);

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

		/** Grundlegendes Fenster: **/

		// Erstellung der Icons/Buttons und Dimensions für alternative Form
		Dimension buttonDimension = new Dimension(100, 50);
		JButton artikelButton = new JButton("Artikel");
		artikelButton.setPreferredSize(buttonDimension);
		artikelButton.addActionListener(controller);
		artikelButton.setActionCommand("artikel");
		JButton kundenButton = new JButton("Kunden");
		kundenButton.setPreferredSize(buttonDimension);
		kundenButton.addActionListener(controller);
		kundenButton.setActionCommand("kunden");
		JButton beendenButton = new JButton("Beenden");
		beendenButton.setPreferredSize(buttonDimension);
		beendenButton.addActionListener(controller);
		beendenButton.setActionCommand("beenden");

		// Panel für Buttons
		FlowLayout linkesflowLayout = new FlowLayout(FlowLayout.LEFT);
		JPanel navigationsButtonPanel = new JPanel();
		navigationsButtonPanel.setBorder(BorderFactory.createTitledBorder("Navigation"));
		navigationsButtonPanel.setLayout(linkesflowLayout);

		// Buttons hinzufügen
		navigationsButtonPanel.add(artikelButton);
		navigationsButtonPanel.add(kundenButton);

		JPanel beendenPanel = new JPanel(new BorderLayout());
		beendenPanel.setBorder(BorderFactory.createTitledBorder(""));
		beendenPanel.add(beendenButton, BorderLayout.EAST);

		FlowLayout unteresFlowLayout = new FlowLayout(FlowLayout.RIGHT, 10, 10);
		beendenPanel.setLayout(unteresFlowLayout);

		/** InternalFrames als integrierte Fenster **/

		// Fenster "ARTIKEL":
		artikelFrame = new JInternalFrame();
		artikelFrame.setLocation(100, 100);
		artikelFrame.setTitle("Artikelübersicht");

		// Befüllen des Fensters "ARTIKEL" mit Buttons usw.
		Dimension artikelNavigationDimension = new Dimension(200, 50);
		JButton artikelNeuButton = new JButton("Neuer Artikel...");
//		JButton kategorieNeuButton = new JButton("Neue Kategorie...");
		JButton bearbeitenButton = new JButton("Artikel bearbeiten...");
		JButton loeschenButton = new JButton("Artikel löschen");
		JButton artikelListeAktualisierenButton = new JButton("Liste aktualisieren");

		// Größen der Buttons festlegen
		artikelNeuButton.setPreferredSize(artikelNavigationDimension);
		bearbeitenButton.setPreferredSize(artikelNavigationDimension);
		loeschenButton.setPreferredSize(artikelNavigationDimension);
		artikelListeAktualisierenButton.setPreferredSize(artikelNavigationDimension);

		// Buttons zum ArtikelNavigationPanel hinzufügen
		JPanel artikelNavigationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		artikelNavigationPanel.setBorder(BorderFactory.createTitledBorder("Artikelnavigation"));
		artikelNavigationPanel.add(artikelNeuButton);
		artikelNavigationPanel.add(bearbeitenButton);
		artikelNavigationPanel.add(loeschenButton);
//		artikelNavigationPanel.add(kategorieNeuButton);
		artikelNavigationPanel.add(artikelListeAktualisierenButton);

		// Actionlisteners und ActionCommands für alle Buttons
		artikelNeuButton.addActionListener(controller);
		artikelNeuButton.setActionCommand("neuerArtikel");

//		kategorieNeuButton.addActionListener(controller);
//		kategorieNeuButton.setActionCommand("neueKategorie");

		bearbeitenButton.addActionListener(controller);
		bearbeitenButton.setActionCommand("bearbeiteArtikel");

		loeschenButton.addActionListener(controller);
		loeschenButton.setActionCommand("loescheArtikel");

		artikelListeAktualisierenButton.addActionListener(controller);
		artikelListeAktualisierenButton.setActionCommand("aktualisiereArtikelListe");

		// Tabelle für die Artikel inkl. Sortierer und Scrollpane
		tabellendaten = controller.holeArtikelDaten();
		artikelTable = new JTable(tabellendaten, controller.holeArtikelKoepfe());
//		artikelTable.setmodel
		artikelTable.setDragEnabled(false);
		artikelTable.setAutoCreateRowSorter(true);
		JScrollPane artikelScrollPane = new JScrollPane(artikelTable);

		// Hinzufügen zum großen Artikelframe
		artikelFrame.add(artikelNavigationPanel, BorderLayout.SOUTH);
		artikelFrame.add(artikelScrollPane);

		/* Fenster Kunden */

		// Tabelle für die Kunden inkl. Sortierer und Scrollpane
		JTable kundenTable = new JTable(controller.holeKundenDaten(), controller.holeKundenKoepfe());
		kundenTable.setDragEnabled(false);
		kundenTable.setAutoCreateRowSorter(true);
		JScrollPane kundenScrollPane = new JScrollPane(kundenTable);

		JPanel kundenNavigationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		kundenNavigationPanel.setBorder(BorderFactory.createTitledBorder("Kundennavigation"));

		JButton kundenListeAktualisierenButton = new JButton("Kundenliste aktualisieren");
		kundenListeAktualisierenButton.addActionListener(controller);
		kundenListeAktualisierenButton.setActionCommand("aktualisiereKundenListe");
		kundenListeAktualisierenButton.setPreferredSize(artikelNavigationDimension);

		kundenNavigationPanel.add(kundenListeAktualisierenButton);

		kundenFrame = new JInternalFrame();
		kundenFrame.setLocation(100, 100);
		kundenFrame.setTitle("Kundenübersicht");
		kundenFrame.add(kundenScrollPane);
		kundenFrame.add(kundenNavigationPanel, BorderLayout.SOUTH);

		this.add(beendenPanel, BorderLayout.SOUTH);
		this.add(navigationsButtonPanel, BorderLayout.NORTH);
		this.setTitle("WaWiBay");
		this.setVisible(true);
		this.setSize(1280, 720);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public JInternalFrame getArtikelFrame() {
		return artikelFrame;
	}

	public void setArtikelFrame(JInternalFrame artikelFrame) {
		this.artikelFrame = artikelFrame;
	}

	public JInternalFrame getKundenFrame() {
		return kundenFrame;
	}

	public void setKundenFrame(JInternalFrame kundenFrame) {
		this.kundenFrame = kundenFrame;
	}

	public JInternalFrame getLagerFrame() {
		return lagerFrame;
	}

	public void setLagerFrame(JInternalFrame lagerFrame) {
		this.lagerFrame = lagerFrame;
	}

	public JTable getArtikelTable() {
		return artikelTable;
	}

	public void setArtikelTable(JTable artikelTable) {
		this.artikelTable = artikelTable;
	}

	public Object[][] getTabellendaten() {
		return tabellendaten;
	}

	public void setTabellendaten(Object[][] tabellendaten) {
		this.tabellendaten = tabellendaten;
	}
	
	
	

}
