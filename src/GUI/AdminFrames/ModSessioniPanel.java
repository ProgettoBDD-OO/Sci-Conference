package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import GUI.ConferenzaFrame.OrganizzatoreInfo;
import linker.Controller;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class ModSessioniPanel extends JPanel {

	Controller controller;
	
	private JTextField DataOraInizio;
	private JTextField DataOraFine;
	
	private JTextField Coordinatore;
	private JTextField KeynoteSpeaker;
	
	private JTextField Locazione;
	private JPanel InterventiPanel;
	
	private JPopupMenu popupMenu;
	private OrganizzatoreInfo oiPanel;
	
	public ModSessioniPanel(int currentSession, Controller c) {
		
		controller = c;
		
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
			
			DataOraInizio = new JTextField("");
			DataOraInizio.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(DataOraInizio, "cell 1 1,growx,aligny center");
			
			
			JLabel DataOraFineLbl = new JLabel("Data e ora di fine:");
			DataOraFineLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(DataOraFineLbl, "cell 0 2,alignx left,aligny center");
			
			DataOraFine = new JTextField("");
			DataOraFine.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(DataOraFine, "cell 1 2,growx,aligny center");
			
			
			JLabel CoordinatoreLbl = new JLabel("Coordinatore:");
			CoordinatoreLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(CoordinatoreLbl, "cell 0 3");
			
			Coordinatore = new JTextField("");
			Coordinatore.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(Coordinatore, "cell 1 3,growx,aligny center");
			
			
			JLabel KeynoteSpeakerLbl = new JLabel("Keynote Speaker:");
			KeynoteSpeakerLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(KeynoteSpeakerLbl, "cell 0 4");
			
			KeynoteSpeaker = new JTextField("");
			KeynoteSpeaker.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(KeynoteSpeaker, "cell 1 4,growx,aligny center");
			
			
			JLabel LocazioneLbl = new JLabel("Locazione:");
			LocazioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(LocazioneLbl, "cell 0 5,alignx left,aligny center");
			
			Locazione = new JTextField("");
			Locazione.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(Locazione, "cell 1 5,growx,aligny center");
			
			
		JPanel InterventiConteiner = new JPanel();
		InterventiConteiner.setPreferredSize(new Dimension(225, 10));
		InterventiConteiner.setLayout(new BorderLayout(0, 0));
		add(InterventiConteiner, BorderLayout.EAST);
			
			JScrollPane InterventiScroller = new JScrollPane();
			InterventiScroller.setBorder(null);
			InterventiConteiner.add(InterventiScroller, BorderLayout.CENTER);
			
			InterventiPanel = new JPanel();
			InterventiPanel.setBorder(new MatteBorder(1, 1, 1, 0, new Color(0, 0, 200)));
			InterventiPanel.setBackground(new Color(255, 255, 255));
			InterventiScroller.setViewportView(InterventiPanel);
			InterventiPanel.setLayout(new BoxLayout(InterventiPanel, BoxLayout.Y_AXIS));
						
			oiPanel = new OrganizzatoreInfo(30);
			oiPanel.setPreferredSize(new Dimension(225, 60));
			
			popupMenu = new JPopupMenu();
			popupMenu.add(oiPanel);
	}
	
	public String getDataOraInizio() { return DataOraInizio.getText(); }
	
	public void setDataOraInizio(String dataOraInizio) { DataOraInizio.setText(dataOraInizio); }
	

	public String getDataOraFine() { return DataOraFine.getText(); }
	
    public void setDataOraFine(String dataOraFine) { DataOraFine.setText(dataOraFine); }

    
    public String getCoordinatore() { return Coordinatore.getText(); }
    
    public void setCoordinatore(String coordinatore) {Coordinatore.setText(coordinatore); }
    

    public String getKeynoteSpeaker() { return KeynoteSpeaker.getText(); }
    
    public void setKeynoteSpeaker(String keynoteSpeaker) {KeynoteSpeaker.setText(keynoteSpeaker); }
	
    
	public JPanel getInterventiPanel() { return InterventiPanel; }
}