package GUI.UserFrames;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import myTools.myTemplates;

public class PswrdFld extends JPasswordField {
	
	myTemplates t = new myTemplates();
	
	public PswrdFld() {
		
		setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
		setForeground(t.tangaroa);
		setFont(t.myFont(18));
		setColumns(20);
	}
}