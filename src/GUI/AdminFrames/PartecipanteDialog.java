package GUI.AdminFrames;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import linker.Controller;
import myException.EnteNotFoundException;
import myTools.myTemplates;
import myTools.myTxtFld;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dimension;

public class PartecipanteDialog extends JDialog {

	Controller controller;
	
	private myTemplates t = new myTemplates();
	
	private JLabel PartecipanteLbl;
	private JTextField EmailFld;
	private JTextField TitoloFld;
	private JTextField NomeFld;
	private JTextField CognomeFld;
	private JTextField AfferenzaFld;
	int n = 1;
	
	public PartecipanteDialog(String comingFrom, String idIntervento, Controller c) {
		
		controller = c;
		
		setSize(400, 450);
		setModal(true);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		PartecipanteLbl = new JLabel("Partecipante 1");
		PartecipanteLbl.setPreferredSize(new Dimension(77, 50));
		PartecipanteLbl.setForeground(t.gray);
		PartecipanteLbl.setBorder(new EmptyBorder(10, 0, 0, 0));
		PartecipanteLbl.setFont(t.myFont(24));
		PartecipanteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MainPanel.add(PartecipanteLbl, BorderLayout.NORTH);
		
		
		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(t.white);
		CentrPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][][][][]"));
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		
			TitoloFld = new myTxtFld("Titolo", controller);
			CentrPanel.add(TitoloFld, "cell 0 0,growx,aligny center");
			
			EmailFld = new myTxtFld("Email", controller);
			CentrPanel.add(EmailFld, "cell 0 1,growx,aligny center");
			
			NomeFld = new myTxtFld("Nome", controller);
			CentrPanel.add(NomeFld, "cell 0 2,growx,aligny center");
			
			CognomeFld = new myTxtFld("Cognome", controller);
			CentrPanel.add(CognomeFld, "cell 0 3,growx,aligny center");
			
			AfferenzaFld = new myTxtFld("Afferenza", controller);
			CentrPanel.add(AfferenzaFld, "cell 0 4,growx,aligny center");
		
		
		JButton ConfermaBtn = new JButton("Conferma");
		ConfermaBtn.setPreferredSize(new Dimension(79, 40));
		ConfermaBtn.setForeground(t.white);
		ConfermaBtn.setBackground(t.scBlue);
		ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		ConfermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comingFrom.equals("Aggiunta")) {
					
					controller.addQueryPartecipante(" CALL insert_partecipante('" + getEmail() + "', '" + getTitolo() + "', '" + getNome() + "', '"+ getCognome() +"', '" + getAfferenza() + "', " + idIntervento + "); ", n);
					
				} else {
					controller.addQueryModPartecipante(" CALL insert_partecipante('" + getEmail() + "', '" + getTitolo() + "', '" + getNome() + "', '"+ getCognome() +"', '" + getAfferenza() + "', " + idIntervento + "); ", n);
				}
				n++;
			}
		});
	}

	public String getEmail() { return  EmailFld.getText(); }

	public String getTitolo() { return TitoloFld.getText(); }
	
	public String getNome() { return NomeFld.getText(); }

	public String getCognome() { return CognomeFld.getText(); }

    public String getAfferenza() { return AfferenzaFld.getText(); }
    
    public void nextPartecipante() {
    	
    	PartecipanteLbl.setText("Partecipante " + n);
    	NomeFld.setText("Nome");
    	CognomeFld.setText("Cognome");
    	EmailFld.setText("Email");
    	TitoloFld.setText("Titolo");
    	AfferenzaFld.setText("Afferenza");
    }
    
    public boolean fieldsAreEmpty() {
    	
    	if (isEmpty(getEmail(), "Email") || isEmpty(getTitolo(), "Titolo") || isEmpty(getNome(), "Nome") || isEmpty(getCognome(), "Cognome") || isEmpty(getAfferenza(), "Afferenza")) {
			
    		return true;
		
    	} else { return false; }
    }
    
    public boolean isEmpty(String txt, String txt2) {
		
		if (txt.isEmpty() || txt.equals(txt2)) { return true; }
		
		else { return false; }
	}
}