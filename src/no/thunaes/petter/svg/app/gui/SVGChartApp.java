package no.thunaes.petter.svg.app.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import no.thunaes.petter.svg.app.Controller;
import no.thunaes.petter.svg.app.gui.domain.ItemPanel;
import no.thunaes.petter.svg.app.gui.domain.ValuePanel;


public class SVGChartApp extends JFrame {

	private CenterPanel center;
	private SouthPanel south;
	private NorthPanel north;
	
	public SVGChartApp() {
		Controller.init(this);
		setTitle("SVGChartApp");
		setLayout(new BorderLayout());
		
		add(north = new NorthPanel(), BorderLayout.NORTH);
		add(center = new CenterPanel(), BorderLayout.CENTER);
		//add(south = new SouthPanel(), BorderLayout.SOUTH);
		
		setSize(400,600);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
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
		center.removeValuePanel(i,v);
		
	}

	public void removeItemPanel(ItemPanel i) {
		center.removeItemPanel(i);
		
	}

	public void generateValueFields(ItemPanel i, ValuePanel v) {
		center.generateValueFields(i, v);
		
	}

	public void exit() {
		System.exit(0);
	}

	public void save() {
		center.save();
		
	}

	public void enableAddItem() {
		center.enableAddItem();
		
	}

	public void createNewChart() {
		center.createNewChart();
		
	}

}
