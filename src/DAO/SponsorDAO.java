package DAO;

import DTO.Sponsor;
import linker.DBConnection;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Statement;


public class SponsorDAO {

	private DBConnection DataBase;
	private Statement statement;

    public SponsorDAO() {

    	DataBase = DBConnection.getConnection();
        statement = DataBase.getStatement();
    }

   public ArrayList<Sponsor> getSponsor(String idConferenza) {

       ArrayList<Sponsor> sponsorizzazioni = new ArrayList<Sponsor>();

        try {

            String query = "SELECT * FROM sponsor("+ idConferenza +");"; 
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

            while (rs.next()) { sponsorAlreadyExists = true; }


        } catch (Exception e) { e.printStackTrace(); } 

       return sponsorAlreadyExists;
   }
   
   public void insertSponsor(String nome, int idConferenza) {
	   
      if(!checkSponsor(nome)) {
    	  
    	  String query = "CALL insert_sponsor('" + nome + "', "+ idConferenza +");";

          try { statement.executeUpdate(query); }
           
          catch (Exception e) { e.printStackTrace();}
      }
   }
}