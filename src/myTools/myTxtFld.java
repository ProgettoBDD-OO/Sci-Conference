package myTools;

import linker.Controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;


public class myTxtFld extends JTextField {
	
	Controller controller;
	myTemplates t = new myTemplates();
	
	public myTxtFld(String txt, Controller c) {
		
		controller = c;
		
		setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
		setForeground(t.altGray);
		setFont(new Font("Calibri Light", Font.ITALIC, 14));
		setText(txt);
		setPreferredSize(new Dimension(10, 30));
		setColumns(23);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setTextNull(myTxtFld.this, 14);
			}
		});
	}
}