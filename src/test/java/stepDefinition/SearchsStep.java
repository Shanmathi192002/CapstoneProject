package stepDefinition;

import baseDriver.TestBase;
import config.ConfigReader;
import pages.LoginPage;
import pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class SearchsStep {
    private WebDriver driver;
    private ConfigReader config;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private SoftAssert softAssert;

    @Before
    public void setup() {
        driver = TestBase.getDriver(); 
        config = new ConfigReader();
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        softAssert = new SoftAssert();
    }

    @Given("User is logged into the application")
    public void user_is_logged_into_application() {
        loginPage.navigateToLogin();
        loginPage.enterUsername(config.getProperty("valid_username"));
        loginPage.enterPassword(config.getProperty("valid_password"));
        loginPage.clickLogin();
    }

    @When("User searches for {string}")
    public void user_searches_for_product(String product) {
        searchPage.navigateToSearch();
        searchPage.searchForProduct(product);
    }

    @And("User applies discount filter")
    public void user_applies_discount_filter() {
        searchPage.applyDiscountFilter();
    }

    @And("User applies price filter")
    public void user_applies_price_filter() {
        searchPage.applyPriceFilter();
    }

    @And("User applies language filter")
    public void user_applies_language_filter() {
        searchPage.applyLanguageFilter();
    }

    @Then("Search results should be displayed")
    public void search_results_should_be_displayed() {
        softAssert.assertTrue(searchPage.isSearchResultDisplayed(), "Search results not displayed!");
        softAssert.assertAll();
    }

   
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + scenario.getName() + ".png";
            try {
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                System.out.println("Screenshot saved: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        TestBase.closeDriver(); 
    }
}
