package GUI.AdminFrames;

import linker.Controller;
import GUI.ConferenzaFrame.SessionePanel;
import myTools.JLblButton;
import myTools.PanelSlide;
import myTools.myTemplates;
import myTools.PanelSlide.AnimateType;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;


public class Aggiunta2Frame extends JFrame {
	
	Controller controller;
	
	myTemplates t = new myTemplates();
	private Integer[] n = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	
	private JLabel EntiLbl;
	private JComboBox<Integer> EntiComboBox;
	private JScrollPane EntiScroller;
	private JPanel EntiConteiner;
	private ArrayList<String> Enti;
	
	private JLabel SponsorLbl;
	private JPanel SponsorConteiner;
	private JComboBox<Integer> SponsorComboBox;
	private JScrollPane SponsorScroller;
	
	private JLabel OrganizzatoriLbl;
	private JPanel OrganizzatoriConteiner;
	private JComboBox<Integer> OrganizzatoriComboBox;

	private JPanel SessioniConteiner;
	private JComboBox<Integer> SessioniComboBox;
	private ArrayList<SessionePanel> Sessioni;
	private PanelSlide SessioniSlider;
	private int currentSession;
	private JLblButton BackBtn;
	private JLblButton NextBtn;
	
	private BackFromAggiunta2Btn IndietroBtn;
	private ConfermaAggiuntaConfBtn ConfermaBtn;

	
	public Aggiunta2Frame(Controller c) {
		
		controller = c;
		
		setTitle("Sci-Conference - Aggiunta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 950);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(t.miniLogo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
			JLabel AddConfLbl = new JLabel("Aggiungi le altre informazioni");
			AddConfLbl.setForeground(t.gray);
			AddConfLbl.setFont(t.myFont(28));
			AddConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
			AddConfLbl.setPreferredSize(new Dimension(46, 100));
			MainPanel.add(AddConfLbl, BorderLayout.NORTH);
			
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(t.white);
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("fill", "[grow]", "[][::30px][::30px][][::30px][::30px][::250px]"));
				
			
			JPanel EntiSponsorConteiner = new JPanel();
			EntiSponsorConteiner.setBackground(t.white);
			CentrPanel.add(EntiSponsorConteiner, "cell 0 0,grow");
			EntiSponsorConteiner.setLayout(new MigLayout("wrap, fill", "[][]", "[::30px][::30px][]"));
			
				Enti = new ArrayList<String>();
				
				EntiLbl = new JLabel("Enti (seleziona il numero)");
				EntiLbl.setForeground(t.scBlue);
				EntiLbl.setFont(t.myFont(18));
				EntiSponsorConteiner.add(EntiLbl, "cell 0 0,alignx center,aligny top");
				
				EntiComboBox = new JComboBox<Integer>();
				EntiComboBox.setPreferredSize(new Dimension(100, 22));
				EntiComboBox.setModel(new DefaultComboBoxModel<Integer>(n));
				EntiSponsorConteiner.add(EntiComboBox, "cell 0 1,alignx center,aligny top");
				EntiComboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						controller.goToEnti();
					}
				});
				
				EntiScroller = new JScrollPane();
				EntiScroller.setBorder(null);
				EntiSponsorConteiner.add(EntiScroller, "cell 0 2, grow");
				
				EntiConteiner = new JPanel();
				EntiConteiner.setMaximumSize(new Dimension(32767, 100));
				EntiConteiner.setBackground(t.white);
				EntiScroller.setViewportView(EntiConteiner);
				EntiConteiner.setLayout(new BoxLayout(EntiConteiner, BoxLayout.Y_AXIS));
				
				SponsorLbl = new JLabel("Sponsor (seleziona il numero)");
				SponsorLbl.setForeground(t.scBlue);
				EntiSponsorConteiner.add(SponsorLbl, "cell 1 0,alignx center,aligny top");
				SponsorLbl.setFont(t.myFont(18));
				
				SponsorComboBox = new JComboBox<Integer>();
				SponsorComboBox.setPreferredSize(new Dimension(100, 22));
				SponsorComboBox.setModel(new DefaultComboBoxModel<Integer>(n));
				EntiSponsorConteiner.add(SponsorComboBox, "cell 1 1,alignx center,aligny top");
				SponsorComboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						controller.goToSponsor();
					}
				});
				
				SponsorScroller = new JScrollPane();
				SponsorScroller.setBorder(null);
				EntiSponsorConteiner.add(SponsorScroller, "cell 1 2,grow");
				
				SponsorConteiner = new JPanel();
				SponsorConteiner.setMaximumSize(new Dimension(32767, 100));
				SponsorConteiner.setBackground(t.white);
				SponsorScroller.setViewportView(SponsorConteiner);
				SponsorConteiner.setLayout(new BoxLayout(SponsorConteiner, BoxLayout.Y_AXIS));
				
				
			OrganizzatoriLbl = new JLabel("Organizzatori");
			OrganizzatoriLbl.setForeground(t.scBlue);
			OrganizzatoriLbl.setFont(t.myFont(18));
			CentrPanel.add(OrganizzatoriLbl, "cell 0 1,alignx left,aligny center");
				
			OrganizzatoriComboBox = new JComboBox<Integer>();
			OrganizzatoriComboBox.setEnabled(false);
			OrganizzatoriComboBox.setPreferredSize(new Dimension(100, 22));
			OrganizzatoriComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
			OrganizzatoriComboBox.setModel(new DefaultComboBoxModel<Integer>(n));
			CentrPanel.add(OrganizzatoriComboBox, "cell 0 2,alignx left,aligny top");
			OrganizzatoriComboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
						controller.goToOrganizzatori();
					}
				});
							
			OrganizzatoriConteiner = new JPanel();
			OrganizzatoriConteiner.setBackground(t.white);
			OrganizzatoriConteiner.setLayout(new GridLayout(4, 3, 0, 0));
			CentrPanel.add(OrganizzatoriConteiner, "cell 0 3,grow");
						
			
			Sessioni = new ArrayList<SessionePanel>();
						
			JLabel SessioniLbl = new JLabel("Sessioni (seleziona il numero)");
			SessioniLbl.setForeground(t.scBlue);
			SessioniLbl.setFont(t.myFont(18));
			CentrPanel.add(SessioniLbl, "cell 0 4,alignx left,aligny center");
						
			SessioniComboBox = new JComboBox<Integer>();
			SessioniComboBox.setPreferredSize(new Dimension(100, 22));
			SessioniComboBox.setModel(new DefaultComboBoxModel<Integer>(n));
			CentrPanel.add(SessioniComboBox, "cell 0 5,alignx left,aligny top");
			SessioniComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.goToSessioni();
				}
			});
			
			
			SessioniConteiner = new JPanel();
			SessioniConteiner.setPreferredSize(new Dimension(10, 350));
			SessioniConteiner.setBackground(t.white);
			SessioniConteiner.setLayout(new BorderLayout(0, 0));
			CentrPanel.add(SessioniConteiner, "cell 0 6,grow");
							
				JLabel ProgrammaLbl = new JLabel("Elenco Sessioni");
				ProgrammaLbl.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
				ProgrammaLbl.setForeground(t.scBlue);
				ProgrammaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
				ProgrammaLbl.setHorizontalAlignment(SwingConstants.CENTER);
				ProgrammaLbl.setPreferredSize(new Dimension(46, 50));
				SessioniConteiner.add(ProgrammaLbl, BorderLayout.NORTH);
								
				SessioniSlider = new PanelSlide();
				SessioniSlider.setBackground(t.white);
				SessioniSlider.show(new JLabel(), AnimateType.TO_RIGHT);
				SessioniConteiner.add(SessioniSlider, BorderLayout.CENTER);
								
				BackBtn = new JLblButton(t.scBlue, "Indietro");
				BackBtn.setEnabled(false);
				BackBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				BackBtn.setPreferredSize(new Dimension(75, 19));
				SessioniConteiner.add(BackBtn, BorderLayout.WEST);
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
				SessioniConteiner.add(NextBtn, BorderLayout.EAST);
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
			
				IndietroBtn = new BackFromAggiunta2Btn(controller);
				SouthPanel.add(IndietroBtn, "cell 0 0,alignx right,aligny bottom");
				
				ConfermaBtn = new ConfermaAggiuntaConfBtn(controller);
				SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny bottom");
	}
	
    public JComboBox<Integer> getnEnti() { return EntiComboBox; }
    
    public JPanel getEntiConteiner() { return EntiConteiner; }
    
    public ArrayList<String> getEnti(){ return Enti; }
    
    
    public JComboBox<Integer> getnSponsor() { return SponsorComboBox; }
    
    public JPanel getSponsorConteiner() { return SponsorConteiner; }

    
    public JComboBox<Integer> getNumeroOrganizzatori() { return OrganizzatoriComboBox; }
    
    public JPanel getOrganizzatoriConteiner() { return OrganizzatoriConteiner; }
    
    
    public JComboBox<Integer> getNumeroSessioni() { return SessioniComboBox; }

	public PanelSlide getSessioniSlider() { return SessioniSlider; }
	
    public ArrayList<SessionePanel> getSessioni() { return Sessioni; }
    
    public JLblButton getNextBtn() { return NextBtn; }
	
    
    public boolean fieldsAreEmpty() {
    	
    	if (EntiConteiner.getComponents().length == 0 || SponsorConteiner.getComponents().length == 0 
    	|| OrganizzatoriConteiner.getComponents().length == 0 || getSessioni().isEmpty()) {
			
    		return true;
			
		} else { return false; }
    }
}
