package graphique.listener.module;

import graphique.GraphicModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import connector.SimpleDbConnector;
import container.Module;

public class SaveModuleListener extends BaseModuleListener implements ActionListener {

	public SaveModuleListener(GraphicModule panel) {
		super(panel);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Module module = new Module();
		module.setName(panel.getTextNom().getText());
		module.setAbbreviation(panel.getTextAbbreviation().getText());
		module.setColor(Integer.toHexString(panel.getComponentCouleur().getColor().getRGB() & 0x00ffffff));
		
		module.setNbSeance(Integer.valueOf(panel.getTextNbSeance().getText()));
		
		if(panel.getIdModuleSelected() != null) { // si le formateur existe, on le met a jour
			module.setId(panel.getIdModuleSelected());
			SimpleDbConnector.update(module);
		} else { // sinon, on le cree
			SimpleDbConnector.save(module);
		}
		refreshList();
		JOptionPane.showMessageDialog(panel, "La module est sauvegardee correctement.");
	}

}
