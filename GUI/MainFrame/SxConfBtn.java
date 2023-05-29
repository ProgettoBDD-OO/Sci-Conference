package GUI.MainFrame;

import java.awt.Font;

import linker.Controller;
import myTools.ConfBtn;


public class SxConfBtn extends ConfBtn{

	public SxConfBtn(Controller c, String... Info) {

		super(c, Info);
		setFont(new Font("Calibri Light", Font.PLAIN, 17));
	}
}