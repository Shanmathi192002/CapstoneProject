package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import config.ConfigReader;
import baseDriver.TestBase;

public class CartStep extends TestBase {
    WebDriver driver = getDriver();
    CartPage cartPage = new CartPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    ConfigReader config = new ConfigReader();
    
    @Given("User is logged in and on the homepage")
    public void userLogsIn() {
        loginPage.navigateToLogin();
        loginPage.enterUsername(config.getProperty("valid_username"));
        loginPage.enterPassword(config.getProperty("valid_password"));
        loginPage.clickLogin();
    }

    @Then("User clicks wishlist symbol")
    public void userClicksWishlistSymbol() {
        cartPage.clickWishlistSymbol();
    }

    @Then("User increases the quantity")
    public void userIncreasesQuantity() {
        cartPage.increaseQuantity();
    }

    @Then("User decreases the quantity")
    public void userDecreasesQuantity() {
        cartPage.decreaseQuantity();
    }

    @Then("User adds the product to cart from wishlist")
    public void userAddsToCartFromWishlist() {
        cartPage.addToCart();
    }

    @Then("User clicks cart symbol")
    public void userClicksCartSymbol() {
        cartPage.clickCartSymbol();
    }

    @Then("User clicks Buy button")
    public void userClicksBuyButton() {
        cartPage.clickBuyButton();
    }
}
