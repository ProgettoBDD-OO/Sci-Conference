package myTools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class JConfBtn extends JButton{

	public JConfBtn(String... Info) {
		
		setText(Info[0]);
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 105, 110)));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setForeground(new Color(90, 100, 110));
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Calibri Light", Font.PLAIN, 14));
		setFocusPainted(false);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
		
		
	}
	
	
}