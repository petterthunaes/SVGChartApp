package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ValuePanel extends JPanel {

	JLabel labOne= new JLabel("Value 1");
	JLabel labTwo = new JLabel("Value 2");
	JLabel labThr = new JLabel("Value 3");
	
	JTextField txtOne = new JTextField(8);
	JTextField txtTwo = new JTextField(8);
	JTextField txtThr = new JTextField(8);
	
	JButton removeVal = new JButton("-");
	
	public ValuePanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		labOne.setPreferredSize(new Dimension(92,15));
		labTwo.setPreferredSize(new Dimension(92,15));
		labThr.setPreferredSize(new Dimension(92,15));		
		
		add(labOne);
		add(labTwo);
		add(labThr);
		add(txtOne);
		add(txtTwo);
		add(txtThr);
		add(removeVal);
	}
}
