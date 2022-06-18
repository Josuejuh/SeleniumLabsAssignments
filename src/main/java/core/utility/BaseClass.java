package core.utility;

import core.pages.orange.OrangeHomePage;
import core.pages.orange.OrangeLoginPage;
import core.pages.others.FacebookHomePage;
import core.pages.others.GoogleHomePage;
import core.pages.others.SampleWebPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver = null;
    public OrangeHomePage ohp;
    public OrangeLoginPage olp;
    public FacebookHomePage fhp;
    public GoogleHomePage ghp;
    public SampleWebPage sp;
    public GetData gd;

    public WebDriver getDriver() {
        return driver;
    }
    //BEFORE SUITE WILL BE A GOOD APPROACH TOO DEPENDING ON HOW IT IS SET UP THE TESTNG SUITE
    @BeforeClass
    public void initializeDriver() {

        String browser = System.getProperty("browser", "chrome");

        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.contains("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void methodLevelSetup() {
        ohp = new OrangeHomePage(driver);
        olp = new OrangeLoginPage(driver);
        fhp = new FacebookHomePage(driver);
        ghp = new GoogleHomePage(driver);
        sp = new SampleWebPage(driver);
        gd = new GetData();
    }

    @AfterClass
    public void quitDriver() {
        //driver.quit();
    }

    public void minimizeWindow(){
        driver.manage().window().minimize();
    }


}
