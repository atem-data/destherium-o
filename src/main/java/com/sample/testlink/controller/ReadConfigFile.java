/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.testlink.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
    
    
    private static Properties prop = null;
    
  public static void readProperties() {

	prop = new Properties();
	InputStream input = null;

	try {

		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
                System.out.println(prop.getProperty("dbhost"));
                System.out.println(prop.getProperty("testlink_key"));
                System.out.println(prop.getProperty("testlink_url"));
		System.out.println(prop.getProperty("database"));
		System.out.println(prop.getProperty("dbuser"));
		System.out.println(prop.getProperty("dbpassword"));

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

  } 
//    public MyPropAllKeys(){
//         
//        InputStream is = null;
//        try {
//            this.prop = new Properties();
//            is = this.getClass().getResourceAsStream("/sample.properties");
//            prop.load(is);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
     
//    public Set<Object> getAllKeys(){
//        Set<Object> keys = prop.keySet();
//        return keys;
//    }
     
    public String getPropertyValue(String key){
        
        prop = new Properties();
	InputStream input = null;

	try {

		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
//                System.out.println(prop.getProperty("dbhost"));
//                System.out.println(prop.getProperty("testlink_key"));
//                System.out.println(prop.getProperty("testlink_url"));
//		System.out.println(prop.getProperty("database"));
//		System.out.println(prop.getProperty("dbuser"));
//		System.out.println(prop.getProperty("dbpassword"));

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        return prop.getProperty(key);
    }
     
   
}
