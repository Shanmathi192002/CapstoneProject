package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import config.ConfigReader;

public class LoginPage {
    private WebDriver driver;
    private ConfigReader config = new ConfigReader();

    private By usernameField = By.id("ctl00_phBody_SignIn_txtEmail");
    private By passwordField = By.id("ctl00_phBody_SignIn_txtPassword");
    private By loginButton = By.id("ctl00_phBody_SignIn_btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLogin() {
        driver.get(config.getProperty("login_url"));
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
