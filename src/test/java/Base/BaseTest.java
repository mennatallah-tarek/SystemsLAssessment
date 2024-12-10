package Base;

import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    public void setUp(String browser) {
        driver = BrowserFactory.getDriver(browser);
    }

   public void tearDown() {
       if (driver != null) {
           driver.quit();
        }
    }
}
