package GUI.UserFrames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import linker.Controller;
import myTools.JLblButton;
import myTools.myTemplates;

public class GoToLogInBtn extends JLblButton {

	private Controller controller;

	private myTemplates t;

	public GoToLogInBtn(Controller c) {

		super(new Color(100, 105, 110), "Hai gia un account? Accedi");
		controller = c;

		t = new myTemplates();
		setFont(t.myFont(16));

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.fromSignUpToLogIn();
			}
		});
	}
}