package no.thunaes.petter.svg.app.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import no.thunaes.petter.svg.app.gui.domain.ChartFrame;

public class DomainView extends JPanel {

	ChartFrame chartInput;
	
	public DomainView() {
		setLayout(new BorderLayout());
		add(chartInput = new ChartFrame());
		
	}
	
}
