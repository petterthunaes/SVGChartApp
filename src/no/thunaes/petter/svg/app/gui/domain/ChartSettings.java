package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Color;
import java.awt.FlowLayout;
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
	
	JTextField chartTitle = new JTextField(25);
	JTextArea chartDesc = new JTextArea(5, 32);
	JComboBox chartType = new JComboBox(chartNames);
	
	JButton chartAxOne = new JButton("Axe-1");
	JButton chartAxTwo = new JButton("Axe-2");
	JButton chartAxThree = new JButton("Axe-3");
	
	public ChartSettings() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBorder(BorderFactory.createLineBorder(Color.black));
		chartDesc.setBorder(BorderFactory.createEtchedBorder());
		
		add(chartType);
		add(chartTitle);
		add(chartDesc);
		add(chartAxOne);
		add(chartAxTwo);
		add(chartAxThree);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Controller.addAxisButtons();
	}
}
