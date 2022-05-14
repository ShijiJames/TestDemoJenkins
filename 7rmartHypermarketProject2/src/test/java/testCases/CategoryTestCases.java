package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.CategoryPageRepo;
import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class CategoryTestCases extends BaseClass {
	LoginPageRepo lpObj;
	HomePageRepo hpObj;
	CategoryPageRepo cpObj;
	SoftAssert softAssert;

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyDeleteIconColor() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		cpObj = new CategoryPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToCategory();
		String actualResult = cpObj.deleteIconColor();
		softAssert.assertEquals(actualResult, "rgba(255, 255, 255, 1)", "Color of delete icon is not as expected");
		softAssert.assertAll();

	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifySelectedItemMovesOnClick() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		cpObj = new CategoryPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToCategory();
		Boolean actualresult = cpObj.moveSelectGroup();
		softAssert.assertSame(actualresult, Boolean.FALSE, "selected item is not moved");
		softAssert.assertAll();

	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyEditIconBkClr() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		cpObj = new CategoryPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToCategory();
		String actualresult = cpObj.editIconBkClr();
		softAssert.assertEquals(actualresult, "rgba(0, 123, 255, 1)",
				"Background color of edit icon is not as expected");
		softAssert.assertAll();

	}
}
