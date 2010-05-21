package no.thunaes.petter.svg.app.gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class NorthPanel extends JPanel {

	private MainMenu menu;
	
	public NorthPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(menu = new MainMenu());
		
	}

}
