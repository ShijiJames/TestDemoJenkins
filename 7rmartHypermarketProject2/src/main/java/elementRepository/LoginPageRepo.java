package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPageRepo {
	private WebDriver driver;
	GeneralUtilities guObj;

	public LoginPageRepo(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement butLogin;

	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement alertDiv;

	@FindBy(id = "remember")
	private WebElement remMe;

	public void setUserName(String user) {
		guObj = new GeneralUtilities();
		guObj.writeOnElement(userName, user);
	}

	public void setPassword(String passcode) {
		guObj = new GeneralUtilities();
		guObj.writeOnElement(password, passcode);
	}

	public void clickLogin() {
		guObj = new GeneralUtilities();
		guObj.clickTheElement(butLogin);
	}

	public boolean clickRememberMeOption() {
		guObj = new GeneralUtilities();
		guObj.clickElementUsingJS(driver, remMe);
		return guObj.isElementSelected(remMe);
	}

	public String xlStringReadCredentials(int row, int col) throws IOException {
		return ExcelRead.stringDataRead(row, col);
	}

	public String getAlertMsg() {
		guObj = new GeneralUtilities();
		String text = alertDiv.getText();
		return guObj.splitAndTrimAlertMsg(text, "!", 1);
	}

	public String displayedNameLoginBtn() {
		guObj = new GeneralUtilities();
		return guObj.getElementVisiblename(butLogin);
	}

	public String getLoginButtonText() {
		guObj = new GeneralUtilities();
		return guObj.getElementText(butLogin);
	}

	public void loginToApplication(String user, String passcode) {
		guObj = new GeneralUtilities();
		guObj.writeOnElement(userName, user);
		guObj.writeOnElement(password, passcode);
		guObj.clickTheElement(butLogin);
	}

}
