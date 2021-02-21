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
import javax.swing.JPanel;

import controller.Controller;

public class StartView extends JFrame{
	
	public void initialise(Controller controller) {
		
		//Erstellung der Icons/Buttons und Dimensions für alternative Form
		Dimension buttonDimension = new Dimension(100, 50);
		JButton artikelButton = new JButton("Artikel");
		artikelButton.setPreferredSize(buttonDimension);
		JButton lagerButton = new JButton("Lager");
		lagerButton.setPreferredSize(buttonDimension);
		JButton kundenButton = new JButton("Kunden");
		kundenButton.setPreferredSize(buttonDimension);
		JButton beendenButton = new JButton("Beenden");
		beendenButton.setPreferredSize(new Dimension(100, 50));
		
		//Panel für Buttons
		FlowLayout oberesflowLayout = new FlowLayout(FlowLayout.LEFT);
		JPanel navigationsButtonPanel = new JPanel();
		navigationsButtonPanel.setBorder(BorderFactory.createTitledBorder("Navigation"));
		navigationsButtonPanel.setLayout(oberesflowLayout);
		
		//Buttons hinzufügen
		navigationsButtonPanel.add(artikelButton);
		navigationsButtonPanel.add(lagerButton);
		navigationsButtonPanel.add(kundenButton);
		
		JPanel beendenPanel = new JPanel(new BorderLayout());
		beendenPanel.setBorder(BorderFactory.createTitledBorder(""));
		beendenPanel.add(beendenButton, BorderLayout.EAST);
		
		FlowLayout unteresFlowLayout = new FlowLayout(FlowLayout.RIGHT, 10, 10);
		beendenPanel.setLayout(unteresFlowLayout);
		
		this.add(beendenPanel, BorderLayout.SOUTH);
		this.add(navigationsButtonPanel, BorderLayout.NORTH);
		this.setTitle("WaWiBay");
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}


}
