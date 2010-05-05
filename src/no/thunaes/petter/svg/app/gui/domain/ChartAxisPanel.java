package no.thunaes.petter.svg.app.gui.domain;



import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import no.smidsrod.robin.svg.library.Range;

public class ChartAxisPanel extends JPanel {

	private List<AxisEditButton> axisEditButtons = new ArrayList<AxisEditButton>();
	
	public ChartAxisPanel() {
	}
	
	public void updateRange(Range[] ranges) {
		if(axisEditButtons.size() > 0)
			axisEditButtons.clear();
		
		for(Range r: ranges) {
			axisEditButtons.add(new AxisEditButton(r));
		}
		
		updateButtons();
	}
	
	private void updateButtons() {
		if(this.getComponentCount() > 0)
			this.removeAll();
		
		for(AxisEditButton j: axisEditButtons) {
			add(j);
		}
	}
	
}
