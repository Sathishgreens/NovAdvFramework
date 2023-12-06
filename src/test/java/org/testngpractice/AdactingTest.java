package org.testngpractice;

import java.io.IOException;

import org.adactinpages.LoginPage;
import org.adactinpages.PageManager;
import org.adactinpages.SearchHotelPage;
import org.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdactingTest extends BaseClass {
	PageManager manager;
	SearchHotelPage searchHotelPage;
	String path = "C:\\Users\\Lenovo\\eclipse-workspace\\" 
	+ "NovAdvFramework\\src\\test\\resources\\Data.xlsx";
	SoftAssert softAssert;
	
	
	@BeforeClass
	public void tearUp() {
		browseLaunch("edge");
		maximizeWindow();
		
	}
	
	@BeforeMethod
	public void url() {
		loadUrl("https://adactinhotelapp.com/");
		manager = new PageManager();
		softAssert = new SoftAssert();
	}

	@Test(priority = 1 , dataProvider = "Login Data" )
	public void userLogin(Object userName,Object password) {
		LoginPage loginPage = manager.getLoginPage();
		//Assert.assertTrue(false);
		//softAssert.assertTrue(false);
		try {
			passValue(loginPage.getUserName(), userName.toString());
			passValue(loginPage.getPassword(),password.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		elementClick(loginPage.getLoginButton());
		searchHotelPage = manager.getSearchHotelPage();	
		String actual = getAttributeValue(searchHotelPage.getUser(), "value");
		//Assert.assertEquals(actual, "Hello sathishgreens123!", "User is on wrong Page");
		softAssert.assertEquals(actual, "Hello sathishgreens123!", "User is on wrong Page");
	}
	@Test(priority = 2 , enabled = false)
	public void searchHotel() throws IOException {
				
		dropDown(searchHotelPage.getLocation(), "text", 
				excelRead(path, "Search Hotel Data", 1, 0));
		//Assert.assertFalse(true);
		//softAssert.assertFalse(true);
		dropDown(searchHotelPage.getHotels(), "text", 
				excelRead(path, "Search Hotel Data", 1, 1));
		
		dropDown(searchHotelPage.getRoomType(), "text", 
				excelRead(path, "Search Hotel Data", 1, 2));
		elementClick(searchHotelPage.getSearchButton());
		String actual = pageTitle(driver);
		//Assert.assertEquals(actual, "Adactin.com - Select Hotel","Page is not Loaded");
		//softAssert.assertEquals(actual, "Actin.com - Select Hotel","Page is not Loaded");

	}
	@AfterClass
	public void tearDown() {
		closeBrowser();
		softAssert.assertAll();
		
	}
	
	@DataProvider(name = "Login Data")
	public Object[][] data() {			 
		return new Object[][] {
			{"sathishgreens123","Greens@123"},
			{"sathish123",123},
			{"sathishgreens12",7777}
		};
	}
	

}
