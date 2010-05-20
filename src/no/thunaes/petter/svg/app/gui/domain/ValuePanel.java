package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import no.smidsrod.robin.svg.library.Chart;
import no.thunaes.petter.svg.app.Controller;

public class ValuePanel extends JPanel implements ActionListener {
	
	private JButton removeVal = new JButton("-");
	private ItemPanel itemPanel;
	
	public ValuePanel(ItemPanel itemPanel) {
		this.itemPanel = itemPanel;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		Controller.generateValueFields(itemPanel, this);

		removeVal.addActionListener(this);

		add(removeVal);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Controller.removeValuePanel(itemPanel, this);
	}

	public void generateValueFields(Chart c) {
		for(int i = 0; i < c.getDimensionCount(); i++) {
			JLabel label = new JLabel(c.getRange(i).getName());
			label.setPreferredSize(new Dimension(92,15));
			add(label);
		}
		
		for(int i = 0; i < c.getDimensionCount(); i++) {
			add(new JTextField(8));
		}
		
		
		
	}
}
