package no.thunaes.petter.svg.app.gui.domain;

import javax.swing.JPanel;

import no.smidsrod.robin.svg.library.Range;

public class ChartAxisPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ChartAxisPanel() {
		// setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	public void updateRange(Range[] ranges) {
		if (getComponentCount() > 0) {
			removeAll();
		}
		for (Range r : ranges) {
			add(new AxisEditButton(r));
		}
	}

}
