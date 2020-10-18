package com.nit.testproj.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.nit.userdefinedexceptions.IncorrectTestCaseNumberException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Data {
	
	public Object[][] getData(String sheetName, String testId){
		
		File file=new File("resources/Testdata.xlsx");
	    FileInputStream fis;
	    int firstRowColumns=0,i=0;
	    List<String> keys=null;
	    Map<String,String> rowData=null;
	    List<Map<String,String>> lmap;
	    String testName=testId;
	    int testCaseRowNum=0;
	    int noOfIterations=0;
	    Object[][] obj=null;
		try {
			fis=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			
			Iterator<Row> rows=sheet.iterator();
			Iterator<Cell> cells;
			keys=new ArrayList<String>();
			rowData=new LinkedHashMap<String,String>();
			lmap=new ArrayList<Map<String,String>>();
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
				if(sheet.getRow(k)!=null && sheet.getRow(k).getCell(0)!=null && sheet.getRow(k).getCell(0).getStringCellValue().equalsIgnoreCase(testName)) {
					if(testCaseRowNum==0) {
						testCaseRowNum=k;
					}
					noOfIterations++;
				}
				
			}
			if(testCaseRowNum==0) {
				throw new IncorrectTestCaseNumberException("Please enter valid test case number");
			}
			obj=new Object[noOfIterations][1];
			int itrs=0;
			//
			for(int x=testCaseRowNum;x<testCaseRowNum+noOfIterations;x++) {
				Map<String,String> map=new LinkedHashMap<String, String>();
				for(int j=1;j<firstRowColumns;j++) {
					if(sheet.getRow(x).getCell(j)!=null) {
						map.put(keys.get(j), sheet.getRow(x).getCell(j).getStringCellValue());
					}
					
				}
				obj[itrs][0]=map;
				itrs++;
				//lmap.add(map);				
			}
			/*for(Map<String,String> map:lmap) {
				obj[itrs][0]=map;
				itrs++;
			}*/
			/*
			System.out.println("No of columns in first row where data present are:: "+firstRowColumns);
			System.out.println(keys);
			System.out.println("Test case row number::"+testCaseRowNum);
			System.out.println("Test case required data::"+rowData);	*/
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return obj;
	}
	
	}

	

