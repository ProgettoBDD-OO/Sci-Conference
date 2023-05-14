package myTools;

import linker.Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;


public class ConfBtn extends JLblButton {
	
	Controller controller;

	public ConfBtn(Controller c, String... Info) {
		
		super(new Color(100, 105, 110), Info);
		
		controller = c;
		
		if (Info.length > 3) { setAlignmentX(Component.CENTER_ALIGNMENT); }
		
		setFont(new Font("Calibri Light", Font.PLAIN, 20));
		setBorder(new EmptyBorder(0,0,5,0));
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				
				if (Info.length > 3) { }//controller.goToUpdateConf(Info[2]); }
				
				else { controller.goToConferenza(Info[2]); }
			}
		});
	}
}