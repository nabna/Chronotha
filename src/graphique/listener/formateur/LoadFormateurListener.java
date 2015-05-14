package graphique.listener.formateur;

import graphique.GraphicFormateur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.apache.commons.lang3.StringUtils;

import connector.SimpleDbConnector;
import container.Formateur;

public class LoadFormateurListener implements ItemListener {

	private GraphicFormateur panel;

	public LoadFormateurListener(GraphicFormateur panel) {
		this.panel = panel;
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			String displayed = (String) event.getItem();
			if (StringUtils.contains(displayed, " - ")) {
				String id = StringUtils.split(displayed, " - ")[0];
				Formateur formateur = (Formateur) SimpleDbConnector.get(
						Formateur.class, Integer.valueOf(id));
				panel.getTextNom().setText(formateur.getNom());
				panel.getTextPrenom().setText(formateur.getPrenom());
				panel.getTextTitre().setText(formateur.getTitre());
				panel.getTextEmail().setText(formateur.getEmail());
				panel.setIdFormateurSelected(Integer.valueOf(id));
			} else {
				panel.getTextNom().setText(StringUtils.EMPTY);
				panel.getTextPrenom().setText(StringUtils.EMPTY);
				panel.getTextTitre().setText(StringUtils.EMPTY);
				panel.getTextEmail().setText(StringUtils.EMPTY);
				panel.setIdFormateurSelected(null);
				
			}
		} 
	}

}
