package no.thunaes.petter.svg.app.gui.domain;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import no.smidsrod.robin.svg.library.Chart;

public class ItemsPanel extends JPanel {
	
	//List<ItemPanel> itemPanels = new ArrayList<ItemPanel>();
	
	public ItemsPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public void addItemPanel() {
		//itemPanels.add(itemPanel);
		add(new ItemPanel());
		updateUI();
	}
	
	public void removeItemPanel(ItemPanel i) {
		//itemPanels.remove(i);
		remove(i);
		updateUI();
	}

	public void addValuePanel(ItemPanel i) {
		i.addValuePanel();
		
	}

	public void removeValuePanel(ItemPanel i, ValuePanel v) {
		i.removeValuePanel(v);
		
	}

	public void generateValueFields(ItemPanel i, ValuePanel v, Chart c) {
		i.generateValueFields(v, c);
		
	}
}
