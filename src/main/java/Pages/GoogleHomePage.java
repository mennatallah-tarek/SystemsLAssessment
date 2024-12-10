package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    private WebDriver driver;

    private By searchBox = By.xpath("//*[@id=\"APjFqb\"]");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement SearchTextField() {
        return driver.findElement(searchBox);
    }


    public FirstResultsPage search(String query) {
        SearchTextField().sendKeys(query);
        SearchTextField().sendKeys(Keys.ENTER);
        return new FirstResultsPage(driver);
    }

}
