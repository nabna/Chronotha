package graphique.listener.module;

import graphique.GraphicModule;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.apache.commons.lang3.StringUtils;

import connector.SimpleDbConnector;
import container.Module;

public class LoadModuleListener implements ItemListener {

	private GraphicModule panel;

	public LoadModuleListener(GraphicModule panel) {
		this.panel = panel;
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			String displayed = (String) event.getItem();
			if (StringUtils.contains(displayed, " - ")) {
				String id = StringUtils.split(displayed, " - ")[0];
				Module module = (Module) SimpleDbConnector.get(
						Module.class, Integer.valueOf(id));
				panel.getTextNom().setText(module.getName());
				panel.getTextAbbreviation().setText(module.getAbbreviation());
				panel.getComponentCouleur().setColor(Color.decode("0x" + module.getColor()));
				panel.getTextNbSeance().setText("" + module.getNbSeance());
				panel.setIdModuleSelected(Integer.valueOf(id));
			} else {
				panel.getTextNom().setText(StringUtils.EMPTY);
				panel.getTextAbbreviation().setText(StringUtils.EMPTY);
				panel.getComponentCouleur().setColor(0, 0, 0);
				panel.getTextNbSeance().setText(StringUtils.EMPTY);
				panel.setIdModuleSelected(null);
			}
		} 
	}

}
