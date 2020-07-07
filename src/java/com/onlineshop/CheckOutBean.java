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
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import org.apache.commons.validator.routines.CreditCardValidator;

/**
 *
 * @author Norelle
 */
@Stateless
public class CheckOutBean {

    @Resource(name = "jdbc/onlinegrocery")
    private DataSource dsOrder;

    public String validateCard(String creditcard) {
        //Validate Credit Card
        String message = "fail";
//        CreditCardValidator creditCardValidator;
//        creditCardValidator = CreditCardValidator.genericCreditCardValidator();

        if (creditcard.length() < 16 || creditcard.length() > 16) {
            return message;
        } else {
            message = "success";
            return message;
        }

    }

    //Create New Order
    public void createOrder(int customerid, int itemid, int quantity) {

        System.out.println("Creating New Order");

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            String SQLInsert = "Insert into onlinegrocery.order (customerid,itemid,quantity) values (?,?,?)";

            connection = dsOrder.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQLInsert);
            statement.setInt(1, customerid);
            statement.setInt(2, itemid);
            statement.setInt(3, quantity);
            statement.executeUpdate();
            System.out.println(itemid + " has been successfully added");

        } catch (SQLException ex) {
            System.out.println("Problem occured with insertion");
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                System.err.println(ex1.getMessage());
            }
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }

            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }

            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }

            }
        }

    }

}
