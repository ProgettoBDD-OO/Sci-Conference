package linker;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import javax.swing.JOptionPane;


import DAO.ConferenzaDAO;
import DAO.TOKEN;
import DTO.Conferenza;

import GUI.*;
import GUI.AdminFrames.GestioneConfFrame;
import GUI.AdminFrames.AggiuntaConfFrame2;
import GUI.AdminFrames.InfoFrame;
import GUI.AdminFrames.ModificaFrame2;
import GUI.AdminFrames.OrganizzatoriFrame;
import GUI.AdminFrames.SessioneFrame;
import GUI.CalendarFrame.CalendarMainFrame;
import GUI.ConferenzaFrame.ConferenzaFrame;
import GUI.ConferenzaFrame.InsertPswrdFrame;
import GUI.FilterFrame.FilterFrame;
import GUI.MainFrame.MainFrame;
import GUI.MainFrame.SxConfBtn;
import GUI.MainFrame.UserConfBtn;
import GUI.MainFrame.WestPanel;

import myException.DifferentPasswordException;
import myException.EmailAlreadyExistsException;
import myException.EmptyFieldException;
import myException.EnteNotFoundException;
import myException.InvalidEmailFormatException;
import myException.ShortPswrdException;
import myException.UserNotFoundException;
import myException.WrongPasswordException;

import myTools.ConfBtn;
import myTools.JLblButton;

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
	private AfferenzeFrame ViewAfferenze;
	
	String queryIniziale = "SELECT * FROM conferenze_scientifiche";
	String queryTemi = "";
	String queryCollocazioni = "";
	String queryData = "";
	
	private ConferenzaFrame ViewConferenza;
	private InsertPswrdFrame ViewInsertPswrd;
	
	private GestioneConfFrame ViewGestioneConf;
	private AggiuntaConfFrame2 ViewAggiuntaConf2;
	private ModificaFrame2 ViewModifica;
	private InfoFrame ViewInfo;
	private OrganizzatoriFrame ViewOrganizzatori;
	private SessioneFrame ViewSessioni;
	
	String queryConferenza = "";
	String queryOrganizzatore = "INSERT INTO organizzatori VALUES ";
	String querySessione = "INSERT INTO sessioni VALUES ";
	
	private Controller controller;
	
	public ControllerLink(Controller contr) {
		
        controller = contr;
        ViewMainFrame = new MainFrame("", this, controller);
        ViewCalendario = new CalendarMainFrame("", this);
	}
	
	
	public void addConferenze(WestPanel sxPanel) {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		
		for (Conferenza cnf : confDAO.getConferenze()) {
			
			switch (cnf.getDataInizio().get(Calendar.MONTH)) {
        	
			case 3:
				sxPanel.getConferenzeMese1().add(new SxConfBtn(this, cnf.getNome(), cnf.getTema(), cnf.getId().toString()));
        		break;
        		
			case 4:
				sxPanel.getConferenzeMese2().add(new SxConfBtn(this, cnf.getNome(), cnf.getTema(), cnf.getId().toString()));
				break;
			}
		} 	
	}
	
//_____________________________________________________________________________________________MainFrame-Conferenze
	
	public void goToConferenza(String idConferenza) {
			 
		ViewConferenza = new ConferenzaFrame("Sci-Conference", this, controller);
		
		if (ViewMainFrame.isVisible()) { 
			
			ViewMainFrame.setVisible(false); 
			ViewCalendario.setVisible(false);
			ViewConferenza.setFramePrecedente("MainFrame");
		}
		
		else { ViewRisultati.setVisible(false); }
	        
	    controller.addInfoConferenze(ViewMainFrame.getUtenteLoggato(), idConferenza, ViewConferenza);
	    
	    setTopicColor(ViewConferenza.getTemaLbl().getText(), ViewConferenza.getNomeLbl());
        setTopicColor(ViewConferenza.getTemaLbl().getText(), ViewConferenza.getTemaLbl());
	    ViewConferenza.foo();
	    ViewConferenza.setVisible(true);
	}
		
	private void setTopicColor(String Tema, Component com) {
    	
		switch (Tema) {
			
    		case "Ambiente":	  com.setForeground(new Color(0, 200, 0));
				break;
				
			case "Anatomia": 	  com.setForeground(new Color(250, 88, 80));
				break;
				
			case "Astrologia":	  com.setForeground(new Color(30, 30, 120));
				break;
				
			case "Biologia":	  com.setForeground(new Color(0, 128, 0));
				break;
				
			case "Chimica":		  com.setForeground(new Color(0, 200, 255));
				break;
				
			case "Fisica":		  com.setForeground(new Color(250, 80, 0));
				break;
				
			case "Geologia":	  com.setForeground(new Color(180, 100, 40));
				break;
				
			case "Informatica":	  com.setForeground(new Color(0, 100, 255));
				break;
				
			case "Matematica":    com.setForeground(new Color(0, 0, 200));
				break;
				
			case "Psicologia":	  com.setForeground(new Color(255, 0, 128));
				break;
				
			case "Sostenibilità": com.setForeground(new Color(240, 210, 0));
				break;

			default: System.out.println("Errore nello switch del tema.");
				break;
		}
	}
		
	public void backFromConferenza(String framePrecedente) {
			
		if(framePrecedente.equals("MainFrame")) { ViewMainFrame.setVisible(true); }
		
		else { ViewRisultati.setVisible(true); }
		
	    ViewConferenza.setVisible(false);
	}
	
//_____________________________________________________________________________________________Conferenze-Iscrizione	
	
	public void goToIscrizione() {
		
		if (ViewMainFrame.getUtenteLoggato().getEmail() != null) {
			
			ViewInsertPswrd = new InsertPswrdFrame(this);
			ViewInsertPswrd.setVisible(true);
			
		} else {
			
			ViewConferenza.dispose();
			
			ViewSignUp = new SignUpFrame("Sci-Conference", this);
			ViewSignUp.setFieldsNull();
	        ViewSignUp.setVisible(true);
		}
	}
	
	public void confermaIscrizione() {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		Conferenza conf = new Conferenza();
		conf = confDAO.getConferenza(ViewConferenza.getId());
		
		if (controller.iscrizione(ViewInsertPswrd, ViewMainFrame.getUtenteLoggato(), conf)) {
			
			ViewInsertPswrd.dispose();
			ViewConferenza.dispose();
			
			ViewMainFrame.getCtrPanel().getUserConfAfterAccess2().add(new UserConfBtn(this, conf.getNome(), conf.getTema(), conf.getId().toString()));
			ViewMainFrame.setVisible(true);
			JOptionPane.showMessageDialog(ViewMainFrame,"Iscrizione Effettuata!");
		}
	}
	
	
//_____________________________________________________________________________________________MainFrame-LogIn
	
	public void goToLogIn() {
		
		ViewMainFrame.dispose();
		
		ViewLogIn = new LogInFrame("Sci-Conference", this);
		ViewLogIn.setUsernameEmailTxtNull();
		ViewLogIn.getPasswordFld().setText("123!BFO€8A$B124N");
		ViewLogIn.setVisible(true);
	}
	
	public void backFromLogIn() {
		
		ViewLogIn.dispose();
		ViewMainFrame.setVisible(true);
	}
	
	public void confermaLogIn() {
		
		TOKEN token = new TOKEN();

        if(token.checkTOKEN(ViewLogIn.getPassword())) {
           
        	ViewLogIn.dispose();
        	ViewMainFrame.getCtrPanel().getCentrLbl().setText("Gestione conferenze");
        	ViewMainFrame.getCtrPanel().getCentrCardLayout().show(ViewMainFrame.getCtrPanel().getCentrCardPanel(), "4");
            ViewMainFrame.setVisible(true);
        
        } else {
		
			try {
				
				ArrayList<Conferenza> confUtente = controller.controlloLogIn(ViewLogIn, ViewMainFrame);
				
				if(confUtente.isEmpty()) { ViewMainFrame.getCtrPanel().getCentrCardLayout().show(ViewMainFrame.getCtrPanel().getCentrCardPanel(),"2"); }
				
				else { 
					
					for (Conferenza cnf : confUtente) {
						ViewMainFrame.getCtrPanel().getUserConfAfterAccess2().add(new UserConfBtn(this, cnf.getNome(), cnf.getTema(), cnf.getId().toString()));
					}
				
					ViewMainFrame.getCtrPanel().getCentrCardLayout().show(ViewMainFrame.getCtrPanel().getCentrCardPanel(),"3"); 
				}
				
				ViewLogIn.dispose();
				ViewMainFrame.setVisible(true);
				JOptionPane.showMessageDialog(ViewMainFrame, "Log-In avvenuto con successo!\nBenvenuto!");
				
			} catch (WrongPasswordException wpe) {
				
				System.out.println(wpe);
				JOptionPane.showMessageDialog(ViewLogIn, wpe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
				
			} catch (UserNotFoundException unfe) {
				
				System.out.println(unfe);
				JOptionPane.showMessageDialog(ViewLogIn, unfe.getMessage(), "Dati incorretti",JOptionPane.ERROR_MESSAGE);
			}
        }
	}
	
	
//_____________________________________________________________________________________________MainFrame-SignUp
	
	public void goToSignUp() {
		
		ViewMainFrame.dispose();
		
		ViewSignUp = new SignUpFrame("Sci-Conference", this);
		ViewSignUp.setFieldsNull();
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
			
		} catch (EmptyFieldException efe) {
			
			System.out.println(efe);
			JOptionPane.showMessageDialog(ViewSignUp, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
			
		} catch (InvalidEmailFormatException iefe) {
			 
			System.out.println(iefe);
			JOptionPane.showMessageDialog(ViewSignUp, iefe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
			
		} catch (EmailAlreadyExistsException eaee) {
			 
			System.out.println(eaee);
			JOptionPane.showMessageDialog(ViewSignUp, eaee.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
			
		} catch (ShortPswrdException spe) {
			 
			System.out.println(spe);
			JOptionPane.showMessageDialog(ViewSignUp, spe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
			
		} catch (DifferentPasswordException dpe) {
			
			System.out.println(dpe);
			JOptionPane.showMessageDialog(ViewSignUp, dpe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
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
		
		ViewFiltri = new FilterFrame("", this);
		Point MouseCoordnt = MouseInfo.getPointerInfo().getLocation();
		ViewFiltri.setLocation(MouseCoordnt.x - 20, MouseCoordnt.y + 25);
		ViewFiltri.setVisible(true);
		
		queryData = "";
	}
	
	public void backFromFiltri() { ViewMainFrame.getDxPanel().getFilterBtn().setEnabled(true); }
	
	
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
		
		try { 
			
			controller.addIdeaToBacheca(ViewBacheca); 
			ViewBacheca.dispose();
			ViewMainFrame.setVisible(true);
			JOptionPane.showMessageDialog(ViewMainFrame, "Idea inserita in bacheca!");
		} 
		
		catch (EmptyFieldException efe) {
			
			System.out.println(efe);
			JOptionPane.showMessageDialog(ViewBacheca, "Inserire tutti i campi!", "Dati incorretti", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
//_____________________________________________________________________________________________MainFrame-Risultati
	
	public void goToRisultati() {
		
		String QueryFinale = controller.addNomeFiltro(queryIniziale, queryTemi, queryCollocazioni, queryData, ViewMainFrame.getDxPanel());
		System.out.println(QueryFinale);
		ViewRisultati = new RisultatiRicercaFrame("Sci-Conference", this);
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		
		for (Conferenza cnf : confDAO.getConferenzeRicerca(QueryFinale)) {
			
			ViewRisultati.getRisultatiPanel().add(new ConfBtn(this, cnf.getNome(), cnf.getTema(), cnf.getId()));
		}
		
		ViewRisultati.getRisultatiCardLayout().show(ViewRisultati.getRisultatiCardPanel(), "2");
		
		ViewMainFrame.setVisible(false);
		ViewRisultati.setVisible(true);
	}
	
	public void backFromRisultati() {
		
		ViewRisultati.dispose();
		ViewMainFrame.setVisible(true);
	}
	
//_____________________________________________________________________________________________MainFrame-AggiuntaConf	
	
	public void goToAggiuntaConf() {
		
		ViewMainFrame.setVisible(false);
		
		ViewGestioneConf = new GestioneConfFrame("", this, controller);
		ViewGestioneConf.setComingFrom("MainFrame");
		ViewGestioneConf.setVisible(true);
	}
	
	public void backFromAggiuntaConf() {
		
		ViewGestioneConf.dispose();
		ViewMainFrame.setVisible(true);
	}
	
	
	public void goToAggiuntaConf2() {
		
		try {
			
			queryConferenza += controller.preparaConferenza(ViewGestioneConf, queryConferenza);
			ViewGestioneConf.setVisible(false);
			ViewAggiuntaConf2 = new AggiuntaConfFrame2("", this);
			ViewAggiuntaConf2.setVisible(true);
		
		} catch (Exception e) {
			// TODO: handle exception
		} //...
	}
	
	public void goToModificaFrame2() {
		
		ViewModifica = new ModificaFrame2("", this, controller);
		ViewGestioneConf.setVisible(false);
		ViewModifica.setVisible(true);
	}
	
	public void backFromAggiuntaConf2() {
		
		ViewAggiuntaConf2.dispose();
		ViewGestioneConf.setVisible(true);
	}

	public void confermaAggiunta() {
			
			controller.inserisciCollocazione(ViewGestioneConf, queryConferenza);
			controller.inserisciEnte(ViewAggiuntaConf2);
			controller.inserisciSponsor(ViewAggiuntaConf2);
			controller.inserisciOrganizzatore(queryOrganizzatore);
			controller.inserisciConferenza(ViewGestioneConf, queryConferenza);
			controller.inserisciSessioni(querySessione);
		
			ViewGestioneConf.dispose();
			ViewAggiuntaConf2.dispose();
			ViewMainFrame.setVisible(true);
	}
	
	public void goToEnti() {
		
		ViewInfo = new InfoFrame(this, "Enti");
		controller.addInfoFld(ViewAggiuntaConf2.getNumeroEnti(), ViewInfo);
		ViewInfo.setLocation(ViewAggiuntaConf2.getEntiLbl().getLocationOnScreen());
		ViewInfo.setVisible(true);
	}
	
	public void goToSponsor() {
		
		ViewInfo = new InfoFrame(this, "Sponsor");
		controller.addInfoFld(ViewAggiuntaConf2.getNumeroSponsor(), ViewInfo);
		ViewInfo.setLocation(ViewAggiuntaConf2.getEntiLbl().getLocationOnScreen());
		ViewInfo.setVisible(true);
	}
	
	
	public void addEnti() {
		
		controller.addInfo(ViewInfo.getInfo(), ViewAggiuntaConf2.getEnti());
	}
	
	
	public void addSponsor() {
		
		controller.addInfo(ViewInfo.getInfo(), ViewAggiuntaConf2.getSponsor());
	}
	
	public void goToOrganizzatori() {

		ViewOrganizzatori = new OrganizzatoriFrame(this);
		ViewOrganizzatori.setVisible(true);
	}
	
	
	//SPOSTARE IN CONTROLLER, QUI TRY & CATCH
	public void addOrganizzatore(String q, int n) {
		
		if (ViewAggiuntaConf2.getEnti().contains(ViewOrganizzatori.getAfferenza())) {
			
			if (n < ViewAggiuntaConf2.getNumeroOrganizzatori().getSelectedIndex()) {
				
				queryOrganizzatore += q;
				ViewOrganizzatori.nextOrganizzatore();
				
			} else { queryOrganizzatore += q; ViewOrganizzatori.dispose(); }
		
		} else {
			
			//exception...
		}
	}

	
	public void goToSessioni() {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		
		ViewSessioni = new SessioneFrame(this, confDAO.getNextId());
		ViewSessioni.setVisible(true);
		
	}
	
	
	public void addSessione(String q, int n) {
		
		if (n < ViewAggiuntaConf2.getNumeroSessioni().getSelectedIndex()) {
			
			querySessione += q;
			ViewSessioni.nextSessione();
		
		} else { querySessione += q; ViewSessioni.dispose(); }
		
	}
	
	
	
	
	
	
	
	
	
//__________________________________________________________________________________________Modifica
	
	public void goToUpdateConf(String idConferenza) {

		ViewRisultati.dispose();
		
		ViewGestioneConf = new GestioneConfFrame("", this, controller);
        controller.setInfoInUpdateConf(idConferenza, ViewGestioneConf);

        ViewGestioneConf.setVisible(true);
    }

	public void goToRisultati2() {
	
		ViewRisultati = new RisultatiRicercaFrame("Sci-Conference", this);
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		
		for (Conferenza cnf : confDAO.getConferenze()) {
			
			ViewRisultati.getRisultatiPanel().add(new ConfBtn(this, cnf.getNome(), cnf.getTema(), cnf.getId(), "goToUpdateConf"));
		}
		
		ViewRisultati.getRisultatiCardLayout().show(ViewRisultati.getRisultatiCardPanel(), "2");
		
		ViewMainFrame.setVisible(false);
		ViewRisultati.setVisible(true);
	}
	
	public void backFromUpdateConf() {

        ViewGestioneConf.dispose();
        ViewRisultati.setVisible(true);
    }
	
	
	
	
	
	
	
	
	
//__________________________________________________________________________________________
	
	public void goToAfferenze() {
		
		ViewMainFrame.setVisible(false);
		ViewAfferenze = new AfferenzeFrame("", this, controller);
		ViewAfferenze.setVisible(true);
	}
	
	public void backFromAfferenze() {
		
		ViewAfferenze.dispose();
		ViewMainFrame.setVisible(true);
	}
//__________________________________________________________________________________________
	
	
	public void addDataLbl(String filtro) {
		
		ViewMainFrame.getDxPanel().getClearFltrBtn().setVisible(true);
		ViewMainFrame.getDxPanel().addDateLbl(filtro);
	}
	
	public void addLuogoToLbl(String filtro) {
		
		ViewMainFrame.getDxPanel().getClearFltrBtn().setVisible(true);
		ViewMainFrame.getDxPanel().addPlacesLbl(filtro);
	}
	
	public void addTemaToLbl(String filtro) {
		
		ViewMainFrame.getDxPanel().getClearFltrBtn().setVisible(true);
		ViewMainFrame.getDxPanel().addTopicsLbl(filtro);
	}
	
	public String getQueryData() { return queryData; }
	
	public void addQueryData(String q) { queryData += q; };
	
	public String getQueryTemi() { return queryTemi; }
	
	public void addQueryTemi(String q) { queryTemi += q; }

	public String getQueryCollocazioni() { return queryCollocazioni; }

	public void addQueryCollocazioni(String q) { queryCollocazioni += q; }
	
	public void resetQuery() { queryTemi = ""; queryCollocazioni = ""; } 
}