package no.thunaes.petter.svg.app.gui.domain;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import no.smidsrod.robin.svg.library.Chart;

public class ValueEditWindow extends JFrame {

	private ValuesPanel valuesPanel;

	public ValueEditWindow(ItemPanel itemPanel) {		
		setLayout(new BorderLayout());
		setSize(370,500);
		add(new ValueMenuPanel(itemPanel), BorderLayout.NORTH);
		add(valuesPanel = new ValuesPanel(itemPanel), BorderLayout.CENTER);
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
