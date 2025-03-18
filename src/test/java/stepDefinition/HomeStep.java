package stepDefinition;

import baseDriver.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;

public class HomeStep {
    WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = TestBase.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        driver.get("https://www.bookswagon.com");
    }

    @Then("Search bar should be displayed")
    public void search_bar_should_be_displayed() {
        Assert.assertTrue(homePage.isSearchBarDisplayed(), "Search bar is not displayed on the home page.");
    }

    @After
    public void tearDown() {
        TestBase.closeDriver();
    }
}
