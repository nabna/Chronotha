package graphique.listener.seance;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import graphique.GraphicSeance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import common.IDbObject;

import connector.SimpleDbConnector;
import container.Formateur;
import container.Module;
import container.Seance;

public class SaveSeanceListener implements ActionListener {

	private GraphicSeance panel;
	
	public SaveSeanceListener(GraphicSeance panel) {
		this.panel = panel;
	}

	public void refreshList() {
		List<IDbObject> modules = SimpleDbConnector.getAll(Module.class);
		List<IDbObject> formateurs = SimpleDbConnector.getAll(Formateur.class);
		panel.getComboBoxModule().removeAllItems();
		panel.getComboBoxFormateur().removeAllItems();
		panel.getComboBoxModule().addItem(EMPTY);
		panel.getComboBoxFormateur().addItem(EMPTY);
		for(IDbObject obj : modules) {
			Module module = (Module) obj;
			panel.getComboBoxModule().addItem(module.getId() + " - " + module.getName() + " (" + module.getAbbreviation() + ")");
		}
		for(IDbObject obj : formateurs) {
			Formateur formateur = (Formateur) obj;
			panel.getComboBoxFormateur().addItem(formateur.getId() + " - " + formateur.getPrenom() + " " + formateur.getNom());
		}
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Formateur formateur = (Formateur) SimpleDbConnector.get(Formateur.class, panel.getIdFormateurSelected());
		Module module = (Module)SimpleDbConnector.get(Module.class, panel.getIdModuleSelected());
		int duree = Integer.valueOf(panel.getTextDuree().getText());
		int rang = Integer.valueOf(panel.getTextRang().getText());
		
		Seance seance = new Seance();
		seance.setDuree(duree);
		seance.setRang(rang);
		seance.setModule(module);
		seance.setFormateur(formateur);
		SimpleDbConnector.save(seance);
	}

}
