package core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class FacebookHomePage {

    WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchTab;

    //WE CAN USE SOMETHING LIKE THIS TOO
    //REMEMBER THE DIFFERENCE BETWEEN FINDALL AND FINDBYS
    @FindAll(@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']"))
    //@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
            List<WebElement> tittleResults;

    public FacebookHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkTitle(String tittle) {
        assertEquals(driver.getTitle(), tittle);
    }

}
