package GUI.AdminFrames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class InfoTxtFld extends JTextField {

	public InfoTxtFld() {
		
		setColumns(23);
		setFont(new Font("Calibri Light", Font.PLAIN, 14));
		setMinimumSize(new Dimension(10, 30));
		setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 200)));
	}
}