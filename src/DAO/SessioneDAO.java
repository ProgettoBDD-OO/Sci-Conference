package DAO;

import DTO.Sessione;
import linker.DBConnection;
import myTools.myTemplates;

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

			String select = "SELECT * FROM sessioni WHERE id_conferenza = '" + idConferenza + "' ORDER BY id_sessione;";
			ResultSet rs = statement.executeQuery(select);
			
			while (rs.next()) {
				
				Sessione s = new Sessione();
				
				s.setId(rs.getString(1));
				s.setDataInizio(rs.getDate(2));
				s.setDataFine(rs.getDate(3));
				s.setCoordinatore(rs.getString(4));
				s.setKeynoteSpeaker(rs.getString(5));
				s.setIdConferenza(6);
				s.setLocazione(rs.getString(7));
				
				Sessioni.add(s);
			}
				
		} catch (SQLException e) { e.getMessage(); }
		
		return Sessioni;
	}
	
	public Sessione getSessione(String idSessione) {
				
		Sessione s = new Sessione();
		
		try {

			String select = "SELECT * FROM sessioni WHERE id_sessione = '" + idSessione + "'";
			ResultSet rs = statement.executeQuery(select);
			
			rs.next();
				
			s.setId(rs.getString(1));
			s.setDataInizio(rs.getDate(2));
			s.setDataFine(rs.getDate(3));
			s.setCoordinatore(rs.getString(4));
			s.setKeynoteSpeaker(rs.getString(5));
			s.setIdConferenza(6);
			s.setLocazione(rs.getString(7));
			
			
		} catch (SQLException e) { e.getMessage(); }
		
		return s;
	}
	
	
	public void insertSessione(Sessione sessione, int idConferenza) {
		
		myTemplates t = new myTemplates();
		
		String insert = "INSERT INTO sessioni VALUES (" + sessione.getId() + ", '" 
							+ t.df(sessione.getDataInizio()) + "', '" 
					  		+ t.df(sessione.getDataFine()) + "', '"
					  		+ sessione.getCoordinatore() + "', '" 
					  		+ sessione.getKeynoteSpeaker() + "', " 
					  		+ idConferenza + ", '" 
					  		+ sessione.getLocazione() +"');";
		
		try { statement.executeUpdate(insert); }
		
		catch (SQLException e) { e.printStackTrace(); }
	}
	
	
	public void updateSessione(String update) {
		
		try { statement.executeUpdate(update); }
		
		catch (SQLException e) { e.getMessage(); }
	}
}