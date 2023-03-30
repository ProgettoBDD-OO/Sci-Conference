package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Sponsor;
import linker.DBConnection;

public class SponsorDAO {

private DBConnection DataBase;

    public SponsorDAO() {

        DataBase = new DBConnection();
        DataBase.connettiDB();
    }

   public ArrayList<Sponsor> getSponsor(String id_conferenza) {

       ArrayList<Sponsor> sponsorizzazioni = new ArrayList<Sponsor>();

        try {

            String query = "SELECT nome FROM sponsor NATURAL JOIN sponsorizzazione WHERE id_conferenza = '"+ id_conferenza +"';"; 
            PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();

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
            PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                sponsorAlreadyExists = true;
            }


        } catch (Exception e) { e.printStackTrace();} 

       return sponsorAlreadyExists;
   }
   
   public void insertSponsor(String nome) {
	   
       if(!checkSponsor(nome)) {

           String query = "INSERT INTO sponsor VALUES (DEFAULT, '" + nome + "');";

           try {

                PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
                statement.executeQuery();

            } catch (Exception e) { e.printStackTrace();}
       }
   }
}