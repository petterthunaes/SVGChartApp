package no.thunaes.petter.svg.app.gui;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class NorthPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public NorthPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEtchedBorder());
		add(new MainMenu());
	}

}
