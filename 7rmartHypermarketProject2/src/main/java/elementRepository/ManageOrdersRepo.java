package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageOrdersRepo {
	private WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWait wait;

	public ManageOrdersRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//tbody/tr[1]//a[contains(text(),'View')]")
	private WebElement view;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr/td[6]")
	private List<WebElement> tableSubTotal;

	@FindBy(xpath = "//table[@class='table']/tbody/tr[2]/td")
	private WebElement deliveryCharge;

	@FindBy(xpath = "//table[@class='table']/tbody/tr[3]/td")
	private WebElement grantTotal;

	@FindBy(xpath = "//a[@onclick='javascript:window.print();']")
	private WebElement printBtn;

	@FindBy(xpath = "//div[@id='maskedImage']")
	private WebElement printScrEle;

	@FindBy(xpath = "//div[@id='mymodal1389']//select[@id='status']")
	private WebElement updateStatusSelect;

	@FindBy(xpath = "//tbody/tr[1]//a[text()='Change Status']")
	private WebElement changeStatus;

	public void clickOnView() {
		guObj.clickTheElement(view);
	}

	public boolean addTotalAmount() {
		int rowCount = guObj.getListSize(tableSubTotal);
		double sum = 0.0;
		for (int i = 0; i < rowCount; i++) {
			String value = guObj.getElementText(tableSubTotal.get(i));
			String s = guObj.splitAndTrimAlertMsg(value, " ", 1);
			s = guObj.splitAndTrimAlertMsg(s, "U", 0);
			double valueDouble = Double.parseDouble(s);
			sum = sum + valueDouble;
		}
		String delCrg = guObj.getElementText(deliveryCharge);
		delCrg = guObj.splitAndTrimAlertMsg(delCrg, " ", 1);
		double doubleDelCrg = Double.parseDouble(delCrg);
		double totalSumval = sum + doubleDelCrg;

		String grtTot = guObj.getElementText(grantTotal);
		grtTot = guObj.splitAndTrimAlertMsg(grtTot, " ", 1);
		double doubleActualGrtTot = Double.parseDouble(grtTot);
		return guObj.isTwoElementValuesEqual(doubleActualGrtTot, totalSumval);
	}

}
