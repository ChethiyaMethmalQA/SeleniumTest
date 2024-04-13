package com.tests.testcases;

import com.pageclass.LoginPage;
import com.tests.util.Config;
import com.tests.util.Constant;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginWithEmptyFieldTest extends BaseTest{

    @Test
    @Parameters({"userName","password"})
    public void LoginWithoutCredentials(String userName,String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage(Config.getTestProperty(Constant.LOGIN_URL),Config.getTestProperty(Constant.PAGE_WAIT_TIME));
        loginPage.enterUserDetails(userName,password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.captureErrorMessage(Config.getTestProperty(Constant.ELEMENT_WAIT_TIME)),"Enter Username & password");


    }



}
