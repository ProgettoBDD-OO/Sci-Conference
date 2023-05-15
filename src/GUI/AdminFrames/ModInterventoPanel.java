package GUI.AdminFrames;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import linker.Controller;

public class ModInterventoPanel extends JPanel {
	
	private Controller controller;
	
	private JPanel CentrPanel;
	private PartecipanteComboBox NumeroPartecipanti;
	
	public ModInterventoPanel(String idSessione, Controller c) {
		
		controller = c;
		
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel InterventoLbl = new JLabel("Intervento n");
		InterventoLbl.setBorder(new EmptyBorder(20, 0, 0, 0));
		InterventoLbl.setPreferredSize(new Dimension(46, 50));
		InterventoLbl.setForeground(new Color(0, 0, 200));
		InterventoLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		InterventoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(InterventoLbl, BorderLayout.NORTH);
		
		CentrPanel = new JPanel();
		CentrPanel.setBackground(new Color(255, 255, 255));
		CentrPanel.setLayout(new BoxLayout(CentrPanel, BoxLayout.Y_AXIS));
		add(CentrPanel, BorderLayout.CENTER);
		
		NumeroPartecipanti = new PartecipanteComboBox(idSessione, controller);
		add(NumeroPartecipanti, BorderLayout.SOUTH);
	}
	
	public JPanel getCentrPanel() { return CentrPanel; }
	
	public PartecipanteComboBox getNumeroPartecipanti() { return NumeroPartecipanti; }
}