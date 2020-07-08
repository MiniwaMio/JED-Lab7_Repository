/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.sql.DataSource;
/**
 *
 * @author admin
 */
@Stateless
public class RegistrationBean {
    @Resource(name="jdbc/onlinegrocery")
    private DataSource customer;
    
    boolean result = true;
    //Validations
    //Email
    public int addAccount(String uname, String address, String postal, String contact, String email){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        int userId = 0;
        try{
            connection = customer.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO customer(name, deliveryaddress, postalcode, contactnumber, emailaddress) VALUES ( ?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, postal);
            preparedStatement.setString(4, contact);
            preparedStatement.setString(5, email);
            
            preparedStatement.executeUpdate();
            
            String searchUserId = "SELECT LAST_INSERT_ID()";
            preparedStatement = connection.prepareStatement(searchUserId);
            resultset = preparedStatement.executeQuery();
            
            resultset.next();
            userId = resultset.getInt(1);
            
            
            
        }catch(SQLException ex){
            try{
                connection.rollback();
            }catch(SQLException ex1){
                ex1.printStackTrace();
                System.err.println(ex.getMessage());
            }
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }finally{
            if(resultset != null){
                try{
                    resultset.close();
                }catch(SQLException ex){
                    try{
                        connection.rollback();
                    }catch(SQLException ex1){
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if(preparedStatement != null){
                try{
                    preparedStatement.close();
                }catch(SQLException ex){
                    try{
                        connection.rollback();
                    }catch(SQLException ex1){
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if(connection != null){
                try{
                    connection.close();
                }catch(SQLException ex){
                    try{
                        connection.setAutoCommit(true);
                        connection.rollback();
                    }catch(SQLException ex1){
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            return userId;
        }
    }
    public boolean isValidEmailAddress(String email){
        try{
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch(AddressException ex){
            result = false;
        }
        return result;
    }
    //uname
    public boolean isValidUName(String uname){
        if(uname.isEmpty() || uname == null){
            result = false;
        }
        return result;
    }
    public boolean isValidAddress(String address){
        if(address.isEmpty() || address == null){
            result = false;
        }
        return result;
    }
    public boolean isValidContactNumber(String phoneNo){
        if(!phoneNo.isEmpty() || phoneNo != null || Integer.parseInt(phoneNo) < 0){
            Pattern pattern = Pattern.compile("[6|8|9]\\d{7}$");
            Matcher matcher = pattern.matcher(phoneNo);
            if(matcher.find()){
                result = true;
            }else{
                result = false;
            }
        }
        return result;
    }
    public boolean isValidPostalCode(String postalC){
        if(postalC.isEmpty() || postalC.length() != 6){
            result = false;
        }else{
            try{
                Integer.parseInt(postalC);
            }
            catch(NumberFormatException e){
                return false;
            }
        }
        return result;
    }
    
}
