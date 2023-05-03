package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Sponsor;
import linker.DBConnection;

public class SponsorDAO {

	private DBConnection DataBase;
	private Statement statement;

    public SponsorDAO() {

    	DataBase = DBConnection.getConnection();
        statement = DataBase.getStatement();
    }

   public ArrayList<Sponsor> getSponsor(int id_conferenza) {

       ArrayList<Sponsor> sponsorizzazioni = new ArrayList<Sponsor>();

        try {

            String query = "SELECT * FROM sponsor("+ id_conferenza +");"; 
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                Sponsor sponsor = new Sponsor();
                sponsor.setNome(rs.getString(1));
                sponsorizzazioni.add(sponsor);

            }

            return sponsorizzazioni;

        } catch (Exception e) { return sponsorizzazioni; }
   }
   
   private boolean checkSponsor(String nome) {

       boolean sponsorAlreadyExists = false;

       try {

            String query = "SELECT * FROM sponsor WHERE nome = '" + nome + "';";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                sponsorAlreadyExists = true;
            }


        } catch (Exception e) { e.printStackTrace();} 

       return sponsorAlreadyExists;
   }
   
   public void insertSponsor(String nome) {
	   
       //if(!checkSponsor(nome)) {

           String query = "INSERT INTO sponsor VALUES (DEFAULT, '" + nome + "');";

           try { statement.executeUpdate(query); }
           
           catch (Exception e) { e.printStackTrace();}
       //}
   }
}