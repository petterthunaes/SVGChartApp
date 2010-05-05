package no.thunaes.petter.svg.app.gui.domain;

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

/*
 * Axis-1, Dimension(115,20);
 */

public class ChartSettingsPanel extends JPanel {

	String[] chartTypes = { "", "Sector", "Bar", "Line", "Scatter" };
	
	JTextField chartName = new JTextField(25);
	JTextArea chartDesc = new JTextArea(5, 32);
	JComboBox chartType = new JComboBox(chartTypes);
	
	Chart theChart;
	ChartAxisPanel chartAxisPanel;

	public ChartSettingsPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		chartDesc.setBorder(BorderFactory.createEtchedBorder());

		add(chartType);
		add(chartName);
		add(chartDesc);
		add(chartAxisPanel = new ChartAxisPanel());


		chartType.addActionListener(new ActionListener() {
			
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
		});

	}
}
