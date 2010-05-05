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
		
		for(int k = 0; k < ranges.length; k++) {
			axisEditButtons.add(new AxisEditButton(ranges[k]));
		}
		
		updateButtons();
	}
	
	private void updateButtons() {
		if(this.getComponentCount() > 0)
			this.removeAll();
		
		for(int j = 0; j < axisEditButtons.size(); j++) {
			add(axisEditButtons.get(j));
		}
	}
	
}
