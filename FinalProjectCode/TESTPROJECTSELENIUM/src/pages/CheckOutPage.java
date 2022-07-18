package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage{
    
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    By tShirtsCategoryBy = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
    By tShirtsContainerBy = By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
    By addToCartBy= By.xpath("//*[@id='add_to_cart']/button/span");
    By productIncartBy = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2");

    String baseURL = "http://automationpractice.com/index.php?id_category=5&controller=category";


    public CheckOutPage validateProductIsInCart(String expectedText){
        String checkOutCartText = readText(productIncartBy);
        assertStringEquals(checkOutCartText, expectedText);
        return this;
    }
    public CheckOutPage basePage(){
        driver.get(baseURL);
        return this;
    }

    public CheckOutPage openTshirts() {
        click(tShirtsCategoryBy);
        return this;
    }
    public CheckOutPage openTshirtContainer() {
        click(tShirtsContainerBy);
        return this;
    }
    public CheckOutPage addProductToCart() {
        click(addToCartBy);
        return this;
    }
}