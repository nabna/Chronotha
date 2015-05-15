/*
 * Created by JFormDesigner on Thu May 14 20:17:01 CEST 2015
 */

package graphique;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class GraphicFormateur extends JPanel {
	public GraphicFormateur() {
		initComponents();
	}
	
	private Integer idFormateurSelected;
	
	public Integer getIdFormateurSelected() {
		return idFormateurSelected;
	}

	public void setIdFormateurSelected(Integer idFormateurSelected) {
		this.idFormateurSelected = idFormateurSelected;
	}

	public JTextField getTextNom() {
		return textNom;
	}

	public JTextField getTextPrenom() {
		return textPrenom;
	}

	public JTextField getTextTitre() {
		return textTitre;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public JButton getButtonSauvegarder() {
		return buttonSauvegarder;
	}

	public JButton getButtonQuitter() {
		return buttonQuitter;
	}

	public JButton getButtonAnnuler() {
		return buttonAnnuler;
	}

	public JComboBox getComboBoxRecherche() {
		return comboBoxRecherche;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		textNom = new JTextField();
		textPrenom = new JTextField();
		textTitre = new JTextField();
		textEmail = new JTextField();
		buttonSauvegarder = new JButton();
		buttonQuitter = new JButton();
		buttonAnnuler = new JButton();
		comboBoxRecherche = new JComboBox();
		label5 = new JLabel();
		label6 = new JLabel();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


		//---- label1 ----
		label1.setText("Nom");

		//---- label2 ----
		label2.setText("Pr\u00e9nom");

		//---- label3 ----
		label3.setText("Titre");

		//---- label4 ----
		label4.setText("Email");

		//---- buttonSauvegarder ----
		buttonSauvegarder.setText("Sauvegarder");

		//---- buttonQuitter ----
		buttonQuitter.setText("Quitter");

		//---- buttonAnnuler ----
		buttonAnnuler.setText("Annuler");

		//---- label5 ----
		label5.setText("Recherche");

		//---- label6 ----
		label6.setText("Gestionnaire de formateur");
		label6.setFont(new Font("Tahoma", Font.BOLD, 20));

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(37, 37, 37)
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
							.addGroup(layout.createSequentialGroup()
								.addComponent(buttonSauvegarder)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(buttonAnnuler)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonQuitter))
							.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
									.addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
									.addComponent(comboBoxRecherche)
									.addComponent(textPrenom)
									.addComponent(textNom)
									.addComponent(textTitre)
									.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))))
						.addComponent(label6, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addGap(30, 30, 30)
					.addComponent(label6)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(comboBoxRecherche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label5))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label1)
						.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23, 23, 23)
					.addGroup(layout.createParallelGroup()
						.addComponent(textPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label2))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup()
						.addComponent(textTitre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label3))
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addGap(18, 18, 18)
							.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(21, 21, 21)
							.addComponent(label4)))
					.addGap(58, 58, 58)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(buttonSauvegarder)
						.addComponent(buttonAnnuler)
						.addComponent(buttonQuitter))
					.addGap(28, 28, 28))
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textTitre;
	private JTextField textEmail;
	private JButton buttonSauvegarder;
	private JButton buttonQuitter;
	private JButton buttonAnnuler;
	private JComboBox comboBoxRecherche;
	private JLabel label5;
	private JLabel label6;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
