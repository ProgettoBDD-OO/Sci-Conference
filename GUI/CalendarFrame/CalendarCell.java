package GUI.CalendarFrame;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.util.Date;


public class CalendarCell extends JTextArea{
	
	private Date Data;
	private boolean Title;
	
	public CalendarCell() {
		setForeground(new Color(20, 40, 60));
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setEditable(false);
		setLineWrap(true);
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Calibri Light", Font.PLAIN, 17));			
	}
	
	
	public void asTitle() {
		Title = true;
	}
	
	public boolean isTitle() {
		return Title;
	}
	
	public void setDate(Date Data) {
		this.Data = Data;
	}
	
	public Date getData() {
		return Data;
	}
	
	public void currentMonth(boolean Act) {
		if(Act) {
			setForeground(new Color(20, 30, 40));
		} else {
			setForeground(new Color(200, 205, 210));
		}
	}
}