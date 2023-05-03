package myTools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

import linker.ControllerLink;

public class ConfBtn extends JLblButton {
	
	ControllerLink controllerLink;

	public ConfBtn(ControllerLink contrLink, String... Info) {
		
		super(new Color(100, 105, 110), Info);
		
		controllerLink = contrLink;
		
		if (Info.length > 3) { setAlignmentX(Component.CENTER_ALIGNMENT); }
		
		setFont(new Font("Calibri Light", Font.PLAIN, 20));
		setBorder(new EmptyBorder(0,0,5,0));
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				
				if (Info.length > 3) { controllerLink.goToUpdateConf(Info[2]); }
				
				else { controllerLink.goToConferenza(Info[2]); }
			}
		});
	}
}