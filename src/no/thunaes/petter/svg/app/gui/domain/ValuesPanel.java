package no.thunaes.petter.svg.app.gui.domain;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ValuesPanel extends JPanel {

	//List<ValuePanel> valuePanels = new ArrayList<ValuePanel>();
	
	private ItemPanel itemPanel;

	public ValuesPanel(ItemPanel itemPanel) {
		this.itemPanel = itemPanel;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void addValuePanel() {
		ValuePanel valuePanel = new ValuePanel(itemPanel);
		//valuePanels.add(valuePanel);
		add(valuePanel);
		updateUI();
	}

	public void removeValuePanel(ValuePanel v) {
		//valuePanels.remove(v);
		remove(v);
		updateUI();
	}
}
