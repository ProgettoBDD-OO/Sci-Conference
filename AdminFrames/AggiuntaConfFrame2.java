package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import linker.ControllerLink;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;

public class AggiuntaConfFrame2 extends JFrame {
	
	ControllerLink controllerLink;
	
	myTemplates t = new myTemplates();
	private Integer[] n = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	
	private JLabel EntiLbl;
	private JComboBox<Integer> NumeroEnti;
	private ArrayList<String> Enti;
	
	private JLabel SponsorLbl;
	private JComboBox<Integer> NumeroSponsor;
	private ArrayList<String> Sponsor;
	
	private JComboBox<Integer> NumeroSessioni;
	private JComboBox<Integer> NumeroOrganizzatori;
	
	private JLabel OrganizzatoriLbl;

	
	public AggiuntaConfFrame2(String Titolo, ControllerLink contrLink) {
		
		
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 1000);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(246, 247, 248));
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
			JLabel AddConfLbl = new JLabel("Aggiungi una conferenza");
			AddConfLbl.setForeground(t.gray);
			AddConfLbl.setFont(t.myFont(28));
			AddConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
			AddConfLbl.setPreferredSize(new Dimension(46, 100));
			MainPanel.add(AddConfLbl, BorderLayout.NORTH);
			
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(new Color(255, 255, 255));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new BoxLayout(CentrPanel, BoxLayout.Y_AXIS));
		
		JPanel EntiSponsorConteiner = new JPanel();
		CentrPanel.add(EntiSponsorConteiner);
		EntiSponsorConteiner.setBackground(new Color(255, 255, 255));
		EntiSponsorConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[][][][]"));
		
			Enti = new ArrayList<String>();
		
			EntiLbl = new JLabel("Enti (seleziona il numero)");
			EntiLbl.setForeground(t.scBlue);
			EntiSponsorConteiner.add(EntiLbl, "cell 0 0,alignx center,aligny bottom");
			EntiLbl.setFont(t.myFont(16));
			
			NumeroEnti = new JComboBox<Integer>();
			EntiSponsorConteiner.add(NumeroEnti, "cell 0 1,grow");
			NumeroEnti.setModel(new DefaultComboBoxModel<Integer>(n));
			NumeroEnti.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					controllerLink.goToEnti();
				}
			});
			
			
			SponsorLbl = new JLabel("Sponsor (seleziona il numero)");
			SponsorLbl.setForeground(t.scBlue);
			EntiSponsorConteiner.add(SponsorLbl, "cell 0 2,alignx center,aligny bottom");
			SponsorLbl.setFont(t.myFont(16));
				
			NumeroSponsor = new JComboBox<Integer>();
			NumeroSponsor.setModel(new DefaultComboBoxModel<Integer>(n));
			EntiSponsorConteiner.add(NumeroSponsor, "cell 0 3,grow");	
			NumeroSponsor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					controllerLink.goToSponsor();
				}
			});
			
			
	JPanel Conteiner2 = new JPanel();
	Conteiner2.setBackground(new Color(255, 255, 255));
	CentrPanel.add(Conteiner2);
	Conteiner2.setLayout(new BoxLayout(Conteiner2, BoxLayout.X_AXIS));
			
		JPanel SessioneConteiner = new JPanel();
		SessioneConteiner.setBackground(new Color(255, 255, 255));
		Conteiner2.add(SessioneConteiner);
		SessioneConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[::50px][]"));
			
			JLabel SessioniLbl = new JLabel("Sessioni (seleziona il numero)");
			SessioniLbl.setForeground(t.scBlue);
			SessioniLbl.setPreferredSize(new Dimension(139, 50));
			SessioniLbl.setFont(t.myFont(16));
			SessioniLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
			SessioneConteiner.add(SessioniLbl, "cell 0 0,alignx center,aligny center");
			
			NumeroSessioni = new JComboBox<Integer>();
			SessioneConteiner.add(NumeroSessioni, "flowx,cell 0 1,growx,aligny top");
			
		JPanel ComitatoConteiner = new JPanel();
		ComitatoConteiner.setBackground(new Color(255, 255, 255));
		Conteiner2.add(ComitatoConteiner);
		ComitatoConteiner.setLayout(new MigLayout("wrap, fill", "[grow]", "[::50px][]"));
			
			OrganizzatoriLbl = new JLabel("Organizzatori");
			OrganizzatoriLbl.setForeground(t.scBlue);
			OrganizzatoriLbl.setFont(t.myFont(16));
			ComitatoConteiner.add(OrganizzatoriLbl, "cell 0 0,alignx center,aligny center");
			
			NumeroOrganizzatori = new JComboBox<Integer>();
			NumeroOrganizzatori.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					controllerLink.goToOrganizzatori();
				}
			});
			NumeroOrganizzatori.setFont(new Font("Tahoma", Font.PLAIN, 12));
			NumeroOrganizzatori.setModel(new DefaultComboBoxModel<Integer>(n));
			ComitatoConteiner.add(NumeroOrganizzatori, "cell 0 1,growx,aligny top");
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
