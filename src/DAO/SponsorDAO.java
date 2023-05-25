package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Sponsor;
import linker.DBConnection;


public class SponsorDAO {

	private DBConnection DataBase;
	private Statement statement;

    public SponsorDAO() {

    	DataBase = DBConnection.getInstance();
        statement = DataBase.getStatement();
    }


    public ArrayList<Sponsor> getSponsor(String idConferenza) {

    	ArrayList<Sponsor> sponsorizzazioni = new ArrayList<>();

    	try {

    		String select = "SELECT * FROM sponsor(" + idConferenza + ");";
            ResultSet rs = statement.executeQuery(select);

            while(rs.next()) {

                Sponsor sponsor = new Sponsor();
                sponsor.setNome(rs.getString(1));
                sponsorizzazioni.add(sponsor);

            }

        } catch (SQLException e) { e.getMessage(); }

    	return sponsorizzazioni;
   }

   public void insertSponsor(String nome, int idConferenza) {

	  String query = "CALL insert_sponsor('" + nome + "', " + idConferenza + ");";

      try { statement.executeUpdate(query); }

      catch (SQLException e) { e.getMessage(); }
   }
}