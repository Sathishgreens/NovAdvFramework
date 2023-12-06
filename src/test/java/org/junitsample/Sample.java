package org.junitsample;

import java.io.IOException;

import org.base.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pages.LoginPage;

public class Sample extends BaseClass {
	public static String path = "C:\\Users\\Lenovo\\eclipse-workspace"
			+ "\\NovAdvFramework\\src\\test\\resources\\Data.xlsx";
	String fileName;
	static WebElement userName;
	static WebElement password;
	static WebElement loginButton;
	
	
	@BeforeClass
	public static void initSetUp() {
		browseLaunch("chrome");
		setImplicitlyWait(10);	
		maximizeWindow();
		loadUrl("https://www.facebook.com/");
		LoginPage loginPage = new LoginPage();
		userName = loginPage.getUserName();
		password = loginPage.getPassword();
		loginButton = loginPage.getLoginButton();
		
	}
	
	@Before
	public void befEveryTest() {
		
	}
	//Negative
	@Test
	public void tc1() throws IOException {	
		fileName="userLogin.png";
//		userName = findingElement("id", "email");	
//		password = findingElement("id", "pass");
//		loginButton = findingElement("name", "login");
		
		passValue(userName, excelRead(path, "Login Data", 1, 0));
		passValue(password, excelRead(path, "Login Data", 1, 1));
		elementClick(loginButton);
		
	}
	
	@Test
	public void tc2() throws IOException {
//		userName = findingElement("id", "email");	
//		password = findingElement("id", "pass");
//		loginButton = findingElement("name", "login");
		
		passValue(userName, excelRead(path, "Login Data", 2, 0));
		passValue(password, excelRead(path, "Login Data", 2, 1));
		elementClick(loginButton);
		String actual = password.getText();
		Assert.assertEquals("Invalid UserName", actual);
		
	}
	
	@Test
	public void tc3() throws IOException {
//		userName = findingElement("id", "email");	
//		password = findingElement("id", "pass");
//		loginButton = findingElement("name", "login");
		passValue(userName, excelRead(path, "Login Data", 3, 0));
		passValue(password, excelRead(path, "Login Data", 3, 1));
		elementClick(loginButton);
	}
	
	@After
	public void aftEveryTest() throws IOException {
		String filePath = "C:\\Users\\Lenovo\\eclipse-workspace"
				+ "\\NovAdvFramework\\target\\"+fileName;
		takeScreenshot(filePath);
		navigateBack();
		refreshWindow();
		
	}
	
	@AfterClass
	public static void exitSetUp() {		
		closeBrowser();		
	}

}
