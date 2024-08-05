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

public class BookHotelPage extends BaseClass{
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement checkBHotelPage;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	@FindBy(id="last_name")
	private WebElement lastname;
	@FindBy(id="address")
	private WebElement address;
	@FindBy(id="cc_num")
	private WebElement ccNumber;
	@FindBy(id="cc_type")
	private WebElement ccType;
	@FindBy(id="cc_exp_month")
	private WebElement expMonth;
	@FindBy(id="cc_exp_year")
	private WebElement expYear;
	@FindBy(id="cc_cvv")
	private WebElement cvv;
	@FindBy(id="book_now")
	private WebElement bookNowButton;
	
	public WebElement getCheckBHotelPage() {
		return checkBHotelPage;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCcNumber() {
		return ccNumber;
	}
	public WebElement getCcType() {
		return ccType;
	}
	public WebElement getExpMonth() {
		return expMonth;
	}
	public WebElement getExpYear() {
		return expYear;
	}
	public WebElement getCvv() {
		return cvv;
	}
	public WebElement getBookNowButton() {
		return bookNowButton;
	}
	
		public String selectBookSHeet(int rownum, int cellnum) throws IOException {

		// To locate File
		File file = new File(
				"C:\\Users\\Mani Bolster\\eclipse-workspace\\AdactinApplication\\Database\\adactin.xlsx");

		FileInputStream fileInputStream = new FileInputStream(file); // throws FileNotFoundException

		// To Define Workbook
		Workbook workbook = new XSSFWorkbook(fileInputStream); // throws IOException

		// To get sheet from workbook
		Sheet sheet = workbook.getSheet("bookhotel");

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
