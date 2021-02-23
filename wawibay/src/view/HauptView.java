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

	//Testdaten
	Object[][] data = { { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" },
			{ "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" },
			{ "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" },
			{ "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" },
			{ "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" },
			{ "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" },
			{ "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" }, { "a", "b" },
			{ "a", "b" }, { "a", "b" } };
	Object[] head = {"A","B"}; 

	Controller controller;

	public void initialise(Controller controller) {

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
		FlowLayout oberesflowLayout = new FlowLayout(FlowLayout.LEFT);
		JPanel navigationsButtonPanel = new JPanel();
		navigationsButtonPanel.setBorder(BorderFactory.createTitledBorder("Navigation"));
		navigationsButtonPanel.setLayout(oberesflowLayout);

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
		JButton kategorieNeuButton = new JButton("Neue Kategorie...");
		JButton bearbeitenButton = new JButton("Artikel bearbeiten...");
		JButton loeschenButton = new JButton("Artikel löschen");

		// Größen der Buttons festlegen
		artikelNeuButton.setPreferredSize(artikelNavigationDimension);
		kategorieNeuButton.setPreferredSize(artikelNavigationDimension);
		bearbeitenButton.setPreferredSize(artikelNavigationDimension);
		loeschenButton.setPreferredSize(artikelNavigationDimension);

		// Buttons zum ArtikelNavigationPanel hinzufügen
		JPanel artikelNavigationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		artikelNavigationPanel.setBorder(BorderFactory.createTitledBorder("Artikelnavigation"));
		artikelNavigationPanel.add(artikelNeuButton);
		artikelNavigationPanel.add(bearbeitenButton);
		artikelNavigationPanel.add(loeschenButton);
		artikelNavigationPanel.add(kategorieNeuButton);

		// Actionlisteners und ActionCommands für alle Buttons
		artikelNeuButton.addActionListener(controller);
		artikelNeuButton.setActionCommand("neuerArtikel");

		kategorieNeuButton.addActionListener(controller);
		kategorieNeuButton.setActionCommand("neueKategorie");

		bearbeitenButton.addActionListener(controller);
		bearbeitenButton.setActionCommand("bearbeiteArtikel");

		loeschenButton.addActionListener(controller);
		loeschenButton.setActionCommand("loescheArtikel");

		// Tabelle für die Artikel inkl. Sortierer und Scrollpane
		JTable artikelTable = new JTable(data, head);
		artikelTable.setDragEnabled(false);
		artikelTable.setAutoCreateRowSorter(true);
		JScrollPane artikelScrollPane = new JScrollPane(artikelTable);

		// Hinzufügen zum großen Artikelframe
		artikelFrame.add(artikelNavigationPanel, BorderLayout.SOUTH);
		artikelFrame.add(artikelScrollPane);

		// Fenster "KUNDEN":
		kundenFrame = new JInternalFrame();
		kundenFrame.setLocation(100, 100);
		kundenFrame.setTitle("Kundenübersicht");

		// Fenster "LAGER":
		lagerFrame = new JInternalFrame();
		lagerFrame.setLocation(100, 100);
		lagerFrame.setTitle("Lagerübersicht");

		this.add(beendenPanel, BorderLayout.SOUTH);
		this.add(navigationsButtonPanel, BorderLayout.NORTH);
		this.setTitle("WaWiBay");
		this.setVisible(true);
		this.setSize(800, 600);
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

}
