package graphique.listener.seance;

import graphique.GraphicSeance;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.apache.commons.lang3.StringUtils;

public class LoadSeancePlanningListener implements ItemListener {

	private GraphicSeance panel;

	public LoadSeancePlanningListener(GraphicSeance panel) {
		this.panel = panel;
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			String displayed = (String) event.getItem();
			if (StringUtils.contains(displayed, " - ")) {
				String id = StringUtils.split(displayed, " - ")[0];
				panel.setIdPlanningSelected(Integer.valueOf(id));
			} else {
				panel.setIdPlanningSelected(null);
			}
		} 
	}

}
