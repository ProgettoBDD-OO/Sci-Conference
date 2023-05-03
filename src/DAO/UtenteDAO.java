package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.Utente;
import linker.Controller;
import linker.DBConnection;

public class UtenteDAO {

    private DBConnection DataBase;
    private Statement statement;

    public UtenteDAO() {

        DataBase = DBConnection.getConnection();
        statement = DataBase.getStatement();
    }

    
    public Utente getUtente(String usernameEmail) {

        String select = "SELECT * FROM utenti WHERE username = '" + usernameEmail + "' OR email = '" + usernameEmail + "'";
        Utente utente = new Utente();
        
        try {

            ResultSet rs = statement.executeQuery(select);
            
            while (rs.next()) {
            	
            	utente.setEmail(rs.getString(1));
                utente.setUsername(rs.getString(2));
                utente.setPassword_user(rs.getString(3));
                utente.setAdmin_status(rs.getBoolean(4));
			}
               
            return utente;

        } catch (Exception e) { e.printStackTrace(); return utente; }
    }

    
    public String checkPassword(Utente utente) {

        String select = "SELECT password_user FROM utenti WHERE email = '" + utente.getEmail() + "';";

        try {
        	
            ResultSet rs = statement.executeQuery(select);
            
            rs.next();
            
            return rs.getString(1);

        } catch (Exception e) { e.printStackTrace();  return null; }
    }
    
    
    public void registrazione(Utente utente) {
    	
    	String insert = "INSERT INTO utenti VALUES ('"+ utente.getEmail() +"', '"+ utente.getUsername() +"', '"+ utente.getPassword_user() +"');";
    	
		try { 
			
			statement.executeUpdate(insert);
		
		} catch (SQLException e) {  }
    }
    
    public boolean checkEmail(String email) {
    	
    	 String select = "SELECT * FROM utenti WHERE email = '" + email + "'";
         boolean EmailUtilizzabile = true;
    	 
         try {

             ResultSet rs = statement.executeQuery(select);
             
             while (rs.next()) { EmailUtilizzabile = false; }

         } catch (Exception e) { e.printStackTrace(); }
         
         return EmailUtilizzabile;
    }
    
    
    public void iscrizione(String email, String idConf) {
    	
    	String insert = "INSERT INTO iscrizioni_conferenze VALUES ('"+ email +"', '"+ idConf +"');";
    	
    	try { statement.executeUpdate(insert);
    		
		} catch (SQLException e) { e.printStackTrace(); }
    }
}