package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import no.smidsrod.robin.svg.library.Chart;
import no.smidsrod.robin.svg.library.Range;
import no.smidsrod.robin.svg.library.Value;
import no.thunaes.petter.svg.app.Controller;

public class ValuePanel extends JPanel implements ActionListener,
		DocumentListener {

	private static final long serialVersionUID = 1L;

	private JPanel labelPanel = new JPanel();
	private JPanel textFieldPanel = new JPanel();

	private JButton deleteValueButton = new JButton("Remove");

	private ItemPanel itemPanel;
	private Value value;

	private ArrayList<JTextField> textFields = new ArrayList<JTextField>();

	public ValuePanel(ItemPanel itemPanel, Value value) {
		this.itemPanel = itemPanel;
		this.value = value;

		setPreferredSize(new Dimension(340, 65));
		setLayout(new FlowLayout(FlowLayout.LEFT));

		labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelPanel.setPreferredSize(new Dimension(400, 20));
		textFieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		textFieldPanel.setPreferredSize(new Dimension(400, 35));

		Controller.generateValueFields(itemPanel, this);

		deleteValueButton.addActionListener(this);

		textFieldPanel.add(deleteValueButton);

		add(labelPanel);
		add(textFieldPanel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Controller.removeValuePanel(itemPanel, this);
	}

	public void generateValueFields(Chart c) {
		for (int i = 0; i < c.getDimensionCount(); i++) {
			Range range = c.getRange(i);
			JLabel label = new JLabel(calcRangeLabel(range, i));
			label.setPreferredSize(new Dimension(92, 15));
			labelPanel.add(label);
		}

		for (int i = 0; i < c.getDimensionCount(); i++) {
			JTextField textfield = new JTextField(8);
			textfield.getDocument().addDocumentListener(this);
			textfield.setText(value.get(i) + "");
			textFields.add(textfield);
			textFieldPanel.add(textfield);
		}
	}

	private String calcRangeLabel(Range range, int dimension) {
		String name = range.getName();
		String unit = range.getUnit();
		if (name.isEmpty() && unit.isEmpty()) {
			return "Axis " + (dimension + 1);
		}
		if (name.isEmpty()) {
			return unit;
		}
		if (unit.isEmpty()) {
			return name;
		}
		return name + " (" + unit + ")";
	}

	public Value getValue() {
		return value;
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

		for (int i = 0; i < textFields.size(); i++) {
			if (changed.equals(textFields.get(i).getDocument())) {
				double data = getDouble(textFields.get(i));
				if (data != Double.NaN) {
					value.set(i, data);
				}
			}
		}
	}
}
