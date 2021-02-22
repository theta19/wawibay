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
import javax.swing.JTextField;

import controller.Controller;

public class HauptView extends JFrame {

	JInternalFrame artikelFrame, kundenFrame, lagerFrame;
	JTextField test;

	Controller controller;

	public void initialise(Controller controller) {

		this.controller = controller;

		/** Grundlegendes Fenster: **/

		// Erstellung der Icons/Buttons und Dimensions für alternative Form
		Dimension buttonDimension = new Dimension(100, 50);
		JButton artikelButton = new JButton("Artikel");
		artikelButton.setPreferredSize(buttonDimension);
		artikelButton.addActionListener(controller);
		artikelButton.setActionCommand("artikel");
		JButton lagerButton = new JButton("Lager");
		lagerButton.setPreferredSize(buttonDimension);
		lagerButton.addActionListener(controller);
		lagerButton.setActionCommand("lager");
		JButton kundenButton = new JButton("Kunden");
		kundenButton.setPreferredSize(buttonDimension);
		kundenButton.addActionListener(controller);
		kundenButton.setActionCommand("kunden");
		JButton beendenButton = new JButton("Beenden");
		beendenButton.setPreferredSize(new Dimension(100, 50));

		// Panel für Buttons
		FlowLayout oberesflowLayout = new FlowLayout(FlowLayout.LEFT);
		JPanel navigationsButtonPanel = new JPanel();
		navigationsButtonPanel.setBorder(BorderFactory.createTitledBorder("Navigation"));
		navigationsButtonPanel.setLayout(oberesflowLayout);

		// Buttons hinzufügen
		navigationsButtonPanel.add(artikelButton);
		navigationsButtonPanel.add(lagerButton);
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
		artikelFrame.setClosable(true);

		// Fenster "KUNDEN":
		kundenFrame = new JInternalFrame();
		kundenFrame.setLocation(100, 100);
		kundenFrame.setTitle("Kundenübersicht");
		kundenFrame.setClosable(true);

		// Fenster "LAGER":
		lagerFrame = new JInternalFrame();
		test = new JTextField();
		lagerFrame.add(test);
		lagerFrame.setLocation(100, 100);
		lagerFrame.setTitle("Lagerübersicht");
		lagerFrame.setClosable(true);

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

	public JTextField getTest() {
		return test;
	}
	
	

}
