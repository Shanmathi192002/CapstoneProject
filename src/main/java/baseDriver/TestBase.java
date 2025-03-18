package baseDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import config.ConfigReader;
import java.time.Duration;

public class TestBase {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ConfigReader config = new ConfigReader();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = config.getProperty("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                case "edge":
                    driver.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(
                Integer.parseInt(config.getProperty("implicit_wait"))
            ));
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
