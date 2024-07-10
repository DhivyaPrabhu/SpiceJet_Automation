package Pages_Spicejet;

import Utilities.ExtentReportGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utilities.ExtentReportGenerator.getExtentReport;

public class Trip_SearchPage {
    public WebDriver driver;
    public WebDriverWait wait;

    // Constructor to initialize WebDriver
    public Trip_SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='one way']")
    WebElement onewayButton;

    @FindBy(xpath = "(//*[name()='circle'])[3]")
    WebElement roundTripButton;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    WebElement fromOrigin;

    @FindBy(xpath = "//div[text()='DEL']")
    WebElement selectDelhi;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    WebElement toDestination;

    @FindBy(xpath = "//div[contains(text(),'BOM')]")
    WebElement selectMumbai;

    @FindBy(xpath = "//div[@data-testid='departure-date-dropdown-label-test-id']")
    WebElement DepartureDatePicker;

    @FindBy(xpath = "//div[text()='Return Date']")
    WebElement returnDatePicker;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-k8qxaj'])[1]//div")
    WebElement selectMonth;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu']//div[text()='5'])[3]")
    WebElement selectDay;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu']//div[text()='8'])[3]")
    WebElement returnDay;

    @FindBy(xpath = "//div[text()='Passengers']")
    WebElement passengers;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")
    WebElement adult;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73'])[1]")
    WebElement donebtn;

    @FindBy(xpath = "//div[@data-testid=\"home-page-flight-cta\"]")
    WebElement searchButton;

    @FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-1i10wst r-1kfrs79'])[4]")
    WebElement select_Amt;

    @FindBy(xpath = "(//div[text()='Flight Details'])[1]")
    WebElement flightDetail1;

    @FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
    WebElement continueButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']//*[name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='circle' and contains(@cx,'24.5')]")
    WebElement next;


    public void setOnewayTrip() throws InterruptedException {
        onewayButton.click();

    }

    public void setRoundTrip() throws InterruptedException {
        onewayButton.click();
        roundTripButton.click();
    }

    public void setOrigin() throws InterruptedException {
        try {
            Thread.sleep(5000);
            fromOrigin.click();
            Thread.sleep(5000);
            selectDelhi.click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setToDestination() throws InterruptedException {
        try {
            Thread.sleep(5000);
            toDestination.click();
            Thread.sleep(5000);
            selectMumbai.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setPassengers() throws InterruptedException {
        Thread.sleep(5000);
        passengers.click();
    }

    public void setAdult() throws InterruptedException {
        Thread.sleep(5000);
        adult.click();
        Thread.sleep(5000);
        donebtn.click();
    }

    public void setDepartureDatePicker() throws InterruptedException {
        Thread.sleep(5000);
        DepartureDatePicker.click();
        //selectMonth.click();
        Thread.sleep(5000);
        next.click();
        Thread.sleep(5000);
        selectDay.click();
        Thread.sleep(5000);
    }

    public void setReturnDatePicker() throws InterruptedException {
        try {
            Thread.sleep(5000);
            returnDatePicker.click();
            //selectMonth.click();
            Thread.sleep(5000);
            next.click();
            Thread.sleep(5000);
            returnDay.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void proceed() throws InterruptedException {
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            waitDriver.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
        } catch (Exception e) {
            // Handle timeout exception if needed
            e.printStackTrace(); // Example: print stack trace
        }
        finally {
            // Report generation code
            getExtentReport();
        }
    }

    public void ValidationOfOnewayTrip_and_RoundTrip() {
        String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void selecting_flight() {
        try {
           // select_Amt.click();
           // flightDetail1.click();
            Thread.sleep(3000);
            continueButton.click();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
