package linker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.text.*;
import java.time.DateTimeException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;

import DAO.ProposteBachecaDAO;
import DAO.SessioneDAO;
import DAO.SponsorDAO;
import DAO.CollocazioneDAO;
import DAO.ConferenzaDAO;
import DAO.EnteDAO;
import DAO.InterventoDAO;
import DAO.KeynoteSpeakerDAO;
import DAO.OrganizzatoreDAO;
import DAO.PartecipanteDAO;
import DAO.UtenteDAO;
import DTO.Collocazione;
import DTO.Conferenza;
import DTO.Ente;
import DTO.Intervento;
import DTO.KeynoteSpeaker;
import DTO.Organizzatore;
import DTO.Partecipante;
import DTO.ProposteBacheca;
import DTO.Sessione;
import DTO.Sponsor;
import DTO.Utente;
import GUI.AfferenzeFrame;
import GUI.AfferenzePanel;
import GUI.BachecaFrame;
import GUI.EntiLbl;
import GUI.LogInFrame;
import GUI.SignUpFrame;
import GUI.AdminFrames.GestioneConfFrame;
import GUI.AdminFrames.AggiuntaConfFrame2;
import GUI.AdminFrames.InfoFrame;
import GUI.AdminFrames.ModSessioniPanel;
import GUI.ConferenzaFrame.ConferenzaFrame;
import GUI.ConferenzaFrame.DescrizioneTextPane;
import GUI.ConferenzaFrame.InfoInterventoLbl;
import GUI.ConferenzaFrame.InsertPswrdFrame;
import GUI.ConferenzaFrame.InterventoLbl;
import GUI.ConferenzaFrame.OrganizzatoreInfo;
import GUI.ConferenzaFrame.SessionePanel;
import GUI.ConferenzaFrame.InfoLbl;
import GUI.MainFrame.ConferenzaBachecaPanel;
import GUI.MainFrame.EastPanel;
import GUI.MainFrame.MainFrame;
import myException.DifferentPasswordException;
import myException.EmailAlreadyExistsException;
import myException.EmptyFieldException;
import myException.InvalidEmailFormatException;
import myException.ShortPswrdException;
import myException.UserNotFoundException;
import myException.WrongPasswordException;
import myTools.ConfBtn;
import myTools.JLblButton;
import myTools.myTemplates;

public class Controller {
	
	myTemplates c = new myTemplates();
	boolean aggiuntoFiltro = false;
	
	
//_____________________________________________________________Controllo Sign-Up
	
	protected void controlloSignUp(SignUpFrame viewSignUp, MainFrame viewMainFrame) throws EmptyFieldException, DifferentPasswordException, ShortPswrdException, InvalidEmailFormatException, EmailAlreadyExistsException {
		
		if (viewSignUp.FieldAreEmpty()) {
			
			throw new EmptyFieldException();
			
		} else if (!viewSignUp.getEmail().matches("[A-z0-9._-]+@[A-z]+\\.[a-z]+")) {
			
			viewSignUp.setEmailError();
			throw new InvalidEmailFormatException();
			
		} else if (viewSignUp.getPassword().length() < 5) {
			
			viewSignUp.setPasswordError();
			throw new ShortPswrdException();
			
		} else if (!viewSignUp.getPassword().equals(viewSignUp.getCnfrmPassword())) {
			
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
		
		if (!utenteDAO.checkEmail(viewSignUp.getEmail())) {
			
			viewSignUp.setEmailError();
			throw new EmailAlreadyExistsException();
			
		} else {
			
			utente.setEmail(viewSignUp.getEmail());
	    	utente.setUsername(viewSignUp.getUsername());
	    	utente.setPassword_user(viewSignUp.getPassword());
	    	
	    	viewMainFrame.setUtenteLoggato(utente);
	    	viewMainFrame.getSxPanel().getUsernameLbl().setText(utente.getUsername());
	    	utenteDAO.registrazione(utente);
		}
	}
	
	
	
	
//_____________________________________________________________Controllo Log-In 
	
	protected ArrayList<Conferenza> controlloLogIn(LogInFrame viewLogIn, MainFrame viewMainFrame) throws UserNotFoundException, WrongPasswordException {
    	
        UtenteDAO utenteDAO = new UtenteDAO();
        Utente utente = new Utente();
        utente =  utenteDAO.getUtente(viewLogIn.getUsernameEmail());
        
        
		if(utente.getEmail() != null) {	
			
			if(viewLogIn.getPassword().equals(utenteDAO.checkPassword(utente))) {							
	
				viewMainFrame.setUtenteLoggato(utente);
				viewMainFrame.getSxPanel().getUserPanelCardLayout().show(viewMainFrame.getSxPanel().getUserCardPanel(), "2"); 
				viewMainFrame.getSxPanel().getUsernameLbl().setText(utente.getUsername());
				ConferenzaDAO confDAO = new ConferenzaDAO();
				return confDAO.getConferenzeUtente(utente.getEmail());
				
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
	
	
//_____________________________________________________________Aggiunta Info al Frame Conferenze
	
	protected void addInfoConferenze(Utente utente, String idConferenza, ConferenzaFrame viewConferenza) {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		Conferenza conf = new Conferenza();
		conf = confDAO.getConferenza(idConferenza);		

		if (confDAO.checkIscrizione(utente.getEmail(), conf.getId().toString())) {
			viewConferenza.getIscrizioneCardLayout().show(viewConferenza.getIscrizioneCardPanel(), "2");
		}
		
		viewConferenza.setId(conf.getId().toString());
        viewConferenza.setNome(conf.getNome());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        viewConferenza.setDataInizio(dateFormat.format(conf.getDataInizio().getTime()));
        viewConferenza.setDataFine(dateFormat.format(conf.getDataFine().getTime()));
                
        viewConferenza.setDescrizione(conf.getDescrizione());
        viewConferenza.setTema(conf.getTema());
        
        addOtherInfo(viewConferenza);
	}
	
	private void addOtherInfo(ConferenzaFrame viewConferenza) {
		
		EnteDAO enteDAO = new EnteDAO();
		SponsorDAO sponsorDAO = new SponsorDAO();
		OrganizzatoreDAO organizzatoreDAO = new OrganizzatoreDAO();
		
		for (Ente e : enteDAO.getEnti(1000)) {
			
			viewConferenza.getEntiConteiner().add(new InfoLbl(e.getNome(), ""));
		}
		
		for (Sponsor s : sponsorDAO.getSponsor(1000)) {
			
			viewConferenza.getSponsorConteiner().add(new InfoLbl(s.getNome(), ""));
		}
		
		for (Organizzatore o : organizzatoreDAO.getOrganizzatori(1000)) {
			
			viewConferenza.getOrganizzatoriConteiner().add(new InfoLbl(o.getNome() + " " + o.getCognome(), o.getEmail()));
		}	
	}
	
	public void addOrganizzatoreInfo(OrganizzatoreInfo organizzatoreInfo, String idOrganizzatore) {
		
		OrganizzatoreDAO organizzatoreDAO = new OrganizzatoreDAO();
		Organizzatore organizzatore = organizzatoreDAO.getOrganizzatore(idOrganizzatore);
		
		organizzatoreInfo.setAfferenza(organizzatore.getAfferenza());
		organizzatoreInfo.setEmail(organizzatore.getEmail());
	}

	public boolean addSessioneInfo(int currentSession, SessionePanel sessionePanel) {
		
		SessioneDAO sessioneDAO = new SessioneDAO();
		ArrayList<Sessione> sessioni = sessioneDAO.getSessioni(1000);
		SimpleDateFormat DateTimeFormat = new SimpleDateFormat("dd/MM/YY hh:mm");
		
		sessionePanel.setDataOraInizio(DateTimeFormat.format(sessioni.get(currentSession).getDataOraInizio().getTime()));
		sessionePanel.setDataOraFine(DateTimeFormat.format(sessioni.get(currentSession).getDataOraFine().getTime()));
		sessionePanel.setKeynoteSpeaker(sessioni.get(currentSession).getKeynoteSpeaker());
		sessionePanel.setCoordinatore(sessioni.get(currentSession).getCoordinatore());
		addInterventi(sessioni.get(currentSession).getId(), sessionePanel);
		
		if (sessioni.size() >= currentSession + 3) { return false; }
		
		else { return true; }
	}
	

	public boolean addModSessioneInfo(int currentSession, ModSessioniPanel sessionePanel) {
		
		SessioneDAO sessioneDAO = new SessioneDAO();
		ArrayList<Sessione> sessioni = sessioneDAO.getSessioni(1000);
		SimpleDateFormat DateTimeFormat = new SimpleDateFormat("dd/MM/YY hh:mm");
		
		sessionePanel.setDataOraInizio(DateTimeFormat.format(sessioni.get(currentSession).getDataOraInizio().getTime()));
		sessionePanel.setDataOraFine(DateTimeFormat.format(sessioni.get(currentSession).getDataOraFine().getTime()));
		sessionePanel.setKeynoteSpeaker(sessioni.get(currentSession).getKeynoteSpeaker());
		sessionePanel.setCoordinatore(sessioni.get(currentSession).getCoordinatore());
		//addInterventi(sessioni.get(currentSession).getId(), sessionePanel);
		
		if (sessioni.size() >= currentSession + 3) { return false; }
		
		else { return true; }
	}
	
	public void addPartecipanteInfo(OrganizzatoreInfo organizzatoreInfo, String idOrganizzatore) {
		
		PartecipanteDAO partecipanteDAO = new PartecipanteDAO();
		Partecipante partecipante = partecipanteDAO.getPartecipante(idOrganizzatore);
		
		organizzatoreInfo.setAfferenza(partecipante.getAfferenza());
		organizzatoreInfo.setEmail(partecipante.getEmail());
	}
	
	
	public void addInterventi(String sessione, SessionePanel sessionePanel) {
		
		InterventoDAO interventoDAO = new InterventoDAO();
		PartecipanteDAO partecipanteDAO = new PartecipanteDAO();
		SimpleDateFormat TimeFormat = new SimpleDateFormat("hh:mm");
		int n = 1;
		
		for (Intervento i : interventoDAO.getInterventi(sessione)) {
			
			sessionePanel.getInterventiPanel().add(new InterventoLbl("Intervento " + n));
			sessionePanel.getInterventiPanel().add(new InfoInterventoLbl(TimeFormat.format(i.getOrainizio().getTime()) + " - " + TimeFormat.format(i.getOrafine().getTime()), ""));
			
			for (Partecipante p : partecipanteDAO.getPartecipanti(i.getIdIntervento())) {
				sessionePanel.getInterventiPanel().add(new InfoInterventoLbl(p.getNome() + " " + p.getCognome(), p.getEmail()));
			}
			
			n ++;
			sessionePanel.getInterventiPanel().add(new DescrizioneTextPane(i.getDescrizione()));
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
	
	
	
	
//_____________________________________________________________Svuota TextField
	
	public void setTextNull(JTextComponent txtCom, int grandezzaFont) {
		
		txtCom.setText("");
		txtCom.setFont(c.myFont(grandezzaFont));
		txtCom.setForeground(c.tangaroa);
	}
	
	
	protected String addNomeFiltro(String queryIniziale, String queryTemi, String queryCollocazioni, String queryData, EastPanel dxPanel) {  
		  
		String q = addDataFiltro(queryIniziale, queryTemi, queryCollocazioni, queryData);
		
		if(q.equals("SELECT * FROM conferenze_scientifiche")) {	  
			  
			q += " WHERE nome ILIKE '%" + dxPanel.getResearchBar().getText() + "%';";
			  
		} else {
			
			q += ") AND nome ILIKE '%" + dxPanel.getResearchBar().getText() + "%';";  
		}
		
		return q;
	}
	
	protected String addDataFiltro(String queryIniziale, String queryTemi, String queryCollocazioni, String queryData) {
		
		String q = componiQuery(queryIniziale, queryTemi, queryCollocazioni);
		
		if(q.equals("SELECT * FROM conferenze_scientifiche") && !queryData.isEmpty()) {	  
			  
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
		cbPanel.setDescrizioneLbl(confBacheca.getDescrizione());
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
	
	public void addInfo(ArrayList<JTextField> arrayTxtFld, ArrayList<String> arrayInfo) {
		
		for (JTextField t : arrayTxtFld) { arrayInfo.add(t.getText()); }
	}
	
	public String preparaConferenza(GestioneConfFrame viewAggiuntaConf, String query) {    

		query += viewAggiuntaConf.getNomeTxt() + "', '";
		query += viewAggiuntaConf.getDataInizio() + "', '";
		query += viewAggiuntaConf.getDataFine() + "', '";
		query += viewAggiuntaConf.getDescrizioneTxt() + "', '";
		query += viewAggiuntaConf.getButtonGroup().getSelection().getActionCommand() + "', '";
		
		return query;
	}
	
	public void inserisciCollocazione(GestioneConfFrame viewAggiuntaConf, String insertConf) {
		
		CollocazioneDAO collocazione = new CollocazioneDAO();
		collocazione.insertCollocazione(viewAggiuntaConf.getSedeTxt(), viewAggiuntaConf.getRegioneTxt());
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
		organizzatoreDAO.insertOrganizzatore(query.substring(0, query.length()-2));
	}
	
	public void inserisciConferenza(GestioneConfFrame viewAggiuntaConf, String query) {
		
		ConferenzaDAO conferenzaDAO = new ConferenzaDAO();
		CollocazioneDAO collocazioneDAO = new CollocazioneDAO();
		query += collocazioneDAO.getIdCollocazione(viewAggiuntaConf.getSedeTxt(), viewAggiuntaConf.getRegioneTxt());
		conferenzaDAO.insertConferenza(query);
	}
	
	public void inserisciSessioni(String query) {
		
		SessioneDAO sessioneDAO = new SessioneDAO();
		sessioneDAO.insertSessione(query.substring(0, query.length()-2));
	}
	
	
	
	
//_____________________________________________________________Controllo Modifica Conferenza	
	
    protected void setInfoInUpdateConf(String idConferenza, GestioneConfFrame viewGestioneConf) {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		Conferenza conf = new Conferenza();
		CollocazioneDAO collDAO = new CollocazioneDAO();
		Collocazione coll = new Collocazione();
		conf = confDAO.getConferenza(idConferenza);	
		coll = collDAO.getCollocazione(conf.getId());
		
		//viewGestioneConf.getAddConfLbl().setText("Modifica " + conf.getNome());

		viewGestioneConf.setNome(conf.getNome());
        
		setDate(viewGestioneConf, conf);
                
        viewGestioneConf.setDescrizione(conf.getDescrizione());
        
        viewGestioneConf.setSede(coll.getSede());
        
        viewGestioneConf.setRegione(coll.getRegione());
        
        setTema(viewGestioneConf, conf);
    }
    
    private void setDate(GestioneConfFrame viewUpdateConf, Conferenza conf) {
    	
    	viewUpdateConf.getDataInizioCB().setDay(conf.getDataInizio().get(Calendar.DATE));
		viewUpdateConf.getDataInizioCB().setMonth(conf.getDataInizio().get(Calendar.MONTH));
		viewUpdateConf.getDataInizioCB().setYear(conf.getDataInizio().get(Calendar.YEAR));
		
		viewUpdateConf.getDataFineCB().setDay(conf.getDataFine().get(Calendar.DATE));
		viewUpdateConf.getDataFineCB().setMonth(conf.getDataFine().get(Calendar.MONTH));
		viewUpdateConf.getDataFineCB().setYear(conf.getDataFine().get(Calendar.YEAR));
    }
    
    private void setTema(GestioneConfFrame viewUpdateConf, Conferenza conf) {
    	
    	Enumeration<AbstractButton> pulsanti = viewUpdateConf.getButtonGroup().getElements();
    	
        while (pulsanti.hasMoreElements()) {
        	
        	AbstractButton myPulsante = pulsanti.nextElement();
        	
        	if (myPulsante.getText().equals(conf.getTema())) { 
        		
        		myPulsante.setSelected(true);
        		break;
        	}
        }
    }
    
    public void checkCorrectDate(Calendar DataInizio, Calendar DataFine) throws DateTimeException{
    	
    	Calendar DataAttuale = Calendar.getInstance();

        if(DataInizio.compareTo(DataFine) > 0) {
        	
        	throw new DateTimeException("La data di fine è più piccola della data di inizio");
               
        } else if (DataInizio.compareTo(DataAttuale) < 0) {
        	
            throw new DateTimeException("La data di inizio è già passata");
        } 
    }
    
    
    
    
    public void fooo(AfferenzePanel afferenzePanel, int month, int year) {
    	
    	KeynoteSpeakerDAO keynoteSpeakerDAO = new KeynoteSpeakerDAO();
    	int totaleEnti = 0;
    	ArrayList<Integer> nOccorrenzeEnti = new ArrayList<Integer>();
    	ArrayList<String> nomeEnti = new ArrayList<String>();
    	Integer percentuale = 0;
    	int n = 0;
    	
    	for (Ente e : keynoteSpeakerDAO.getAfferenzeByMonth(month, year)) {
    		
			totaleEnti += e.getnOccorrenze();
			nOccorrenzeEnti.add(e.getnOccorrenze());
			nomeEnti.add(e.getNome());
		}
    	
    	for (Integer p : nOccorrenzeEnti) {
    		
    		percentuale = (p * 100) / totaleEnti;
    		afferenzePanel.getPercentualiAfferenze().add(new EntiLbl(percentuale.toString() + "% - " + nomeEnti.get(n) + " (" + p + ")", 16));
    		afferenzePanel.addValue(nomeEnti.get(n), percentuale);
    		n++;
		}
    }
    
    public void fooo2(AfferenzePanel afferenzePanel, int year) {
    	
    	KeynoteSpeakerDAO keynoteSpeakerDAO = new KeynoteSpeakerDAO();
    	int totaleEnti = 0;
    	ArrayList<Integer> nOccorrenzeEnti = new ArrayList<Integer>();
    	ArrayList<String> nomeEnti = new ArrayList<String>();
    	Integer percentuale = 0;
    	int n = 0;
    	
    	for (Ente e : keynoteSpeakerDAO.getAfferenzeByYear(year)) {
    		
			totaleEnti += e.getnOccorrenze();
			nOccorrenzeEnti.add(e.getnOccorrenze());
			nomeEnti.add(e.getNome());
		}
    	
    	for (Integer p : nOccorrenzeEnti) {
    		
    		percentuale = (p * 100) / totaleEnti;
    		afferenzePanel.getPercentualiAfferenze().add(new EntiLbl(percentuale.toString() + "% - " + nomeEnti.get(n) + " (" + p + ")", 20));
    		afferenzePanel.addValue(nomeEnti.get(n), percentuale);
    		n++;
		}
    }
}    