package GUI.CalendarFrame;

import myTools.myTemplates;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

import javax.swing.*;


public class CalendarCell extends JTextArea {
	
	private myTemplates t = new myTemplates();
	
	public CalendarCell() {

		setBackground(t.white);
		setFont(t.myFont(17));
		setEditable(false);
		setLineWrap(true);
		setWrapStyleWord(true);
	}
	
	public void currentMonth(boolean Act) {
		
		if(Act) {
			setForeground(t.tangaroa);
		} else {
			setForeground(new Color(200, 205, 210));
		}
	}
	
	public void containsConf(String nomeConf) { 
		
		if (nomeConf != null) {
		
			append("\n" + nomeConf);
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					//controllerLink.goToConferenza(conf.getId());
				}
				@Override
				public void mouseEntered(MouseEvent e) { setForeground(t.scBlue); }
				@Override
				public void mouseExited(MouseEvent e) { getForeground(); }
			}); 
		}
	}
}