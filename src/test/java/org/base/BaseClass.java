package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;

	public static void browseLaunch(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("filefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static WebElement findingElement(String locator, String value) {
		WebElement element = null;
		switch (locator) {
		case "id":
			element = driver.findElement(By.id(value));
			break;
		case "name":
			element = driver.findElement(By.name(value));
			break;
		case "tagName":
			element = driver.findElement(By.tagName(value));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(value));
			break;
		case "linkText":
			element = driver.findElement(By.linkText(value));
			break;
		default:
			break;
		}

		return element;
	}

	public static void passValue(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static String excelRead(String path, String sheetName, int rowNumber, int cellNumber) throws IOException {
		// File Input Stream
		FileInputStream inputStream = new FileInputStream(new File(path));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		String value = null;
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			boolean cellDateFormatted = DateUtil.isCellDateFormatted(cell);

			if (cellDateFormatted) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
				value = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long num = (long) numericCellValue;
				if (num == numericCellValue) {
					value = Long.toString(num);
				} else {
					value = Double.toString(numericCellValue);
				}
			}
			break;
		case BOOLEAN:
			boolean booleanCellValue = cell.getBooleanCellValue();
			value = Boolean.toString(booleanCellValue);
			break;
		default:
			break;
		}
		return value;
	}
	
	public static void setImplicitlyWait(long sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public static void elementClick(WebElement ele) {
		ele.click();
	}
	
	public static void takeScreenshot(String filePath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(filePath));
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	public static String gettingText(WebElement ele) {
		String text = ele.getText();
		return text;
	}
	
	public static void refreshWindow() {
		driver.navigate().refresh();
	}
	
	public static void navigateBack() {
		driver.navigate().back();
	}
	
	public static String getAttributeValue(WebElement ele,String name) {
		return ele.getAttribute(name);
	}
	
	
	public static void dropDown(WebElement element , String method , String value) {
		
		Select select = new Select(element);
		
		switch (method) {
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
			break;
		case "index":
			int parseInt = Integer.parseInt(value);
			select.selectByIndex(parseInt);
			break;
		default:
			break;
		}
		
	}
	
	public static String pageTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}
	

}





