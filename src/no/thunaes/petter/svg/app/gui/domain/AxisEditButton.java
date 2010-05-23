package no.thunaes.petter.svg.app.gui.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import no.smidsrod.robin.svg.library.Range;

public class AxisEditButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Range range;

	// FIXME: This class could be inlined
	public AxisEditButton(Range range) {
		this.range = range;
		
		if (range.getName().isEmpty()) {
			setText("Axis " + ( range.getDimension() + 1 ));
		} else {
			setText(range.getName());
		}

		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new AxisEditWindow(range);
	}

}
