package GUI.UserFrames;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import myTools.myTemplates;

public class UserFld extends JTextField {
	
	myTemplates t = new myTemplates();
	
	public UserFld() {
		
		setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
		setForeground(t.tangaroa);
		setFont(t.myFont(18));
		setColumns(20);
	}
}