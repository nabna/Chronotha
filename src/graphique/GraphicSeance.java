/*
 * Created by JFormDesigner on Fri May 15 00:22:16 CEST 2015
 */

package graphique;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class GraphicSeance extends JPanel {
	public GraphicSeance() {
		initComponents();
	}
	
	private Integer idFormateurSelected;
	private Integer idModuleSelected;
	private Integer idPlanningSelected;
	
	public Integer getIdFormateurSelected() {
		return idFormateurSelected;
	}

	public void setIdFormateurSelected(Integer idFormateurSelected) {
		this.idFormateurSelected = idFormateurSelected;
	}

	public Integer getIdModuleSelected() {
		return idModuleSelected;
	}

	public void setIdModuleSelected(Integer idModuleSelected) {
		this.idModuleSelected = idModuleSelected;
	}
	
	public Integer getIdPlanningSelected() {
		return idPlanningSelected;
	}

	public void setIdPlanningSelected(Integer idPlanningSelected) {
		this.idPlanningSelected = idPlanningSelected;
	}

	public JTextField getTextDebut() {
		return textDebut;
	}

	public JTextField getTextDuree() {
		return textDuree;
	}

	public JTextField getTextRang() {
		return textRang;
	}

	public JButton getButtonSauvegarder() {
		return buttonSauvegarder;
	}

	public JButton getButtonQuitter() {
		return buttonQuitter;
	}

	public JComboBox getComboBoxModule() {
		return comboBoxModule;
	}

	public JComboBox getComboBoxFormateur() {
		return comboBoxFormateur;
	}
	
	public JComboBox getComboBoxPlanning() {
		return comboBoxPlanning;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		textDuree = new JTextField();
		textRang = new JTextField();
		buttonSauvegarder = new JButton();
		buttonQuitter = new JButton();
		comboBoxModule = new JComboBox();
		label5 = new JLabel();
		label6 = new JLabel();
		comboBoxFormateur = new JComboBox();
		label1 = new JLabel();
		label7 = new JLabel();
		comboBoxPlanning = new JComboBox();
		label8 = new JLabel();
		textDebut = new JTextField();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


		//---- label3 ----
		label3.setText("Dur\u00e9e");

		//---- label4 ----
		label4.setText("Rang");

		//---- buttonSauvegarder ----
		buttonSauvegarder.setText("Sauvegarder");

		//---- buttonQuitter ----
		buttonQuitter.setText("Quitter");

		//---- label5 ----
		label5.setText("Module");

		//---- label6 ----
		label6.setText("Gestionnaire de S\u00e9ance");
		label6.setFont(new Font("Tahoma", Font.BOLD, 20));

		//---- label1 ----
		label1.setText("Formateur");

		//---- label7 ----
		label7.setText("Planning");

		//---- label8 ----
		label8.setText("D\u00e9but");

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(37, 37, 37)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
							.addComponent(buttonSauvegarder)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(buttonQuitter))
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup()
								.addGroup(layout.createSequentialGroup()
									.addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 0, Short.MAX_VALUE)))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(comboBoxFormateur, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
								.addComponent(comboBoxModule)
								.addComponent(comboBoxPlanning, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(label8, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addComponent(label3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addComponent(label4, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup()
								.addComponent(textDebut, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDuree, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(textRang, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label6, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label6)
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(comboBoxModule, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label5))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(comboBoxFormateur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label1))
					.addGap(20, 20, 20)
					.addGroup(layout.createParallelGroup()
						.addComponent(comboBoxPlanning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label7))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label2)
					.addGap(29, 29, 29)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label8)
						.addComponent(textDebut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label3)
						.addComponent(textDuree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14, 14, 14)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(textRang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label4))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(buttonSauvegarder)
						.addComponent(buttonQuitter))
					.addGap(50, 50, 50))
		);
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField textDuree;
	private JTextField textRang;
	private JButton buttonSauvegarder;
	private JButton buttonQuitter;
	private JComboBox comboBoxModule;
	private JLabel label5;
	private JLabel label6;
	private JComboBox comboBoxFormateur;
	private JLabel label1;
	private JLabel label7;
	private JComboBox comboBoxPlanning;
	private JLabel label8;
	private JTextField textDebut;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
