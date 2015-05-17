package graphique.listener.planning;

import graphique.GraphicSeance;
import graphique.listener.ExitScreenListener;
import graphique.listener.seance.LoadSeanceFormateurListener;
import graphique.listener.seance.LoadSeanceModuleListener;
import graphique.listener.seance.LoadSeancePlanningListener;
import graphique.listener.seance.SaveSeanceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CreateSeanceListener implements ActionListener {
	
	private GeneratePlanningListener generatePlanningListener;

	public CreateSeanceListener(GeneratePlanningListener generatePlanningListener) {
		this.generatePlanningListener = generatePlanningListener;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame frame = new JFrame();
		frame.setSize(550, 480);
		GraphicSeance panel = new GraphicSeance();
		
		for(int i = 0; i < TimeSlotHelper.getTotalSlotsCount(); i++) {
			panel.getComboBoxDebut().addItem(TimeSlotHelper.getSlotLabel(i));
		}

		SaveSeanceListener saveModuleListener = new SaveSeanceListener(panel, generatePlanningListener);
		saveModuleListener.refreshList();

		panel.getButtonSauvegarder().addActionListener(saveModuleListener);
		panel.getComboBoxFormateur().addItemListener(new LoadSeanceFormateurListener(panel));
		panel.getComboBoxModule().addItemListener(new LoadSeanceModuleListener(panel));
		panel.getComboBoxPlanning().addItemListener(new LoadSeancePlanningListener(panel));
		panel.getButtonQuitter().addActionListener(new ExitScreenListener(frame));
		
		frame.add(panel);
		frame.setVisible(true);
	}

}
