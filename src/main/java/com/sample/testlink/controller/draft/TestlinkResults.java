/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.testlink.controller.draft;

import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import com.sample.testlink.model.TestLinkIntegration;
import static com.sample.testlink.model.TestLinkIntegration.BUILD_NAME;
import static com.sample.testlink.model.TestLinkIntegration.TEST_PLAN_NAME;
import static com.sample.testlink.model.TestLinkIntegration.TEST_PROJECT_NAME;
import testlink.api.java.client.TestLinkAPIClient;

/**
 *
 * @author Dakangwa
 */
public class TestlinkResults {
    public static final String TESTLINK_KEY = "88061f71968708d4fc36bb3ccd141151";
    public static final String TESTLINK_URL = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
    
     public static void updateResults(String exception, String results) throws TestLinkAPIException, testlink.api.java.client.TestLinkAPIException {
//String testCaseName, 

       TestLinkIntegration testcases = new TestLinkIntegration();
       
        TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
        testLink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testcases.getTestCaseName(), BUILD_NAME, exception, results);
    }

}
