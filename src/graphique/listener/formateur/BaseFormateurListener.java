package graphique.listener.formateur;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import graphique.GraphicFormateur;

import java.util.List;

import common.IDbObject;

import connector.SimpleDbConnector;
import container.Formateur;

public abstract class BaseFormateurListener {

	protected GraphicFormateur panel;
	
	public BaseFormateurListener(GraphicFormateur panel) {
		this.panel = panel;
	}

	public void refreshList() {
		List<IDbObject> formateurs = SimpleDbConnector.getAll(Formateur.class);
		panel.getComboBoxRecherche().removeAllItems();
		panel.getComboBoxRecherche().addItem(EMPTY);
		for(IDbObject obj : formateurs) {
			Formateur formateur = (Formateur) obj;
			panel.getComboBoxRecherche().addItem(formateur.getId() + " - " + formateur.getPrenom() + " " + formateur.getNom());
		}
	}
}
