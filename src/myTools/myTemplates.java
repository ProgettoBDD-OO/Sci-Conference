package myTools;

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
	public final Color altGray = new Color(150, 151, 152);
	
	public final Color red = new Color(212, 0, 0);
	
	public final Image MiniLogo = new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage();
	
	public final Font myFont(int grandezzaFont) {
		
		return new Font("Calibri Light", Font.PLAIN, grandezzaFont);
	}
}