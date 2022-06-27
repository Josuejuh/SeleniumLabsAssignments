package core.seleniumAssign;

import core.utility.BaseClass;
import core.utility.listeners.ListenerCustom;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenerCustom.class)
public class TS02 extends BaseClass {

    @Test(description = "Login and check search PIM")
    public void Login() {

        driver.get(gd.property("url01"));
        olp.login(gd.property("username"), gd.property("password"));

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Assert.assertTrue(ohp.dashboardMenu.isDisplayed());

        ohp.PIMMenu.click();
        opp.search("Linda Anderson");
        Assert.assertEquals(opp.resultLabel.getText(),"0016");


    }
}

