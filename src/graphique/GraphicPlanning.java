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

	public JComboBox getComboBox1() {
		return comboBox1;
	}

	public JButton getButton2() {
		return button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public JButton getButton4() {
		return button4;
	}

	public JButton getButton5() {
		return button5;
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
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		comboBox1 = new JComboBox();
		label1 = new JLabel();

		// ======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(
						new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation",
						javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM,
						new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), getBorder()));
		addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				if ("border".equals(e.getPropertyName()))
					throw new RuntimeException();
			}
		});

		// ======== scrollPane1 ========
		{
			scrollPane1.setViewportView(table1);
		}

		// ---- button2 ----
		button2.setText("Cr\u00e9er une s\u00e9ance");

		// ---- button3 ----
		button3.setText("Exportation");

		// ---- button4 ----
		button4.setText("Saugarder");

		// ---- button5 ----
		button5.setText("Quitter l'\u00e9cran");

		// ---- label1 ----
		label1.setText("Ann\u00e9e scolaire");

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup()
				.addGroup(
						layout.createSequentialGroup()
								.addGap(36, 36, 36)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		label1,
																		GroupLayout.PREFERRED_SIZE,
																		84,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		comboBox1,
																		GroupLayout.PREFERRED_SIZE,
																		168,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(39, 39,
																		39)
																.addComponent(
																		button2)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED,
																		59,
																		Short.MAX_VALUE)
																.addComponent(
																		button3,
																		GroupLayout.PREFERRED_SIZE,
																		132,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(102,
																		102,
																		102)
																.addComponent(
																		button4)
																.addGap(110,
																		110,
																		110)
																.addComponent(
																		button5))
												.addComponent(scrollPane1))
								.addGap(145, 145, 145)));
		layout.setVerticalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup()
						.addGap(27, 27, 27)
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE,
								419, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(button5)
										.addComponent(button4)
										.addComponent(button3)
										.addComponent(label1)
										.addComponent(comboBox1,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(button2))
						.addGap(48, 48, 48)));
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jixuan LIU
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JComboBox comboBox1;
	private JLabel label1;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
