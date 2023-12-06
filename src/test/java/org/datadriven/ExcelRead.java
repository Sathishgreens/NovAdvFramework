package org.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {
		Workbook workbook = null;
		File file = new File(
				"C:\\Users\\Lenovo\\eclipse-workspace\\" + "NovAdvFramework\\src\\test\\resources\\Data.xlsx");
		// FileInputStream
		try {
			FileInputStream inputStream = new FileInputStream(file);
			// Access the workbook in input stream
			workbook = new XSSFWorkbook(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// to access a sheet
		Sheet loginDataSheet = workbook.getSheet("Sheet3");
		int numberOfRows = loginDataSheet.getPhysicalNumberOfRows();

		// To print all data in a sheet
		for (int i = 0; i < numberOfRows; i++) {
			Row row = loginDataSheet.getRow(i);
			int numberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < numberOfCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
					break;
				case NUMERIC:
					boolean cellDateFormatted = DateUtil.isCellDateFormatted(cell);

					if (cellDateFormatted) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
						String format = dateFormat.format(dateCellValue);
						System.out.println(format);
					} else {
						double numericCellValue = cell.getNumericCellValue();
						long num = (long) numericCellValue;
						if (num == numericCellValue) {
							System.out.println(num);
						} else {
							System.out.println(numericCellValue);
						}
					}
					break;
				case BOOLEAN:
					boolean booleanCellValue = cell.getBooleanCellValue();
					System.out.println(booleanCellValue);
					break;
				default:
					break;
				}
			}
		}
	}

}
