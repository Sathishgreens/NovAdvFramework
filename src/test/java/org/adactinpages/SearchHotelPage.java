package org.adactinpages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass {
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username_show")
	private WebElement user;

	@FindBy(id="location")
	private WebElement location;

	@FindBy(id="hotels")
	private WebElement hotels;

	@FindBy(id="room_type")
	private WebElement roomType;

	@FindBy(id="Submit")
	private WebElement searchButton;
	
	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getUser() {
		return user;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}

	
}
