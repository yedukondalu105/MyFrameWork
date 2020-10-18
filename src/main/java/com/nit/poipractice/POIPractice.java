package com.nit.poipractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIPractice {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		File file=new File("resources/Testdata.xlsx");
	    FileInputStream fis;
	   
		try {
			fis=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("data1");
		//	System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
			//Row number starts from 0
		//int colnum=sheet.getRow(1).getLastCellNum();
		//System.out.println("last cell of second row::"+colnum);
			//int rowCount=sheet.getLastRowNum();
			//System.out.println("Last row number: "+sheet.getLastRowNum());//It will return in which row the last data is present(row number starts from 0)
			//System.out.println("First row number: "+sheet.getFirstRowNum()); //It will return the row number where data is started
			//System.out.println(sheet.getActiveCell()); //it will return which cell is focussed currently
			Iterator<Row> rows=sheet.iterator();
			Iterator<Cell> cells;
			//System.out.println("Cell type:: "+rows.next().getCell(0).getCellType());
			//To find the no of columns in first row
			int firstRowColumns=0;
			while(rows.hasNext()) {
				cells=rows.next().iterator();
				while(cells.hasNext()) {
					Cell cell=cells.next();
					//System.out.println(cell.toString());
					if(cell.getCellType()==CellType.STRING) {
						System.out.println(cell.getStringCellValue());
					}
					else if(cell.getCellType()==CellType.NUMERIC) {
						System.out.println(cell.getNumericCellValue());
						int num=(int) cell.getNumericCellValue();
						System.out.println(num);
					}
					else if(cell.getCellType()==CellType.BOOLEAN) {
						System.out.println(cell.getBooleanCellValue());
					}
					else if(cell.getCellType()==CellType.FORMULA) {
						System.out.println(cell.getCellFormula());
					}
					else {					
						throw new InvalidFormatException("The Value entered in cell is of invalid type");
					}	
					}				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
