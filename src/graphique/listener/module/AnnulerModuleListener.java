package graphique.listener.module;

import graphique.GraphicModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang3.StringUtils;

public class AnnulerModuleListener extends BaseModuleListener implements ActionListener {
	
	public AnnulerModuleListener(GraphicModule panel) {
		super(panel);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		panel.getTextNom().setText(StringUtils.EMPTY);
		panel.getTextAbbreviation().setText(StringUtils.EMPTY);
		panel.getTextNbSeance().setText(StringUtils.EMPTY);
		panel.getComponentCouleur().setColor(0, 0, 0);
		refreshList();
	}

}
