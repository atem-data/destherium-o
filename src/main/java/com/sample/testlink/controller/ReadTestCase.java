/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.testlink.controller;

import com.sample.testlink.model.TestLinkIntegration;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Dakangwa
 */
public class ReadTestCase {

      //private static final Pattern REMOVE_TAGS = Pattern.compile("<*.+tr>|<*.table>");//"<.+?>" <*.+tr>
         
      private static final Pattern REMOVE_TAGS = Pattern.compile("<.+?>");
      
      private static final Pattern CHECK_TAGS = Pattern.compile("<.+?>");
      
       private static String[] testSteps = null;
       
      
     private static final String stringToSearch = "<table>\n"
            + "  <tr>\n"
            + "    <td>Action</td>\n"
            + "    <td>Argument 1</td>\n"
            + "	 <td>Argument 2</td>\n"
            + "  </tr>\n"
            + "</table> ";
      
    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }

        return null;
    }

    //Reads all the data values available in the excel sheet and set them to their corressponding model
    public List<TestLinkIntegration> readBooksFromExcelFile(String excelFilePath) throws IOException {
        
        List<TestLinkIntegration> testcases = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
      //      System.err.println("--------------------  12");
        Workbook workbook = new XSSFWorkbook(inputStream);
         // System.err.println("--------------------  12");
        Sheet firstSheet = (Sheet) workbook.getSheetAt(0);
       
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            TestLinkIntegration testcase = new TestLinkIntegration();
            

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        testcase.setTestCaseName((String) getCellValue(nextCell));                    
                        break;
                    case 1:
                    {// removeTags(String string); removeTags((String[]) getCellValue(nextCell)).split("\r?\n");
                       testSteps = removeTags((String) getCellValue(nextCell)).split("\r?\n");
                       //System.out.println(Arrays.toString(testSteps));
                       
                        testcase.setAction(testSteps[3].trim());
                       testcase.setArgumanets1(testSteps[4].trim());
                        testcase.setArgumanets2(testSteps[5].trim());
                  //     testcase.setAction((String) getCellValue(nextCell));
                  //System.out.println(testcase.setAction(testSteps[2]));
                        break;}
                    case 2:
                        testcase.setExpectedResult((String) getCellValue(nextCell));
                        break;
                }

            }
            testcases.add(testcase);
        }

        //workbook.close();
        inputStream.close();

        return testcases;
    }

    private Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
            throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = getWorkbook(inputStream, excelFilePath);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not an Excel file");
        }

        return workbook;
    }
    

//Class for HTML Syntax Removal or differentiate between html tags and perform an operation
    public static String removeTags(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        Matcher m = REMOVE_TAGS.matcher(string);
        Matcher check = CHECK_TAGS.matcher(string);
       return m.replaceAll("");
    }
    
//    public static String validateTags(String string) {
//        if (string == null || string.length() == 0) {
//            return string;
//        }
//
//        Matcher m = CHECK_TAGS.matcher(string);
//       return m.replaceAll("");
//    }
    
//      public static void main(String[] args) {
//         
//          System.out.println("\n========================HTML Remove==============================\n");
//          String[] split = removeTags(stringToSearch).split("\r?\n");
//           System.out.println(Arrays.toString(split));
//
//    }
  
    
}
