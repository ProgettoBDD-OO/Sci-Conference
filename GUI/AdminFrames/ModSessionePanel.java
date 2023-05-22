package GUI.AdminFrames;


import linker.Controller;
import myTools.DateComboBox;
import myTools.myTemplates;

import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;


public class ModSessionePanel extends JPanel {

	Controller controller;
	
	myTemplates t = new myTemplates();
	
	private String idSessione;
	private DateComboBox DataInizio;
	private DateComboBox DataFine;
	private JTextField Coordinatore;
	private JTextField Locazione;
	
	private ArrayList<ModInterventoPanel> Interventi;
	private JPanel InterventiConteiner;
	private InterventoComboBox InterventoComboBox;
	private JPanel ModificaInterventoConteiner;

	private String KeynoteSpeaker = "";
	
	public ModSessionePanel(Controller c) {
		
		controller = c;
		
		setLayout(new BorderLayout(0,0));
		
		JPanel InfoSessione = new JPanel();
		InfoSessione.setBorder(new MatteBorder(1, 1, 1, 0, new Color(0, 0, 200)));
		InfoSessione.setBackground(new Color(255, 255, 255));
		InfoSessione.setLayout(new MigLayout("wrap, fill", "[::140px][]", "[][][][][][]"));
		add(InfoSessione, BorderLayout.CENTER);
		
		JLabel SessioneLbl = new JLabel("Sessione n");
		//SessioneLbl.setText("Sessione " + (currentSession + 1));
		SessioneLbl.setForeground(new Color(0, 0, 200));
		SessioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		InfoSessione.add(SessioneLbl, "cell 0 0,alignx center,aligny center");
		
			JLabel DataOraInizioLbl = new JLabel("Data e ora di inizio:");
			DataOraInizioLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessione.add(DataOraInizioLbl, "cell 0 1,alignx left,aligny center");
			
			DataInizio = new DateComboBox();
			InfoSessione.add(DataInizio, "cell 1 1,alignx center, aligny center");
			
			JLabel DataOraFineLbl = new JLabel("Data e ora di fine:");
			DataOraFineLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessione.add(DataOraFineLbl, "cell 0 2,alignx left,aligny center");
			
			DataFine = new DateComboBox();
			InfoSessione.add(DataFine, "cell 1 2, alignx center, aligny center");
			
			
			JLabel LocazioneLbl = new JLabel("Locazione:");
			LocazioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessione.add(LocazioneLbl, "cell 0 3,alignx left,aligny center");
			
			Locazione = new JTextField("");
			Locazione.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessione.add(Locazione, "cell 1 3,growx,aligny center");
			
			
			JLabel CoordinatoreLbl = new JLabel("Coordinatore:");
			CoordinatoreLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessione.add(CoordinatoreLbl, "cell 0 4");
			
			Coordinatore = new JTextField("");
			Coordinatore.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessione.add(Coordinatore, "cell 1 4,growx,aligny center");
			
			
			JLabel KeynoteSpeakerLbl = new JLabel("Keynote Speaker:");
			KeynoteSpeakerLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessione.add(KeynoteSpeakerLbl, "cell 0 5");
			
			JButton KeynoteSpeakerBtn = new JButton("Inserisci Keynote Speaker (opzionale)");
			KeynoteSpeakerBtn.setPreferredSize(new Dimension(213, 35));
			KeynoteSpeakerBtn.setForeground(Color.WHITE);
			KeynoteSpeakerBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			KeynoteSpeakerBtn.setBackground(new Color(0, 0, 200));
			InfoSessione.add(KeynoteSpeakerBtn, "cell 1 5,alignx center,aligny center");
			KeynoteSpeakerBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.goToKeynote();
				}
			});
			
			
		JPanel InterventiPanel = new JPanel();
		InterventiPanel.setBackground(new Color(255, 255, 255));
		InterventiPanel.setPreferredSize(new Dimension(225, 10));
		InterventiPanel.setLayout(new BorderLayout(0, 0));
		add(InterventiPanel, BorderLayout.EAST);
			
			JScrollPane InterventiScroller = new JScrollPane();
			InterventiScroller.setBorder(null);
			InterventiPanel.add(InterventiScroller, BorderLayout.CENTER);
			
			InterventiConteiner = new JPanel();
			InterventiConteiner.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 200)));
			InterventiConteiner.setBackground(new Color(255, 255, 255));
			InterventiScroller.setViewportView(InterventiConteiner);
			InterventiConteiner.setLayout(new BoxLayout(InterventiConteiner, BoxLayout.Y_AXIS));
			
			Interventi = new ArrayList<ModInterventoPanel>();
			
		ModificaInterventoConteiner = new JPanel();
		ModificaInterventoConteiner.setBackground(new Color(255, 255, 255));
		ModificaInterventoConteiner.setPreferredSize(new Dimension(10, 40));
		add(ModificaInterventoConteiner, BorderLayout.SOUTH);
		ModificaInterventoConteiner.setLayout(new BoxLayout(ModificaInterventoConteiner, BoxLayout.X_AXIS));
		
		JLabel ModificaInterventoLbl = new JLabel("\tSeleziona un intervento da modificare:\t\t");
		ModificaInterventoLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		ModificaInterventoConteiner.add(ModificaInterventoLbl);
	}

	public String getIdSessione() { return idSessione; }

    public void setIdSessione(String idSessione) { this.idSessione = idSessione; }
	
	
	public DateComboBox getDataInizioCB() { return DataInizio; }
	
	public DateComboBox getDataFineCB() { return DataFine; }
	
    
    public String getCoordinatore() { return Coordinatore.getText(); }
    
    public void setCoordinatore(String coordinatore) {Coordinatore.setText(coordinatore); }
    
    
    public String getKeynoteSpeaker() { return KeynoteSpeaker; }
    
    public void setKeynoteSpeaker(String keynoteSpeaker) {KeynoteSpeaker = keynoteSpeaker; }
    
	
    public String getLocazione() { return Locazione.getText(); }

    public void setLocazione(String locazione) { Locazione.setText(locazione);; }
    
    
    public ArrayList<ModInterventoPanel> getInterventi() { return Interventi; }
    
    public JPanel getInterventiPanel() { return InterventiConteiner; }
    
    public int getIntervento() { return InterventoComboBox.getSelectedIndex(); }
    
    public void setNInterventi(int nInterventi) {

    	InterventoComboBox = new InterventoComboBox(nInterventi, controller);
		ModificaInterventoConteiner.add(InterventoComboBox);
    }
}