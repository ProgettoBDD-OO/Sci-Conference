package linker;

import com.formdev.flatlaf.*;

import DAO.ConferenzaDAO;
import GUI.ConferenzaFrame.ConferenzaFrame;


public class Main {
	
	public static void main(String[] args) { 
		FlatIntelliJLaf.setup();
		
	    Controller controller = new Controller();	                
	    ControllerLink controllerLink = new ControllerLink(controller);
	}
}