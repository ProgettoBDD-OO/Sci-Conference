package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;

import myTools.DateComboBox;
import myTools.myRadioBtn;
import myTools.myTemplates;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import linker.ControllerLink;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;

public class AggiuntaConfFrame1 extends JFrame {
	
	ControllerLink controllerLink;
	
	myTemplates t = new myTemplates();
	private ButtonGroup buttonGroup;
	
	
	private String[] Regioni = {"Valle d'Aosta", "Piemonte", "Liguria", "Lombardia", "Trentino-Alto Adige", "Veneto", 
								"Friuli-Venezia Giulia", "Emilia-Romagna", "Toscana", "Umbria", "Marche", "Lazio", 
								"Abruzzo", "Molise", "Campania", "Puglia", "Basilicata", "Calabria", "Sicilia", "Sardegna"};
	private JTextField NomeFld;
	private DateComboBox DataInizio;
	private DateComboBox DataFine;
	private JTextArea DescrizioneFld;
	
	private JTextField SedeFld;
	private JComboBox<String> Regione;
	
	
	
	private JButton AnnullaBtn;
	private JButton ConfermaBtn;
	
	public AggiuntaConfFrame1(String Titolo, ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
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
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::30px]30[::80px]30[::60px]30[::20px][]30[::35px][::200px]"));
				
				NomeFld = new JTextField();
				NomeFld.setText("Nome");
				NomeFld.setFont(t.myFont(16));
				NomeFld.setForeground(t.scBlue);
				NomeFld.setPreferredSize(new Dimension(7, 25));
				NomeFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
				CentrPanel.add(NomeFld, "cell 0 0,alignx left,aligny center");
				NomeFld.setColumns(30);
				
				
				JPanel DatePanel = new JPanel();
				DatePanel.setBackground(new Color(255, 255, 255));
				CentrPanel.add(DatePanel, "cell 0 1,grow");
				DatePanel.setLayout(new MigLayout("wrap, fill", "[][]", "[][]"));
				
					JLabel DataInizioLbl = new JLabel("Data inizio");
					DataInizioLbl.setFont(t.myFont(16));
					DataInizioLbl.setForeground(t.scBlue);
					DatePanel.add(DataInizioLbl, "cell 0 0,alignx center,aligny bottom");
					
					JLabel DataFineLbl = new JLabel("Data fine");
					DataFineLbl.setFont(t.myFont(16));
					DataFineLbl.setForeground(t.scBlue);
					DatePanel.add(DataFineLbl, "cell 1 0,alignx center,aligny bottom");
					
					DataInizio = new DateComboBox();	
					DatePanel.add(DataInizio, "cell 0 1 , alignx center, aligny center");
					
					DataFine = new DateComboBox();	
					DatePanel.add(DataFine, "cell 1 1 , alignx center, aligny center");
				
				DescrizioneFld = new JTextArea();
				DescrizioneFld.setFont(t.myFont(16));
				DescrizioneFld.setText("Descrizione");
				DescrizioneFld.setForeground(t.scBlue);
				DescrizioneFld.setLineWrap(true);
				DescrizioneFld.setPreferredSize(new Dimension(400, 22));
				DescrizioneFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
				CentrPanel.add(DescrizioneFld, "flowx,cell 0 2,alignx left,growy");
				
				
				JLabel TemaLbl = new JLabel("Tema");
				TemaLbl.setForeground(t.scBlue);
				TemaLbl.setFont(t.myFont(16));
				CentrPanel.add(TemaLbl, "cell 0 3,alignx left,aligny bottom");
				
					buttonGroup = new ButtonGroup();
							
							JPanel TemiPanel = new JPanel();
							TemiPanel.setBackground(new Color(255, 255, 255));
							CentrPanel.add(TemiPanel, "cell 0 4,grow");
							TemiPanel.setLayout(new MigLayout("wrap, fill", "[][][]", "[][][][]"));
							
							myRadioBtn TemaAmbienteLbl = new myRadioBtn("Ambiente", new Color(0, 200, 0), 14);
							buttonGroup.add(TemaAmbienteLbl);
							TemiPanel.add(TemaAmbienteLbl, "cell 0 0, alignx left, aligny center");
							
							myRadioBtn TemaChimicaLbl = new myRadioBtn("Chimica", new Color(0, 200, 255), 14);
							buttonGroup.add(TemaChimicaLbl);
							TemiPanel.add(TemaChimicaLbl, "cell 1 0, alignx left, aligny center");
							
							myRadioBtn TemaBiologiaLbl = new myRadioBtn("Biologia", new Color(0, 128, 0), 14);
							buttonGroup.add(TemaBiologiaLbl);
							TemiPanel.add(TemaBiologiaLbl, "cell 2 0, alignx left, aligny center");
							
							myRadioBtn TemaSostenibilitàLbl = new myRadioBtn("Sostenibilità", new Color(240, 210, 0), 14);
							buttonGroup.add(TemaSostenibilitàLbl);
							TemiPanel.add(TemaSostenibilitàLbl, "cell 0 1, alignx left, aligny center");
							
							myRadioBtn TemaInformaticaLbl = new myRadioBtn("Informatica", new Color(0, 100, 255), 14);
							buttonGroup.add(TemaInformaticaLbl);
							TemiPanel.add(TemaInformaticaLbl, "cell 1 1, alignx left,aligny center");
							
							myRadioBtn TemaAnatomiaLbl = new myRadioBtn("Anatomia", new Color(250, 88, 80), 14);
							buttonGroup.add(TemaAnatomiaLbl);
							TemiPanel.add(TemaAnatomiaLbl, "cell 2 1, alignx left,aligny center");
							
							myRadioBtn TemaFisicaLbl = new myRadioBtn("Fisica", new Color(250, 80, 0), 14);
							buttonGroup.add(TemaFisicaLbl);
							TemiPanel.add(TemaFisicaLbl, "cell 0 2, alignx left, aligny center");
							
							myRadioBtn TemaMatematicaLbl = new myRadioBtn("Matematica", t.scBlue, 14);
							buttonGroup.add(TemaMatematicaLbl);
							TemiPanel.add(TemaMatematicaLbl, "cell 1 2, alignx left, aligny center");
							
							myRadioBtn TemaPsicologiaLbl = new myRadioBtn("Psicologia", new Color(255, 0, 128), 14);
							buttonGroup.add(TemaPsicologiaLbl);
							TemiPanel.add(TemaPsicologiaLbl, "cell 2 2, alignx left, aligny center");
							TemaPsicologiaLbl.setActionCommand("Psicologia");
							
							myRadioBtn TemaGeologiaLbl = new myRadioBtn("Geologia", new Color(180, 100, 40), 14);
							buttonGroup.add(TemaGeologiaLbl);
							TemiPanel.add(TemaGeologiaLbl, "cell 0 3, alignx left, aligny center");
							
							myRadioBtn TemaAstrologiaLbl = new myRadioBtn("Astrologia", new Color(30, 30, 120), 14);
							buttonGroup.add(TemaAstrologiaLbl);
							TemiPanel.add(TemaAstrologiaLbl, "cell 1 3, alignx left, aligny center");
							
							myRadioBtn TemaAltroLbl = new myRadioBtn("Altro", t.altGray, 14);
							buttonGroup.add(TemaAltroLbl);
							TemiPanel.add(TemaAltroLbl, "cell 2 3, alignx left, aligny center");
						
							JLabel CollocazioneLbl = new JLabel("Collocazione");
							CentrPanel.add(CollocazioneLbl, "cell 0 5,alignx center,aligny center");
							CollocazioneLbl.setForeground(t.scBlue);
							CollocazioneLbl.setFont(t.myFont(16));
							
							JPanel CollocazioneConteiner = new JPanel();
							CentrPanel.add(CollocazioneConteiner, "cell 0 6,grow");
							CollocazioneConteiner.setBackground(new Color(255, 255, 255));
							CollocazioneConteiner.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
							
							SedeFld = new JTextField();
							SedeFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
							SedeFld.setFont(new Font("Tahoma", Font.ITALIC, 12));
							SedeFld.setForeground(t.gray);
							SedeFld.setText("Sede");
							CollocazioneConteiner.add(SedeFld, "cell 0 0,grow");
							SedeFld.setColumns(10);
							
							Regione = new JComboBox<String>();
							CollocazioneConteiner.add(Regione, "cell 1 0,grow");
							Regione.setFont(new Font("Tahoma", Font.PLAIN, 12));
							Regione.setModel(new DefaultComboBoxModel<String>(Regioni));
					
					
				
						
				JPanel SouthPanel = new JPanel();
				SouthPanel.setBackground(t.lGray);
				SouthPanel.setPreferredSize(new Dimension(10, 80));
				MainPanel.add(SouthPanel, BorderLayout.SOUTH);
				SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
				
					AnnullaBtn = new JButton("Annulla");
					AnnullaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					AnnullaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
					AnnullaBtn.setPreferredSize(new Dimension(150, 35));
					AnnullaBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controllerLink.backFromAggiuntaConf();
						}
					});
					SouthPanel.add(AnnullaBtn, "cell 0 0,alignx right,aligny bottom");
					
					ConfermaBtn = new JButton("Conferma\r\n");
					ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					ConfermaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
					ConfermaBtn.setForeground(t.white);
					ConfermaBtn.setBackground(t.scBlue);
					ConfermaBtn.setPreferredSize(new Dimension(150, 35));
					ConfermaBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//controllerLink.confermaBacheca();
						}
					});
					SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny bottom");
	}
	
    public String getNomeTxt() { return NomeFld.getText(); }

    public String getDataInizio() { return DataInizio.getGGMMAA(); }

    public String getDataFine() { return DataFine.getGGMMAA(); }

    public String getDescrizioneTxt() { return DescrizioneFld.getText(); }

    public ButtonGroup getButtonGroup() { return buttonGroup; }
    
    public String getSedeTxt() { return SedeFld.getText(); }
    
    public String getRegioneTxt() { return ((String)Regione.getSelectedItem()); }
    
    
    
}