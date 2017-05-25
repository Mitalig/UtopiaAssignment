package com.setup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {

  public static XSSFSheet ExcelWSheet;
  public static String ExcelWSheets;
  public static List<String> ExcelWSheetNames = new ArrayList<String> ();
  public static XSSFWorkbook ExcelWBook;
  public static XSSFCell Cell;
  public static XSSFRow Row;
  public static int rowCount;

  public static void setExcelFile (String Path) throws Exception {

    try {
      FileInputStream ExcelFile = new FileInputStream (Path);
      ExcelWBook = new XSSFWorkbook (ExcelFile);
    }
    catch (Exception e) {
      Log.info ("Failed to set the Excel file | Class:Excel Utils | method: setExcelFile " + e.getMessage ());
     
    }
  }

  public static String getCellData (int RowNum, int ColNum, String SheetName)

  {

    try {
      ExcelWSheet = ExcelWBook.getSheet (SheetName);
      try {
        Cell = ExcelWSheet.getRow (RowNum).getCell (ColNum);
        String CellData = Cell.getStringCellValue ();
        return CellData;
      }

      catch (Exception e) {
        Log.info ("Failed to return the String Cell data | Class:Excel Utils | method: getCellData " + e.getMessage ());
        // ActionsWeb.bResult=false;
        // ActionsMobile.bResult=false;

      }
    }
    catch (Exception e) {
      Log.info ("Failed to get the sheet name | Class:Excel Utils | method: getCellData " + e.getMessage ());
     

    }
    return "";

  }

  public static int getCellData1 (int RowNum, int ColNum, String SheetName) throws Exception {

    try {
      ExcelWSheet = ExcelWBook.getSheet (SheetName);
      try {

        Cell = ExcelWSheet.getRow (RowNum).getCell (ColNum);
        int CellData = (int) Cell.getNumericCellValue ();
        return CellData;
      }
      catch (Exception e) {
        Log.info ("Not able to get the int cell data | Class: Excel Utils | method: getCellData1 " + e.getMessage ());
       
        return 0;
      }
    }
    catch (Exception e) {
      Log.info ("Failed to get the sheet name | Class: Excel Utils | method: getCellData1 " + e.getMessage ());
     

    }
    return 0;
  }

  public static int getRowCount (String SheetName) {

    try {
      ExcelWSheet = ExcelWBook.getSheet (SheetName);

      try {

        int number = ExcelWSheet.getLastRowNum ();
        return number;
      }

      catch (Exception e) {
        Log.info ("Failed to return the row count | Class:ExcelUtils : method: getRowCount " + e.getMessage ());
      
      }
    }
    catch (Exception e) {
      Log.info ("Failed to return the the Sheet Name | Class:ExcelUtils : method: getRowCount " + e.getMessage ());
     

    }
    return 0;

  }

  public static int getRowContains (String sTestCaseName, int colNum, String SheetName) throws Exception {

    try {
      int i;
      ExcelWSheet = ExcelWBook.getSheet (SheetName);
      try {
        rowCount = ExcelUtils.getRowCount (SheetName);
      }
      catch (Exception e) {
        Log.info ("Falied to get the row count | Class:ExcelUtils : method: getRowContains " + e.getMessage ());
       

      }
      for (i = 1; i <= rowCount; i++) {

        if (ExcelUtils.getCellData (i, colNum, SheetName).equalsIgnoreCase (sTestCaseName)) {
          break;
        }

      }
      return i;

    }
    catch (Exception e) {
      Log.info (
          "Failed to get the sheet name or cell data Class:ExcelUtils : method: getRowContains " + e.getMessage ());
    
    }

    return 0;
  }

 

  @SuppressWarnings ("static-access")
  public static void setCellData (String Result, int RowNum, int ColNum, String SheetName) throws Exception {

    try {

      ExcelWSheet = ExcelWBook.getSheet (SheetName);
      Row = ExcelWSheet.getRow (RowNum);
      Cell = Row.getCell (ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
      if (Cell == null) {
        Cell = Row.createCell (ColNum);
        Cell.setCellValue (Result);
      }
      else {
        Cell.setCellValue (Result);
      }
     // FileOutputStream fileOut = new FileOutputStream (VerifyingExcel.excelFilePath);
      //ExcelWBook.write (fileOut);
      //fileOut.close ();
     // ExcelWBook = new XSSFWorkbook (new FileInputStream (VerifyingExcel.excelFilePath));
    }
    catch (Exception e) {
      Log.info ("Failed to set the cell data Class:ExcelUtils : method: setCellData" + e.getMessage ());

    }
  }

  public static List<String> getSheetNames () {

    for (int i = 0; i < ExcelWBook.getNumberOfSheets (); i++) {
      ExcelWSheets = ExcelWBook.getSheetAt (i).getSheetName ();
      ExcelWSheetNames.add (ExcelWSheets);

    }

    return ExcelWSheetNames;

  }

}