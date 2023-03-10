package Logica;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import GUI.CommentoBachecaFrame;
import GUI.InfoConferenzaFrame;
import GUI.JLblButton;
import GUI.LogInFrame;
import GUI.MainFrame;
import GUI.RisultatiRicercaFrame;
import GUI.SignUpFrame;
import GUI.CalendarFrame.CalendarMainFrame;

public class Controller {
	private MainFrame View;
	private CommentoBachecaFrame ViewCommentoBacheca;
	private CalendarMainFrame ViewCalendario;
	private LogInFrame ViewLogIn; 
	private SignUpFrame ViewSignUp;
	private InfoConferenzaFrame ViewInfo;
	private RisultatiRicercaFrame ViewRisultati;
	private boolean accessoAdmin = false;
	private Calendar DataConferenza = Calendar.getInstance() ;
	Connessione database = new Connessione();
	
	private String framePrecedente = "";
	
	private ArrayList<JLblButton> ArrayLblButton = new ArrayList<JLblButton>();
	

    public Controller(MainFrame Vista, CommentoBachecaFrame VistaCB, CalendarMainFrame VistaC, LogInFrame VistaL, SignUpFrame VistaS, 
    		          InfoConferenzaFrame VistaI, RisultatiRicercaFrame VistaR) {
    	
        this.View = Vista;
        this.ViewCommentoBacheca = VistaCB;
        this.ViewCalendario = VistaC;
        this.ViewLogIn = VistaL;
        this.ViewSignUp = VistaS;
        this.ViewInfo = VistaI;
        this.ViewRisultati = VistaR;
    
        
    	database.connetti();
    	
    	ActionListener gestoreCommentoBacheca;
    	ActionListener gestoreIndietroCommento;
    	
    	ActionListener gestoreCalendario;
    	ActionListener gestoreIndietroCalendario;
    	
    	ActionListener gestoreLogIn;
    	ActionListener gestoreAnnullaLogInBtn;
    	ActionListener gestoreConfermaLogInBtn;
    	ActionListener gestoreSignUpSwitchBtn;

    	
    	ActionListener gestoreSignUp;
    	ActionListener gestoreConfermaSignUpBtn;
    	ActionListener gestoreAnnullaSignUpBtn;
    	ActionListener gestoreLogInSwitchBtn; 
    	
    	MouseAdapter gestoreResearchBar;
    	
    	ActionListener gestoreInfoConferenze;
    	ActionListener gestoreIndietroInfoConferenze;
    	
    	ActionListener gestoreRisultati;
    	ActionListener gestoreIndietroRisultati;
    	
//_____________________________________________Preparazione arrayList delle conferenze 
    	
    	 String select = "SELECT nome,datainizio FROM conferenza_scientifica";
         int N = 0;
         ArrayLblButton = new ArrayList<JLblButton>();
         
         try {

             PreparedStatement statement = database.getConnection().prepareStatement(select);
             ResultSet rs = statement.executeQuery();
             
             while(rs.next()) {
             	
             	DataConferenza.setTime(rs.getDate(2));
                 
                 switch (DataConferenza.get(Calendar.MONTH)) {

                     case 1:
                         ArrayLblButton.add(new JLblButton(rs.getString(1)));
                         View.getMese1Panel().add(ArrayLblButton.get(N));
                         N++;
                         break;

                     case 2:
                         ArrayLblButton.add(new JLblButton(rs.getString(1)));
                         View.getMese2Panel().add(ArrayLblButton.get(N));
                         N++;                      
                         break;

                     case 3:
                     	ArrayLblButton.add(new JLblButton(rs.getString(1)));
                         View.getMese3Panel().add(ArrayLblButton.get(N));
                         N++;                        
                         break;                   

                       }
                } 
             } catch (Exception e) {
             e.printStackTrace();
         };
    	
   
    	
//_____________________________________________Passaggio da MainFrame a CommentoBachecaFrame
    	
    	gestoreCommentoBacheca = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				View.setVisible(false);
				ViewCommentoBacheca.setVisible(true);
			}
		};
		
		View.getAddIdeaBtn().addActionListener(gestoreCommentoBacheca);
    	
		
//_____________________________________________Ritorno a MainFrame da CommentoBachecaFrame
		
		gestoreIndietroCommento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCommentoBacheca.setVisible(false);
				View.setVisible(true);
				
			}
		};
    	
    	ViewCommentoBacheca.getIndietroCommentoBachecaBtn().addActionListener(gestoreIndietroCommento);
    	
    	
//_____________________________________________Passaggio da MainFrame a CalendarioFrame
    	
    	gestoreCalendario = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCalendario.setVisible(true);
			}
		};
		
		View.getCalendario().addActionListener(gestoreCalendario);
		View.getSfogliaConfBtn().addActionListener(gestoreCalendario);
		    
		 
//_____________________________________________Passaggio da MainFrame a LogInFrame
		    	
		  gestoreLogIn = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				View.setVisible(false);
				ViewLogIn.setVisible(true);
			}
		};
				
		View.getLogInBtn().addActionListener(gestoreLogIn);    
		View.getAccediBtn().addActionListener(gestoreLogIn);
				
		
//_____________________________________________Ritorno a MainFrame da LogInFrame
				
		gestoreAnnullaLogInBtn = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewLogIn.setVisible(false);
				View.setVisible(true);	
				ViewLogIn.setUsernameEmailNull();
		    	ViewLogIn.setPasswordNullLogIn();
			}
		};
		    	
		ViewLogIn.getAnnullaLogInBtn().addActionListener(gestoreAnnullaLogInBtn);
		
//_____________________________________________Switch da LogInFrame a SignUpFrame	
		
		gestoreSignUpSwitchBtn = new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewLogIn.setVisible(false);
				ViewSignUp.setVisible(true);
				ViewLogIn.setUsernameEmailNull();
				ViewLogIn.setPasswordNullLogIn();
				
			}		
		};
		
		ViewLogIn.getSignUpSwitchBtn().addActionListener(gestoreSignUpSwitchBtn);
		
//_____________________________________________Apertura InfoConferenzaFrame
        
        gestoreInfoConferenze = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (View.isVisible()) {
					View.setVisible(false);
					framePrecedente = "View";
				}
                
				if (ViewRisultati.isVisible()) {
					ViewRisultati.setVisible(false);
					framePrecedente = "ViewRisultati";
				}
				
				ViewInfo.setVisible(true);
				
				String select = "SELECT * FROM conferenza_scientifica WHERE nome = ?";
       		 
                try {
                	
                    PreparedStatement statement = database.getConnection().prepareStatement(select);
                    
                    statement.setString(1,((JLblButton)e.getSource()).getText());
                    
                    ResultSet rs = statement.executeQuery();
                    
                    while(rs.next()) {
                        ViewInfo.getNomeConferenzaLbl().setText(rs.getString(2));
                    	
                    	Date dataInizio = rs.getDate(3);
                    	DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
                    	String data1 = dateFormat1.format(dataInizio);
                    	ViewInfo.getDataInizioLbl().setText(data1);
                    	
                    	Date dataFine = rs.getDate(4);
                    	DateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                    	String data2 = dateFormat2.format(dataFine);
                    	ViewInfo.getDataFineLbl().setText(data2);
                    	
                    	ViewInfo.getDescrizioneLbl().setText(rs.getString(5));
                    	
                    	ViewInfo.getTemaLbl().setText(rs.getString(6));
                    	
                    	switch (rs.getString(6)) {
						
                        case "Ambiente":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(0, 200, 0));
							ViewInfo.getTemaLbl().setForeground(new Color(0, 200, 0));
							break;
						
						case "Anatomia": 
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(250, 88, 80));
							ViewInfo.getTemaLbl().setForeground(new Color(250, 88, 80));
							break;
							
						case "Astronomia":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(30, 30, 120));
							ViewInfo.getTemaLbl().setForeground(new Color(30, 30, 120));
							break;
							
						case "Biologia":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(0, 128, 0));
							ViewInfo.getTemaLbl().setForeground(new Color(0, 128, 0));
							break;
							
						case "Chimica":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(0, 200, 255));
							ViewInfo.getTemaLbl().setForeground(new Color(0, 200, 255));
							break;
							
						case "Fisica":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(250, 80, 0));
							ViewInfo.getTemaLbl().setForeground(new Color(250, 80, 0));
							break;
							
						case "Geologia":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(180, 100, 40));
							ViewInfo.getTemaLbl().setForeground(new Color(180, 100, 40));
							break;
							
						case "Informatica":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(0, 100, 255));
							ViewInfo.getTemaLbl().setForeground(new Color(0, 100, 255));
							break;
							
						case "Matematica":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(0, 0, 200));
							ViewInfo.getTemaLbl().setForeground(new Color(0, 0, 200));
							break;
							
						case "Psicologia":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(255, 0, 128));
							ViewInfo.getTemaLbl().setForeground(new Color(255, 0, 128));
							break;
							
						case "Sostenibilità":
							ViewInfo.getNomeConferenzaLbl().setForeground(new Color(240, 210, 0));
							ViewInfo.getTemaLbl().setForeground(new Color(240, 210, 0));
							break;
			
						default:
							System.out.print("Errore nello switch del tema");
							break;
					}

                    }
                    
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                };
                
            }
        };


        for (int i = 0; i < ArrayLblButton.size(); i++) {
            ArrayLblButton.get(i).addActionListener(gestoreInfoConferenze);
        }
		
		
//_____________________________________________Conferma accesso
		
		gestoreConfermaLogInBtn = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
               String select1 = "SELECT username,email FROM utenti WHERE username = ? OR email = ?";
               String select2 = "SELECT user name,email,password_user,admin_status FROM utenti WHERE (username = ? OR email = ?) AND password_user = ?";
               String select3 = "SELECT nome FROM conferenza_scientifica NATURAL JOIN iscrizioni WHERE email = ? OR email = (SELECT email FROM utenti WHERE username = ?)";
               boolean userEmail = false;
               boolean passwordErrata = true;
               boolean noConferenze = true;
               ArrayLblButton = new ArrayList<JLblButton>();
               int N = 0;
				
				try { 
					
					PreparedStatement statement1 = database.getConnection().prepareStatement(select1);
					
					statement1.setString(1, ViewLogIn.getUsernameEmailTxt());
					statement1.setString(2, ViewLogIn.getUsernameEmailTxt());
					
					ResultSet rs1 = statement1.executeQuery();
					
					while(rs1.next()) {
							userEmail = true;
							ViewLogIn.getUsernameEmail().setBorder(new MatteBorder(1,1,1,1,(Color)new Color(0,0,200)));
							ViewLogIn.getPassword().setBorder(new MatteBorder(1,1,1,1,(Color)new Color(0,0,200)));							
						} 
			
					  }  catch (Exception ex) {
					       ex.printStackTrace();
				}
				
				if(userEmail) {
					
					try {
						
						PreparedStatement statement2 = database.getConnection().prepareStatement(select2);
						
						statement2.setString(1, ViewLogIn.getUsernameEmailTxt());
						statement2.setString(2, ViewLogIn.getUsernameEmailTxt());
						statement2.setString(3, ViewLogIn.getPasswordLogIn());
						
						ResultSet rs2 = statement2.executeQuery();
						
						while(rs2.next()) {
							
							try {
								PreparedStatement statement3 = database.getConnection().prepareStatement(select3);
								
								statement3.setString(1, ViewLogIn.getUsernameEmailTxt());
								statement3.setString(2, ViewLogIn.getUsernameEmailTxt());
								
								ResultSet rs3 = statement3.executeQuery();
								
								while (rs3.next()) {
									noConferenze = false;
									ArrayLblButton.add(new JLblButton(rs3.getString(1)));
									ArrayLblButton.get(N).setAlignmentX(Component.CENTER_ALIGNMENT);
									ArrayLblButton.get(N).setFont(new Font("Tahoma", Font.PLAIN, 18));
									ArrayLblButton.get(N).setBorder(new EmptyBorder(10,0,10,0));
			                        View.getCentrLayer3().add(ArrayLblButton.get(N));
			                        N++;
								}
								
								for (int i = 0; i < ArrayLblButton.size(); i++) {
		    	    	        	ArrayLblButton.get(i).addActionListener(gestoreInfoConferenze);	
		    	    			}
								
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
							ViewLogIn.setUsernameEmailNull();
							ViewLogIn.setPasswordNullLogIn();
							ViewLogIn.getUsernameEmail().setBorder(new MatteBorder(1,1,1,1,(Color)new Color(0,0,200)));
							ViewLogIn.getPassword().setBorder(new MatteBorder(1,1,1,1,(Color)new Color(0,0,200)));
							
							if(noConferenze) {
							    View.getCentrCardLayout().show(View.getCentrCardPanel(),"2");
							} else {
								View.getCentrCardLayout().show(View.getCentrCardPanel(),"3");	
							}
							
								passwordErrata = false;
								ViewLogIn.setVisible(false);
								View.setVisible(true);
								
								if(rs2.getBoolean(4) == true) {
									JOptionPane.showMessageDialog(View,"Log-In avvenuto con successo! \n    Benvenuto amministratore!");
									accessoAdmin = true;
								} else {
								    JOptionPane.showMessageDialog(View,"Log-In avvenuto con successo! \n                 Benvenuto!");
								    accessoAdmin = false;
								}
								
								
							}
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
			     } else {
			    	 ViewLogIn.getUsernameEmail().setBorder(new MatteBorder(1,1,1,1,Color.RED));
			    	 ViewLogIn.setUsernameEmailNull();
			    	 ViewLogIn.setPasswordNullLogIn();
			    	 JOptionPane.showMessageDialog(ViewLogIn,"Username o Email errati o non presenti!","Dati incorretti",JOptionPane.ERROR_MESSAGE); 
			     }
				
				if(passwordErrata && userEmail) {
					ViewLogIn.getPassword().setBorder(new MatteBorder(1,1,1,1,Color.RED));
					ViewLogIn.setPasswordNullLogIn();
					JOptionPane.showMessageDialog(ViewLogIn, "Password errata!","Dati incorretti",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		};
		
		ViewLogIn.getLogInConfermaBtn().addActionListener(gestoreConfermaLogInBtn);
		
		
//_____________________________________________Passaggio da MainFrame a SignUpFrame
    	
		  gestoreSignUp = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				View.setVisible(false);
				ViewSignUp.setVisible(true);
			}
		};
				
		View.getSignUpBtn().addActionListener(gestoreSignUp); 
		View.getRegistratiBtn().addActionListener(gestoreSignUp);
		
		
//_____________________________________________Ritorno a MainFrame da SignUpFrame
		
		gestoreAnnullaSignUpBtn = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewSignUp.setVisible(false);
				View.setVisible(true);
				ViewSignUp.setUsernameNull();
				ViewSignUp.setEmailNull();
				ViewSignUp.setPasswordNull();
				ViewSignUp.setCnfrmPasswordTxtNull();
			}
		};
		    	
		ViewSignUp.getAnnullaSignUpBtn().addActionListener(gestoreAnnullaSignUpBtn);
		
//_____________________________________________Switch da SignUpFrame a LogInFrame		
		
		gestoreLogInSwitchBtn = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewSignUp.setVisible(false);
				ViewLogIn.setVisible(true);
				ViewSignUp.setUsernameNull();
				ViewSignUp.setEmailNull();
				ViewSignUp.setPasswordNull();
				ViewSignUp.setCnfrmPasswordTxtNull();
			}		
		};
		
		ViewSignUp.getLogInSwitchBtn().addActionListener(gestoreLogInSwitchBtn);
		
//_____________________________________________Conferma registrazione
		
	    gestoreConfermaSignUpBtn = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String insert = "INSERT INTO utenti VALUES (?,?,?,?)";
				boolean confermaPassword = true;
				
				if (ViewSignUp.getPassword().equals(ViewSignUp.getCnfrmPasswordTxt())) {
					if (!ViewSignUp.getUsername().equals("") && !ViewSignUp.getEmail().equals("") && !ViewSignUp.getPassword().equals("")) {
						try {

							PreparedStatement statement = database.getConnection().prepareStatement(insert);

							statement.setString(1, ViewSignUp.getUsername());
							statement.setString(2, ViewSignUp.getEmail());
							statement.setString(3, ViewSignUp.getPassword());
							statement.setBoolean(4, false);

							statement.executeUpdate();

						} catch (Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(ViewSignUp, ex.getMessage(), "Dati incorretti",JOptionPane.ERROR_MESSAGE);

						} 
					} else {
						ViewSignUp.getUsernameField().setBorder(new MatteBorder(1,1,1,1,Color.RED));
						ViewSignUp.getEmailField().setBorder(new MatteBorder(1,1,1,1,Color.RED));
						ViewSignUp.getPasswordField().setBorder(new MatteBorder(1,1,1,1,Color.RED));
						ViewSignUp.getCnfrmPasswordField().setBorder(new MatteBorder(1,1,1,1,Color.RED));
						ViewSignUp.setUsernameNull();
						ViewSignUp.setEmailNull();
						ViewSignUp.setPasswordNull();
						ViewSignUp.setCnfrmPasswordTxtNull();
						JOptionPane.showMessageDialog(ViewSignUp, "Inserisci prima tutti i campi!","Dati incorretti",JOptionPane.ERROR_MESSAGE);
						confermaPassword = false;
					}
				} else {
					ViewSignUp.getUsernameField().setBorder(new MatteBorder(1,1,1,1,(Color)new Color(0,0,200)));
					ViewSignUp.getEmailField().setBorder(new MatteBorder(1,1,1,1,(Color)new Color(0,0,200)));
					ViewSignUp.getPasswordField().setBorder(new MatteBorder(1,1,1,1,Color.RED));
					ViewSignUp.getCnfrmPasswordField().setBorder(new MatteBorder(1,1,1,1,Color.RED));
					ViewSignUp.setPasswordNull();
					ViewSignUp.setCnfrmPasswordTxtNull();
					JOptionPane.showMessageDialog(ViewSignUp, "Le password non corrispondono!","Dati incorretti",JOptionPane.ERROR_MESSAGE);
					confermaPassword = false;
				}
				
				if (confermaPassword) {
					ViewSignUp.setVisible(false);
					View.setVisible(true);
					JOptionPane.showMessageDialog(View, "Registrazione effettuata!");
					ViewSignUp.setUsernameNull();
					ViewSignUp.setEmailNull();
					ViewSignUp.setPasswordNull();
					ViewSignUp.setCnfrmPasswordTxtNull();
					ViewSignUp.getPasswordField().setBorder(new MatteBorder(1,1,1,1,(Color)new Color(0,0,200)));
					ViewSignUp.getCnfrmPasswordField().setBorder(new MatteBorder(1,1,1,1,(Color)new Color(0,0,200)));
				}
			}
		};
		
		ViewSignUp.getSignUpConfermaBtn().addActionListener(gestoreConfermaSignUpBtn);
		
//_____________________________________________Pulizia research bar
		
		gestoreResearchBar = new MouseAdapter() {
			   @Override
	            public void mouseClicked(MouseEvent e) {
				    View.getResearchBar().setText("");
	                View.getResearchBar().setFont(new Font("Tahoma", Font.PLAIN, 13));
	                View.getResearchBar().setForeground(new Color(20,40,60));
	            }
		};
		
        View.getResearchBar().addMouseListener(gestoreResearchBar);
        
//_____________________________________________Ritorno a MainFrame/RisultatiFrame da InfoConferenzaFrame    
        
        
        gestoreIndietroInfoConferenze = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(framePrecedente.equals("View")) {
            	   View.setVisible(true);
            	   framePrecedente = "";
               }
               
               if(framePrecedente.equals("ViewRisultati")) {
            	   ViewRisultati.setVisible(true);
            	   framePrecedente = "";
               }
               
               ViewInfo.setVisible(false);
            }
        };

        ViewInfo.getIndietroBtn().addActionListener(gestoreIndietroInfoConferenze);
        
//_____________________________________________Mostra risultati filtro in RisultatiRicercaFrame
        
    	gestoreRisultati = new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				View.setVisible(false);
    				ViewRisultati.setVisible(true);

    				String select = "SELECT nome FROM conferenza_scientifica WHERE tema = ?";
    				int N = 0;

    				try {

    					PreparedStatement statement = database.getConnection().prepareStatement(select);
    			
    					statement.setString(1,((JRadioButtonMenuItem)e.getSource()).getText());

    					ResultSet rs = statement.executeQuery();
    					ArrayList<JLblButton> ArrayLblButton = new ArrayList<JLblButton>();

    					while (rs.next()) {
    						ArrayLblButton.add(new JLblButton(rs.getString(1)));
    		                ViewRisultati.getRisultatiPanel().add(ArrayLblButton.get(N));
    		                N++;
    					}
    					
    					for (int i = 0; i < ArrayLblButton.size(); i++) {
    	    	        	ArrayLblButton.get(i).addActionListener(gestoreInfoConferenze);	
    	    			}

    				} catch (Exception e2) {
    					e2.printStackTrace();
    				}

    			}
    		};
    		
    		for (int i = 0; i < View.getTemiArray().size(); i++) {
                View.getTemiArray().get(i).addActionListener(gestoreRisultati);
            }
    		
//_____________________________________________Passaggio da MainFrame a CommentoBachecaFrame
    		
    		gestoreIndietroRisultati = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ViewRisultati.setVisible(false);
					View.setVisible(true);				
				}
			};
			
			ViewRisultati.getIndietroRisultatiBtn().addActionListener(gestoreIndietroRisultati);
    		
      }
		
    public boolean getAccessoAdmin() {
    	return accessoAdmin;
    }
  
}
    