package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import no.smidsrod.robin.svg.library.Range;

public class RangeEditWindow extends JFrame {

	JLabel labMin = new JLabel("Min");
	JLabel labMax = new JLabel("Max");
	JLabel labUni = new JLabel("Unit");
	
	JTextField txtMin = new JTextField(5);
	JTextField txtMax = new JTextField(5);
	JTextField txtUni = new JTextField(5);
	
	public RangeEditWindow(Range range) {
		labMin.setPreferredSize(new Dimension(60, 10));
		labMax.setPreferredSize(new Dimension(60, 10));
		labUni.setPreferredSize(new Dimension(60, 10));
			
		setSize(220,200);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setTitle("Axis-settings " + range.getDimension());		
		
		add(labMin);
		add(labMax);
		add(labUni);
		add(txtMin);
		add(txtMax);
		add(txtUni);
		setVisible(true);

	}

}
