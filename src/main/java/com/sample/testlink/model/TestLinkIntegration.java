/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.testlink.model;

import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIClient;

/**
 *
 * @author EYADI BONJO
 */
public class TestLinkIntegration {
    
      private String testLinkUrl ; // To hold the default TestLink access link/url
      private String testLinkKey; // Key generated after intallation of TestLink 
      private String testProjectName; //Test project name from TestLink to perform Automation testing
      private String testPlanName; //Corresponding Test plan name from TestLink project above
      private String buildName; // Corresponding Test build name from TestLink test plan above
      private String testCaseName; // Test cases name to be executed
      private String[] testSteps;//Test steps to be executed from a define test case
      private String action; //test_elements 1
      private String argumanets1; //test_elements 2
      private String argumanets2; //test_elements 2
      private String expectedResult; //Expected Results

    public String getArgumanets1() {
        return argumanets1;
    }

    public void setArgumanets1(String argumanets1) {
        this.argumanets1 = argumanets1;
    }

    public String getArgumanets2() {
        return argumanets2;
    }

    public void setArgumanets2(String argumanets2) {
        this.argumanets2 = argumanets2;
    }

    public String[] getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(String[] testSteps) {
        this.testSteps = testSteps;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }
      
      
    public String getTestLinkUrl() {
        return testLinkUrl;
    }

    public void setTestLinkUrl(String testLinkUrl) {
        this.testLinkUrl = testLinkUrl;
    }

    public String getTestLinkKey() {
        return testLinkKey;
    }

    public void setTestLinkKey(String testLinkKey) {
        this.testLinkKey = testLinkKey;
    }

    public String getTestProjectName() {
        return testProjectName;
    }

    public void setTestProjectName(String testProjectName) {
        this.testProjectName = testProjectName;
    }

    public String getTestPlanName() {
        return testPlanName;
    }

    public void setTestPlanName(String testPlanName) {
        this.testPlanName = testPlanName;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
     
      
    public static final String TESTLINK_KEY = "88061f71968708d4fc36bb3ccd141151";
    public static final String TESTLINK_URL = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
    public static final String TEST_PROJECT_NAME = "TestLink Test"; // declare a variable to hold testProject
    public static final String TEST_PLAN_NAME = "TestLink Test Plan"; // declare a variable to hold a testPlan
    public static final String TEST_CASE_NAME = "TestLink Login Test Automation"; // declare an array list of testCases
    public static final String BUILD_NAME = "TestBuild5"; // decare a variable to hold testBuild
    //Create a model callled TestSpec having test_project, test_plan, test_build, test_cases, test_elements

    public static void updateResults(String exception, String results) throws TestLinkAPIException, testlink.api.java.client.TestLinkAPIException {
//String testCaseName, 
        TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
        testLink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, TEST_CASE_NAME, BUILD_NAME, exception, results);
    }

}
