package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;
import elementRepository.ManageExpensesRepo;

public class ManageExpensesTestCases extends BaseClass {
	LoginPageRepo lpObj;
	HomePageRepo hpObj;
	ManageExpensesRepo meObj;
	SoftAssert softAssert;

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyCalenderDateSelection() throws Exception {
		lpObj = new LoginPageRepo(driver);
		hpObj = new HomePageRepo(driver);
		meObj = new ManageExpensesRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageExpense();
		String actualDate = meObj.selectCalendarDate("Dec", "21");
		softAssert.assertEquals(actualDate, "21-12-2022", "Date selected by calendar is not as expected");
		softAssert.assertAll();
	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyAddNewExpense() throws Exception {
		lpObj = new LoginPageRepo(driver);
		hpObj = new HomePageRepo(driver);
		meObj = new ManageExpensesRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageExpense();
		String actualMessage = meObj.clickAddNewExpense();
		softAssert.assertEquals(actualMessage, "Expense Record Created Successfully",
				"Adding new expense is not working");
		softAssert.assertAll();
	}

	@Test(groups = { "sanity" }, enabled = true)
	public void verifyDuplicationOfExpenseCategory() throws Exception {
		lpObj = new LoginPageRepo(driver);
		hpObj = new HomePageRepo(driver);
		meObj = new ManageExpensesRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.clickOnRightSideManageExp();
		String actualMessage = meObj.addNewExpenseCategory();
		softAssert.assertEquals(actualMessage, "Category already exists.", "Adding duplicate expense category");
		softAssert.assertAll();
	}
}
