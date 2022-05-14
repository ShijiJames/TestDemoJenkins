package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ListsProductRepo {
	private WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWait wait;

	public ListsProductRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space(text())='New']")
	private WebElement addNewProduct;

	@FindBy(xpath = "//input[@value='Nonveg']")
	private WebElement radioNonveg;

	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement category;

	@FindBy(xpath = "//tbody/tr[1]/td[7]/a/span")
	private WebElement statusCol;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMsgHolder;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchbtn;

	@FindBy(xpath = "//button[@name='update']")
	private WebElement updateBtn;

	@FindBy(xpath = "//input[@placeholder='Product Code']")
	private WebElement productCode;

	@FindBy(xpath = "//button[@name='Search']")
	private WebElement search;

	@FindBy(xpath = "//tbody/tr")
	private List<WebElement> tableRows;

	@FindBy(xpath = " //tbody/tr[2]/td[9]/a[1]/i[1]")
	private WebElement editIconOnTable;

	@FindBy(xpath = " //input[@name='title']")
	private WebElement titleFieldEditFrm;

	@FindBy(xpath = "//tbody/tr[1]//a[@class='btn btn-sm btn btn-danger btncss']/i[@class='fas fa-trash-alt']")
	private WebElement deleteIconOntable;

	public void clickAddNewProduct() {

		guObj.clickTheElement(addNewProduct);

	}

	public int clickSearchProduct() {
		guObj.clickTheElement(searchbtn);
		guObj.writeOnElement(productCode, "427");
		guObj.clickTheElement(search);
		return guObj.getListSize(tableRows);
	}

	public String editAndUpdateFromTable() throws InterruptedException {
		guObj.clickTheElement(editIconOnTable);
		guObj.clearElementText(titleFieldEditFrm);
		guObj.writeOnElement(titleFieldEditFrm, "Chicken");
		guObj.clickElementUsingJS(driver, updateBtn);
		String msg = guObj.getElementText(alertMsgHolder);
		return guObj.splitAndTrimAlertMsg(msg, "!", 1);
	}

	public String deletingFromTable() {
		guObj.clickTheElement(deleteIconOntable);
		driver.switchTo().alert().accept();
		String msg = guObj.getElementText(alertMsgHolder);
		return guObj.splitAndTrimAlertMsg(msg, "!", 1);
	}

	public String changeTheStatus() {
		guObj.clickTheElement(statusCol);
		String msg = guObj.getElementText(alertMsgHolder);
		return guObj.splitAndTrimAlertMsg(msg, "!", 1);
	}

	public String clickCategory() {
		guObj.clickTheElement(category);
		return guObj.selectDropDownItem(category, 1);
	}

	public Boolean clickRadioNonveg() throws InterruptedException {

		guObj.clickTheElement(radioNonveg);
		return guObj.isElementSelected(radioNonveg);
	}

}
