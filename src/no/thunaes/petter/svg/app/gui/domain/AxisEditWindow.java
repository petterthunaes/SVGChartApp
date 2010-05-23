package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import no.smidsrod.robin.svg.library.Range;

public class AxisEditWindow extends JFrame implements ActionListener,
		DocumentListener {

	private static final long serialVersionUID = 1L;

	private JLabel axisOptionsLabel = new JLabel("Axis options");
	private JLabel gridOptionsLabel = new JLabel("Grid options");

	private JLabel minLabel = new JLabel("Min");
	private JLabel maxLabel = new JLabel("Max");
	private JLabel unitLabel = new JLabel("Unit");
	private JLabel nameLabel = new JLabel("Name");
	private JLabel distanceLabel = new JLabel("Distance");
	private JLabel countLabel = new JLabel("Count");

	private JTextField minText = new JTextField(5);
	private JTextField maxText = new JTextField(5);
	private JTextField unitText = new JTextField(5);
	private JTextField nameText = new JTextField(5);
	private JTextField distanceText = new JTextField(5);
	private JTextField countText = new JTextField(5);

	private JButton closeButton = new JButton("Close");

	private Range range;
	private NumberFormat numberFormat;

	public AxisEditWindow(Range range) {
		this.range = range;

		setSize(270, 300);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setTitle("Settings for axis " + (range.getDimension() + 1));
		setLocationRelativeTo(null);

		JPanel axisPanel = new JPanel();
		JPanel gridPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		axisPanel.setLayout(new GridLayout(0, 4));
		gridPanel.setLayout(new GridLayout(0, 2));
		buttonPanel.setLayout(new GridLayout(0, 1));

		maxText.getDocument().addDocumentListener(this);
		minText.getDocument().addDocumentListener(this);
		unitText.getDocument().addDocumentListener(this);
		nameText.getDocument().addDocumentListener(this);
		countText.getDocument().addDocumentListener(this);
		distanceText.getDocument().addDocumentListener(this);
		closeButton.addActionListener(this);

		if (range.isMinSet()) {
			minText.setText(getFormatter().format(range.getMin()));
		}
		if (range.isMaxSet()) {
			maxText.setText(getFormatter().format(range.getMax()));
		}
		unitText.setText(range.getUnit());
		nameText.setText(range.getName());
		distanceText
				.setText(getFormatter().format(range.getGridlineDistance()));
		countText.setText(range.getGridlineCount() + "");

		Dimension labelSize = new Dimension(60, 10);
		minLabel.setPreferredSize(labelSize);
		maxLabel.setPreferredSize(labelSize);
		unitLabel.setPreferredSize(labelSize);
		nameLabel.setPreferredSize(labelSize);
		distanceLabel.setPreferredSize(labelSize);
		countLabel.setPreferredSize(labelSize);

		Dimension titleSize = new Dimension(220, 20);
		axisOptionsLabel.setPreferredSize(titleSize);
		gridOptionsLabel.setPreferredSize(titleSize);

		buttonPanel.add(closeButton);
		add(buttonPanel);

		add(axisOptionsLabel);
		axisPanel.add(nameLabel);
		axisPanel.add(unitLabel);
		axisPanel.add(minLabel);
		axisPanel.add(maxLabel);
		axisPanel.add(nameText);
		axisPanel.add(unitText);
		axisPanel.add(minText);
		axisPanel.add(maxText);
		add(axisPanel);

		add(gridOptionsLabel);

		gridPanel.add(distanceLabel);
		gridPanel.add(countLabel);
		gridPanel.add(distanceText);
		gridPanel.add(countText);
		add(gridPanel);

		setVisible(true);
	}

	private NumberFormat getFormatter() {
		if (numberFormat == null) {
			numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
			numberFormat.setMaximumFractionDigits(2);
		}
		return numberFormat;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(closeButton)) {
			setVisible(false);
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		handleDocumentEvent(e);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		handleDocumentEvent(e);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		handleDocumentEvent(e);
	}

	private void handleDocumentEvent(DocumentEvent e) {
		Document changed = e.getDocument();
		if (changed.equals(maxText.getDocument())) {
			double value = getDouble(maxText);
			if (value != Double.NaN) {
				range.setMax(value);
			}
		}
		if (changed.equals(minText.getDocument())) {
			double value = getDouble(minText);
			if (value != Double.NaN) {
				range.setMin(value);
			}
		}
		if (changed.equals(unitText.getDocument())) {
			range.setUnit(unitText.getText());
		}
		if (changed.equals(nameText.getDocument())) {
			range.setName(nameText.getText());
		}
		if (changed.equals(countText.getDocument())) {
			int value = getInt(countText);
			if (value != Integer.MAX_VALUE) {
				range.setGridlineCount(value);
				distanceText.getDocument().removeDocumentListener(this);
				distanceText.setText(getFormatter().format(
						range.getGridlineDistance()));
				distanceText.getDocument().addDocumentListener(this);
			}
		}
		if (changed.equals(distanceText.getDocument())) {
			double value = getDouble(distanceText);
			if (value != Double.NaN) {
				range.setGridlineDistance(value);
				countText.getDocument().removeDocumentListener(this);
				countText.setText(range.getGridlineCount() + "");
				countText.getDocument().addDocumentListener(this);
			}
		}
	}

	private double getDouble(JTextField textField) {
		if (!textField.getText().isEmpty()) {
			try {
				double value = Double.parseDouble(textField.getText());
				return value;
			} catch (Exception e) {
				// do nothing
			}
		}
		return Double.NaN;
	}

	private int getInt(JTextField textField) {
		if (!textField.getText().isEmpty()) {
			try {
				int value = Integer.parseInt(textField.getText());
				return value;
			} catch (Exception e) {
				// do nothing
			}
		}
		return Integer.MAX_VALUE;
	}

}
