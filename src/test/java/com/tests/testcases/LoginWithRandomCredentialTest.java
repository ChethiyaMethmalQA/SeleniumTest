package com.tests.testcases;

import com.aventstack.extentreports.Status;
import com.pageclass.LoginPage;
import com.tests.util.Config;
import com.tests.util.Constant;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginWithRandomCredentialTest extends BaseTest{

    @Test
    @Parameters({"userName","password"})
    public void LoginWithRandomCredentials(String userName,String password){

        LoginPage loginPage = new LoginPage(driver);
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName,"Login with entering random values");
        test.log(Status.INFO,"Navigate to login page and try to enter random values");
        loginPage.navigateToLoginPage(Config.getTestProperty(Constant.LOGIN_URL),Config.getTestProperty(Constant.PAGE_WAIT_TIME));
        loginPage.enterUserDetails(userName,password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.captureErrorMessage(Config.getTestProperty(Constant.ELEMENT_WAIT_TIME)),"Invalid username and password");

    }

}
