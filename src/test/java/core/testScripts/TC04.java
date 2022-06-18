package core.testScripts;

import core.pages.others.SampleWebPage;
import core.utility.BaseClass;
import org.testng.annotations.*;

public class TC04 extends BaseClass {

    @Test(description = "Testing Alerts")
    public void alertScript() {
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        sp.alertHandle();
    }

    @Test
    public void handleMultipleWindows() {
        driver.get("http://demo.guru99.com/popup.php");
        sp.windowsHandle();
    }
}
