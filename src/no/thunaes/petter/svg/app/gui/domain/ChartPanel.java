package no.thunaes.petter.svg.app.gui.domain;

import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import no.smidsrod.robin.svg.library.SVGRenderer;

public class ChartPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ChartMenuPanel chartMenu;
	private ChartSettingsPanel chartSettingsPanel;
	private ChartItemsPanel chartItems;

	private File renderFile;

	public ChartPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(chartSettingsPanel = new ChartSettingsPanel());
		add(chartMenu = new ChartMenuPanel());
		add(chartItems = new ChartItemsPanel());
	}

	public void newChart() {
		chartSettingsPanel.newChart();
	}

	public void renderChart() {
		JFileChooser chooser = new JFileChooser(renderFile);
		chooser.setFileFilter(new FileNameExtensionFilter(
				"Scalable Vector Graphics", "svg"));
		if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
			return;
		}
		renderFile = chooser.getSelectedFile();

		SVGRenderer r = chartSettingsPanel.getChart().getSVGRenderer();
		r.setPrettyPrint(true);
		try {
			r.storeSVGDocument(renderFile);
			JOptionPane.showMessageDialog(this, "Chart saved to '"
					+ renderFile.getAbsolutePath() + "'.",
					"Render successful!", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),
					"Render was not successful!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void reCalcUI() {
		this.repaint();
	}

	public void addItemPanel() {
		chartItems.addItemPanel(chartSettingsPanel.getChart());
	}

	public void addValuePanel(ItemPanel i) {
		chartItems.addValuePanel(i, chartSettingsPanel.getChart());
	}

	public void removeValuePanel(ItemPanel i, ValuePanel v) {
		chartItems.removeValuePanel(i, v);
	}

	public void removeItemPanel(ItemPanel i) {
		chartItems.removeItemPanel(i, chartSettingsPanel.getChart());
	}

	public void generateValueFields(ItemPanel i, ValuePanel v) {
		chartItems.generateValueFields(i, v, chartSettingsPanel.getChart());
	}

	public void enableAddItem() {
		chartMenu.enableAddItem();
	}

}
