package GUI;
import java.awt.*;
import com.formdev.flatlaf.*;

public class Main {
<<<<<<< HEAD
	public static void main(String[] args) { 
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                MainFrame Vista = new MainFrame("Sci-Conference");
	                CommentoBachecaFrame VistaCB = new CommentoBachecaFrame("Sci-Conference");
	                CalendarioFrame VistaC = new CalendarioFrame("Sci-Conference");
=======
    public static void main(String[] args){
    	FlatIntelliJLaf.setup();
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	                MainFrame Vista = new MainFrame("GUI Science Conference");
	                CommentoBachecaFrame VistaCB = new CommentoBachecaFrame("GUI Science Conference");
	                CalendarioFrame VistaC = new CalendarioFrame("GUI Science Conference");
>>>>>>> ad49237d0132d715413b07616f00ba071df1a6fa
	                LogInFrame VistaL = new LogInFrame("Science Conference LOG-IN");
	                SignUpFrame VistaS = new SignUpFrame("Sceince Conference SIGN-UP");
	                Controller Controllore = new Controller(Vista,VistaCB,VistaC,VistaL,VistaS);
	                Controllore.assegnaGestori();
<<<<<<< HEAD
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
=======
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
>>>>>>> ad49237d0132d715413b07616f00ba071df1a6fa
}