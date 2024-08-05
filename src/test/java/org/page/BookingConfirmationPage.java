package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationPage extends BaseClass{

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement checkBConfirmText;
	
	public WebElement getCheckBConfirmText() {
		return checkBConfirmText;
	}

	@FindBy(id="my_itinerary")
	private WebElement clickMyItinerary;
	
	public WebElement getClickMyItinerary() {
		return clickMyItinerary;
	}

}
