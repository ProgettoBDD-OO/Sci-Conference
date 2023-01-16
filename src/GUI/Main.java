package GUI;

import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.*;

public class Main {
    public static void main(String[] args){
    	FlatIntelliJLaf.setup();
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
	                MainFrame vista = new MainFrame();

	                Controller controllore = new Controller(vista);
	                
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}