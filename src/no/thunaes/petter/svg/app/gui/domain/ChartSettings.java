package no.thunaes.petter.svg.app.gui.domain;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import no.thunaes.petter.svg.app.Controller;

public class ChartSettings extends JPanel implements ActionListener {

	String[] chartNames = { "Sector", "Bar", "Line", "Scatter" };
	
	JTextField chartTitle;
	JTextArea chartDesc;
	JComboBox chartType;
	
	public ChartSettings() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		chartType = new JComboBox(chartNames);
		chartType.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,10);
		c.ipadx = 10;
		c.gridx = 0;
		c.gridy = 0;
		add(chartType, c);
		
		chartTitle = new JTextField(15);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,0);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		add(chartTitle, c);
		
		chartDesc = new JTextArea(5, 15);
		chartDesc.setBorder(BorderFactory.createEtchedBorder());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		add(chartDesc, c);
		
		JButton axisOne = new JButton("Axis 1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,0,0,10);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		add(axisOne, c);
		
		JButton axisTwo = new JButton("Axis 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		add(axisTwo, c);
		
		JButton axisThree = new JButton("Axis 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,0,0,0);
		c.gridx = 2;
		c.gridy = 2;
		add(axisThree, c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Controller.addAxisButtons();
	}
}
