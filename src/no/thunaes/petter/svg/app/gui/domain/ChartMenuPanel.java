package no.thunaes.petter.svg.app.gui.domain;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.thunaes.petter.svg.app.Controller;

public class ChartMenuPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

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
		if (addItemButton.isEnabled()) {
			addItemButton.setEnabled(false);
		} else {
			addItemButton.setEnabled(true);
		}
	}

}
