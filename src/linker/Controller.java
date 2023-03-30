package linker;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import DAO.ProposteBachecaDAO;
import DAO.SponsorDAO;
import DAO.CollocazioneDAO;
import DAO.ConferenzaDAO;
import DAO.EnteDAO;
import DAO.OrganizzatoreDAO;
import DAO.UtenteDAO;
import DTO.Conferenza;
import DTO.ProposteBacheca;
import DTO.Utente;

import GUI.BachecaFrame;
import GUI.InfoConferenzaFrame;
import GUI.InsertPswrdFrame;
import GUI.LogInFrame;
import GUI.SignUpFrame;
import GUI.AdminFrames.AggiuntaConfFrame1;
import GUI.AdminFrames.AggiuntaConfFrame2;
import GUI.AdminFrames.InfoFrame;
import GUI.MainFrame.CentrPanel;
import GUI.MainFrame.ConferenzaBachecaPanel;
import GUI.MainFrame.EastPanel;
import GUI.MainFrame.MainFrame;
import GUI.MainFrame.WestPanel;
import myException.DifferentPasswordException;
import myException.EmailAlreadyExistsException;
import myException.EmptyFieldException;
import myException.InvalidEmailFormatException;
import myException.ShortPswrdException;
import myException.UserNotFoundException;
import myException.WrongPasswordException;
import myTools.JLblButton;
import myTools.myTemplates;

public class Controller {
	
	myTemplates c = new myTemplates();
	boolean aggiuntoFiltro = false;
	
	
//_____________________________________________________________Controllo Sign-Up
	
	protected void controlloSignUp(SignUpFrame viewSignUp, MainFrame viewMainFrame) throws EmptyFieldException, DifferentPasswordException, ShortPswrdException, InvalidEmailFormatException, EmailAlreadyExistsException {
		
		if (viewSignUp.getEmailTxt().isEmpty() || viewSignUp.getUsernameTxt().isEmpty() || viewSignUp.getPasswordTxt().isEmpty() || viewSignUp.getCnfrmPasswordTxt().isEmpty()) {
			
			throw new EmptyFieldException();

		} else if (!viewSignUp.getEmailTxt().matches("[A-z0-9]+@[A-z]+\\.[a-z]+")) {
			
			viewSignUp.setEmailError();
			throw new InvalidEmailFormatException();
			
		} else if (viewSignUp.getPasswordTxt().length() < 5) {
			
			viewSignUp.setPasswordError();
			throw new ShortPswrdException();
			
		} else if (!viewSignUp.getPasswordTxt().equals(viewSignUp.getCnfrmPasswordTxt())) {
			
			viewSignUp.setPasswordError();
        	throw new DifferentPasswordException();   	
	            
		} else { 
	        	
			registraUtente(viewSignUp, viewMainFrame);
        	
        	viewMainFrame.getSxPanel().getUserPanelCardLayout().show(viewMainFrame.getSxPanel().getUserCardPanel(), "2");
            viewMainFrame.getCtrPanel().getCentrCardLayout().show(viewMainFrame.getCtrPanel().getCentrCardPanel(), "2");
	        	 
		}
	}
	
	private void registraUtente(SignUpFrame viewSignUp, MainFrame viewMainFrame) throws EmailAlreadyExistsException {
		
		UtenteDAO utenteDAO = new UtenteDAO();
		Utente utente = new Utente();
		
		if (!utenteDAO.checkEmail(viewSignUp.getEmailTxt())) {
			
			viewSignUp.setEmailError();
			throw new EmailAlreadyExistsException();
			
		} else {
			
			utente.setEmail(viewSignUp.getEmailTxt());
	    	utente.setUsername(viewSignUp.getUsernameTxt());
	    	utente.setPassword_user(viewSignUp.getPasswordTxt());
	    	
	    	viewMainFrame.setUtenteLoggato(utente);
	    	viewMainFrame.getSxPanel().getUsernameLbl().setText(utente.getUsername());
	    	utenteDAO.registrazione(utente);
		}
	}
	
	
	
	
//_____________________________________________________________Controllo Log-In 
	
	protected void controlloLogIn(LogInFrame viewLogIn, MainFrame viewMainFrame) throws UserNotFoundException, WrongPasswordException {
    	
        UtenteDAO utenteDAO = new UtenteDAO();
        Utente utente = new Utente();
        utente =  utenteDAO.getUtente(viewLogIn.getUsernameEmailTxt());
        
        
		if(utente.getEmail() != null) {	
			
			if(utenteDAO.checkPassword(utente, viewLogIn.getPasswordTxt())) {							
	
				viewMainFrame.setUtenteLoggato(utente);
				checkUserConf(utente, viewMainFrame.getCtrPanel().getArrayLblButtons(), viewMainFrame.getCtrPanel());
				viewMainFrame.getSxPanel().getUserPanelCardLayout().show(viewMainFrame.getSxPanel().getUserCardPanel(), "2"); 
				viewMainFrame.getSxPanel().getUsernameLbl().setText(utente.getUsername());
				
			} else {
				
				viewLogIn.getPasswordFld().setBorder(new MatteBorder(1,1,1,1,Color.RED));
				viewLogIn.setPasswordTxtNull();
				throw new WrongPasswordException();
			}
			
		} else {
			
			viewLogIn.getUsernameEmailFld().setBorder(new MatteBorder(1,1,1,1,Color.RED));
			viewLogIn.setUsernameEmailTxtNull();
		    viewLogIn.setPasswordTxtNull();
		    throw new UserNotFoundException();
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
			
			ctrPanel.getCentrCardLayout().show(ctrPanel.getCentrCardPanel(),"3");
			
		} else { ctrPanel.getCentrCardLayout().show(ctrPanel.getCentrCardPanel(),"2"); }
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
			
			//to do exception
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
	
	
	private void addBtn(ArrayList<JLblButton> array, int n, JPanel panel, ProposteBacheca conf) {
		
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
	
	protected String addNomeFiltro(String queryIniziale, String queryTemi, String queryCollocazioni, String queryData, EastPanel dxPanel) {  
		  
		String q = addDataFiltro(queryIniziale, queryTemi, queryCollocazioni, queryData);
		
		if(q.equals("SELECT nome, tema FROM conferenze_scientifiche")) {	  
			  
			q += " WHERE nome ILIKE '%" + dxPanel.getResearchBar().getText() + "%';";
			  
		} else {
			
			q += ") AND nome ILIKE '%" + dxPanel.getResearchBar().getText() + "%';";  
		}
		
		return q;
	}
	
	protected String addDataFiltro(String queryIniziale, String queryTemi, String queryCollocazioni, String queryData) {
		
		String q = componiQuery(queryIniziale, queryTemi, queryCollocazioni);
		
		if(q.equals("SELECT nome, tema FROM conferenze_scientifiche") && !queryData.isEmpty()) {	  
			  
			q += " WHERE ("+ cutOR(queryData);
			  
		} else if (!queryData.isEmpty()) {
			
			q += ") AND ("+ cutOR(queryData);  
		} 
		
		return q;
	}
	
	
	private String componiQuery(String queryIniziale, String queryTemi, String queryCollocazioni) { 
		
		if (queryTemi.equals("") && queryCollocazioni.equals("")) { return queryIniziale; }
		
		else if(queryTemi.equals("")) { queryIniziale += " WHERE (" + cutOR(queryCollocazioni); } 
		  
		else if(queryCollocazioni.equals("")) { queryIniziale += " WHERE (" + cutOR(queryTemi); } 
		  
		else { queryIniziale += " WHERE ("+  cutOR(queryTemi) + ") AND (" + cutOR(queryCollocazioni); }
		
		return queryIniziale;
	}
	
	private String cutOR(String query) { return query.substring(0, query.length() - 4);	}
	
	
	
//_____________________________________________________________Controllo Bacheca
	
	public void addIdeaToBacheca(BachecaFrame viewBacheca) throws EmptyFieldException {
		
		if (viewBacheca.getNomeConfTxt().isEmpty() || viewBacheca.getDescrizioneConfTxt().isEmpty() || viewBacheca.getButtonGroup().getSelection().getActionCommand().isEmpty()) {
			
			throw new EmptyFieldException();
			
		} else {
			
			ProposteBacheca confBacheca = new ProposteBacheca();
			ProposteBachecaDAO confBachecaDAO = new ProposteBachecaDAO();
			String descrizione = aggiungiApostrofiSQL(viewBacheca.getDescrizioneConfTxt());
			
			confBacheca.setNome(viewBacheca.getNomeConfTxt());
			confBacheca.setDescrizione(descrizione);
			confBacheca.setTema(viewBacheca.getButtonGroup().getSelection().getActionCommand());
			confBachecaDAO.addConf(confBacheca);
		}
	}
	
	public void showLatestConfInBacheca(EastPanel dxPanel) {
		
		ProposteBachecaDAO confBachecaDAO = new ProposteBachecaDAO();

		int n = 0;
		
		for (ProposteBacheca cB : confBachecaDAO.getConferenzeBacheca()) {
			
			addConfBacheca(dxPanel.getArrayConfBacheca(), n, dxPanel.getBacheca(), cB);
			n ++;
		}
	}
	
	public void addConfBacheca(ArrayList<JLblButton> array, int n, JPanel bacheca, ProposteBacheca confB) {
		
		array.add(new JLblButton(c.lBlue, confB.getNome(), confB.getTema()));
		array.get(n).setFont(new Font("Calibri Light", Font.PLAIN, 17));
		array.get(n).setAlignmentX(Component.CENTER_ALIGNMENT);
		array.get(n).setBorder(new EmptyBorder(25, 0, 25, 0));
		bacheca.add(array.get(n));
	}
	
	public void setInfoConfBacheca(ConferenzaBachecaPanel cbPanel, String nome) {
		
		ProposteBachecaDAO confBachecaDAO = new ProposteBachecaDAO();
		ProposteBacheca confBacheca = new ProposteBacheca();
		confBacheca = confBachecaDAO.getConferenzaBacheca(nome);
		
		cbPanel.setNomeLbl(confBacheca.getNome());
		//cbPanel.setDescrizioneLbl(confBacheca.getDescrizione());
		cbPanel.setTemaLbl(confBacheca.getTema());
	}
	
	private String aggiungiApostrofiSQL(String stringa) {

        String stringaModificata = "";

        for(char c : stringa.toCharArray()) { 
            
        	if (c == '\'') { stringaModificata += c + "'"; }
        	
        	else { stringaModificata += c; }
        }
        
        return stringaModificata;
    }
	
//_____________________________________________________________Controllo Aggiunta Conferenza
	
	public void addInfoFld(int n, InfoFrame viewInfo) {
		
		for (int i = 0; i < n; i++) {
			
			viewInfo.getInfo().add(new JTextField());
			viewInfo.getInfo().get(i).setColumns(23);
			viewInfo.getInfo().get(i).setMinimumSize(new Dimension(10, 30));
			viewInfo.getInfo().get(i).setBorder(new MatteBorder(1,1,1,1, new Color(0,0,200)));
			viewInfo.getEntiConteiner().add(viewInfo.getInfo().get(i));
		}
	}
	
	public void addInfo(ArrayList<JTextField> a, ArrayList<String> b) {
		
		for (JTextField i : a) { b.add(i.getText()); }
	}
	
	public void preparaConferenza1(AggiuntaConfFrame1 viewAggiuntaConf) {    //cliccando conferma crea la stringa da eseguire alla fine

	      CollocazioneDAO collocazione = new CollocazioneDAO(); 
	      ConferenzaDAO conf = new ConferenzaDAO();
	      String insertConf = "'";

	      insertConf += viewAggiuntaConf.getNomeTxt() + "','";
	      insertConf += viewAggiuntaConf.getDataInizio() + "','";
	      insertConf += viewAggiuntaConf.getDataFine() + "','";
	      insertConf += viewAggiuntaConf.getDescrizioneTxt() + "','";
	      insertConf += viewAggiuntaConf.getButtonGroup().getSelection().getActionCommand() + "',";

	      collocazione.insertCollocazione(viewAggiuntaConf.getSedeTxt(), viewAggiuntaConf.getRegioneTxt());
	      insertConf += collocazione.getIdCollocazione(viewAggiuntaConf.getSedeTxt(), viewAggiuntaConf.getRegioneTxt());

	      conf.insertConferenza(insertConf);
	}
	
	public void inserisciEnte(AggiuntaConfFrame2 viewAggiuntaConf) {
		
		EnteDAO enteDAO = new EnteDAO();
		
		for (String e : viewAggiuntaConf.getEnti()) {
			
			enteDAO.insertEnte(e);
		}
	}
	
	public void inserisciSponsor(AggiuntaConfFrame2 viewAggiuntaConf) {
		
		SponsorDAO sponsorDAO = new SponsorDAO();
		
		for (String s : viewAggiuntaConf.getSponsor()) {
			
			sponsorDAO.insertSponsor(s);
		}
	}
	
	public void inserisciOrganizzatore(String query) {
		
		OrganizzatoreDAO organizzatoreDAO = new OrganizzatoreDAO();
		organizzatoreDAO.insertOrganizzatore(query.substring(0, query.length()-1));
	}
	
	public void inserisciAll(AggiuntaConfFrame1 viewAggiuntaConf, AggiuntaConfFrame2 viewAggiuntaConf2, String query) {
		
		inserisciEnte(viewAggiuntaConf2);
		
		inserisciSponsor(viewAggiuntaConf2);
		
		inserisciOrganizzatore(query);
	}
}    