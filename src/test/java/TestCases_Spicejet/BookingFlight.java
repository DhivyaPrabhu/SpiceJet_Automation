package TestCases_Spicejet;

import Pages_Spicejet.BookingPage;
import Pages_Spicejet.Trip_SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingFlight extends BaseClass
{
    @Test(priority = 13)
    public void PaymentProcess()throws InterruptedException {
        Trip_SearchPage searchPage=new Trip_SearchPage(driver);
        BookingPage bookingPage=new BookingPage(driver);
        BaseClass baseClass=new BaseClass();
        baseClass.BookingPage();
        searchPage.selecting_flight();
        bookingPage.setContact_and_PassengerDetails("Dhivya","Prabhu","8760877080","divi3391@gmail.com","Bangalore","Dhivya","Prabhu","9788276688");
        bookingPage.PaymentDetails("12345678","Anu","09","2025","582");
        Assert.assertTrue(true);
    }
}
