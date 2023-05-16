package myTools;

import java.awt.Component;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class JLblButton extends JButton {
	
	public JLblButton(Color c, String... Info) {
		
		setText(Info[0]);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setForeground(c);
		setFont(new Font("Calibri Light", Font.PLAIN, 14));
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);
		setBorder(new MatteBorder(0, 0, 1, 0, c));
		setBorderPainted(false);
		
		if (Info.length > 1) {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) { setTopicColor(Info[1]); }
				@Override
				public void mouseExited(MouseEvent e) { setForeground(c); }
			});
		}
	}
	
	
	public void setTopicColor(String Tema) {
    	
		switch (Tema) {
			
    		case "Ambiente": this.setForeground(new Color(0, 200, 0));
				break;
				
			case "Anatomia": this.setForeground(new Color(250, 88, 80));
				break;
				
			case "Astrologia": this.setForeground(new Color(30, 30, 120));
				break;
				
			case "Biologia": this.setForeground(new Color(0, 128, 0));
				break;
				
			case "Chimica": this.setForeground(new Color(0, 200, 255));
				break;
				
			case "Fisica": this.setForeground(new Color(250, 80, 0));
				break;
				
			case "Geologia": this.setForeground(new Color(180, 100, 40));
				break;
				
			case "Informatica": this.setForeground(new Color(0, 100, 255));
				break;
				
			case "Matematica": this.setForeground(new Color(0, 0, 200));
				break;
				
			case "Psicologia": this.setForeground(new Color(255, 0, 128));
				break;
				
			case "Sostenibilità": this.setForeground(new Color(240, 210, 0));
				break;

			default: System.out.println("Errore nello switch del tema.");
				break;
		}
	}
}