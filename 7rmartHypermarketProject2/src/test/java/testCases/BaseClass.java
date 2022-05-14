package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShot;

public class BaseClass {
	WebDriver driver;
	ScreenShot ssObj;
	public static Properties property;

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void beforeMethod(String Browser) throws IOException {
		basics();
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty(property.getProperty("CHROMEDRIVER"),
					System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("Edge")) {
			System.setProperty(property.getProperty("EDGEDRIVER"),
					System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.get(property.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void basics() throws IOException {
		property = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties");
		property.load(fis);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ssObj = new ScreenShot();
			ssObj.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
