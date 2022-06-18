package core.testScripts;

import core.pages.others.FacebookHomePage;
import core.pages.others.GoogleHomePage;
import core.utility.BaseClass;
import org.testng.annotations.Test;

public class TC03 extends BaseClass {

    @Test(description = "Visit and locate search-box Google")
    public void googleSearchBox() {
        driver.get("https://www.google.com");
        ghp.checkSearchBoxXpath();
        ghp.checkSearchBoxCss();
    }

    @Test(description = "Visit and locate elements on Facebook")
    public void facebookElements() {
        driver.get("https://www.facebook.com");
        fhp.checkElements();
    }

}
