package GUI.AdminFrames;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.DateComboBox;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;


public class ModSessionePanel extends JPanel {

	Controller controller;

	private myTemplates t;

	private String idSessione;
	private DateComboBox DataInizio;
	private DateComboBox DataFine;
	private JTextField Coordinatore;
	private JTextField Locazione;

	private ArrayList<ModInterventoPanel> Interventi;
	private JPanel InterventiContainer;
	private InterventoComboBox InterventoComboBox;
	private JPanel ModificaInterventoContainer;

	private String KeynoteSpeaker = "";
	private JLabel SessioneLbl;

	public ModSessionePanel(Controller c) {

		controller = c;

		t = new myTemplates();
		setLayout(new BorderLayout(0,0));

		JPanel InfoSessione = new JPanel();
		InfoSessione.setBorder(new MatteBorder(1, 1, 1, 0, t.scBlue));
		InfoSessione.setBackground(t.white);
		InfoSessione.setLayout(new MigLayout("wrap, fill", "[::140px][]", "[][][][][][]"));
		add(InfoSessione, BorderLayout.CENTER);

		SessioneLbl = new JLabel("Sessione n");
		SessioneLbl.setForeground(t.scBlue);
		SessioneLbl.setFont(t.myFont(20));
		InfoSessione.add(SessioneLbl, "cell 0 0,alignx center,aligny center");

			JLabel DataOraInizioLbl = new JLabel("Data e ora di inizio:");
			DataOraInizioLbl.setFont(t.myFont(16));
			InfoSessione.add(DataOraInizioLbl, "cell 0 1,alignx left,aligny center");

			DataInizio = new DateComboBox();
			InfoSessione.add(DataInizio, "cell 1 1,alignx center, aligny center");

			JLabel DataOraFineLbl = new JLabel("Data e ora di fine:");
			DataOraFineLbl.setFont(t.myFont(16));
			InfoSessione.add(DataOraFineLbl, "cell 0 2,alignx left,aligny center");

			DataFine = new DateComboBox();
			InfoSessione.add(DataFine, "cell 1 2, alignx center, aligny center");


			JLabel LocazioneLbl = new JLabel("Locazione:");
			LocazioneLbl.setFont(t.myFont(16));
			InfoSessione.add(LocazioneLbl, "cell 0 3,alignx left,aligny center");

			Locazione = new JTextField("");
			Locazione.setFont(t.myFont(16));
			InfoSessione.add(Locazione, "cell 1 3,growx,aligny center");


			JLabel CoordinatoreLbl = new JLabel("Coordinatore:");
			CoordinatoreLbl.setFont(t.myFont(16));
			InfoSessione.add(CoordinatoreLbl, "cell 0 4");

			Coordinatore = new JTextField("");
			Coordinatore.setFont(t.myFont(16));
			InfoSessione.add(Coordinatore, "cell 1 4,growx,aligny center");


			JLabel KeynoteSpeakerLbl = new JLabel("Keynote Speaker:");
			KeynoteSpeakerLbl.setFont(t.myFont(16));
			InfoSessione.add(KeynoteSpeakerLbl, "cell 0 5");

			JButton KeynoteSpeakerBtn = new JButton("Inserisci Keynote Speaker (opzionale)");
			KeynoteSpeakerBtn.setPreferredSize(new Dimension(213, 35));
			KeynoteSpeakerBtn.setForeground(Color.WHITE);
			KeynoteSpeakerBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			KeynoteSpeakerBtn.setBackground(t.scBlue);
			InfoSessione.add(KeynoteSpeakerBtn, "cell 1 5,alignx center,aligny center");
			KeynoteSpeakerBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToKeynote();
				}
			});


		JPanel InterventiPanel = new JPanel();
		InterventiPanel.setBackground(t.white);
		InterventiPanel.setPreferredSize(new Dimension(225, 10));
		InterventiPanel.setLayout(new BorderLayout(0, 0));
		add(InterventiPanel, BorderLayout.EAST);

			JScrollPane InterventiScroller = new JScrollPane();
			InterventiScroller.setBorder(null);
			InterventiScroller.getVerticalScrollBar().setUnitIncrement(10);
			InterventiPanel.add(InterventiScroller, BorderLayout.CENTER);

			InterventiContainer = new JPanel();
			InterventiContainer.setBorder(new MatteBorder(1, 0, 1, 1, t.scBlue));
			InterventiContainer.setBackground(t.white);
			InterventiScroller.setViewportView(InterventiContainer);
			InterventiContainer.setLayout(new BoxLayout(InterventiContainer, BoxLayout.Y_AXIS));

			Interventi = new ArrayList<>();

		ModificaInterventoContainer = new JPanel();
		ModificaInterventoContainer.setBackground(t.white);
		ModificaInterventoContainer.setPreferredSize(new Dimension(10, 40));
		add(ModificaInterventoContainer, BorderLayout.SOUTH);
		ModificaInterventoContainer.setLayout(new BoxLayout(ModificaInterventoContainer, BoxLayout.X_AXIS));

		JLabel ModificaInterventoLbl = new JLabel("           Seleziona un intervento da modificare:                    ");
		ModificaInterventoLbl.setFont(t.myFont(16));
		ModificaInterventoContainer.add(ModificaInterventoLbl);
	}

	public String getIdSessione() { return idSessione; }

    public void setIdSessione(String idSessione) { this.idSessione = idSessione; }

	public void setSessioneLbl(String txt) { SessioneLbl.setText(txt); }

	public DateComboBox getDataInizioCB() { return DataInizio; }

	public DateComboBox getDataFineCB() { return DataFine; }


    public String getCoordinatore() { return Coordinatore.getText(); }

    public void setCoordinatore(String coordinatore) {Coordinatore.setText(coordinatore); }


    public String getKeynoteSpeaker() { return KeynoteSpeaker; }

    public void setKeynoteSpeaker(String keynoteSpeaker) {KeynoteSpeaker = keynoteSpeaker; }


    public String getLocazione() { return Locazione.getText(); }

    public void setLocazione(String locazione) { Locazione.setText(locazione); }


    public ArrayList<ModInterventoPanel> getInterventi() { return Interventi; }

    public JPanel getInterventiPanel() { return InterventiContainer; }

    public int getIntervento() { return InterventoComboBox.getSelectedIndex(); }

    public void setNInterventi(int nInterventi) {

    	InterventoComboBox = new InterventoComboBox(nInterventi, controller);
		ModificaInterventoContainer.add(InterventoComboBox);
    }
}