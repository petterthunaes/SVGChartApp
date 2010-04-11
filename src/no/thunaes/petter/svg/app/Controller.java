package no.thunaes.petter.svg.app;

import no.thunaes.petter.svg.app.gui.SVGChartApp;

public class Controller {

	static SVGChartApp ui;
	
	public static void init(SVGChartApp ui) {
		Controller.ui = ui;
	}
	
	public static void hello() {
		ui.hello();
	}
}
