package linker;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;


import DAO.ConferenzaDAO;
import DAO.TOKEN;
import DTO.Conferenza;
import GUI.*;
import GUI.AdminFrames.AggiuntaConfFrame1;
import GUI.AdminFrames.AggiuntaConfFrame2;
import GUI.AdminFrames.InfoFrame;
import GUI.AdminFrames.OrganizzatoriFrame;
import GUI.CalendarFrame.CalendarMainFrame;
import GUI.FilterFrame.FilterFrame;
import GUI.MainFrame.MainFrame;
import myException.DifferentPasswordException;
import myException.EmailAlreadyExistsException;
import myException.EmptyFieldException;
import myException.InvalidEmailFormatException;
import myException.ShortPswrdException;
import myException.UserNotFoundException;
import myException.WrongPasswordException;
import myTools.JLblButton;

import java.awt.Color;
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
	String queryData = "";
	
	private InfoConferenzaFrame ViewInfoConferenza;
	private InsertPswrdFrame ViewInsertPswrd;
	
	private AggiuntaConfFrame1 ViewAggiuntaConf1;
	private AggiuntaConfFrame2 ViewAggiuntaConf2;
	private InfoFrame ViewInfo;
	private OrganizzatoriFrame ViewOrganizzatori;
	String queryOrganizzatore = "INSERT INTO organizzatore VALUES ";
	
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
			ViewSignUp.setFieldsNull();
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
			ConfBtn.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					goToConferenza("MaiFrame", ConfBtn.getText());
				}
			});
			
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
		
		TOKEN token = new TOKEN();

        if(token.checkTOKEN(ViewLogIn.getPasswordTxt())) {
           
        	ViewLogIn.dispose();
        	ViewMainFrame.getCtrPanel().getCentrLbl().setText("Gestione conferenze");
        	ViewMainFrame.getCtrPanel().getCentrCardLayout().show(ViewMainFrame.getCtrPanel().getCentrCardPanel(), "4");
            ViewMainFrame.setVisible(true);
        
        } else {
		
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
			JOptionPane.showMessageDialog(ViewSignUp, "Password troppo corta", "Dati incorretti", JOptionPane.ERROR_MESSAGE);
			
		} catch (DifferentPasswordException dpe) {
			
			System.out.println(dpe);
			JOptionPane.showMessageDialog(ViewSignUp, "Le password non corrispondono!", "Dati incorretti",JOptionPane.ERROR_MESSAGE);
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
	
//_____________________________________________________________________________________________MainFrame-AggiuntaConf	
	
	public void goToAggiuntaConf() {
		
		ViewMainFrame.setVisible(false);
		
		ViewAggiuntaConf1 = new AggiuntaConfFrame1("", this);
		ViewAggiuntaConf1.setVisible(true);
	}
	
	public void backFromAggiuntaConf() {
		
		ViewAggiuntaConf1.dispose();
		ViewMainFrame.setVisible(true);
	}
	
	
	public void goToAggiuntaConf2() {
		
		//controller.preparaConferenza1(ViewAggiuntaConf1);
		ViewAggiuntaConf1.setVisible(false);
		ViewAggiuntaConf2 = new AggiuntaConfFrame2("", this);
		ViewAggiuntaConf2.setVisible(true);
	}
	
	public void backFromAggiuntaConf2() {
		
		ViewAggiuntaConf2.dispose();
		ViewAggiuntaConf1.setVisible(true);
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
		
		for (String s : ViewAggiuntaConf2.getEnti()) {
			System.out.println( "ok " + s);
		}
	}
	
	public void addSponsor() {
		
		controller.addInfo(ViewInfo.getInfo(), ViewAggiuntaConf2.getSponsor());
		
		for (String s : ViewAggiuntaConf2.getSponsor()) {
			System.out.println( "ok " + s);
		}
	}
	
	public void goToOrganizzatori() {

		ViewOrganizzatori = new OrganizzatoriFrame(this);
		ViewOrganizzatori.setLocation(ViewAggiuntaConf2.getOrganizzatoriLbl().getLocationOnScreen());
		ViewOrganizzatori.setVisible(true);
	}
	
	
	public void addOrganizzatore(String q, int n) {
		
		if (n < ViewAggiuntaConf2.getNumeroOrganizzatori().getSelectedIndex() + 1) {
			
			queryOrganizzatore += q;
			ViewOrganizzatori.nextOrganizzatore(n);
			
		} else { queryOrganizzatore += q; ViewOrganizzatori.dispose();  }
	}

	
//__________________________________________________________________________________________
	
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