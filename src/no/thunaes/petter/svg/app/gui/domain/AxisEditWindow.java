package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import no.smidsrod.robin.svg.library.Range;

public class AxisEditWindow extends JFrame implements ActionListener, DocumentListener {
	
	private JLabel labMin = new JLabel("Min");
	private JLabel labMax = new JLabel("Max");
	private JLabel labUni = new JLabel("Unit");	
	private JLabel labNam = new JLabel("Name");
	private JLabel labInt = new JLabel("Interval");
	private JLabel labCun = new JLabel("Count");
	
	private JTextField txtMin = new JTextField(5);
	private JTextField txtMax = new JTextField(5);
	private JTextField txtUni = new JTextField(5);
	private JTextField txtNam = new JTextField(5);
	private JTextField txtInt = new JTextField(5);
	private JTextField txtCun = new JTextField(5);
	
	private JLabel labAxis = new JLabel("Axis options");
	private JLabel labGrid = new JLabel("Grid options");
	
	private JButton btnClose = new JButton("Close");
	
	private Range range;
	
	public AxisEditWindow(Range range) {
		this.range = range;
		
		setSize(270,300);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setTitle("Axis settings " + range.getDimension());		
		
		JPanel axisPanel = new JPanel();
		JPanel gridPanel = new JPanel();
		JPanel buttPanel = new JPanel();
		
		axisPanel.setLayout(new GridLayout(0, 4));
		gridPanel.setLayout(new GridLayout(0, 2));
		buttPanel.setLayout(new GridLayout(0, 1));
		
		Dimension label_size = new Dimension(60,10);
		Dimension title_size = new Dimension(220,20);
		
		txtMax.getDocument().addDocumentListener(this);
		txtMin.getDocument().addDocumentListener(this);
		txtUni.getDocument().addDocumentListener(this);
		txtNam.getDocument().addDocumentListener(this);
		txtCun.getDocument().addDocumentListener(this);
		txtInt.getDocument().addDocumentListener(this);
		btnClose.addActionListener(this);
		
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
		nf.setMaximumFractionDigits(2);
		
		txtMax.setText(nf.format(range.getMax()) + "");
		txtMin.setText(nf.format(range.getMin()) + "");
		txtUni.setText(range.getUnit());
		txtNam.setText(range.getName());
		txtInt.setText(nf.format(range.getGridlineDistance()) + "");
		txtCun.setText(range.getGridlineCount() + "");
		
		labMin.setPreferredSize(label_size);
		labMax.setPreferredSize(label_size);
		labUni.setPreferredSize(label_size);
		labNam.setPreferredSize(label_size);
		labInt.setPreferredSize(label_size);
		labCun.setPreferredSize(label_size);		
		labAxis.setPreferredSize(title_size);
		labGrid.setPreferredSize(title_size);

		
		buttPanel.add(btnClose);
		add(buttPanel);
		
		add(labAxis);
		axisPanel.add(labMin);
		axisPanel.add(labMax);
		axisPanel.add(labUni);
		axisPanel.add(labNam);
		axisPanel.add(txtMin);
		axisPanel.add(txtMax);
		axisPanel.add(txtUni);
		axisPanel.add(txtNam);
		add(axisPanel);
		
		add(labGrid);
		
		gridPanel.add(labInt);
		gridPanel.add(labCun);	
		gridPanel.add(txtInt);
		gridPanel.add(txtCun);
		add(gridPanel);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(btnClose)) {
			setVisible(false);
		}
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

	private void doDocumentEvent(DocumentEvent arg0) {
		Document changed  = arg0.getDocument();
		if (changed.equals(txtMax.getDocument())) {
			double value = getDouble(txtMax);
			if(value != Double.NaN) {
				range.setMax(value);
			}
		}
		if (changed.equals(txtMin.getDocument())) {
			double value = getDouble(txtMin);
			if(value != Double.NaN) {
				range.setMin(value);
			}			
		}
		if (changed.equals(txtUni.getDocument())) {
			range.setName(txtUni.getText());
		}
		if (changed.equals(txtNam.getDocument())) {
			range.setName(txtNam.getText());
		}
		if (changed.equals(txtCun.getDocument())) {
			int value = getInt(txtCun);
			if (value != Integer.MAX_VALUE) {
				range.setGridlineCount(value);
				txtInt.getDocument().removeDocumentListener(this);
				txtInt.setText(range.getGridlineDistance() + "");
				txtInt.getDocument().addDocumentListener(this);
			}	
		}
		if (changed.equals(txtInt.getDocument())) {
			double value = getDouble(txtInt);
			if(value != Double.NaN) {
				range.setGridlineDistance(value);
				txtCun.getDocument().removeDocumentListener(this);
				txtCun.setText(range.getGridlineCount() + "");
				txtCun.getDocument().addDocumentListener(this);
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
