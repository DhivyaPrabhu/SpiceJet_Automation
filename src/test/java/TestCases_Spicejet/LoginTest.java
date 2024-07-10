package TestCases_Spicejet;

import Pages_Spicejet.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass
{

    @Test(priority = 8)
    public void LoginTest_via_email()
    {
        LoginPage lp=new LoginPage(driver);
        BaseClass baseClass=new BaseClass();
        lp.getLoginOption();
        lp.setLogin_via_Email("divi3391@gmail.com","Prabhu@43883391");
       // lp.validationOfLogin();
        baseClass.HomePage();

    }
    @Test(priority = 7)
    public void LoginTest_ivalid_crendentials()
    {
        LoginPage lp=new LoginPage(driver);
        BaseClass baseClass=new BaseClass();
        lp.getLoginOption();
        lp.setLogin_via_Email("divi33@gmail.com","Prabhu@43883391");
        //lp.validationOfLogin();
        baseClass.HomePage();

    }
    @Test(priority = 6)
    public void LoginTest_with_empty_crendentials()
    {
        LoginPage lp=new LoginPage(driver);
        BaseClass baseClass=new BaseClass();
        lp.getLoginOption();
        lp.setLogin_via_Email("","");
        //lp.validationOfLogin();
        baseClass.HomePage();
    }

    @Test(priority = 5)
    public void LoginTest_via_MobileNum()
    {
        LoginPage lp=new LoginPage(driver);
        BaseClass baseClass=new BaseClass();
        lp.getLoginOption();
        lp.setLogin_via_MobileNum("8760877080","Prabhu@43883391");
        //lp.validationOfLogin();
        //Assert.assertTrue(true);
        baseClass.HomePage();
    }
    @Test(priority = 4)
    public void LoginTest_via_InvalidMobileNum()
    {
        LoginPage lp=new LoginPage(driver);
        BaseClass baseClass=new BaseClass();
        lp.getLoginOption();
        lp.setLogin_via_MobileNum("876087708","Prabhu@43883391");
        //lp.validationOfLogin();
        baseClass.HomePage();
    }
    @Test(priority = 3)
    public void LoginTest_via_MobileNum_with_Empty_Credentials()
    {
        LoginPage lp=new LoginPage(driver);
        BaseClass baseClass=new BaseClass();
        lp.getLoginOption();
        lp.setLogin_via_MobileNum("","");
        //lp.validationOfLogin();
        baseClass.HomePage();
    }
}
