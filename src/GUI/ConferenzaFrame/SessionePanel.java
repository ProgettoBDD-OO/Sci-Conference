package GUI.ConferenzaFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;


public class SessionePanel extends JPanel {

	Controller controller;

	private myTemplates t;

	private JLabel SessioneLbl;

	private JLabel DataOraInizio;
	private JLabel DataOraFine;

	private JLabel Coordinatore;
	private JLabel KeynoteSpeaker;

	private JLabel Locazione;
	private JPanel InterventiConteiner;

	private JPopupMenu popupMenu;
	private OrganizzatoreInfo OrgInfoPanel;
	private JScrollPane InterventiScroller;


	public SessionePanel(String idSessione, Controller c, String comingFrom) {

		controller = c;

		t = new myTemplates();
		setLayout(new BorderLayout(0, 0));
		setBorder(new MatteBorder(0, 1, 0, 1, t.scBlue));

		JPanel InfoSessioni = new JPanel();
		InfoSessioni.setBorder(new MatteBorder(1, 0, 1, 0, t.scBlue));
		InfoSessioni.setBackground(t.white);
		InfoSessioni.setLayout(new MigLayout("wrap, fill", "[::140px][]", "[][][][][][]"));
		add(InfoSessioni, BorderLayout.CENTER);

		SessioneLbl = new JLabel("Sessione 1");
		SessioneLbl.setForeground(t.scBlue);
		SessioneLbl.setFont(t.myFont(16));
		InfoSessioni.add(SessioneLbl, "cell 0 0,alignx center,aligny center");


			JLabel DataInizioLbl = new JLabel("Data di inizio:");
			DataInizioLbl.setFont(t.myFont(13));
			InfoSessioni.add(DataInizioLbl, "cell 0 1,alignx left,aligny center");

			DataOraInizio = new JLabel("");
			DataOraInizio.setFont(t.myFont(13));
			InfoSessioni.add(DataOraInizio, "cell 1 1, alignx center, aligny center");


			JLabel DataFineLbl = new JLabel("Data di fine:");
			DataFineLbl.setFont(t.myFont(13));
			InfoSessioni.add(DataFineLbl, "cell 0 2,alignx left,aligny center");

			DataOraFine = new JLabel("");
			DataOraFine.setFont(t.myFont(13));
			InfoSessioni.add(DataOraFine, "cell 1 2, alignx center, aligny center");


			JLabel CoordinatoreLbl = new JLabel("Coordinatore:");
			CoordinatoreLbl.setFont(t.myFont(13));
			InfoSessioni.add(CoordinatoreLbl, "cell 0 3");

			Coordinatore = new JLabel("");
			Coordinatore.setFont(t.myFont(13));
			InfoSessioni.add(Coordinatore, "cell 1 3, alignx center, aligny center");


			JLabel KeynoteSpeakerLbl = new JLabel("Keynote Speaker:");
			KeynoteSpeakerLbl.setFont(t.myFont(13));
			InfoSessioni.add(KeynoteSpeakerLbl, "cell 0 4");

			KeynoteSpeaker = new JLabel("");
			KeynoteSpeaker.setFont(t.myFont(13));
			InfoSessioni.add(KeynoteSpeaker, "cell 1 4, alignx center, aligny center");


			JLabel LocazioneLbl = new JLabel("Locazione:");
			LocazioneLbl.setFont(t.myFont(13));
			InfoSessioni.add(LocazioneLbl, "cell 0 5,alignx left,aligny center");

			Locazione = new JLabel("");
			Locazione.setFont(t.myFont(13));
			InfoSessioni.add(Locazione, "cell 1 5, alignx center, aligny center");


		JPanel InterventiPanel = new JPanel();
		InterventiPanel.setPreferredSize(new Dimension(225, 10));
		InterventiPanel.setLayout(new BorderLayout(0, 0));
		add(InterventiPanel, BorderLayout.EAST);

			InterventiScroller = new JScrollPane();
			InterventiScroller.setBorder(null);
			InterventiScroller.getVerticalScrollBar().setUnitIncrement(10);
			InterventiPanel.add(InterventiScroller, BorderLayout.CENTER);

			InterventiConteiner = new JPanel();
			InterventiConteiner.setBorder(new MatteBorder(1, 1, 1, 0, t.scBlue));
			InterventiConteiner.setBackground(t.white);
			InterventiConteiner.setLayout(new BoxLayout(InterventiConteiner, BoxLayout.Y_AXIS));
			InterventiScroller.setViewportView(InterventiConteiner);

			OrgInfoPanel = new OrganizzatoreInfo(25);
			OrgInfoPanel.setPreferredSize(new Dimension(190, 50));
			
			popupMenu = new JPopupMenu();
			popupMenu.add(OrgInfoPanel);
			
			if (comingFrom.equals("Aggiunta")) { controller.addInfoSessione(this); }

			else {
				controller.addSessioneInfo(idSessione, this);
				showInfoPerson();
			}
	}

	public void setSessioneLbl(String txt) { SessioneLbl.setText(txt); }
	
	public void setDataInizio(String dataInizio) { DataOraInizio.setText(dataInizio); }

    public void setDataFine(String dataFine) { DataOraFine.setText(dataFine); }

    public void setCoordinatore(String coordinatore) { Coordinatore.setText(coordinatore); }

    public void setKeynoteSpeaker(String keynoteSpeaker) { KeynoteSpeaker.setText(keynoteSpeaker); }

    public void setLocazione(String locazione) { Locazione.setText(locazione); }
    
	public JPanel getInterventi() { return InterventiConteiner; }

	public void showInfoPerson() {

		for (Component l : InterventiConteiner.getComponents()) {

			if (l instanceof InfoInterventoLbl && ((InfoInterventoLbl) l).getId() != null) {

				l.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						showMenu(e);
						controller.addPartecipanteInfo(OrgInfoPanel, ((InfoInterventoLbl) l).getId());
					}
					@Override
					public void mouseExited(MouseEvent e) {
						popupMenu.setVisible(false);
					}
					private void showMenu(MouseEvent e) {
						popupMenu.setLocation(InterventiConteiner.getLocationOnScreen().x, l.getLocationOnScreen().y + 15);
						popupMenu.setVisible(true);
					}
				});
			}
		}
	}
}