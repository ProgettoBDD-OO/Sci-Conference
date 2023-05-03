package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import DTO.Collocazione;
import linker.DBConnection;

public class CollocazioneDAO {
	
    private DBConnection DataBase;
	private Statement statement;
	
	public CollocazioneDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}
	
   public Collocazione getCollocazione(String id_conferenza) {
		
		Collocazione col = new Collocazione();
		
		try {
			
			String query = "SELECT * FROM collocazione_conferenza("+ id_conferenza +");";
			ResultSet rs = statement.executeQuery(query);
			
			rs.next();
				
			col.setSede(rs.getString(2));
			col.setRegione(rs.getString(3));
		
			return col;
			
		} catch (Exception e) { return col; }
	}
   
   public int getIdCollocazione(String sede, String regione) {

       int idColl = 0;

       try {

            String query = "SELECT * FROM collocazioni("+ sede +", "+ regione +");";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) { idColl = rs.getInt(1); }


        } catch (Exception e) { e.printStackTrace(); } 

       return idColl;
   }
   
   public void insertCollocazione(String sede, String regione) {

       if(getIdCollocazione(sede, regione) == 0) {

           try {

                statement.executeUpdate("INSERT INTO collocazioni VALUES (DEFAULT,'" + sede + "','" + regione + "');");

            } catch (Exception e) { e.printStackTrace();}
       }
   }
}