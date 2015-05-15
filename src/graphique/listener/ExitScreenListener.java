package graphique.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ExitScreenListener implements ActionListener {
	
	private JFrame frame;
	
	public ExitScreenListener(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		frame.setVisible(false);
		frame.dispose();
	}

}
