package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import no.thunaes.petter.svg.app.Controller;

public class ValuePanel extends JPanel implements ActionListener {

	private JLabel labOne= new JLabel("Value 1");
	private JLabel labTwo = new JLabel("Value 2");
	private JLabel labThr = new JLabel("Value 3");
	
	private JTextField txtOne = new JTextField(8);
	private JTextField txtTwo = new JTextField(8);
	private JTextField txtThr = new JTextField(8);
	
	private JButton removeVal = new JButton("-");
	private ItemPanel itemPanel;
	
	public ValuePanel(ItemPanel itemPanel) {
		this.itemPanel = itemPanel;
		setLayout(new FlowLayout(FlowLayout.LEFT));

		labOne.setPreferredSize(new Dimension(92,15));
		labTwo.setPreferredSize(new Dimension(92,15));
		labThr.setPreferredSize(new Dimension(92,15));
		removeVal.addActionListener(this);
		
		add(labOne);
		add(labTwo);
		add(labThr);
		add(txtOne);
		add(txtTwo);
		add(txtThr);
		add(removeVal);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Controller.removeValuePanel(itemPanel, this);
	}
}
