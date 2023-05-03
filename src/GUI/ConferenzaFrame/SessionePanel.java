package GUI.ConferenzaFrame;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import linker.Controller;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class SessionePanel extends JPanel {
	
	Controller controller;
	
	private JLabel DataOraInizio;
	private JLabel DataOraFine;
	
	private JLabel Coordinatore;
	private JLabel KeynoteSpeaker;
	
	private JLabel Locazione;
	private JPanel InterventiPanel;
	
	private JPopupMenu popupMenu;
	private OrganizzatoreInfo oiPanel;
	
	private boolean lastSession = false;
	
	public SessionePanel(int currentSession, Controller contr) {
		
		controller = contr;
		
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
			
			DataOraInizio = new JLabel("");
			DataOraInizio.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(DataOraInizio, "cell 1 1, alignx center, aligny center");
			
			
			JLabel DataOraFineLbl = new JLabel("Data e ora di fine:");
			DataOraFineLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(DataOraFineLbl, "cell 0 2,alignx left,aligny center");
			
			DataOraFine = new JLabel("");
			DataOraFine.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(DataOraFine, "cell 1 2, alignx center, aligny center");
			
			
			JLabel CoordinatoreLbl = new JLabel("Coordinatore:");
			CoordinatoreLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(CoordinatoreLbl, "cell 0 3");
			
			Coordinatore = new JLabel("");
			Coordinatore.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(Coordinatore, "cell 1 3, alignx center, aligny center");
			
			
			JLabel KeynoteSpeakerLbl = new JLabel("Keynote Speaker:");
			KeynoteSpeakerLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(KeynoteSpeakerLbl, "cell 0 4");
			
			KeynoteSpeaker = new JLabel("");
			KeynoteSpeaker.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(KeynoteSpeaker, "cell 1 4, alignx center, aligny center");
			
			
			JLabel LocazioneLbl = new JLabel("Locazione:");
			LocazioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(LocazioneLbl, "cell 0 5,alignx left,aligny center");
			
			Locazione = new JLabel("");
			Locazione.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			InfoSessioni1.add(Locazione, "cell 1 5, alignx center, aligny center");
			
			
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
			lastSession = controller.addSessioneInfo(currentSession, this);
			foo();
	}
	
	public void setDataOraInizio(String dataOraInizio) {
        DataOraInizio.setText(dataOraInizio);
    }

    public void setDataOraFine(String dataOraFine) {
        DataOraFine.setText(dataOraFine);
    }

    public void setCoordinatore(String coordinatore) {
        Coordinatore.setText(coordinatore);
    }

    public void setKeynoteSpeaker(String keynoteSpeaker) {
        KeynoteSpeaker.setText(keynoteSpeaker);
    }
	
    public boolean isLastSession() { return lastSession; }
	
	public JPanel getInterventiPanel() { return InterventiPanel; }
	
	public void foo() {
		
		for (Component l : InterventiPanel.getComponents()) {
			
			if (l instanceof InfoInterventoLbl && ((InfoInterventoLbl) l).getId() != null) {
				
				l.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						showMenu(e);
						controller.addPartecipanteInfo(oiPanel, ((InfoInterventoLbl) l).getId());
					}
					@Override
					public void mouseExited(MouseEvent e) {
						popupMenu.setVisible(false);
					}
					private void showMenu(MouseEvent e) {
						popupMenu.setLocation(InterventiPanel.getLocationOnScreen().x, l.getLocationOnScreen().y + 15);
						popupMenu.setVisible(true);
					}
				});
			}
		}
	}
}