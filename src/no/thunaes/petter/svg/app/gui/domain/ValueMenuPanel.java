package no.thunaes.petter.svg.app.gui.domain;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.thunaes.petter.svg.app.Controller;

public class ValueMenuPanel extends JPanel implements ActionListener {
	
	private JButton valueAddButton = new JButton("Add");
	private ItemPanel itemPanel;
	
	public ValueMenuPanel(ItemPanel itemPanel) {
		this.itemPanel = itemPanel;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		valueAddButton.addActionListener(this);
		add(valueAddButton);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Controller.addValuePanel(itemPanel);
	}
}
