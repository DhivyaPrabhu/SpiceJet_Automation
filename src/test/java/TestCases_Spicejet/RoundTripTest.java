package TestCases_Spicejet;

import Pages_Spicejet.Trip_SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoundTripTest extends BaseClass
{
    @Test(priority = 11)
    public void Round_TripTest() throws InterruptedException {
        Trip_SearchPage sp=new Trip_SearchPage(driver);
        BaseClass baseClass=new BaseClass();
        sp.setRoundTrip();
        sp.setOrigin();
        sp.setDepartureDatePicker();
        sp.setToDestination();
        sp.setReturnDatePicker();
        sp.proceed();
        sp.ValidationOfOnewayTrip_and_RoundTrip();
        Assert.assertTrue(true);
        baseClass.BookingPage();
    }
    @Test(enabled = false, priority = 12)
    public void Round_TripTest_with_MissingCredentials() throws InterruptedException {
        Trip_SearchPage sp=new Trip_SearchPage(driver);
        BaseClass baseClass=new BaseClass();
        sp.setRoundTrip();
        sp.setOrigin();
        sp.setDepartureDatePicker();
        //sp.setToDestination();
        //sp.setReturnDatePicker();
        sp.proceed();
        sp.ValidationOfOnewayTrip_and_RoundTrip();
        //Assert.assertTrue(true);
        baseClass.BookingPage();
    }
}
