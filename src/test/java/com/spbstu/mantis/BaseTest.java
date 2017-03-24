package com.spbstu.mantis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by luck on 24.03.17.
 */
public class BaseTest {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        //driver.navigate().to("http://www.google.com");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    /*@AfterSuite
    public void afterSuite(){
        driver.close();
    }*/
}
