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
	
	private JLabel labMin = new JLabel("Min");
	private JLabel labMax = new JLabel("Max");
	private JLabel labUni = new JLabel("Unit");	
	private JTextField txtMin = new JTextField(5);
	private JTextField txtMax = new JTextField(5);
	private JTextField txtUni = new JTextField(5);
	
	private JLabel labInt = new JLabel("Interval");
	private JLabel labCun = new JLabel("Count");
	private JLabel labEnb = new JLabel("Enable");
	private JTextField txtInt = new JTextField(5);
	private JTextField txtCun = new JTextField(5);
	private JCheckBox chbEnb = new JCheckBox();
	
	private JLabel labAxis = new JLabel("Axis-settings");
	private JLabel labGrid = new JLabel("Grid-settings");
	private JButton btnSave = new JButton("Ok");
	private JButton btnExit = new JButton("Exit");
	
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
