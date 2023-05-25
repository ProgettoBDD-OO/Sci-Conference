package GUI.AdminFrames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import linker.Controller;


public class GoToNextInfoBtn extends JButton {

	Controller controller;

	public GoToNextInfoBtn(String comingFrom, Controller c) {

		controller = c;

		setText("Prossime Info");
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 0, 200));
		setPreferredSize(new Dimension(150, 35));

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comingFrom.equals("MainFrame")) { controller.goToAggiunta2(); }

				else {  controller.goToModifica2(); }
			}
		});
	}
}