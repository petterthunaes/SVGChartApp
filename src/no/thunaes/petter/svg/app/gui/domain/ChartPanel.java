package no.thunaes.petter.svg.app.gui.domain;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ChartPanel extends JPanel {
	
	private ChartSettingsPanel chartSettings;
	private ChartItemsPanel chartItems;
	private ChartMenuPanel chartMenu;
	
	public ChartPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(chartSettings = new ChartSettingsPanel());
		add(chartMenu = new ChartMenuPanel());
		add(chartItems = new ChartItemsPanel());
	}

	public void reCalcUI() {
		this.repaint();
		
	}

	public void addItemPanel() {
		chartItems.addItemPanel();
		
	}

	public void addValuePanel(ItemPanel i) {
		chartItems.addValuePanel(i);
		
	}

	public void removeValuePanel(ItemPanel i, ValuePanel v) {
		chartItems.removeValuePanel(i,v);
		
	}

	public void removeItemPanel(ItemPanel i) {
		chartItems.removeItemPanel(i);
		
	}

}
