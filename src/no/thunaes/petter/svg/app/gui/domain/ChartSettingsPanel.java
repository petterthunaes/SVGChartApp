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

import no.smidsrod.robin.svg.library.BarChart;
import no.smidsrod.robin.svg.library.Chart;
import no.smidsrod.robin.svg.library.LineChart;
import no.smidsrod.robin.svg.library.ScatterChart;
import no.smidsrod.robin.svg.library.SectorChart;
import no.thunaes.petter.svg.app.Controller;

/*
 * Axis-1, Dimension(115,20);
 */

public class ChartSettingsPanel extends JPanel implements ActionListener {

	private String[] chartTypes = { "", "Sector", "Bar", "Line", "Scatter" };
	
	private JTextField chartName = new JTextField(25);
	private JTextArea chartDesc = new JTextArea(5, 32);
	private JComboBox chartType = new JComboBox(chartTypes);
	
	private Chart theChart;
	private ChartAxisPanel chartAxisPanel;

	public ChartSettingsPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(400, 175));
		chartDesc.setBorder(BorderFactory.createEtchedBorder());

		add(chartType);
		add(chartName);
		add(chartDesc);
		add(chartAxisPanel = new ChartAxisPanel());


		chartType.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		switch(chartType.getSelectedIndex()) {
		case 0:
			break;
		case 1:
			theChart = new SectorChart();
			break;
		case 2:
			theChart = new BarChart();
			break;
		case 3:
			theChart = new LineChart();
			break;
		case 4:
			theChart = new ScatterChart();
			break;
		}
		
		chartAxisPanel.updateRange(theChart.getRanges());
		updateUI();	
	}
}
