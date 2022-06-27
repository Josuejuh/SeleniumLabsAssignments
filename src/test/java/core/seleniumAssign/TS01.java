package core.seleniumAssign;


import core.utility.BaseClass;
import core.utility.listeners.ListenerCustom;
import core.utility.listeners.RetryAnalizer;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners(ListenerCustom.class)
public class TS01 extends BaseClass {

    @Test(description = "Login and dashboard check", priority = 1)
    public void Login() {

        driver.get(gd.property("url01"));
        olp.login(gd.property("username"), gd.property("password"));

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Assert.assertTrue(ohp.dashboardMenu.isDisplayed());

        //Printing Dashboard text
        System.out.println(ohp.dashboardTittle.getText());

    }


    @Test(description = "Click on Admin and check the Link Texts",priority = 2, retryAnalyzer = RetryAnalizer.class)
    //@Test(description = "Click on Admin and check the Link Texts",priority = 2)
    public void AdminCheck() {
        ohp.adminMenu.click();
        Assert.assertEquals(ohp.sbmAdmin01.getText(), "User Management");
        Assert.assertEquals(ohp.sbmAdmin02.getText(), "Job");
        Assert.assertEquals(ohp.sbmAdmin03.getText(), "Organization");
        Assert.assertEquals(ohp.sbmAdmin04.getText(), "Qualifications");

    }


}
