package core.seleniumAssign;

import core.pages.orange.OrangeHomePage;
import core.pages.orange.OrangeLoginPage;
import core.utility.BaseClass;
import core.utility.GetData;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC01 extends BaseClass {

    @Test(description = "Login and dashboard check", priority = 0)
    public void Login() {
        GetData gd = new GetData();
        OrangeLoginPage op = new OrangeLoginPage(driver);
        OrangeHomePage ohp = new OrangeHomePage(driver);

        driver.get(gd.property("url01"));
        op.login(gd.property("username"), gd.property("password"));

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Assert.assertTrue(ohp.dashboardMenu.isDisplayed());

    }

    @Test(description = "Click on Admin and check the Link Texts",priority = 1)
    public void AdminCheck() {
        OrangeHomePage ohp = new OrangeHomePage(driver);

    }


}
