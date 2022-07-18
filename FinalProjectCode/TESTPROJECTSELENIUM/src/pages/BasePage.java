package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void waitVisibility (By elementBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitVisibilityOfAllElements (List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public void click(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
    }
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }
    
    public String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
    public void assertStringEquals (String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public void assertIntegerEquals(int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    public List<WebElement> locateElements( By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy);
    }
    
}