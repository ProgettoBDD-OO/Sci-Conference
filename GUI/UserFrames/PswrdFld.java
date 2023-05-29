package GUI.UserFrames;

import myTools.myTemplates;

import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;


public class PswrdFld extends JPasswordField {

	public PswrdFld() {

		myTemplates t = new myTemplates();

		setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
		setForeground(t.tangaroa);
		setFont(t.myFont(18));
		setColumns(20);
	}
}