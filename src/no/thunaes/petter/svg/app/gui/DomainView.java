package no.thunaes.petter.svg.app.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import no.thunaes.petter.svg.app.gui.domain.Hello;

public class DomainView extends JPanel {

	Hello test;
	
	public DomainView() {
		add(test = new Hello());
	}

	public void hello() {
		test.hello();
	}
}
