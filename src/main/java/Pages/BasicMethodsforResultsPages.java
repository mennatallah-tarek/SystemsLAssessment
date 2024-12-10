package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasicMethodsforResultsPages {

        protected WebDriver driver;
    private By nextPageButton = By.xpath("//*[@id=\"pnnext\"]/span[2]");
    private By SearchResults = By.cssSelector("div.VwiC3b");

    public BasicMethodsforResultsPages(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement nextPage() {
        return driver.findElement(nextPageButton);
    }
    public void scrollToBottom() {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public List<WebElement> searchResults() {
        return driver.findElements(SearchResults);
    }
    public int getResultCount() {;
        return searchResults().size();
    }



}
