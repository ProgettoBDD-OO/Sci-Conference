package GUI.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import DTO.Utente;
import linker.Controller;
import linker.ControllerLink;
import myTools.JLblButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MainFrame extends JFrame {

	private ControllerLink controllerLink;
	
	private WestPanel SxPanel;
	private CentrPanel CtrPanel;
	private EastPanel DxPanel;
	private Controller controller;
	private Utente UtenteLoggato;
	
	public MainFrame(String Titolo, ControllerLink contrLink, Controller contr) {
		
		controllerLink = contrLink;
		controller = contr;
		UtenteLoggato = new Utente();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400, 800);
		setMinimumSize(new Dimension(1200, 700));
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(null);
		MainPanel.setBackground(new Color(255, 255, 255));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		
		
		
//_______________________________________________________________Panello Sinistro
		
		SxPanel = new WestPanel();
		SxPanel.getCalendario().addMouseListener(new MouseAdapter() {
			
		});
		
			controller.addConferenze(SxPanel);
			
			SxPanel.getCalendario().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.goToCalendario();
				}
			});
		
			SxPanel.getSignUpBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.goToSignUp();
				}
			});
	
			SxPanel.getLogInBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.goToLogIn();
				}
			});
			
			
			for (JLblButton lBtn : getSxPanel().getArrayLblButtons()) {
				lBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						controllerLink.goToConferenza("MainFrame", ((JLblButton)e.getSource()).getText());
					}
				});
			}
			
		MainPanel.add(SxPanel, BorderLayout.WEST);
		
		
//_______________________________________________________________Panello Centrale		
		
		CtrPanel = new CentrPanel();
		
			CtrPanel.getRegistratiBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.goToSignUp();
				}
			});
			
			CtrPanel.getAccediBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.goToLogIn();
				}
			});
			
			CtrPanel.getAggiungiConfBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controllerLink.goToAggiuntaConf();
				}
			});
			
		MainPanel.add(CtrPanel, BorderLayout.CENTER);
		
		
//_______________________________________________________________Panello Destro
		   
		DxPanel = new EastPanel();
		
			controller.showLatestConfInBacheca(DxPanel);
		
			DxPanel.getFilterBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DxPanel.getFilterBtn().setEnabled(false);
					controllerLink.goToFiltri();
				}
			});
		
			DxPanel.getResearchBar().addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == 10) { controllerLink.goToRisultati(); }
				}
			});
			
			DxPanel.getResearchBar().addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					controller.setTextNull(DxPanel);
				}
			});
			
			DxPanel.getClearFltrBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controllerLink.resetQuery();
					DxPanel.resetFilterLbl();
					DxPanel.getClearFltrBtn().setVisible(false);
				}
			});
			
			for (JLblButton lBtn : DxPanel.getArrayConfBacheca()) {
				
				lBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						controller.setInfoConfBacheca(DxPanel.getCbPanel(), lBtn.getText());
						showMenu(e);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						DxPanel.getPopupMenu().setVisible(false);
					}
					private void showMenu(MouseEvent e) {
						DxPanel.getPopupMenu().setLocation(DxPanel.getLocationOnScreen().x, lBtn.getLocationOnScreen().y + 50);
						DxPanel.getPopupMenu().setVisible(true);
					}
				});
			}
			
			DxPanel.getAddIdeaBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.goToBacheca();
				}
			});
		
		MainPanel.add(DxPanel, BorderLayout.EAST);
		
		setVisible(true);
	};
	
	
	public WestPanel getSxPanel() { return SxPanel; }
	
	public CentrPanel getCtrPanel() { return CtrPanel; }
	
	public EastPanel getDxPanel() { return DxPanel; }
	
	
	public Utente getUtenteLoggato() { return UtenteLoggato; }
	
	public void setUtenteLoggato(Utente utenteLoggato) { this.UtenteLoggato = utenteLoggato; }
}