package elementRepository;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class HomePageRepo {
	private WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWait wait = new ExplicitWait();

	public HomePageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page' and @class='small-box-footer']")
	private WebElement moreInfoManagePage;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")
	private WebElement moreInfoManageProduct;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider' and @class='small-box-footer']")
	private WebElement moreInfoManageSlider;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	private WebElement moreInfoCategory;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense' and @class='small-box-footer']")
	private WebElement moreInfoManageExpense;

	@FindBy(xpath = "//a[contains(@href,'list-order') and @class='small-box-footer' ]")
	private WebElement moreInfoManageOrder;

	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	private WebElement loggedUser;

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']")
	private WebElement rightSliderContainer;

	@FindBy(xpath = "//div[@class='inner']/p")
	private List<WebElement> dashboardItems;

	@FindBy(xpath = "//ul[@class='navbar-nav ml-auto']/li")
	private WebElement logoutDropdown;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	private WebElement logout;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Settings']")
	private WebElement settings;

	@FindBy(xpath = "//input[@placeholder='Old Password']")
	private WebElement oldPassword;

	@FindBy(xpath = "//input[@placeholder='New Password']")
	private WebElement newPassword;

	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMsg;

	@FindBy(xpath = "//button[normalize-space()='Change']")
	private WebElement changeBtn;

	@FindBy(xpath = "//footer[@class='main-footer text-sm']")
	private WebElement footerDriver;

	@FindBy(xpath = "//div[@class='row']")
	private WebElement linkContainer;

	@FindBy(tagName = "a")
	private List<WebElement> linksInHp;

	@FindBy(xpath = "//p[normalize-space(text())='Manage Expense']//i[@class='fas fa-angle-left right']")
	private WebElement manageExpRightSlider;

	@FindBy(xpath = "//p[text()='Expense Category']")
	private WebElement expenseCategory;

	@FindBy(xpath = "//p[normalize-space()='Manage Payment Methods']")
	private WebElement paymentMethodLink;

	@FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']//li//a")
	private List<WebElement> links;

	public void clickOnPaymentMethodLink() {
		guObj.clickTheElement(paymentMethodLink);
	}

	public String getLoggedUser() {
		return guObj.getElementText(loggedUser);
	}

	public String goToManagePages() throws InterruptedException {
		guObj.clickTheElement(moreInfoManagePage);
		return guObj.getTitleOfCurrentPage(driver);
	}

	public String logoutUser() {
		guObj.clickTheElement(logoutDropdown);
		guObj.clickTheElement(logout);
		return guObj.getTitleOfCurrentPage(driver);
	}

	public String settingPasswordChangeForUser() {
		guObj.clickTheElement(logoutDropdown);
		guObj.clickTheElement(settings);
		guObj.writeOnElement(oldPassword, "admin");
		guObj.writeOnElement(newPassword, "trialpass");
		guObj.writeOnElement(confirmPassword, "trial");
		guObj.clickTheElement(changeBtn);
		String msg = guObj.getElementText(alertMsg);
		return guObj.splitAndTrimAlertMsg(msg, "!", 1);
	}

	public int getTotalWorkingLinksInHomepage() throws InterruptedException {
		int titleCount = 0;
		int linkNo = guObj.getListSize(linkContainer.findElements(By.tagName("a")));
		for (int i = 1; i < linkNo; i++) {

			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			linkContainer.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
		}
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			titleCount++;
		}

		return titleCount;
	}

	public void goToManageProduct() throws InterruptedException {
		guObj.clickTheElement(moreInfoManageProduct);
	}

	public void goToManageOrder() throws InterruptedException {
		guObj.clickTheElement(moreInfoManageOrder);
	}

	public String deleteSessionCookies() {
		guObj.deleteGivenCookies(driver, "ci_session");
		guObj.clickTheElement(moreInfoManagePage);
		return guObj.getTitleOfCurrentPage(driver);
	}

	public void goToCategory() {
		guObj.clickTheElement(moreInfoCategory);
	}

	public void goToManageSlider() throws InterruptedException {
		guObj.clickTheElement(moreInfoManageSlider);
	}

	public void goToManageExpense() {
		guObj.clickElementUsingJS(driver, moreInfoManageExpense);
	}

	public int findTotalDashboardItems() {
		return guObj.getListSize(dashboardItems);
	}

	public void clickOnRightSideManageExp() {
		guObj.clickTheElement(manageExpRightSlider);
		guObj.clickTheElement(expenseCategory);
	}

	public int getTotalLinksInFooter() {
		return guObj.getListSize(footerDriver.findElements(By.tagName("a")));
	}

	public String getLinksInRightContainer() throws Exception {
		String brokenLink = null;
		guObj.clickTheElement(manageExpRightSlider);
		for (WebElement link : links) {
			String url = guObj.getElementAttributeValue(link, "href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.getRequestMethod();
			conn.connect();
			int respCode = conn.getResponseCode();

			if (respCode > 400) {
				brokenLink = guObj.getElementText(link);
			}
		}
		return brokenLink;
	}

}
