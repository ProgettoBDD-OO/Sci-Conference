package linker;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicRadioButtonUI;

import DAO.ConferenzaDAO;
import DTO.Conferenza;
import GUI.*;
import GUI.CalendarFrame.CalendarMainFrame;
import GUI.MainFrame.MainFrame;
import myTools.DifferentPasswordException;
import myTools.JLblButton;
import myTools.UserNotFoundException;
import myTools.WrongPasswordException;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.MouseInfo;

public class ControllerLink {
	
	
	private MainFrame ViewMainFrame;
	private LogInFrame ViewLogIn; 
	private SignUpFrame ViewSignUp;
	
	private CalendarMainFrame ViewCalendario;
	private BachecaFrame ViewBacheca;
	
	private FilterFrame ViewFiltri;
	private RisultatiRicercaFrame ViewRisultati;
	
	String queryIniziale = "SELECT nome, tema FROM conferenze_scientifiche";
	String queryTemi = "";
	String queryCollocazioni = "";
	
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
		linkedFrame = frameAttuale; 
		
		if (ViewMainFrame.isVisible()) { ViewMainFrame.setVisible(false); ViewCalendario.setVisible(false); }

		else { ViewRisultati.setVisible(false); }
	        
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
			JLblButton ConfBtn = new JLblButton(new Color(100, 105, 110), conf.getNome(), conf.getTema());
			controller.addUserConf(ConfBtn, ViewMainFrame.getCtrPanel(), conf);
			ViewMainFrame.setVisible(true);
			JOptionPane.showMessageDialog(ViewMainFrame,"Iscrizione Effettuata!");
		}
	}
	
	
//_____________________________________________________________________________________________MainFrame-LogIn
	
	public void goToLogIn() {

		ViewMainFrame.dispose();
		
		ViewLogIn = new LogInFrame("Sci-Conference", this);
		ViewLogIn.setUsernameEmailTxtNull();
		ViewLogIn.setPasswordTxtNull();
		ViewLogIn.setVisible(true);
	}
	
	public void backFromLogIn() {
		
		ViewLogIn.dispose();
		ViewMainFrame.setVisible(true);
	}
	
	public void confermaLogIn() {
		
		try {
			
			controller.controlloLogIn(ViewLogIn, ViewMainFrame);
			ViewLogIn.dispose();
			ViewMainFrame.setVisible(true);
			JOptionPane.showMessageDialog(ViewMainFrame,"Log-In avvenuto con successo!\nBenvenuto!");
			
			for (JLblButton cBtn : ViewMainFrame.getCtrPanel().getArrayLblButtons()) {
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
		
		ViewLogIn = new LogInFrame("Sci-Conference", this);
		ViewLogIn.setVisible(true);
	}
	
	
	
//_____________________________________________________________________________________________MainFrame-Calendario
	
	public void goToCalendario() { ViewCalendario.setVisible(true); }
	
	
	
//_____________________________________________________________________________________________MainFrame-Filtri
	
	public void goToFiltri() {
		
		ViewFiltri = new FilterFrame("", controller, this);
		Point MouseCoordnt = MouseInfo.getPointerInfo().getLocation();
		ViewFiltri.setLocation(MouseCoordnt.x - 20, MouseCoordnt.y + 25);
		ViewFiltri.setVisible(true);
	}
	
	public void foo() {
		ViewMainFrame.getDxPanel().getFilterBtn().setEnabled(true);
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
	
	public void confermaBacheca() {
		
		controller.addIdeaToBacheca(ViewBacheca);
		ViewBacheca.dispose();
		ViewMainFrame.setVisible(true);
		JOptionPane.showMessageDialog(ViewMainFrame,"Idea inserita in bacheca!");
	}
	
	
	
//_____________________________________________________________________________________________MainFrame-Risultati
	
	public void goToRisultati() {
		
		String QueryFinale = controller.addNomeFiltro(queryIniziale, queryTemi, queryCollocazioni, ViewMainFrame.getDxPanel());
		
		ViewRisultati = new RisultatiRicercaFrame("Sci-Conference", this);
		
		if (!controller.getRisultati(QueryFinale).isEmpty()) {
			
			for (JLblButton lBtn : controller.getRisultati(QueryFinale)) {
				
				lBtn.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				lBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) { goToConferenza("RisultatiFrame", (lBtn.getText())); }
				});
				ViewRisultati.getRisultatiPanel().add(lBtn);
			}
			
			ViewRisultati.getRisultatiCardLayout().show(ViewRisultati.getRisultatiCardPanel(), "2");
		} 
		
		ViewMainFrame.setVisible(false);
		ViewRisultati.setVisible(true);
	}
	
	public void backFromRisultati() {
		
		ViewRisultati.dispose();
		ViewMainFrame.setVisible(true);
	}
	
	public void addLuogoToLbl(String filtro) {
		
		ViewMainFrame.getDxPanel().getClearFltrBtn().setVisible(true);
		ViewMainFrame.getDxPanel().addPlacesLbl(filtro);
	}
	
	public void addTemaToLbl(String filtro) {
		
		ViewMainFrame.getDxPanel().getClearFltrBtn().setVisible(true);
		ViewMainFrame.getDxPanel().addTopicsLbl(filtro);
	}
	
	public String getQueryTemi() { return queryTemi; }
	
	public void addQueryTemi(String q) { queryTemi += q; }

	public void resetQuery() { queryTemi = ""; queryCollocazioni = ""; }
	
	public String getQueryCollocazioni() { return queryCollocazioni; }
	
	public void addQueryCollocazioni(String q) { queryCollocazioni += q; }
}