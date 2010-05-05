package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import no.smidsrod.robin.svg.library.Range;

public class AxisEditWindow extends JFrame {
	
	JLabel labMin = new JLabel("Min");
	JLabel labMax = new JLabel("Max");
	JLabel labUni = new JLabel("Unit");	
	JTextField txtMin = new JTextField(5);
	JTextField txtMax = new JTextField(5);
	JTextField txtUni = new JTextField(5);
	
	JLabel labInt = new JLabel("Interval");
	JLabel labCun = new JLabel("Count");
	JLabel labEnb = new JLabel("Enable");
	JTextField txtInt = new JTextField(5);
	JTextField txtCun = new JTextField(5);
	JCheckBox chbEnb = new JCheckBox();
	
	JLabel labAxis = new JLabel("Axis-settings");
	JLabel labGrid = new JLabel("Grid-settings");
	JButton btnSave = new JButton("Ok");
	JButton btnExit = new JButton("Exit");
	
	public AxisEditWindow(Range range) {
		Dimension labelSize = new Dimension(60,10);
		
		setSize(220,220);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setTitle("Axis-settings " + range.getDimension());	
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Something to save the data
				
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Something to discard changes and exit frame
				
			}
		});
		
		labMin.setPreferredSize(labelSize);
		labMax.setPreferredSize(labelSize);
		labUni.setPreferredSize(labelSize);
		labInt.setPreferredSize(labelSize);
		labCun.setPreferredSize(labelSize);
		labEnb.setPreferredSize(labelSize);
		chbEnb.setPreferredSize(new Dimension(60,13));
		
		labAxis.setPreferredSize(new Dimension(220,20));
		labGrid.setPreferredSize(new Dimension(220,20));

		add(labAxis);
		add(labMin);
		add(labMax);
		add(labUni);
		add(txtMin);
		add(txtMax);
		add(txtUni);
		
		add(labGrid);
		add(labEnb);
		add(labInt);
		add(labCun);
		add(chbEnb);
		add(txtInt);
		add(txtCun);
		
		add(btnSave);
		add(btnExit);
		
		setVisible(true);
	}

}
