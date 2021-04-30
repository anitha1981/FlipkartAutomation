
import org.openqa.selenium.*;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;

public class searchProduct extends PageObject {

    //private final String SEARCHTEXT = "iphone 12 pro max";

    // @FindBy(class = "first-name")
    // private WebElement first_name;

    public searchProduct(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
    private WebElement txt_searchbox;

    @FindBy(xpath = "/html/body/div[2]/div/div/button")
    private WebElement login_closebutton;

    @FindBy(xpath = "//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/button/svg/g/path[2]")
    private WebElement searchicon;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
    private WebElement searchresult;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div/div[1]")
    private WebElement Nosearchresult;

    //login section start
    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a")
    private WebElement login;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
    private WebElement username;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
    private WebElement password;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button/span")
    private WebElement confirmlogin;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
    private WebElement addtocart;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]")
    private WebElement removecart;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[5]/div/div/a/div")
    private WebElement cartlink;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[2]")
    private WebElement cartremovefinal;

    @FindBy(xpath ="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div[4]")
    private WebElement pricehightolow;

    @FindBy(xpath ="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]")
    private WebElement highestpriceditem;

    // add to cart section

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a[1]/div[1]/div/div/img")
    private WebElement productitem;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
    private WebElement productitemwoutlogin;

    @FindBy(xpath = "//*[@id=\"pincodeInputId\"]")
    private WebElement pincode;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[7]/div/div/div[1]/div[2]/div/div[2]/div/span")
    private WebElement pincheck;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div/div[1]/a/div[1]")
    private WebElement topoffers;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button")
    private WebElement btnbuynow;

    public void enterusername() {
        this.username.click();
        this.username.sendKeys("hariharan.anitha@gmail.com");
    }

    public void enterpassword() {
        this.password.sendKeys("pillai04");
    }

    public void ClickLogin() {
        try {
            if (!login_closebutton.isDisplayed()) {
                this.login.click();
            }
        }
        catch (NoSuchElementException e)
        {// Code for Handling exception
            this.login.click();
             }
           }

    public void confirmLogin() {
        this.confirmlogin.click();
    }
    // login session end


    public void clickSearch() {
        this.txt_searchbox.click();

    }

    public void enterSearchText(String SEARCHTEXT) {
        //this.txt_searchbox.click();
        this.txt_searchbox.sendKeys(SEARCHTEXT);
//        if (this.txt_searchbox.getText()!=SEARCHTEXT)
//        {
//            this.txt_searchbox.sendKeys(SEARCHTEXT);
//        }
    }

    public void enterkeypress() {
        this.txt_searchbox.click();
        this.txt_searchbox.sendKeys(Keys.ENTER);

    }

    public void clickSearchIcon() {
        this.searchicon.click();
    }

    public void clickClose() {
        this.login_closebutton.click();
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

    public boolean verifySearchresult() {
        if (this.searchresult.getText().contains("iphone 12")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyNoSearchresult() {
        if (this.Nosearchresult.getText().contains("no results found")) {
            return true;
        } else {
            return false;
        }
    }

        //add to cart section

        public void selectproduct () {
            this.productitem.click();

        }

        public void writepin (String pincode) {
            this.pincode.sendKeys(pincode);

        }

        public void pincheck () {

            this.pincheck.click();

        }

        public void addtocartclick ()
        {
            this.addtocart.click();
        }

        public boolean verifyproductfound () {
            if (this.productitem.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        }

    public boolean verifyproductwlgfound () {
        if (this.productitemwoutlogin.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

        public void cartremove () {
            this.removecart.click();
        }

    public void clickcart () {
        this.cartlink.click();
    }

    public void removecartfinal () {
        this.cartremovefinal.click();
    }

    public void clickhightolow()
    {
        this.pricehightolow.click();
    }
    public boolean validatehighpriceitem()
    {

        if(this.highestpriceditem.getText().contentEquals(Utils.HighPriceItemname))
        {
            return true;
        }
        {
            return false;
        }
    }
    //Top offers
    public void clickTopoffers()
    {
        this.topoffers.click();
    }

    //product search with out loging in
    public void selectproductwol () {
        this.productitemwoutlogin.click();
    }
    public String selectproductwoltext () {
        return this.productitemwoutlogin.getText();

    }
    public void clickbuynow () {
        this.btnbuynow.click();

    }
}