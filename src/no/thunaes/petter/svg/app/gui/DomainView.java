package no.thunaes.petter.svg.app.gui;

import javax.swing.JPanel;

import no.thunaes.petter.svg.app.gui.domain.ChartInput;

public class DomainView extends JPanel {

	ChartInput chartInput;
	
	public DomainView() {
		add(chartInput = new ChartInput(), null);
		
	}
	
}
