package Tests;

import Base.BaseTest;
import Pages.FirstResultsPage;
import Pages.GoogleHomePage;
import Pages.SecondResultsPage;
import Pages.ThirdResultsPage;
import Utility.ReportGenerator;
import Utility.TestDataFromExcel;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static Utility.screenShotGenerator.takeScreenshot;


public class SearchTest extends BaseTest {
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setUpTest() {
        extent = ReportGenerator.getInstance();
        setUp("chrome");
    }

    @Test
    public void testGoogleSearch() {
        test = extent.createTest("Validate Result Counts Between Pages");
        String excelFilePath = "src/test/resources/TestData.xlsx";
        test.info("went to Excel sheet to fetch data");


        Map<String, String> testData = TestDataFromExcel.readExcel(excelFilePath, "Sheet1");
        String SearchQuery = testData.keySet().iterator().next();
        String url = testData.get(SearchQuery);
        test.info("Fetched the data of searched Query and Google URL ");


        driver.get(url);
        test.info("Navigated to Google");

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.search(SearchQuery);
        test.info("Searched for SYSTEMS EGYPT");


        FirstResultsPage firstResultPage = new FirstResultsPage(driver);
        firstResultPage.scrollToBottom();
        test.info("I scrolled down to Bottom Page");

        firstResultPage.GoTOSecondResultPage();
        test.info("Navigated to second results page");

        SecondResultsPage secondResultsPage = new SecondResultsPage(driver);
        secondResultsPage.scrollToBottom();
        test.info("I scrolled down to Bottom Page");

        int resultsCount2ndPage = secondResultsPage.getResultCount();
        secondResultsPage.GoTOThirdResultsPage();
        test.info("Second Page Results Count:  " + resultsCount2ndPage);
        ThirdResultsPage thirdResultsPage = new ThirdResultsPage(driver);
        test.info("Navigated to third results page");
        thirdResultsPage.getResultCount();
        int resultsCount3rdPage = secondResultsPage.getResultCount();
        test.info("third Page Results Count " + resultsCount3rdPage);
        System.out.println("Second Page Results Count: " + resultsCount2ndPage);
        System.out.println("third Page Results Count: " +resultsCount3rdPage);
        if (resultsCount2ndPage == resultsCount3rdPage) {
            test.pass("Result counts match on pages 2 and 3. Results Count = " + resultsCount2ndPage);
        } else {
            String screenshotPath = takeScreenshot(driver, "Mismatch_resultPage2_resultPage3");
            test.fail("Mismatch in result counts", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
            //test.fail(" 2nd results page count: " + resultsCount2ndPage + ", 3rd results page count:  " + resultsCount3rdPage + ". Result counts do not match!");
       // }

        Assert.assertEquals(resultsCount2ndPage,resultsCount3rdPage, "Results of 2nd results Page doesn't equal to Results in 3rd results page");
    }

  @AfterMethod
    public void tearDownTest() {
        tearDown();
      extent.flush();
    }
}
