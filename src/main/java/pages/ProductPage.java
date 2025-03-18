package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
    }

    private By availability = By.xpath("//a[contains(text(),'In Stock')]");
    private By productLink = By.xpath("//a[contains(text(),'Harry Potter: Honeydukes Embellished Card')]");
    private By addToCartButton = By.id("btnAddtocart");
    private By cartSuccessMessage = By.id("lblcartmsg_34918271");
    private By goToCartButton = By.id("btnGotocart"); 
    private By addToWishlistButton = By.id("ctl00_phBody_BookCart_lvCart_ctrl0_btnMovetoWishlist"); 

    public void clickAvailability() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(availability));
        element.click();
    }

    public void clickProductLink() {
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(productLink));
        try {
            productElement.click();
        } catch (StaleElementReferenceException e) {
            productElement = wait.until(ExpectedConditions.elementToBeClickable(productLink));
            productElement.click();
        }
    }

    public void addToCart() {
        try {
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            addToCartBtn.click();
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for the 'Add to Cart' button!");
        } catch (Exception e) {
            System.out.println("Unexpected error clicking 'Add to Cart': " + e.getMessage());
        }
    }

    public String getCartSuccessMessage() {
        try {
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartSuccessMessage));
            return messageElement.isDisplayed() ? messageElement.getText() : "Cart message not displayed";
        } catch (TimeoutException e) {
            return "Cart success message did not appear!";
        }
    }
    
    public void goToCart() {
        try {
            WebElement goToCartElement = wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
            goToCartElement.click();
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for the 'Go to Cart' button!");
        } catch (Exception e) {
            
        }
    }

    public void addToWishlist() {
        try {
            WebElement wishlistElement = wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButton));
            wishlistElement.click();
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for the 'Add to Wishlist' button!");
        } catch (Exception e) {
            
        }
    }
}
