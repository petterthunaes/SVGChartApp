package no.thunaes.petter.svg.app.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import no.thunaes.petter.svg.app.gui.domain.ItemPanel;
import no.thunaes.petter.svg.app.gui.domain.ValuePanel;

public class CenterPanel extends JPanel {

	private DomainView domainview;
	
	public CenterPanel() {
		setLayout(new BorderLayout());
		add(domainview = new DomainView());
	}

	public void reCalcUI() {
		domainview.reCalcUI();
		
	}

	public void addItemPanel() {
		domainview.addItemPanel();
		
	}

	public void addValuePanel(ItemPanel i) {
		domainview.addValuePanel(i);
		
	}

	public void removeValuePanel(ItemPanel i, ValuePanel v) {
		domainview.removeValuePanel(i,v);
		
	}

	public void removeItemPanel(ItemPanel i) {
		domainview.removeItemPanel(i);
		
	}

	public void generateValueFields(ItemPanel i, ValuePanel v) {
		domainview.generateValueFields(i, v);
		
	}

}
