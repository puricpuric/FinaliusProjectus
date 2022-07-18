package tests;
import org.junit.Test;

import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckOutPageTest extends BaseTest{

    public LoginPage loginPage;
    public ProductsPage productsPage;
    public CheckOutPage checkoutPage;

    String checkOutHeader = "Product successfully added to your shopping cart";

    
    @Test
    public void testIfProductIsInCart() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckOutPage(driver);
    

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        productsPage.basePage();
        checkoutPage.addProductToCart();
        checkoutPage.validateProductIsInCart(checkOutHeader);
    }
    
}