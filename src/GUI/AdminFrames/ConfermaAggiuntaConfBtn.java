package GUI.AdminFrames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import linker.Controller;

public class ConfermaAggiuntaConfBtn extends JButton {

	Controller controller;
	
	public ConfermaAggiuntaConfBtn(Controller c) {
		
		controller = c;
		
		setText("Aggiungi Conferenza");
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 200));
		setPreferredSize(new Dimension(150, 35));
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.confermaAggiunta();
			}
		});
	}
}