package org.global;

import java.io.IOException;

import org.global.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.page.AdactinFinalPage;
import org.page.BookHotelPage;
import org.page.BookingConfirmationPage;
import org.page.LoginPage;
import org.page.MyItineraryPage;
import org.page.SearchHotelPage;
import org.page.SelectHotelPage;

import com.github.dockerjava.api.model.Driver;

public class TestScript extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass base = new BaseClass();
		base.getDriver(base.readExcel(0, 1));
		base.launchUrl(base.readExcel(3, 1));
		base.winMax();
		base.screenCapture();

		LoginPage loginPage = new LoginPage();

		WebElement user = loginPage.getUserName();
		base.sendKeysByJava(user, base.readExcel(1, 1));

		WebElement password = loginPage.getPassword();
		base.sendKeysByJS(password, base.readExcel(2, 1));

		WebElement login = loginPage.getLogin();
		base.clickByJS(login);

		//Search Hotel Page
		SearchHotelPage searchHotePage = new SearchHotelPage();
		WebElement searchHotelText = searchHotePage.getSearchHotelText();

		if (searchHotelText.isDisplayed()) {

			base.writeExcel(searchHotelText, 3, 3);

			base.userWriteExcel(searchHotelText, 3, 4, "Adactin Hotel Successfully Logged In");

			WebElement sLocation=searchHotePage.getSelectLocation();
			base.selectByText(sLocation, searchHotePage.selectHotelSHeet(7, 0));
			WebElement selectHotel=searchHotePage.getSelectHotel();
			base.selectByText(selectHotel, searchHotePage.selectHotelSHeet(4, 1));
			WebElement roomType=searchHotePage.getRoomType();
			base.selectByText(roomType, searchHotePage.selectHotelSHeet(3, 2));
			WebElement noOfRooms=searchHotePage.getNoOfRooms();
			base.selectByText(noOfRooms, searchHotePage.selectHotelSHeet(7, 3));
			WebElement checkIn=searchHotePage.getCheckIn();
			base.sendKeysByJava(checkIn, searchHotePage.selectHotelSHeet(1, 6));
			WebElement checkOut=searchHotePage.getCheckOut();
			base.sendKeysByJava(checkOut, searchHotePage.selectHotelSHeet(1, 7));
			WebElement adultRoom=searchHotePage.getAdultRoom();
			base.selectByText(adultRoom, searchHotePage.selectHotelSHeet(2, 4));
			WebElement childRoom=searchHotePage.getChildRoom();
			base.selectByText(childRoom, searchHotePage.selectHotelSHeet(2, 5));
			WebElement searchButton=searchHotePage.getSearchHotelButton();
			base.clickByJava(searchButton);
			
			SelectHotelPage sHotelPage=new SelectHotelPage();
			WebElement selectHotelText = sHotelPage.getSelectHotelText();
			System.out.println(selectHotelText);
			if(selectHotelText.isDisplayed()) {
				WebElement hotelRadioButton=sHotelPage.getHotelRadioButton();
				base.clickByJava(hotelRadioButton);
				WebElement continueButton=sHotelPage.getContinueButtonInSelectHotel();
				base.clickByJava(continueButton);
				
				BookHotelPage bHotelPage=new BookHotelPage();
				WebElement checkBHotelPage = bHotelPage.getCheckBHotelPage();
				if(checkBHotelPage.isDisplayed()) {
					WebElement firstName = bHotelPage.getFirstName();
					base.sendKeysByJava(firstName, bHotelPage.selectBookSHeet(1, 0));
					
					WebElement lastname = bHotelPage.getLastname();
					base.sendKeysByJava(lastname, bHotelPage.selectBookSHeet(1, 1));
					
					WebElement address = bHotelPage.getAddress();
					base.sendKeysByJava(address, bHotelPage.selectBookSHeet(1, 2));
					
					WebElement ccNumber = bHotelPage.getCcNumber();
					base.sendKeysByJava(ccNumber, bHotelPage.selectBookSHeet(1, 3));
					
					WebElement ccType = bHotelPage.getCcType();
					base.selectByText(ccType, bHotelPage.selectBookSHeet(1, 4));
					
					WebElement expMonth = bHotelPage.getExpMonth();
					base.selectByText(expMonth, bHotelPage.selectBookSHeet(1, 5));
					
					WebElement expYear = bHotelPage.getExpYear();
					base.selectByText(expYear, bHotelPage.selectBookSHeet(1, 6));
					
					WebElement cvv = bHotelPage.getCvv();
					base.sendKeysByJava(cvv, bHotelPage.selectBookSHeet(1, 7));
					
					WebElement bookNowButton = bHotelPage.getBookNowButton();
					base.clickByJava(bookNowButton);
					
					BookingConfirmationPage bConfirmPage=new BookingConfirmationPage();
					WebElement checkBConfirmText = bConfirmPage.getCheckBConfirmText();
					base.sleep(10000);
					
					if(checkBConfirmText.isDisplayed()) {
						WebElement clickMyItinerary = bConfirmPage.getClickMyItinerary();
						base.clickByJava(clickMyItinerary);
						
						MyItineraryPage myItineraryPage=new MyItineraryPage();
						WebElement myItineraryText = myItineraryPage.getMyItineraryText();
						if(myItineraryText.isDisplayed()) {
							WebElement getOrderId = myItineraryPage.getGetOrderId();
							String attribute = getOrderId.getAttribute("value");
							System.out.println("The OrderId is "+attribute);
							
							WebElement checkBox = myItineraryPage.getCheckBox();
							base.clickByJava(checkBox);
							
							base.sleep(3000);
							WebElement cancelButton = myItineraryPage.getCancelButton();
							base.clickByJava(cancelButton);
							base.alertMessageMethod();
							
							base.sleep(3000);
							WebElement logoutButton = myItineraryPage.getLogoutButtonInIti();
							base.clickByJava(logoutButton);
							
							AdactinFinalPage adactinFinalPage=new AdactinFinalPage();
							WebElement checkLoggedOutText = adactinFinalPage.getCheckLoggedOutText();
							if(checkLoggedOutText.isDisplayed()) {
								WebElement loginPage2 = adactinFinalPage.getLoginPage();
								base.clickByJava(loginPage2);
							}
							else {
								System.out.println("User is Not in " + checkLoggedOutText.getText() + " Page");
							}
						}
						else {
							System.out.println("User is Not in " + myItineraryText.getText() + " Page");
						}

					}
					else {
						System.out.println("User is Not in " + checkBConfirmText.getText() + " Page");
					}

					
				}
				else {
					System.out.println("User is Not in " + checkBHotelPage.getText() + " Page");
				}


			}
			else {
				System.out.println("User is Not in " + selectHotelText.getText() + " Page");
			}

		} else {
			System.out.println("User is Not in " + searchHotelText.getText() + " Page");
		}

		
	}

}