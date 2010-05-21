package no.thunaes.petter.svg.app;

import no.thunaes.petter.svg.app.gui.SVGChartApp;
import no.thunaes.petter.svg.app.gui.domain.ItemPanel;
import no.thunaes.petter.svg.app.gui.domain.ValuePanel;

public class Controller {

	private static SVGChartApp ui;
	
	public static void init(SVGChartApp ui) {
		Controller.ui = ui;
	}

	public static void addItemPanel() {
		ui.addItemPanel();		
	}
	
	public static void addValuePanel(ItemPanel i) {
		ui.addValuePanel(i);
	}
	
	public static void reCalcUI() {
		ui.reCalcUI();
	}

	public static void removeValuePanel(ItemPanel i, ValuePanel v) {
		ui.removeValuePanel(i,v);
		
	}

	public static void removeItemPanel(ItemPanel i) {
		ui.removeItemPanel(i);
		
	}

	public static void generateValueFields(ItemPanel i,
			ValuePanel v) {
		ui.generateValueFields(i, v);
		
	}

	public static void exit() {
		ui.exit();
		
	}

	public static void save() {
		ui.save();
		
	}



}
