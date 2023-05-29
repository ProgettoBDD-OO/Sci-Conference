package GUI.CalendarFrame;

import linker.Controller;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class CalendarFrame extends JFrame{

	Controller controller;

	public CalendarFrame(Controller c) {

		controller = c;
		
		setTitle("Sci-Conference - Calendario");
		setSize(850, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());

		CalendarCustom MainPanel = new CalendarCustom(controller);
		setContentPane(MainPanel);
	}
}