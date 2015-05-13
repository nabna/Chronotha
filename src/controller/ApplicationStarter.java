package controller;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import graphique.GraphicPlanning;
import graphique.listener.ExitScreenListener;
import graphique.listener.GeneratePlanningListener;

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

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(1150, 480);
		GraphicPlanning panel = new GraphicPlanning();
		panel.getComboBox1().addItem("2014");
		panel.getComboBox1().addItem("2015");
		panel.getComboBox1().addItem("2016");
		panel.getComboBox1().addItem("2017");
		panel.getComboBox1().addItem("2018");
		panel.getComboBox1().addItem("2019");
		panel.getComboBox1().addItem("2020");
		panel.getComboBox1().addItem("2021");
		panel.getComboBox1().addItemListener(new GeneratePlanningListener(panel));
		panel.getButton5().addActionListener(new ExitScreenListener(frame));
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

		// Un autre exemple
		formation = new Formation();
		formation.setYear(now);
		plannings = new ArrayList<Planning>();
		Planning planning = new Planning(now, EMPTY);
		Seance seance = new Seance();
		Module module = new Module();
		module.setAbbreviation("SI");
		module.setName("Systeme informatique");
		module.setColor("FF089C");
		module.setNbSeance(14);
		seance.setModule(module);
		seance.setDuree(5);
		planning.addSeance(seance);
		plannings.add(planning);
		formation.addWorkingDays(plannings);

		System.out.println(fHandler.toXML(formation));

		System.out.println("Il faut ecrire un transformeur XSLT, pour exporter XML en HTML");
	}

}
