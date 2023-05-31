package linker;

import DAO.*;
import DTO.*;
import GUI.AfferenzeFrame;
import GUI.AfferenzePanel;
import GUI.BachecaFrame;
import GUI.EntiLbl;
import GUI.PropostaBachecaBtn;
import GUI.RisultatiRicercaFrame;
import GUI.AdminFrames.*;
import GUI.CalendarFrame.*;
import GUI.ConferenzaFrame.*;
import GUI.FilterFrame.*;
import GUI.MainFrame.*;
import GUI.UserFrames.*;
import myException.*;
import myTools.*;
import myTools.PanelSlide.AnimateType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.time.DateTimeException;
import com.formdev.flatlaf.FlatIntelliJLaf;

import java.awt.Color;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;


public class Controller {

	private myTemplates t;


	private ConferenzaDAO conferenzaDAO;
    private Conferenza conferenza;
    private SessioneDAO sessioneDAO;
    private Sessione sessione;
    private ArrayList<Sessione> sessioni;
    private KeynoteSpeakerDAO keynoteSpeakerDAO;
    private ArrayList<KeynoteSpeaker> keynoteSpeakers;
    private KeynoteSpeaker keynoteSpeaker;
    private InterventoDAO interventoDAO;
    private Intervento intervento;
    private ArrayList<Intervento> interventi;
    private PartecipanteDAO partecipanteDAO;
    private ArrayList<Partecipante> partecipanti;
    private Partecipante partecipante;

	private CollocazioneDAO collocazioneDAO;
	private Collocazione collocazione;
    private EnteDAO enteDAO;
    private SponsorDAO sponsorDAO;
    private OrganizzatoreDAO organizzatoreDAO;
    private ArrayList<Organizzatore> organizzatori;
    private Organizzatore organizzatore;

    private ProposteBachecaDAO proposteBachecaDAO;
    private ProposteBacheca proposteBacheca;

    private UtenteDAO utenteDAO;
    private Utente utente;

    private TOKEN token;


    private MainFrame ViewMain;
    private Calendar DataAttuale = Calendar.getInstance();
    private int Mese1 = DataAttuale.get(Calendar.MONTH);
    private int Mese2 = DataAttuale.get(Calendar.MONTH) + 1;
	private LogInFrame ViewLogIn;
	private SignUpFrame ViewSignUp;

	private CalendarFrame ViewCalendario;

	private BachecaFrame ViewBacheca;

	private FilterFrame ViewFiltri;
	private RisultatiRicercaFrame ViewRisultati;
	private String queryTemi = "NULL";
	private String queryCollocazioni = "NULL";
	private String queryDataPrecisa = "NULL";
	private String queryPeriodo = ", NULL, NULL";
	private String queryData = "";

	private AfferenzeFrame ViewAfferenze;

	private ConferenzaFrame ViewConferenza;
	private InsertPswrdDialog ViewInsertPswrd;

	private GestioneFrame ViewGestione;
	private Aggiunta2Frame ViewAggiunta2;
	private Modifica2Frame ViewModifica2;
	private SessioneDialog ViewSessioni;
	private KeynoteDialog ViewKeynote;
	private InterventiDialog ViewInterventi;
	private PartecipanteDialog ViewPartecipante;
	private InfoDialog ViewInfo;
	private OrganizzatoreDialog ViewOrganizzatori;

	private int IdNextConf = -1;
	private String queryModificaSessioni = "";


	public static void main(String[] args) {
		FlatIntelliJLaf.setup();

		Controller controller = new Controller();
	}

	public Controller() {

		initDAO();
		t = new myTemplates();
		ViewCalendario = new CalendarFrame(this);
		ViewMain = new MainFrame(this);
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

			if (c.getDataInizio().get(Calendar.MONTH) == Mese1) {

				sxPanel.getConferenzeMese1().add(new SxConfBtn(this, c.getNome(), c.getTema(), c.getId()));

			} else if (c.getDataInizio().get(Calendar.MONTH) == Mese2) {

				sxPanel.getConferenzeMese2().add(new SxConfBtn(this, c.getNome(), c.getTema(), c.getId()));
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

		ViewSignUp = new SignUpFrame(this);
        ViewSignUp.setVisible(true);
	}
	
	public void backFromSignUp() {

		ViewSignUp.dispose();
		ViewMain.setVisible(true);
	}
	
	public void fromSignUpToLogIn() {

		ViewSignUp.dispose();

		ViewLogIn = new LogInFrame(this);
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

		} catch (UsernameAlreadyExistsException uaee) {
			System.out.println(uaee);
			JOptionPane.showMessageDialog(ViewSignUp, uaee.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void controlloSignUp() throws EmptyFieldException, DifferentPasswordException,
										  ShortPswrdException, InvalidEmailFormatException,
										  EmailAlreadyExistsException, UsernameAlreadyExistsException {

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

	        ViewMain.getSxPanel().showAfterAccessLayer(utente.getUsername());
	        ViewMain.getCtrPanel().showLayer("NoConf");
		}
	}


	private void registraUtente() throws EmailAlreadyExistsException, UsernameAlreadyExistsException {

		if (!utenteDAO.checkEmail(ViewSignUp.getEmail())) {

			ViewSignUp.setEmailError();
			throw new EmailAlreadyExistsException();

		} else if (!utenteDAO.checkUsername(ViewSignUp.getUsername())) {

			ViewSignUp.setUsernameError();
			throw new UsernameAlreadyExistsException();

		} else {

			utente = new Utente();
			utente.setEmail(ViewSignUp.getEmail());
		    utente.setUsername(ViewSignUp.getUsername());
		    utente.setPassword(ViewSignUp.getPassword());

		    utenteDAO.registrazione(utente);
		}
	}




//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//												Controllo LogIn
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToLogIn() {

		ViewMain.dispose();

		ViewLogIn = new LogInFrame(this);
		ViewLogIn.setVisible(true);
	}

	public void backFromLogIn() {

		ViewLogIn.dispose();
		ViewMain.setVisible(true);
	}

	public void fromLogInToSignUp() {

		ViewLogIn.dispose();

		ViewSignUp = new SignUpFrame(this);
		ViewSignUp.setVisible(true);
	}


	public void confermaLogIn() {

        if(token.checkTOKEN(ViewLogIn.getPassword())) {

        	ViewLogIn.dispose();
        	utente = new Utente();
        	utente.setUsername("Admin");
        	ViewMain.getSxPanel().showAfterAccessLayer("Admin");
        	ViewMain.getCtrPanel().getCentrLbl().setText("Gestione Conferenze");
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

				ViewMain.getSxPanel().showAfterAccessLayer(utente.getUsername());
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

			ViewMain.getCtrPanel().showLayer("NoConf");

		} else {

			for (Conferenza c : conferenzeUtente) {
				ViewMain.getCtrPanel().getUserConfAfterAccess2().add(new UserConfBtn(this, c.getNome(), c.getTema(), c.getId()));
			}

			ViewMain.getCtrPanel().showLayer("UserConf");
		}
	}




//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//	   											Controllo Calendario
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToCalendario() { ViewCalendario.setVisible(true); }


	public void setDate(ArrayList<CalendarCell> arrCells, Calendar DataPannello, int meseCorrente) {

		int StartDay = DataPannello.get(Calendar.DAY_OF_WEEK) - 2;

		DataPannello.add(Calendar.DATE, - StartDay);

		for (CalendarCell c : arrCells) {

			c.setText(DataPannello.get(Calendar.DATE) + "");
			c.currentMonth(DataPannello.get(Calendar.MONTH) == meseCorrente);
			conferenza = conferenzaDAO.getConferenzaByDate(t.dateFormat(DataPannello.getTime()));
			c.containsConf(conferenza.getNome(), conferenza.getId(), this);

			DataPannello.add(Calendar.DATE, 1);
		}
	}




//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//		 									    Controllo Afferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToAfferenze() {

		ViewMain.setVisible(false);
		ViewAfferenze = new AfferenzeFrame(this);
		ViewAfferenze.setVisible(true);
	}

	public void backFromAfferenze() {

		ViewAfferenze.dispose();
		ViewMain.setVisible(true);
	}

	public void addPercentualiAfferenze(AfferenzePanel afferenzePanel, int month, int year) {

    	for (Ente e : keynoteSpeakerDAO.getAfferenze(month, year)) {

    		int percentuale = (e.getOccorrenze() * 100) / Ente.getTotaleEnti();
    		
    		if (afferenzePanel.getItemCount() < 10) {
    			
    			afferenzePanel.getPercentualiAfferenze().add(new EntiLbl(percentuale +"% - "+ e.getNome() +" ("+ e.getOccorrenze()));
    			afferenzePanel.addValue(e.getNome(), percentuale);				
			}
		}
    }
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//	   											 Controllo Ricerca
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToFiltri() {

		ViewFiltri = new FilterFrame(this);
		Point MouseCoordnt = MouseInfo.getPointerInfo().getLocation();
		ViewFiltri.setLocation(MouseCoordnt.x - 20, MouseCoordnt.y + 25);
		ViewFiltri.setVisible(true);

		resetQueryFiltri();
	}

	public void backFromFiltri() { ViewMain.getDxPanel().getFilterBtn().setEnabled(true); }


    public void goToRisultati() {

    	componiQuery();

    	ViewRisultati = new RisultatiRicercaFrame(this);

    	queryData = queryDataPrecisa + queryPeriodo;

		for (Conferenza c : conferenzaDAO.getConferenzeRicerca(ViewMain.getResearchTxt(), queryTemi, queryCollocazioni, queryData)) {

			ViewRisultati.getRisultatiPanel().add(new ConfBtn(this, c.getNome(), c.getTema(), c.getId()));
		}

		if (ViewRisultati.getRisultatiPanel().getComponents().length != 0) {

			ViewRisultati.showLayer("ResultsScroller");
		}

		ViewMain.setVisible(false);
		ViewRisultati.setVisible(true);
	}
    
    public void backFromRisultati() {

		ViewRisultati.dispose();
		ViewMain.getDxPanel().resetFilterLbl();
		ViewMain.getDxPanel().getClearFltrBtn().setVisible(false);
		queryTemi = "NULL";
		queryCollocazioni = "NULL";
		ViewMain.setVisible(true);
	}
    
	private void componiQuery() {

		if (!queryTemi.equals("NULL")) {

			queryTemi = "ARRAY[" + cut2(queryTemi) + "]";
		}


		if (!queryCollocazioni.equals("NULL")) {

			queryCollocazioni = "ARRAY[" + cut2(queryCollocazioni) + "]";
		}
	}
	
	
	public void addQueryDataPrecisa(String q) { queryDataPrecisa = q; }
	
	public void addQueryPeriodo(String q) { queryPeriodo = q; }
	
	
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
	
	
	public void addQueryTemi(String q) {

		if (queryTemi.equals("NULL")) { queryTemi = q; }

		else { queryTemi += q;}
	}
	
	public void addQueryCollocazioni(String q) {

		if (queryCollocazioni.equals("NULL")) {	queryCollocazioni = q; }

		else { queryCollocazioni += q; }
	}
	
	public void resetQueryFiltri() {

		queryTemi = "NULL";
		queryCollocazioni = "NULL";
		queryDataPrecisa = "NULL";
		queryPeriodo = ", NULL, NULL";
		queryData = "";
	}
	
	
	
	
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//	   											  Controllo Conferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToConferenza(String idConferenza) {

		ViewConferenza = new ConferenzaFrame(idConferenza, this);
		addInfoConferenza(idConferenza);
		setTopicColor(ViewConferenza.getNorthPanel().getTemaLbl().getText(), ViewConferenza.getNorthPanel().getNomeLbl());
        setTopicColor(ViewConferenza.getNorthPanel().getTemaLbl().getText(), ViewConferenza.getNorthPanel().getTemaLbl());
	    ViewConferenza.showInfo();

		if (ViewMain.isVisible()) {

			ViewMain.setVisible(false);
			ViewCalendario.setVisible(false);
			ViewConferenza.setFramePrecedente("MainFrame");
		}

		else { ViewRisultati.setVisible(false); }

	    ViewConferenza.setVisible(true);
	}

	public void backFromConferenza(String framePrecedente) {

		if(framePrecedente.equals("MainFrame")) { ViewMain.setVisible(true); }

		else { ViewRisultati.setVisible(true); }

	    ViewConferenza.dispose();
	}


	private void addInfoConferenza(String idConferenza) {

		conferenza = conferenzaDAO.getConferenza(idConferenza);
		collocazione = collocazioneDAO.getCollocazione(idConferenza);

		ViewConferenza.getNorthPanel().setNome(conferenza.getNome());

        ViewConferenza.getNorthPanel().setDataInizio(t.dateFormat(conferenza.getDataInizio().getTime()));
        ViewConferenza.getNorthPanel().setDataFine(t.dateFormat(conferenza.getDataFine().getTime()));

        ViewConferenza.getNorthPanel().setDescrizionePrimaParte(conferenza.getDescrizionePrimaParte());
        ViewConferenza.getNorthPanel().setDescrizioneSecondaParte(conferenza.getDescrizioneSecondaParte());
        ViewConferenza.getNorthPanel().setTema(conferenza.getTema());
        ViewConferenza.getNorthPanel().setCollocazione(collocazione.getSede() + ", " + collocazione.getRegione());

        addOtherInfo(idConferenza);

		if (utente != null) {

			if (utenteDAO.checkIscrizione(utente.getEmail(), conferenza.getId().toString())) {

				ViewConferenza.showLayer("GiàIscritto");

			} else if (utente.getUsername().equals("Admin")) {

				ViewConferenza.showLayer("Rimuovi");
			}
		}
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

		int n = 1;
		for (Sessione s : sessioneDAO.getSessioni(idConferenza)) {
			
			SessionePanel sp = new SessionePanel(s.getId(), this, "ConferenzaFrame");
			sp.setSessioneLbl("Sessione " + n);
			sessioniPanels.add(sp);
			n ++;
		}
	}

	public void addSessioneInfo(String idSessione, SessionePanel sessionePanel) {
		
		sessione = sessioneDAO.getSessione(idSessione);
		
		sessionePanel.setDataInizio(t.dateFormat(sessione.getDataInizio().getTime()));
		sessionePanel.setDataFine(t.dateFormat(sessione.getDataFine().getTime()));
		sessionePanel.setKeynoteSpeaker(sessione.getKeynoteSpeaker());
		sessionePanel.setCoordinatore(sessione.getCoordinatore());
		sessionePanel.setLocazione(sessione.getLocazione());
		addInterventi(idSessione, sessionePanel);
	}


	private void addInterventi(String idSessione, SessionePanel sessionePanel) {

		int n = 1;

		for (Intervento i : interventoDAO.getInterventi(idSessione)) {

			sessionePanel.getInterventi().add(new InterventoLbl("Intervento " + n));
			sessionePanel.getInterventi().add(new InfoInterventoLbl(t.timeFormat(i.getOraInizio().getTime()) + " - " + t.timeFormat(i.getOraFine().getTime()), ""));

			for (Partecipante p : partecipanteDAO.getPartecipanti(i.getId())) {
				sessionePanel.getInterventi().add(new InfoInterventoLbl(p.getNome() + " " + p.getCognome(), p.getEmail()));
			}

			n ++;
			sessionePanel.getInterventi().add(new DescrizioneTextPane(i.getDescrizione()));
		}
	}

	public void addPartecipanteInfo(OrganizzatoreInfo organizzatoreInfo, String idOrganizzatore) {

		partecipante = partecipanteDAO.getPartecipante(idOrganizzatore);

		organizzatoreInfo.shrinkFont();
		organizzatoreInfo.setAfferenza(partecipante.getAfferenza());
		organizzatoreInfo.setEmail(partecipante.getEmail());
	}


//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//		  										Controllo Iscrizione
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToIscrizione() {

		if (utente != null) {

			ViewInsertPswrd = new InsertPswrdDialog(this);
			ViewInsertPswrd.setVisible(true);

		} else {

			ViewConferenza.dispose();

			ViewSignUp = new SignUpFrame(this);
			ViewSignUp.setFieldsNull();
	        ViewSignUp.setVisible(true);
		}
	}


	public void confermaIscrizione() {

		conferenza = conferenzaDAO.getConferenza(ViewConferenza.getId());

		try {

			iscrizione(conferenza);
			ViewInsertPswrd.dispose();
			ViewConferenza.dispose();
			ViewMain.getCtrPanel().showLayer("UserConf");
			ViewMain.getCtrPanel().getUserConfAfterAccess2().add(new UserConfBtn(this, conferenza.getNome(), conferenza.getTema(), conferenza.getId()));
			ViewMain.revalidate();
			ViewMain.setVisible(true);
			JOptionPane.showMessageDialog(ViewMain,"Iscrizione Effettuata!");

		} catch (WrongPasswordException wpe) {

			wpe.getMessage();
			ViewInsertPswrd.setError();
		}
	}

	private void iscrizione(Conferenza conf) throws WrongPasswordException {

		if (ViewInsertPswrd.getPasswordFld().equals(utente.getPassword())) {

			utenteDAO.iscrizione(utente.getEmail(), conf.getId());

		} else { throw new WrongPasswordException(); }
	}




//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//									   			   Controllo Bacheca
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToBacheca() {

		ViewMain.setVisible(false);

		ViewBacheca = new BachecaFrame(this);
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

			proposteBacheca = new ProposteBacheca();
			
			proposteBacheca.setNome(ViewBacheca.getNomeConf());
			proposteBacheca.setDescrizione(descrizione);
			proposteBacheca.setTema(ViewBacheca.getButtonGroup().getSelection().getActionCommand());

			proposteBachecaDAO.addConf(proposteBacheca);
		}
	}




//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//	 								     Controllo Aggiunta Conferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToAggiunta() {

		ViewMain.setVisible(false);

		ViewGestione = new GestioneFrame("", "MainFrame", this);
		ViewGestione.setVisible(true);
	}

	public void backFromAggiunta() {

		ViewGestione.dispose();
		ViewMain.setVisible(true);
	}


	public void goToAggiunta2() {

		try {
			
			initArray();
			createConferenza();
			checkCorrectDate(ViewGestione.getDataInizioC(), ViewGestione.getDataFineC());
			createCollocazione();
			
			IdNextConf = conferenzaDAO.getLastId() + 1;
			ViewGestione.setVisible(false);
			ViewAggiunta2 = new Aggiunta2Frame(this);
			ViewAggiunta2.setVisible(true);

		} catch (EmptyFieldException efe) {

			System.out.println(efe);
			JOptionPane.showMessageDialog(ViewBacheca, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);

		} catch (DateTimeException dte) {

			System.out.println(dte);
			JOptionPane.showMessageDialog(ViewBacheca, dte.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void initArray() {

		sessioni = new ArrayList<Sessione>();
		organizzatori = new ArrayList<Organizzatore>();
		keynoteSpeakers = new ArrayList<KeynoteSpeaker>();
		interventi = new ArrayList<Intervento>();
		partecipanti = new ArrayList<Partecipante>();
	}
	
	public void createConferenza() throws EmptyFieldException {

		if (ViewGestione.fieldsAreEmpty()) { throw new EmptyFieldException(); }

		else {

			conferenza = new Conferenza();

			conferenza.setNome(addApostrofi(ViewGestione.getDescrizione()));
			conferenza.setDataInizio(ViewGestione.getDataInizioC());
			conferenza.setDataFine(ViewGestione.getDataFineC());
			conferenza.setDescrizione(addApostrofi(ViewGestione.getDescrizione()));
			conferenza.setTema(ViewGestione.getTema());
		}
	}

	private void createCollocazione() {

		collocazione = new Collocazione();

		collocazione.setSede(ViewGestione.getSede());
		collocazione.setRegione(ViewGestione.getRegione());
	}


	public void backFromAggiunta2() {

		ViewAggiunta2.dispose();
		ViewGestione.setVisible(true);
	}

	public void goToEnti() {

		ViewInfo = new InfoDialog(this, "Enti");

		for (int i = 0; i < ViewAggiunta2.getnEnti().getSelectedIndex(); i++) {

			ViewInfo.getInfoConteiner().add(new myTxtFld("Nome Ente", this));
		}

		ViewInfo.setVisible(true);
	}

	public void goToSponsor() {

		ViewInfo = new InfoDialog(this, "Sponsor");

		for (int i = 0; i < ViewAggiunta2.getnSponsor().getSelectedIndex(); i++) {

			ViewInfo.getInfoConteiner().add(new myTxtFld("Nome Sponsor", this));
		}

		ViewInfo.setVisible(true);
	}

	public void goToOrganizzatori() {
		
		ViewOrganizzatori = new OrganizzatoreDialog(conferenzaDAO.getLastId(), this);
		ViewOrganizzatori.setVisible(true);
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


	public void confermaAggiunta() {

		try {

			collocazioneDAO.insertCollocazione(collocazione);
			conferenza.setIdCollocazione(collocazioneDAO.getIdCollocazione(ViewGestione.getSede(), ViewGestione.getRegione()));
			conferenzaDAO.insertConferenza(conferenza);
			inserisciInfo(ViewAggiunta2);
			inserisciSessioni();

			ViewGestione.dispose();
			ViewAggiunta2.dispose();
			ViewMain.setVisible(true);

		} catch (EmptyFieldException efe) {

			System.out.println(efe);
			JOptionPane.showMessageDialog(ViewAggiunta2, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
		}
	}


	private void inserisciInfo(Aggiunta2Frame viewAggiuntaConf) throws EmptyFieldException {

		if (viewAggiuntaConf.fieldsAreEmpty()) {

			throw new EmptyFieldException();

		} else {

			for (String e : viewAggiuntaConf.getEnti()) {

				enteDAO.insertEnte(e, IdNextConf);
			}

			for (Component s : viewAggiuntaConf.getSponsorConteiner().getComponents()) {

				sponsorDAO.insertSponsor(((JLabel)s).getText(), IdNextConf);
			}

			for (Organizzatore o : organizzatori) {

				organizzatoreDAO.insertOrganizzatore(o, IdNextConf);
			}

			if (keynoteSpeakers != null) {

				for (KeynoteSpeaker k : keynoteSpeakers) {

					keynoteSpeakerDAO.insertKeynoteSpeaker(k);
				}
			}
		}
	}
	
	private void inserisciSessioni() {

		for (Sessione s : sessioni) { sessioneDAO.insertSessione(s, IdNextConf); }

		for (Intervento i : interventi) { interventoDAO.insertIntervento(i); }

		if (partecipanti != null) {

			for (Partecipante p : partecipanti) { partecipanteDAO.insertPartecipante(p); }
		}
	}


	public void addEnti() throws EmptyFieldException {

		for (Component t : ViewInfo.getInfoConteiner().getComponents()) {

			if (((JTextComponent) t).getText().isEmpty() || ((JTextComponent) t).getText().equals("Nome Ente")) {

				JOptionPane.showMessageDialog(ViewInfo, "Uno o più campi sono vuoti.", "Dati incorretti", JOptionPane.ERROR_MESSAGE);
				throw new EmptyFieldException();

			} else {

				ViewAggiunta2.getNumeroOrganizzatori().setEnabled(true);
				ViewAggiunta2.getEnti().add(((JTextComponent) t).getText());
				ViewAggiunta2.getEntiConteiner().add(new InfoLbl(((JTextComponent) t).getText(), ""));
			}
		}

		ViewAggiunta2.getEntiConteiner().revalidate();
		ViewAggiunta2.getnEnti().setEnabled(false);
		ViewInfo.dispose();
	}


	public void addSponsor() throws EmptyFieldException {

		for (Component t : ViewInfo.getInfoConteiner().getComponents()) {

			if (((JTextComponent) t).getText().isEmpty() || ((JTextComponent) t).getText().equals("Nome Sponsor")) {

				JOptionPane.showMessageDialog(ViewInfo, "Uno o più campi sono vuoti.", "Dati incorretti", JOptionPane.ERROR_MESSAGE);
				throw new EmptyFieldException();

			} else { ViewAggiunta2.getSponsorConteiner().add(new InfoLbl(((JTextComponent) t).getText(), ""));  }
		}

		ViewAggiunta2.getSponsorConteiner().revalidate();
		ViewAggiunta2.getnSponsor().setEnabled(false);
		ViewInfo.dispose();
	}


	public void addOrganizzatori(int n) throws EmptyFieldException, EnteNotFoundException {

		if (ViewOrganizzatori.fieldsAreEmpty()) {

			throw new EmptyFieldException();

		} else if (ViewAggiunta2.getEnti().contains(ViewOrganizzatori.getAfferenza())) {

			createOrganizzatore();
			ViewAggiunta2.getOrganizzatoriConteiner().add(new InfoLbl(ViewOrganizzatori.getNome() + " " + ViewOrganizzatori.getCognome(), ""));

			if (n == ViewAggiunta2.getNumeroOrganizzatori().getSelectedIndex()) {

				ViewAggiunta2.getOrganizzatoriConteiner().revalidate();
				ViewAggiunta2.getNumeroOrganizzatori().setEnabled(false);
				ViewOrganizzatori.dispose();

			} else { ViewOrganizzatori.nextOrganizzatore(); }

		} else { throw new EnteNotFoundException(); }
	}

	private void createOrganizzatore() {

		organizzatore = new Organizzatore();
		organizzatore.setEmail(ViewOrganizzatori.getEmail());
		organizzatore.setTitolo(ViewOrganizzatori.getTitolo());
		organizzatore.setNome(ViewOrganizzatori.getNome());
		organizzatore.setCognome(ViewOrganizzatori.getCognome());
		organizzatore.setAfferenza(ViewOrganizzatori.getAfferenza());

		organizzatori.add(organizzatore);
	}


	public void addSessione(Integer n) throws EmptyFieldException, NoInterventionException, DateTimeException {

		if (ViewSessioni.FieldsAreEmpty()) {

			throw new EmptyFieldException();

		} else if(ViewSessioni.getInterventi().isEmpty()) {

			throw new NoInterventionException();

		} else {

			checkDateSessionInConf();

			createSessione(n);
			ViewAggiunta2.getSessioni().add(new SessionePanel(n.toString(), this, "Aggiunta"));
			
			if (n > 1) { ViewAggiunta2.getNextBtn().setEnabled(true); }

			if (n == ViewAggiunta2.getNumeroSessioni().getSelectedIndex()) {

				ViewSessioni.dispose();
				ViewAggiunta2.getSessioniSlider().show(ViewAggiunta2.getSessioni().get(0), AnimateType.TO_LEFT);
				ViewAggiunta2.getNumeroSessioni().setEnabled(false);

			} else { ViewSessioni.nextSessione(); }
		}
	}

	private void createSessione(int n) {

		sessione = new Sessione();

		if (n < 10 ) { sessione.setId(IdNextConf + "0" + n); }

		else { sessione.setId(IdNextConf + "" + n); }

		sessione.setDataInizio(ViewSessioni.getDataInizioC());
		sessione.setDataFine(ViewSessioni.getDataFineC());
		sessione.setIdConferenza(IdNextConf);
		sessione.setLocazione(ViewSessioni.getLocazione());
		sessione.setCoordinatore(ViewSessioni.getCoordinatore());

		if (ViewSessioni.getKeynoteSpeaker().equals("Nessuno")) { sessione.setKeynoteSpeaker("Nessuno"); }

		else { sessione.setKeynoteSpeaker(ViewKeynote.getEmail()); }

		sessioni.add(sessione);
	}

	private void checkDateSessionInConf() throws DateTimeException {

		if (ViewSessioni.getDataInizioC().compareTo(ViewGestione.getDataInizioC()) < 0
		 || ViewSessioni.getDataFineC().compareTo(ViewGestione.getDataFineC()) > 0) {

			throw new DateTimeException("La data della sessione deve essere compresa in quella della conferenza.");

		} else if (ViewSessioni.getDataInizioC().compareTo(ViewSessioni.getDataFineC()) > 0) {

			throw new DateTimeException("La data di fine è più piccola della data di inizio.");
		}
	}

	public void addInfoSessione(SessionePanel sessionePanel) {

		sessionePanel.setSessioneLbl("Sessione " + ViewSessioni.getN());
		sessionePanel.setDataInizio(ViewSessioni.getDataInizio());
		sessionePanel.setDataFine(ViewSessioni.getDataFine());
		sessionePanel.setCoordinatore(ViewSessioni.getCoordinatore());
		sessionePanel.setLocazione(ViewSessioni.getLocazione());
		
		if (ViewSessioni.getKeynoteSpeaker().equals("Nessuno")) { sessionePanel.setKeynoteSpeaker("Nessuno"); }
		
		else { sessionePanel.setKeynoteSpeaker(ViewKeynote.getNome() + " " + ViewKeynote.getCognome()); }
		
		for (Component com : ViewSessioni.getInterventi()) {
			sessionePanel.getInterventi().add(com);
		}
	}

	public void addKeynote() throws EmptyFieldException {

		if (ViewKeynote.fieldsAreEmpty()) {

			throw new EmptyFieldException();

		} else if(ViewSessioni != null) {

			createKeynote();
			ViewSessioni.setKeynoteSpeaker(ViewKeynote.getEmail());
			ViewSessioni.getKeynoteSpeakerBtn().setEnabled(false);

		} else {

			createKeynote();
			ViewModifica2.getSessioniPanel().get(ViewModifica2.getN()).setKeynoteSpeaker(ViewKeynote.getEmail());
		}
		ViewKeynote.dispose();
	}

	private void createKeynote() {

		keynoteSpeaker = new KeynoteSpeaker();

		keynoteSpeaker.setEmail(ViewKeynote.getEmail());
		keynoteSpeaker.setTitolo(ViewKeynote.getTitolo());
		keynoteSpeaker.setNome(ViewKeynote.getNome());
		keynoteSpeaker.setCognome(ViewKeynote.getCognome());
		keynoteSpeaker.setAfferenza(ViewKeynote.getAfferenza());

		keynoteSpeakers.add(keynoteSpeaker);
	}


	public void addInterventi(String idSessione, int n) throws EmptyFieldException, DateTimeException {
		
		if (ViewInterventi.getDescrizione().isEmpty()) {

			throw new EmptyFieldException();

		} else {

			checkOrario();
			createIntervento(idSessione, n);
			addInfoInterventi(ViewSessioni.getInterventi(), n);

			if (n == ViewSessioni.getnInterventi().getSelectedIndex()) {

				ViewSessioni.getnInterventi().setEnabled(false);
				ViewInterventi.dispose();

			} else { ViewInterventi.nextIntervento(); }
		}
	}

	private void createIntervento(String idSessione, int n) {

		intervento = new Intervento();

		if (n < 10 ) { intervento.setId(idSessione + "0" + n); }

		else { intervento.setId(idSessione + n); }

		intervento.setOraInizio(ViewInterventi.getOraInizioC());
		intervento.setOraFine(ViewInterventi.getOraFineC());
		intervento.setDescrizione(ViewInterventi.getDescrizione());
		intervento.setIdSessione(idSessione);

		interventi.add(intervento);
	}

	private void checkOrario() {

		if (ViewInterventi.getOraInizioC().compareTo(ViewInterventi.getOraFineC()) > 0) {

			throw new DateTimeException("L'orario di inizio viene dopo quello di fine.");
		}
	}

	public void addInfoInterventi(ArrayList<Component> a, int n) {

		a.add(new InterventoLbl("Intervento " + n));
		a.add(new InfoInterventoLbl(ViewInterventi.getOraInizio().gethhmm() + " - " + ViewInterventi.getOraFine().gethhmm(), ""));

		for (String p : ViewInterventi.getPartecipanti()) { a.add(new InfoInterventoLbl(p, "")); }

		a.add(new DescrizioneTextPane(ViewInterventi.getDescrizione()));
	}


	public void addPartecipante(String idIntervento, int n) {

		createPartecipante(idIntervento);
		ViewInterventi.getPartecipanti().add(ViewPartecipante.getNome() + " " + ViewPartecipante.getCognome());

		if (n == ViewInterventi.getnPartecipanti().getSelectedIndex()) {

			ViewInterventi.getnPartecipanti().setEnabled(false);
			ViewPartecipante.dispose();

		} else { ViewPartecipante.nextPartecipante(); }
	}

	private void createPartecipante(String idIntervento) {

		partecipante = new Partecipante();

		partecipante.setEmail(ViewPartecipante.getEmail());
		partecipante.setTitolo(ViewPartecipante.getTitolo());
		partecipante.setNome(ViewPartecipante.getNome());
		partecipante.setCognome(ViewPartecipante.getCognome());
		partecipante.setAfferenza(ViewPartecipante.getAfferenza());
		partecipante.setIdIntervento(idIntervento);

		partecipanti.add(partecipante);
	}




//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//	 								      Controllo Modifica Conferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToElencoModifica() {

		ViewRisultati = new RisultatiRicercaFrame(this);

		for (Conferenza c : conferenzaDAO.getConferenze()) {

			ViewRisultati.getRisultatiPanel().add(new ConfBtn(this, c.getNome(), c.getTema(), c.getId(), "Modifica"));
		}

		ViewRisultati.showLayer("ResultsScroller");

		ViewMain.setVisible(false);
		ViewRisultati.setVisible(true);
	}
	
	public void goToModifica(String idConferenza) {

		ViewRisultati.dispose();

		ViewGestione = new GestioneFrame(idConferenza, "", this);
        setInfoInUpdateConf(idConferenza);

        ViewGestione.setVisible(true);
    }

	public void goToModifica2(String idConferenza) {

		try {

			createCollocazione();
			createConferenza();
			conferenza.setId(idConferenza);
			initArray();
			ViewModifica2 = new Modifica2Frame(this);
			ViewGestione.setVisible(false);
			ViewModifica2.setVisible(true);

		} catch (EmptyFieldException efe) {

			System.out.println(efe);
			JOptionPane.showMessageDialog(ViewBacheca, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void backFromModifica() {

        ViewGestione.dispose();
        ViewRisultati.setVisible(true);
    }

	public void backFromModifica2() {

		ViewModifica2.dispose();
		ViewGestione.setVisible(true);
	}

	public void confermaModifica() {

		collocazioneDAO.insertCollocazione(collocazione);
		conferenza.setIdCollocazione(collocazioneDAO.getIdCollocazione(ViewGestione.getSede(), ViewGestione.getRegione()));
		conferenzaDAO.updateConferenza(conferenza);

		if (keynoteSpeakers.isEmpty()) {

			for (KeynoteSpeaker k : keynoteSpeakers) { keynoteSpeakerDAO.insertKeynoteSpeaker(k); }
		}

		modificaSessione(ViewModifica2.getSessioniPanel());

		for (Intervento intervento : interventi) {

			interventoDAO.updateIntervento(intervento);
		}


		for (Partecipante p : partecipanti) {

			partecipanteDAO.insertPartecipante(p);
		}

		ViewGestione.dispose();
		ViewModifica2.dispose();
		ViewMain.setVisible(true);
	}


	public void goToModIntervento(int nIntervento) {

		intervento = interventoDAO.getInterventi(ViewModifica2.getIdSessione()).get(ViewModifica2.getCurrentIntervento());

		ViewInterventi = new InterventiDialog(this, intervento.getIdSessione(), nIntervento);
		setInfoIntervento();
		ViewInterventi.setLocationRelativeTo(null);
		ViewInterventi.setVisible(true);
	}
	
	private void setInfoIntervento() {

		ViewInterventi.setInterventoLbl("Modifica Intervento");

		ViewInterventi.getOraInizio().setHour(intervento.getOraInizio().get(Calendar.HOUR_OF_DAY));
		ViewInterventi.getOraInizio().setMinute(intervento.getOraInizio().get(Calendar.MINUTE));

		ViewInterventi.getOraFine().setHour(intervento.getOraFine().get(Calendar.HOUR_OF_DAY));
		ViewInterventi.getOraFine().setMinute(intervento.getOraFine().get(Calendar.MINUTE));

		ViewInterventi.setPartecipantiLbl("Aggiungi uno o più partecipanti (seleziona il numero): ");

		ViewInterventi.setDescrizione(intervento.getDescrizione());

		ViewInterventi.setConfermaBtnTxt("Conferma");
	}


	private void setInfoInUpdateConf(String idConferenza) {

		conferenza = conferenzaDAO.getConferenza(idConferenza);
		collocazione = collocazioneDAO.getCollocazione(conferenza.getId());

		ViewGestione.setLbl("Modifica " + conferenza.getNome());
		ViewGestione.setNome(conferenza.getNome());
		setDate();
        ViewGestione.setDescrizione(conferenza.getDescrizione());
        ViewGestione.setSede(collocazione.getSede());
        ViewGestione.setRegione(collocazione.getRegione());
        setTema();
    }

	private void setDate() {

    	ViewGestione.getDataInizioCB().setDay(conferenza.getDataInizio().get(Calendar.DATE));
		ViewGestione.getDataInizioCB().setMonth(conferenza.getDataInizio().get(Calendar.MONTH));
		ViewGestione.getDataInizioCB().setYear(conferenza.getDataInizio().get(Calendar.YEAR));

		ViewGestione.getDataFineCB().setDay(conferenza.getDataFine().get(Calendar.DATE));
		ViewGestione.getDataFineCB().setMonth(conferenza.getDataFine().get(Calendar.MONTH));
		ViewGestione.getDataFineCB().setYear(conferenza.getDataFine().get(Calendar.YEAR));
    }

    private void setTema() {

    	Enumeration<AbstractButton> pulsanti = ViewGestione.getButtonGroup().getElements();

        while (pulsanti.hasMoreElements()) {

        	AbstractButton myPulsante = pulsanti.nextElement();

        	if (myPulsante.getText().equals(conferenza.getTema())) {

        		myPulsante.setSelected(true);
        		break;
        	}
        }
    }


    public void addModSessioneInfo(ArrayList<ModSessionePanel> sessionePanels) {

    	int n = 1;

		for (Sessione s : sessioneDAO.getSessioni(ViewGestione.getId())) {

			ModSessionePanel sPanel = new ModSessionePanel(this);

			setSessioneDate(sPanel, s);
			sPanel.setSessioneLbl("Sessione " + n);
			sPanel.setKeynoteSpeaker(s.getKeynoteSpeaker());
			sPanel.setCoordinatore(s.getCoordinatore());
			sPanel.setIdSessione(s.getId());
			sPanel.setLocazione(s.getLocazione());
			sPanel.setNInterventi(addModIntervento(s.getId(), sPanel));
			sessionePanels.add(sPanel);
			n ++;
		}
	}
    
    private void setSessioneDate(ModSessionePanel sessionePanel, Sessione sessione) {

    	sessionePanel.getDataInizioCB().setDay(sessione.getDataInizio().get(Calendar.DATE));
    	sessionePanel.getDataInizioCB().setMonth(sessione.getDataInizio().get(Calendar.MONTH));
    	sessionePanel.getDataInizioCB().setYear(sessione.getDataInizio().get(Calendar.YEAR));

    	sessionePanel.getDataFineCB().setDay(sessione.getDataFine().get(Calendar.DATE));
    	sessionePanel.getDataFineCB().setMonth(sessione.getDataFine().get(Calendar.MONTH));
    	sessionePanel.getDataFineCB().setYear(sessione.getDataFine().get(Calendar.YEAR));
    }

	private int addModIntervento(String idSessione, ModSessionePanel sessionePanel) {
		
		int n = 0;

		for (Intervento i : interventoDAO.getInterventi(idSessione)) {

			ModInterventoPanel iPanel = new ModInterventoPanel(i.getId());

			iPanel.setInterventoLbl("Intervento " + (n + 1));
			iPanel.add(new InfoInterventoLbl(t.timeFormat(i.getOraInizio().getTime()) + " - " + t.timeFormat(i.getOraFine().getTime()), ""));
			iPanel.add(new DescrizioneTextPane(i.getDescrizione()));

			for (Partecipante p : partecipanteDAO.getPartecipanti(i.getId())) {
				iPanel.add(new InfoInterventoLbl(p.getNome() + " " + p.getCognome(), ""));
			}

			sessionePanel.getInterventi().add(iPanel);
			sessionePanel.getInterventiPanel().add(iPanel);
			n ++;
		}

		return n;
	}

	public void modificaInterventi(String idSessione) throws EmptyFieldException, DateTimeException {

		if (ViewInterventi.getDescrizione().isEmpty()) {

			throw new EmptyFieldException();

		} else {

			checkOrario();
			createIntervento(idSessione, ViewModifica2.getCurrentIntervento() + 1);
			ViewInterventi.dispose();

			for (String p : ViewInterventi.getPartecipanti()) {

				ViewModifica2.getInterventi().get(ViewModifica2.getCurrentIntervento()).add(new InfoModLbl(p));
			}

			ViewModifica2.getInterventi().get(ViewModifica2.getCurrentIntervento()).revalidate();
		}
	}

	public void modificaSessione(ArrayList<ModSessionePanel> modSessioniPanels) {

		for (ModSessionePanel s : modSessioniPanels) {

			queryModificaSessioni += "UPDATE sessione SET ";
			queryModificaSessioni += "data_inizio = '" + s.getDataInizioCB().getAAMMGG() + "', ";
			queryModificaSessioni += "data_fine = '" + s.getDataFineCB().getAAMMGG() + "', ";
			queryModificaSessioni += "coordinatore = '" + s.getCoordinatore() + "', ";
			queryModificaSessioni += "keynote_speaker = '" + s.getKeynoteSpeaker() + "', ";
			queryModificaSessioni += "locazione = '"+ s.getLocazione() + "' ";
			queryModificaSessioni += "WHERE id_sessione = " + s.getIdSessione() + "; ";
		}

		sessioneDAO.updateSessione(queryModificaSessioni);
    }




//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//	 									 Controllo Rimozione Conferenza
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void goToRisultati3() {

		ViewRisultati = new RisultatiRicercaFrame(this);

		for (Conferenza c : conferenzaDAO.getConferenze()) {

			ViewRisultati.getRisultatiPanel().add(new ConfBtn(this, c.getNome(), c.getTema(), c.getId(), "Rimozione"));
		}

		ViewRisultati.showLayer("ResultsScroller");

		ViewMain.setVisible(false);
		ViewRisultati.setVisible(true);
	}

	public void goToRimozione(String idConferenza) {

		ViewRisultati.dispose();
		ViewConferenza = new ConferenzaFrame(idConferenza, this);
		ViewConferenza.showLayer("Rimuovi");
		addInfoConferenza(idConferenza);
	    setTopicColor(ViewConferenza.getNorthPanel().getTemaLbl().getText(), ViewConferenza.getNorthPanel().getNomeLbl());
        setTopicColor(ViewConferenza.getNorthPanel().getTemaLbl().getText(), ViewConferenza.getNorthPanel().getTemaLbl());
	    ViewConferenza.showInfo();
		ViewConferenza.setVisible(true);
	}

	public void confermaRimozione(String idConferenza) {

		conferenzaDAO.deleteConferenza(idConferenza);
		ViewConferenza.dispose();
		ViewMain.setVisible(true);
		JOptionPane.showMessageDialog(ViewInfo, "Rimozione effettuata.", "", JOptionPane.INFORMATION_MESSAGE);
	}




//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
//												 Utils function
//+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

	public void setTextNull(JTextComponent txtCom, int grandezzaFont) {

		txtCom.setText("");
		txtCom.setFont(t.myFont(grandezzaFont));
		txtCom.setForeground(t.tangaroa);
	}


	private void checkCorrectDate(Calendar DataInizio, Calendar DataFine) throws DateTimeException {

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

			case "Medicina": 	  com.setForeground(new Color(250, 88, 80));
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

			default:	com.setForeground(new Color(140, 141, 142));
				break;
		}
	}


	private String addApostrofi(String string) {

		String newString = "";
		
        for (char c : string.toCharArray()) {

        	if (c == '\'') { newString += c + "'"; }
        	
        	else { newString += c; }
        }

        return newString;
    }

	private String cut2(String query) { return query.substring(0, query.length() - 2); }
}