package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageExpensesRepo {
	private WebDriver driver;
	GeneralUtilities guObj;
	ExplicitWait wait;

	public ManageExpensesRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space(text())='New']")
	private WebElement addNewExpense;

	@FindBy(id = "user_id")
	private WebElement user;

	@FindBy(id = "ex_date")
	private WebElement expenseDate;

	@FindBy(id = "ex_cat")
	private WebElement category;

	@FindBy(id = "order_id")
	private WebElement orderId;

	@FindBy(id = "purchase_id")
	private WebElement purchaseid;

	@FindBy(id = "ex_type")
	private WebElement expenseType;

	@FindBy(id = "amount")
	private WebElement amount;

	@FindBy(id = "content")
	private WebElement remarks;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement uploadFile;

	@FindBy(xpath = "//button[@name='create']")
	private WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement failureAlert;

	@FindBy(name = "Create")
	private WebElement saveExpTitle;

	@FindBy(className = "day")
	private List<WebElement> dates;

	@FindBy(css = "[class='datepicker-days'] th[class='next']")
	private WebElement nextMonth;

	@FindBy(css = "[class='datepicker-days'] [class='datepicker-switch']")
	private WebElement calMonth;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement titleExp;

	public String addNewExpenseCategory() {
		guObj = new GeneralUtilities();
		guObj.clickTheElement(addNewExpense);
		guObj.writeOnElement(titleExp, "Testing");
		guObj.clickTheElement(saveExpTitle);
		String alertmsg = guObj.getElementText(failureAlert);
		return guObj.splitAndTrimAlertMsg(alertmsg, "!", 1);
	}

	public String selectCalendarDate(String month, String day) {
		guObj = new GeneralUtilities();
		guObj.clickTheElement(addNewExpense);
		guObj.clickTheElement(expenseDate);
		while (!guObj.getElementText(calMonth).contains(month)) {
			guObj.clickTheElement(nextMonth);
		}
		int count = guObj.getListSize(dates);
		for (int i = 0; i < count; i++) {
			String text = guObj.getElementText(dates.get(i));
			if (text.equalsIgnoreCase(day)) {
				guObj.clickTheElement(dates.get(i));
				break;
			}
		}

		return expenseDate.getAttribute("value");
	}

	public String clickAddNewExpense() throws Exception {
		guObj = new GeneralUtilities();
		guObj.clickTheElement(addNewExpense);
		guObj.selectDropDownItem(user, 1);
		guObj.selectDropDownItem(category, 1);
		guObj.selectDropDownItem(orderId, 1);
		guObj.selectDropDownItem(purchaseid, 1);
		guObj.selectDropDownItem(expenseType, 1);
		guObj.writeOnElement(amount, "5000");
		guObj.writeOnElement(remarks, "goods");
		guObj.uploadFileFirstMethod(uploadFile, "doll.png");
		guObj.clickElementUsingJS(driver, save);
		String alertmsg = guObj.getElementText(successAlert);
		return guObj.splitAndTrimAlertMsg(alertmsg, "!", 1);
	}

}
