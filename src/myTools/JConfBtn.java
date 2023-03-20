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

	public JConfBtn(String Text, String Tema) {
		
		setText(Text);
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
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setTopicColor(Tema);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(new Color(90, 100, 110));
			}
		});
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