package GUI.CalendarFrame;

import linker.Controller;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class CalendarFrame extends JFrame{

	Controller controller;

	public CalendarFrame(Controller c) {

		controller = c;
		
		setTitle("Sci-Conference - Calendario");
		setBounds(100, 100, 1200, 700);
		setSize(850, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());

		CalendarCustom MainPanel = new CalendarCustom(controller);
		setContentPane(MainPanel);
	}
}