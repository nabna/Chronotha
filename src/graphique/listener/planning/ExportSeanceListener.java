package graphique.listener.planning;

import graphique.GraphicPlanning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import util.DateUtil;
import util.JXMLHandler;
import util.XmlFileTransformer;
import container.Formation;
import container.Planning;
import controller.PlanningGenerator;

public class ExportSeanceListener implements ActionListener {

	private static final Logger log = Logger.getLogger(ExportSeanceListener.class);
	private static final String DATA_OUT_DIRECTORY = "data/out/";
	private GraphicPlanning panel;

	public ExportSeanceListener(GraphicPlanning panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Planning> plannings = panel.getPlannings();

		if (plannings != null && !plannings.isEmpty()) {
			Planning planning = plannings.get(0);
			Formation formation = new Formation();
			formation.setWorkingDays(panel.getPlannings());
			formation.setHolidays(PlanningGenerator.getHolidays(planning.getDate()));
			JXMLHandler<Formation> handler = new JXMLHandler<Formation>(Formation.class);

			String fileName = "export" + DateUtil.getYYYYMMDDHHmmss2(new Date());
			handler.toXML(formation, DATA_OUT_DIRECTORY + fileName + ".xml");

			XmlFileTransformer transform = new XmlFileTransformer("./xslt/tfseance.xsl");
			transform.transform("./" + DATA_OUT_DIRECTORY + fileName + ".xml", 
					"./" + DATA_OUT_DIRECTORY + fileName + ".html");
			
			serialize(formation, DATA_OUT_DIRECTORY + fileName + ".ser");
			JOptionPane.showMessageDialog(panel, "Le planning est exporte dans " + DATA_OUT_DIRECTORY 
				 + fileName + " en trois fichiers xml, html et ser (binaire serialis¨¦)" );
		}
	}

	private void serialize(Serializable e, String filename) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");
		} catch (IOException i) {
			log.error(i.getMessage(), i);
		}
	}

}
