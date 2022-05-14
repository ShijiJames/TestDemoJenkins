package elementRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManagePaymentMethodRepo {
	private WebDriver driver;
	GeneralUtilities guObj;
	ExplicitWait wait;

	public ManagePaymentMethodRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//tbody/tr/td[1]")
	private List<WebElement> rows;

	public int findPaymentlimitOnUPI() {
		guObj = new GeneralUtilities();
		List<String> price = rows.stream().filter(s -> guObj.getElementText(s).contains("UPI"))
				.map(s -> getPriceLimit(s)).collect(Collectors.toList());
		int limit = Integer.parseInt(price.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("")));
		return limit;
	}

	private String getPriceLimit(WebElement s) {
		guObj = new GeneralUtilities();
		return guObj.getElementText(s.findElement(By.xpath("following-sibling::td[1]")));
	}

}
