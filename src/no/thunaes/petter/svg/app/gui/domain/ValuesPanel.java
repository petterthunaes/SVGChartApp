package no.thunaes.petter.svg.app.gui.domain;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import no.smidsrod.robin.svg.library.Chart;
import no.smidsrod.robin.svg.library.Value;

public class ValuesPanel extends JPanel {
	
	private ItemPanel itemPanel;

	public ValuesPanel(ItemPanel itemPanel) {
		this.itemPanel = itemPanel;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void addValuePanel(Chart c) {
		Value value = new Value(c.getDimensionCount());
		itemPanel.getItem().getValueList().add(value);
		add(new ValuePanel(itemPanel, value));
		updateUI();
	}

	public void removeValuePanel(ValuePanel v) {
		itemPanel.getItem().getValueList().remove(v.getValue());
		remove(v);
		updateUI();
	}

	public void generateValueFields(ValuePanel v, Chart c) {
		v.generateValueFields(c);
		
	}
}
