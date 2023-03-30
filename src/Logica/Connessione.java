package Logica;

import java.sql.*;
import java.util.Scanner;

import UTILITIES.ConnessioneDB;


public class Connessione {
	
	private Connection con;
	private Statement statement;
	private static Connessione myConnessione;
	   
  	public void connetti()  {
  		
  		statement = null;
				
  		try {
  			
		String user = "postgres";
		String password = "ciaociao23";
		String url = "jdbc:postgresql://localhost/Progetto OO-BD 2022-23";
		
		con = DriverManager.getConnection(url, user, password);
	    System.out.println("Connessione effettuata! \n");
	    
		} catch (SQLException e) {
			
			System.out.println("Connessione fallita \n");
			System.out.println(e);
	    }
  		
  		
  		try {
  			
  			statement = con.createStatement();
			
		} catch (Exception e) {
			
			System.out.println("Statement non creato correttamente \n");
			System.out.println(e);
		}
		
 }  
	
	public static Connessione getConnection() {   //Singleton
		
	
		if(myConnessione == null) {
			myConnessione = new Connessione();
		}
		
		return myConnessione;
		
	}
	
	public Statement getStatement() {
		return statement;
	}

}