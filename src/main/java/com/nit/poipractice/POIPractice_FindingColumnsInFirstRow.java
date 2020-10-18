package com.nit.poipractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.nit.userdefinedexceptions.IncorrectTestCaseNumberException;
public class POIPractice_FindingColumnsInFirstRow {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		File file=new File("resources/Testdata.xlsx");
	    FileInputStream fis;
	    int firstRowColumns=0,i=0;
	    List<String> keys=null;
	    Map<String,String> rowData=null;
	    String testName="33333";
	    int testCaseRowNum=0;
		try {
			fis=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("data1");
			Iterator<Row> rows=sheet.iterator();
			Iterator<Cell> cells;
			keys=new ArrayList<String>();
			rowData=new LinkedHashMap<String,String>();
			while(rows.hasNext()) {
				if(i>0) {
					break;
				}
				cells=rows.next().iterator();
				while(cells.hasNext()) {
					keys.add(cells.next().getStringCellValue());
					firstRowColumns++;
			    }
				i++;
			}
			
			//To find the row number of the test case
			for(int k=0;k<sheet.getLastRowNum()+1;k++) {
				if(sheet.getRow(k).getCell(0).getStringCellValue().equalsIgnoreCase(testName)) {
					testCaseRowNum=k;
					break;
				}
				
			}
			if(testCaseRowNum==0) {
				throw new IncorrectTestCaseNumberException("Please enter valid test case number");
			}
			for(int j=1;j<firstRowColumns;j++) {
				rowData.put(keys.get(j), sheet.getRow(testCaseRowNum).getCell(j).getStringCellValue());
							
			}
			System.out.println("No of columns in first row where data present are:: "+firstRowColumns);
			System.out.println(keys);
			System.out.println("Test case row number::"+testCaseRowNum);
			System.out.println("Test case required data::"+rowData);	
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
