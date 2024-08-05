package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyItineraryPage extends BaseClass{
	public MyItineraryPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Booked Itinerary']")
	private WebElement myItineraryText;

	public WebElement getMyItineraryText() {
		return myItineraryText;
	}
	
	@FindBy(xpath="(//input[@class='select_text'])[1]")
	private WebElement getOrderId;

	public WebElement getGetOrderId() {
		return getOrderId;
	}
	
	@FindBy(xpath="//input[@name='check_all']")
	private WebElement checkBox;

	public WebElement getCheckBox() {
		return checkBox;
	}
	
	@FindBy(xpath="//input[@name='cancelall']")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	@FindBy(xpath="//input[@name='logout']")
	private WebElement logoutButtonInIti;

	public WebElement getLogoutButtonInIti() {
		return logoutButtonInIti;
	}
	
}
