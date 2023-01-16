package GUI;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
    	
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