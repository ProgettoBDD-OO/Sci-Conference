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
import myTools.JConfBtn;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MainFrame extends JFrame {
	
	private WestPanel SxPanel;
	private CentrPanel CtrPanel;
	private EastPanel DxPanel;
	private ControllerLink controllerLink;
	private Controller controller;
	private Utente UtenteLoggato;
	
	public MainFrame(String Titolo, ControllerLink contrLink, Controller contr) {
		
		controllerLink = contrLink;
		controller = contr;
		UtenteLoggato = new Utente();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400, 800);
		setLocationRelativeTo(null);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(null);
		MainPanel.setBackground(new Color(255, 255, 255));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		
		
//_______________________________________________________________Panello Sinistro
		
		SxPanel = new WestPanel();
		
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
			
			controller.addConferenze(SxPanel);
			
			for (JConfBtn cBtn : getSxPanel().getArrayConfBtns()) {
				cBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						controllerLink.goToConferenza("MainFrame", ((JConfBtn)e.getSource()).getText());
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
			
		MainPanel.add(CtrPanel, BorderLayout.CENTER);
		
		
//_______________________________________________________________Panello Destro
		   
		DxPanel = new EastPanel();
		DxPanel.getResearchBar().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) { controllerLink.goToRisultati(); }
			}
		});
		
			DxPanel.getAddIdeaBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.goToBacheca();
				}
			});
		
			DxPanel.getFilterBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DxPanel.getFilterBtn().setEnabled(false);
					controllerLink.goToFiltri();
				}
			});
		
		
			DxPanel.getResearchBar().addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					controller.setTextNull(DxPanel);
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