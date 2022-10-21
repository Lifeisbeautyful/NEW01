package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Ipathconstant.IpathConstant;

public class ExcelUtility
{
	
	//Getting data from Excel sheet
	/**
	 * this method is uded to fetch data from excel
	 * @param sheetName
	 * @param RowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author adminDeepak
	 */
	
	public String getDataFromExcel(String sheetName,int RowNum,int cellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstant.PROPERTYFILE_PATH2);
		//FileInputStream fis1=new FileInputStream("./Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String data=book.getSheet(sheetName).getRow(RowNum).getCell(cellnum).getStringCellValue();
		return data;
	}


//........................................................................................................................................................

	
//To get the last used row number on specified Sheet
/**
 * used to get the last used row number on specified Sheet
 * @param sheetName
 * @return
 * @throws Throwable
 */
public int getRowCount(String sheetName) throws Throwable 
{
	//FileInputStream fis  = new FileInputStream("./Vtiger.xlsx");
	FileInputStream fis=new FileInputStream(IpathConstant.PROPERTYFILE_PATH2);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	wb.close();
	return sh.getLastRowNum();
}

//........................................................................................................................................................

//To write data back to Excel
/**
 * used to write data back to Excel based on below parameter
 * @param sheetName
 * @param rowNum
 * @param celNum
 * @param data
 * @throws Throwable
 */
public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
	//FileInputStream fis  = new FileInputStream("./Vtiger.xlsx");
	FileInputStream fis=new FileInputStream(IpathConstant.PROPERTYFILE_PATH2);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	Cell cel = row.createCell(celNum);
	cel.setCellValue(data);
	FileOutputStream fos = new FileOutputStream("./Vtiger.xlsx");
	wb.write(fos);
	wb.close();

}
}