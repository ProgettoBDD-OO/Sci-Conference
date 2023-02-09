package GUI.CalendarFrame;
import javax.swing.*;

import java.awt.Color;
import java.util.Date;
import java.awt.Font;


public class CalendarCell extends JButton{
	
	private Date Data;
	private boolean Title;
	
	public CalendarCell() {
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Tahoma", Font.PLAIN, 16));
		setContentAreaFilled(false);
		setHorizontalAlignment(JLabel.CENTER);
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
	
	public void currentMonth(boolean Act) {
		if(Act) {
			setForeground(new Color(20, 30, 40));
		} else {
			setForeground(new Color(200, 205, 210));
		}
	}
}