package com.onlineshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless

public class AddCartBean {
    @Resource(name="jdbc/onlinegrocery")
    private DataSource dsGrocery;
    
    public int GetCustomerId(String username)
    {
        int customerId = 0;
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        
         try {
            connection = dsGrocery.getConnection();
            
            preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE name = ?");
            
            preparedStatement.setString(1, username);
            
            resultset = preparedStatement.executeQuery();
            
            while(resultset.next()) {
                customerId = resultset.getInt("customerid");

            }
            
            
            
        } catch(SQLException ex) {
            //Usually, the error should be logged somewhere in the system log.
            //Sometimes, users may also need to be notified regarding such error
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        } finally {
            //Resultset, Statement and Connection are closed in the finally 
            // clause to ensure that they will be closed no matter what 
            // happens to the system.
            if(resultset != null) {
                try {
                    resultset.close();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
        
        
        }
        
        return customerId;
    }
    
    
    
}
