package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;
import elementRepository.ManagePaymentMethodRepo;

public class PaymentMethodTestCases extends BaseClass {
	LoginPageRepo lpObj;
	HomePageRepo hpObj;
	ManagePaymentMethodRepo mpmObj;
	SoftAssert softAssert;

	@Test(groups = { "sanity" }, enabled = false)
	public void verifyPaymentLimitsOfUPI() throws Exception {
		lpObj = new LoginPageRepo(driver);
		hpObj = new HomePageRepo(driver);
		softAssert = new SoftAssert();
		mpmObj = new ManagePaymentMethodRepo(driver);
		lpObj.loginToApplication(lpObj.xlStringReadCredentials(1, 0), lpObj.xlStringReadCredentials(1, 1));
		hpObj.clickOnPaymentMethodLink();
		int actualResult = mpmObj.findPaymentlimitOnUPI();
		softAssert.assertEquals(actualResult, CONSTANT.limitOfUPIPayment,
				"limit of UPI payment method is not as expected");
		softAssert.assertAll();

	}
}
