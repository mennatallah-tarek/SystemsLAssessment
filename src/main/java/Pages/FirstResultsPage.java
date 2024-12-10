package Pages;

import org.openqa.selenium.WebDriver;

public class FirstResultsPage extends BasicMethodsforResultsPages {
    private WebDriver driver;


    public FirstResultsPage(WebDriver driver) {
        super(driver);    }


    public SecondResultsPage GoTOSecondResultPage() {
        nextPage().click();
       return new SecondResultsPage(driver);
    }

}
