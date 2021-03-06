package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import no.smidsrod.robin.svg.library.BarChart;
import no.smidsrod.robin.svg.library.Chart;
import no.smidsrod.robin.svg.library.LineChart;
import no.smidsrod.robin.svg.library.ScatterChart;
import no.smidsrod.robin.svg.library.SectorChart;
import no.thunaes.petter.svg.app.Controller;

public class ChartSettingsPanel extends JPanel implements ActionListener,
		DocumentListener {

	private static final long serialVersionUID = 1L;

	private String[] chartTypes = { "", "Sector", "Bar", "Line", "Scatter" };

	private JTextField chartName = new JTextField(25);
	private JTextArea chartDesc = new JTextArea(5, 32);
	private JComboBox chartType = new JComboBox(chartTypes);

	private JLabel typeLabel = new JLabel("Chart type");
	private JLabel nameLabel = new JLabel("Chart name");
	private JLabel descLabel = new JLabel("Chart description");

	private Chart chart;
	private ChartAxisPanel chartAxisPanel;

	public ChartSettingsPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(400, 205));

		typeLabel.setPreferredSize(new Dimension(70, 15));
		nameLabel.setPreferredSize(new Dimension(300, 15));
		descLabel.setPreferredSize(new Dimension(370, 15));

		chartDesc.setBorder(BorderFactory.createEtchedBorder());

		chartName.getDocument().addDocumentListener(this);
		chartDesc.getDocument().addDocumentListener(this);
		chartType.addActionListener(this);

		chartName.setEnabled(false);
		chartDesc.setEnabled(false);

		add(typeLabel);
		add(nameLabel);
		add(chartType);
		add(chartName);
		add(descLabel);
		add(chartDesc);
		add(chartAxisPanel = new ChartAxisPanel());
	}

	public void newChart() {
		JOptionPane.showMessageDialog(this, "Not implemented!", "New chart",
				JOptionPane.PLAIN_MESSAGE);
	}

	public Chart getChart() {
		return chart;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (chartType.getSelectedIndex()) {
		case 0:
			return;
		case 1:
			chart = new SectorChart();
			break;
		case 2:
			chart = new BarChart();
			break;
		case 3:
			chart = new LineChart();
			break;
		case 4:
			chart = new ScatterChart();
			break;
		}

		chartType.setEnabled(false);
		chartName.setEnabled(true);
		chartDesc.setEnabled(true);

		chartName.setText(getChart().getTitle());
		chartDesc.setText(getChart().getDescription());

		chartAxisPanel.updateRange(getChart().getRanges());
		Controller.enableAddItem();
		Controller.addItemPanel();
		updateUI();
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
		Document changedDocument = e.getDocument();
		if (changedDocument.equals(chartName.getDocument())) {
			getChart().setTitle(chartName.getText());
		}
		if (changedDocument.equals(chartDesc.getDocument())) {
			getChart().setDescription(chartDesc.getText());
		}
	}

}
