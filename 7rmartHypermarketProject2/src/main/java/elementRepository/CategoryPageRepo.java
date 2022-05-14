package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class CategoryPageRepo {

	private WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWait wait;

	public CategoryPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[@id='1-selectable']")
	private WebElement firstSelectFirstItem;

	@FindBy(xpath = "//a[normalize-space(text())='New']")
	private WebElement addNewCategory;

	@FindBy(xpath = "//li[@id='1-selection']")
	private WebElement secondSelectFirstItem;

	@FindBy(xpath = "//tbody/tr[1]//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement editIconOntable;

	@FindBy(xpath = "//tbody/tr[1]//a[@class=\"btn btn-sm btn btn-danger btncss\"]")
	private WebElement deleteIconOnTable;

	public String deleteIconColor() {
		String clr = guObj.getElementCssValue(deleteIconOnTable, "color");
		return clr;
	}

	public boolean moveSelectGroup() {
		guObj.clickTheElement(addNewCategory);
		String bStyleSecondEle = guObj.getElementAttributeValue(secondSelectFirstItem, "style");
		guObj.clickTheElement(firstSelectFirstItem);
		String aStyleFirstEle = guObj.getElementAttributeValue(firstSelectFirstItem, "style");
		return guObj.isTwoElementValuesEqual(bStyleSecondEle, aStyleFirstEle);

	}

	public String editIconBkClr() {
		String bkClr = guObj.getElementCssValue(editIconOntable, "background-color");
		return bkClr;
	}

}
