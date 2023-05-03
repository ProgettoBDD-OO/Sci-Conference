package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Ente;
import linker.DBConnection;

public class KeynoteSpeakerDAO {

	private DBConnection DataBase;
	private Statement statement;
	
	public KeynoteSpeakerDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}
	
	public ArrayList<Ente> getAfferenzeByMonth(int month, int year) {
		
		String select = "SELECT * FROM afferenze_by_month("+ month +", "+ year +");";
		
		ArrayList<Ente> enti = new ArrayList<Ente>();
		
		try {
			 
			ResultSet rs = statement.executeQuery(select);
			
			while (rs.next()) {
				
				Ente e = new Ente();
				e.setNome(rs.getString(1));
				e.setnOccorrenze(rs.getInt(2));
				
				enti.add(e);
			} 
			
		} catch (Exception e) {  }
		
		return enti;
	}
	
	public ArrayList<Ente> getAfferenzeByYear(int year) {
		
		String select = "SELECT * FROM afferenze_by_year("+ year +");";
		
		ArrayList<Ente> enti = new ArrayList<Ente>();
		
		try {
			 
			ResultSet rs = statement.executeQuery(select);
			
			while (rs.next()) {
				
				Ente e = new Ente();
				e.setNome(rs.getString(1));
				e.setnOccorrenze(rs.getInt(2));
				
				enti.add(e);
			} 
			
		} catch (Exception e) {  }
		
		return enti;
	}
}