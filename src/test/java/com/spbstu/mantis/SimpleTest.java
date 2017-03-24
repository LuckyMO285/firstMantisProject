package com.spbstu.mantis;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Created by luck on 24.03.17.
 */
public class SimpleTest extends BaseTest{

    @Test
    public void test1(){
        driver.navigate().to("http://127.0.0.1/mantisbt");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("administrator");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("root" + Keys.ENTER);

        WebElement leftReportIssue = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a/i"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", leftReportIssue);

        WebElement summary = driver.findElement(By.xpath("//*[@id=\"summary\"]"));
        summary.sendKeys("SoHelpMeGod");
        WebElement description = driver.findElement(By.xpath("//*[@id=\"description\"]"));
        description.sendKeys("Yeah! I managed to do this!");

        WebElement submitIssue = driver.findElement(By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input"));
        executor.executeScript("arguments[0].click();", submitIssue);

    }

}
