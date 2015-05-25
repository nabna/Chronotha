package graphique.listener;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import graphique.GraphicPlanning;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import container.Planning;
import controller.PlanningGenerator;

public class GeneratePlanningListener implements ItemListener {

	private GraphicPlanning panel;

	public GeneratePlanningListener(GraphicPlanning panel) {
		this.panel = panel;
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			String fDate = (String) event.getItem() + "-08-01";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = format.parse(fDate);
				populateTable(panel.getTable1(), date);
			} catch (ParseException e) {
			}
		}
	}
	private void populateTable(JTable table, Date date) {
		List<Planning> plannings = PlanningGenerator.getWorkingDays(date);

		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Date");
		columnNames.add("08:00 AM");
		columnNames.add("09:00 AM");
		columnNames.add("10:00 AM");
		columnNames.add("11:00 AM");
		columnNames.add("13:00 PM");
		columnNames.add("14:00 PM");
		columnNames.add("15:00 PM");
		columnNames.add("16:00 PM");
		columnNames.add("17:00 PM");
		columnNames.add("18:00 PM");
		TableModel model = new DefaultTableModel(columnNames, 600);
		int i = 0;
		for (Planning planning : plannings) {
			model.setValueAt(planning.getFormattedDate(), i++, 0);
		}
		table.setModel(model);
	}

}
