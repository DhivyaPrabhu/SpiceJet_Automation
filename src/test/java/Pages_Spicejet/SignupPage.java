package Pages_Spicejet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utilities.ExtentReportGenerator.getExtentReport;

public class SignupPage
{
    public WebDriver driver;
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath ="//div[text()='Signup']")
    WebElement signupButton;
    @FindBy (xpath ="//select[@class='form-control form-select ']")
    WebElement selectSalutation;
    @FindBy (xpath ="//input[@id='first_name']")
    WebElement signupFirstName;
    @FindBy (xpath ="//input[@id='last_name']")
    WebElement signupLastName;
    @FindBy (xpath ="//select[@tabindex='0']")
    WebElement selectCountry;
    @FindBy (xpath ="//input[@id='dobDate']")
    WebElement dobCalendar;
    @FindBy (xpath ="//select[@class='react-datepicker__month-select']")
    WebElement selectMonth;
    @FindBy (xpath ="//select[@class='react-datepicker__year-select']")
    WebElement selectYear;
    @FindBy (xpath ="(//div[@aria-label='Choose Sunday, March 3rd, 1991'])[1]")
    WebElement dobDate;
    @FindBy (xpath ="//input[@type='tel']")
    WebElement signupPhoneNumber;
    @FindBy (xpath ="//input[@id='email_id']")
    WebElement signupEmailId;
    @FindBy (xpath ="//input[@id='new-password']")
    WebElement signupPassword;
    @FindBy (xpath ="//input[@id='c-password']")
    WebElement signupConfirmPassword;
    @FindBy (xpath ="//input[@type='checkbox']")
    WebElement iAgreeButton;
    @FindBy(xpath ="//button[text()='Submit']")
    WebElement submitButton;

    public void switchToSignupWindow() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        signupButton.click();
        //Switch to new window---->Using Set & List function to get the Index access
        Set<String> allWindows=driver.getWindowHandles();
        List<String> WindowStrings = new ArrayList<String >(allWindows);
        String newWindow = WindowStrings.get(1);
        String OrginalWindow=WindowStrings.get(0);
        driver.switchTo().window(newWindow);
    }

    public void setSignupForm(String fname,String lname,String mobileNum,String email,String pwd,String confirmPwd) throws InterruptedException {
        try {
            Select salutation_dropdown = new Select(selectSalutation);
            salutation_dropdown.selectByVisibleText("Mrs");
            signupFirstName.sendKeys(fname);
            Thread.sleep(2000);
            signupLastName.sendKeys(lname);
            Thread.sleep(2000);
            signupPhoneNumber.sendKeys(mobileNum);
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.elementToBeClickable(signupEmailId));
            signupEmailId.sendKeys(email);
            Thread.sleep(2000);
            signupPassword.sendKeys(pwd);
            Thread.sleep(2000);
            signupConfirmPassword.sendKeys(confirmPwd);
            Thread.sleep(2000);
            Select country_dropdown = new Select(selectCountry);
            country_dropdown.selectByVisibleText("India");
            Thread.sleep(2000);
            dobCalendar.click();
            Select month_dropdown = new Select(selectMonth);
            month_dropdown.selectByVisibleText("March");
            Thread.sleep(2000);
            Select year_dropdown = new Select(selectYear);
            year_dropdown.selectByVisibleText("1991");
            dobDate.click();
            Thread.sleep(5000);
            iAgreeButton.click();
            Thread.sleep(5000);
            submitButton.click();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        finally {
            getExtentReport();
        }
    }

}
