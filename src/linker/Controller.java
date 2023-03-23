package linker;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import DAO.ConferenzaBachecaDAO;
import DAO.ConferenzaDAO;
import DAO.UtenteDAO;
import DTO.Conferenza;
import DTO.ConferenzaBacheca;
import DTO.Utente;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.*;

import GUI.BachecaFrame;
import GUI.InfoConferenzaFrame;
import GUI.InsertPswrdFrame;
import GUI.LogInFrame;
import GUI.SignUpFrame;
import GUI.MainFrame.CentrPanel;
import GUI.MainFrame.ConferenzaBachecaPanel;
import GUI.MainFrame.EastPanel;
import GUI.MainFrame.MainFrame;
import GUI.MainFrame.WestPanel;
import myTools.DifferentPasswordException;
import myTools.JLblButton;
import myTools.UserNotFoundException;
import myTools.WrongPasswordException;
import myTools.myColors;

public class Controller {
	
	boolean aggiuntoFiltro = false;
	myColors c = new myColors();
	
//_____________________________________________________________Controllo Sign-Up
	
	protected void controlloSignUp(SignUpFrame viewSignUp, MainFrame viewMainFrame) throws DifferentPasswordException {
        
        if (viewSignUp.getPasswordTxt().equals(viewSignUp.getCnfrmPasswordTxt())) {
            
        	registraUtente(viewSignUp, viewMainFrame);
        	
        	viewMainFrame.getSxPanel().getUserPanelCardLayout().show(viewMainFrame.getSxPanel().getUserCardPanel(), "2");
            viewMainFrame.getCtrPanel().getCentralCardLayout().show(viewMainFrame.getCtrPanel().getCentrCardPanel(), "2");
            
        } else { 
        
        	viewSignUp.setPasswordTxtNull();
        	viewSignUp.setCnfrmPasswordTxtNull();
        	viewSignUp.getPasswordFld().setBorder(new MatteBorder(1,1,1,1,Color.RED));
        	viewSignUp.getCnfrmPasswordFld().setBorder(new MatteBorder(1,1,1,1,Color.RED));
        	throw new DifferentPasswordException("Il campo per confermare la password non corrisponde."); 
        }
	}
	
	
	private void registraUtente(SignUpFrame viewSignUp, MainFrame viewMainFrame) {
		
		UtenteDAO utenteDAO = new UtenteDAO();
		Utente utente = new Utente();
		
    	utente.setEmail(viewSignUp.getEmailTxt());
    	utente.setUsername(viewSignUp.getUsernameTxt());
    	utente.setPassword_user(viewSignUp.getPasswordTxt());
    	
    	viewMainFrame.setUtenteLoggato(utente);
    	viewMainFrame.getSxPanel().getUsernameLbl().setText(utente.getUsername());
    	utenteDAO.registrazione(utente);
	}
	
	
	
	
//_____________________________________________________________Controllo Log-In 
	
	protected void controlloLogIn(LogInFrame viewLogIn, MainFrame viewMainFrame) throws UserNotFoundException, WrongPasswordException {
    	
        UtenteDAO utenteDAO = new UtenteDAO();
        Utente utente = new Utente();
        utente =  utenteDAO.getUtente(viewLogIn.getUsernameEmailTxt());
        
        
		if(utente.getEmail() != null) {
			
			viewLogIn.getUsernameEmailFld().setBorder(new MatteBorder(1,1,1,1, c.scBlue));
			viewLogIn.getPasswordFld().setBorder(new MatteBorder(1,1,1,1, c.scBlue));		
			
			if(utenteDAO.checkPassword(utente, viewLogIn.getPasswordTxt())) {							
	
				viewMainFrame.setUtenteLoggato(utente);
				checkUserConf(utente, viewMainFrame.getCtrPanel().getArrayLblButtons(), viewMainFrame.getCtrPanel());
				viewMainFrame.getSxPanel().getUserPanelCardLayout().show(viewMainFrame.getSxPanel().getUserCardPanel(), "2"); 
				viewMainFrame.getSxPanel().getUsernameLbl().setText(utente.getUsername());
				
			} else {
				
				viewLogIn.getPasswordFld().setBorder(new MatteBorder(1,1,1,1,Color.RED));
				viewLogIn.setPasswordTxtNull();
				throw new WrongPasswordException("Wrong password.");
			}
			
		} else {
			
			viewLogIn.getUsernameEmailFld().setBorder(new MatteBorder(1,1,1,1,Color.RED));
			viewLogIn.setUsernameEmailTxtNull();
		    viewLogIn.setPasswordTxtNull();
		    throw new UserNotFoundException("User not found.");
		}
    }
	
	
	private void checkUserConf(Utente utente, ArrayList<JLblButton> arrayLblButtons, CentrPanel ctrPanel) {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		int n = 0;

		if(confDAO.getConferenzeUtente(utente.getEmail()) != null) {
			
			for (Conferenza cnf : confDAO.getConferenzeUtente(utente.getEmail())) {
				
				arrayLblButtons.add(new JLblButton(c.gray, cnf.getNome(), cnf.getTema()));
				addUserConf(arrayLblButtons.get(n), ctrPanel, cnf);
				n++;
			}
			
			ctrPanel.getCentralCardLayout().show(ctrPanel.getCentrCardPanel(),"3");
			
		} else { ctrPanel.getCentralCardLayout().show(ctrPanel.getCentrCardPanel(),"2"); }
	}
	
	
	protected void addUserConf(JLblButton lBtn, CentrPanel ctrPanel, Conferenza c) {
		 
		lBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		lBtn.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lBtn.setBorder(new EmptyBorder(10,0,10,0));
		ctrPanel.getUserConfAfterAccess2().add(lBtn);
	}
	
	
	
	
//_____________________________________________________________Aggiunta Info al Frame Conferenze
	
	protected void addInfoConferenze(Utente utente, String nomeConferenza, InfoConferenzaFrame viewConferenza) {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		Conferenza conf = new Conferenza();
		conf = confDAO.getConferenza(nomeConferenza);		

		if (confDAO.checkIscrizione(utente.getEmail(), conf.getId())) {
			viewConferenza.getIscrizioneCardLayout().show(viewConferenza.getIscrizioneCardPanel(), "2");
		}
		
        viewConferenza.getNomeConferenzaLbl().setText(conf.getNome());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        viewConferenza.getDataInizioLbl().setText(dateFormat.format(conf.getDataInizio().getTime()));
        viewConferenza.getDataFineLbl().setText(dateFormat.format(conf.getDataFine().getTime()));
                
        viewConferenza.getDescrizioneLbl().setText(conf.getDescrizione());
        viewConferenza.getTemaLbl().setText(conf.getTema());
              
        setTopicColor(conf.getTema(), viewConferenza.getNomeConferenzaLbl());
        setTopicColor(conf.getTema(), viewConferenza.getTemaLbl());
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
				
			case "Matematica":    com.setForeground(c.scBlue);
				break;
				
			case "Psicologia":	  com.setForeground(new Color(255, 0, 128));
				break;
				
			case "Sostenibilità": com.setForeground(new Color(240, 210, 0));
				break;

			default: System.out.println("Errore nello switch del tema.");
				break;
		}
	}
	
	
	
	
//_____________________________________________________________Controllo Iscrizione
	
	protected boolean iscrizione(InsertPswrdFrame viewInsertPswrd, Utente utente, Conferenza conf) {
		
		if (viewInsertPswrd.getPasswordFld().getText().equals(utente.getPassword_user())) {
			
			UtenteDAO utenteDAO = new UtenteDAO();
			utenteDAO.iscrizione(utente.getEmail(), conf.getId());
			return true;
			
		} else {
			
			viewInsertPswrd.getPasswordFld().setText("");
			viewInsertPswrd.getPasswordFld().setBorder(new MatteBorder(1,1,1,1,Color.RED));
			return false;
		}
	}
	
	
	
	
//_____________________________________________________________Controllo CalendarPanel
	
	public void addConferenze(WestPanel sxPanel) {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		int n = 0;
		
		for (Conferenza cnf : confDAO.getConferenze()) {
			
			switch (cnf.getDataInizio().get(Calendar.MONTH)) {
        	
			case 2:
				addBtn(sxPanel.getArrayLblButtons(), n, sxPanel.getConferenzeMese1(), cnf);
				n++;
        		break;
        		
			case 3:
				addBtn(sxPanel.getArrayLblButtons(), n, sxPanel.getConferenzeMese2(), cnf);
				n++;
				break;
				
			case 4:
				addBtn(sxPanel.getArrayLblButtons(), n, sxPanel.getConferenzeMese3(), cnf);
				n++;
				break;
			}
		} 	
	}
	
	
	private void addBtn(ArrayList<JLblButton> array, int n, JPanel panel, ConferenzaBacheca conf) {
		
		array.add(new JLblButton(c.gray, conf.getNome(), conf.getTema()));
		array.get(n).setFont(new Font("Calibri Light", Font.PLAIN, 17));
		panel.add(array.get(n));
	}
	
	
	
	
//_____________________________________________________________Controllo ResearchBar
	
	public void setTextNull(EastPanel dxPanel) {
		
		dxPanel.getResearchBar().setText("");
		dxPanel.getResearchBar().setFont(new Font("Calibri Corpo", Font.PLAIN, 14));
		dxPanel.getResearchBar().setForeground(c.tangaroa);
	}
	
	
	protected ArrayList<JLblButton> getRisultati(String queryFinale) {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		ArrayList<JLblButton> arrayConfBtns = new ArrayList<JLblButton>();
				
		for (Conferenza cnf : confDAO.getConferenzeRicerca(queryFinale)) {
			
			arrayConfBtns.add(new JLblButton(c.gray, cnf.getNome(), cnf.getTema()));
		}
		
		return arrayConfBtns;
	}
	 
	
	protected String addNomeFiltro(String queryIniziale, String queryTemi, String queryCollocazioni, EastPanel dxPanel) {  
		  
		String q = componiQuery(queryIniziale, queryTemi, queryCollocazioni);
		
		if(q.equals("SELECT nome, tema FROM conferenze_scientifiche")) {	  
			  
			q += " WHERE nome ILIKE '%" + dxPanel.getResearchBar().getText() + "%';";
			  
		} else {
			
			q += ") AND nome ILIKE '%" + dxPanel.getResearchBar().getText() + "%';";  
		}
		
		return q;
	}  

	private String componiQuery(String queryIniziale, String queryTemi, String queryCollocazioni) { 
		
		if (queryTemi.equals("") && queryCollocazioni.equals("")) { return queryIniziale; }
		
		else if(queryTemi.equals("")) { queryIniziale += " WHERE (" + queryCollocazioni.substring(0, queryCollocazioni.length() - 3); } 
		  
		else if(queryCollocazioni.equals("")) { queryIniziale += " WHERE (" + queryTemi.substring(0, queryTemi.length() - 3); } 
		  
		else { queryIniziale += " WHERE ("+  queryTemi.substring(0, queryTemi.length() - 3) + ") AND (" + queryCollocazioni.substring(0, queryCollocazioni.length() - 3); }
		
		return queryIniziale;
	}
	
	
	
	
//_____________________________________________________________Controllo Bacheca
	
	public void addIdeaToBacheca(BachecaFrame viewBacheca) {
		
		ConferenzaBacheca confBacheca = new ConferenzaBacheca();
		ConferenzaBachecaDAO confBachecaDAO = new ConferenzaBachecaDAO();

		confBacheca.setNome(viewBacheca.getNomeConfTxt());
		confBacheca.setDescrizione(viewBacheca.getDescrizioneConfTxt());
		confBacheca.setTema(viewBacheca.getButtonGroup().getSelection().getActionCommand());
		confBachecaDAO.addConf(confBacheca);
	}
	
	public void showLatestConfInBacheca(EastPanel dxPanel) {
		
		ConferenzaBachecaDAO confBachecaDAO = new ConferenzaBachecaDAO();

		int n = 0;
		
		for (ConferenzaBacheca cB : confBachecaDAO.getConferenzeBacheca()) {
			
			addConfBacheca(dxPanel.getArrayConfBacheca(), n, dxPanel.getBacheca(), cB);
			n ++;
		}
	}
	
	public void addConfBacheca(ArrayList<JLblButton> array, int n, JPanel bacheca, ConferenzaBacheca confB) {
		
		array.add(new JLblButton(c.lBlue, confB.getNome(), confB.getTema()));
		array.get(n).setFont(new Font("Calibri Light", Font.PLAIN, 17));
		array.get(n).setAlignmentX(Component.CENTER_ALIGNMENT);
		array.get(n).setBorder(new EmptyBorder(25, 0, 25, 0));
		bacheca.add(array.get(n));
	}
	
	public void setInfoConfBacheca(ConferenzaBachecaPanel cbPanel, String nome) {
		
		ConferenzaBachecaDAO confBachecaDAO = new ConferenzaBachecaDAO();
		ConferenzaBacheca confBacheca = new ConferenzaBacheca();
		confBacheca = confBachecaDAO.getConferenzaBacheca(nome);
		
		cbPanel.setNomeLbl(confBacheca.getNome());
		cbPanel.setDescrizioneLbl(confBacheca.getDescrizione());
		cbPanel.setTemaLbl(confBacheca.getTema());
	}
}    