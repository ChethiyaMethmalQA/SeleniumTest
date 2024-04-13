package com.tests.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    protected WebDriver driver;
    protected static ExtentSparkReporter sparkReporter;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    public void initReport(){

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Login Test Reports");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        extent =new ExtentReports();
        extent.attachReporter(sparkReporter);

    }

    @BeforeSuite
    public void createReport(){

        initReport();

    }
    @BeforeTest
    public void initBrowser(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }



    @AfterTest
    public void quiteBrowser(){

        driver.quit();

    }

    @AfterSuite
    public void flushReport(){

        extent.flush();

    }
}
