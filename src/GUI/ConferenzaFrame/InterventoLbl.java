package GUI.ConferenzaFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class InterventoLbl extends JLabel{

	public InterventoLbl(String txt) {
		
		setText(txt);
		setForeground(new Color(0, 0, 200));
		setFont(new Font("Calibri Light", Font.PLAIN, 18));
		setBorder(new EmptyBorder(15, 0, 0, 0));
		setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}