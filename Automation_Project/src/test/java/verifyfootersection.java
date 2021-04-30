import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyfootersection extends PageObject
{

   public verifyfootersection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"container\"]/div/footer/div/div[3]/div[1]/div[6]/div/div[2]/div/div")
    private WebElement regaddress;

    @FindBy(xpath = "//*[@id=\"container\"]/div/footer/div/div[3]/div[1]/div[1]/a[2]")
    private WebElement footerabout;

    @FindBy(xpath = "/html/body/div[2]/div/div/button")
    private WebElement login_closebutton;

public String getregaddress()
{
    return this.regaddress.getText();
}

public String getfooterabout()
{
    return this.footerabout.getText();
}
    public boolean verifyAlertSuccess() {

        try
        {
            if (this.login_closebutton.isDisplayed()) {
                return true;
            } else {
                return false;
            }

        } catch (NoSuchElementException e) {
            // Code for Handling exception
            return false;
        }
    }
    public void clickClose() {
        this.login_closebutton.click();
    }
}

