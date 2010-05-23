package no.thunaes.petter.svg.app.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import no.thunaes.petter.svg.app.Controller;
import no.thunaes.petter.svg.app.gui.domain.ItemPanel;
import no.thunaes.petter.svg.app.gui.domain.ValuePanel;

public class SVGChartApp extends JFrame {

	private static final String APP_NAME = "SVGChartApp";

	private static final long serialVersionUID = 1L;

	private CenterPanel center;

	public SVGChartApp() {
		Controller.init(this);
		setTitle(APP_NAME);
		setLayout(new BorderLayout());

		add(center = new CenterPanel(), BorderLayout.CENTER);
		add(new NorthPanel(), BorderLayout.NORTH);
		// Not currently in use:
		// add(new SouthPanel(), BorderLayout.SOUTH);

		setSize(400, 600);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void exit() {
		System.exit(0);
	}

	public void newChart() {
		center.newChart();
	}

	public void renderChart() {
		center.renderChart();
	}

	public void reCalcUI() {
		center.reCalcUI();
	}

	public void addItemPanel() {
		center.addItemPanel();
	}

	public void addValuePanel(ItemPanel i) {
		center.addValuePanel(i);
	}

	public void removeValuePanel(ItemPanel i, ValuePanel v) {
		center.removeValuePanel(i, v);
	}

	public void removeItemPanel(ItemPanel i) {
		center.removeItemPanel(i);
	}

	public void generateValueFields(ItemPanel i, ValuePanel v) {
		center.generateValueFields(i, v);
	}

	public void enableAddItem() {
		center.enableAddItem();
	}

}
