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
import no.smidsrod.robin.svg.library.Value;
import no.thunaes.petter.svg.app.Controller;

public class ValuePanel extends JPanel implements ActionListener, DocumentListener {
	
	private JButton removeVal = new JButton("-");
	
	private ItemPanel itemPanel;
	private Value value;
	
	private ArrayList<JTextField> textfieldStorage = new ArrayList<JTextField>();
	
	public ValuePanel(ItemPanel itemPanel, Value value) {
		this.itemPanel = itemPanel;
		this.value = value;
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		Controller.generateValueFields(itemPanel, this);

		removeVal.addActionListener(this);

		add(removeVal);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Controller.removeValuePanel(itemPanel, this);
	}

	public void generateValueFields(Chart c) {
		for(int i = 0; i < c.getDimensionCount(); i++) {
			JLabel label = new JLabel(c.getRange(i).getName());
			label.setPreferredSize(new Dimension(92,15));	
			add(label);
		}
		
		for(int i = 0; i < c.getDimensionCount(); i++) {
			JTextField textfield = new JTextField(8);
			textfield.getDocument().addDocumentListener(this);
			textfield.setText(value.get(i) + "");
			textfieldStorage.add(textfield);
			add(textfield);
		}
	}

	public Value getValue() {
		return value;
	}
	
	private void doDocumentEvent(DocumentEvent arg0) {
		Document changed = arg0.getDocument();
		
		for(int i = 0; i < textfieldStorage.size(); i++) {
			if (changed.equals(textfieldStorage.get(i).getDocument())) {
				
				double data = getDouble(textfieldStorage.get(i));
				if(data != Double.NaN) {
					value.set(i, data);
				}
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

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		doDocumentEvent(arg0);
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		doDocumentEvent(arg0);
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		doDocumentEvent(arg0);
		
	}
}
