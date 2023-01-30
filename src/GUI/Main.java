package GUI;
import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.*;

import GUI.MainFrame.MainFrame;

public class Main {
    public static void main(String[] args){
    	FlatIntelliJLaf.setup();
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	                MainFrame Vista = new MainFrame("GUI Science Conference");
	                CommentoBachecaFrame VistaCB = new CommentoBachecaFrame("GUI Science Conference");
	                CalendarioFrame VistaC = new CalendarioFrame("GUI Science Conference");
	                LogInFrame VistaL = new LogInFrame("Science Conference LOG-IN");
	                SignUpFrame VistaS = new SignUpFrame("Sceince Conference SIGN-UP");
	                Controller Controllore = new Controller(Vista,VistaCB,VistaC,VistaL,VistaS);
	                Controllore.assegnaGestori();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}