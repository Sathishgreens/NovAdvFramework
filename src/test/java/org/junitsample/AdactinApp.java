package org.junitsample;

import org.adactinpages.LoginPage;
import org.adactinpages.PageManager;
import org.adactinpages.SearchHotelPage;
import org.adactinpages.SelectHotelPage;
import org.base.BaseClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


//ListIterator
public class AdactinApp extends BaseClass{
	static PageManager pageManager;
	SearchHotelPage searchHotelPage;
	LoginPage loginPage;
	SelectHotelPage selectHotelPage;
	@BeforeClass
	public static void tearUpClass() {
		browseLaunch("chrome");
		maximizeWindow();
		pageManager = new PageManager();
		loadUrl("https://adactinhotelapp.com/");
		
	}
	
	@Test
	public void tc1() {
		
		loginPage = pageManager.getLoginPage();
		passValue(loginPage.getUserName(), "sathishgreens123");
		passValue(loginPage.getPassword(), "Greens@123");
		elementClick(loginPage.getLoginButton());
		
		searchHotelPage = pageManager.getSearchHotelPage();
		String expected = "Hello sathishgreens123!";
		String actual = getAttributeValue(searchHotelPage.getUser(),"value");
		Assert.assertEquals(actual, expected);
		System.out.println("User Has been Successfully Logged in");
		
	}
	
	@Test
	public void tc2() {
		
		dropDown(searchHotelPage.getLocation(), "value", "Brisbane");
		dropDown(searchHotelPage.getHotels(), "text", "Hotel Hervey");
		dropDown(searchHotelPage.getRoomType(), "index", "1");
		elementClick(searchHotelPage.getSearchButton());
		selectHotelPage = pageManager.getSelectHotelPage();
		
		
	}
	

}
