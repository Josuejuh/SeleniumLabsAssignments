package core.testScripts;

import core.utility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(core.utility.ListenerCustom01.class)
public class TC07 extends BaseClass {

    @Test
    public void TestSucess(){
        driver.get("https://www.google.com.sv");
        System.out.println(driver.getTitle());
    }

    @Test (retryAnalyzer = core.utility.RetryAnalizer.class)
    public void TestFailure(){
        driver.get("https://www.google.com.sv");
        Assert.assertEquals(driver.getTitle(),"Nothing");
    }

}
