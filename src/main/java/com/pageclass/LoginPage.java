package com.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class LoginPage extends BaseClass{

    @FindBy(id = "form-input-live-u")
    private WebElement userName;

    @FindBy(id = "form-input-live-p")
    private WebElement password;

    @FindBy(id = "mat-mdc-checkbox-1-input")
    private WebElement rememberMeBox;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block mb-3']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,\"error_msg\")]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='ps ps--active-y']")
    private WebElement scrollingFrame;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage(String url,String seconds){

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(seconds)));

    }

    public void enterUserDetails(String userName,String password){

        this.userName.sendKeys(userName);
        this.password.sendKeys(password);

    }

    public void clickRememberMeBox(){

        rememberMeBox.click();

    }

    public void clickLoginButton(){

        loginButton.click();

    }

    public String captureErrorMessage(String waitTime)  {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop += 100;", scrollingFrame);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(waitTime)));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));

        return errorMessage.getText();


    }}
