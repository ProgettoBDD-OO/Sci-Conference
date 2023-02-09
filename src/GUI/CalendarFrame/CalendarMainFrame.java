package GUI.CalendarFrame;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.awt.*;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalendarMainFrame extends JFrame{
	
	public CalendarMainFrame(String Titolo) {
			setTitle(Titolo);
			setBounds(100, 100, 1200, 700);
			setSize(850, 850);
			setLocationRelativeTo(null);
			setVisible(false);
			
			ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
			Image IconAppLogo = IconLogo.getImage();
			setIconImage(IconAppLogo);
			
			CalendarCustom MainPanel = new CalendarCustom();
			setContentPane(MainPanel);
	}
	
	
	
	
	
	
	
	
	
	
	
}