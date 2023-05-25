package GUI.ConferenzaFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import linker.Controller;

public class IscrivitiBtn extends JButton {

	Controller controller;
	
	public IscrivitiBtn(Controller c) {
		
		controller = c;
		
		setText("Iscriviti");
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 200));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setPreferredSize(new Dimension(150, 30));
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.goToIscrizione();
			}
		});
	}
}