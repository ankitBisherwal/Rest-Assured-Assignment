package sample_java;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import Helper.helper;

public class Excel_read_write {
	
	@Test
	public void test() throws IOException, EncryptedDocumentException, NullPointerException{
		
        ClassLoader classLoader = this.getClass().getClassLoader();
		FileInputStream file = new FileInputStream(classLoader.getResource("ExcelRW.xlsx").getFile());
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowstart = sheet.getFirstRowNum();
		int rowend = sheet.getLastRowNum();
		rowend++;
		//System.out.println(rowend);
		for(int i= rowstart+1;i<rowend;i++)
		{
			Row row = sheet.getRow(i);
			String request = row.getCell(0).getStringCellValue();
			String url = row.getCell(1).getStringCellValue();
			int statusCode = (int) row.getCell(2).getNumericCellValue();
			int status = helper.help(request,url);
			//System.out.println(statusCode);
			//System.out.println(status);
			Assert.assertEquals(statusCode, status);
		}
	}

	
	
	
}
