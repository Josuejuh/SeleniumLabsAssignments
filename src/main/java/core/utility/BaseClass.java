package core.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver = null;

    //BEFORE SUITE WILL BE A GOOD APPROACH TOO DEPENDING IN HOW IT IS SET UP THE TESTNG SUITE
    @BeforeSuite
    public WebDriver initializeDriver() {

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

        return driver;
    }

    @AfterSuite
    public void quitDriver() {
        //driver.quit();
    }


}
