package tests;

import org.junit.Test;

import pages.MyAccountPage;
import pages.LoginPage;
public class LoginTests extends BaseTest{
    
    public LoginPage loginPage; 
    public MyAccountPage homePage;

    String myAccountHeader = "MY ACCOUNT";
    String invalidEmailError = "Authentication failed.";
    String noEmailError = "An email address required.";
    String noPasswordError = "Password is required.";

    @Test
    public void validLoginTest() {
        loginPage = new LoginPage(driver);
        homePage = new MyAccountPage(driver);


        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.verifyLogin(myAccountHeader);

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    public void invalidEmail() {
        loginPage = new LoginPage(driver);
        
        loginPage.basePage();
        loginPage.login(invalidEmail, validPassword);
        loginPage.unsuccessfulLogin(invalidEmailError);
    }

    @Test
    public void noEmailcheck() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login("", validPassword);
        loginPage.unsuccessfulLogin(noEmailError);
    }

    @Test
    public void noPasswordcheck() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, "");
        loginPage.unsuccessfulLogin(noPasswordError);
    }

}