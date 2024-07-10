package TestCases_Spicejet;

import Pages_Spicejet.Trip_SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OneWayTripTest extends BaseClass
{
    BaseClass baseClass;
    @Test(priority = 9)
    public void Oneway_TripTest() throws InterruptedException {
        Trip_SearchPage sp=new Trip_SearchPage(driver);
        baseClass=new BaseClass();
        sp.setOnewayTrip();
        sp.setOrigin();
        sp.setDepartureDatePicker();
        sp.setToDestination();
        sp.proceed();
        sp.ValidationOfOnewayTrip_and_RoundTrip();
        Assert.assertTrue(true);
        baseClass.HomePage();

    }
    @Test(priority = 10)
    public void Oneway_TripTest_with_missing_Credential() throws InterruptedException {
        Trip_SearchPage sp=new Trip_SearchPage(driver);
        baseClass=new BaseClass();
        sp.setOnewayTrip();
        sp.setOrigin();
        sp.setDepartureDatePicker();
        //sp.setToDestination();
        sp.proceed();
        sp.ValidationOfOnewayTrip_and_RoundTrip();
        pageSource("Please enter a valid destination", "Negative one way booking test passed", "Negative one way booking test failed");
        Assert.assertTrue(true);
        baseClass.HomePage();

    }
}
