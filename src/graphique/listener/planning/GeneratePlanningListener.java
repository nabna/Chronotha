package graphique.listener.planning;

import graphique.GraphicPlanning;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import common.IDbObject;

import connector.SimpleDbConnector;
import container.Planning;
import container.Seance;
import controller.PlanningGenerator;

public class GeneratePlanningListener implements ItemListener {

	private GraphicPlanning panel;
	private String fDate;

	public GeneratePlanningListener(GraphicPlanning panel) {
		this.panel = panel;
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			fDate = (String) event.getItem() + "-08-01";
			this.refresh();
		}
	}

	
	public void refresh() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(fDate);
			populateTable(panel.getTable1(), date);
		} catch (ParseException e) {
		}
	}

	private void populateTable(final JTable table, Date date) {
		List<Planning> plannings = PlanningGenerator.getWorkingDays(date);

		Criterion critDate = null;
		Criterion critPlanning = null;

		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Date");
		for (int i = 0; i < TimeSlotHelper.getTotalSlotsCount(); i++) {
			columnNames.add(TimeSlotHelper.getSlotLabel(i));
		}
		table.setModel(new DefaultTableModel(columnNames, 600));
		table.setDefaultRenderer(Object.class, new ColoredCellRenderer());
		table.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				boolean deleted = false;
				if(table.getSelectedRow() > -1 && table.getSelectedColumn() > -1) {
					Object obj = table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
					if(obj != null && obj instanceof Seance && !deleted) {
						SimpleDbConnector.delete((Seance)obj);
						JOptionPane.showMessageDialog(panel, "La séance " + obj + " est supprimée.");
						deleted = true;
						refresh();
					} 
				}
			}
		});

		int i = 0;
		for (Planning p : plannings) {
			critDate = Restrictions.eq("date", p.getDate());
			List<IDbObject> result = SimpleDbConnector.find(Planning.class,
					critDate);
			if (result != null && result.size() > 0) {
				Planning planning = (Planning) result.get(0);
				p.setId(planning.getId());
				p.setAvailability(planning.getAvailability());
				critPlanning = Restrictions.eq("planning.id", planning.getId());
				List<IDbObject> seances = SimpleDbConnector.find(Seance.class,
						critPlanning);
				if (seances != null && seances.size() > 0) {
					for (IDbObject obj : seances) {
						Seance s = (Seance) obj;
						p.addSeance(s);
						for (int j = s.getDebut(); j < s.getDebut()
								+ s.getDuree(); j++) {
							table.setValueAt(s, i, j);
						}
					}
				}
			}
			table.setValueAt(p.getFormattedDate(), i++, 0);
		}
		panel.setPlannings(plannings);
	}

}

class ColoredCellRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);
		if (value instanceof Seance) {
			Seance s = (Seance) value;
			c.setBackground(Color.decode("0x" + s.getModule().getColor()));
			if (c instanceof JComponent) {
				JComponent jc = (JComponent) c;
				StringBuilder tooltip = new StringBuilder();
				tooltip.append("Module: ");
				tooltip.append(s.getModule().getAbbreviation());
				tooltip.append(" - ");
				tooltip.append(s.getModule().getName());
				tooltip.append("; Rang: ");
				tooltip.append(s.getRang());
				tooltip.append("; Formateur: ");
				tooltip.append(s.getFormateur().getNom());
				tooltip.append(", ");
				tooltip.append(s.getFormateur().getPrenom());
				jc.setToolTipText(tooltip.toString());
			}
		} else {
			c.setBackground(new Color(255, 255, 255));
		}
		return c;
	}
}