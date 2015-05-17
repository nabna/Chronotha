package graphique.listener.planning;

import graphique.GraphicPlanning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import connector.SimpleDbConnector;
import container.Planning;

public class SavePlanningListener implements ActionListener {
	
	private GraphicPlanning panel;

	public SavePlanningListener(GraphicPlanning panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Planning> plannings = panel.getPlannings();
		if(plannings != null && !plannings.isEmpty()) {
			for(Planning planning : plannings) {
				if(planning.getId() != null) {
					SimpleDbConnector.update(planning);
				} else {
					SimpleDbConnector.save(planning);
				}
			}
		}
		JOptionPane.showMessageDialog(panel, "Le planning est sauvegarde correctement.");
	}

}
