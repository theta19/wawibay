package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.Controller;

public class ArtikelView extends JFrame {

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

		JTabbedPane artikelTabbedPane = new JTabbedPane();
		JPanel allgemeinPanel = new JPanel();
		JPanel variationPanel = new JPanel();

		artikelTabbedPane.addTab("Allgemein", allgemeinPanel);
		artikelTabbedPane.addTab("Variationen", variationPanel);

		this.add(artikelTabbedPane);
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setTitle("Neuen Artikel anlegen");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

}
