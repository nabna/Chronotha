package graphique.listener.planning;

import graphique.GraphicSeance;
import graphique.listener.ExitScreenListener;
import graphique.listener.seance.LoadSeanceFormateurListener;
import graphique.listener.seance.LoadSeanceModuleListener;
import graphique.listener.seance.SaveSeanceListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CreateSeanceListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
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

}
