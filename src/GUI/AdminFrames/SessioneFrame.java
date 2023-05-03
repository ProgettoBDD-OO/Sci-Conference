package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import linker.ControllerLink;
import myTools.DateComboBox;
import myTools.myTemplates;

public class SessioneFrame extends JDialog {
	
	private ControllerLink controllerLink;
	
	private myTemplates t = new myTemplates();
	
	private JLabel SessioneLbl;

	private DateComboBox DataInizio;
	private JTextField OraInizioFld;
	private JTextField MinutoInizioFld;
	
	private DateComboBox DataFine;
	private JTextField OraFineFld;
	private JTextField MinutoFineFld;
	
	private JTextField CoordinatoreFld;
	private JTextField KeynoteSpeakerFld;
	int n = 1;

	public SessioneFrame(ControllerLink contrLink, int nextIdConf) {
		
		controllerLink = contrLink;
		
		setSize(430, 400);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		setModal(true);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
			SessioneLbl = new JLabel("Sessione 1");
			SessioneLbl.setPreferredSize(new Dimension(77, 50));
			SessioneLbl.setForeground(t.gray);
			SessioneLbl.setBorder(new EmptyBorder(10, 0, 0, 0));
			SessioneLbl.setFont(t.myFont(24));
			SessioneLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(SessioneLbl, BorderLayout.NORTH);
		
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(Color.WHITE);
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][][]"));
					
					JPanel DateConteiner = new JPanel();
					DateConteiner.setBackground(new Color(255, 255, 255));
					CentrPanel.add(DateConteiner, "cell 0 0,grow");
					DateConteiner.setLayout(new MigLayout("wrap, fill", "[130px:n][::150px]20[::35px,][::5px][::35px]", "[][]"));
					
					JLabel DataOraInizioLbl = new JLabel("Data e ora di inizio:");
					DataOraInizioLbl.setForeground(new Color(0, 0, 200));
					DataOraInizioLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					DateConteiner.add(DataOraInizioLbl, "cell 0 0,alignx left,aligny center");
					
					DataInizio = new DateComboBox();
					DateConteiner.add(DataInizio, "cell 1 0,alignx center,aligny center");
					
					OraInizioFld = new JTextField();
					DateConteiner.add(OraInizioFld, "cell 2 0,alignx right,aligny center");
					OraInizioFld.setColumns(3);
					
					JLabel DuePuntiLbl1 = new JLabel(":");
					DuePuntiLbl1.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					DateConteiner.add(DuePuntiLbl1, "cell 3 0,alignx center");
					
					MinutoInizioFld = new JTextField();
					DateConteiner.add(MinutoInizioFld, "cell 4 0,alignx left,aligny center");
					MinutoInizioFld.setColumns(3);
					
					JLabel DataOraFineLbl = new JLabel("Data e ora di fine:");
					DataOraFineLbl.setForeground(new Color(0, 0, 200));
					DataOraFineLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					DateConteiner.add(DataOraFineLbl, "cell 0 1,alignx left,aligny center");
					
					DataFine = new DateComboBox();
					DateConteiner.add(DataFine, "cell 1 1,alignx center,aligny center");
					
					OraFineFld = new JTextField();
					OraFineFld.setColumns(3);
					DateConteiner.add(OraFineFld, "cell 2 1,alignx right");
					
					JLabel DuePuntiLbl2 = new JLabel(":");
					DuePuntiLbl1.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					DateConteiner.add(DuePuntiLbl2, "cell 3 1,alignx center");
					
					MinutoFineFld = new JTextField();
					MinutoFineFld.setColumns(3);
					DateConteiner.add(MinutoFineFld, "cell 4 1,alignx left");
				
					CoordinatoreFld = new JTextField();
					CoordinatoreFld.setColumns(30);
					CoordinatoreFld.setPreferredSize(new Dimension(7, 30));
					CoordinatoreFld.setForeground(t.scBlue);
					CoordinatoreFld.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					CoordinatoreFld.setText("Coordinatore");
					CentrPanel.add(CoordinatoreFld, "cell 0 1,alignx left,aligny center");
				
				KeynoteSpeakerFld = new JTextField();
				KeynoteSpeakerFld.setColumns(30);
				KeynoteSpeakerFld.setPreferredSize(new Dimension(7, 30));
				KeynoteSpeakerFld.setForeground(t.scBlue);
				KeynoteSpeakerFld.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				KeynoteSpeakerFld.setText("Keynote Speaker");
				CentrPanel.add(KeynoteSpeakerFld, "cell 0 2,alignx left,aligny center");
		
		
		JButton ConfermaBtn = new JButton("Prossima Sessione");
		ConfermaBtn.setPreferredSize(new Dimension(79, 40));
		ConfermaBtn.setForeground(t.white);
		ConfermaBtn.setBackground(t.scBlue);
		ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		ConfermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controllerLink.addSessione("('" + nextIdConf + "0" + n + "', '" + getDataOraInizio() + "', '" + getDataOraFine() + "', '" + getCoordinatore() + "', '" + getKeynoteSpeaker() + "', '" + nextIdConf + "'), ", n);
				n++;
			}
		});
	}
	
	public String getDataOraInizio() {
		 return DataInizio.getAAMMGG() + " " + OraInizioFld.getText() + ":" + MinutoInizioFld.getText() + ":00";
	}
	
	public String getDataOraFine() {
		 return DataFine.getAAMMGG() + " " + OraFineFld.getText() + ":" + MinutoFineFld.getText() + ":00";
	}
	
	public String getCoordinatore() { return CoordinatoreFld.getText(); }
	
	public String getKeynoteSpeaker() { return KeynoteSpeakerFld.getText(); }
	
	public void nextSessione() {
		
		DataInizio.resetFields();
		DataFine.resetFields();
		OraInizioFld.setText("");
		MinutoInizioFld.setText("");
		OraFineFld.setText("");
		MinutoFineFld.setText("");
		CoordinatoreFld.setText("");
		KeynoteSpeakerFld.setText("");
		SessioneLbl.setText("Sessione " + (n + 1));
	}
}