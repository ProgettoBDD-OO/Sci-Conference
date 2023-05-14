package GUI.AdminFrames;

import javax.swing.JDialog;
import javax.swing.JPanel;

import linker.Controller;
import myException.EmptyFieldException;
import myTools.TimeComboBox;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;

public class InterventiDialog extends JDialog {

	private Controller controller;
	
	private myTemplates t = new myTemplates();

	int n = 1;
	private JLabel InterventoLbl;

	private TimeComboBox OraInizio;
	private TimeComboBox OraFine;
	private Calendar OraInizioC = Calendar.getInstance();
	private Calendar OraFineC = Calendar.getInstance();
	
	private JComboBox<Integer> NumeroPartecipanti;
	private Integer[] nPartecipanti = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	private ArrayList<String> Partecipanti;
	
	private JTextArea IntervalliTxt;
	
	public InterventiDialog(Controller c, String idSessione) {
		
		controller = c;
		setSize(430, 430);
		setIconImage(t.MiniLogo);
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
		
			JPanel TimeConteiner = new JPanel();
			TimeConteiner.setBackground(new Color(255, 255, 255));
			TimeConteiner.setLayout(new MigLayout("wrap, fill", "[][]", "[][]"));
			CentrPanel.add(TimeConteiner, "cell 0 0, grow");
			
				JLabel OraInizioLbl = new JLabel("Ora Inizio:");
				OraInizioLbl.setForeground(t.scBlue);
				OraInizioLbl.setFont(t.myFont(16));
				TimeConteiner.add(OraInizioLbl, "cell 0 0,alignx center,aligny center");
				
				JLabel OraFineLbl = new JLabel("Ora Fine:");
				OraFineLbl.setForeground(t.scBlue);
				OraFineLbl.setFont(t.myFont(16));
				TimeConteiner.add(OraFineLbl, "cell 0 1,alignx center,aligny center");
				
				OraInizio = new TimeComboBox();
				TimeConteiner.add(OraInizio, "cell 1 0, alignx center, aligny center");
				
				OraFine = new TimeComboBox();
				TimeConteiner.add(OraFine, "cell 1 1, alignx center, aligny center");
				
				
			Partecipanti = new ArrayList<String>();
			
			JLabel PartecipantiLbl = new JLabel("Partecipanti (seleziona il numero):");
			PartecipantiLbl.setForeground(new Color(0, 0, 200));
			PartecipantiLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			CentrPanel.add(PartecipantiLbl, "cell 0 1,growx,aligny bottom");
				
			NumeroPartecipanti = new JComboBox<Integer>();
			NumeroPartecipanti.setModel(new DefaultComboBoxModel<Integer>(nPartecipanti));
			NumeroPartecipanti.setPreferredSize(new Dimension(100, 22));
			CentrPanel.add(NumeroPartecipanti, "cell 0 2,alignx left,aligny top");
			NumeroPartecipanti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.goToPartecipanti(idSessione + "0" + n);
				}
			});
			
			JLabel IntervalliLbl = new JLabel("Specifica il giorno ed eventuali intervalli:");
			IntervalliLbl.setForeground(new Color(0, 0, 200));
			IntervalliLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			CentrPanel.add(IntervalliLbl, "cell 0 3,alignx left,aligny bottom");
			
			IntervalliTxt = new JTextArea();
			IntervalliTxt.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 200)));
			IntervalliTxt.setForeground(t.scBlue);
			IntervalliTxt.setFont(t.myFont(16));
			CentrPanel.add(IntervalliTxt, "cell 0 4,grow");
			
			
		JButton ConfermaBtn = new JButton("Prossimo Intervento");
		ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		ConfermaBtn.setPreferredSize(new Dimension(79, 40));
		ConfermaBtn.setForeground(t.white);
		ConfermaBtn.setBackground(new Color(0, 0, 200));
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		ConfermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.addQueryInterventi("('" + idSessione + "0" + n + "', '" + getOraInizio() + "', '" + getOraFine() + "', '" + idSessione + "', '" + getDescrizione() + "'), ", n);
				
				} catch (EmptyFieldException efe) {
					
					JOptionPane.showMessageDialog(InterventiDialog.this, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
					System.out.println(efe);
				} catch (DateTimeException dte) {
					
					JOptionPane.showMessageDialog(InterventiDialog.this, dte.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
					System.out.println(dte);
				}
				n ++;
			}
		});
	}
	
	public String getOraInizio() { return OraInizio.gethhmm(); }
	
	public String getOraFine() { return OraFine.gethhmm(); }
	
	public Calendar getOraInizioC() {
		
		OraInizioC.set(Calendar.HOUR, OraInizio.getHour());
		OraInizioC.set(Calendar.MINUTE, OraInizio.getMinute());
		
		return OraInizioC;
	}
	
	public Calendar getOraFineC() {
		
		OraFineC.set(Calendar.HOUR, OraFine.getHour());
		OraFineC.set(Calendar.MINUTE, OraFine.getMinute());
		
		return OraFineC;
	}
	
	public JComboBox<Integer> getnPartecipanti(){ return NumeroPartecipanti; }
	
	public ArrayList<String> getPartecipanti() { return Partecipanti; }

	
	public String getDescrizione() { return IntervalliTxt.getText(); }
	
	
	public void nextIntervento() {
		
		InterventoLbl.setText("Intervento " + (n + 1));
		OraInizio.resetFields();
		OraFine.resetFields();
		IntervalliTxt.setText("");
		Partecipanti.clear();
		NumeroPartecipanti.setEnabled(true);
	}
	
	public boolean fieldsAreEmpty() {
		
		if (getOraInizio().isEmpty() || getOraFine().isEmpty() || getDescrizione().isEmpty()) {
			
			return true;
			
		} else { return false; }
	}
}