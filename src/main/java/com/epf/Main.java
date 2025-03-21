package com.epf;

import com.epf.models.Zombie;
import com.epf.persistance.DataSourceConnection;
import com.epf.persistance.dao.ZombieDAO;
import com.epf.persistance.dao.impl.ZombieDAOImpl;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceConnection.getDataSource()); //tut on dobavil user etc. d getcoonnection

        try {
            Connection connect = DataSourceConnection.getDataSource().getConnection();
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
