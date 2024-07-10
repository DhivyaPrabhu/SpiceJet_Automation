package TestCases_Spicejet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass
{
    public static WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOp = new ChromeOptions();
            chromeOp.addArguments("--headless");
            driver = new ChromeDriver();//driver = new ChromeDriver(chromeOp)
            driver.manage().window().maximize();
        }else if (browser.equalsIgnoreCase("Edge")) {
            EdgeOptions edgeOp = new EdgeOptions();
            edgeOp.addArguments("--headless");
            driver = new EdgeDriver();//driver = new EdgeDriver(edgeOp)
            driver.manage().window().maximize();
        }
        /*else if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions fireOp = new FirefoxOptions();
            fireOp.addArguments("--headless");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }*/
        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

   @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

   public static String takeScreenShot(String testCaseName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destinationFile = new File("D:\\Intelli workspace\\SpiceJet_Flight_BookingSystem\\Screenshots\\" + testCaseName + ".png");
        try {
            FileUtils.copyFile(scrFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String path = "<img src= " + destinationFile.getAbsolutePath() + " width = 200px height=200px />";

        Reporter.log(path);
        return destinationFile.getAbsolutePath();
    }
    public static void pageSource(String containsValue, String sysoMessageOne, String sysoMessageTwo) {
        if (driver.getPageSource().contains(containsValue)) {
            System.out.println(sysoMessageOne);
        } else {
            System.out.println(sysoMessageTwo);
        }
    }
    public void HomePage()
    {
        driver.navigate().to("https://www.spicejet.com/");
    }
    public void BookingPage()
    {
        driver.navigate().to("https://www.spicejet.com/search?from=DEL&to=BOM&tripType=1&departure=2024-09-05&adult=1&child=0&srCitizen=0&infant=0&currency=INR&redirectTo=/");
    }
}
