package stepDefinition;

import config.ConfigReader;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import pages.LoginPage;
import baseDriver.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginStep {
    private WebDriver driver;
    private LoginPage loginPage;
    private ConfigReader config;

    @Before
    public void setup() {
        driver = TestBase.getDriver();
        loginPage = new LoginPage(driver);
        config = new ConfigReader();
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.navigateToLogin();
    }

    @When("User enters invalid credentials")
    public void user_enters_invalid_credentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_phBody_SignIn_txtEmail")));
        loginPage.enterUsername(config.getProperty("invalid_username"));
        loginPage.enterPassword(config.getProperty("invalid_password"));
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_phBody_SignIn_txtEmail")));
        loginPage.enterUsername(config.getProperty("valid_username"));
        loginPage.enterPassword(config.getProperty("valid_password"));
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        Assert.assertTrue(driver.getPageSource().contains("Invalid Login"));
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String expectedUrl = "https://www.bookswagon.com/myaccount";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

}

