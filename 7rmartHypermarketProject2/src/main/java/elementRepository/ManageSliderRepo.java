package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSliderRepo {
	private WebDriver driver;
	GeneralUtilities guObj;

	public ManageSliderRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space(text())='New']")
	private WebElement addNewSlider;

	@FindBy(id = "main_img")
	private WebElement chooseFile;

	@FindBy(xpath = "//input[@placeholder='Link']")
	private WebElement link;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;

	@FindBy(xpath = "//tr/th")
	private List<WebElement> tableColHeadings;

	public String clickAddNewSlider() throws AWTException {
		guObj = new GeneralUtilities();
		guObj.clickTheElement(addNewSlider);
		guObj.uploadFileFirstMethod(chooseFile, "doll.png");
		guObj.writeOnElement(link, "http:help.com");
		guObj.clickTheElement(save);
		String alertmsg = guObj.getElementText(successAlert);
		return guObj.splitAndTrimAlertMsg(alertmsg, "!", 1);
	}

	public String[] columnsNameOfListsSliderTable() {
		guObj = new GeneralUtilities();
		String[] colNames = guObj.columnsName(tableColHeadings);
		return colNames;
	}

	public String chooseFileTagname() {
		guObj = new GeneralUtilities();
		guObj.clickTheElement(addNewSlider);
		return guObj.getElementTagname(chooseFile);
	}

}
