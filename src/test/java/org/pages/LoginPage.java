package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginButton;
	
	
	public WebElement getUserName() {
		return userName;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}



	
	
	

}
