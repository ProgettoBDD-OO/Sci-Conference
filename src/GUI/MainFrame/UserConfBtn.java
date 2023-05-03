package GUI.MainFrame;

import java.awt.Component;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import linker.ControllerLink;
import myTools.ConfBtn;

public class UserConfBtn extends ConfBtn {

	public UserConfBtn(ControllerLink contrLink, String... Info) {
		
		super(contrLink, Info);
		
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setFont(new Font("Calibri Light", Font.PLAIN, 20));
		setBorder(new EmptyBorder(10,0,10,0));
	}
}