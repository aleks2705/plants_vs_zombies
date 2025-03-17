package com.epf;

import com.epf.persistance.DataSourceConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connect = DataSourceConnection.getDataSource().getConnection(); //tut on dobavil user etc. d getcoonnection
            System.out.println("Connection réussie!");

            String sql = "SELECT * from map, zombie, plante";

            PreparedStatement statement = connect.prepareStatement(sql);
            //Resultat de la requete
            ResultSet resultSet = statement.executeQuery();

            connect.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }




    }
}
