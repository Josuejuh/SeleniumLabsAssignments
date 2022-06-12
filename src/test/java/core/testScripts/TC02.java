package core.testScripts;

import core.utility.BaseClass;
import org.testng.annotations.*;

public class TC02 extends BaseClass {

    @Test(description = "Visiting Facebook and printing page title")
    public void visitFacebook(){
        driver.get("https://www.facebook.com");
        System.out.println("************************************");
        System.out.println("PRINTING TITLE");
        System.out.println(driver.getTitle());
        System.out.println("************************************");
    }

    @Test(description = "Visiting Google and printing URL")
    public void visitGoogle01(){
        driver.get("https://www.google.com.sv");
        System.out.println("************************************");
        System.out.println("PRINTING URL");
        System.out.println(driver.getCurrentUrl());
        System.out.println("************************************");
    }

    @Test(description = "Visiting Google and printing Page Source")
    public void visitGoogle02(){
        driver.get("https://www.google.com.sv");
        System.out.println("************************************");
        System.out.println("PRINTING PAGE SOURCE");
        System.out.println(driver.getPageSource());
        System.out.println("************************************");
    }


}
