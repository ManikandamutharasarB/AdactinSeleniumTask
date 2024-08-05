package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinFinalPage extends BaseClass{
	
	public AdactinFinalPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='You have successfully logged out. ']")
	private WebElement checkLoggedOutText;

	public WebElement getCheckLoggedOutText() {
		return checkLoggedOutText;
	}
	
	@FindBy(xpath="//a[text()='Click here to login again']")
	private WebElement loginPage;

	public WebElement getLoginPage() {
		return loginPage;
	}
}
