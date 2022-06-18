package core.testScripts;

import core.pages.others.FacebookHomePage;
import core.pages.others.SampleWebPage;
import core.utility.BaseClass;
import org.testng.annotations.Test;

public class TC05 extends BaseClass {

    @Test
    public void mouseScript() {
        driver.get("http://demo.guru99.com/test/newtours/");
        sp.mouseHandle();
    }

    @Test
    public void keyboardScript() {
        driver.get("https://www.facebook.com");
        fhp.keyboardScript();
    }


}
