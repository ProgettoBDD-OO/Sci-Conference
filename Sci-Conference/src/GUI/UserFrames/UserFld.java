package GUI.UserFrames;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import myTools.myTemplates;

public class UserFld extends JTextField {

	private myTemplates t;

	public UserFld() {

		t = new myTemplates();
		setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
		setForeground(t.tangaroa);
		setFont(t.myFont(16));
		setColumns(18);
	}
}