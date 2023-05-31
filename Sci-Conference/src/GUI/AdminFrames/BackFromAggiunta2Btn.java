package GUI.AdminFrames;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import linker.Controller;

public class BackFromAggiunta2Btn extends JButton {

	private Controller controller;

	public BackFromAggiunta2Btn(Controller c) {

		controller = c;

		setText("Indietro");
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setPreferredSize(new Dimension(130, 30));
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				controller.backFromAggiunta2();
			}
		});
	}
}