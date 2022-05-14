package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;
import elementRepository.ManageOrdersRepo;

public class ManageOrdersTestCases extends BaseClass {
	LoginPageRepo lpObj;
	HomePageRepo hpObj;
	ManageOrdersRepo moObj;
	SoftAssert softAssert;

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyAdditionOnViewTable() throws Exception {
		lpObj = new LoginPageRepo(driver);
		hpObj = new HomePageRepo(driver);
		moObj = new ManageOrdersRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageOrder();
		moObj.clickOnView();
		boolean actualResult = moObj.addTotalAmount();
		softAssert.assertTrue(actualResult, "Grant Total does match with total amount calculated");
		softAssert.assertAll();
	}

}
