package utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void deleteGivenCookies(WebDriver driver, String cookiesName) {
		driver.manage().deleteCookieNamed(cookiesName);
	}

	public void clearElementText(WebElement element) {
		element.clear();
	}

	public String getElementAttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public String getElementTagname(WebElement element) {
		return element.getTagName();
	}

	public String getElementCssValue(WebElement element, String propertyName) {
		return element.getCssValue(propertyName);
	}

	public void clickTheElement(WebElement element) {
		element.click();
	}

	public String getElementVisiblename(WebElement element) {
		return element.getAccessibleName();
	}

	public void clickElementUsingJS(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public String getTitleOfCurrentPage(WebDriver driver) {
		return driver.getTitle();

	}

	public void uploadFileFirstMethod(WebElement element, String filename) {
		element.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\Images\\" + filename);
	}

	public Boolean isElementSelected(WebElement element) {
		Boolean result = element.isSelected();
		return result;
	}

	public void writeOnElement(WebElement element, String s) {
		element.sendKeys(s);
	}

	public String splitAndTrimAlertMsg(String msg, String exp, int index) {
		String cleanMsg = msg.split(exp)[index].trim();
		return cleanMsg;
	}

	public boolean isTwoElementValuesEqual(String s1, String s2) {
		boolean result = true;
		if (s1.equals(s2)) {
			result = false;
		}
		return result;
	}

	public String[] columnsName(List<WebElement> element) {
		String[] colnames = new String[element.size()];
		for (int i = 0; i < element.size(); i++) {
			String name = element.get(i).getText().trim();
			colnames[i] = name;
		}
		return colnames;
	}

	public int getListSize(List<WebElement> element) {
		return element.size();
	}

	public boolean isElementChecked(WebElement element) {
		return element.isEnabled();
	}

	public boolean isTwoElementValuesEqual(double val1, double val2) {
		boolean result = false;
		if (val1 == val2) {
			result = true;
		}
		return result;
	}

	public String selectDropDownItem(WebElement element, int index) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
		WebElement selectedElement = dropdown.getFirstSelectedOption();
		return selectedElement.getText();
	}
}
