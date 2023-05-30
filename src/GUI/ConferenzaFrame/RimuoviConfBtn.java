package GUI.ConferenzaFrame;

import linker.Controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class RimuoviConfBtn extends JButton {

	Controller controller;
	
	public RimuoviConfBtn(Controller c, String idConferenza) {
		
		controller = c;
		
		setText("Rimuovi");
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(212, 0, 0));
		setPreferredSize(new Dimension(75, 25));
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				controller.confermaRimozione(idConferenza);
			}
		});
	}
}