package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Intervento;
import linker.DBConnection;

public class InterventoDAO {
	
	private DBConnection DataBase;
	private Statement statement;
	
	public InterventoDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}

	
	public ArrayList<Intervento> getInterventi(String id_sessione) {
		
		ArrayList<Intervento> Interventi = new ArrayList<Intervento>();
		
		String select = "select * from interventi where id_sessione = " + id_sessione +";";
		
		try {
			
			ResultSet rs = statement.executeQuery(select);
			
			while (rs.next()) {
				
				Intervento i = new Intervento();
				i.setIdIntervento(rs.getString(1));
				i.setOrainizio(rs.getTime(2));
				i.setOrafine(rs.getTime(3));
				i.setIdSessione(rs.getString(4));
				i.setDescrizione(rs.getString(5));
                
                Interventi.add(i);
			}
			
		} catch (Exception e) { }
		
		return Interventi;
	}
}