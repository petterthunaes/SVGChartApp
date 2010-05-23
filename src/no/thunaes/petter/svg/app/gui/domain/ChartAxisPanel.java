package no.thunaes.petter.svg.app.gui.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
			add(buildEditButton(r));
		}
	}

	private JButton buildEditButton(final Range r) {
		JButton button = new JButton();

		// Create button label
		if (r.getName().isEmpty()) {
			button.setText("Axis " + (r.getDimension() + 1));
		} else {
			button.setText(r.getName());
		}

		// Add click listener
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AxisEditWindow(r);
			}
		});

		return button;
	}

}
