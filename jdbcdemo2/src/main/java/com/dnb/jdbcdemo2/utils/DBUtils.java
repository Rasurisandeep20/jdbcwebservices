package com.dnb.jdbcdemo2.utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

 

import javax.sql.DataSource;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

 

@Component
public class DBUtils {

@Autowired
DataSource dataSource;

 

    public DBUtils()
    {

    }

    public Optional<Connection> getConnection()//remove static for Spring
    {
        //Properties properties = getProperties();

        try {
    
            Connection connection = dataSource.getConnection();
            return Optional.of(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void closeConnection(Connection connection)
    {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

  
}