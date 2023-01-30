package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import GUI.MainFrame.MainFrame;

public class Controller {
	private MainFrame View;
	private CommentoBachecaFrame ViewCommentoBacheca;
	private CalendarioFrame ViewCalendario;
	private LogInFrame ViewLogIn; 
	private SignUpFrame ViewSignUp;
	
    public Controller(MainFrame Vista, CommentoBachecaFrame VistaCB, CalendarioFrame VistaC, LogInFrame VistaL, SignUpFrame VistaS) {
        this.View = Vista;
        this.ViewCommentoBacheca = VistaCB;
        this.ViewCalendario = VistaC;
        this.ViewLogIn = VistaL;
        this.ViewSignUp = VistaS;
    }
    
    public void assegnaGestori() {
    	
    	ActionListener gestoreCommentoBacheca;
    	ActionListener gestoreIndietroCommento;
    	ActionListener gestoreTemiBtn;
    	
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
    	
    	//_____________________________________________Tema selezionato in CommentoBachecaFrame
    	
    	gestoreTemiBtn = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton temaScelto = (JButton) e.getSource();
				
				if (temaScelto == ViewCommentoBacheca.getTemaAmbienteBtn()) {
					ViewCommentoBacheca.getTemaSelezionatoPanel().setBackground(Color.GREEN);
				} else if (temaScelto == ViewCommentoBacheca.getTemaFisicaBtn()) {
					ViewCommentoBacheca.getTemaSelezionatoPanel().setBackground(Color.RED);
				} else if (temaScelto == ViewCommentoBacheca.getTemaChimicaBtn()) {
					ViewCommentoBacheca.getTemaSelezionatoPanel().setBackground(Color.CYAN);
				} else if (temaScelto == ViewCommentoBacheca.getTemaMatematicaBtn()) {
					ViewCommentoBacheca.getTemaSelezionatoPanel().setBackground(Color.BLUE);
				} else if (temaScelto == ViewCommentoBacheca.getTemaSostenibilitàBtn()) {
					ViewCommentoBacheca.getTemaSelezionatoPanel().setBackground(Color.YELLOW);
				} else if (temaScelto == ViewCommentoBacheca.getTemaAltroBtn()) {
					ViewCommentoBacheca.getTemaSelezionatoPanel().setBackground(Color.darkGray);
				}
				
			}
		};
		
		ViewCommentoBacheca.getTemaAmbienteBtn().addActionListener(gestoreTemiBtn);
		ViewCommentoBacheca.getTemaFisicaBtn().addActionListener(gestoreTemiBtn);
		ViewCommentoBacheca.getTemaChimicaBtn().addActionListener(gestoreTemiBtn);
		ViewCommentoBacheca.getTemaMatematicaBtn().addActionListener(gestoreTemiBtn);
		ViewCommentoBacheca.getTemaSostenibilitàBtn().addActionListener(gestoreTemiBtn);
		ViewCommentoBacheca.getTemaAltroBtn().addActionListener(gestoreTemiBtn);
		
        //_____________________________________________Passaggio da MainFrame a CalendarioFrame
    	
    	gestoreCalendario = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				View.setVisible(false);
				ViewCalendario.setVisible(true);
			}
		};
		
		View.getCalendario().addActionListener(gestoreCalendario);
		
		//_____________________________________________Ritorno a MainFrame da CalendarioFrame
		
		gestoreIndietroCalendario = new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCalendario.setVisible(false);
				View.setVisible(true);
						
			}
		};
		    	
		 ViewCalendario.getIndietroCalendarioBtn().addActionListener(gestoreIndietroCalendario);
		    	
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