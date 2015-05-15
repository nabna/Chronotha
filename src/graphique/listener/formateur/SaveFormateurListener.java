package graphique.listener.formateur;

import graphique.GraphicFormateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import connector.SimpleDbConnector;
import container.Formateur;

public class SaveFormateurListener extends BaseFormateurListener implements ActionListener {

	public SaveFormateurListener(GraphicFormateur panel) {
		super(panel);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Formateur formateur = new Formateur();
		formateur.setPrenom(panel.getTextPrenom().getText());
		formateur.setNom(panel.getTextNom().getText());
		formateur.setTitre(panel.getTextTitre().getText());
		formateur.setEmail(panel.getTextTitre().getText());
		
		if(panel.getIdFormateurSelected() != null) { // si le formateur existe, on le met à jour
			formateur.setId(panel.getIdFormateurSelected());
			SimpleDbConnector.update(formateur);
		} else { // sinon, on le crée
			SimpleDbConnector.save(formateur);
		}
		refreshList();
		JOptionPane.showMessageDialog(panel, "Le formateur est sauvegardé correctement.");
	}

}
