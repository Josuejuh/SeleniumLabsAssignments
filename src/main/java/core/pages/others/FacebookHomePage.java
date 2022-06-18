package core.pages.others;

import core.utility.HighLight;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class FacebookHomePage {

    WebDriver driver;

    @FindBy(css = "#email")
    WebElement cssEmailBox;

    @FindBy(css = "#passContainer")
    WebElement cssPasswordBox;

    @FindBy(css = "[name='login']")
    WebElement cssLoginButton;

//    //WE CAN USE SOMETHING LIKE THIS TOO
//    //REMEMBER THE DIFFERENCE BETWEEN FINDALL AND FINDBYS
//    @FindAll(@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']"))
//    //@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
//            List<WebElement> tittleResults;

    public FacebookHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkElements() {
        HighLight.highLighterMethod(this.driver,cssEmailBox);
        HighLight.highLighterMethod(this.driver,cssPasswordBox);
        HighLight.highLighterMethod(this.driver,cssPasswordBox);
    }

    public void keyboardScript(){
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(cssEmailBox)
                .click()
                .keyDown(cssEmailBox, Keys.SHIFT)
                .sendKeys(cssEmailBox, "hello")
                .keyUp(cssEmailBox, Keys.SHIFT)
                .doubleClick(cssEmailBox)
                .contextClick()
                .build();

        seriesOfActions.perform() ;
    }

}
