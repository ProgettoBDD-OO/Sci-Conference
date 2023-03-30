package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Organizzatore;
import linker.DBConnection;

public class OrganizzatoreDAO {

private DBConnection DataBase;

    public OrganizzatoreDAO() {

        DataBase = new DBConnection();
        DataBase.connettiDB();
    }

    public ArrayList<Organizzatore> getOrganizzatoriComitato(String istituzione) {       //nome del comitato

        ArrayList<Organizzatore> organizzatori = new ArrayList<Organizzatore>();

        try {

            String query = "SELECT * FROM organizzatore WHERE istituzioneDiAfferenza = '" + istituzione + "';" ;
            PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Organizzatore org = new Organizzatore();
                org.setNomeCognome(rs.getString(2));
                org.setEmail(rs.getString(3));
                org.setAfferenza(istituzione);

                organizzatori.add(org);

            }

            return organizzatori;

        } catch (Exception e) { return organizzatori; }

    }
    
    private boolean checkOrganizzatore(String email) {

        boolean organizzatoreAlreadyExists = false;

        try {

             String query = "SELECT * FROM organizzatore WHERE email = '" + email + "';";
             PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
             ResultSet rs = statement.executeQuery();

             while (rs.next()) {
                 organizzatoreAlreadyExists = true;
             }


         } catch (Exception e) { e.printStackTrace();} 

        return organizzatoreAlreadyExists;
    }

    public void insertOrganizzatore(String q) {

        //if(!checkOrganizzatore(org.getEmail())) {

            String query = q + ";";

            try {

                 PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
                 statement.executeQuery();

             } catch (Exception e) { e.printStackTrace();}
        //}
    }
}