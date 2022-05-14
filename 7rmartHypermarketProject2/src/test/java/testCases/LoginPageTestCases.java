package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPageRepo;

public class LoginPageTestCases extends BaseClass {
	LoginPageRepo lpObj;
	SoftAssert softAssert;

	@Test(groups = { "regression" }, enabled = false)
	public void verifyLoginButtonText() throws Exception {
		lpObj = new LoginPageRepo(driver);
		String actualResult = lpObj.getLoginButtonText();
		Assert.assertEquals(actualResult, CONSTANT.loginBtnText, "Login Text is not as expected");
	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyInvalidUser() throws Exception {
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.setUserName(lpObj.xlStringReadCredentials(2, 0));
		lpObj.setPassword(lpObj.xlStringReadCredentials(2, 1));
		lpObj.clickLogin();
		String actualAlertMsg = lpObj.getAlertMsg();
		softAssert.assertEquals(actualAlertMsg, CONSTANT.invvalidUserAlertMsg, "Invalid user is permitted");
		softAssert.assertAll();

	}

	@Test(groups = { "sanity" }, enabled = false)
	public void isRememberMeOptionSelected() throws Exception {
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		boolean actualResult = lpObj.clickRememberMeOption();
		softAssert.assertTrue(actualResult, "RememberMe is not clickable");
		softAssert.assertAll();

	}

	@Test(groups = { "regression" }, enabled = false)
	public void verifyDisplayNameLoginBtn() throws Exception {
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		String actualResult = lpObj.displayedNameLoginBtn();
		softAssert.assertEquals(actualResult, CONSTANT.loginBtnText, "Display Name of Login button is not as expected");
		softAssert.assertAll();
	}

}
