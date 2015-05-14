package controller;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import graphique.GraphicFormateur;
import graphique.GraphicModule;
import graphique.GraphicPlanning;
import graphique.GraphicSeance;
import graphique.listener.ExitScreenListener;
import graphique.listener.formateur.AnnulerFormateurListener;
import graphique.listener.formateur.LoadFormateurListener;
import graphique.listener.formateur.SaveFormateurListener;
import graphique.listener.module.AnnulerModuleListener;
import graphique.listener.module.LoadModuleListener;
import graphique.listener.module.SaveModuleListener;
import graphique.listener.planning.CreateSeanceListener;
import graphique.listener.planning.GeneratePlanningListener;
import graphique.listener.seance.LoadSeanceFormateurListener;
import graphique.listener.seance.LoadSeanceModuleListener;
import graphique.listener.seance.SaveSeanceListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import util.JXMLHandler;
import container.Formation;
import container.Module;
import container.Planning;
import container.Seance;

public class ApplicationStarter {
	
	private static final int startYear = 2014;

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(1150, 480);
		GraphicPlanning panel = new GraphicPlanning();
		for(int i = startYear; i < startYear + 10; i++) {
			panel.getComboBoxYear().addItem("" + i);
		}
		panel.getComboBoxYear().addItemListener(new GeneratePlanningListener(panel));
		panel.getButtonCreerSeance().addActionListener(new CreateSeanceListener());
		panel.getButtonQuitter().addActionListener(new ExitScreenListener(frame));
		frame.add(panel);
		frame.setVisible(true);
		
	}

	public static void mainSeance(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(550, 480);
		GraphicSeance panel = new GraphicSeance();

		SaveSeanceListener saveModuleListener = new SaveSeanceListener(panel);
		saveModuleListener.refreshList();

		panel.getButtonSauvegarder().addActionListener(saveModuleListener);
		panel.getComboBoxFormateur().addItemListener(new LoadSeanceFormateurListener(panel));
		panel.getComboBoxModule().addItemListener(new LoadSeanceModuleListener(panel));
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

	public static void mainPlanning(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(1050, 480);
		GraphicPlanning panel = new GraphicPlanning();
		panel.getComboBoxYear().addItem("2014");
		panel.getComboBoxYear().addItem("2015");
		panel.getComboBoxYear().addItem("2016");
		panel.getComboBoxYear().addItem("2017");
		panel.getComboBoxYear().addItem("2018");
		panel.getComboBoxYear().addItem("2019");
		panel.getComboBoxYear().addItem("2020");
		panel.getComboBoxYear().addItem("2021");
		panel.getComboBoxYear().addItemListener(new GeneratePlanningListener(panel));
		panel.getButtonQuitter().addActionListener(new ExitScreenListener(frame));
		frame.add(panel);
		frame.setVisible(true);
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void _main(String[] args) throws IOException {
		Date now = new Date();
		List<Planning> plannings = PlanningGenerator.getWholeYear(now, EMPTY);
		System.out.println(plannings);
		plannings = PlanningGenerator.getWorkingDays(now, EMPTY);
		System.out.println(plannings);
		plannings = PlanningGenerator.getHolidays(now, EMPTY);
		System.out.println(plannings);

		System.out.println("Click this zone here and press Enter...");
		System.in.read();

		Formation formation = new Formation();
		formation.setYear(now);
		formation.addWorkingDays(PlanningGenerator.getWorkingDays(now, "AM"));
		formation.addHolidays(PlanningGenerator.getHolidays(now, "AM"));
		formation.addWorkingDays(PlanningGenerator.getWorkingDays(now, "PM"));
		formation.addHolidays(PlanningGenerator.getHolidays(now, "PM"));

		JXMLHandler<Formation> fHandler = new JXMLHandler<Formation>(
				Formation.class);
		String xml = fHandler.toXML(formation);

		System.out.println(xml);

		System.out.println("Click this zone here again and press Enter...");
		System.in.read();

		// Another example with a single day and populated modules
		formation = new Formation();
		formation.setYear(now);
		plannings = new ArrayList<Planning>();
		Planning planning = new Planning(now, EMPTY);
		Seance seance = new Seance();
		Module module = new Module();
		module.setAbbreviation("ECP");
		module.setName("Electro-magnetisme et Champs de Propagation");
		module.setColor("FF089C");
		module.setNbSeance(14);
		seance.setModule(module);
		seance.setDuree(5);
		planning.addSeance(seance);
		plannings.add(planning);
		formation.addWorkingDays(plannings);

		System.out.println(fHandler.toXML(formation));

		// You can then write an XSLT, to transform the generated XML to HTML
		// for export
		System.out
				.println("You can then write an XSLT, to transform the generated XML to HTML for export");
	}

}
