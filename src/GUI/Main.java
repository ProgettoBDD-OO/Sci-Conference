package GUI;
import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.*;

import GUI.MainFrame.MainFrame;

public class Main {
    public static void main(String[] args){
    	FlatIntelliJLaf.setup();
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	                MainFrame Vista = new MainFrame("GUI Science Conference");
	                Controller Controllore = new Controller(Vista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}