package no.thunaes.petter.svg.app.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import no.thunaes.petter.svg.app.gui.domain.ChartPanel;
import no.thunaes.petter.svg.app.gui.domain.ItemPanel;
import no.thunaes.petter.svg.app.gui.domain.ValuePanel;

public class DomainView extends JPanel {

	private ChartPanel chartPanel;
	
	public DomainView() {
		setLayout(new BorderLayout());
		add(chartPanel = new ChartPanel());
		
	}

	public void reCalcUI() {
		chartPanel.reCalcUI();
		
	}

	public void addItemPanel() {
		chartPanel.addItemPanel();
		
	}

	public void addValuePanel(ItemPanel i) {
		chartPanel.addValuePanel(i);
		
	}

	public void removeValuePanel(ItemPanel i, ValuePanel v) {
		chartPanel.removeValuePanel(i,v);
		
	}

	public void removeItemPanel(ItemPanel i) {
		chartPanel.removeItemPanel(i);
		
	}
	
}
