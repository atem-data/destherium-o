/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.login.controller;

import com.sample.login.model.LoginModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dakangwa
 */
public class LoginController {
    
     private static Connection con = null; // Declaring conn variable to connect the Java class to the db or MySql db
    private static PreparedStatement pst = null;
    private static ResultSet rst = null;

//    private LoginController() {
//        con = DBConnectivity.createConnection();
//    }

    public static ResultSet loginRecords(LoginModel login) throws SQLException {
//            System.out.print("-----------------------2-----------------------------\n");
//                System.out.print(login.getPassword());
//                 System.out.print("\n-------------------End--------------------------\n");
        try {
            con = DBConnectivity.createConnection();
            String sql = "SELECT id,login,password,role_id, active FROM tlfn_users "
                    + "where login = '" + login.getLogin() + "' AND "
                    + "password = MD5('" + login.getPassword() + "') AND "
                    + "active = '1' ";
            pst = con.prepareStatement(sql);
            rst = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }
    
    public static void blockAccount(LoginModel login) throws SQLException {
        try {
            con = DBConnectivity.createConnection();
            String sql = "UPDATE tlfn_users SET active = ? "
                    + "where login = ? ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setString(2, login.getLogin());
            
            // execute the java preparedstatement
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
}
