/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.testlink.controller.test;

import com.sample.testlink.controller.draft.ReadTestCase;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import com.sample.testlink.model.TestLinkIntegration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author Morph
 */
public class LinkIntegrationSeleneseTest {

    public static final String TESTLINK_KEY = "88061f71968708d4fc36bb3ccd141151";
    public static final String TESTLINK_URL = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
    
    WebDriver driver = null;
 
    ReadTestCase readbook = null;

    //@Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dakangwa\\Documents\\NetBeansProjects\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "E:\\Books\\Software Testing- DTS Books\\Esthers Project\\library\\geckodriver.exe");
        driver = new FirefoxDriver();

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Morph\\Documents\\NetBeansProjects\\library\\chromedriver_win32\\chromedriver.exe");
        //       driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    }


    //@Test
    public void GenericTest() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 100);
        
        ReadTestCase readbook= new ReadTestCase();
        
        String notes = null;

        String result = null;
            
        List<TestLinkIntegration> arrayList = new ArrayList<>();
            
        arrayList = readbook.readBooksFromExcelFile("test_docuemnt20171114.xlsx");
            
      for (TestLinkIntegration testLinkIntegration : arrayList) {
      
        try {

            driver.manage().window().maximize();

            driver.get(testLinkIntegration.getArgumanets1());
             
            driver.switchTo().defaultContent();

            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("+Testlink")));
            
            result = TestLinkAPIResults.TEST_PASSED;

            notes = "Executed successfully";

        } catch (Exception e) {

            result = TestLinkAPIResults.TEST_FAILED;

            notes = "Execution failed";

        } finally {

         updateTestLinkResults(testLinkIntegration.getTestCaseName(),notes, result);
        //driver.close();

        }

          
      }


//        try {
//
//            driver.manage().window().maximize();
//
//          
//
//            driver.get("http://localhost/testlink/login.php?note=logout&viewer=");
//
//            driver.findElement(By.id("tl_login")).sendKeys("admin");
//
//            driver.findElement(By.id("tl_password")).sendKeys("admin");
//
//            driver.findElement(By.id("//input[@value=\"Log in\"]")).click();
//
//            driver.switchTo().defaultContent();
//
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("+Testlink")));
//
//            result = TestLinkAPIResults.TEST_PASSED;
//
//            notes = "Executed successfully";
//
//        } catch (Exception e) {
//
//            result = TestLinkAPIResults.TEST_FAILED;
//
//            notes = "Execution failed";
//
//        } finally {
//
//            TestLinkIntegration.updateResults(notes, result);
//
//            driver.quit();
//        }

    }
    
    //@After
    public void tearDown() throws Exception {
        driver.quit();
    }
    
    public static final String TEST_PROJECT_NAME = "TestLinkAutomation"; // declare a variable to hold testProject
    public static final String TEST_PLAN_NAME = "AutomationTestPlan"; // declare a variable to hold a testPlan
    public static final String BUILD_NAME = "AutomationTest build 2"; // decare a variable to hold testBuild
     public static void updateTestLinkResults(String testcases, String exception, String results) throws TestLinkAPIException, testlink.api.java.client.TestLinkAPIException {
//String testCaseName, 

     //  TestLinkIntegration testcases = new TestLinkIntegration();
       
        TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
        testLink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testcases, BUILD_NAME, exception, results);
    }

    

}
