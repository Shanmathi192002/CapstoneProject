package stepDefinition;

import baseDriver.TestBase;
import io.cucumber.java.en.*;
import pages.ProductPage;
import config.ConfigReader;
import pages.LoginPage;

public class ProductStep {
    private LoginPage loginPage;
    private ProductPage productPage;

    private ConfigReader config;

    public ProductStep() {
        this.loginPage = new LoginPage(TestBase.getDriver());
        this.productPage = new ProductPage(TestBase.getDriver());
        
        this.config = new ConfigReader();
    }

    @Given("User is logged into Bookswagon")
    public void user_is_logged_into_bookswagon() {
        loginPage.navigateToLogin();
        loginPage.enterUsername(config.getProperty("valid_username"));
        loginPage.enterPassword(config.getProperty("valid_password"));
        loginPage.clickLogin();
    }

    @When("User navigates to a product page")
    public void user_navigates_to_a_product_page() {
        TestBase.getDriver().get("https://www.bookswagon.com/search-books/harry-potter/filter?sid=739792"); 
    }

    @When("User clicks on availability")
    public void user_clicks_on_availability() {
        productPage.clickAvailability();
    }

    @When("User clicks on product name")
    public void user_clicks_on_product_name() {
        productPage.clickProductLink();
    }

    @When("User adds the product to cart")
    public void user_adds_the_product_to_cart() {
        productPage.addToCart();
    }
    
    @When("User goes to cart")
    public void user_goes_to_cart() {
        productPage.goToCart();
    }

    @When("User adds product to wishlist")
    public void user_adds_product_to_wishlist() {
        productPage.addToWishlist();
    }


}
