package GUI.CalendarFrame;

import myTools.myTemplates;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

import javax.swing.*;

import linker.Controller;


public class CalendarCell extends JTextArea {
	
	private myTemplates t = new myTemplates();
	private Color foreground;
	
	public CalendarCell() {

		setBackground(t.white);
		setFont(t.myFont(17));
		setEditable(false);
		setLineWrap(true);
		setWrapStyleWord(true);
	}
	
	public void currentMonth(boolean Act) {
		
		if(Act) { foreground = t.tangaroa; }
		
		else { foreground = new Color(200, 205, 210); }
		
		setForeground(foreground);
	}
	
	public void containsConf(String nomeConf, String idConf, Controller c) { 
		
		if (nomeConf != null) {
		
			append("\n" + nomeConf);
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					c.goToConferenza(idConf);
				}
				@Override
				public void mouseEntered(MouseEvent e) { setForeground(t.scBlue); }
				@Override
				public void mouseExited(MouseEvent e) { setForeground(foreground); }
			}); 
		}
	}
}