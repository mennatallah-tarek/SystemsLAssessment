package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGenerator {

        private static ExtentReports extent;

        public static ExtentReports getInstance() {
            if (extent == null) {

                String reportPath = System.getProperty("Desktop/Assessment/GoogleSearch/") + "/test-output/ExtentReport.html";
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
                sparkReporter.config().setDocumentTitle("Automation Test Report");
                sparkReporter.config().setReportName("Test Execution Report");
                sparkReporter.config().setTheme(Theme.STANDARD);

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
                extent.setSystemInfo("OS", System.getProperty("os.name"));
                extent.setSystemInfo("User", System.getProperty("user.name"));
                extent.attachReporter(sparkReporter);
                sparkReporter.config().setEncoding("UTF-8");

            }
            return extent;
        }
    }


