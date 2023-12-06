package org.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\"
				+ "NovAdvFramework\\src\\test\\resources\\Data3.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		
		//Initialize the workbook
		Workbook workbook = new XSSFWorkbook(inputStream);
		//Creating a sheet
		Sheet createSheet = workbook.createSheet("New Sheet");
		
		//Create a row
		Row createRow = createSheet.createRow(0);
		
		//Create a cell
		Cell createCell = createRow.createCell(1);
		
		//Setting a value in the cell
		createCell.setCellValue("Greens");
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);		
	}
}




