package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.DateComboBox;
import myTools.TopicSelectionPanel;
import myTools.myTemplates;
import myTools.myTxtFld;
import net.miginfocom.swing.MigLayout;

public class GestioneFrame extends JFrame {

	Controller controller;

	private myTemplates t;

	private String IdConferenza;
	private JLabel AddConfLbl;
	private JTextField NomeFld;
	private DateComboBox DataInizio;
	private DateComboBox DataFine;
	private JTextArea DescrizioneFld;

	private Calendar DataInizioC = Calendar.getInstance();
	private Calendar DataFineC = Calendar.getInstance();

	private String[] Regioni = {"Piemonte", "Liguria", "Lombardia", "Trentino-Alto Adige", "Veneto",
			"Friuli-Venezia Giulia", "Val di Aosta", "Emilia-Romagna", "Toscana", "Umbria", "Marche", "Lazio",
			"Abruzzo", "Molise", "Campania", "Puglia", "Basilicata", "Calabria", "Sicilia", "Sardegna"};
	private JTextField SedeFld;
	private JComboBox<String> Regione;


	private BackFromGestioneBtn IndietroBtn;
	private GoToNextInfoBtn ConfermaBtn;
	private TopicSelectionPanel TemiContainer;

	public GestioneFrame(String idConferenza, String comingFrom, Controller c) {

		controller = c;
		IdConferenza = idConferenza;
		t = new myTemplates();
		
		setTitle("Gestione Conferenza");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(642, 730);
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
			AddConfLbl.setFont(t.myFont(26));
			AddConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
			AddConfLbl.setPreferredSize(new Dimension(46, 85));
			MainPanel.add(AddConfLbl, BorderLayout.NORTH);


			JPanel CentrPanel = new JPanel();
			CentrPanel.setBorder(new EmptyBorder(8, 4, 8, 4));
			CentrPanel.setBackground(t.white);
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::30px]25[]25[60px:n]25[][]25[][]"));

			
			if (comingFrom.equals("MainFrame")) {
				
				NomeFld = new myTxtFld("Nome", controller);

			} else {
				
				NomeFld = new JTextField();
				NomeFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
				NomeFld.setForeground(t.tangaroa);
				NomeFld.setFont(t.myFont(16));
				NomeFld.setPreferredSize(new Dimension(10, 25));
				NomeFld.setColumns(23);
			}
			
			CentrPanel.add(NomeFld, "cell 0 0,alignx left,growy");
				
				JPanel DateContainer = new JPanel();
				DateContainer.setBackground(t.white);
				CentrPanel.add(DateContainer, "cell 0 1,grow");
				DateContainer.setLayout(new MigLayout("wrap, fill", "[][]", "[][]"));

					JLabel DataInizioLbl = new JLabel("Data inizio");
					DataInizioLbl.setFont(t.myFont(16));
					DataInizioLbl.setForeground(t.scBlue);
					DateContainer.add(DataInizioLbl, "cell 0 0,alignx center,aligny bottom");

					JLabel DataFineLbl = new JLabel("Data fine");
					DataFineLbl.setFont(t.myFont(16));
					DataFineLbl.setForeground(t.scBlue);
					DateContainer.add(DataFineLbl, "cell 1 0,alignx center,aligny bottom");

					DataInizio = new DateComboBox();
					DateContainer.add(DataInizio, "cell 0 1,alignx center,aligny top");

					DataFine = new DateComboBox();
					DateContainer.add(DataFine, "cell 1 1,alignx center,aligny top");

				DescrizioneFld = new JTextArea();
				if (comingFrom.equals("MainFrame")) {
					
					DescrizioneFld.setFont(new Font("Calibri Light", Font.ITALIC, 16));
					DescrizioneFld.setForeground(t.altGray);
					DescrizioneFld.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							controller.setTextNull(DescrizioneFld, 16);
						}
					});
					
				} else {
					
					DescrizioneFld.setFont(t.myFont(16)); 
					DescrizioneFld.setForeground(t.tangaroa);
				}
				DescrizioneFld.setText("Descrizione");
				DescrizioneFld.setLineWrap(true);
				DescrizioneFld.setWrapStyleWord(true);
				DescrizioneFld.setPreferredSize(new Dimension(430, 22));
				DescrizioneFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
				CentrPanel.add(DescrizioneFld, "flowx,cell 0 2,alignx left,growy");

				JLabel CollocazioneLbl = new JLabel("Collocazione");
				CentrPanel.add(CollocazioneLbl, "cell 0 3,alignx center,aligny bottom");
				CollocazioneLbl.setForeground(t.scBlue);
				CollocazioneLbl.setFont(t.myFont(14));

				JPanel CollocazioneContainer = new JPanel();
				CentrPanel.add(CollocazioneContainer, "cell 0 4,grow");
				CollocazioneContainer.setBackground(t.white);
				CollocazioneContainer.setLayout(new MigLayout("wrap, fill", "[][]", "[::35px]"));

				
					if (comingFrom.equals("MainFrame")) {
						
						SedeFld = new myTxtFld("Sede", controller);
						
					} else {
						
						SedeFld = new JTextField();
						SedeFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
						SedeFld.setForeground(t.tangaroa);
						SedeFld.setFont(t.myFont(16));
						SedeFld.setPreferredSize(new Dimension(10, 25));
						SedeFld.setColumns(21);
					}
					CollocazioneContainer.add(SedeFld, "cell 0 0,grow");
						
					Regione = new JComboBox<>();
					CollocazioneContainer.add(Regione, "cell 1 0,grow");
					Regione.setModel(new DefaultComboBoxModel<>(Regioni));


				JLabel TemaLbl = new JLabel("Tema");
				CentrPanel.add(TemaLbl, "cell 0 5,alignx left,aligny bottom");
				TemaLbl.setForeground(t.scBlue);
				TemaLbl.setFont(t.myFont(16));

				TemiContainer = new TopicSelectionPanel();
				CentrPanel.add(TemiContainer, "cell 0 6,grow");


			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(t.lGray);
			SouthPanel.setPreferredSize(new Dimension(10, 70));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
			SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));

				IndietroBtn = new BackFromGestioneBtn(comingFrom, controller);
				SouthPanel.add(IndietroBtn, "cell 0 0,alignx right,aligny bottom");

				ConfermaBtn = new GoToNextInfoBtn(comingFrom, IdConferenza, controller);
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

    public ButtonGroup getButtonGroup() { return TemiContainer.getButtonGroup();}
    public String getTema() { return TemiContainer.getButtonGroup().getSelection().getActionCommand(); }

    public boolean fieldsAreEmpty() {

		if (isEmpty(getNome(), "Nome") || isEmpty(getDescrizione(), "Descrizione") || isEmpty(getSede(), "Sede")
		|| getDataInizio().isEmpty() || getDataFine().isEmpty() || TemiContainer.getButtonGroup().getSelection() == null) {
			return true;

		} else { return false; }
	}

	private boolean isEmpty(String txt, String txt2) {

		if (txt.equals("") || txt.equals(txt2)) { return true; }

		else { return false; }
	}
}