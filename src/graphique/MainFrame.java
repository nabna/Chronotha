package graphique;

import graphique.listener.ExitScreenListener;
import graphique.listener.formateur.AnnulerFormateurListener;
import graphique.listener.formateur.LoadFormateurListener;
import graphique.listener.formateur.SaveFormateurListener;
import graphique.listener.module.AnnulerModuleListener;
import graphique.listener.module.LoadModuleListener;
import graphique.listener.module.SaveModuleListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuItem createSeanceAction;

	public MainFrame() {

		setTitle("Systeme de gestion planning");
		setSize(1000, 480);

		// Creates a menubar for a JFrame
		JMenuBar menuBar = new JMenuBar();

		// Add the menubar to the frame
		setJMenuBar(menuBar);

		// Define and add two drop down menu to the menubar
		JMenu menuGestionnaire = new JMenu("Gestionnaire");
		menuBar.add(menuGestionnaire);

		// Create and add simple menu item to one of the drop down menu
		createSeanceAction = new JMenuItem("Creer une seance...");
		JMenuItem createModuleAction = new JMenuItem("Creer une module...");
		JMenuItem createFormateurAction = new JMenuItem("Creer un formateur...");

		// Create a ButtonGroup and add both radio Button to it. Only one radio
		// button in a ButtonGroup can be selected at a time.
		ButtonGroup bg = new ButtonGroup();
		menuGestionnaire.add(createSeanceAction);
		menuGestionnaire.add(new JSeparator()); 
		menuGestionnaire.add(createModuleAction);
		menuGestionnaire.add(createFormateurAction);
		menuGestionnaire.addSeparator();
		// Add a listener to the New menu item. actionPerformed() method will
		// invoked, if user triggred this menu item
		createModuleAction.addActionListener(new CreateModuleAction());
		createFormateurAction.addActionListener(new CreateFormateurAction());
	}

	public JMenuItem getCreateSeanceAction() {
		return createSeanceAction;
	}

}

class CreateModuleAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame();
		frame.setSize(900, 710);
		GraphicModule panel = new GraphicModule();

		SaveModuleListener saveModuleListener = new SaveModuleListener(panel);
		saveModuleListener.refreshList();

		panel.getComboBoxRecherche().addItemListener(
				new LoadModuleListener(panel));
		panel.getButtonSauvegarder().addActionListener(saveModuleListener);
		panel.getButtonAnnuler().addActionListener(
				new AnnulerModuleListener(panel));
		panel.getButtonQuitter().addActionListener(
				new ExitScreenListener(frame));

		frame.add(panel);
		frame.setVisible(true);
	}

}

class CreateFormateurAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame();
		frame.setSize(500, 480);
		GraphicFormateur panel = new GraphicFormateur();

		SaveFormateurListener saveFormateurListener = new SaveFormateurListener(
				panel);
		saveFormateurListener.refreshList();

		panel.getComboBoxRecherche().addItemListener(
				new LoadFormateurListener(panel));
		panel.getButtonSauvegarder().addActionListener(saveFormateurListener);
		panel.getButtonAnnuler().addActionListener(
				new AnnulerFormateurListener(panel));
		panel.getButtonQuitter().addActionListener(
				new ExitScreenListener(frame));
		frame.add(panel);
		frame.setVisible(true);
	}

}