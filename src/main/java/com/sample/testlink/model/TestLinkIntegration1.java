/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.testlink.model;

import com.sample.testlink.controller.draft.ReadTestCase;
import static com.sample.testlink.controller.draft.ReadTestCase.removeTags;
import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author EYADI BONJO
 */
public class TestLinkIntegration1 {

  
          private static String[] testSteps;
    

//    public static void updateResults() throws IOException{
//        
//        ReadTestCase readbook= new ReadTestCase();
//       List<TestLinkIntegration> arrayList = new ArrayList<>();
//        
//        arrayList = readbook.readBooksFromExcelFile("test_docuemnt20171024.xlsx");
//      //  for (TestLinkIntegration tc : arrayList) {
//            
//           System.out.println("\n========================Start==============================\n");
//                System.out.println("{ " + arrayList.size());
//            System.out.println("\n============================End==========================\n");
//       // }
//    }


    public static void main(String[] args) {
        try {
            ReadTestCase readbook= new ReadTestCase();
            List<TestLinkIntegration> arrayList = new ArrayList<>();
            
            arrayList = readbook.readBooksFromExcelFile("test_docuemnt20171024.xlsx");
            //  for (TestLinkIntegration tc : arrayList) {
            
            System.out.println("=========================================== Start ==================== ");
            for (TestLinkIntegration testLinkIntegration : arrayList) {
                
                
                System.out.println(testLinkIntegration.getTestCaseName());
                System.out.println(testLinkIntegration.getAction());
                System.out.println(testLinkIntegration.getArgumanets1());
                System.out.println(testLinkIntegration.getArgumanets2());
                System.out.println(testLinkIntegration.getExpectedResult());
            }
            
            
//            System.out.println("\n========================Start==============================\n");
//            System.out.println("{Array " + arrayList.get(1).getAction());
            System.out.println("============================End==========================");
            // }
        } catch (IOException ex) {
            Logger.getLogger(TestLinkIntegration1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public List<TestLinkIntegration> readBooksFromExcelFile(String excelFilePath) throws IOException {
//        
//          
//    List<TestLinkIntegration> listBooks = new ArrayList<>();
//    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
// 
//    Workbook workbook = new XSSFWorkbook(inputStream);
//    Sheet firstSheet = workbook.getSheetAt(0);
//    Iterator<Row> iterator = firstSheet.iterator();
// 
//    while (iterator.hasNext()) {
//        Row nextRow = iterator.next();
//        Iterator<Cell> cellIterator = nextRow.cellIterator();
//        TestLinkIntegration aBook = new TestLinkIntegration();
// 
//        while (cellIterator.hasNext()) {
//            Cell nextCell = cellIterator.next();
//            int columnIndex = nextCell.getColumnIndex();
// 
//            switch (columnIndex) {
//            case 1:
//                aBook.setTestCaseName((String) getCellValue(nextCell));           
//                break;
//            case 2:
//                testSteps = removeTags((String) getCellValue(nextCell)).split("\r?\n");
//                        
//                        aBook.setAction(testSteps[2]);
//                        aBook.setArgumanets1(testSteps[3]);
//                        aBook.setArgumanets2(testSteps[4]);
//                break;
//            case 3:
//                aBook.setExpectedResult((String) getCellValue(nextCell));
//                break;
//            }
// 
// 
//        }
//        listBooks.add(aBook);
//    }
// 
//    workbook.close();
//    inputStream.close();
// 
//    return listBooks;
//}
//    
//
//     private Object getCellValue(Cell cell) {
//    switch (cell.getCellType()) {
//    case Cell.CELL_TYPE_STRING:
//        return cell.getStringCellValue();
// 
//    case Cell.CELL_TYPE_BOOLEAN:
//        return cell.getBooleanCellValue();
// 
//    case Cell.CELL_TYPE_NUMERIC:
//        return cell.getNumericCellValue();
//    }
// 
//    return null;
//}
}