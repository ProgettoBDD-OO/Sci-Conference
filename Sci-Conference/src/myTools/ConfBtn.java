package myTools;

import linker.Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;


public class ConfBtn extends JLblButton {

	private Controller controller;

	public ConfBtn(Controller c, String... Info) {

		super(new Color(100, 105, 110), Info);

		controller = c;

		if (Info.length > 3) { setAlignmentX(Component.CENTER_ALIGNMENT); }

		setFont(new Font("Calibri Light", Font.PLAIN, 18));
		setBorder(new EmptyBorder(0, 0, 4, 0));

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (Info.length > 3 && Info[3].equals("Modifica") ) { controller.goToModifica(Info[2]); }

				else if (Info.length > 3 && Info[3].equals("Rimozione") ) { controller.goToRimozione(Info[2]); }

				else { controller.goToConferenza(Info[2]); }
			}
		});


		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { controller.setTopicColor(Info[1], ConfBtn.this); }
			@Override
			public void mouseExited(MouseEvent e) { setForeground(new Color(100, 105, 110)); }
		});
	}
}