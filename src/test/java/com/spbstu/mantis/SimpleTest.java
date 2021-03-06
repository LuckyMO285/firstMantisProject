package com.spbstu.mantis;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by luck on 24.03.17.
 */
public class SimpleTest extends BaseTest{

    @Test
    public void test1(){
        driver.navigate().to("http://127.0.0.1/mantisbt");

        //check in to http://127.0.0.1/mantisbt
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("administrator");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("root" + Keys.ENTER);

        //create issue and write summary with descriptions
        WebElement leftReportIssue = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a/i"));
        leftReportIssue.click();

        WebElement summary = driver.findElement(By.xpath("//*[@id=\"summary\"]"));
        summary.sendKeys("SoHelpMeGod");
        WebElement description = driver.findElement(By.xpath("//*[@id=\"description\"]"));
        description.sendKeys("Yeah! I managed to do this!");

        WebElement submitIssue = driver.findElement(By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input"));
        submitIssue.click();

        //click "View Issues" to check summary, which I created
        WebElement viewIssues = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/i"));
        viewIssues.click();

        List<WebElement> checkSummary = driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[11]"));
        int i = 0;
        boolean exitFromCycle = true;
        while (exitFromCycle && i < checkSummary.size()){
            if (checkSummary.get(i).getText().equals("SoHelpMeGod")){
                Assert.assertTrue(true);
                exitFromCycle = false;
            }
            i++;
        }

        //click on ID
        WebElement pressID = driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr["+i+"]/td[4]/a"));
        pressID.click();

        //click "Delete"
        WebElement pressDelete = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[10]/form/fieldset/input[4]"));
        pressDelete.click();

        //click "Delete Issues"
        WebElement pressDeleteIssues = driver.findElement(By.xpath("//*[@id=\"action-group-div\"]/form/div/div[2]/div[2]/input"));
        pressDeleteIssues.click();

        //check that element was deleted
        try{
            List<WebElement> checkSummary2 = driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[11]"));
            i = 0;
            exitFromCycle = true;
            while (exitFromCycle && i < checkSummary2.size()){
                if (checkSummary2.get(i).getText().equals("SoHelpMeGod")){
                    Assert.assertTrue(false);
                    exitFromCycle = false;
                }
                i++;
            }
        }catch (NoSuchElementException ignored) {
            Assert.assertTrue(true);
        }

    }

}
