package linker;

import DAO.*;
import DTO.*;
import GUI.*;
import GUI.AdminFrames.*;
import GUI.CalendarFrame.*;
import GUI.ConferenzaFrame.*;
import GUI.FilterFrame.*;
import GUI.MainFrame.*;
import myException.*;
import myTools.*;
import myTools.PanelSlide.AnimateType;

import java.awt.Color;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class Controller {
	
	private myTemplates t = new myTemplates();
	
	
	private ConferenzaDAO conferenzaDAO;
    private Conferenza conferenza;
    private SessioneDAO sessioneDAO;
    private Sessione sessione;
    private KeynoteSpeakerDAO keynoteSpeakerDAO;
    private InterventoDAO interventoDAO;
    private PartecipanteDAO partecipanteDAO;
    private Partecipante partecipante;
    
	private CollocazioneDAO collocazioneDAO;
    private EnteDAO enteDAO;
    private SponsorDAO sponsorDAO;
    private OrganizzatoreDAO organizzatoreDAO;
    private Organizzatore organizzatore;
    
    private ProposteBachecaDAO proposteBachecaDAO;
    private ProposteBacheca proposteBacheca;
    
    private UtenteDAO utenteDAO;
    private Utente utente;
    
    private TOKEN token;
	
	
    private MainFrame ViewMain;
	private LogInFrame ViewLogIn; 
	private SignUpFrame ViewSignUp;
	
	private CalendarMainFrame ViewCalendario;
	
	private BachecaFrame ViewBacheca;
	
	private FilterFrame ViewFiltri;
	private RisultatiRicercaFrame ViewRisultati;
	private AfferenzeFrame ViewAfferenze;
	
	private ConferenzaFrame ViewConferenza;
	private InsertPswrdFrame ViewInsertPswrd;
	
	private GestioneConfFrame ViewGestioneConf;
	private AggiuntaConfFrame2 ViewAggiuntaConf2;
	private ModificaFrame2 ViewModifica;
	private SessioneDialog ViewSessioni;
	private KeynoteDialog ViewKeynote;
	private InterventiDialog ViewInterventi;
	private PartecipanteDialog ViewPartecipante;
	private InfoDialog ViewInfo;
	private OrganizzatoreDialog ViewOrganizzatori;
	
	
	String queryIniziale = "SELECT * FROM conferenze_scientifiche";
	String queryTemi = "";
	String queryCollocazioni = "";
	String queryData = "";
	
    
	public static void main(String[] args) {
		FlatIntelliJLaf.setup();
		
		Controller controller = new Controller();
	}
	
	public Controller() {
		
		initDAO();
		ViewCalendario = new CalendarMainFrame("", this);
		ViewMain = new MainFrame("Sci-Conference", this);
	}
	
	private void initDAO() {
		
		conferenzaDAO = new ConferenzaDAO();
		sessioneDAO = new SessioneDAO();
		keynoteSpeakerDAO = new KeynoteSpeakerDAO();
		interventoDAO = new InterventoDAO();
		partecipanteDAO = new PartecipanteDAO();
		collocazioneDAO = new CollocazioneDAO();
        enteDAO = new EnteDAO();
        sponsorDAO = new SponsorDAO();
        organizzatoreDAO = new OrganizzatoreDAO();
        proposteBachecaDAO = new ProposteBachecaDAO();
        utenteDAO = new UtenteDAO();
        token = new TOKEN();
    }
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//												Controllo MainFrame
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	
	public void addConfToCalendarPanel(WestPanel sxPanel) {
		
		for (Conferenza c : conferenzaDAO.getConferenze()) {
			
			switch (c.getDataInizio().get(Calendar.MONTH)) {
        	
			case 3:
				sxPanel.getConferenzeMese1().add(new SxConfBtn(this, c.getNome(), c.getTema(), c.getId().toString()));
        		break;
        		
			case 4:
				sxPanel.getConferenzeMese2().add(new SxConfBtn(this, c.getNome(), c.getTema(), c.getId().toString()));
				break;
			}
		} 	
	}
	
	
	public void addConfToBacheca(EastPanel dxPanel) {
		
		for (ProposteBacheca pb : proposteBachecaDAO.getConferenzeBacheca()) {
			
			dxPanel.getBacheca().add(new PropostaBachecaBtn(this, pb.getNome(), pb.getTema()));
		}
	}
	
	public void setInfoConfBacheca(ConferenzaBachecaPanel cbPanel, String nome) {
		
		proposteBacheca = proposteBachecaDAO.getConferenzaBacheca(nome);
		
		cbPanel.setNomeLbl(proposteBacheca.getNome());
		cbPanel.setDescrizioneLbl(proposteBacheca.getDescrizione());
		cbPanel.setTemaLbl(proposteBacheca.getTema());
	}
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//											   Controllo SignUp
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	
	public void goToSignUp() {
		
		ViewMain.dispose();
		
		ViewSignUp = new SignUpFrame("Sci-Conference", this);
        ViewSignUp.setVisible(true);
	}
	
	public void backFromSignUp() {
		
		ViewSignUp.dispose();
		ViewMain.setVisible(true);
	}
	
	public void fromSignUpToLogIn() {
		
		ViewSignUp.dispose();
		
		ViewLogIn = new LogInFrame("Sci-Conference", this);
		ViewLogIn.setVisible(true);
	}
	
	
	public void confermaSignUp() {
			
		try {
				
			controlloSignUp();
				
			ViewSignUp.dispose();
			ViewMain.setVisible(true);
			JOptionPane.showMessageDialog(ViewMain, "Registrazione effettuata!");
				
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
		
		
	private void controlloSignUp() throws EmptyFieldException, DifferentPasswordException, 
										  ShortPswrdException, InvalidEmailFormatException, EmailAlreadyExistsException {
			
		if (ViewSignUp.FieldsAreEmpty()) {
				
			throw new EmptyFieldException();
				
		} else if (!ViewSignUp.getEmail().matches("[A-z0-9._-]+@[A-z]+\\.[a-z]+")) {
				
			ViewSignUp.setEmailError();
			throw new InvalidEmailFormatException();
				
		} else if (ViewSignUp.getPassword().length() < 5) {
				
			ViewSignUp.setPasswordError();
			throw new ShortPswrdException();
				
		} else if (!ViewSignUp.getPassword().equals(ViewSignUp.getCnfrmPassword())) {
				
			ViewSignUp.setPasswordError();
	        throw new DifferentPasswordException();   	
		            
		} else { 
		        	
			registraUtente();
	        	
	        ViewMain.getSxPanel().showAfterAccessLayer();
	        ViewMain.getCtrPanel().showLayer("No Conf");
		}
	}
		
		
	private void registraUtente() throws EmailAlreadyExistsException {
			
		if (!utenteDAO.checkEmail(ViewSignUp.getEmail())) {
				
			ViewSignUp.setEmailError();
			throw new EmailAlreadyExistsException();
				
		} else {
				
			utente.setEmail(ViewSignUp.getEmail());
		    utente.setUsername(ViewSignUp.getUsername());
		    utente.setPassword_user(ViewSignUp.getPassword());
		    	
		    ViewMain.setUtenteLoggato(utente);
		    ViewMain.getSxPanel().getUsernameLbl().setText(utente.getUsername());
		    utenteDAO.registrazione(utente);
		}
	}
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//												Controllo LogIn
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	
	public void goToLogIn() {
		
		ViewMain.dispose();
		
		ViewLogIn = new LogInFrame("Sci-Conference", this);
		ViewLogIn.getPasswordFld().setText("123!BFO€8A$B124N");
		ViewLogIn.setVisible(true);
	}
	
	public void backFromLogIn() {
		
		ViewLogIn.dispose();
		ViewMain.setVisible(true);
	}
	
	public void fromLogInToSignUp() {
		
		ViewLogIn.dispose();
		
		ViewSignUp = new SignUpFrame("Sci-Conference", this);
		ViewSignUp.setVisible(true);
	}
	
	
	public void confermaLogIn() {
		
        if(token.checkTOKEN(ViewLogIn.getPassword())) {
           
        	ViewLogIn.dispose();
        	ViewMain.getCtrPanel().getCentrLbl().setText("Gestione conferenze");
        	ViewMain.getCtrPanel().showLayer("Admin");
            ViewMain.setVisible(true);
        
        } else {
		
			try {
				
				controlloLogIn();
				
				ViewLogIn.dispose();
				ViewMain.setVisible(true);
				JOptionPane.showMessageDialog(ViewMain, "Log-In avvenuto con successo!\nBenvenuto!");
				
			} catch (WrongPasswordException wpe) {
				
				System.out.println(wpe);
				JOptionPane.showMessageDialog(ViewLogIn, wpe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
				
			} catch (UserNotFoundException unfe) {
				
				System.out.println(unfe);
				JOptionPane.showMessageDialog(ViewLogIn, unfe.getMessage(), "Dati incorretti",JOptionPane.ERROR_MESSAGE);
			}
        }
	}
	
	
	private void controlloLogIn() throws UserNotFoundException, WrongPasswordException {
    	
        utente = utenteDAO.getUtente(ViewLogIn.getUsernameEmail());
        
		if(utente.getEmail() != null) {	
			
			if(ViewLogIn.getPassword().equals(utenteDAO.checkPassword(utente))) {							
	
				ViewMain.setUtenteLoggato(utente);
				ViewMain.getSxPanel().showAfterAccessLayer();
				ViewMain.getSxPanel().getUsernameLbl().setText(utente.getUsername());
				addConfUtente(conferenzaDAO.getConferenzeUtente(utente.getEmail())); 
				
			} else {
				
				ViewLogIn.getPasswordFld().setBorder(new MatteBorder(1, 1, 1, 1, t.red));
				ViewLogIn.setPasswordTxtNull();
				throw new WrongPasswordException();
			}
			
		} else {
			
			ViewLogIn.getUsernameEmailFld().setBorder(new MatteBorder(1, 1, 1, 1, t.red));
			ViewLogIn.setUsernameEmailTxtNull();
		    ViewLogIn.setPasswordTxtNull();
		    throw new UserNotFoundException();
		}
    }
	
	
	private void addConfUtente(ArrayList<Conferenza> conferenzeUtente) {
		
		if(conferenzeUtente.isEmpty()) { 
			
			ViewMain.getCtrPanel().showLayer("No Conf");
			
		} else { 
			
//			for (Conferenza c : conferenzeUtente) {
//				ViewMainFrame.getCtrPanel().getUserConfAfterAc
//			}
		
			ViewMain.getCtrPanel().showLayer("User Conf");
		}	
	}
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//	   											Controllo Calendario
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToCalendario() { ViewCalendario.setVisible(true); }
	
	
	public void setDate(ArrayList<CalendarCell> arrCells, Calendar DataPannello) {
		
		int StartDay = DataPannello.get(Calendar.DAY_OF_WEEK) - 2;
		
		DataPannello.add(Calendar.DATE, - StartDay);
		
		for (CalendarCell c : arrCells) {
			
			c.setText(DataPannello.get(Calendar.DATE) + "");
			//c.currentMonth(DataPannello.get(Calendar.MONTH) == Month - 1);
			
			conferenza = conferenzaDAO.getConferenzaByDate(t.toDateFormat(DataPannello.getTime()));
			c.containsConf(conferenza.getNome());

			DataPannello.add(Calendar.DATE, 1);			
		}
	}
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//		 									    Controllo Afferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	
	public void goToAfferenze() {
		
		ViewMain.setVisible(false);
		ViewAfferenze = new AfferenzeFrame("", this);
		ViewAfferenze.setVisible(true);
	}
	
	public void backFromAfferenze() {
		
		ViewAfferenze.dispose();
		ViewMain.setVisible(true);
	}
	
	public void addPercentualiAfferenze(AfferenzePanel afferenzePanel, int month, int year) {
    	
    	for (Ente e : keynoteSpeakerDAO.getAfferenze(month, year)) {
    		
    		int percentuale = (e.getOccorrenze() * 100) / Ente.getTotaleEnti();
    		afferenzePanel.getPercentualiAfferenze().add(new EntiLbl(percentuale +"% - "+ e.getNome() +" ("+ e.getOccorrenze()));
    		afferenzePanel.addValue(e.getNome(), percentuale);
		}
    }
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//	   											 Controllo Ricerca
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
    
	public void goToFiltri() {
		
		ViewFiltri = new FilterFrame("", this);
		Point MouseCoordnt = MouseInfo.getPointerInfo().getLocation();
		ViewFiltri.setLocation(MouseCoordnt.x - 20, MouseCoordnt.y + 25);
		ViewFiltri.setVisible(true);
		
		resetQueryFiltri();
	}
	
	public void backFromFiltri() { ViewMain.getDxPanel().getFilterBtn().setEnabled(true); }
	
	
    public void goToRisultati() {
		
		ViewRisultati = new RisultatiRicercaFrame("Sci-Conference", this);
		
		componiQuery();
		
		for (Conferenza c : conferenzaDAO.getConferenzeRicerca(ViewMain.getDxPanel().getResearchBar().getText(), queryTemi, queryCollocazioni)) {
			
			ViewRisultati.getRisultatiPanel().add(new ConfBtn(this, c.getNome(), c.getTema(), c.getId()));
		}
		
		ViewRisultati.showLayer("Results Scroller");
		
		ViewMain.setVisible(false);
		ViewRisultati.setVisible(true);
	}
	
    public void backFromRisultati() {
		
		ViewRisultati.dispose();
		ViewMain.setVisible(true);
	}
	
	
	private void componiQuery() {
		
		if (queryTemi.equals("")) { queryTemi = "NULL"; } 
		
		else { queryTemi = "ARRAY[" + cut2(queryTemi) + "]"; }
		
		
		if (queryCollocazioni.equals("")) { queryCollocazioni = "NULL"; }
		
		else { queryCollocazioni = "ARRAY[" + cut2(queryCollocazioni) + "]"; }
	}
	
	
	public void addDataLbl(String filtro) {
		
		ViewMain.getDxPanel().getClearFltrBtn().setVisible(true);
		ViewMain.getDxPanel().addDateLbl(filtro);
	}
	
	public void addLuogoToLbl(String filtro) {
		
		ViewMain.getDxPanel().getClearFltrBtn().setVisible(true);
		ViewMain.getDxPanel().addPlacesLbl(filtro);
	}
	
	public void addTemaToLbl(String filtro) {
		
		ViewMain.getDxPanel().getClearFltrBtn().setVisible(true);
		ViewMain.getDxPanel().addTopicsLbl(filtro);
	}
	
	
	public void addQueryData(String q) { queryData += q; };
	
	public void addQueryTemi(String q) { queryTemi += q; }

	public void addQueryCollocazioni(String q) { queryCollocazioni += q; }
	
	public void resetQueryFiltri() { queryTemi = ""; queryCollocazioni = ""; queryData = ""; }
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//	   											  Controllo Conferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	
	public void goToConferenza(String idConferenza) {
		 
		ViewConferenza = new ConferenzaFrame(idConferenza, "Sci-Conference", this);
		
		if (ViewMain.isVisible()) { 
			
			ViewMain.setVisible(false); 
			ViewCalendario.setVisible(false);
			ViewConferenza.setFramePrecedente("MainFrame");
		}
		
		else { ViewRisultati.setVisible(false); }
	        
	    addInfoConferenze(ViewMain.getUtenteLoggato(), idConferenza);
	    
	    setTopicColor(ViewConferenza.getTemaLbl().getText(), ViewConferenza.getNomeLbl());
        setTopicColor(ViewConferenza.getTemaLbl().getText(), ViewConferenza.getTemaLbl());
	    ViewConferenza.foo();
	    ViewConferenza.setVisible(true);
	}
		
	public void backFromConferenza(String framePrecedente) {
			
		if(framePrecedente.equals("MainFrame")) { ViewMain.setVisible(true); }
		
		else { ViewRisultati.setVisible(true); }
		
	    ViewConferenza.setVisible(false);
	}
	
	
	private void addInfoConferenze(Utente utente, String idConferenza) {
		
		conferenza = conferenzaDAO.getConferenza(idConferenza);		

		if (conferenzaDAO.checkIscrizione(utente.getEmail(), conferenza.getId().toString())) {
			ViewConferenza.showLayer("GiàIscritto");
		}

        ViewConferenza.setNome(conferenza.getNome());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        ViewConferenza.setDataInizio(dateFormat.format(conferenza.getDataInizio().getTime()));
        ViewConferenza.setDataFine(dateFormat.format(conferenza.getDataFine().getTime()));
                
        ViewConferenza.setDescrizione(conferenza.getDescrizione());
        ViewConferenza.setTema(conferenza.getTema());
        
        addOtherInfo(idConferenza);
	}
	
	private void addOtherInfo(String idConferenza) {
		
		for (Ente e : enteDAO.getEnti(idConferenza)) {
			
			ViewConferenza.getEntiConteiner().add(new InfoLbl(e.getNome(), ""));
		}
		
		for (Sponsor s : sponsorDAO.getSponsor(idConferenza)) {
			
			ViewConferenza.getSponsorConteiner().add(new InfoLbl(s.getNome(), ""));
		}
		
		for (Organizzatore o : organizzatoreDAO.getOrganizzatori(idConferenza)) {
			
			ViewConferenza.getOrganizzatoriConteiner().add(new InfoLbl(o.getNome() + " " + o.getCognome(), o.getEmail()));
		}	
	}
	
	public void addOrganizzatoreInfo(OrganizzatoreInfo organizzatoreInfo, String idOrganizzatore) {
		
		organizzatore = organizzatoreDAO.getOrganizzatore(idOrganizzatore);
		
		organizzatoreInfo.setAfferenza(organizzatore.getAfferenza());
		organizzatoreInfo.setEmail(organizzatore.getEmail());
	}
	
	
	public void addSessioniPanel(String idConferenza, ArrayList<SessionePanel> sessioniPanels) {
		
		for (Sessione s : sessioneDAO.getSessioni(idConferenza)) {
			
			sessioniPanels.add(new SessionePanel(s.getId(), this, "ConferenzaFrame"));
		}
	}

	public void addSessioneInfo(String idSessione, SessionePanel sessionePanel) {
		
		sessione = sessioneDAO.getSessione(idSessione);
		
		sessionePanel.setDataOraInizio(t.toDateTimeFormat(sessione.getDataInizio().getTime()));
		sessionePanel.setDataOraFine(t.toDateTimeFormat(sessione.getDataFine().getTime()));
		sessionePanel.setKeynoteSpeaker(sessione.getKeynoteSpeaker());
		sessionePanel.setCoordinatore(sessione.getCoordinatore());
		addInterventi(sessione.getId(), sessionePanel);
	}
	
	
	public void addInterventi(String sessione, SessionePanel sessionePanel) {
		
		int n = 1;
		
		for (Intervento i : interventoDAO.getInterventi(sessione)) {
			
			sessionePanel.getInterventiPanel().add(new InterventoLbl("Intervento " + n));
			sessionePanel.getInterventiPanel().add(new InfoInterventoLbl(t.toTimeFormat(i.getOrainizio().getTime()) + " - " + t.toTimeFormat(i.getOrafine().getTime()), ""));
			
			for (Partecipante p : partecipanteDAO.getPartecipanti(i.getIdIntervento())) {
				sessionePanel.getInterventiPanel().add(new InfoInterventoLbl(p.getNome() + " " + p.getCognome(), p.getEmail()));
			}
			
			n ++;
			sessionePanel.getInterventiPanel().add(new DescrizioneTextPane(i.getDescrizione()));
		}		
	}
	
	public void addPartecipanteInfo(OrganizzatoreInfo organizzatoreInfo, String idOrganizzatore) {
		
		partecipante = partecipanteDAO.getPartecipante(idOrganizzatore);
		
		organizzatoreInfo.setAfferenza(partecipante.getAfferenza());
		organizzatoreInfo.setEmail(partecipante.getEmail());
	}
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//		  										Controllo Iscrizione
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	
	public void goToIscrizione() {
		
		if (ViewMain.getUtenteLoggato().getEmail() != null) {
			
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
		
		conferenza = conferenzaDAO.getConferenza(ViewConferenza.getId());
		
		if (iscrizione(ViewMain.getUtenteLoggato(), conferenza)) {
			
			ViewInsertPswrd.dispose();
			ViewConferenza.dispose();
			
			//ViewMain.getCtrPanel().getUserConfAfterAccess2().add(new UserConfBtn(this, conf.getNome(), conf.getTema(), conf.getId().toString()));
			ViewMain.setVisible(true);
			JOptionPane.showMessageDialog(ViewMain,"Iscrizione Effettuata!");
		}
	}
	
	private boolean iscrizione(Utente utente, Conferenza conf) {
		
		if (ViewInsertPswrd.getPasswordFld().getText().equals(utente.getPassword_user())) {
			
			utenteDAO.iscrizione(utente.getEmail(), conf.getId());
			return true;
			
		} else {
			
			//to do exception
			ViewInsertPswrd.getPasswordFld().setText("");
			ViewInsertPswrd.getPasswordFld().setBorder(new MatteBorder(1, 1, 1, 1, Color.RED));
			return false;
		}
	}
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//									   			   Controllo Bacheca
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	
	public void goToBacheca() {
		
		ViewMain.setVisible(false);
		
		ViewBacheca = new BachecaFrame("Sci-Conference", this);
		ViewBacheca.setVisible(true);
	}
	
	public void backFromBacheca() {
		
		ViewBacheca.dispose();
		ViewMain.setVisible(true);
	}
	
	
	public void confermaBacheca() {
		
		try { 
			
			addIdea(); 
			ViewBacheca.dispose();
			ViewMain.setVisible(true);
			JOptionPane.showMessageDialog(ViewMain, "Idea inserita in bacheca!");
		} 
		
		catch (EmptyFieldException efe) {
			
			System.out.println(efe);
			JOptionPane.showMessageDialog(ViewBacheca, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void addIdea() throws EmptyFieldException {
		
		if (ViewBacheca.fieldsAreEmpty()) { throw new EmptyFieldException(); }
		
		else {
			
			String descrizione = addApostrofi(ViewBacheca.getDescrizioneConf());
			
			proposteBacheca.setNome(ViewBacheca.getNomeConf());
			proposteBacheca.setDescrizione(descrizione);
			proposteBacheca.setTema(ViewBacheca.getButtonGroup().getSelection().getActionCommand());
			
			proposteBachecaDAO.addConf(proposteBacheca);
		}
	}
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//	 								     Controllo Aggiunta Conferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
	
	String queryConferenza = "";
	String queryOrganizzatore = "";
	String querySessione = "INSERT INTO sessioni VALUES ";
	String queryKeynote = "";
	String queryInterventi = "INSERT INTO interventi VALUES ";
	String queryPartecipante = "";


	private Collocazione collocazione;
	
	public void goToAggiunta() {
		
		ViewMain.setVisible(false);
		
		ViewGestioneConf = new GestioneConfFrame("", this);
		ViewGestioneConf.setComingFrom("MainFrame");
		ViewGestioneConf.setVisible(true);
	}
	
	public void backFromAggiunta() {
		
		ViewGestioneConf.dispose();
		resetQuery();
		ViewMain.setVisible(true);
	}
	
	private void resetQuery() {
		
		queryConferenza = "";
		queryOrganizzatore = "";
		querySessione = "INSERT INTO sessioni VALUES ";
		queryKeynote = "";
		queryInterventi = "INSERT INTO interventi VALUES ";
		queryPartecipante = "";
	}
	
	
	public void goToAggiunta2() {
		
		try {
			
			preparaConferenza();
			checkCorrectDate(ViewGestioneConf.getDataInizioC(), ViewGestioneConf.getDataFineC());
			ViewGestioneConf.setVisible(false);
			ViewAggiuntaConf2 = new AggiuntaConfFrame2("", this);
			ViewAggiuntaConf2.setVisible(true);
		
		} catch (EmptyFieldException efe) {

			System.out.println(efe);
			JOptionPane.showMessageDialog(ViewBacheca, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
			
		} catch (DateTimeException dte) {
			
			System.out.println(dte);
			JOptionPane.showMessageDialog(ViewBacheca, dte.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void backFromAggiunta2() {
		
		ViewAggiuntaConf2.dispose();
		resetQuery();
		ViewGestioneConf.setVisible(true);
	}
	
	
	public void goToSessioni() {
		
		ViewSessioni = new SessioneDialog(this, conferenzaDAO.getLastId() + 1);
		ViewSessioni.setVisible(true);
		
	}
	
	public void goToKeynote() {
		
		ViewKeynote = new KeynoteDialog(this);
		ViewKeynote.setVisible(true);
	}
	
	public void goToInterventi(String idSessione) {
		
		ViewInterventi = new InterventiDialog(this, idSessione);
		ViewInterventi.setLocation(ViewSessioni.getLocationOnScreen().x + 450, ViewSessioni.getLocationOnScreen().y + 25);
		ViewInterventi.setVisible(true);
	}
	
	public void goToPartecipanti(String comingFrom, String idIntervento) {
		
		ViewPartecipante = new PartecipanteDialog(comingFrom, idIntervento, this);
		ViewPartecipante.setVisible(true);
	}
	
	
	public void goToEnti() {
		
		ViewInfo = new InfoDialog(this, "Enti");
		
		for (int i = 0; i < ViewAggiuntaConf2.getnEnti().getSelectedIndex(); i++) {
			
			ViewInfo.getInfoConteiner().add(new myTxtFld("Nome Ente", this));
		}
		
		ViewInfo.setVisible(true);
	}
	
	public void goToSponsor() {
		
		ViewInfo = new InfoDialog(this, "Sponsor");
		
		for (int i = 0; i < ViewAggiuntaConf2.getnSponsor().getSelectedIndex(); i++) {
			
			ViewInfo.getInfoConteiner().add(new myTxtFld("Nome Sponsor", this));
		}
		
		ViewInfo.setVisible(true);
	}
	
	
	public void goToOrganizzatori() {

		ViewOrganizzatori = new OrganizzatoreDialog(conferenzaDAO.getLastId(), this);
		ViewOrganizzatori.setVisible(true);
	}
	
	
	public void confermaAggiunta() {
		
		try { 
			
			inserisciCollocazione(ViewGestioneConf, queryConferenza);
			inserisciConferenza(ViewGestioneConf, queryConferenza);
			inserisciInfo(ViewAggiuntaConf2); 
			inserisciSessioni();
			
			ViewGestioneConf.dispose();
			ViewAggiuntaConf2.dispose();
			ViewMain.setVisible(true);
			
		} catch (EmptyFieldException efe) {
			
			System.out.println(efe);
			JOptionPane.showMessageDialog(ViewAggiuntaConf2, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void preparaConferenza() throws EmptyFieldException {    

		if (ViewGestioneConf.fieldsAreEmpty()) { throw new EmptyFieldException(); } 
		
		else {
			
			queryConferenza += ViewGestioneConf.getNomeTxt() + "', '";
			queryConferenza += ViewGestioneConf.getDataInizio() + "', '";
			queryConferenza += ViewGestioneConf.getDataFine() + "', '";
			queryConferenza += ViewGestioneConf.getDescrizioneTxt() + "', '";
			queryConferenza += ViewGestioneConf.getButtonGroup().getSelection().getActionCommand() + "', '";
		}
	}
	
	public void inserisciCollocazione(GestioneConfFrame viewAggiuntaConf, String insertConf) {
		
		collocazioneDAO.insertCollocazione(viewAggiuntaConf.getSedeTxt(), viewAggiuntaConf.getRegioneTxt());
	}
	
	public void inserisciInfo(AggiuntaConfFrame2 viewAggiuntaConf) throws EmptyFieldException {
		
		int idConferenza = conferenzaDAO.getLastId();
		
		if (viewAggiuntaConf.fieldsAreEmpty()) {
			
			throw new EmptyFieldException();
			
		} else {
		
			for (String e : viewAggiuntaConf.getEnti()) {
				
				enteDAO.insertEnte(e, idConferenza);
			}
			
			for (Component s : viewAggiuntaConf.getSponsorConteiner().getComponents()) {
				
				sponsorDAO.insertSponsor(((JLabel)s).getText(), idConferenza);
			}
			
			organizzatoreDAO.insertOrganizzatore(queryOrganizzatore);
			
			keynoteSpeakerDAO.insertKeynoteSpeaker(cut2(queryKeynote));
		}
	}
	
	public void inserisciConferenza(GestioneConfFrame viewAggiuntaConf, String query) {
		
		query += collocazioneDAO.getIdCollocazione(viewAggiuntaConf.getSedeTxt(), viewAggiuntaConf.getRegioneTxt());
		conferenzaDAO.insertConferenza(query);
	}
	
	public void inserisciSessioni() {
		
		sessioneDAO.insertSessione(cut2(querySessione));
		interventoDAO.insertIntervento(cut2(queryInterventi));
		partecipanteDAO.insertPartecipante(queryPartecipante);
	}
	
	public void addQuerySessione(String q, Integer n) throws EmptyFieldException, NoInterventionException, DateTimeException {
		
		if (ViewSessioni.FieldsAreEmpty()) {
			
			throw new EmptyFieldException();
			
		} else if(ViewSessioni.getInterventi().isEmpty()) {
			
			throw new NoInterventionException();
			
		} else {
			
			checkDateSessionInConf();
			
			if (n < ViewAggiuntaConf2.getNumeroSessioni().getSelectedIndex()) {
				
				querySessione += q;
				ViewAggiuntaConf2.getSessioni().add(new SessionePanel(n.toString(), this, "Aggiunta"));
				ViewSessioni.nextSessione();
				ViewAggiuntaConf2.getNextBtn().setEnabled(true);
				
			} else {
				
				querySessione += q;
				ViewAggiuntaConf2.getSessioni().add(new SessionePanel(n.toString(), this, "Aggiunta"));
				ViewSessioni.dispose();
				ViewAggiuntaConf2.getSessioniSlider().show(ViewAggiuntaConf2.getSessioni().get(0), AnimateType.TO_LEFT);
			}
			System.out.println();
			System.out.println();
			ViewAggiuntaConf2.getNumeroSessioni().setEnabled(false);	
		}
	}
	
	public void checkDateSessionInConf() throws DateTimeException {
		
		if (ViewSessioni.getDataInizioC().compareTo(ViewGestioneConf.getDataInizioC()) < 0 
		 || ViewSessioni.getDataFineC().compareTo(ViewGestioneConf.getDataFineC()) > 0) {
			
			throw new DateTimeException("La data della sessione deve essere compresa in quella della conferenza.");
		
		} else if (ViewSessioni.getDataInizioC().compareTo(ViewSessioni.getDataFineC()) > 0) {
			
			throw new DateTimeException("La data di fine è più piccola della data di inizio.");
		}
	}
	
	public void addInfoSessione(SessionePanel sessionePanel) {
		
		sessionePanel.setDataOraInizio(ViewSessioni.getDataInizio());
		sessionePanel.setDataOraFine(ViewSessioni.getDataFine());
		sessionePanel.setLocazione(ViewSessioni.getLocazione());
		sessionePanel.setCoordinatore(ViewSessioni.getCoordinatore());
		
		if (ViewKeynote == null) { sessionePanel.setKeynoteSpeaker("nessuno"); }
		
		else { sessionePanel.setKeynoteSpeaker(ViewKeynote.getNome() + " " + ViewKeynote.getCognome()); }
		
		for (Component com : ViewSessioni.getInterventi()) {
			sessionePanel.getInterventiPanel().add(com);
		}
	}
	
	public void addQueryKeynote(String q) throws EmptyFieldException {
		
		if (ViewKeynote.fieldsAreEmpty()) {
			
			throw new EmptyFieldException();
			
		} else {

			queryKeynote += q;
			ViewSessioni.setKeynoteSpeaker(ViewKeynote.getEmail());
			ViewKeynote.dispose();
		}
	}
	
	
	public void addQueryInterventi(String q, int n) throws EmptyFieldException, DateTimeException {
		
		if (ViewInterventi.fieldsAreEmpty()) {

			throw new EmptyFieldException();
			
		} else {
			
			checkOrario();
			
			if (n < ViewSessioni.getnInterventi().getSelectedIndex()) {
				
				queryInterventi += q;
				addInfoInterventi(ViewSessioni.getInterventi(), n);
				ViewInterventi.nextIntervento();
				
			} else {
				
				queryInterventi += q; 
				addInfoInterventi(ViewSessioni.getInterventi(), n);
				ViewSessioni.getnInterventi().setEnabled(false);
				ViewInterventi.dispose(); 
			}
		}
	}
	
	public void checkOrario() {
		
		if (ViewInterventi.getOraInizioC().compareTo(ViewInterventi.getOraFineC()) > 0) {
			
			throw new DateTimeException("L'orario di inizio viene dopo quello di fine.");
		}
	}
	
	public void addInfoInterventi(ArrayList<Component> a, int n) {
		
		a.add(new InterventoLbl("Intervento " + n));
		a.add(new InfoInterventoLbl(ViewInterventi.getOraInizio() + " - " + ViewInterventi.getOraFine(), ""));
		
		for (String p : ViewInterventi.getPartecipanti()) { a.add(new InfoInterventoLbl(p, "")); }
		
		a.add(new DescrizioneTextPane(ViewInterventi.getDescrizione()));
	}
	
	public void addQueryPartecipante(String q, int n) {
		
		if (n < ViewInterventi.getnPartecipanti().getSelectedIndex()) {
				
			queryPartecipante += q;
			ViewInterventi.getPartecipanti().add(ViewPartecipante.getNome() + " " + ViewPartecipante.getCognome());
			ViewPartecipante.nextPartecipante();
			
		} else { 
				
			queryPartecipante += q;
			ViewInterventi.getPartecipanti().add(ViewPartecipante.getNome() + " " + ViewPartecipante.getCognome());
			ViewInterventi.getnPartecipanti().setEnabled(false);
			ViewPartecipante.dispose(); 
		}
	}
	
	
	public void addQueryEnti() throws EmptyFieldException {
		
		for (Component t : ViewInfo.getInfoConteiner().getComponents()) {
			
			if (((JTextComponent) t).getText().isEmpty() || ((JTextComponent) t).getText().equals("Nome Ente")) {

				JOptionPane.showMessageDialog(ViewInfo, "Uno o più campi sono vuoti.", "Dati incorretti", JOptionPane.ERROR_MESSAGE);
				throw new EmptyFieldException();
				
			} else {
				
				ViewAggiuntaConf2.getNumeroOrganizzatori().setEnabled(true);
				ViewAggiuntaConf2.getEnti().add(((JTextComponent) t).getText());
				ViewAggiuntaConf2.getEntiConteiner().add(new InfoLbl(((JTextComponent) t).getText(), "")); 
			}
		}
		
		ViewAggiuntaConf2.getEntiConteiner().revalidate();
		ViewAggiuntaConf2.getnEnti().setEnabled(false);
		ViewInfo.dispose();
	}
	
	public void addQuerySponsor() throws EmptyFieldException {
		
		for (Component t : ViewInfo.getInfoConteiner().getComponents()) { 
			
			if (((JTextComponent) t).getText().isEmpty() || ((JTextComponent) t).getText().equals("Nome Sponsor")) {

				JOptionPane.showMessageDialog(ViewInfo, "Uno o più campi sono vuoti.", "Dati incorretti", JOptionPane.ERROR_MESSAGE);
				throw new EmptyFieldException();
				
			} else { ViewAggiuntaConf2.getSponsorConteiner().add(new InfoLbl(((JTextComponent) t).getText(), ""));  }
		}
		
		ViewAggiuntaConf2.getSponsorConteiner().revalidate();
		ViewAggiuntaConf2.getnSponsor().setEnabled(false);
		ViewInfo.dispose();
	}
	
	
	public void addQueryOrganizzatore(String q, int n) throws EmptyFieldException, EnteNotFoundException {
		
		if (ViewOrganizzatori.fieldsAreEmpty()) {
				
			throw new EmptyFieldException();
				
		} else if (ViewAggiuntaConf2.getEnti().contains(ViewOrganizzatori.getAfferenza())) {
			
			if (n < ViewAggiuntaConf2.getNumeroOrganizzatori().getSelectedIndex()) {
				
				queryOrganizzatore += q;
				ViewAggiuntaConf2.getOrganizzatoriConteiner().add(new InfoLbl(ViewOrganizzatori.getNome() + " " + ViewOrganizzatori.getCognome(), ""));
				ViewOrganizzatori.nextOrganizzatore();
				
			} else {
				
				queryOrganizzatore += q;
				ViewAggiuntaConf2.getOrganizzatoriConteiner().add(new InfoLbl(ViewOrganizzatori.getNome() + " " + ViewOrganizzatori.getCognome(), ""));
				ViewAggiuntaConf2.getOrganizzatoriConteiner().revalidate();
				ViewAggiuntaConf2.getNumeroOrganizzatori().setEnabled(false);
				ViewOrganizzatori.dispose();
			}
			
		} else { throw new EnteNotFoundException(); }
	}
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//	 								      Controllo Modifica Conferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	//TODO
	
	String queryModificaPartecipante = "";
	
	public void goToRisultati2() {
		
		ViewRisultati = new RisultatiRicercaFrame("Sci-Conference", this);
		
		
		for (Conferenza c : conferenzaDAO.getConferenze()) {
			
			ViewRisultati.getRisultatiPanel().add(new ConfBtn(this, c.getNome(), c.getTema(), c.getId(), "goToUpdateConf"));
		}
		
		ViewRisultati.showLayer("Results Scroller");
		
		ViewMain.setVisible(false);
		ViewRisultati.setVisible(true);
	}
	
	public void goToModifica(String idConferenza) {

		ViewRisultati.dispose();
		
		ViewGestioneConf = new GestioneConfFrame("", this);
        setInfoInUpdateConf(idConferenza, ViewGestioneConf);

        ViewGestioneConf.setVisible(true);
    }
	
	public void goToModifica2() {
		
		ViewModifica = new ModificaFrame2("", this);
		ViewGestioneConf.setVisible(false);
		ViewModifica.setVisible(true);
	}
	
	public void backFromModifica() {

        ViewGestioneConf.dispose();
        ViewRisultati.setVisible(true);
    }
	
	public void backFromModifica2() {
		
	}
	
	
	private void setInfoInUpdateConf(String idConferenza, GestioneConfFrame viewGestioneConf) {
		
		conferenza = conferenzaDAO.getConferenza(idConferenza);	
		collocazione = collocazioneDAO.getCollocazione(conferenza.getId());
		
		//viewGestioneConf.getAddConfLbl().setText("Modifica " + conf.getNome());

		viewGestioneConf.setNome(conferenza.getNome());
        
		setDate(viewGestioneConf, conferenza);
                
        viewGestioneConf.setDescrizione(conferenza.getDescrizione());
        
        viewGestioneConf.setSede(collocazione.getSede());
        
        viewGestioneConf.setRegione(collocazione.getRegione());
        
        setTema(viewGestioneConf, conferenza);
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
	
	
    public void addModSessioneInfo(int currentSession, ModSessioniPanel sessionePanel) {
		
		ArrayList<Sessione> sessioni = sessioneDAO.getSessioni("1000");
		setSessioneDate(sessionePanel, sessioni.get(currentSession));
		sessionePanel.setKeynoteSpeaker(sessioni.get(currentSession).getKeynoteSpeaker());
		sessionePanel.setCoordinatore(sessioni.get(currentSession).getCoordinatore());
		addModInterventi(sessioni.get(currentSession).getId(), sessionePanel);
	}
	
    public void setSessioneDate(ModSessioniPanel sessionePanel, Sessione sessione) {
    	
    	sessionePanel.getDataInizioCB().setDay(sessione.getDataInizio().get(Calendar.DATE));
    	sessionePanel.getDataInizioCB().setMonth(sessione.getDataInizio().get(Calendar.MONTH));
    	sessionePanel.getDataInizioCB().setYear(sessione.getDataInizio().get(Calendar.YEAR));
		
    	sessionePanel.getDataFineCB().setDay(sessione.getDataFine().get(Calendar.DATE));
    	sessionePanel.getDataFineCB().setMonth(sessione.getDataFine().get(Calendar.MONTH));
    	sessionePanel.getDataFineCB().setYear(sessione.getDataFine().get(Calendar.YEAR));
    }
    
	
	public void addModInterventi(String idsessione, ModSessioniPanel sessionePanel) {
		
		int n = 0;
		
		for (Intervento i : interventoDAO.getInterventi(idsessione)) {
			
			sessionePanel.getInterventi().add(new ModInterventoPanel(i.getIdIntervento(), this));
			sessionePanel.getInterventi().get(n).getCentrPanel().add(new InfoInterventoLbl(t.toTimeFormat(i.getOrainizio().getTime()) + " - " + t.toTimeFormat(i.getOrafine().getTime()), ""));
			sessionePanel.getInterventi().get(n).getCentrPanel().add(new DescrizioneTextPane(i.getDescrizione()));
			
			for (Partecipante p : partecipanteDAO.getPartecipanti(i.getIdIntervento())) {
				sessionePanel.getInterventi().get(n).getCentrPanel().add(new InfoInterventoLbl(p.getNome() + " " + p.getCognome(), p.getEmail()));
			}
			
			sessionePanel.getInterventiPanel().add(sessionePanel.getInterventi().get(n));
			sessionePanel.getInterventi().get(n).getCentrPanel().add(new JLabel(" "));
			sessionePanel.getInterventi().get(n).getCentrPanel().add(new InfoInterventoLbl("Aggiungi un partecipante:", ""));
			n ++;
		}		
	}
    
	
	public void updateSessione(ModSessioniPanel modSessioniPanel) {
    	
    	sessione.setId("100001");
//    	sessione.setDataOraInizio(modSessioniPanel.getDataOraFine());
//    	sessione.setDataOraFine(modSessioniPanel.getDataOraInizio());
    	sessione.setCoordinatore(modSessioniPanel.getCoordinatore());
    	sessione.setKeynoteSpeaker(modSessioniPanel.getKeynoteSpeaker());
    	
    	sessioneDAO.updateSessione(sessione);
    }
	
	public void addQueryModPartecipante(ModSessioniPanel modSessioniPanel,int i, String q, int n) {
		
		if (n < modSessioniPanel.getInterventi().get(i).getNumeroPartecipanti().getSelectedIndex()) {
			
			queryModificaPartecipante += q;
			modSessioniPanel.getInterventi().get(i).getCentrPanel().add(new InfoInterventoLbl(ViewPartecipante.getNome() + " " + ViewPartecipante.getCognome(), ""));
			ViewPartecipante.nextPartecipante();
			
		} else {
				
			queryModificaPartecipante += q;
			modSessioniPanel.getInterventi().get(i).getCentrPanel().add(new InfoInterventoLbl(ViewPartecipante.getNome() + " " + ViewPartecipante.getCognome(), ""));
			modSessioniPanel.getInterventi().get(i).getNumeroPartecipanti().setEnabled(false);
			ViewPartecipante.dispose(); 
		}
	}
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//	 									 Controllo Rimozione Conferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	
	public void delete() {
		
		//TODO
	}
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+	
//												 Utils function
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
	
	public void setTextNull(JTextComponent txtCom, int grandezzaFont) {
		
		txtCom.setText("");
		txtCom.setFont(t.myFont(grandezzaFont));
		txtCom.setForeground(t.tangaroa);
	}
	
	
	public void checkCorrectDate(Calendar DataInizio, Calendar DataFine) throws DateTimeException {
    	
    	Calendar DataAttuale = Calendar.getInstance();

        if(DataInizio.compareTo(DataFine) > 0) {
        	
        	throw new DateTimeException("La data di fine è più piccola della data di inizio.");
               
        } else if (DataInizio.compareTo(DataAttuale) < 0) {
        	
            throw new DateTimeException("La data di inizio è già passata.");
        } 
    }
	
	
	public void setTopicColor(String Tema, Component com) {
    	
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
	
	
	public String addApostrofi(String string) {

        for (char c : string.toCharArray()) { 
            
        	if (c == '\'') { string += c + "'"; }
        	
        	else { string += c; }
        }
        
        return string;
    }
	
	private String cut2(String query) { return query.substring(0, query.length() - 2); }
}