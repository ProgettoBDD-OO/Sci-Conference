package GUI.CalendarFrame;

import linker.Controller;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class CalendarFrame extends JFrame{

	private Controller controller;

	public CalendarFrame(Controller c) {

		controller = c;
		
		setTitle("Sci-Conference - Calendario");
		setSize(730, 730);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());

		CalendarCustom MainPanel = new CalendarCustom(controller);
		setContentPane(MainPanel);
	}
}