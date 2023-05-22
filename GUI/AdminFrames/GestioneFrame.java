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
import java.awt.event.MouseAdapter;
import java.util.Calendar;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import linker.Controller;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseEvent;
import myTools.myTxtFld;
import myTools.TopicSelectionPanel;

public class GestioneFrame extends JFrame {
	
	Controller controller;
	
	myTemplates t = new myTemplates();
	
	private String IdConferenza;
	private JLabel AddConfLbl;
	private myTxtFld NomeFld;
	private DateComboBox DataInizio;
	private DateComboBox DataFine;
	private JTextArea DescrizioneFld;
	
	private Calendar DataInizioC = Calendar.getInstance();
	private Calendar DataFineC = Calendar.getInstance();
	
	private String[] Regioni = {"Piemonte", "Liguria", "Lombardia", "Trentino-Alto Adige", "Veneto", 
			"Friuli-Venezia Giulia", "Val di Aosta", "Emilia-Romagna", "Toscana", "Umbria", "Marche", "Lazio", 
			"Abruzzo", "Molise", "Campania", "Puglia", "Basilicata", "Calabria", "Sicilia", "Sardegna"};
	private myTxtFld SedeFld;
	private JComboBox<String> Regione;
	
	
	private BackFromGestioneBtn IndietroBtn;
	private GoToNextInfoBtn ConfermaBtn;
	private TopicSelectionPanel TemiConteiner;
	
	public GestioneFrame(String idConferenza, String comingFrom, Controller c) {
		
		controller = c;
		IdConferenza = idConferenza;
		
		setTitle("Gestione Conferenza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(t.miniLogo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
			AddConfLbl = new JLabel("Aggiungi una conferenza");
			AddConfLbl.setForeground(t.gray);
			AddConfLbl.setFont(t.myFont(28));
			AddConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
			AddConfLbl.setPreferredSize(new Dimension(46, 100));
			MainPanel.add(AddConfLbl, BorderLayout.NORTH);
			
			
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBorder(new EmptyBorder(10, 5, 10, 5));
			CentrPanel.setBackground(t.white);
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::35px]30[]30[70px:n]30[][]30[][]"));
				
				NomeFld = new myTxtFld("Nome", controller);
				CentrPanel.add(NomeFld, "cell 0 0,alignx left,growy");
				
				JPanel DateConteiner = new JPanel();
				DateConteiner.setBackground(t.white);
				CentrPanel.add(DateConteiner, "cell 0 1,grow");
				DateConteiner.setLayout(new MigLayout("wrap, fill", "[][]", "[][]"));
				
					JLabel DataInizioLbl = new JLabel("Data inizio");
					DataInizioLbl.setFont(t.myFont(18));
					DataInizioLbl.setForeground(t.scBlue);
					DateConteiner.add(DataInizioLbl, "cell 0 0,alignx center,aligny bottom");
					
					JLabel DataFineLbl = new JLabel("Data fine");
					DataFineLbl.setFont(t.myFont(18));
					DataFineLbl.setForeground(t.scBlue);
					DateConteiner.add(DataFineLbl, "cell 1 0,alignx center,aligny bottom");
					
					DataInizio = new DateComboBox();	
					DateConteiner.add(DataInizio, "cell 0 1,alignx center,aligny top");
					
					DataFine = new DateComboBox();	
					DateConteiner.add(DataFine, "cell 1 1,alignx center,aligny top");
				
				DescrizioneFld = new JTextArea();
				DescrizioneFld.setFont(new Font("Calibri Light", Font.ITALIC, 16));
				DescrizioneFld.setText("Descrizione");
				DescrizioneFld.setForeground(t.altGray);
				DescrizioneFld.setLineWrap(true);
				DescrizioneFld.setPreferredSize(new Dimension(500, 22));
				DescrizioneFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
				CentrPanel.add(DescrizioneFld, "flowx,cell 0 2,alignx left,growy");
				DescrizioneFld.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						controller.setTextNull(DescrizioneFld, 18);
					}
				});
				
				JLabel CollocazioneLbl = new JLabel("Collocazione");
				CentrPanel.add(CollocazioneLbl, "cell 0 3,alignx center,aligny bottom");
				CollocazioneLbl.setForeground(t.scBlue);
				CollocazioneLbl.setFont(t.myFont(18));
				
				JPanel CollocazioneConteiner = new JPanel();
				CentrPanel.add(CollocazioneConteiner, "cell 0 4,grow");
				CollocazioneConteiner.setBackground(t.white);
				CollocazioneConteiner.setLayout(new MigLayout("wrap, fill", "[][]", "[::35px]"));
							
						SedeFld = new myTxtFld("Sede", controller);
						CollocazioneConteiner.add(SedeFld, "cell 0 0,grow");
						
						Regione = new JComboBox<String>();
						CollocazioneConteiner.add(Regione, "cell 1 0,grow");
						Regione.setFont(new Font("Tahoma", Font.PLAIN, 12));
						Regione.setModel(new DefaultComboBoxModel<String>(Regioni));
						
						
				JLabel TemaLbl = new JLabel("Tema");
				CentrPanel.add(TemaLbl, "cell 0 5,alignx left,aligny bottom");
				TemaLbl.setForeground(t.scBlue);
				TemaLbl.setFont(t.myFont(18));
				
				TemiConteiner = new TopicSelectionPanel();
				CentrPanel.add(TemiConteiner, "cell 0 6,grow");
				
					
			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(t.lGray);
			SouthPanel.setPreferredSize(new Dimension(10, 80));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
			SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
			
				IndietroBtn = new BackFromGestioneBtn(comingFrom, controller);
				SouthPanel.add(IndietroBtn, "cell 0 0,alignx right,aligny bottom");
				
				ConfermaBtn = new GoToNextInfoBtn(comingFrom, controller);
				SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny bottom");
	}
	
	public String getId() { return IdConferenza; }
	
	public void setLbl(String txt) { AddConfLbl.setText(txt); }
	
    public String getNome() { return NomeFld.getText(); }
    public void setNome(String txt) { NomeFld.setText(txt); }
    
    public DateComboBox getDataInizioCB() { return DataInizio; }
    public String getDataInizio() { return DataInizio.getAAMMGG(); }

    public DateComboBox getDataFineCB() { return DataFine; }
    public String getDataFine() { return DataFine.getAAMMGG(); }
    
    public Calendar getDataInizioC() {
    	
    	DataInizioC.set(DataInizio.getYear(), DataInizio.getMonth(), DataInizio.getDay());
    	return DataInizioC;
    }
    
    public Calendar getDataFineC() {
    	
    	DataFineC.set(DataFine.getYear(), DataFine.getMonth(), DataFine.getDay());
		return DataFineC;
    }
    
    public String getDescrizione() { return DescrizioneFld.getText(); }
    public void setDescrizione(String txt) { DescrizioneFld.setText(txt); }
    
    public String getSede() { return SedeFld.getText(); }
    public void setSede(String txt) { SedeFld.setText(txt); }
    
    public String getRegione() { return ((String)Regione.getSelectedItem()); }
    public void setRegione(String txt) { Regione.setSelectedItem(txt); }
    
    public ButtonGroup getButtonGroup() { return TemiConteiner.getButtonGroup();}
    public String getTema() { return TemiConteiner.getButtonGroup().getSelection().getActionCommand(); }
    
    public boolean fieldsAreEmpty() {
		
		if (isEmpty(getNome(), "Nome") || isEmpty(getDescrizione(), "Descrizione") || isEmpty(getSede(), "Sede") 
		|| getDataInizio().isEmpty() || getDataFine().isEmpty() || TemiConteiner.getButtonGroup().getSelection() == null) {
			return true;	
		
		} else { return false; }
	}
	
	private boolean isEmpty(String txt, String txt2) {
		
		if (txt.equals("") || txt.equals(txt2)) { return true; }
		
		else { return false; }
	}
}