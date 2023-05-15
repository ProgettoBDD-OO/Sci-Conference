package GUI.ConferenzaFrame;

import linker.Controller;
import myTools.myTemplates;
import myTools.PanelSlide;
import myTools.PanelSlide.AnimateType;
import myTools.JLblButton;

import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;


public class ConferenzaFrame extends JFrame {
	
	private Controller controller;
	
	private myTemplates t = new myTemplates();
	private String framePrecedente = "";
	
	private String IdConferenza;
	private JLabel NomeLbl;
	private JLabel TemaLbl;
	private JLabel DataInizioLbl;
	private JLabel SpazioLbl;
	private JLabel DataFineLbl;
	private JLabel DescrizioneLbl;
	private JLabel CollocazioneLbl;
	
	private JPanel CentrPanel;
	private ArrayList<SessionePanel> SessioniPanels;
	private int n = 0;
	private JLblButton BackBtn;
	private JLblButton NextBtn;
	
	private JPanel EntiConteiner;
	private JPanel SponsorConteiner;
	private JPanel OrganizzatoriConteiner;
	
	private OrganizzatoreInfo oiPanel;
	private JPopupMenu popupMenu;
	
	private JButton IndietroBtn;
	private CardLayout IscrizioneCardLayout;
	private JPanel IscrizioneCardPanel;
	private JButton IscrivitiBtn;
	
	public ConferenzaFrame(String idConferenza, String Titolo, Controller c) {
		
		IdConferenza = idConferenza;
		controller = c;
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(250, 251, 252));
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
			JPanel NorthPanel = new JPanel();
			NorthPanel.setBorder(new EmptyBorder(25, 0, 25, 0));
			NorthPanel.setBackground(new Color(250, 251, 252));
			NorthPanel.setPreferredSize(new Dimension(10, 275));
			MainPanel.add(NorthPanel, BorderLayout.NORTH);
			NorthPanel.setLayout(new BorderLayout(0, 0));
			
				NomeLbl = new JLabel("Titolo");
				NomeLbl.setPreferredSize(new Dimension(26, 60));
				NorthPanel.add(NomeLbl, BorderLayout.NORTH);
				NomeLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
				NomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
				NomeLbl.setFont(new Font("Calibri Light", Font.PLAIN, 34));
				
				JPanel NorthCentrPanel = new JPanel();
				NorthCentrPanel.setBackground(new Color(250, 251, 252));
				NorthPanel.add(NorthCentrPanel, BorderLayout.CENTER);
				NorthCentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][][]"));
				
					TemaLbl = new JLabel("Tema");
					TemaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
					NorthCentrPanel.add(TemaLbl, "cell 0 0,alignx center,aligny center");
					
					JPanel DatePanel = new JPanel();
					NorthCentrPanel.add(DatePanel, "cell 0 1,grow");
					DatePanel.setBackground(new Color(250, 251, 252));
					DatePanel.setLayout(new MigLayout("wrap, fill", "[][::15px][]", "[]"));
			
					DataInizioLbl = new JLabel("Data Inizio");
					DataInizioLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
					DatePanel.add(DataInizioLbl, "cell 0 0,alignx right,aligny center");
					
					SpazioLbl = new JLabel("-");
					SpazioLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
					DatePanel.add(SpazioLbl, "cell 1 0,alignx center,aligny center");
					
					DataFineLbl = new JLabel("Data Fine");
					DataFineLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
					DatePanel.add(DataFineLbl, "cell 2 0,alignx left,aligny center");
					
					CollocazioneLbl = new JLabel("Collocazione");
					CollocazioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 22));
					NorthCentrPanel.add(CollocazioneLbl, "cell 0 2,alignx center,aligny center");
					
					DescrizioneLbl = new JLabel("Descrizione");
					DescrizioneLbl.setHorizontalAlignment(SwingConstants.CENTER);
					DescrizioneLbl.setPreferredSize(new Dimension(54, 50));
					DescrizioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
					DescrizioneLbl.setBackground(new Color(250, 251, 252));
					NorthPanel.add(DescrizioneLbl, BorderLayout.SOUTH);
					
				
			CentrPanel = new JPanel();
			CentrPanel.setBackground(new Color(255, 255, 255));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new BorderLayout(0, 0));
			
				JLabel ProgrammaLbl = new JLabel("Programma");
				ProgrammaLbl.setBorder(new MatteBorder(1, 0, 0, 0, new Color(192, 192, 192)));
				ProgrammaLbl.setForeground(new Color(0, 0, 200));
				ProgrammaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
				ProgrammaLbl.setHorizontalAlignment(SwingConstants.CENTER);
				ProgrammaLbl.setPreferredSize(new Dimension(46, 50));
				CentrPanel.add(ProgrammaLbl, BorderLayout.NORTH);
				
				PanelSlide SessioniSlider = new PanelSlide();
				SessioniSlider.setBackground(new Color(255, 255, 255));
				CentrPanel.add(SessioniSlider, BorderLayout.CENTER);
				System.out.println(IdConferenza);
				
				SessioniPanels = new ArrayList<SessionePanel>();
				controller.addSessioniPanel(IdConferenza, SessioniPanels);
				SessioniSlider.show(SessioniPanels.get(n), AnimateType.TO_RIGHT);
				
				BackBtn = new JLblButton(new Color(0, 0, 200), "Indietro");
				BackBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				BackBtn.setPreferredSize(new Dimension(75, 19));
				BackBtn.setEnabled(false);
				CentrPanel.add(BackBtn, BorderLayout.WEST);
				BackBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						n --;
						if (n == 0) { BackBtn.setEnabled(false); } 
						
						else { NextBtn.setEnabled(true); }
						
						SessioniSlider.show(SessioniPanels.get(n), AnimateType.TO_RIGHT);
					}
				});
				
				NextBtn = new JLblButton(new Color(0, 0, 200), "Avanti");
				NextBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				NextBtn.setPreferredSize(new Dimension(75, 19));
				CentrPanel.add(NextBtn, BorderLayout.EAST);
				NextBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						n ++;						
						BackBtn.setEnabled(true); 
						
						if (SessioniPanels.size() - 1 == n) { NextBtn.setEnabled(false); }
						
						SessioniSlider.show(SessioniPanels.get(n), AnimateType.TO_LEFT);
					}
				});
				
				
				JPanel NextInfoPanel = new JPanel();
				NextInfoPanel.setPreferredSize(new Dimension(10, 175));
				CentrPanel.add(NextInfoPanel, BorderLayout.SOUTH);
				NextInfoPanel.setLayout(new BorderLayout(0, 0));
				
				JPanel EntiPanel = new JPanel();
				EntiPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
				EntiPanel.setBackground(new Color(250, 251, 252));
				EntiPanel.setPreferredSize(new Dimension(225, 10));
				NextInfoPanel.add(EntiPanel, BorderLayout.WEST);
				EntiPanel.setLayout(new BorderLayout(0, 0));
				
				JLabel EntiLbl = new JLabel("Enti");
				EntiLbl.setFont(new Font("Calibri Light", Font.PLAIN, 22));
				EntiLbl.setHorizontalAlignment(SwingConstants.CENTER);
				EntiLbl.setPreferredSize(new Dimension(18, 30));
				EntiPanel.add(EntiLbl, BorderLayout.NORTH);
				
				JScrollPane EntiScroller = new JScrollPane();
				EntiScroller.setBorder(null);
				EntiPanel.add(EntiScroller, BorderLayout.CENTER);
				
				EntiConteiner = new JPanel();
				EntiConteiner.setBackground(new Color(250, 251, 252));
				EntiScroller.setViewportView(EntiConteiner);
				EntiConteiner.setLayout(new BoxLayout(EntiConteiner, BoxLayout.Y_AXIS));
				
				JPanel SponsorPanel = new JPanel();
				SponsorPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
				SponsorPanel.setBackground(new Color(250, 251, 252));
				SponsorPanel.setPreferredSize(new Dimension(225, 10));
				NextInfoPanel.add(SponsorPanel, BorderLayout.EAST);
				SponsorPanel.setLayout(new BorderLayout(0, 0));
				
				JLabel SponsorLbl = new JLabel("Sponsor");
				SponsorLbl.setFont(new Font("Calibri Light", Font.PLAIN, 22));
				SponsorLbl.setHorizontalAlignment(SwingConstants.CENTER);
				SponsorLbl.setPreferredSize(new Dimension(18, 30));
				SponsorPanel.add(SponsorLbl, BorderLayout.NORTH);
				
				JScrollPane SponsorScroller = new JScrollPane();
				SponsorScroller.setBorder(new EmptyBorder(0, 0, 0, 0));
				SponsorPanel.add(SponsorScroller, BorderLayout.CENTER);
				
				SponsorConteiner = new JPanel();
				SponsorConteiner.setBackground(new Color(250, 251, 252));
				SponsorScroller.setViewportView(SponsorConteiner);
				SponsorConteiner.setLayout(new BoxLayout(SponsorConteiner, BoxLayout.Y_AXIS)); 
				
				JPanel OrganizzatoriPanel = new JPanel();
				OrganizzatoriPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
				OrganizzatoriPanel.setBackground(new Color(250, 251, 252));
				NextInfoPanel.add(OrganizzatoriPanel, BorderLayout.CENTER);
				OrganizzatoriPanel.setLayout(new BorderLayout(0, 0));
				
				JLabel ComitatoLbl = new JLabel("Comitato");
				ComitatoLbl.setBackground(new Color(250, 251, 252));
				ComitatoLbl.setPreferredSize(new Dimension(64, 30));
				ComitatoLbl.setHorizontalAlignment(SwingConstants.CENTER);
				ComitatoLbl.setFont(new Font("Calibri Light", Font.PLAIN, 22));
				OrganizzatoriPanel.add(ComitatoLbl, BorderLayout.NORTH);
				
				JScrollPane OrganizzatoriScroller = new JScrollPane();
				OrganizzatoriScroller.setBorder(null);
				OrganizzatoriPanel.add(OrganizzatoriScroller, BorderLayout.CENTER);
				
				OrganizzatoriConteiner = new JPanel();
				OrganizzatoriConteiner.setBackground(new Color(250, 251, 252));
				OrganizzatoriScroller.setViewportView(OrganizzatoriConteiner);
				OrganizzatoriConteiner.setLayout(new BoxLayout(OrganizzatoriConteiner, BoxLayout.Y_AXIS));
			
				oiPanel = new OrganizzatoreInfo(40);
				oiPanel.setPreferredSize(new Dimension(332, 90));
				popupMenu = new JPopupMenu();
				popupMenu.add(oiPanel);
				
				
			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(new Color(246, 247, 248));
			SouthPanel.setPreferredSize(new Dimension(10, 50));
			SouthPanel.setLayout(new MigLayout("wrap, fill", "[][grow]", "[grow]"));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
				
					IndietroBtn = new JButton("Indietro");
					IndietroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					IndietroBtn.setPreferredSize(new Dimension(150, 30));
					IndietroBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
					SouthPanel.add(IndietroBtn, "cell 0 0,alignx left,growy");
					IndietroBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controller.backFromConferenza(framePrecedente);
						}
					});
					
					IscrizioneCardLayout = new CardLayout(0, 0);
					
					IscrizioneCardPanel = new JPanel();
					IscrizioneCardPanel.setBackground(new Color(246, 247, 248));
					SouthPanel.add(IscrizioneCardPanel, "cell 1 0,grow");
					IscrizioneCardPanel.setLayout(IscrizioneCardLayout);
					
					JPanel IscrivitiBtnConteiner = new JPanel();
					IscrivitiBtnConteiner.setBackground(new Color(246, 247, 248));
					IscrizioneCardPanel.add(IscrivitiBtnConteiner, "Iscrizione");
					IscrivitiBtnConteiner.setLayout(new BorderLayout(0, 0));
					
					IscrivitiBtn = new JButton("Iscriviti");
					IscrivitiBtnConteiner.add(IscrivitiBtn, BorderLayout.EAST);
					IscrivitiBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					IscrivitiBtn.setForeground(new Color(255, 255, 255));
					IscrivitiBtn.setBackground(new Color(0, 0, 200));
					IscrivitiBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
					IscrivitiBtn.setPreferredSize(new Dimension(150, 30));
					
					IscrivitiBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controller.goToIscrizione();
						}
					});
					
					JLabel GiàIscrittoLbl = new JLabel("Sei gia iscritto a questa conferenza");
					GiàIscrittoLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					GiàIscrittoLbl.setHorizontalAlignment(SwingConstants.RIGHT);
					GiàIscrittoLbl.setBackground(new Color(246, 247, 248));
					IscrizioneCardPanel.add(GiàIscrittoLbl, "GiàIscritto");
					
					JPanel RimuoviBtnConteiner = new JPanel();
					RimuoviBtnConteiner.setBackground(new Color(246, 247, 248));
					RimuoviBtnConteiner.setLayout(new BorderLayout(0, 0));
					IscrizioneCardPanel.add(RimuoviBtnConteiner, "Rimuovi");
					
					JButton RimuoviBtn = new JButton("Rimuovi");
					RimuoviBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					RimuoviBtn.setForeground(new Color(255, 255, 255));
					RimuoviBtn.setBackground(new Color(255, 0, 0));
					RimuoviBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
					RimuoviBtn.setPreferredSize(new Dimension(150, 30));
					RimuoviBtnConteiner.add(RimuoviBtn, BorderLayout.EAST);
	}
	
	public String getFramePrecedente() { return framePrecedente; }
	
	public void setFramePrecedente(String frame) { framePrecedente = frame; }
	
	public String getId() { return IdConferenza; }
	
	public JLabel getNomeLbl() { return NomeLbl; }
	
	public void setNome(String nome) { NomeLbl.setText(nome); }
	
	public JLabel getTemaLbl() { return TemaLbl; }
	
	public void setTema(String tema) { TemaLbl.setText(tema); }
	
	public void setDataInizio(String dataInizio) { DataInizioLbl.setText(dataInizio); }
	
	public void setDataFine(String dataFine) { DataFineLbl.setText(dataFine); }
	
	public void setDescrizione(String descrizione) { DescrizioneLbl.setText(descrizione); }
	
	
	public JPanel getEntiConteiner() { return EntiConteiner; }
	
	public JPanel getSponsorConteiner() { return SponsorConteiner; }
	
	public JPanel getOrganizzatoriConteiner() { return OrganizzatoriConteiner; }
	
	
	public ArrayList<SessionePanel> getSessioniPanels(){ return SessioniPanels; }
	
	
	public JButton getIndietroBtn() { return IndietroBtn; }
	
	public void showLayer(String layer) { IscrizioneCardLayout.show(IscrizioneCardPanel, layer); }
	
	public JPanel getIscrizioneCardPanel() { return IscrizioneCardPanel; }
	
	
	public void foo() {
		
		for (Component l : OrganizzatoriConteiner.getComponents()) {
			l.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					showMenu(e);
					controller.addOrganizzatoreInfo(oiPanel, ((InfoLbl) l).getId());
				}
				@Override
				public void mouseExited(MouseEvent e) {
					popupMenu.setVisible(false);
				}
				private void showMenu(MouseEvent e) {
					popupMenu.setLocation(OrganizzatoriConteiner.getLocationOnScreen().x, l.getLocationOnScreen().y + 30);
					popupMenu.setVisible(true);
				}
			});
		}
	}
}