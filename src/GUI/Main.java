package GUI;
import java.awt.*;
import com.formdev.flatlaf.*;

public class Main {
	public static void main(String[] args) { 
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                MainFrame Vista = new MainFrame("Sci-Conference");
	                CommentoBachecaFrame VistaCB = new CommentoBachecaFrame("Sci-Conference");
	                CalendarioFrame VistaC = new CalendarioFrame("Sci-Conference");
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