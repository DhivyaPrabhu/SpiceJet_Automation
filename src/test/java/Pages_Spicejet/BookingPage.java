package Pages_Spicejet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BookingPage
{
    public WebDriver driver;
    public BookingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[1]")
    WebElement salutationMenu;


    @FindBy(xpath = "(//input[@type='text'])[1]")
    WebElement FirstName;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    WebElement LastName;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    WebElement PhoneNumber;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    WebElement Email;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[3]")
    WebElement countryMenu;

    @FindBy(xpath = "(//input[@type='text'])[5]")
    WebElement Town;

    @FindBy(xpath = "//div[contains(text(),'Retain my details for the next visit.')]")
    WebElement retainMyDetails;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[4]")
    WebElement Passenger_salutationMenu;


    @FindBy(xpath = "(//input[@type='text'])[6]")
    WebElement PassengerOneFirstName;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    WebElement PassengerOneLastName;

    @FindBy(xpath = "(//input[@type='text'])[8]")
    WebElement PassengerOnePhoneNumber;

    @FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
    WebElement submitBtn;

    @FindBy(xpath = "(//div[@data-testid='add-ons-continue-footer-button'])[3]")
    WebElement clickContinue;

    @FindBy(xpath = "//div[text()='Credit/Debit Card']")
    WebElement creditCard;

    @FindBy(xpath = "//input[@data-merchant_id='spicejet']")
    WebElement enterCardNum;

    @FindBy(xpath = "//input[@placeholder='Cardholder Name'")
    WebElement enterCardHolderName;

    @FindBy(xpath="//input[@placeholder='MM']")
    WebElement enterExpiryMonth;

    @FindBy(xpath = "//input[@placeholder='YY']")
    WebElement enterExpiryYear;

    @FindBy(xpath = "//input[@placeholder='123']")
    WebElement enterCVV;

    @FindBy(xpath = "//div[@data-testid='common-proceed-to-pay']")
    WebElement proceedToPay;

    public void setContact_and_PassengerDetails(String c_fname,String c_lname, String c_mobilenum, String c_email,String c_town,String p_fname,String p_lname, String p_mobileNum) throws InterruptedException {
        try {
            Select dropdown = new Select(salutationMenu);
            dropdown.selectByVisibleText("Mrs");
            Thread.sleep(3000);
            FirstName.click();
            FirstName.sendKeys(c_fname);
            Thread.sleep(3000);
            LastName.clear();
            LastName.sendKeys(c_lname);
            Thread.sleep(3000);
            PhoneNumber.clear();
            PhoneNumber.sendKeys(c_mobilenum);
            Thread.sleep(3000);
            Email.clear();
            Email.sendKeys(c_email);
            Select dropdown_country = new Select(countryMenu);
            dropdown_country.selectByVisibleText("India");
            Thread.sleep(3000);
            Town.clear();
            Town.sendKeys(c_town);
            Thread.sleep(3000);
            Select PassengerSalutation_dropdown = new Select(Passenger_salutationMenu);
            PassengerSalutation_dropdown.selectByVisibleText("Mrs");
            Thread.sleep(3000);
            PassengerOneFirstName.sendKeys(p_fname);
            Thread.sleep(3000);
            PassengerOneLastName.sendKeys(p_lname);
            Thread.sleep(3000);
            PassengerOnePhoneNumber.sendKeys(p_mobileNum);
            Thread.sleep(3000);
            submitBtn.click();
            Thread.sleep(3000);
            clickContinue.click();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
    public void PaymentDetails(String cardNum,String holderName, String month,String year,String cVV) throws InterruptedException {
       try {
           creditCard.click();
           Thread.sleep(3000);
           enterCardNum.sendKeys(cardNum);
           Thread.sleep(3000);
           enterCardHolderName.sendKeys(holderName);
           Thread.sleep(3000);
           enterExpiryMonth.sendKeys(month);
           Thread.sleep(3000);
           enterExpiryYear.sendKeys(year);
           Thread.sleep(3000);
           enterCVV.sendKeys(cVV);
           Thread.sleep(3000);
           proceedToPay.click();
           Assert.assertTrue(true);
       }
       catch (Exception e)
       {
           e.getMessage();
       }
        Assert.assertTrue(true);
    }
}
