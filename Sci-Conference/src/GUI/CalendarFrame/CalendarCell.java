package GUI.CalendarFrame;

import linker.Controller;
import myTools.myTemplates;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;


public class CalendarCell extends JTextArea {

	private myTemplates t;
	private Color foreground;

	public CalendarCell() {

		t = new myTemplates();
		setBackground(t.white);
		setFont(t.myFont(16));
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