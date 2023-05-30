package myTools;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import linker.Controller;


public class myTxtFld extends JTextField {

	Controller controller;
	myTemplates t = new myTemplates();

	public myTxtFld(String txt, Controller c) {

		controller = c;

		setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
		setForeground(t.altGray);
		setFont(new Font("Calibri Light", Font.ITALIC, 16));
		setText(txt);
		setPreferredSize(new Dimension(10, 30));
		setColumns(18);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (getText().equals(txt)) {
					controller.setTextNull(myTxtFld.this, 16);
				}
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (getText().equals(txt)) {
					controller.setTextNull(myTxtFld.this, 16);
				}
			}
		});

		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (getText().equals("") ) {
					setForeground(t.altGray);
					setFont(new Font("Calibri Light", Font.ITALIC, 16));
					setText(txt);
				}
			}
		});
	}
}