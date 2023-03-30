package GUI.CalendarFrame;

import javax.swing.*;

import linker.ControllerLink;

import java.awt.*;

public class CalendarMainFrame extends JFrame{
	
	ControllerLink controllerLink;
	
	public CalendarMainFrame(String Titolo, ControllerLink contrLink) {
		
		controllerLink = contrLink;
			
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setSize(850, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
			
		CalendarCustom MainPanel = new CalendarCustom(controllerLink);
		setContentPane(MainPanel);
	}
}