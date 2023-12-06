package org.adactinpages;

public class PageManager {

	private LoginPage loginPage;
	
	private SearchHotelPage searchHotelPage;
	
	private SelectHotelPage selectHotelPage;

	public SearchHotelPage getSearchHotelPage() {
		if(searchHotelPage==null) {
			searchHotelPage = new SearchHotelPage();
		}
		return searchHotelPage;
	}

	public SelectHotelPage getSelectHotelPage() {
		if(selectHotelPage==null) {
			selectHotelPage = new SelectHotelPage();
		}
		return selectHotelPage;
	}


	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

}
