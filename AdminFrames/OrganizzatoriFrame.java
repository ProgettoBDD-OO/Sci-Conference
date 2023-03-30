package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import linker.ControllerLink;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrganizzatoriFrame extends JFrame {

	ControllerLink controllerLink;
	
	private JLabel OrganizzatoreLbl;
	private JTextField NomeFld;
	private JTextField EmailFld;
	private JTextField TitoloFld;
	private JTextField AfferenzaFld;
	int n = 2;
	
	public OrganizzatoriFrame(ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
		setSize(400, 300);
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(255, 255, 255));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		OrganizzatoreLbl = new JLabel("Organizzatore 1");
		OrganizzatoreLbl.setForeground(new Color(0, 0, 200));
		OrganizzatoreLbl.setBorder(new EmptyBorder(10, 0, 0, 0));
		OrganizzatoreLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		OrganizzatoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MainPanel.add(OrganizzatoreLbl, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(new MigLayout("wrap, fill", "[][grow]", "[][][][]"));
		MainPanel.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Nome-cognome");
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel.add(lblNewLabel_1, "cell 0 0,alignx trailing,aligny center");
		
		NomeFld = new JTextField();
		NomeFld.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel.add(NomeFld, "cell 1 0,growx,aligny center");
		NomeFld.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel.add(lblNewLabel_2, "cell 0 1,alignx center,aligny center");
		
		EmailFld = new JTextField();
		EmailFld.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel.add(EmailFld, "cell 1 1,growx,aligny center");
		EmailFld.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Titolo");
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel.add(lblNewLabel_3, "cell 0 2,alignx center,aligny center");
		
		TitoloFld = new JTextField();
		TitoloFld.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel.add(TitoloFld, "cell 1 2,growx,aligny center");
		TitoloFld.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Afferenza");
		lblNewLabel_4.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel.add(lblNewLabel_4, "cell 0 3,alignx center,aligny center");
		
		AfferenzaFld = new JTextField();
		AfferenzaFld.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		panel.add(AfferenzaFld, "cell 1 3,growx,aligny center");
		AfferenzaFld.setColumns(10);
		
		
		JButton ConfermaBtn = new JButton("Conferma");
		ConfermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controllerLink.addOrganizzatore("('" + getNome() + "', '" + getEmail() + "', '" + getTitolo() + "', '" + getAfferenza() + "'),\n", n);
				n++;
			}
		});
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
	}
	
	public String getNome() { return NomeFld.getText(); }

    public String getEmail() { return EmailFld.getText(); }

    public String getTitolo() { return TitoloFld.getText(); }

    public String getAfferenza() { return AfferenzaFld.getText(); }
    
    public void nextOrganizzatore(int i) {
    	
    	NomeFld.setText("");
    	EmailFld.setText("");
    	TitoloFld.setText("");
    	AfferenzaFld.setText("");
    	OrganizzatoreLbl.setText("Organizzatore " + i);
    }
}