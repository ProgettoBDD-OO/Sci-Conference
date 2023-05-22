package GUI.UserFrames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import linker.Controller;
import myTools.JLblButton;
import myTools.myTemplates;

public class GoToLogInBtn extends JLblButton {
	
	Controller controller;
	
	myTemplates t = new myTemplates();
	
	public GoToLogInBtn(Controller c) {
		
		super(new Color(100, 105, 110), "Hai gia un account? Accedi");
		controller = c;
		
		setFont(t.myFont(18));
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.fromSignUpToLogIn();
			}
		});
	}
}