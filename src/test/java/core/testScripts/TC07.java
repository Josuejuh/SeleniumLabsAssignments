package core.testScripts;

import core.utility.BaseClass;
import core.utility.listeners.ListenerCustom;
import core.utility.listeners.RetryAnalizer;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ListenerCustom.class)
public class TC07 extends BaseClass {

    @Test
    public void TestSucess(){
        driver.get("https://www.google.com.sv");
        System.out.println(driver.getTitle());
    }

    @Test (retryAnalyzer = RetryAnalizer.class)
    public void TestFailure(){
        driver.get("https://www.google.com.sv");
        Assert.assertEquals(driver.getTitle(),"Nothing");
    }

}
