package no.thunaes.petter.svg.app.gui.domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ItemPanels extends JPanel {
	
	List<ItemPanel> valuePanels = new ArrayList<ItemPanel>();
	
	public ItemPanels() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new ItemPanel());
		add(new ItemPanel());
	}
}
