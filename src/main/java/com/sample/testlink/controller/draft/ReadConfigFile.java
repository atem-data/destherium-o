/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.testlink.controller.draft;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
  
    
    public static void getConfigstatic() {

	Properties prop = new Properties();
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
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
			}
		}
	}

  }
}