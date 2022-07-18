package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    By popularProductsBy = By.xpath(("//ul[@id='homefeatured']//div[@class='product-container']")); //lista
    By bestsellerProductsBy = By.xpath(("//ul[@id='blockbestsellers']//div[@class='product-container']")); //lista
    By bestsellerTabBy = By.xpath(("//a[@class='blockbestsellers']"));// dugme
    String baseURL = "http://automationpractice.com/index.php?";

    public ProductsPage basePage(){
        driver.get(baseURL);
        return this;
    }


    private ProductsPage validateNumberOfProducts(int expectedNumberOfProducts, By elementBy) {
        int actualNumberOfProducts = locateElements(elementBy).size();
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    public ProductsPage validateNumberOfPopularProducts(int expectedNumberOfProducts) {
        this.validateNumberOfProducts(expectedNumberOfProducts, popularProductsBy);
        return this;
    }

    public ProductsPage validateNumberOfBestsellerProducts(int expectedNumberOfProducts) {
        this.validateNumberOfProducts(expectedNumberOfProducts, bestsellerProductsBy);
        return this;
    }
    public ProductsPage openBestseller() {
        click(bestsellerTabBy);
        return this;
    }
}