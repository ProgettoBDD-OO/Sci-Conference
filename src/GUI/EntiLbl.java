package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class EntiLbl extends JLabel {
	
	public EntiLbl(String Txt, int grandezzaFont) {
		
		setText(Txt);
		setFont(new Font("Calibri Light", Font.PLAIN, grandezzaFont));
		setForeground(new Color(30, 47, 60));
		setBorder(new EmptyBorder(0, 20, 0, 0));
	}
}		