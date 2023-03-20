package linker;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import DAO.ConferenzaDAO;
import DAO.UtenteDAO;
import DTO.Conferenza;
import DTO.Utente;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.*;

import GUI.InfoConferenzaFrame;
import GUI.InsertPswrdFrame;
import GUI.LogInFrame;
import GUI.SignUpFrame;
import GUI.MainFrame.CentrPanel;
import GUI.MainFrame.EastPanel;
import GUI.MainFrame.MainFrame;
import GUI.MainFrame.WestPanel;
import myTools.DifferentPasswordException;
import myTools.JConfBtn;
import myTools.UserNotFoundException;
import myTools.WrongPasswordException;

public class Controller {
	
	public Controller() {

//_____________________________________________________________Link MainFrame-RisultatiRicercaFrame
	        
//    	MouseListener gestoreRisultati = new MouseAdapter() {
//                @Override
//                public void mousePressed(MouseEvent e) {
//                	ViewMainFrame.setVisible(false);
//                	ViewFiltri.setVisible(false);
//                	ViewRisultati.setVisible(true);
//                    String select = "SELECT nome, data_inizio, tema FROM conferenze_scientifiche WHERE tema = ?";
//                    
//                    int N = 0;
//
//                    try {
//
//                        PreparedStatement statement = DataBase.getConnection().prepareStatement(select);
//                        statement.setString(1, ((JToggleButton)e.getSource()).getText());
//                        System.out.println(((JToggleButton)e.getSource()).getText());
//                        
//                        ResultSet rs = statement.executeQuery();
//                        ArrayList<JConfBtn> arrayConfBtns = new ArrayList<JConfBtn>();
//
//                        while (rs.next()) {
//                            arrayConfBtns.add(new JConfBtn(rs.getString(1) + " - " + rs.getString(2), rs.getString(3)));
//                            arrayConfBtns.get(N).setFont(new Font("Calibri Light", Font.PLAIN, 20));;
//                            arrayConfBtns.get(N).setBorder(new EmptyBorder(5,0,5,0));
//                            ViewRisultati.getRisultatiPanel().add(arrayConfBtns.get(N));
//                            N++;
//                        }
//                        							
////                        for (int i = 0; i < arrayConfBtns.size(); i++) {
////                            arrayConfBtns.get(i).addMouseListener(gestoreInfoConferenze);
////                        }
//
//                    } catch (Exception e2) {
//                        e2.printStackTrace();
//                    }
//                }
//            };
//            
////            for (FilterItem i : ViewFiltri.getArrayFilterItem()) {
////				i.getFilterItemLbl().addMouseListener(gestoreRisultati);
////			} 
    }
	
//_____________________________________________________________Controllo Sign-Up
	
	public void controlloSignUp(SignUpFrame viewSignUp, MainFrame viewMainFrame) throws DifferentPasswordException {
        
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
	
	public void controlloLogIn(LogInFrame viewLogIn, MainFrame viewMainFrame) throws UserNotFoundException, WrongPasswordException {
    	
        UtenteDAO utenteDAO = new UtenteDAO();
        Utente utente = new Utente();
        utente =  utenteDAO.getUtente(viewLogIn.getUsernameEmailTxt());
        
        
		if(utente.getEmail() != null) {
			
			viewLogIn.getUsernameEmailFld().setBorder(new MatteBorder(1,1,1,1, new Color(0,0,200)));
			viewLogIn.getPasswordFld().setBorder(new MatteBorder(1,1,1,1, new Color(0,0,200)));		
			
			if(utenteDAO.checkPassword(utente, viewLogIn.getPasswordTxt())) {							
	
				viewMainFrame.setUtenteLoggato(utente);
				checkUserConf(utente, viewMainFrame.getCtrPanel().getArrayConfBtns(), viewMainFrame.getCtrPanel());
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
	
	
	private void checkUserConf(Utente utente, ArrayList<JConfBtn> arrayConfBtns, CentrPanel ctrPanel) {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		int n = 0;

		if(confDAO.getConferenzeUtente(utente.getEmail()) != null) {
			
			for (Conferenza c : confDAO.getConferenzeUtente(utente.getEmail())) {
				
				arrayConfBtns.add(new JConfBtn(c.getNome(), c.getTema()));
				addUserConf(arrayConfBtns.get(n), ctrPanel, c);
				n++;
			}
			
			ctrPanel.getCentralCardLayout().show(ctrPanel.getCentrCardPanel(),"3");
			
		} else { ctrPanel.getCentralCardLayout().show(ctrPanel.getCentrCardPanel(),"2"); }
	}
	
	
	public void addUserConf(JConfBtn cBtn, CentrPanel ctrPanel, Conferenza c) {
		
		 
		cBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		cBtn.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		cBtn.setBorder(new EmptyBorder(10,0,10,0));
		ctrPanel.getUserConfAfterAccess2().add(cBtn);
	}
	
	
	
	
//_____________________________________________________________Aggiunta Conferenze
	
	public void addInfoConferenze(Utente utente, String nomeConferenza, InfoConferenzaFrame viewConferenza) {
		
		ConferenzaDAO confDAO = new ConferenzaDAO();
		Conferenza conf = new Conferenza();
		conf = confDAO.getConferenza(nomeConferenza);		

		checkIscrizione(utente, conf, confDAO, viewConferenza);
		
        viewConferenza.getNomeConferenzaLbl().setText(conf.getNome());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        viewConferenza.getDataInizioLbl().setText(dateFormat.format(conf.getDataInizio().getTime()));
        viewConferenza.getDataFineLbl().setText(dateFormat.format(conf.getDataFine().getTime()));
                
        viewConferenza.getDescrizioneLbl().setText(conf.getDescrizione());
        viewConferenza.getTemaLbl().setText(conf.getTema());
                
        setTopicColor(conf.getTema(), viewConferenza.getNomeConferenzaLbl());
        setTopicColor(conf.getTema(), viewConferenza.getTemaLbl());
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
	
	private void checkIscrizione(Utente utente, Conferenza conf, ConferenzaDAO confDAO, InfoConferenzaFrame viewInfoConferenza) {
		
		if (confDAO.checkIscrizione(utente.getEmail(), conf.getId())) {
			viewInfoConferenza.getIscrizioneCardLayout().show(viewInfoConferenza.getIscrizioneCardPanel(), "2");
		} 
	}
	
	
//_____________________________________________________________Controllo Iscrizione
	
	public boolean iscrizione(InsertPswrdFrame viewInsertPswrd, Utente utente, Conferenza conf) {
		
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
		int N = 0;
		
		for (Conferenza c : confDAO.getConferenze()) {
			
			switch (c.getDataInizio().get(Calendar.MONTH)) {
        	
			case 2:
				addConfBtn(sxPanel.getArrayConfBtns(), N, sxPanel.getConferenzeMese1(), c);
				N++;
        		break;
        		
			case 3:
				addConfBtn(sxPanel.getArrayConfBtns(), N, sxPanel.getConferenzeMese2(), c);
				N++;
				break;
				
			case 4:
				addConfBtn(sxPanel.getArrayConfBtns(), N, sxPanel.getConferenzeMese3(), c);
				N++;
				break;
			}
		} 	
	}
	
	
	public void addConfBtn(ArrayList<JConfBtn> array, int n, JPanel ConferenzeMeseN, Conferenza conf) {
		
		array.add(new JConfBtn(conf.getNome(), conf.getTema()));
		array.get(n).setFont(new Font("Calibri Light", Font.PLAIN, 17));
		ConferenzeMeseN.add(array.get(n));
	}
	
	
	
	
//_____________________________________________________________Controllo ResearchBar
	
	public void setTextNull(EastPanel dxPanel) {
		
		dxPanel.getResearchBar().setText("");
		dxPanel.getResearchBar().setFont(new Font("Calibri Corpo", Font.PLAIN, 14));
		dxPanel.getResearchBar().setForeground(new Color(20,40,60));
	}
}