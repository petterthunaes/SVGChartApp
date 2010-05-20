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

import no.smidsrod.robin.svg.library.Chart;
import no.thunaes.petter.svg.app.Controller;

public class ItemPanel extends JPanel implements ActionListener {
	
	private ValueEditWindow valueEditWindow;
	
	private JButton valueAdd = new JButton("V");
	private JButton valueDel = new JButton("-");
	
	private JLabel labName = new JLabel("Label");
	private JLabel labColr = new JLabel("Color");
	private JLabel labHigh = new JLabel("Highlight");
	
	private JTextField valLabel = new JTextField(10);
	private JCheckBox  valHighl = new JCheckBox();
	private JTextField valColor = new JTextField(7);
	
	public ItemPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(390, 65));
		labName.setPreferredSize(new Dimension(115, 15));
		labColr.setPreferredSize(new Dimension(82,15));
		labHigh.setPreferredSize(new Dimension(60,15));
		
		valHighl.setPreferredSize(new Dimension(60, 15));
		
		valueAdd.addActionListener(this);
		valueDel.addActionListener(this);
		
		valueEditWindow = new ValueEditWindow(this);
		
		add(labName);
		add(labColr);
		add(labHigh);
		add(valLabel);
		add(valColor);		
		add(valHighl);
		add(valueAdd);
		add(valueDel);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(valueAdd)) {
			valueEditWindow.setVisible(true);
		}
		if (arg0.getSource().equals(valueDel)) {
			Controller.removeItemPanel(this);
		}
	}

	public void addValuePanel() {
		valueEditWindow.addValuePanel();
		
	}

	public void removeValuePanel(ValuePanel v) {
		valueEditWindow.removeValuePanel(v);
		
	}

	public void generateValueFields(ValuePanel v, Chart c) {
		valueEditWindow.generateValueFields(v, c);
		
	}

}
