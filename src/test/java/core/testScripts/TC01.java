package core.testScripts;

import core.utility.BaseClass;
import org.testng.annotations.*;

public class TC01 extends BaseClass {

//    HomePage hp;
//
//    @BeforeClass
//    public void ObjectCreation() {
//        hp = new HomePage(driver);
//    }

    @Test (description = "Opening an specific URL and closing the driver")
    public void openURL(){
        driver.get("https://www.google.com.sv");
    }

}
