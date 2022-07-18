package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By loginEmailBy = By.xpath("//*[@id='email']");

   
    By loginPasswordBy = By.xpath(" //*[@id='passwd']");
    By loginButtonBy = By.xpath("//*[@id='SubmitLogin']/span");
    By errorMessageBy = By.xpath("//*[@id='center_column']/div[1]/ol/li ");
    String baseURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public LoginPage basePage(){
        driver.get(baseURL);
        return this;
    }

    public LoginPage login (String username, String password){
        writeText(loginEmailBy, username);
        writeText(loginPasswordBy, password);
        click(loginButtonBy);
        return this;
    }

    public void unsuccessfulLogin(String expectedErrorText) {
        String errorText = readText(errorMessageBy);
        assertStringEquals(expectedErrorText, errorText);
    }
}

