package no.thunaes.petter.svg.app.gui.domain;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import no.smidsrod.robin.svg.library.Chart;
import no.smidsrod.robin.svg.library.Item;

public class ItemsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ItemsPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public void addItemPanel(Chart c) {
		Item item = new Item("");
		add(new ItemPanel(item));
		c.getItemList().add(item);
		updateUI();
	}

	public void removeItemPanel(ItemPanel i, Chart c) {
		c.getItemList().remove(i.getItem());
		remove(i);
		updateUI();
	}

	public void addValuePanel(ItemPanel i, Chart c) {
		i.addValuePanel(c);
	}

	public void removeValuePanel(ItemPanel i, ValuePanel v) {
		i.removeValuePanel(v);
	}

	public void generateValueFields(ItemPanel i, ValuePanel v, Chart c) {
		i.generateValueFields(v, c);
	}
}
