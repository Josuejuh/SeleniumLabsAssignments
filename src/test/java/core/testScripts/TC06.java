package core.testScripts;

import core.pages.orange.OrangeHomePage;
import core.pages.orange.OrangeLoginPage;
import core.utility.BaseClass;
import core.utility.GetData;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC06 extends BaseClass {

    @Test (priority = 0)
    public void Login01() {
        driver.get(gd.property("url01"));
        olp.login(gd.property("username"),gd.property("password"));

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Assert.assertTrue(ohp.dashboardMenu.isDisplayed());

    }

    @Test (priority = 1)
    public void AdminCheck() {
        ohp.searchOnAdminPanel("Newboo");
        Assert.assertFalse(ohp.recordsFound.isDisplayed());
    }




}
