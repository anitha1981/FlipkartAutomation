import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPage extends PageObject{

      public LoginPage(WebDriver driver) {
            super(driver);
        }
       WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a")
    private WebElement login;

    @FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
    private WebElement username;

    @FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
    private WebElement password;

    @FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button/span")
    private WebElement confirmlogin;

    @FindBy(xpath = "/html/body/div[2]/div/div/button")
    private WebElement login_closebutton;

    public void enterusername(){
        this.username.click();
        this.username.sendKeys("hariharan.anitha@gmail.com");
    }

    public void enterpassword(){
        this.password.sendKeys("pillai04");
    }

    public void ClickLogin(){
        if (!login_closebutton.isDisplayed()){
            this.login.click();
        }

    }
        public void confirmLogin() {
        this.confirmlogin.click();
    }


}
