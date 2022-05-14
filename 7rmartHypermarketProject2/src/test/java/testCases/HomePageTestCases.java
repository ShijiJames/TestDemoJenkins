package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class HomePageTestCases extends BaseClass {
	HomePageRepo hpObj;
	LoginPageRepo lpObj;
	SoftAssert softAssert;

	@Test(groups = { "regression" }, enabled = false)
	public void verifyLoginUserNameTC() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		String actualUser = hpObj.getLoggedUser();
		softAssert.assertEquals(actualUser, CONSTANT.loggedUser, "Login name is not as expected");
		softAssert.assertAll();
	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifySessionLogout() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		String actualResult = hpObj.deleteSessionCookies();
		Assert.assertEquals(actualResult, CONSTANT.loginTitle, "Session cookie deletion doesn't logout the user");
	}

	@Test(groups = { "regression" }, enabled = false)
	public void verifyManagePagesMoreInfoLink() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		String actualLandingPagetitle = hpObj.goToManagePages();
		softAssert.assertEquals(actualLandingPagetitle, CONSTANT.listPagesTitle,
				"More Info link is not working as expected");
		softAssert.assertAll();
	}

	@Test(groups = { "regression" }, enabled = false)
	public void verifyTotalNumberOfDashboardItems() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		int actualNoItems = hpObj.findTotalDashboardItems();
		softAssert.assertEquals(actualNoItems, CONSTANT.totalDashboardItems, "Dashboard items not as expected");
		softAssert.assertAll();
	}

	@Test(groups = { "regression" }, enabled = false)
	public void verifyTotalNoOfLinksInFooter() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		int actualNumber = hpObj.getTotalLinksInFooter();
		softAssert.assertEquals(actualNumber, CONSTANT.totalFooterLinks,
				"No. of links in footer section doesn't match");
		softAssert.assertAll();
	}

	@Test(groups = { "regression" }, enabled = true)
	public void verifyAllLinksInHomePage() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		int actualWorkingLinks = hpObj.getTotalWorkingLinksInHomepage();
		softAssert.assertEquals(actualWorkingLinks, CONSTANT.totalWorkingDashboardLinks,
				"No. of working links are not as expected");
		softAssert.assertAll();
	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyBrokenLinksInHomePage() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		String brokenLinkText = hpObj.getLinksInRightContainer();
		softAssert.assertTrue(brokenLinkText.isEmpty(), "The link with Text " + brokenLinkText + " is broken");
		softAssert.assertAll();
	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyUserLogout() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		String actualResult = hpObj.logoutUser();
		softAssert.assertEquals(actualResult, CONSTANT.loginTitle, "Logout option doesn't work as expected");
		softAssert.assertAll();
	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyConfirmPasswordChangeForUser() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		softAssert = new SoftAssert();
		lpObj.setUserName(lpObj.xlStringReadCredentials(3, 0));
		lpObj.setPassword(lpObj.xlStringReadCredentials(3, 1));
		lpObj.clickLogin();
		String actualResult = hpObj.settingPasswordChangeForUser();
		softAssert.assertEquals(actualResult, CONSTANT.alertForUnmatchedPassword,
				"Confirm Password is not working as expected");
		softAssert.assertAll();
	}

}
