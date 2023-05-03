package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import DTO.Sessione;
import linker.DBConnection;

public class SessioneDAO {
	
	private DBConnection DataBase;
	private Statement statement;
	
	public SessioneDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}
	
	
	public ArrayList<Sessione> getSessioni(int idConf) {
		
		ArrayList<Sessione> Sessioni = new ArrayList<Sessione>();
		
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM sessioni WHERE id_conferenza = '" + idConf + "';");
			
			while (rs.next()) {
				
				Sessione s = new Sessione();
				s.setId(rs.getString(1));
				s.setDataOraInizio(rs.getTimestamp(2));
				s.setDataOraFine(rs.getTimestamp(3));
				s.setCoordinatore(rs.getString(4));
				s.setKeynoteSpeaker(rs.getString(5));
				s.setIdConferenza(6);
				Sessioni.add(s);
			}
			
			return Sessioni;
			
		} catch (Exception e) { return Sessioni; }
	}
	
	public void insertSessione(String query) {
		
		System.out.println(query);
		try { statement.executeUpdate(query + ";"); }
		
		catch (SQLException e) { e.printStackTrace(); }
	}
}