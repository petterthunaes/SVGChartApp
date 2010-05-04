package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChartValues extends JPanel {
	
	JButton btnNewValue = new JButton("+");
	
	public ChartValues() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(btnNewValue);
	}
}
