package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.Utente;
import linker.DBConnection;


public class UtenteDAO {

    private DBConnection DataBase;
    private Statement statement;

    public UtenteDAO() {

        DataBase = DBConnection.getInstance();
        statement = DataBase.getStatement();
    }


    public Utente getUtente(String usernameEmail) {

        Utente utente = new Utente();

        try {

        	String select = "SELECT * FROM utente WHERE username = '" + usernameEmail + "' OR email = '" + usernameEmail + "'";
            ResultSet rs = statement.executeQuery(select);

            rs.next();

        	utente.setEmail(rs.getString(1));
            utente.setUsername(rs.getString(2));
            utente.setPassword(rs.getString(3));

        } catch (SQLException e) { e.getMessage(); }

        return utente;
    }


    public String checkPassword(Utente utente) {

        try {

        	String select = "SELECT password_user FROM utente WHERE email = '" + utente.getEmail() + "';";
            ResultSet rs = statement.executeQuery(select);

            rs.next();

            utente.setPassword(rs.getString(1));

        } catch (SQLException e) { e.getMessage(); }

        return utente.getPassword();
    }


    public void registrazione(Utente utente) {

		try {

			String insert = "INSERT INTO utente VALUES ('"+ utente.getEmail() +"', '"+ utente.getUsername() +"', '"+ utente.getPassword() +"');";
			statement.executeUpdate(insert);

		} catch (SQLException e) { e.getMessage(); }
    }


    public boolean checkEmail(String email) {

         boolean EmailUtilizzabile = true;

         try {

        	 String select = "SELECT * FROM utente WHERE email = '" + email + "'";
             ResultSet rs = statement.executeQuery(select);

             while (rs.next()) { EmailUtilizzabile = false; }

         } catch (SQLException e) { e.getMessage(); }

         return EmailUtilizzabile;
    }

    public boolean checkUsername(String username) {

        boolean UsernameUtilizzabile = true;

        try {

        	String select = "SELECT * FROM utente WHERE username = '" + username + "'";
            ResultSet rs = statement.executeQuery(select);

            while (rs.next()) { UsernameUtilizzabile = false; }

        } catch (SQLException e) { e.getMessage(); }

        return UsernameUtilizzabile;
   }

   public boolean checkIscrizione(String email, String idConferenza) {

	   boolean ConferenzaPresente = false;

	   try {

		   String select = "SELECT * FROM iscrizioni('"+ email +"', "+ idConferenza +");";
		   ResultSet rs = statement.executeQuery(select);

		   while (rs.next()) { ConferenzaPresente = true; }

	   } catch (SQLException e) { e.getMessage(); }

	   return ConferenzaPresente;
	}


    public void iscrizione(String email, String idConf) {

    	try {

    		String insert = "INSERT INTO iscrizione_conferenza VALUES ('"+ email +"', '"+ idConf +"');";
    		statement.executeUpdate(insert);

		} catch (SQLException e) { e.getMessage(); }
    }
}