package tests;

import org.junit.Test;

import pages.LoginPage;
import pages.ProductsPage;

public class ProductsPageTests extends BaseTest {

    public LoginPage loginPage;
    public ProductsPage productsPage;

    int numberOfAllItems = 7;

    @Test
    public void checkNumberOfPopularProducts() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        productsPage.basePage();
        productsPage.validateNumberOfPopularProducts(numberOfAllItems);
    }

    @Test
    public void validateBestsellerProducts() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        productsPage.basePage();
        productsPage.openBestseller();
        productsPage.validateNumberOfBestsellerProducts(numberOfAllItems);
    }

}
