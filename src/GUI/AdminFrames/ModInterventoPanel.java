package GUI.AdminFrames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ModInterventoPanel extends JPanel {

	public ModInterventoPanel(String idSessione) {

		setMaximumSize(new Dimension(32767, 150));
		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentY(Component.TOP_ALIGNMENT);
		
		JLabel InterventoLbl = new JLabel("Intervento n");
		InterventoLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		InterventoLbl.setBorder(new EmptyBorder(20, 0, 0, 0));
		InterventoLbl.setPreferredSize(new Dimension(46, 50));
		InterventoLbl.setForeground(new Color(0, 0, 200));
		InterventoLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		add(InterventoLbl);
	}
}