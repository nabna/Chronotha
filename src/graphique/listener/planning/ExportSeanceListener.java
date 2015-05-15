package graphique.listener.planning;

import graphique.GraphicPlanning;
import graphique.GraphicSeance;
import graphique.listener.ExitScreenListener;
import graphique.listener.seance.LoadSeanceFormateurListener;
import graphique.listener.seance.LoadSeanceModuleListener;
import graphique.listener.seance.LoadSeancePlanningListener;
import graphique.listener.seance.SaveSeanceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import util.DateUtil;
import util.JXMLHandler;
import container.EasyBean;
import container.Formation;
import container.Planning;
import controller.PlanningGenerator;

public class ExportSeanceListener implements ActionListener {
	
	private static final String DATA_OUT_DIRECTORY = "data/out/";
	private GraphicPlanning panel;

	public ExportSeanceListener(GraphicPlanning panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Planning> plannings = panel.getPlannings();
		
		if(plannings != null && !plannings.isEmpty()) {
			Planning planning = plannings.get(0);
			Formation formation = new Formation();
			formation.setWorkingDays(panel.getPlannings());
			formation.setHolidays(PlanningGenerator.getHolidays(planning.getDate()));
			JXMLHandler<Formation> handler = new JXMLHandler<Formation>(Formation.class);
			
			String fileName = "export" + DateUtil.getYYYYMMDDHHmmss2(new Date());
			handler.toXML(formation, DATA_OUT_DIRECTORY + fileName + ".xml");
			JOptionPane.showMessageDialog(panel, "Le planning est exporté dans " + DATA_OUT_DIRECTORY + fileName + ".xml");
		}
	}

}
