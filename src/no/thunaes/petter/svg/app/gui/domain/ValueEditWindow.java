package no.thunaes.petter.svg.app.gui.domain;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ValueEditWindow extends JFrame {

	JPanel test = new JPanel();
	
	public ValueEditWindow() {
		test.setLayout(new BoxLayout(test, BoxLayout.Y_AXIS));
		
		setSize(370,500);
		setVisible(true);
		
		test.add(new ValuePanel());
		test.add(new ValuePanel());
		test.add(new ValuePanel());
		
		add(new JButton("Add"), BorderLayout.NORTH);
		add(test, BorderLayout.CENTER);
	}
}
