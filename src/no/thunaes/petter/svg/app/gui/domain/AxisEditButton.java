package no.thunaes.petter.svg.app.gui.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import no.smidsrod.robin.svg.library.Range;

public class AxisEditButton extends JButton implements ActionListener {

	private Range range;
	
	public AxisEditButton(Range range) {
		this.range = range;
		
		setText("Axis-" + range.getDimension());
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new AxisEditWindow(range);
	}

}
