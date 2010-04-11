package no.thunaes.petter.svg.app.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import no.thunaes.petter.svg.app.Controller;


public class SVGChartApp extends JFrame {

	CenterPanel center;
	SouthPanel south;
	NorthPanel north;
	
	public SVGChartApp() {
		Controller.init(this);
		setTitle("SVGChartApp");
		
		add(north = new NorthPanel(), BorderLayout.NORTH);
		add(center = new CenterPanel(), null);
		add(south = new SouthPanel(), BorderLayout.SOUTH);
		
		setSize(800,500);
		setVisible(true);
	}

	public void hello() {
		center.hello();
	}
}
