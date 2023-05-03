package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import linker.ControllerLink;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;

public class AggiuntaConfFrame2 extends JFrame {
	
	ControllerLink controllerLink;
	
	myTemplates t = new myTemplates();
	private Integer[] n = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
	
	private JLabel EntiLbl;
	private JComboBox<Integer> NumeroEnti;
	private ArrayList<String> Enti;
	
	private JLabel SponsorLbl;
	private JComboBox<Integer> NumeroSponsor;
	private ArrayList<String> Sponsor;
	
	private JComboBox<Integer> NumeroSessioni;
	private JComboBox<Integer> NumeroOrganizzatori;
	
	private JLabel OrganizzatoriLbl;
	
	private JButton AnnullaBtn;
	private JButton ConfermaBtn;

	
	public AggiuntaConfFrame2(String Titolo, ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 900);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
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
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::30px][::30px][grow][][][grow][][][grow][][][grow]"));
		
			JLabel SessioniLbl = new JLabel("Sessioni (seleziona il numero)");
			SessioniLbl.setForeground(t.scBlue);
			SessioniLbl.setFont(t.myFont(18));
			CentrPanel.add(SessioniLbl, "cell 0 0,alignx left,aligny center");
			
			NumeroSessioni = new JComboBox<Integer>();
			NumeroSessioni.setPreferredSize(new Dimension(100, 22));
			NumeroSessioni.setModel(new DefaultComboBoxModel<Integer>(n));
			CentrPanel.add(NumeroSessioni, "flowx,cell 0 1,alignx left,aligny top");
			NumeroSessioni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.goToSessioni();
				}
			});
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			CentrPanel.add(scrollPane, "cell 0 2,grow");
			
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 255));
				scrollPane.setViewportView(panel);
			
			
			Enti = new ArrayList<String>();
		
			EntiLbl = new JLabel("Enti (seleziona il numero)");
			EntiLbl.setForeground(t.scBlue);
			EntiLbl.setFont(t.myFont(18));
			CentrPanel.add(EntiLbl, "cell 0 3,alignx left,aligny bottom");
			
			NumeroEnti = new JComboBox<Integer>();
			NumeroEnti.setPreferredSize(new Dimension(100, 22));
			NumeroEnti.setModel(new DefaultComboBoxModel<Integer>(n));
			CentrPanel.add(NumeroEnti, "cell 0 4,alignx left,growy");
			NumeroEnti.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					controllerLink.goToEnti();
				}
			});
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBorder(null);
			CentrPanel.add(scrollPane_1, "cell 0 5,grow");
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			scrollPane_1.setViewportView(panel_1);
			
			
			Sponsor = new ArrayList<String>();
			
			SponsorLbl = new JLabel("Sponsor (seleziona il numero)");
			SponsorLbl.setForeground(t.scBlue);
			CentrPanel.add(SponsorLbl, "cell 0 6,alignx left,aligny bottom");
			SponsorLbl.setFont(t.myFont(18));
				
			NumeroSponsor = new JComboBox<Integer>();
			NumeroSponsor.setPreferredSize(new Dimension(100, 22));
			NumeroSponsor.setModel(new DefaultComboBoxModel<Integer>(n));
			CentrPanel.add(NumeroSponsor, "cell 0 7,alignx left,growy");	
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBorder(null);
			CentrPanel.add(scrollPane_2, "cell 0 8,grow");
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(255, 255, 255));
			scrollPane_2.setViewportView(panel_2);
			NumeroSponsor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					controllerLink.goToSponsor();
				}
			});
			
			
			OrganizzatoriLbl = new JLabel("Organizzatori");
			OrganizzatoriLbl.setForeground(t.scBlue);
			OrganizzatoriLbl.setFont(t.myFont(18));
			CentrPanel.add(OrganizzatoriLbl, "cell 0 9,alignx left,aligny center");
			
			NumeroOrganizzatori = new JComboBox<Integer>();
			NumeroOrganizzatori.setPreferredSize(new Dimension(100, 22));
			NumeroOrganizzatori.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					controllerLink.goToOrganizzatori();
				}
			});
			NumeroOrganizzatori.setFont(new Font("Tahoma", Font.PLAIN, 12));
			NumeroOrganizzatori.setModel(new DefaultComboBoxModel<Integer>(n));
			CentrPanel.add(NumeroOrganizzatori, "cell 0 10,alignx left,aligny top");
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBorder(null);
			CentrPanel.add(scrollPane_3, "cell 0 11,grow");
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(255, 255, 255));
			scrollPane_3.setViewportView(panel_3);
			
			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(t.lGray);
			SouthPanel.setPreferredSize(new Dimension(10, 80));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
			SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
			
				AnnullaBtn = new JButton("Annulla");
				AnnullaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				AnnullaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
				AnnullaBtn.setPreferredSize(new Dimension(150, 35));
				SouthPanel.add(AnnullaBtn, "cell 0 0,alignx right,aligny bottom");
				AnnullaBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						controllerLink.backFromAggiuntaConf2();
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
						controllerLink.confermaAggiunta();
					}
				});
	}
	
	public JLabel getEntiLbl() { return EntiLbl; }
    
    public int getNumeroEnti() { return NumeroEnti.getSelectedIndex(); }
    
    public ArrayList<String> getEnti(){ return Enti; }
    
    public JLabel getSponsorLbl() { return SponsorLbl; }
    
    public int getNumeroSponsor() { return NumeroSponsor.getSelectedIndex(); }
    
    public ArrayList<String> getSponsor() { return Sponsor; }
    

    public JComboBox<Integer> getNumeroSessioni() { return NumeroSessioni; }
    
    
    public JLabel getOrganizzatoriLbl() { return OrganizzatoriLbl; }

    public JComboBox<Integer> getNumeroOrganizzatori() { return NumeroOrganizzatori; }
}
