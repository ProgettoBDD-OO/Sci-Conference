package DAO;

import DTO.Sessione;
import linker.DBConnection;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SessioneDAO {
	
	private DBConnection DataBase;
	private Statement statement;
	
	public SessioneDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}
	
	
	public ArrayList<Sessione> getSessioni(String idConferenza) {
		
		ArrayList<Sessione> Sessioni = new ArrayList<Sessione>();
		
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM sessioni WHERE id_conferenza = '" + idConferenza + "' ORDER BY id_sessione;");
			
			while (rs.next()) {
				
				Sessione s = new Sessione();
				s.setId(rs.getString(1));
				s.setDataInizio(rs.getTimestamp(2));
				s.setDataFine(rs.getTimestamp(3));
				s.setCoordinatore(rs.getString(4));
				s.setKeynoteSpeaker(rs.getString(5));
				s.setIdConferenza(6);
				Sessioni.add(s);
			}
			
			return Sessioni;
			
		} catch (Exception e) { return Sessioni; }
	}
	
	public Sessione getSessione(String idSessione) {
		
		String select = "SELECT * FROM sessioni WHERE id_sessione = '" + idSessione + "'";
		
		Sessione s = new Sessione();
		
		try {

			ResultSet rs = statement.executeQuery(select);
			
			while (rs.next()) {
				
				s.setId(rs.getString(1));
				s.setDataInizio(rs.getTimestamp(2));
				s.setDataFine(rs.getTimestamp(3));
				s.setCoordinatore(rs.getString(4));
				s.setKeynoteSpeaker(rs.getString(5));
				s.setIdConferenza(6);
				s.setLocazione(rs.getString(7));
			}
			
		} catch (Exception e) { }
		
		return s;
	}
	
	
	public void insertSessione(String query) {
		
		System.out.println(query);
		try { statement.executeUpdate(query + ";"); }
		
		catch (SQLException e) { e.printStackTrace(); }
	}
	
	
	public void updateSessione(Sessione sessione) {
		
		String update = "UPDATE sessioni "
		+ "SET data_ora_inizio = '"+ sessione.getDataInizio() +"', data_ora_fine = '"+ sessione.getDataFine() +"', coordinatore = '"+ sessione.getCoordinatore() +"', keynote_speaker = '"+ sessione.getKeynoteSpeaker() +"'"
		+ "WHERE id_sessione = "+ sessione.getId();
		
		try { statement.executeUpdate(update + ";"); }
		
		catch (SQLException e) { e.printStackTrace(); }
	}
}