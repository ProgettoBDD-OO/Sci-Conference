package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myException.EmptyFieldException;
import myTools.TimeComboBox;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;


public class InterventiDialog extends JDialog {

	private Controller controller;

	private myTemplates t;
	int n = 1;
	
	private JLabel InterventoLbl;

	private TimeComboBox OraInizio;
	private TimeComboBox OraFine;
	private Calendar OraInizioC = Calendar.getInstance();
	private Calendar OraFineC = Calendar.getInstance();

	private JLabel PartecipantiLbl;
	private JComboBox<Integer> PartecipantiComboBox;
	private Integer[] nPartecipanti = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	private ArrayList<String> Partecipanti;

	private JTextArea IntervalliTxt;

	private JButton ConfermaBtn;

	public InterventiDialog(Controller c, String idSessione, int... nIntervento) {

		controller = c;
		t = new myTemplates();
		
		setSize(430, 430);
		setIconImage(t.miniLogo);
		setModal(true);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);

		InterventoLbl = new JLabel("Intervento 1");
		InterventoLbl.setPreferredSize(new Dimension(61, 50));
		InterventoLbl.setFont(t.myFont(22));
		InterventoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MainPanel.add(InterventoLbl, BorderLayout.NORTH);


		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(Color.WHITE);
		CentrPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][][][::30px][]"));
		MainPanel.add(CentrPanel, BorderLayout.CENTER);

			JPanel TimeContainer = new JPanel();
			TimeContainer.setBackground(new Color(255, 255, 255));
			TimeContainer.setLayout(new MigLayout("wrap, fill", "[][]", "[][]"));
			CentrPanel.add(TimeContainer, "cell 0 0, grow");

				JLabel OraInizioLbl = new JLabel("Ora Inizio:");
				OraInizioLbl.setForeground(t.scBlue);
				OraInizioLbl.setFont(t.myFont(16));
				TimeContainer.add(OraInizioLbl, "cell 0 0,alignx center,aligny center");

				JLabel OraFineLbl = new JLabel("Ora Fine:");
				OraFineLbl.setForeground(t.scBlue);
				OraFineLbl.setFont(t.myFont(16));
				TimeContainer.add(OraFineLbl, "cell 0 1,alignx center,aligny center");

				OraInizio = new TimeComboBox();
				TimeContainer.add(OraInizio, "cell 1 0, alignx center, aligny center");

				OraFine = new TimeComboBox();
				TimeContainer.add(OraFine, "cell 1 1, alignx center, aligny center");


			Partecipanti = new ArrayList<>();

			PartecipantiLbl = new JLabel("Partecipanti (seleziona il numero):");
			PartecipantiLbl.setForeground(t.scBlue);
			PartecipantiLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			CentrPanel.add(PartecipantiLbl, "cell 0 1,growx,aligny bottom");

			PartecipantiComboBox = new JComboBox<>();
			PartecipantiComboBox.setModel(new DefaultComboBoxModel<>(nPartecipanti));
			PartecipantiComboBox.setPreferredSize(new Dimension(100, 22));
			CentrPanel.add(PartecipantiComboBox, "cell 0 2,alignx left,aligny top");
			PartecipantiComboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					if (PartecipantiLbl.getText().equals("Partecipanti (seleziona il numero):")) {

						controller.goToPartecipanti("Aggiunta", idSessione + "0" + n);

					} else { controller.goToPartecipanti("", idSessione + "0" + nIntervento[0]); }
				}
			});

			JLabel IntervalliLbl = new JLabel("Specifica il giorno ed eventuali intervalli:");
			IntervalliLbl.setForeground(t.scBlue);
			IntervalliLbl.setFont(t.myFont(16));
			CentrPanel.add(IntervalliLbl, "cell 0 3,alignx left,aligny bottom");

			IntervalliTxt = new JTextArea();
			IntervalliTxt.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
			IntervalliTxt.setForeground(t.tangaroa);
			IntervalliTxt.setFont(t.myFont(16));
			CentrPanel.add(IntervalliTxt, "cell 0 4,grow");


		ConfermaBtn = new JButton("Prossimo Intervento");
		ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		ConfermaBtn.setPreferredSize(new Dimension(79, 40));
		ConfermaBtn.setForeground(t.white);
		ConfermaBtn.setBackground(t.scBlue);
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		ConfermaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					if (PartecipantiLbl.getText().equals("Partecipanti (seleziona il numero):")) {

						controller.addInterventi(idSessione, n); n ++;

					} else { controller.modificaInterventi(idSessione); n ++; }

				} catch (EmptyFieldException efe) {

					JOptionPane.showMessageDialog(InterventiDialog.this, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
					System.out.println(efe);
				} catch (DateTimeException dte) {

					JOptionPane.showMessageDialog(InterventiDialog.this, dte.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
					System.out.println(dte);
				}
			}
		});
	}

	public void setInterventoLbl(String txt) { InterventoLbl.setText(txt); }

	public void setPartecipantiLbl(String txt) { PartecipantiLbl.setText(txt); }

	public TimeComboBox getOraInizio() { return OraInizio; }

	public TimeComboBox getOraFine() { return OraFine; }

	public Calendar getOraInizioC() {

		OraInizioC.set(Calendar.HOUR_OF_DAY, OraInizio.getHour());
		OraInizioC.set(Calendar.MINUTE, OraInizio.getMinute());

		return OraInizioC;
	}

	public Calendar getOraFineC() {

		OraFineC.set(Calendar.HOUR_OF_DAY, OraFine.getHour());
		OraFineC.set(Calendar.MINUTE, OraFine.getMinute());

		return OraFineC;
	}

	public JComboBox<Integer> getnPartecipanti(){ return PartecipantiComboBox; }

	public ArrayList<String> getPartecipanti() { return Partecipanti; }

	public String getDescrizione() { return IntervalliTxt.getText(); }

	public void setDescrizione(String txt) { IntervalliTxt.setText(txt); }

	public void setConfermaBtnTxt(String txt) { ConfermaBtn.setText(txt); }

	public void nextIntervento() {

		InterventoLbl.setText("Intervento " + (n + 1));
		OraInizio.resetFields();
		OraFine.resetFields();
		IntervalliTxt.setText("");
		Partecipanti.clear();
		PartecipantiComboBox.setEnabled(true);
	}
}