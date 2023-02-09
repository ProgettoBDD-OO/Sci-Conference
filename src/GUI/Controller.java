package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.CalendarFrame.CalendarMainFrame;

public class Controller {
	private MainFrame View;
	private CommentoBachecaFrame ViewCommentoBacheca;
	private CalendarMainFrame ViewCalendario;
	private LogInFrame ViewLogIn; 
	private SignUpFrame ViewSignUp;
	
    public Controller(MainFrame Vista, CommentoBachecaFrame VistaCB, CalendarMainFrame VistaC, LogInFrame VistaL, SignUpFrame VistaS) {
        this.View = Vista;
        this.ViewCommentoBacheca = VistaCB;
        this.ViewCalendario = VistaC;
        this.ViewLogIn = VistaL;
        this.ViewSignUp = VistaS;
    }
    
    public void assegnaGestori() {
    	
    	ActionListener gestoreCommentoBacheca;
    	ActionListener gestoreIndietroCommento;
    	
    	ActionListener gestoreCalendario;
    	ActionListener gestoreIndietroCalendario;
    	
    	ActionListener gestoreLogIn;
    	ActionListener gestoreAnnullaLogInBtn;
    	
    	ActionListener gestoreSignUp;
    	ActionListener gestoreAnnullaSignUpBtn;
    	
    	
//_____________________________________________Passaggio da MainFrame a CommentoBachecaFrame
    	
    	gestoreCommentoBacheca = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				View.setVisible(false);
				ViewCommentoBacheca.setVisible(true);
			}
		};
		
		View.getAddIdeaBtn().addActionListener(gestoreCommentoBacheca);
    	
		
//_____________________________________________Ritorno a MainFrame da CommentoBachecaFrame
		
		gestoreIndietroCommento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCommentoBacheca.setVisible(false);
				View.setVisible(true);
				
			}
		};
    	
    	ViewCommentoBacheca.getIndietroCommentoBachecaBtn().addActionListener(gestoreIndietroCommento);
    	
    	
//_____________________________________________Passaggio da MainFrame a CalendarioFrame
    	
    	gestoreCalendario = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCalendario.setVisible(true);
			}
		};
		
		View.getCalendario().addActionListener(gestoreCalendario);
		    
		 
//_____________________________________________Passaggio da MainFrame a LogInFrame
		    	
		  gestoreLogIn = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				View.setVisible(false);
				ViewLogIn.setVisible(true);
			}
		};
				
		View.getLogInBtn().addActionListener(gestoreLogIn);    	
				
		
//_____________________________________________Ritorno a MainFrame da LogInFrame
				
		gestoreAnnullaLogInBtn = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewLogIn.setVisible(false);
				View.setVisible(true);						
			}
		};
		    	
		ViewLogIn.getAnnullaLogInBtn().addActionListener(gestoreAnnullaLogInBtn);
		
		
//_____________________________________________Passaggio da MainFrame a SignUpFrame
    	
		  gestoreSignUp = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				View.setVisible(false);
				ViewSignUp.setVisible(true);
			}
		};
				
		View.getSignUpBtn().addActionListener(gestoreSignUp); 
		
		
//_____________________________________________Ritorno a MainFrame da SignUpFrame
		
		gestoreAnnullaSignUpBtn = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewSignUp.setVisible(false);
				View.setVisible(true);						
			}
		};
		    	
		ViewSignUp.getAnnullaSignUpBtn().addActionListener(gestoreAnnullaSignUpBtn);
    }
}