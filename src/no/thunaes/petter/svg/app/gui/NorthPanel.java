package no.thunaes.petter.svg.app.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.thunaes.petter.svg.app.Controller;

public class NorthPanel extends JPanel implements ActionListener {

	private JButton button;
	
	public NorthPanel() {
		button = new JButton("Hello?");
		button.addActionListener(this);
		add(button);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Controller.hello();
		
	}
}
