package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemPanel extends JPanel {
	
	JButton valueAdd = new JButton("V");
	JButton valueDel = new JButton("-");
	
	JLabel labName = new JLabel("Label");
	JLabel labColr = new JLabel("Color");
	JLabel labHigh = new JLabel("Highlight");
	
	JTextField valLabel = new JTextField(10);
	JCheckBox  valHighl = new JCheckBox();
	JTextField valColor = new JTextField(7);
	
	public ItemPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		labName.setPreferredSize(new Dimension(115, 15));
		labColr.setPreferredSize(new Dimension(82,15));
		labHigh.setPreferredSize(new Dimension(70,15));
		
		valHighl.setPreferredSize(new Dimension(70, 15));

		valueAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ValueEditWindow();
				
			}
		});
		
		add(labName);
		add(labColr);
		add(labHigh);
		add(valLabel);
		add(valColor);		
		add(valHighl);
		add(valueAdd);
		add(valueDel);

	}

}
