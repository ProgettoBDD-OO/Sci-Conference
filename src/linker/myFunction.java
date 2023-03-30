package linker;

import java.awt.Color;
import java.awt.Component;

public interface myFunction {
	
	public default void setTopicColor(String Tema, Component com) {
    	
		switch (Tema) {
			
    		case "Ambiente":	  com.setForeground(new Color(0, 200, 0));
				break;
				
			case "Anatomia": 	  com.setForeground(new Color(250, 88, 80));
				break;
				
			case "Astrologia":	  com.setForeground(new Color(30, 30, 120));
				break;
				
			case "Biologia":	  com.setForeground(new Color(0, 128, 0));
				break;
				
			case "Chimica":		  com.setForeground(new Color(0, 200, 255));
				break;
				
			case "Fisica":		  com.setForeground(new Color(250, 80, 0));
				break;
				
			case "Geologia":	  com.setForeground(new Color(180, 100, 40));
				break;
				
			case "Informatica":	  com.setForeground(new Color(0, 100, 255));
				break;
				
			case "Matematica":    com.setForeground(new Color(0, 0, 200));
				break;
				
			case "Psicologia":	  com.setForeground(new Color(255, 0, 128));
				break;
				
			case "Sostenibilità": com.setForeground(new Color(240, 210, 0));
				break;

			default: System.out.println("Errore nello switch del tema.");
				break;
		}
	}
}