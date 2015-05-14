package graphique.listener.formateur;

import graphique.GraphicFormateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang3.StringUtils;

public class AnnulerFormateurListener extends BaseFormateurListener implements ActionListener {
	
	public AnnulerFormateurListener(GraphicFormateur panel) {
		super(panel);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		panel.getTextNom().setText(StringUtils.EMPTY);
		panel.getTextPrenom().setText(StringUtils.EMPTY);
		panel.getTextTitre().setText(StringUtils.EMPTY);
		panel.getTextEmail().setText(StringUtils.EMPTY);
		refreshList();
	}

}
