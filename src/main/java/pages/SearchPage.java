package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.ConfigReader;
import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private ConfigReader config = new ConfigReader();
    private WebDriverWait wait;
    
    private By searchBox = By.id("inputbar");  
    private By searchButton = By.id("btnTopSearch");  
    private By searchResults = By.xpath("//h1/span");  
    private By priceFilter = By.xpath("//a[contains(@href, \"PR:3\")]");
    private By discountFilter = By.xpath("//a[contains(@href, \"Discount:9\")]");
    private By languageFilter = By.xpath("//a[contains(@href, \"Language:English\")]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit_wait"))));
    }

    public void navigateToSearch() {
        driver.get(config.getProperty("base_url"));
    }

    public void searchForProduct(String productName) {
        WebElement searchInput;
        try {
            searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
            searchInput.sendKeys(productName);
        } catch (StaleElementReferenceException e) {
            searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
            searchInput.sendKeys(productName);
        }

        try {
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchBtn.click();
        } catch (StaleElementReferenceException e) {
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchBtn.click();
        }
    }

    public void applyPriceFilter() {
        WebElement price;
        try {
            price = wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", price);
        } catch (StaleElementReferenceException e) {
            price = wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", price);
        }
        waitFor(5);
    }

    public void applyDiscountFilter() {
        WebElement discount;
        try {
            discount = wait.until(ExpectedConditions.elementToBeClickable(discountFilter));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", discount);
        } catch (StaleElementReferenceException e) {
            discount = wait.until(ExpectedConditions.elementToBeClickable(discountFilter));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", discount);
        }
        waitFor(5);
    }

    public void applyLanguageFilter() {
        WebElement element;
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(languageFilter));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (StaleElementReferenceException e) {
            element = wait.until(ExpectedConditions.elementToBeClickable(languageFilter));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
    }

    public boolean isSearchResultDisplayed() {
        List<WebElement> results = driver.findElements(searchResults);
        return results.size() > 0;
    }

    private void waitFor(int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
            .until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }
}
