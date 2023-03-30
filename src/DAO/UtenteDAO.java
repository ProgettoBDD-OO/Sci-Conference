package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Utente;
import linker.Controller;
import linker.DBConnection;

public class UtenteDAO {

    private DBConnection DataBase;

    public UtenteDAO() {

        DataBase = new DBConnection();
        DataBase.connettiDB();
    }

    
    public Utente getUtente(String usernameEmail) {

        String select = "SELECT * FROM utenti WHERE username = '" + usernameEmail + "' OR email = '" + usernameEmail + "'";
        Utente utente = new Utente();
        
        try {

            PreparedStatement statement = DataBase.getConnection().prepareStatement(select);

            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
            	
            	utente.setEmail(rs.getString(1));
                utente.setUsername(rs.getString(2));
                utente.setPassword_user(rs.getString(3));
                utente.setAdmin_status(rs.getBoolean(4));
			}
               
            return utente;

        } catch (Exception e) { e.printStackTrace(); return utente; }
    }

    
    public boolean checkPassword(Utente utente, String password) {

        String select = "SELECT password_user FROM utenti WHERE email = '" + utente.getEmail() + "' AND password_user = '" + password + "';";
        
        boolean correctPassword = false;

        try {

            PreparedStatement statement = DataBase.getConnection().prepareStatement(select);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) { correctPassword = true; }

        } catch (Exception e) { e.printStackTrace(); }

        return correctPassword;
    }
    
    
    public void registrazione(Utente utente) {
    	
    	String insert = "INSERT INTO utenti VALUES ('"+ utente.getEmail() +"', '"+ utente.getUsername() +"', '"+ utente.getPassword_user() +"');";
    	
		try { 
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement(insert); 
			statement.executeUpdate();
		
		} catch (SQLException e) { e.printStackTrace(); }
    }
    
    public boolean checkEmail(String email) {
    	
    	 String select = "SELECT email FROM utenti WHERE email = '" + email + "'";
         boolean EmailUtilizzabile = true;
    	 
         try {

             PreparedStatement statement = DataBase.getConnection().prepareStatement(select);

             ResultSet rs = statement.executeQuery();
             
             while (rs.next()) { EmailUtilizzabile = false; }

         } catch (Exception e) { System.out.println(e); }
         
         return EmailUtilizzabile;
    }
    
    
    public void iscrizione(String email, int idConf) {
    	
    	String insert = "INSERT INTO iscrizioni_conferenze VALUES ('"+ email +"', '"+ idConf +"');";
    	
    	try {
			
    		PreparedStatement statement = DataBase.getConnection().prepareStatement(insert);
    		statement.executeUpdate();
    		
		} catch (SQLException e) { e.printStackTrace(); }
    }
}