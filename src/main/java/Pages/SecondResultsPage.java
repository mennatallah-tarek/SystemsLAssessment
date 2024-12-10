package Pages;

import org.openqa.selenium.WebDriver;


public class SecondResultsPage extends BasicMethodsforResultsPages {
    private WebDriver driver;


    public SecondResultsPage(WebDriver driver) {
        super(driver);
        }

        public ThirdResultsPage GoTOThirdResultsPage() {
            nextPage().click();
            return new ThirdResultsPage(driver);
        }

    }

