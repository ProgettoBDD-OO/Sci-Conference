package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import linker.ControllerLink;
import myException.EnteNotFoundException;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dimension;

public class OrganizzatoriFrame extends JDialog {

	ControllerLink controllerLink;
	
	private myTemplates t = new myTemplates();
	
	private JLabel OrganizzatoreLbl;
	private JTextField EmailFld;
	private JTextField TitoloFld;
	private JTextField NomeFld;
	private JTextField CognomeFld;
	private JTextField AfferenzaFld;
	int n = 1;
	
	public OrganizzatoriFrame(ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
		setSize(400, 450);
		setModal(true);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		OrganizzatoreLbl = new JLabel("Organizzatore 1");
		OrganizzatoreLbl.setPreferredSize(new Dimension(77, 50));
		OrganizzatoreLbl.setForeground(t.gray);
		OrganizzatoreLbl.setBorder(new EmptyBorder(10, 0, 0, 0));
		OrganizzatoreLbl.setFont(t.myFont(24));
		OrganizzatoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MainPanel.add(OrganizzatoreLbl, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(t.white);
		panel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][][][][]"));
		MainPanel.add(panel, BorderLayout.CENTER);
		
		TitoloFld = new JTextField();
		TitoloFld.setPreferredSize(new Dimension(7, 30));
		TitoloFld.setForeground(t.scBlue);
		TitoloFld.setText("Titolo");
		TitoloFld.setFont(t.myFont(14));
		panel.add(TitoloFld, "cell 0 0,growx,aligny center");
		
		EmailFld = new JTextField();
		EmailFld.setPreferredSize(new Dimension(7, 30));
		EmailFld.setForeground(t.scBlue);
		EmailFld.setText("Email");
		EmailFld.setFont(t.myFont(14));
		panel.add(EmailFld, "cell 0 1,growx,aligny center");
		
		NomeFld = new JTextField();
		NomeFld.setPreferredSize(new Dimension(7, 30));
		NomeFld.setForeground(t.scBlue);
		NomeFld.setText("Nome");
		NomeFld.setFont(t.myFont(14));
		panel.add(NomeFld, "cell 0 2,growx,aligny center");
		
		CognomeFld = new JTextField();
		CognomeFld.setPreferredSize(new Dimension(7, 30));
		CognomeFld.setForeground(t.scBlue);
		CognomeFld.setText("Cognome");
		CognomeFld.setFont(t.myFont(14));
		panel.add(CognomeFld, "cell 0 3,growx,aligny center");
		
		AfferenzaFld = new JTextField();
		AfferenzaFld.setPreferredSize(new Dimension(7, 30));
		AfferenzaFld.setForeground(t.scBlue);
		AfferenzaFld.setText("Afferenza");
		AfferenzaFld.setFont(t.myFont(14));
		panel.add(AfferenzaFld, "cell 0 4,growx,aligny center");
		
		
		JButton ConfermaBtn = new JButton("Conferma");
		ConfermaBtn.setPreferredSize(new Dimension(79, 40));
		ConfermaBtn.setForeground(t.white);
		ConfermaBtn.setBackground(t.scBlue);
		ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		ConfermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controllerLink.addOrganizzatore("('" + getEmail() + "', '" + getTitolo() + "', '" + getNome() + "', '"+ getCognome() +"', '" + getAfferenza() + "'), ", n);
				
				n++;
			}
		});
	}

	public String getEmail() { return  EmailFld.getText(); }

	public String getTitolo() { return TitoloFld.getText(); }
	
	public String getNome() { return NomeFld.getText(); }

	public String getCognome() { return CognomeFld.getText(); }

    public String getAfferenza() { return AfferenzaFld.getText(); }
    
    public void nextOrganizzatore() {
    	
    	NomeFld.setText("");
    	EmailFld.setText("");
    	TitoloFld.setText("");
    	AfferenzaFld.setText("");
    	OrganizzatoreLbl.setText("Organizzatore " + n);
    }
}