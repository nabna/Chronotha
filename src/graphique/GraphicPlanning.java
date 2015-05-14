/*
 * Created by JFormDesigner on Mon May 11 20:55:08 CEST 2015
 */

package graphique;

import javax.swing.*;
import javax.swing.GroupLayout;

public class GraphicPlanning extends JPanel {
	public GraphicPlanning() {
		initComponents();
	}

	public JComboBox getComboBoxYear() {
		return comboBoxYear;
	}

	public JButton getButtonCreerSeance() {
		return buttonCreerSeance;
	}

	public JButton getButtonExporter() {
		return buttonExporter;
	}

	public JButton getButtonSave() {
		return buttonSave;
	}

	public JButton getButtonQuitter() {
		return buttonQuitter;
	}

	public JTable getTable1() {
		return table1;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jixuan LIU
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		buttonCreerSeance = new JButton();
		buttonExporter = new JButton();
		buttonSave = new JButton();
		buttonQuitter = new JButton();
		comboBoxYear = new JComboBox();
		label1 = new JLabel();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(table1);
		}

		//---- buttonCreerSeance ----
		buttonCreerSeance.setText("Cr\u00e9er une s\u00e9ance");

		//---- buttonExporter ----
		buttonExporter.setText("Exportation");

		//---- buttonSave ----
		buttonSave.setText("Saugarder");

		//---- buttonQuitter ----
		buttonQuitter.setText("Quitter l'\u00e9cran");

		//---- label1 ----
		label1.setText("Ann\u00e9e scolaire");

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(36, 36, 36)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(comboBoxYear, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(39, 39, 39)
							.addComponent(buttonCreerSeance)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addComponent(buttonExporter, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(102, 102, 102)
							.addComponent(buttonSave)
							.addGap(110, 110, 110)
							.addComponent(buttonQuitter))
						.addComponent(scrollPane1))
					.addGap(145, 145, 145))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(27, 27, 27)
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(buttonQuitter)
						.addComponent(buttonSave)
						.addComponent(buttonExporter)
						.addComponent(label1)
						.addComponent(comboBoxYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonCreerSeance))
					.addGap(48, 48, 48))
		);
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jixuan LIU
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton buttonCreerSeance;
	private JButton buttonExporter;
	private JButton buttonSave;
	private JButton buttonQuitter;
	private JComboBox comboBoxYear;
	private JLabel label1;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
