/*
 * Created by JFormDesigner on Mon May 11 20:55:08 CEST 2015
 */

package graphique;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import container.Planning;

public class GraphicPlanning extends JPanel {
	
	private List<Planning> plannings;
	
	public List<Planning> getPlannings() {
		return plannings;
	}

	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}

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
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		buttonCreerSeance = new JButton();
		buttonExporter = new JButton();
		buttonSave = new JButton();
		buttonQuitter = new JButton();
		comboBoxYear = new JComboBox();
		label1 = new JLabel();
		label3 = new JLabel();
		this2 = new JPanel();
		scrollPane2 = new JScrollPane();
		table2 = new JTable();
		buttonCreerSeance2 = new JButton();
		buttonExporter2 = new JButton();
		buttonSave2 = new JButton();
		buttonQuitter2 = new JButton();
		comboBoxYear2 = new JComboBox();
		label2 = new JLabel();
		buttonSupprimerSeance2 = new JButton();

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
		buttonExporter.setText("Exporter");

		//---- buttonSave ----
		buttonSave.setText("Saugarder");

		//---- buttonQuitter ----
		buttonQuitter.setText("Quitter");

		//---- label1 ----
		label1.setText("Choisir l'ann\u00e9e scolaire");

		//---- label3 ----
		label3.setText("Gestionnaire de Planning");
		label3.setFont(new Font("Tahoma", Font.BOLD, 20));

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addGap(27, 27, 27)
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(comboBoxYear, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(buttonCreerSeance)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(buttonExporter, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
							.addComponent(buttonQuitter, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
							.addGap(36, 36, 36)
							.addGroup(layout.createParallelGroup()
								.addComponent(scrollPane1)
								.addGroup(layout.createSequentialGroup()
									.addComponent(label3, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 708, Short.MAX_VALUE)))))
					.addGap(145, 145, 145))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(13, 13, 13)
					.addComponent(label3)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(comboBoxYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonCreerSeance)
						.addComponent(label1)
						.addComponent(buttonExporter)
						.addComponent(buttonSave)
						.addComponent(buttonQuitter))
					.addGap(48, 48, 48))
		);

		//======== this2 ========
		{

			// JFormDesigner evaluation mark
			this2.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), this2.getBorder())); this2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


			//======== scrollPane2 ========
			{
				scrollPane2.setViewportView(table2);
			}

			//---- buttonCreerSeance2 ----
			buttonCreerSeance2.setText("Cr\u00e9er une s\u00e9ance");

			//---- buttonExporter2 ----
			buttonExporter2.setText("Exporter");

			//---- buttonSave2 ----
			buttonSave2.setText("Saugarder");

			//---- buttonQuitter2 ----
			buttonQuitter2.setText("Quitter");

			//---- label2 ----
			label2.setText("Choisir l'ann\u00e9e scolaire");

			//---- buttonSupprimerSeance2 ----
			buttonSupprimerSeance2.setText("Supprimer une s\u00e9ance");

			GroupLayout this2Layout = new GroupLayout(this2);
			this2.setLayout(this2Layout);
			this2Layout.setHorizontalGroup(
				this2Layout.createParallelGroup()
					.addGroup(this2Layout.createSequentialGroup()
						.addGap(36, 36, 36)
						.addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addGroup(this2Layout.createSequentialGroup()
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(comboBoxYear2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addGap(40, 40, 40)
								.addComponent(buttonCreerSeance2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buttonSupprimerSeance2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonExporter2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addGap(28, 28, 28)
								.addComponent(buttonSave2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addGap(30, 30, 30)
								.addComponent(buttonQuitter2))
							.addComponent(scrollPane2))
						.addGap(145, 145, 145))
			);
			this2Layout.setVerticalGroup(
				this2Layout.createParallelGroup()
					.addGroup(this2Layout.createSequentialGroup()
						.addGap(27, 27, 27)
						.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(buttonQuitter2)
							.addComponent(label2)
							.addComponent(buttonSave2)
							.addComponent(buttonExporter2)
							.addComponent(comboBoxYear2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonCreerSeance2)
							.addComponent(buttonSupprimerSeance2))
						.addGap(48, 48, 48))
			);
		}
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton buttonCreerSeance;
	private JButton buttonExporter;
	private JButton buttonSave;
	private JButton buttonQuitter;
	private JComboBox comboBoxYear;
	private JLabel label1;
	private JLabel label3;
	private JPanel this2;
	private JScrollPane scrollPane2;
	private JTable table2;
	private JButton buttonCreerSeance2;
	private JButton buttonExporter2;
	private JButton buttonSave2;
	private JButton buttonQuitter2;
	private JComboBox comboBoxYear2;
	private JLabel label2;
	private JButton buttonSupprimerSeance2;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
