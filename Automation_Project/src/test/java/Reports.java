import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Reports {
    public static ExtentSparkReporter extentSparkReporter ;
     public static ExtentReports extentReports ;
     public static ExtentTest extentTest ;


        @Test
    public void testReports() throws IOException {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./report/FlipkartAutomation.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter((ExtentReporter) reporter);
        ExtentTest logger = extent.createTest("LoginTest");
        logger.log(Status.INFO,"iphone");
        logger.log(Status.PASS,"iphone pro max 12");
        extent.flush();
        ExtentTest logger2 = extent.createTest("Logoff Test");
        //logger.log(Status.INFO,"iphone");
        logger2.log(Status.FAIL,"iphone pro max 12 not found");
        logger2.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath("D:/Anitha/Automation_Project/report/screenshot.png/").build());
        extent.flush();

        System.out.println("Flipkart");
    }



}




