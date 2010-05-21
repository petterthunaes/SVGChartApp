package no.thunaes.petter.svg.app.gui.domain;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import no.smidsrod.robin.svg.library.SVGRenderer;

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
		chartItems.addItemPanel(chartSettings.getChart());	
	}

	public void addValuePanel(ItemPanel i) {
		chartItems.addValuePanel(i, chartSettings.getChart());	
	}

	public void removeValuePanel(ItemPanel i, ValuePanel v) {
		chartItems.removeValuePanel(i,v);		
	}

	public void removeItemPanel(ItemPanel i) {
		chartItems.removeItemPanel(i, chartSettings.getChart());
	}

	public void generateValueFields(ItemPanel i, ValuePanel v) {
		chartItems.generateValueFields(i, v, chartSettings.getChart());
	}
	
	public void save() {
		SVGRenderer r = chartSettings.getChart().getSVGRenderer();
		r.setPrettyPrint(true);
		try {
			r.storeSVGDocument(new File("C:\\Temp\\app_chart.svg"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
