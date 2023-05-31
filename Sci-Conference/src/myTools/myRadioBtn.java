package myTools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JRadioButton;


public class myRadioBtn extends JRadioButton {

	public myRadioBtn(String txt, Color c, int grandezzaFont) {

		setText(txt);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setForeground(c);
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Calibri Light", Font.PLAIN, grandezzaFont));
		setActionCommand(txt);
	}
}