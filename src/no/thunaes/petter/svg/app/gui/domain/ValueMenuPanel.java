package no.thunaes.petter.svg.app.gui.domain;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.thunaes.petter.svg.app.Controller;

public class ValueMenuPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ItemPanel itemPanel;

	public ValueMenuPanel(ItemPanel itemPanel) {
		this.itemPanel = itemPanel;
		setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton addValueButton = new JButton("Add Value");
		addValueButton.addActionListener(this);
		add(addValueButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Controller.addValuePanel(itemPanel);
	}
}
