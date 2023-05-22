package GUI.MainFrame;

import linker.Controller;
import myTools.ConfBtn;

import java.awt.Font;


public class SxConfBtn extends ConfBtn{

	public SxConfBtn(Controller c, String... Info) {
		
		super(c, Info);
		setFont(new Font("Calibri Light", Font.PLAIN, 17));
	}
}