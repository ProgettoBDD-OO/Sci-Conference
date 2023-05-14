package GUI.CalendarFrame;

import linker.Controller;

import javax.swing.*;


public class CalendarMainFrame extends JFrame{
	
	Controller controller;
	
	public CalendarMainFrame(String Titolo, Controller c) {
		
		controller = c;
			
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setSize(850, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
			
		CalendarCustom MainPanel = new CalendarCustom(controller);
		setContentPane(MainPanel);
	}
}