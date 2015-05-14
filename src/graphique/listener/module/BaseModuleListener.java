package graphique.listener.module;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import graphique.GraphicModule;

import java.util.List;

import common.IDbObject;

import connector.SimpleDbConnector;
import container.Module;

public abstract class BaseModuleListener {

	protected GraphicModule panel;
	
	public BaseModuleListener(GraphicModule panel) {
		this.panel = panel;
	}

	public void refreshList() {
		List<IDbObject> modules = SimpleDbConnector.getAll(Module.class);
		panel.getComboBoxRecherche().removeAllItems();
		panel.getComboBoxRecherche().addItem(EMPTY);
		for(IDbObject obj : modules) {
			Module module = (Module) obj;
			panel.getComboBoxRecherche().addItem(module.getId() + " - " + module.getName() + " (" + module.getAbbreviation() + ")");
		}
	}
}
