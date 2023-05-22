package GUI.AdminFrames;

import linker.Controller;
import myException.EmptyFieldException;
import myException.NoInterventionException;
import myTools.DateComboBox;
import myTools.myTemplates;
import myTools.myTxtFld;

import java.util.ArrayList;
import java.util.Calendar;
import java.time.DateTimeException;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;


public class SessioneDialog extends JDialog {
	
	private Controller controller;
	
	private myTemplates t = new myTemplates();
	
	int n = 1;
	private JLabel SessioneLbl;

	private Calendar DataInizioC = Calendar.getInstance();
	private Calendar DataFineC = Calendar.getInstance();
	private DateComboBox DataInizio;
	private DateComboBox DataFine;
	
	private myTxtFld LocazioneFld;
	private myTxtFld CoordinatoreFld;
	private String KeynoteSpeaker = "nessuno";
	
	private JComboBox<Integer> InterventiComboBox;
	private ArrayList<Component> Interventi;
	private Integer[] nInterventi = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	
	
	public SessioneDialog(Controller c, int nextIdConf) {
		
		controller = c;
		
		setSize(430, 475);
		setLocationRelativeTo(null);
		setIconImage(t.miniLogo);
		setModal(true);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
			SessioneLbl = new JLabel("Sessione 1");
			SessioneLbl.setPreferredSize(new Dimension(77, 50));
			SessioneLbl.setForeground(t.gray);
			SessioneLbl.setBorder(new EmptyBorder(10, 0, 0, 0));
			SessioneLbl.setFont(t.myFont(24));
			SessioneLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(SessioneLbl, BorderLayout.NORTH);
		
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(t.white);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][][][][][]"));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
					
					JPanel DateConteiner = new JPanel();
					DateConteiner.setBackground(t.white);
					CentrPanel.add(DateConteiner, "cell 0 0, grow");
					DateConteiner.setLayout(new MigLayout("wrap, fill", "[][]", "[][]"));
					
					JLabel DataOraInizioLbl = new JLabel("Data e ora di inizio:");
					DataOraInizioLbl.setForeground(t.scBlue);
					DataOraInizioLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					DateConteiner.add(DataOraInizioLbl, "cell 0 0, alignx left, aligny center");
					
					DataInizio = new DateComboBox();
					DateConteiner.add(DataInizio, "cell 1 0,alignx center,aligny center");
					
					JLabel DataOraFineLbl = new JLabel("Data e ora di fine:");
					DataOraFineLbl.setForeground(t.scBlue);
					DataOraFineLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					DateConteiner.add(DataOraFineLbl, "flowx,cell 0 1,alignx left,aligny center");
					
					DataFine = new DateComboBox();
					DateConteiner.add(DataFine, "cell 1 1, alignx center, aligny center");
				
				LocazioneFld = new myTxtFld("Locazione", controller);
				CentrPanel.add(LocazioneFld, "cell 0 1,growx,aligny center");
				
				CoordinatoreFld = new myTxtFld("Coordinatore", controller);
				CentrPanel.add(CoordinatoreFld, "cell 0 2,growx,aligny center");
				
				JButton KeynoteSpeakerBtn = new JButton("Inserisci Keynote Speaker (opzionale)");
				KeynoteSpeakerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				KeynoteSpeakerBtn.setBackground(t.scBlue);
				KeynoteSpeakerBtn.setForeground(t.white);
				KeynoteSpeakerBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
				KeynoteSpeakerBtn.setPreferredSize(new Dimension(213, 35));
				CentrPanel.add(KeynoteSpeakerBtn, "cell 0 3,alignx center,aligny center");
				KeynoteSpeakerBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.goToKeynote();
					}
				});
				
				Interventi = new ArrayList<Component>();
				
				JLabel InterventiLbl = new JLabel("Interventi (seleziona il numero):");
				CentrPanel.add(InterventiLbl, "cell 0 4,alignx left,aligny bottom");
				InterventiLbl.setForeground(t.scBlue);
				InterventiLbl.setFont(t.myFont(16));
				
				InterventiComboBox = new JComboBox<Integer>();
				InterventiComboBox.setModel(new DefaultComboBoxModel<Integer>(nInterventi));
				InterventiComboBox.setPreferredSize(new Dimension(100, 22));
				CentrPanel.add(InterventiComboBox, "flowx,cell 0 5,alignx left,aligny top");
				InterventiComboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.goToInterventi(nextIdConf + "0" + n);
					}
				});
		
				
		JButton ConfermaBtn = new JButton("Prossima Sessione");
		ConfermaBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ConfermaBtn.setPreferredSize(new Dimension(79, 40));
		ConfermaBtn.setForeground(t.white);
		ConfermaBtn.setBackground(t.scBlue);
		ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		ConfermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					controller.addSessione(n);
					n++;
					
				} catch (EmptyFieldException efe) {
					
					System.out.println(efe);
					JOptionPane.showMessageDialog(SessioneDialog.this, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
					
				} catch (NoInterventionException nie) {
					
					System.out.println(nie);
					JOptionPane.showMessageDialog(SessioneDialog.this, nie.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
					
				} catch (DateTimeException dte) {
					
					System.out.println(dte);
					JOptionPane.showMessageDialog(SessioneDialog.this, dte.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public String getDataInizio() { return DataInizio.getAAMMGG(); }
	
	public String getDataFine() { return DataFine.getAAMMGG(); }
	
	public Calendar getDataInizioC() {
    	
    	DataInizioC.set(DataInizio.getYear(), DataInizio.getMonth(), DataInizio.getDay());
    	return DataInizioC;
    }
    
    public Calendar getDataFineC() {
    	
    	DataFineC.set(DataFine.getYear(), DataFine.getMonth(), DataFine.getDay());
		return DataFineC;
    }
	
    public String getLocazione() { return LocazioneFld.getText(); }
	
    public String getCoordinatore() { return CoordinatoreFld.getText(); }

    public String getKeynoteSpeaker() { return KeynoteSpeaker; }
	
    public void setKeynoteSpeaker(String keynoteSpeaker) { KeynoteSpeaker = keynoteSpeaker; }
    
	public JComboBox<Integer> getnInterventi() { return InterventiComboBox; }
	
	public ArrayList<Component> getInterventi() { return Interventi; }
	
	public void nextSessione() {
		
		SessioneLbl.setText("Sessione " + (n + 1));
		DataInizio.resetFields();
		DataFine.resetFields();
		
		CoordinatoreFld.setFont(new Font("Calibri Light", Font.ITALIC, 14));
		CoordinatoreFld.setForeground(t.altGray);
		CoordinatoreFld.setText("Coordinatore");
		
		LocazioneFld.setFont(new Font("Calibri Light", Font.ITALIC, 14));
		LocazioneFld.setForeground(t.altGray);
		LocazioneFld.setText("Locazione");
		InterventiComboBox.setEnabled(true);
	}
	
	public boolean FieldsAreEmpty() {
		
		if (isEmpty(getCoordinatore(), "Coordinatore") || getDataInizio().isEmpty() 
		   || getDataFine().isEmpty() || isEmpty(getLocazione(), "Locazione")) {
			
			return true;
		} else { return false; }
	}
	
	public boolean isEmpty(String txt, String txt2) {
		
		if (txt.isEmpty() || txt.equals(txt2)) { return true; }
		
		else { return false; }
	}
}