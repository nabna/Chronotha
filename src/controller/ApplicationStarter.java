package controller;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import graphique.GraphicFormateur;
import graphique.GraphicModule;
import graphique.GraphicPlanning;
import graphique.MainFrame;
import graphique.listener.ExitScreenListener;
import graphique.listener.formateur.AnnulerFormateurListener;
import graphique.listener.formateur.LoadFormateurListener;
import graphique.listener.formateur.SaveFormateurListener;
import graphique.listener.module.AnnulerModuleListener;
import graphique.listener.module.LoadModuleListener;
import graphique.listener.module.SaveModuleListener;
import graphique.listener.planning.CreateSeanceListener;
import graphique.listener.planning.ExportSeanceListener;
import graphique.listener.planning.GeneratePlanningListener;
import graphique.listener.planning.SavePlanningListener;

import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings("unchecked")
public class ApplicationStarter {
	
	private static final int startYear = 2014;

	public static void main(String[] args) throws IOException {
    	MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicPlanning panel = new GraphicPlanning();
		panel.getComboBoxYear().addItem(EMPTY);
		for(int i = startYear; i < startYear + 10; i++) {
			panel.getComboBoxYear().addItem(EMPTY + i);
		}
		GeneratePlanningListener generatePlanningListener = new GeneratePlanningListener(panel);
		panel.getComboBoxYear().addItemListener(generatePlanningListener);
		frame.getCreateSeanceAction().addActionListener(new CreateSeanceListener(generatePlanningListener));
		panel.getButtonExporter().addActionListener(new ExportSeanceListener(panel));
		panel.getButtonSave().addActionListener(new SavePlanningListener(panel));
		panel.getButtonQuitter().addActionListener(new ExitScreenListener(frame));
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static void mainModule(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(900, 710);
		GraphicModule panel = new GraphicModule();

		SaveModuleListener saveModuleListener = new SaveModuleListener(panel);
		saveModuleListener.refreshList();
		
		panel.getComboBoxRecherche().addItemListener(new LoadModuleListener(panel));
		panel.getButtonSauvegarder().addActionListener(saveModuleListener);
		panel.getButtonAnnuler().addActionListener(new AnnulerModuleListener(panel));
		panel.getButtonQuitter().addActionListener(new ExitScreenListener(frame));
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static void mainFormateur(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(500, 480);
		GraphicFormateur panel = new GraphicFormateur();

		SaveFormateurListener saveFormateurListener = new SaveFormateurListener(panel);
		saveFormateurListener.refreshList();
		
		panel.getComboBoxRecherche().addItemListener(new LoadFormateurListener(panel));
		panel.getButtonSauvegarder().addActionListener(saveFormateurListener);
		panel.getButtonAnnuler().addActionListener(new AnnulerFormateurListener(panel));
		panel.getButtonQuitter().addActionListener(new ExitScreenListener(frame));
		frame.add(panel);
		frame.setVisible(true);
	}


}
