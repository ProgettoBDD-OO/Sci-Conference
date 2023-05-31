package GUI.AdminFrames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import linker.Controller;

public class ConfermaAggiuntaConfBtn extends JButton {

	private Controller controller;

	public ConfermaAggiuntaConfBtn(Controller c) {

		controller = c;

		setText("Aggiungi Conferenza");
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 200));
		setPreferredSize(new Dimension(130, 30));

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.confermaAggiunta();
			}
		});
	}
}