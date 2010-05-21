package no.thunaes.petter.svg.app.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import no.thunaes.petter.svg.app.Controller;

public class MainMenu extends JMenuBar implements ActionListener {

	JMenuItem save = new JMenuItem("Save");
	JMenuItem exit = new JMenuItem("Exit");
	
	public MainMenu() {
		JMenu file = new JMenu("File");
		
		file.add(save).addActionListener(this);
		file.add(exit).addActionListener(this);
		
		add(file);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(save)) {
			Controller.save();
		}
		if (arg0.getSource().equals(exit)) {
			Controller.exit();
		}
		
	}
}
