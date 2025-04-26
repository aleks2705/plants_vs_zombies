package com.epf.persistance;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.PreparedStatement;

//DataSource = objet qui permet de créer des connexions vers une BDD
public class DataSourceConnection {

    @Bean
    public static DataSource getDataSource(){
        MysqlDataSource dataSource = new MysqlDataSource(); //MytsqlDataSource = classe fournie paer le driver MySQL JDBC pour gérer les connxions à une bdd MySQL de manière plus avancée que DriverManage + améliore la secu  en evitant d'inclure directement
        //les info de connexions dans le code + optimise la gezstion des connexions
        dataSource.setUser("epf"); //checker dans resources/database
        dataSource.setPassword("epf111");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("pvz");
        dataSource.setURL("jdbc:mysql://localhost:3306/pvz");
        return dataSource;
    }

}
