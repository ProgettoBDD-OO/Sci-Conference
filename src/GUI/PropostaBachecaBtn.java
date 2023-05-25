package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.border.EmptyBorder;

import linker.Controller;
import myTools.JLblButton;


public class PropostaBachecaBtn extends JLblButton {

	public PropostaBachecaBtn(Controller contr, String... Info) {

		super(new Color(120, 180, 255), Info);
		setFont(new Font("Calibri Light", Font.PLAIN, 17));
		setBorder(new EmptyBorder(25, 0, 25, 0));
		setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}