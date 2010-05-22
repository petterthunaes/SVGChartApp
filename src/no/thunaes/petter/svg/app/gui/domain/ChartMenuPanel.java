package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.thunaes.petter.svg.app.Controller;

public class ChartMenuPanel extends JPanel implements ActionListener {

	private JButton addItemButton = new JButton("Add Item");
	
	public ChartMenuPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		addItemButton.addActionListener(this);
		addItemButton.setEnabled(false);
		add(addItemButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Controller.addItemPanel();
		
	}

	public void enableAddItem() {
		addItemButton.setEnabled(true);
	}
	
}
