package core.pages.others;

import core.utility.HighLight;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class GoogleHomePage {

    WebDriver driver;
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
     WebElement xpathSearchBox;
    @FindBy(css = "input")
    WebElement cssSearchBox;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkSearchBoxXpath() {
        xpathSearchBox.clear();
        xpathSearchBox.sendKeys("xPath");
      HighLight.highLighterMethod(this.driver,xpathSearchBox);
    }

    public void checkSearchBoxCss() {
        cssSearchBox.clear();
        cssSearchBox.sendKeys("Css");
       HighLight.highLighterMethod(this.driver,xpathSearchBox);
    }

}
