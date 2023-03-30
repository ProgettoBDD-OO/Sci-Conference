package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.Collocazione;
import linker.DBConnection;

public class CollocazioneDAO {
	
    private DBConnection DataBase;
	
	public CollocazioneDAO() {
		
		DataBase = new DBConnection();
		DataBase.connettiDB();
	}
	
   public Collocazione getCollocazione(String id_conferenza) {
		
		Collocazione col = new Collocazione();
		
		try {
			
			String query = "SELECT * FROM collocazioni NATURAL JOIN conferenza_scientifica WHERE id_conferenza = " + id_conferenza + " ;"; 
			PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			rs.next();
				
			col.setSede(rs.getString(2));
			col.setRegione(rs.getString(4));
		
			return col;
			
		} catch (Exception e) { return col; }
		
	}
   
   public int getIdCollocazione(String sede, String regione) {

       int idColl = 0;

       try {

            String query = "SELECT id_collocazione FROM collocazioni WHERE sede = '" + sede + "' AND regione = '" + regione + "';";
            PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                idColl = rs.getInt(1);
            }


        } catch (Exception e) { e.printStackTrace();} 

       return idColl;
   }
   
   public void insertCollocazione(String sede, String regione) {

       if(getIdCollocazione(sede, regione) == 0) {

           String query = "INSERT INTO collocazioni VALUES (DEFAULT,'" + sede + "','" + regione + "');";

           try {

                PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
                statement.executeUpdate();

            } catch (Exception e) { e.printStackTrace();}
       }
   }
}