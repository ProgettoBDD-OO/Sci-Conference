package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import GUI.ConferenzaFrame.OrganizzatoreInfo;
import linker.Controller;
import myTools.DateComboBox;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModSessioniPanel extends JPanel {

	Controller controller;
	
	private DateComboBox DataInizio;
	private DateComboBox DataFine;
	private JTextField Coordinatore;
	private JTextField Locazione;
	private int currentSession;
	private int nInterventi;
	
	private ArrayList<ModInterventoPanel> Interventi;
	private JPanel InterventiPanel;
	private InterventoComboBox SelezioneInterventoComboBox;
	private JPanel panel;
	
	public ModSessioniPanel(int currentSession, Controller c) {
		
		controller = c;
		this.currentSession = currentSession;
		
		setLayout(new BorderLayout(0,0));
		setBorder(new MatteBorder(0, 1, 0, 1,new Color(0, 0, 200)));
		
		JPanel InfoSessioni1 = new JPanel();
		InfoSessioni1.setBorder(new MatteBorder(1, 0, 1, 0, new Color(0, 0, 200)));
		InfoSessioni1.setBackground(new Color(255, 255, 255));
		InfoSessioni1.setLayout(new MigLayout("wrap, fill", "[::140px][]", "[][][][][][]"));
		add(InfoSessioni1, BorderLayout.CENTER);
		
		JLabel SessioneLbl = new JLabel("Sessione n");
		SessioneLbl.setText("Sessione " + (currentSession + 1));
		SessioneLbl.setForeground(new Color(0, 0, 200));
		SessioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		InfoSessioni1.add(SessioneLbl, "cell 0 0,alignx center,aligny center");
		
		
			JLabel DataOraInizioLbl = new JLabel("Data e ora di inizio:");
			DataOraInizioLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(DataOraInizioLbl, "cell 0 1,alignx left,aligny center");
			
			DataInizio = new DateComboBox();
			InfoSessioni1.add(DataInizio, "cell 1 1,alignx center, aligny center");
			
			JLabel DataOraFineLbl = new JLabel("Data e ora di fine:");
			DataOraFineLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(DataOraFineLbl, "cell 0 2,alignx left,aligny center");
			
			DataFine = new DateComboBox();
			InfoSessioni1.add(DataFine, "cell 1 2, alignx center, aligny center");
			
			
			JLabel CoordinatoreLbl = new JLabel("Coordinatore:");
			CoordinatoreLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(CoordinatoreLbl, "cell 0 3");
			
			Coordinatore = new JTextField("");
			Coordinatore.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(Coordinatore, "cell 1 3,growx,aligny center");
			
			
			JLabel KeynoteSpeakerLbl = new JLabel("Keynote Speaker:");
			KeynoteSpeakerLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(KeynoteSpeakerLbl, "cell 0 4");
			
			JButton KeynoteSpeakerBtn = new JButton("Inserisci Keynote Speaker (opzionale)");
			KeynoteSpeakerBtn.setPreferredSize(new Dimension(213, 35));
			KeynoteSpeakerBtn.setForeground(Color.WHITE);
			KeynoteSpeakerBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			KeynoteSpeakerBtn.setBackground(new Color(0, 0, 200));
			InfoSessioni1.add(KeynoteSpeakerBtn, "cell 1 4,alignx center,aligny center");
			KeynoteSpeakerBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.goToKeynote();
				}
			});
			
			
			JLabel LocazioneLbl = new JLabel("Locazione:");
			LocazioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(LocazioneLbl, "cell 0 5,alignx left,aligny center");
			
			Locazione = new JTextField("");
			Locazione.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(Locazione, "cell 1 5,growx,aligny center");
			
			
		JPanel InterventiConteiner = new JPanel();
		InterventiConteiner.setBackground(new Color(255, 255, 255));
		InterventiConteiner.setPreferredSize(new Dimension(225, 10));
		InterventiConteiner.setLayout(new BorderLayout(0, 0));
		add(InterventiConteiner, BorderLayout.EAST);
			
			JScrollPane InterventiScroller = new JScrollPane();
			InterventiScroller.setBorder(null);
			InterventiConteiner.add(InterventiScroller, BorderLayout.CENTER);
			
			InterventiPanel = new JPanel();
			InterventiPanel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 200)));
			InterventiPanel.setBackground(new Color(255, 255, 255));
			InterventiScroller.setViewportView(InterventiPanel);
			InterventiPanel.setLayout(new BoxLayout(InterventiPanel, BoxLayout.Y_AXIS));
			
			Interventi = new ArrayList<ModInterventoPanel>();
			
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setPreferredSize(new Dimension(10, 40));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("\tSeleziona un intervento da modificare:\t\t");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		panel.add(lblNewLabel);
	}

	
	public DateComboBox getDataInizioCB() { return DataInizio; }
	
	public DateComboBox getDataFineCB() { return DataFine; }
	
    
    public String getCoordinatore() { return Coordinatore.getText(); }
    
    public void setCoordinatore(String coordinatore) {Coordinatore.setText(coordinatore); }
    
    
    //public String getKeynoteSpeaker() { return KeynoteSpeaker.getText(); }
    
	
    
    public ArrayList<ModInterventoPanel> getInterventi() { return Interventi; }
    
    public JPanel getInterventiPanel() { return InterventiPanel; }
    
    
    public JComboBox<Integer> getSelezioneInterventoComboBox() { return SelezioneInterventoComboBox; }
    
    public void setNInterventi(int nInterventi) {
    	
    	this.nInterventi = nInterventi; 
    	SelezioneInterventoComboBox = new InterventoComboBox(currentSession,  nInterventi, controller);
		panel.add(SelezioneInterventoComboBox);
    }
}