package DAO;

import DTO.Organizzatore;
import linker.DBConnection;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OrganizzatoreDAO {

	private DBConnection DataBase;
	private Statement statement;
	

    public OrganizzatoreDAO() {
    	
    	DataBase = DBConnection.getConnection();
    	statement = DataBase.getStatement();
    }

    public Organizzatore getOrganizzatore(String id) {
    	
    	Organizzatore organizzatore = new Organizzatore();
    	
    	try {
    		
    		String query = "SELECT * FROM organizzatore WHERE email = '"+ id +"';";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                
            	organizzatore.setEmail(rs.getString(1));
                organizzatore.setTitolo(rs.getString(2));
                organizzatore.setNome(rs.getString(3));
                organizzatore.setCognome(rs.getString(4));
                organizzatore.setAfferenza(rs.getString(5));
                
            }
    		
		} catch (Exception e) { e.getMessage(); }

    	return organizzatore;
    }
    
    public ArrayList<Organizzatore> getOrganizzatori(String idConferenza) {       //nome del comitato

        ArrayList<Organizzatore> organizzatori = new ArrayList<Organizzatore>();

        try {

            String query = "SELECT * FROM organizzatore NATURAL JOIN comitato_scientifico WHERE id_conferenza = '"+ idConferenza +"';" ;
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                Organizzatore organizzatore = new Organizzatore();
                
                organizzatore.setEmail(rs.getString(1));
                organizzatore.setTitolo(rs.getString(2));
                organizzatore.setNome(rs.getString(3));
                organizzatore.setCognome(rs.getString(4));
                organizzatore.setTitolo(rs.getString(5));
                
                organizzatori.add(organizzatore);
            }

            return organizzatori;

        } catch (Exception e) { return organizzatori; }
    }

    public void insertOrganizzatore(String query) {
    	
    	System.out.println(query);
            
        try {  statement.executeUpdate(query); }
            
        catch (SQLException e) { e.printStackTrace();}
    }
}