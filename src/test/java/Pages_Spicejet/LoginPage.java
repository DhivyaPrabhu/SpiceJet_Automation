package Pages_Spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage
{
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[text()='Login']")
    WebElement loginOption;
    @FindBy(xpath="//div[text()='Email']")
    WebElement login_via_Email;
    @FindBy(xpath = "//div[text()='Mobile Number']")
    WebElement login_via_MobileNum;
    @FindBy(xpath = "(//input[@type='number'])[1]")
    WebElement mobileNumInput;
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//div[@data-testid='login-cta']")
    WebElement loginButton;

    public void getLoginOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(loginOption));
        loginOption.click();
    }
    public void setLogin_via_Email(String email, String password) {
        try {
            login_via_Email.click();
            emailInput.clear();
            emailInput.sendKeys(email);
            passwordInput.clear();
            passwordInput.sendKeys(password);
            loginButton.click();
        }
        catch(Exception e)
        {
            e.getMessage();
        }

    }
    public void setLogin_via_MobileNum(String mobileNum, String password)
    {
        try {
            login_via_MobileNum.click();
            mobileNumInput.clear();
            mobileNumInput.sendKeys(mobileNum);
            passwordInput.clear();
            passwordInput.sendKeys(password);
            loginButton.click();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
    public void validationOfLogin()
    {
        String actualString = driver.findElement(By.xpath("(//div[contains(text(),'Hi')])[1]")).getText();
        Assert.assertTrue(actualString.contains("Hi"));
        System.out.println(actualString);
    }
}
