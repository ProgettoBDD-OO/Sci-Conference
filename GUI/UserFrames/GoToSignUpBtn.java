package GUI.UserFrames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import linker.Controller;
import myTools.JLblButton;
import myTools.myTemplates;

public class GoToSignUpBtn extends JLblButton {

	Controller controller;

	private myTemplates t;

	public GoToSignUpBtn(Controller c) {

		super(new Color(100, 105, 110), "Non hai un account? Registrati");
		controller = c;

		t = new myTemplates();
		setFont(t.myFont(18));

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.fromLogInToSignUp();
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(t.scBlue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(t.gray);
			}
		});
	}
}