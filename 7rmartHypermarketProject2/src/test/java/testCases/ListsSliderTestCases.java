package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;
import elementRepository.ManageSliderRepo;

public class ListsSliderTestCases extends BaseClass {
	LoginPageRepo lpObj;
	HomePageRepo hpObj;
	ManageSliderRepo msObj;
	SoftAssert softAssert;

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyAddNewSlider() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		msObj = new ManageSliderRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageSlider();
		String actualMessage = msObj.clickAddNewSlider();
		softAssert.assertEquals(actualMessage, CONSTANT.successAlertCreatedSlider, "Adding new Slider is not working");
		softAssert.assertAll();

	}

	@Test(groups = { "sanity", "smoke" }, enabled = false)
	public void verifyAllColNames() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		msObj = new ManageSliderRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageSlider();
		String[] clnames = (String[]) msObj.columnsNameOfListsSliderTable();
		softAssert.assertEquals(clnames, CONSTANT.sliderColnNames, "Column names are not as expected");
		softAssert.assertAll();

	}

	@Test(groups = { "sanity", "smoke" }, enabled = false)
	public void verifyTagNameForChooseFile() throws Exception {
		hpObj = new HomePageRepo(driver);
		lpObj = new LoginPageRepo(driver);
		msObj = new ManageSliderRepo(driver);
		softAssert = new SoftAssert();
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.goToManageSlider();
		String actualresult = msObj.chooseFileTagname();
		softAssert.assertEquals(actualresult, "input", "TagName of ChooseFile is not as expected");
		softAssert.assertAll();

	}
}
