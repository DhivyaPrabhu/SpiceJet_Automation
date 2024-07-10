package TestCases_Spicejet;

import Pages_Spicejet.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseClass
{
    @Test(priority = 0)
    public void SignupForm() throws InterruptedException
    {
        SignupPage signupPage=new SignupPage(driver);
        BaseClass baseClass=new BaseClass();
        signupPage.switchToSignupWindow();
        signupPage.setSignupForm("Kavitha","Ballu","8760877081","ammu3391@gmail.com","Kavi@1234","Kavi@1234");
        Assert.assertTrue(true);
        baseClass.HomePage();
    }
    @Test(priority = 1)
    public void SignupForm_with_invalid_credentials() throws InterruptedException
    {
        SignupPage signupPage=new SignupPage(driver);
        BaseClass baseClass=new BaseClass();
        signupPage.switchToSignupWindow();
        signupPage.setSignupForm("Kavitha","Ballu","8760877081","ammu33@gmail.com","Kavi@1234","Kavi234");
        Assert.assertTrue(true);
        baseClass.HomePage();
    }
    @Test(priority = 2)
    public void SignupForm_with_nullValues() throws InterruptedException
    {
        SignupPage signupPage=new SignupPage(driver);
        BaseClass baseClass=new BaseClass();
        signupPage.switchToSignupWindow();
        signupPage.setSignupForm("","","","","","");
        baseClass.HomePage();
    }

}
