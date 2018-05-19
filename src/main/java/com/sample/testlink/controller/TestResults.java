/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sample.testlink.controller;

/**
 *
 * @author Windows 10UI
 */
public class TestResults {
    
    public static String testConsoleResults(long testcaseNo, String pageTitle, String testcaseStatus) {
        String testResultsConsole;
        if (pageTitle!=null){
           testResultsConsole = "\n \n |============== Navigating to: "+pageTitle+"===============|\n"
                + " Executing Test Case #" + testcaseNo + " : "+testcaseStatus+" ...\n";
        }
        else{
            testResultsConsole = " Executing Test Case #" + testcaseNo + " : "+testcaseStatus+" ...\n";
        }
        
        return testResultsConsole;
        
        
      
    }
    
 
}
