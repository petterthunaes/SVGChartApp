package no.thunaes.petter.svg.app.gui.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
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

public class ChartSettingsPanel extends JPanel implements ActionListener, DocumentListener {

	private String[] chartTypes = { "", "Sector", "Bar", "Line", "Scatter" };
	
	private JTextField chartName = new JTextField(25);
	private JTextArea chartDesc = new JTextArea(5, 32);
	private JComboBox chartType = new JComboBox(chartTypes);
	
	private Chart chart;
	private ChartAxisPanel chartAxisPanel;

	public ChartSettingsPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(400, 175));
		chartDesc.setBorder(BorderFactory.createEtchedBorder());

		chartName.getDocument().addDocumentListener(this);
		chartDesc.getDocument().addDocumentListener(this);
		chartType.addActionListener(this);
		
		chartName.setEnabled(false);
		chartDesc.setEnabled(false);
		
		add(chartType);
		add(chartName);
		add(chartDesc);
		add(chartAxisPanel = new ChartAxisPanel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		switch(chartType.getSelectedIndex()) {
		case 0:
			break;
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
		
		chartName.setText(chart.getTitle());
		chartDesc.setText(chart.getDescription());
		
		chartAxisPanel.updateRange(chart.getRanges());
		updateUI();	
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		documentDoEvent(arg0);
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		documentDoEvent(arg0);		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		documentDoEvent(arg0);
	}
	
	private void documentDoEvent(DocumentEvent arg0) {
		Document changed = arg0.getDocument();
		if(changed.equals(chartName.getDocument())) {
			chart.setTitle(chartName.getText());
		}		
		if(changed.equals(chartDesc.getDocument())) {
			chart.setDescription(chartDesc.getText());
		}
	}
	
	public Chart getChart() {
		return chart;
	}
	
}
