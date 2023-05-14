package myTools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public final Color altGray = new Color(150, 151, 152);
	
	public final Color red = new Color(212, 0, 0);
	
	
	public final Image MiniLogo = new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage();
	
	
	public final Font myFont(int grandezzaFont) {
		
		return new Font("Calibri Light", Font.PLAIN, grandezzaFont);
	}
	
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
	
	public String toDateFormat(Date date) { return dateFormat.format(date); }
	
	
	private SimpleDateFormat monthYearFormat = new SimpleDateFormat("MMMM - yyyy");
	
	public String toMonthYearFormat(Date date) { return monthYearFormat.format(date); }
	
	private SimpleDateFormat DateTimeFormat = new SimpleDateFormat("dd/MM/YY hh:mm");
	
	public String toDateTimeFormat(Date date) { return DateTimeFormat.format(date); }
	
	private SimpleDateFormat TimeFormat = new SimpleDateFormat("hh:mm");
	
	public String toTimeFormat(Date date) { return TimeFormat.format(date); }
}