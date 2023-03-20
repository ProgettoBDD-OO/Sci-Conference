package linker;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

import DAO.ConferenzaDAO;
import DTO.Conferenza;
import GUI.*;
import GUI.CalendarFrame.CalendarMainFrame;
import GUI.CalendarFrame.CalendarPanel;
import GUI.MainFrame.MainFrame;
import myTools.DifferentPasswordException;
import myTools.JConfBtn;
import myTools.UserNotFoundException;
import myTools.WrongPasswordException;
import net.miginfocom.layout.ContainerWrapper;

import java.awt.Color;
import java.awt.MouseInfo;

public class ControllerLink {
	
	private MainFrame ViewMainFrame;
	
	private LogInFrame ViewLogIn; 
	private SignUpFrame ViewSignUp;
	
	private CalendarMainFrame ViewCalendario;
	private BachecaFrame ViewBacheca;
	
	private FilterFrame ViewFiltri;
	private RisultatiRicercaFrame ViewRisultati;
	
	private InfoConferenzaFrame ViewInfoConferenza;
	private InsertPswrdFrame ViewInsertPswrd;
	
	
	private Controller controller;
	
	private String linkedFrame;
	
	public ControllerLink(Controller contr) {
		
        controller = contr;
        ViewMainFrame = new MainFrame("", this, controller);
        ViewCalendario = new CalendarMainFrame("", this);
	}
	
//_____________________________________________________________________________________________MainFrame-Conferenze
	
	public void goToConferenza(String frameAttuale, String nomeConferenza) {
			
		linkedFrame = new String();
		
		if (ViewMainFrame.isVisible()) { ViewMainFrame.setVisible(false); ViewCalendario.setVisible(false); }
	        
	    linkedFrame = frameAttuale; 
	        
	    ViewInfoConferenza = new InfoConferenzaFrame("", this);
	    controller.addInfoConferenze(ViewMainFrame.getUtenteLoggato(), nomeConferenza, ViewInfoConferenza);
	    
	    ViewInfoConferenza.setVisible(true);
	}
		
	public String getFramePrecedente() { return linkedFrame; }
		
	public void backFromConferenza(String framePrecedente) {
			
		if(framePrecedente.equals("MainFrame")) { ViewMainFrame.setVisible(true); }
			
		if(framePrecedente.equals("RisultatiFrame")) { ViewRisultati.setVisible(true); }
	        
		framePrecedente = "";
	    ViewInfoConferenza.setVisible(false);
	}
	
//_____________________________________________________________________________________________Conferenze-Iscrizione	
	
	public void goToIscrizione() {
		
		if (ViewMainFrame.getUtenteLoggato().getEmail() != null) {
			
			ViewInsertPswrd = new InsertPswrdFrame(this);
			ViewInsertPswrd.setVisible(true);
			
		} else {
			
			ViewInfoConferenza.dispose();
			
			ViewSignUp = new SignUpFrame("Sci-Conference", this);
			ViewSignUp.setUsernameNull();
	        ViewSignUp.setEmailNull();
	        ViewSignUp.setPasswordTxtNull();
	        ViewSignUp.setCnfrmPasswordTxtNull();
	        ViewSignUp.setVisible(true);
		}
	}
	
	
	public void confermaIscrizione() {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		Conferenza conf = new Conferenza();
		conf = confDAO.getConferenza(ViewInfoConferenza.getNomeConferenzaLbl().getText());
		
		if (controller.iscrizione(ViewInsertPswrd, ViewMainFrame.getUtenteLoggato(), conf)) {
			
			ViewInsertPswrd.dispose();
			ViewInfoConferenza.dispose();
			JConfBtn ConfBtn = new JConfBtn(conf.getNome(), conf.getTema());
			controller.addUserConf(ConfBtn, ViewMainFrame.getCtrPanel(), conf);
			ViewMainFrame.setVisible(true);
			JOptionPane.showMessageDialog(ViewMainFrame,"Iscrizione Effettuata!");
		}
	}
	
	
//_____________________________________________________________________________________________MainFrame-LogIn
	
	public void goToLogIn() {

		ViewMainFrame.dispose();
		
		ViewLogIn = new LogInFrame("Sci-Conference", this, controller);
		ViewLogIn.setUsernameEmailTxtNull();
		ViewLogIn.setPasswordTxtNull();
		ViewLogIn.setVisible(true);
	}
	
	public void backFromLogIn() {
		
		ViewLogIn.dispose();
		
		ViewMainFrame = new MainFrame("", this, controller);
		ViewMainFrame.setVisible(true);
	}
	
	public void confermaLogIn() {
		
		try {
			
			controller.controlloLogIn(ViewLogIn, ViewMainFrame);
			ViewLogIn.dispose();
			ViewMainFrame.setVisible(true);
			JOptionPane.showMessageDialog(ViewMainFrame,"Log-In avvenuto con successo!\nBenvenuto!");
			
			for (JConfBtn cBtn : ViewMainFrame.getCtrPanel().getArrayConfBtns()) {
				cBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) { goToConferenza("MainFrame", (cBtn.getText())); }
				});
			}
				
		} catch (WrongPasswordException wpe) {
			
			System.out.println(wpe);
			JOptionPane.showMessageDialog(ViewLogIn, "Password errata!", "Dati incorretti", JOptionPane.ERROR_MESSAGE);
			
		} catch (UserNotFoundException unfe) {
			
			System.out.println(unfe);
			JOptionPane.showMessageDialog(ViewLogIn, "Username o Email non presenti!", "Dati incorretti",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
//_____________________________________________________________________________________________MainFrame-SignUp
	
	public void goToSignUp() {
		
		ViewMainFrame.dispose();
		
		ViewSignUp = new SignUpFrame("Sci-Conference", this);
		ViewSignUp.setUsernameNull();
        ViewSignUp.setEmailNull();
        ViewSignUp.setPasswordTxtNull();
        ViewSignUp.setCnfrmPasswordTxtNull();
        ViewSignUp.setVisible(true);
	}
	
	public void backFromSignUp() {
		
		ViewSignUp.dispose();
		ViewMainFrame.setVisible(true);
	}
	
	public void confermaSignUp() {
		
		try {
			
			controller.controlloSignUp(ViewSignUp, ViewMainFrame);
			ViewSignUp.dispose();
			ViewMainFrame.setVisible(true);
			JOptionPane.showMessageDialog(ViewMainFrame, "Registrazione effettuata!");
			
		} catch (DifferentPasswordException dpe) {
			
			System.out.println(dpe);
			JOptionPane.showMessageDialog(ViewSignUp, "Le password non corrispondono!","Dati incorretti",JOptionPane.ERROR_MESSAGE);
		}
	}
	
//_____________________________________________________________________________________________LogIn-SignUp
	
	public void fromLogInToSignUp() {
		
		ViewLogIn.dispose();
		
		ViewSignUp = new SignUpFrame("Sci-Conference", this);
		ViewSignUp.setVisible(true);
	}
	
	public void fromSignUpToLogIn() {
		
		ViewSignUp.dispose();
		
		ViewLogIn = new LogInFrame("Sci-Conference", this, controller);
		ViewLogIn.setVisible(true);
	}
	
	
	
//_____________________________________________________________________________________________MainFrame-Calendario
	
	public void goToCalendario() { ViewCalendario.setVisible(true); }
	
	
	
//_____________________________________________________________________________________________MainFrame-Filtri
	
	public void goToFiltri() {
		
		ViewFiltri = new FilterFrame("");
		Point MouseCoordnt = MouseInfo.getPointerInfo().getLocation();
		ViewFiltri.setLocation(MouseCoordnt.x - 20, MouseCoordnt.y + 25);
		ViewFiltri.setVisible(true);
		ViewFiltri.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("prova prova prova");
				ViewMainFrame.getDxPanel().getFilterBtn().setEnabled(true);
			}
		});
	}
	
	
	
//_____________________________________________________________________________________________MainFrame-Bacheca
	
	public void goToBacheca() {
		
		ViewMainFrame.setVisible(false);
		
		ViewBacheca = new BachecaFrame("Sci-Conference", this);
		ViewBacheca.setVisible(true);
	}
	
	public void backFromBacheca() {
		
		ViewBacheca.dispose();
		ViewMainFrame.setVisible(true);
	}
	
	
	
//_____________________________________________________________________________________________MainFrame-Risultati
	
	public void goToRisultati() {
		
		ViewMainFrame.setVisible(false);
		
		ViewRisultati = new RisultatiRicercaFrame("Sci-Conference", this);
		ViewRisultati.setVisible(true);
	}
	
	public void backFromRisultati() {
		
		ViewRisultati.dispose();
		ViewMainFrame.setVisible(true);
	}
}