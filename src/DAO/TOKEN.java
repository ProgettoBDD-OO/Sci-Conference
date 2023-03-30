package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import linker.DBConnection;

public class TOKEN {

    private DBConnection DataBase;

    public TOKEN() {

        DataBase = new DBConnection();
        DataBase.connettiDB();
    }

    public boolean checkTOKEN(String password) {

        String select = "SELECT * FROM db_token WHERE db_token = '" + password + "';" ;
        boolean isAdmin = false;

        try {

            PreparedStatement statement = DataBase.getConnection().prepareStatement(select);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                isAdmin = true;
            }

        } catch (Exception e) { e.printStackTrace(); }

        return isAdmin;
    }

}