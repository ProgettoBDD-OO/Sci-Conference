package GUI.AdminFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import linker.Controller;
import java.awt.Component;

public class ModInterventoPanel extends JPanel {
	
	private Controller controller;
	
	public ModInterventoPanel(String idSessione, Controller c) {
		
		controller = c;
		
		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel InterventoLbl = new JLabel("Intervento n");
		InterventoLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		InterventoLbl.setBorder(new EmptyBorder(20, 0, 0, 0));
		InterventoLbl.setPreferredSize(new Dimension(46, 50));
		InterventoLbl.setForeground(new Color(0, 0, 200));
		InterventoLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		add(InterventoLbl);
	}
}