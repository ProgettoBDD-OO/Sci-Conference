package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class EntiLbl extends JLabel {

	public EntiLbl(String txt) {

		setText(txt + ")");
		setFont(new Font("Calibri Light", Font.PLAIN, 14));
		setForeground(new Color(30, 47, 60));
		setBorder(new EmptyBorder(0, 17, 0, 0));
		setAlignmentY(Component.CENTER_ALIGNMENT);
	}
}