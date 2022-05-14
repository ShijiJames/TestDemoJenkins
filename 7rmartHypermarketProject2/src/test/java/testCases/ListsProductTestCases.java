package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePageRepo;
import elementRepository.ListsProductRepo;
import elementRepository.LoginPageRepo;

public class ListsProductTestCases extends BaseClass {
	ListsProductRepo plObj;
	LoginPageRepo lpObj;
	HomePageRepo hpObj;
	SoftAssert softAssert;

	@Test(groups = { "sanity" }, enabled = true)
	public void isNonVegRadiobtnClicked() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		plObj = new ListsProductRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageProduct();
		plObj.clickAddNewProduct();
		Boolean actualStatus = plObj.clickRadioNonveg();
		softAssert.assertEquals(actualStatus, Boolean.TRUE);
		softAssert.assertAll();

	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyStatusChangeOnClick() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		plObj = new ListsProductRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageProduct();
		String actualMsg = plObj.changeTheStatus();
		softAssert.assertEquals(actualMsg, "Product Status Changed Successfully", "Status is not changed");
		softAssert.assertAll();

	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifySelectingCategoryDropDown() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		plObj = new ListsProductRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageProduct();
		plObj.clickAddNewProduct();
		String actualItem = plObj.clickCategory();
		softAssert.assertEquals(actualItem, "Fruits & Vegetables", "Not able to select from Category Dropdown");
		softAssert.assertAll();

	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifySearchProductWithUniqueId() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		plObj = new ListsProductRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageProduct();
		int actualRowState = plObj.clickSearchProduct();
		softAssert.assertEquals(actualRowState, 1, "There is no unique product with given ID");
		softAssert.assertAll();

	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyEditAndUpdateFromTable() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		plObj = new ListsProductRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageProduct();
		String actualMsg = plObj.editAndUpdateFromTable();
		softAssert.assertEquals(actualMsg, "Product Updated Successfully",
				"Editing and updating from table is not working");
		softAssert.assertAll();

	}

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyDeleteFromTable() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		plObj = new ListsProductRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageProduct();
		String actualMsg = plObj.deletingFromTable();
		softAssert.assertEquals(actualMsg, "Product Deleted Successfully", "Deleting from table is not working");
		softAssert.assertAll();

	}
}
