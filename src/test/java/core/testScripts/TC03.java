package core.testScripts;

import core.pages.others.FacebookHomePage;
import core.pages.others.GoogleHomePage;
import core.utility.BaseClass;
import org.testng.annotations.Test;

public class TC03 extends BaseClass {

    @Test(description = "Visit and locate search-box Google")
    public void googleSearchBox() {
        GoogleHomePage gp = new GoogleHomePage(driver);
        driver.get("https://www.google.com");
        gp.checkSearchBoxXpath();
        gp.checkSearchBoxCss();
    }

    @Test(description = "Visit and locate elements on Facebook")
    public void facebookElements() {
        FacebookHomePage fp = new FacebookHomePage(driver);
        driver.get("https://www.facebook.com");
        fp.checkElements();
    }

}
