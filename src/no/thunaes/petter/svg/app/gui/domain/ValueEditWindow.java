package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import no.smidsrod.robin.svg.library.Chart;

public class ValueEditWindow extends JFrame {

	private ValuesPanel valuesPanel;
	private JScrollPane scrollPanel;
	private JPanel panel;

	public ValueEditWindow(ItemPanel itemPanel) {		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(400,500);

		valuesPanel = new ValuesPanel(itemPanel);
		scrollPanel = new JScrollPane(valuesPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(380,417));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(scrollPanel);
		
		add(new ValueMenuPanel(itemPanel));
		add(panel);
	}

	public void addValuePanel(Chart c) {
		valuesPanel.addValuePanel(c);
	
	}

	public void removeValuePanel(ValuePanel v) {
		valuesPanel.removeValuePanel(v);
		
	}

	public void generateValueFields(ValuePanel v, Chart c) {
		valuesPanel.generateValueFields(v, c);
		
	}
}
