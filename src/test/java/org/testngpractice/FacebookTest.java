package org.testngpractice;

import org.base.BaseClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class FacebookTest extends BaseClass {
	
	@Parameters({"browser one","user name","password"})
	@Test
	public void tearUp(String browser,String user,String pass) {
		browseLaunch(browser);
		maximizeWindow();
		loadUrl("https://www.facebook.com/");
		passValue(findingElement("id", "email"), user);
		
		
		
	}
}


