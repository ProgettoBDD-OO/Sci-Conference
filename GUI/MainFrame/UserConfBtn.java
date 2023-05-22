package GUI.MainFrame;

import linker.Controller;
import myTools.ConfBtn;

import java.awt.Component;
import java.awt.Font;

import javax.swing.border.EmptyBorder;


public class UserConfBtn extends ConfBtn {

	public UserConfBtn(Controller c, String... Info) {
		
		super(c, Info);
		
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setFont(new Font("Calibri Light", Font.PLAIN, 20));
		setBorder(new EmptyBorder(10,0,10,0));
	}
}