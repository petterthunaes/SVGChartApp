package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ChartItemsPanel extends JPanel {
	
	private ItemsPanel itemsPanel = new ItemsPanel();
	private JScrollPane scrollPanel;
	
	public ChartItemsPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(400, 275));
		scrollPanel = new JScrollPane(itemsPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPanel);
	}

	public void addItemPanel() {
		itemsPanel.addItemPanel();
		updateUI();
		
	}

	public void addValuePanel(ItemPanel i) {
		itemsPanel.addValuePanel(i);
		
	}

	public void removeValuePanel(ItemPanel i, ValuePanel v) {
		itemsPanel.removeValuePanel(i,v);
		
	}

	public void removeItemPanel(ItemPanel i) {
		itemsPanel.removeItemPanel(i);
		
	}
}
