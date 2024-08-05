package org.page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.global.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Search Hotel ']")
	private WebElement searchHotelText;
	
	public WebElement getSearchHotelText() {
		return searchHotelText;
	}
	
	@FindBy(id="location")
	private WebElement selectLocation;
	@FindBy(id="hotels")
	private WebElement selectHotel;
	@FindBy(id="room_type")
	private WebElement roomType;
	@FindBy(id="room_nos")
	private WebElement noOfRooms;
	@FindBy(id="datepick_in")
	private WebElement checkIn;
	@FindBy(id="datepick_out")
	private WebElement checkOut;
	@FindBy(id="adult_room")
	private WebElement adultRoom;
	@FindBy(id="child_room")
	private WebElement childRoom;
	@FindBy(id="Submit")
	private WebElement searchHotelButton;

	public WebElement getSelectLocation() {
		return selectLocation;
	}
	public WebElement getSelectHotel() {
		return selectHotel;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getNoOfRooms() {
		return noOfRooms;
	}
	public WebElement getCheckIn() {
		return checkIn;
	}
	public WebElement getCheckOut() {
		return checkOut;
	}
	public WebElement getAdultRoom() {
		return adultRoom;
	}
	public WebElement getChildRoom() {
		return childRoom;
	}
	public WebElement getSearchHotelButton() {
		return searchHotelButton;
	}
	
	public String selectHotelSHeet(int rownum, int cellnum) throws IOException {

		// To locate File
		File file = new File(
				"C:\\Users\\Mani Bolster\\eclipse-workspace\\AdactinApplication\\Database\\adactin.xlsx");

		FileInputStream fileInputStream = new FileInputStream(file); // throws FileNotFoundException

		// To Define Workbook
		Workbook workbook = new XSSFWorkbook(fileInputStream); // throws IOException

		// To get sheet from workbook
		Sheet sheet = workbook.getSheet("searchhotel");

		// To get Row from sheet
		Row row = sheet.getRow(rownum);

		// To get Cell from Row
		Cell cell = row.getCell(cellnum);

		// To Find Cell Type
		CellType cellType = cell.getCellType();

		String value = null;

		switch (cellType) {
		case STRING:

			value = cell.getStringCellValue();

			break;

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				value = simpleDateFormat.format(dateCellValue);

			} else {

				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				value = valueOf.toString();

			}

			break;

		default:
			break;
		}

		return value;

	}


}