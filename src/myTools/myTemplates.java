package myTools;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat; 

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;


public class myTemplates {

	public final Color white = new Color(255, 255, 255);
	public final Color black = new Color(0, 0, 0);

	public final Color lBlue = new Color(120, 180, 255);
	public final Color scBlue = new  Color(0, 0, 200);
	public final Color dBlue = new Color(0, 0, 140);
	public final Color tangaroa = new Color(30, 47, 60);

	public final Color sxGray = new Color(240, 241, 242);
	public final Color dxGray = new Color(242, 243, 244);
	public final Color lGray = new Color(246, 247, 248);
	public final Color gray = new Color(100, 105, 110);
	public final Color altGray = new Color(140, 141, 142);

	public final Color red = new Color(212, 0, 0);


	public final Image miniLogo = new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage();


	public final Font myFont(int grandezzaFont) {

		return new Font("Calibri Light", Font.PLAIN, grandezzaFont);
	}


	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

	public String toDateFormat(Date date) { return dateFormat.format(date); }


	private SimpleDateFormat monthYearFormat = new SimpleDateFormat("MMMM - yyyy");

	public String toMonthYearFormat(Date date) { return monthYearFormat.format(date); }


	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public String toTimeFormat(Date date) { return timeFormat.format(date); }

	private SimpleDateFormat sqlFormat = new SimpleDateFormat("YYYY-MM-dd");

	public String df(Calendar calendar) { return sqlFormat.format(calendar.getTime()); }
}