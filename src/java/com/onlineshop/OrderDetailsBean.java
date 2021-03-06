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
public class OrderDetailsBean {
     @Resource(name="jdbc/onlinegrocery")
    private DataSource dsProductCatalogue;
     
     public List<Catalogue> itemDetails(int itemId) {
         
           List<Catalogue> itemDetails = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        
        try {
            connection = dsProductCatalogue.getConnection();
            
            preparedStatement = connection.prepareStatement("SELECT * FROM catalogue WHERE itemid = ?");
            
            preparedStatement.setInt(1, itemId);
            
            resultset = preparedStatement.executeQuery();
            
            while(resultset.next()) {
                Catalogue catalogue = new Catalogue();
                
                
                catalogue.setitemid(resultset.getInt("itemid"));
                catalogue.setCategoryid(resultset.getInt("categoryid"));
                catalogue.setitem(resultset.getString("item"));
                catalogue.setppu(resultset.getDouble("ppu"));
                
                itemDetails.add(catalogue);
                
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
        
        return itemDetails;
     }
}
