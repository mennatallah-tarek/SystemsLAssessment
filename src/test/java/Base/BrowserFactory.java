package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
    WebDriver driver;

    switch (browser.toLowerCase()) {
        case "chrome":
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
            break;

        case "firefox":
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new FirefoxDriver(firefoxOptions);
            break;

        case "edge":
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
            EdgeOptions edgeOptions = new EdgeOptions();
            driver = new EdgeDriver(edgeOptions);
            break;

        default:
            throw new IllegalArgumentException("Unsupported browser: " + browser);
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
}
}
