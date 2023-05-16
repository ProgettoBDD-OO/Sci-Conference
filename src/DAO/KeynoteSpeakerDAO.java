package DAO;

import DTO.Ente;
import linker.DBConnection;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class KeynoteSpeakerDAO {

	private DBConnection DataBase;
	private Statement statement;
	
	public KeynoteSpeakerDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}
	
	public ArrayList<Ente> getAfferenze(int month, int year) {
		
		String select;
		
		if (month == -1) { select = "SELECT * FROM afferenze_by_year("+ year +");"; }
		
		else { select = "SELECT * FROM afferenze_by_month("+ month +", "+ year +");"; }
		
		ArrayList<Ente> enti = new ArrayList<Ente>();
		
		try {
			 
			ResultSet rs = statement.executeQuery(select);
			Ente.azzeraTotale();
			
			while (rs.next()) {
				
				Ente e = new Ente();
				e.setNome(rs.getString(1));
				e.setOccorrenze(rs.getInt(2));
				
				enti.add(e);
			} 
			
		} catch (Exception e) { e.getMessage(); }
		
		return enti;
	}
	
	
	public void insertKeynoteSpeaker(String insert) {
		
		System.out.println(insert);
        
        try {  statement.executeUpdate(insert); }
            
        catch (SQLException e) { e.printStackTrace(); }
	}
	
	
	public void updateKeynoteSpeaker() {
		
		String update = "UPDATE keynote_speaker SET ";
	}
}