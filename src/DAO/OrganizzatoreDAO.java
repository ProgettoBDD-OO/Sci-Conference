package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Organizzatore;
import linker.DBConnection;

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
    		
    		String query = "SELECT * FROM organizzatori WHERE email = '"+ id +"';";
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
    
    public ArrayList<Organizzatore> getOrganizzatori(int id_conferenza) {       //nome del comitato

        ArrayList<Organizzatore> organizzatori = new ArrayList<Organizzatore>();

        try {

            String query = "SELECT * FROM organizzatori NATURAL JOIN comitati_scientifici WHERE id_conferenza = '"+ id_conferenza +"';" ;
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
    
    private boolean checkOrganizzatore(String email) {

        boolean organizzatoreAlreadyExists = false;

        try {

             String query = "SELECT * FROM organizzatori WHERE email = '" + email + "'; ";
             ResultSet rs = statement.executeQuery(query);

             rs.next();
             organizzatoreAlreadyExists = true;

         } catch (Exception e) { e.printStackTrace();} 

        return organizzatoreAlreadyExists;
    }

    public void insertOrganizzatore(String query) {

        //if(!checkOrganizzatore(org.getEmail())) {
            
            System.out.println(query + ";");
            
            try {  statement.executeUpdate(query + "; "); }
            
            catch (Exception e) { e.printStackTrace();}
        //}
    }
}