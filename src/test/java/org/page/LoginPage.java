package org.page;

import org.global.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
      PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}
	
	@FindBy(id="password")
	private WebElement password;
	
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(xpath="//input[@id='login']")
	private WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
	
	@FindBy(xpath="//td[text()='Search Hotel ']")
	private WebElement searchHotelText;
	
	public WebElement getSearchHotelText() {
		return searchHotelText;
	}
	
	
	
	
	
// Annotations @FindBy   = findElement(By)
	
	//	WebElement user = driver.findElement(By.id("username"));
	
}