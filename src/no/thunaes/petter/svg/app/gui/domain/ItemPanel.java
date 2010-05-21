package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import no.smidsrod.robin.svg.library.Chart;
import no.smidsrod.robin.svg.library.Item;
import no.thunaes.petter.svg.app.Controller;

public class ItemPanel extends JPanel implements ActionListener, DocumentListener, ItemListener, MouseListener {
	
	private ValueEditWindow valueEditWindow;
	
	private JButton valueAdd = new JButton("V");
	private JButton valueDel = new JButton("-");
	
	private JLabel labName = new JLabel("Label");
	private JLabel labColr = new JLabel("Color");
	private JLabel labHigh = new JLabel("Highlight");
	
	private JLabel valColor = new JLabel("");
	private JTextField valLabel = new JTextField(10);
	private JCheckBox  valHighl = new JCheckBox();

	private Item item;
	
	public ItemPanel(Item item) {
		this.item = item;
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(390, 65));

		valColor.setForeground(item.getColor());
		valHighl.setSelected(item.isHighlighted());
		valLabel.setText(item.getName());
		
		labName.setPreferredSize(new Dimension(115, 15));
		labColr.setPreferredSize(new Dimension(82,15));
		labHigh.setPreferredSize(new Dimension(60,15));
		valColor.setPreferredSize(new Dimension(82,15));
		valHighl.setPreferredSize(new Dimension(60,15));

		valLabel.getDocument().addDocumentListener(this);
		valHighl.addItemListener(this);
		valColor.addMouseListener(this);
		valueAdd.addActionListener(this);
		valueDel.addActionListener(this);
		
		valueEditWindow = new ValueEditWindow(this);
		
		add(labName);
		add(labColr);
		add(labHigh);
		add(valLabel);
		add(valColor);
		add(valHighl);
		add(valueAdd);
		add(valueDel);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(valueAdd)) {
			valueEditWindow.setVisible(true);
		}
		if (arg0.getSource().equals(valueDel)) {
			Controller.removeItemPanel(this);
		}
	}

	public void addValuePanel(Chart c) {
		valueEditWindow.addValuePanel(c);	
	}

	public void removeValuePanel(ValuePanel v) {
		valueEditWindow.removeValuePanel(v);
	}

	public void generateValueFields(ValuePanel v, Chart c) {
		valueEditWindow.generateValueFields(v, c);		
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

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			item.setHighlighted(true);
		}
		if (arg0.getStateChange() == ItemEvent.DESELECTED) {
			item.setHighlighted(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JColorChooser chooser = new JColorChooser();
		JDialog dialog = JColorChooser.createDialog(this,"Color",true,chooser,null,null);
		dialog.setVisible(true);
		Color color = chooser.getColor();
		item.setColor(color);
		valColor.setOpaque(true);
		valColor.setBackground(color);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}

	private void doDocumentEvent(DocumentEvent arg0) {
		Document changed = arg0.getDocument();
		if(changed.equals(valLabel.getDocument())) {
			item.setName(valLabel.getText());
		}
	}
	
	public Item getItem() {
		return item;
	}

}
