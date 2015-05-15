package graphique.listener.seance;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import graphique.GraphicSeance;
import graphique.listener.planning.GeneratePlanningListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import common.IDbObject;
import connector.SimpleDbConnector;
import container.Formateur;
import container.Module;
import container.Planning;
import container.Seance;

public class SaveSeanceListener implements ActionListener {

	private GraphicSeance panel;
	private GeneratePlanningListener generatePlanningListener;

	public SaveSeanceListener(GraphicSeance panel, GeneratePlanningListener generatePlanningListener) {
		this.panel = panel;
		this.generatePlanningListener = generatePlanningListener;
	}

	public void refreshList() {
		List<IDbObject> modules = SimpleDbConnector.getAll(Module.class);
		List<IDbObject> formateurs = SimpleDbConnector.getAll(Formateur.class);
		List<IDbObject> plannings = SimpleDbConnector.getAll(Planning.class);
		panel.getComboBoxModule().removeAllItems();
		panel.getComboBoxFormateur().removeAllItems();
		panel.getComboBoxPlanning().removeAllItems();
		panel.getComboBoxModule().addItem(EMPTY);
		panel.getComboBoxFormateur().addItem(EMPTY);
		panel.getComboBoxPlanning().addItem(EMPTY);
		for(IDbObject obj : modules) {
			Module module = (Module) obj;
			panel.getComboBoxModule().addItem(module.getId() + " - " + module.getName() + " (" + module.getAbbreviation() + ")");
		}
		for(IDbObject obj : formateurs) {
			Formateur formateur = (Formateur) obj;
			panel.getComboBoxFormateur().addItem(formateur.getId() + " - " + formateur.getPrenom() + " " + formateur.getNom());
		}
		for(IDbObject obj : plannings) {
			Planning planning = (Planning) obj;
			panel.getComboBoxPlanning().addItem(planning.getId() + " - " + planning.getFormattedDate());
		}
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Formateur formateur = (Formateur) SimpleDbConnector.get(Formateur.class, panel.getIdFormateurSelected());
		Module module = (Module)SimpleDbConnector.get(Module.class, panel.getIdModuleSelected());
		Planning planning = (Planning)SimpleDbConnector.get(Planning.class, panel.getIdPlanningSelected());
		int debut = Integer.valueOf(panel.getTextDebut().getText());
		int duree = Integer.valueOf(panel.getTextDuree().getText());
		int rang = Integer.valueOf(panel.getTextRang().getText());
		
		Seance seance = new Seance();
		seance.setDebut(debut);
		seance.setDuree(duree);
		seance.setRang(rang);
		seance.setModule(module);
		seance.setFormateur(formateur);
		seance.setPlanning(planning);
		SimpleDbConnector.save(seance);

		JOptionPane.showMessageDialog(panel, "La séance est correctement sauvegardée.");
		generatePlanningListener.refresh();
	}

}
