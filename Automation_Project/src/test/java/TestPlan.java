import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    private static void takeScreenshot(String TestcaseID) throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        //get current date time with Date()
        Date date = new Date();

        // Now format the date
        String date1= dateFormat.format(date);

        date1 = date1.replace("/","");
        date1 = date1.replace(" ","");
        date1 = date1.replace(":","");

        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(source, new File("D:\\Anitha\\Automation_Project\\report\\" + TestcaseID + "_" + date1 + ".png"));
    }

   @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

   @Test(testName = "TC1 - Validate Search for item - Positive Scenario")
    public static void submitForm() throws IOException {
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        searchProduct searchProduct = new searchProduct(driver);

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       if (searchProduct.verifyAlertSuccess())
       {
           searchProduct.clickClose();
       }
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       searchProduct.enterSearchText("iphone 12 pro max");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchProduct.enterkeypress();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        if (searchProduct.verifySearchresult())
        {

            takeScreenshot("TC1");
        }
        else {
            takeScreenshot("TC1");
        }
      // Reports.extentTest.log(Status.PASS,"product search ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
    }
    @Test(testName = "TC2- Validate Search for item - Negative Scenario")
    public static void submitFormwrong() throws IOException {
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        searchProduct searchProduct = new searchProduct(driver);
        if (searchProduct.verifyAlertSuccess())
        {
            searchProduct.clickClose();
        }
        searchProduct.enterSearchText("12242453464646464");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchProduct.enterkeypress();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if (searchProduct.verifyNoSearchresult())
        {
            takeScreenshot("TC2");
        }

    }

    @Test(testName = "TC3-Validate Adding item to cart")
    public static void addtocart() throws IOException {
        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        searchProduct searchProduct = new searchProduct (driver);

        searchProduct.ClickLogin();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchProduct.enterusername();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchProduct.enterpassword();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchProduct.confirmLogin();

        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

        searchProduct.clickSearch();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        searchProduct.enterSearchText("iphone");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        searchProduct.enterkeypress();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        if (searchProduct.verifyproductfound())
             {searchProduct.selectproduct();}
        else
            {
               searchProduct.enterSearchText("iPhone");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                searchProduct.enterkeypress();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                searchProduct.selectproduct();
            }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchProduct.writepin("560032");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchProduct.pincheck();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchProduct.addtocartclick();
        takeScreenshot("TC3");
    }
    @Test(testName = "TC4 - Validate remove item to cart")
    public static void removefromcart() throws IOException {
        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        searchProduct searchProduct = new searchProduct (driver);

        searchProduct.ClickLogin();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchProduct.enterusername();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchProduct.enterpassword();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchProduct.confirmLogin();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        searchProduct.clickcart();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        searchProduct.cartremove();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        takeScreenshot("TC4");

        searchProduct.removecartfinal();
    }

    @Test(testName = "TC5 - Verify name of most expensive mobile")
    public static void validatehighpriceitem() throws IOException {
        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        searchProduct searchProduct = new searchProduct(driver);

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
       try
        {
            if (searchProduct.verifyAlertSuccess()) {
                searchProduct.clickClose();
            }
        } catch (NoSuchElementException e) {
            // Code for Handling exception
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        searchProduct.ClickLogin();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchProduct.enterusername();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchProduct.enterpassword();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchProduct.confirmLogin();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        searchProduct.enterSearchText("iphone 12 pro max");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchProduct.enterkeypress();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        searchProduct.clickhightolow();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if(searchProduct.validatehighpriceitem())
        {
            //write report as success
            takeScreenshot("TC5");
        }

        if (searchProduct.verifySearchresult())
        {

            takeScreenshot("TC5");
        }
        else {
            takeScreenshot("TC5");
        }
    }

    @Test(testName = "TC6 - Verify invalid pincode is not added")
    public static void verifypincode() throws IOException {
        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        searchProduct searchProduct = new searchProduct (driver);

        searchProduct.ClickLogin();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        searchProduct.enterusername();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        searchProduct.enterpassword();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        searchProduct.confirmLogin();

        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        searchProduct.clickSearch();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        searchProduct.enterSearchText("iphone");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        searchProduct.enterkeypress();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            searchProduct.selectproduct();
        }
        catch(NoSuchElementException e)
        {
            searchProduct.enterSearchText("iPhone");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            searchProduct.enterkeypress();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            searchProduct.selectproduct();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchProduct.writepin("76975689");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchProduct.pincheck();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        takeScreenshot("TC6");
    }

    @Test(testName = "TC8 - Verify registered office in footer")
    public static void verifyfooterregaddress() throws IOException {
        driver.get(Utils.BASE_URL);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        String regaddress;

        verifyfootersection verifyfootersection  = new verifyfootersection(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        if (verifyfootersection.verifyAlertSuccess()) {
            verifyfootersection.clickClose();
        }

        regaddress = verifyfootersection.getregaddress();
       // System.out.print(regaddress + " printing");
        if (regaddress.contains("CIN : U51109KA2012PTC066107") )
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                takeScreenshot("TC8");}
    }

    @Test(testName = "TC7 - Verify product filter")
    public static void verifyfilterproduct() throws IOException {
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        searchProduct searchProduct = new searchProduct(driver);

        if (searchProduct.verifyAlertSuccess()) {
            searchProduct.clickClose();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        searchProduct.enterSearchText("T-Shirts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchProduct.enterkeypress();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (searchProduct.verifyNoSearchresult()) {
            takeScreenshot("TC7");
        } else {
            takeScreenshot("TC7");
        }
    }

    @Test(testName = "TC11 - Verify Login page is displayed after clicking on Buy now for an item")
    public static void verifyloginwhenproductselected() throws IOException {
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        searchProduct searchProduct = new searchProduct(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (searchProduct.verifyAlertSuccess())
        {
            searchProduct.clickClose();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        searchProduct.enterSearchText("APPLE iPhone 11");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchProduct.enterkeypress();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //System.out.println(searchProduct.selectproductwoltext());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        searchProduct.selectproductwol();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        searchProduct.clickbuynow();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      takeScreenshot("C=TC11");

    }

    @Test(testName = "TC12 - Verify footer about section")
    public static void verifyaboutsection() throws IOException {
        driver.get(Utils.BASE_URL);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        String aboutsection;

        verifyfootersection verifyfootersection  = new verifyfootersection(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        if (verifyfootersection.verifyAlertSuccess()) {
            verifyfootersection.clickClose();
        }

        aboutsection = verifyfootersection.getfooterabout();
       // System.out.print(aboutsection + " printing");
        if (aboutsection.contains("About Us") )
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            takeScreenshot("TC12");}
    }
    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}