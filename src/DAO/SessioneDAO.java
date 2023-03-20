package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import DTO.Sessione;
import linker.DBConnection;

public class SessioneDAO {
	private DBConnection DataBase;
	
	public SessioneDAO() {
		
		DataBase = new DBConnection();
		DataBase.connettiDB();
	}
	
	
	public ArrayList<Sessione> getSessioni() {
		
		ArrayList<Sessione> Sessioni = new ArrayList<Sessione>();
		
		try {
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement("SELECT * FROM sessione");
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				Sessione s = new Sessione();
				s.setId(rs.getInt(1));
				s.setDataOraInizio(rs.getDate(2));
				s.setDataOraFine(rs.getDate(3));
				s.setCoordinatore(rs.getString(4));
				s.setKeynoteSpeaker(rs.getString(5));
				s.setIdConferenza(6);
				Sessioni.add(s);
			}
			
			return Sessioni;
			
		} catch (Exception e) {
			e.getMessage();
			return Sessioni;
		}
	}
}