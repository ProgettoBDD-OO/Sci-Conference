package GUI.AdminFrames;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import linker.Controller;

public class BackFromGestioneBtn extends JButton {

	private Controller controller;

	public BackFromGestioneBtn(String comingFrom, Controller c) {

		controller = c;

		setText("Indietro");
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setPreferredSize(new Dimension(130, 30));
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (comingFrom.equals("MainFrame")) { controller.backFromAggiunta(); }

				else {  controller.backFromModifica(); }
			}
		});
	}
}