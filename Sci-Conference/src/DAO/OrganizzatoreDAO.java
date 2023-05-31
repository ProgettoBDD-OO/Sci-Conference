package DAO;

import DTO.Organizzatore;
import linker.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrganizzatoreDAO {

	private DBConnection DataBase;
	private Statement statement;


    public OrganizzatoreDAO() {

    	DataBase = DBConnection.getInstance();
    	statement = DataBase.getStatement();
    }


    public Organizzatore getOrganizzatore(String idOrganizzatore) {

    	Organizzatore organizzatore = new Organizzatore();

    	try {

    		String select = "SELECT * FROM organizzatore WHERE email = '"+ idOrganizzatore +"';";
            ResultSet rs = statement.executeQuery(select);

            rs.next();

        	organizzatore.setEmail(rs.getString(1));
            organizzatore.setTitolo(rs.getString(2));
            organizzatore.setNome(rs.getString(3));
            organizzatore.setCognome(rs.getString(4));
            organizzatore.setAfferenza(rs.getString(5));

		} catch (SQLException e) { e.getMessage(); }

    	return organizzatore;
    }


    public ArrayList<Organizzatore> getOrganizzatori(String idConferenza) {

        ArrayList<Organizzatore> organizzatori = new ArrayList<>();

        try {

            String select = "SELECT * FROM organizzatore NATURAL JOIN comitato_scientifico WHERE id_conferenza = '"+ idConferenza +"';" ;
            ResultSet rs = statement.executeQuery(select);

            while (rs.next()) {

                Organizzatore organizzatore = new Organizzatore();

                organizzatore.setEmail(rs.getString(1));
                organizzatore.setTitolo(rs.getString(2));
                organizzatore.setNome(rs.getString(3));
                organizzatore.setCognome(rs.getString(4));
                organizzatore.setTitolo(rs.getString(5));

                organizzatori.add(organizzatore);
            }

        } catch (SQLException e) { e.getMessage(); }

        return organizzatori;
    }


    public void insertOrganizzatore(Organizzatore organizzatore, int idConferenza) {


        try {

        	String insert = "CALL insert_organizzatore('" + organizzatore.getEmail() + "', '" 
        												  + organizzatore.getTitolo() + "', '"
        												  + organizzatore.getNome() + "', '" 
        												  + organizzatore.getCognome() + "', '" 
        												  + organizzatore.getAfferenza()+"'," 
        												  + idConferenza + ");";
        	statement.executeUpdate(insert);

        } catch (SQLException e) { e.getMessage();}
    }
}