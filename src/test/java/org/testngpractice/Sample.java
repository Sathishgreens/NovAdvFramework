package org.testngpractice;

import org.base.BaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample extends BaseClass{
	@Parameters("browser two")
	@Test()
	public void tc1(String browser) {
		browseLaunch(browser);
		maximizeWindow();
		loadUrl("https://www.amazon.in/");
	}
	
	

}
