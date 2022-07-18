package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    By myAccountHeaderBy = By.xpath("//*[@id='center_column']/h1");

       public MyAccountPage verifyLogin(String expectedText){
        String pageTitle = readText(myAccountHeaderBy);
        assertStringEquals(pageTitle, expectedText);
        return this;
    }
}
