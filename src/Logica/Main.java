package Logica;
import java.awt.*;
import com.formdev.flatlaf.*;

import GUI.CommentoBachecaFrame;
import GUI.InfoConferenzaFrame;
import GUI.LogInFrame;
import GUI.MainFrame;
import GUI.RisultatiRicercaFrame;
import GUI.SignUpFrame;
import GUI.CalendarFrame.*;

public class Main {
	public static void main(String[] args) { 
		
		Connessione database = new Connessione();
		database.connetti();
		
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                MainFrame Vista = new MainFrame("Sci-Conference");
	                CommentoBachecaFrame VistaCB = new CommentoBachecaFrame("Sci-Conference");
	                CalendarMainFrame VistaC = new CalendarMainFrame("Sci-Conference");
	                LogInFrame VistaL = new LogInFrame("Science Conference LOG-IN");
	                SignUpFrame VistaS = new SignUpFrame("Science Conference SIGN-UP");
	                InfoConferenzaFrame VistaI = new InfoConferenzaFrame("Science Conference Info");
	                RisultatiRicercaFrame VistaR = new RisultatiRicercaFrame("Science Conference Info",Vista);
	                Controller Controllore = new Controller(Vista,VistaCB,VistaC,VistaL,VistaS,VistaI,VistaR);
	                
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });

	}
}