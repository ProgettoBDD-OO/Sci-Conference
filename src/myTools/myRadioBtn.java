package myTools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JRadioButton;

public class myRadioBtn extends JRadioButton {

	public myRadioBtn(String text, Color c) {
		
		setText(text);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setForeground(c);
		setBackground(new Color(246, 247, 248));
		setFont(new Font("Calibri Light", Font.PLAIN, 18));
		setActionCommand(text);
	}	
}