package GUI.AdminFrames;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import linker.Controller;
import myException.EmptyFieldException;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dimension;
import myTools.myTxtFld;

public class KeynoteDialog extends JDialog {

	Controller controller;
	
	private myTemplates t = new myTemplates();
	private myTxtFld EmailFld;
	private myTxtFld TitoloFld;
	private myTxtFld NomeFld;
	private myTxtFld CognomeFld;
	private myTxtFld AfferenzaFld;
	
	public KeynoteDialog(Controller c) {
		
		controller = c;
		
		setSize(400, 450);
		setModal(true);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel KeynoteLbl = new JLabel("Keynote Speaker");
		KeynoteLbl.setPreferredSize(new Dimension(77, 50));
		KeynoteLbl.setForeground(t.gray);
		KeynoteLbl.setBorder(new EmptyBorder(10, 0, 0, 0));
		KeynoteLbl.setFont(t.myFont(24));
		KeynoteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MainPanel.add(KeynoteLbl, BorderLayout.NORTH);
		
		
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
		ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ConfermaBtn.setPreferredSize(new Dimension(79, 40));
		ConfermaBtn.setForeground(t.white);
		ConfermaBtn.setBackground(t.scBlue);
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		ConfermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					controller.addQueryKeynote();
				
				} catch (EmptyFieldException efe) {
					
					System.out.println(efe);
					JOptionPane.showMessageDialog(KeynoteDialog.this, efe.getMessage(), "Dati incorretti", JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
	}

	public String getEmail() { return  EmailFld.getText(); }

	public String getTitolo() { return TitoloFld.getText(); }
	
	public String getNome() { return NomeFld.getText(); }

	public String getCognome() { return CognomeFld.getText(); }

    public String getAfferenza() { return AfferenzaFld.getText(); }
    
    
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