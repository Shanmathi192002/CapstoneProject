package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    private By wishlistSymbol = By.id("ctl00_lblWishlistCount");
    private By addQuantity = By.id("add");
    private By removeQuantity = By.id("sub");
    private By addToCartButton = By.id("ctl00_phBody_WishList_lvWishList_ctrl0_btnaddtocart");
    private By cartSymbol = By.id("ctl00_lblTotalCartItems");
    private By buyButton = By.id("ctl00_phBody_BookCart_lvCart_imgPayment");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickWishlistSymbol() {
        wait.until(ExpectedConditions.elementToBeClickable(wishlistSymbol)).click();
    }

    public void increaseQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(addQuantity)).click();
    }

    public void decreaseQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(removeQuantity)).click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void clickCartSymbol() {
        wait.until(ExpectedConditions.elementToBeClickable(cartSymbol)).click();
    }

    public void clickBuyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buyButton)).click();
        
        // Wait until the "Order Summary" heading appears on the next page
        By orderSummaryHeader = By.xpath("//h2[contains(text(),'Order Summary')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderSummaryHeader));

        // Take a screenshot after the new page is fully loaded
        takeScreenshot("OrderConfirmation");
    }

    // Method to take a screenshot
    public void takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
        File destination = new File(filePath);
        
        try {
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot taken: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
