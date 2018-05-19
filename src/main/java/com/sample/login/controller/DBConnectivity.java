/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.login.controller;

import com.sample.testlink.controller.ReadConfigFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author New Generation Cameroon: Olouge Eya Ekolle
 */
public class DBConnectivity {

   public static Connection con= null;
   static String dbhost = null;
   static String dburl= null;
   static String dbname= null;
   static String dbuser= null;
   static String dbpassword = null;
   
   /*  */
   public static Connection createConnection(){
       
       ReadConfigFile prop = new ReadConfigFile();
       
       // get the property value from config file
       dbname = prop.getPropertyValue("database");
       dbuser = prop.getPropertyValue("dbuser");
       dbpassword = prop.getPropertyValue("dbpassword");
       
       dbhost ="com.mysql.jdbc.Driver";
       dburl ="jdbc:mysql://localhost:3306/"+dbname;
       
       //
       try{ 
           Class.forName(dbhost);
           con = DriverManager.getConnection(dburl,dbuser,dbpassword);
           //JOptionPane.showMessageDialog(null, "Connection Successful");
           return con;
       }catch(ClassNotFoundException | SQLException e) {
           JOptionPane.showMessageDialog(null, e);
           return null;
       }
   }
    public static void closeConnection(){
        if(con != null){
            try{
                con.close();
            }
            catch(SQLException e){
                
            }
        }
    }
    

}
