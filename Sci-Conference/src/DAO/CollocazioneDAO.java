package DAO;

import DTO.Collocazione;
import linker.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CollocazioneDAO {

    private DBConnection DataBase;
	private Statement statement;

	public CollocazioneDAO() {

		DataBase = DBConnection.getInstance();
		statement = DataBase.getStatement();
	}
	
	public Collocazione getCollocazione(String idConferenza) {
		
		Collocazione collocazione = new Collocazione();

		try {

			String select = "SELECT * FROM collocazione_conferenza("+ idConferenza +");";
			ResultSet rs = statement.executeQuery(select);

			rs.next();

			collocazione.setSede(rs.getString(1));
			collocazione.setRegione(rs.getString(2));

		} catch (SQLException e) { e.getMessage(); }

		return collocazione; 
	}

	public int getIdCollocazione(String sede, String regione) {
		
		int idCollocazione = 0;

		try {
			
			String select = "SELECT * FROM collocazione('"+ sede +"', '"+ regione +"');";
            ResultSet rs = statement.executeQuery(select);
            
            while (rs.next()) { idCollocazione = rs.getInt(1); }
            
		} catch (SQLException e) { e.getMessage(); }
		
		return idCollocazione;
	}

	public void insertCollocazione(Collocazione collocazione) {

		try {
			
			String insert = "INSERT INTO collocazione VALUES (DEFAULT,'"
				   		  + collocazione.getSede() + "','" + collocazione.getRegione() + "') ON CONFLICT DO NOTHING;";

			statement.executeUpdate(insert);

	    } catch (SQLException e) { e.getMessage();}
    }
}