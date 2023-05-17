package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import GUI.ConferenzaFrame.SessionePanel;
import linker.Controller;
import myTools.JLblButton;
import myTools.PanelSlide;
import myTools.myTemplates;
import myTools.PanelSlide.AnimateType;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class AggiuntaConfFrame2 extends JFrame {
	
	Controller controller;
	
	myTemplates t = new myTemplates();
	private Integer[] n = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	
	private JLabel EntiLbl;
	private JComboBox<Integer> NumeroEnti;
	private JScrollPane EntiScroller;
	private JPanel EntiConteiner;
	private ArrayList<String> Enti;
	
	private JLabel SponsorLbl;
	private JComboBox<Integer> NumeroSponsor;
	private JScrollPane SponsorScroller;
	private JPanel SponsorConteiner;
	
	private JComboBox<Integer> NumeroSessioni;
	private ArrayList<SessionePanel> Sessioni;
	private PanelSlide SessioniSlider;
	private JPanel foooooooJPanel;
	private int currentSession;
	private JLblButton BackBtn;
	private JLblButton NextBtn;
	
	private JLabel OrganizzatoriLbl;
	private JPanel OrganizzatoriConteiner;
	

	private JComboBox<Integer> NumeroOrganizzatori;

	private JButton AnnullaBtn;
	private JButton ConfermaBtn;

	
	public AggiuntaConfFrame2(String Titolo, Controller c) {
		
		myTemplates t = new myTemplates();
		
		controller = c;
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 950);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(t.MiniLogo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(246, 247, 248));
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
			JLabel AddConfLbl = new JLabel("Aggiungi le altre informazioni");
			AddConfLbl.setForeground(t.gray);
			AddConfLbl.setFont(t.myFont(28));
			AddConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
			AddConfLbl.setPreferredSize(new Dimension(46, 100));
			MainPanel.add(AddConfLbl, BorderLayout.NORTH);
			
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(new Color(255, 255, 255));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("fill", "[grow]", "[][::30px][::30px][][::30px][::30px][::250px]"));
				
				
				Sessioni = new ArrayList<SessionePanel>();
			
			
			
			JPanel EntiSponsorConteiner = new JPanel();
			EntiSponsorConteiner.setBackground(new Color(255, 255, 255));
			CentrPanel.add(EntiSponsorConteiner, "cell 0 0,grow");
			EntiSponsorConteiner.setLayout(new MigLayout("wrap, fill", "[][]", "[::30px][::30px][]"));
			
				Enti = new ArrayList<String>();
				
				EntiLbl = new JLabel("Enti (seleziona il numero)");
				EntiLbl.setForeground(t.scBlue);
				EntiLbl.setFont(t.myFont(18));
				EntiSponsorConteiner.add(EntiLbl, "cell 0 0,alignx center,aligny top");
				
				NumeroEnti = new JComboBox<Integer>();
				NumeroEnti.setPreferredSize(new Dimension(100, 22));
				NumeroEnti.setModel(new DefaultComboBoxModel<Integer>(n));
				EntiSponsorConteiner.add(NumeroEnti, "cell 0 1,alignx center,aligny top");
				NumeroEnti.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						controller.goToEnti();
					}
				});
				
				EntiScroller = new JScrollPane();
				EntiScroller.setBorder(null);
				EntiSponsorConteiner.add(EntiScroller, "cell 0 2, grow");
				
				EntiConteiner = new JPanel();
				EntiConteiner.setMaximumSize(new Dimension(32767, 125));
				EntiConteiner.setBackground(new Color(255, 255, 255));
				EntiScroller.setViewportView(EntiConteiner);
				EntiConteiner.setLayout(new BoxLayout(EntiConteiner, BoxLayout.Y_AXIS));
				
				
				SponsorLbl = new JLabel("Sponsor (seleziona il numero)");
				SponsorLbl.setForeground(t.scBlue);
				EntiSponsorConteiner.add(SponsorLbl, "cell 1 0,alignx center,aligny top");
				SponsorLbl.setFont(t.myFont(18));
				
				NumeroSponsor = new JComboBox<Integer>();
				NumeroSponsor.setPreferredSize(new Dimension(100, 22));
				NumeroSponsor.setModel(new DefaultComboBoxModel<Integer>(n));
				EntiSponsorConteiner.add(NumeroSponsor, "cell 1 1,alignx center,aligny top");
				NumeroSponsor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						controller.goToSponsor();
					}
				});
				
				SponsorScroller = new JScrollPane();
				SponsorScroller.setBorder(null);
				EntiSponsorConteiner.add(SponsorScroller, "cell 1 2,grow");
				
				SponsorConteiner = new JPanel();
				SponsorConteiner.setMaximumSize(new Dimension(32767, 125));
				SponsorConteiner.setBackground(new Color(255, 255, 255));
				SponsorScroller.setViewportView(SponsorConteiner);
				SponsorConteiner.setLayout(new BoxLayout(SponsorConteiner, BoxLayout.Y_AXIS));
				
				
				
			OrganizzatoriLbl = new JLabel("Organizzatori");
			OrganizzatoriLbl.setForeground(t.scBlue);
			OrganizzatoriLbl.setFont(t.myFont(18));
			CentrPanel.add(OrganizzatoriLbl, "cell 0 1,alignx left,aligny center");
				
			NumeroOrganizzatori = new JComboBox<Integer>();
			NumeroOrganizzatori.setEnabled(false);
			NumeroOrganizzatori.setPreferredSize(new Dimension(100, 22));
			NumeroOrganizzatori.setFont(new Font("Tahoma", Font.PLAIN, 12));
			NumeroOrganizzatori.setModel(new DefaultComboBoxModel<Integer>(n));
			CentrPanel.add(NumeroOrganizzatori, "cell 0 2,alignx left,aligny top");
			NumeroOrganizzatori.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
						controller.goToOrganizzatori();
					}
				});
							
			OrganizzatoriConteiner = new JPanel();
			OrganizzatoriConteiner.setBackground(new Color(255, 255, 255));
			OrganizzatoriConteiner.setLayout(new GridLayout(4, 3, 0, 0));
			CentrPanel.add(OrganizzatoriConteiner, "cell 0 3,grow");
						
						
			JLabel SessioniLbl = new JLabel("Sessioni (seleziona il numero)");
			SessioniLbl.setForeground(t.scBlue);
			SessioniLbl.setFont(t.myFont(18));
			CentrPanel.add(SessioniLbl, "cell 0 4,alignx left,aligny center");
						
			NumeroSessioni = new JComboBox<Integer>();
			NumeroSessioni.setPreferredSize(new Dimension(100, 22));
			NumeroSessioni.setModel(new DefaultComboBoxModel<Integer>(n));
			CentrPanel.add(NumeroSessioni, "cell 0 5,alignx left,aligny top");
			NumeroSessioni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.goToSessioni();
				}
			});
							
							
			foooooooJPanel = new JPanel();
			foooooooJPanel.setPreferredSize(new Dimension(10, 350));
			foooooooJPanel.setBackground(new Color(255, 255, 255));
			foooooooJPanel.setLayout(new BorderLayout(0, 0));
			CentrPanel.add(foooooooJPanel, "cell 0 6,grow");
							
				JLabel ProgrammaLbl = new JLabel("Elenco Sessioni");
				ProgrammaLbl.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
				ProgrammaLbl.setForeground(new Color(0, 0, 200));
				ProgrammaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
				ProgrammaLbl.setHorizontalAlignment(SwingConstants.CENTER);
				ProgrammaLbl.setPreferredSize(new Dimension(46, 50));
				foooooooJPanel.add(ProgrammaLbl, BorderLayout.NORTH);
								
				SessioniSlider = new PanelSlide();
				SessioniSlider.setBackground(new Color(255, 255, 255));
				SessioniSlider.show(new JLabel(), AnimateType.TO_RIGHT);
				foooooooJPanel.add(SessioniSlider, BorderLayout.CENTER);
								
				BackBtn = new JLblButton(new Color(0, 0, 200), "Indietro");
				BackBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				BackBtn.setPreferredSize(new Dimension(75, 19));
				BackBtn.setEnabled(false);
				foooooooJPanel.add(BackBtn, BorderLayout.WEST);
				BackBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						currentSession --;
						if (currentSession == 0) { BackBtn.setEnabled(false); } 
						
						NextBtn.setEnabled(true);
						
						SessioniSlider.show(Sessioni .get(currentSession), AnimateType.TO_RIGHT);
					}
				});
			
				NextBtn = new JLblButton(new Color(0, 0, 200), "Avanti");
				NextBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				NextBtn.setPreferredSize(new Dimension(75, 19));
				NextBtn.setEnabled(false);
				foooooooJPanel.add(NextBtn, BorderLayout.EAST);
				NextBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						currentSession ++;						
						BackBtn.setEnabled(true); 
						
						if (Sessioni.size() - 1 == currentSession) { NextBtn.setEnabled(false); }
						SessioniSlider.show(Sessioni .get(currentSession), AnimateType.TO_LEFT);
					}
				});
				
			
			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(t.lGray);
			SouthPanel.setPreferredSize(new Dimension(10, 80));
			SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
			
				AnnullaBtn = new JButton("Annulla");
				AnnullaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				AnnullaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
				AnnullaBtn.setPreferredSize(new Dimension(150, 35));
				SouthPanel.add(AnnullaBtn, "cell 0 0,alignx right,aligny bottom");
				AnnullaBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						controller.backFromAggiunta2();
					}
				});
				
				ConfermaBtn = new JButton("Inserisci Conferenza");
				ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				ConfermaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
				ConfermaBtn.setForeground(t.white);
				ConfermaBtn.setBackground(t.scBlue);
				ConfermaBtn.setPreferredSize(new Dimension(150, 35));
				SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny bottom");
				ConfermaBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.confermaAggiunta();
					}
				});
	}
	
	public PanelSlide getSessioniSlider() { return SessioniSlider; }
	
    public ArrayList<SessionePanel> getSessioni() { return Sessioni; }
    
    public JLblButton getNextBtn() { return NextBtn; }
	
	
    public JComboBox<Integer> getnEnti() { return NumeroEnti; }
    
    public JPanel getEntiConteiner() { return EntiConteiner; }
    
    public ArrayList<String> getEnti(){ return Enti; }
    
    
    public JComboBox<Integer> getnSponsor() { return NumeroSponsor; }
    
    public JPanel getSponsorConteiner() { return SponsorConteiner; }

    
    public JComboBox<Integer> getNumeroOrganizzatori() { return NumeroOrganizzatori; }
    
    public JPanel getOrganizzatoriConteiner() { return OrganizzatoriConteiner; }
    
    
    public JComboBox<Integer> getNumeroSessioni() { return NumeroSessioni; }
    
    
    public boolean fieldsAreEmpty() {
    	
    	if (EntiConteiner.getComponents().length == 0 || SponsorConteiner.getComponents().length == 0 
    	|| OrganizzatoriConteiner.getComponents().length == 0 || getSessioni().isEmpty()) {
			
    		return true;
			
		} else { return false; }
    }
}
