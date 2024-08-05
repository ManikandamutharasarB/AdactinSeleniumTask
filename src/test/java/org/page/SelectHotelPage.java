package org.page;

import org.global.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass{
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement selectHotelText;
	
	@FindBy(id="radiobutton_0")
	private WebElement hotelRadioButton;
	
	@FindBy(id="continue")
	private WebElement continueButtonInSelectHotel;

	public WebElement getSelectHotelText() {
		return selectHotelText;
	}

	public WebElement getHotelRadioButton() {
		return hotelRadioButton;
	}

	public WebElement getContinueButtonInSelectHotel() {
		return continueButtonInSelectHotel;
	}
	
	
}
