package GUI.MainFrame;

import java.awt.Font;

import linker.ControllerLink;
import myTools.ConfBtn;

public class SxConfBtn extends ConfBtn{

	public SxConfBtn(ControllerLink contrLink, String... Info) {
		
		super(contrLink, Info);
		setFont(new Font("Calibri Light", Font.PLAIN, 17));
	}
}