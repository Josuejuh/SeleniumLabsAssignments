package core.pages.others;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class SampleWebPage {

    WebDriver driver;

    @FindBy(name = "cusid")
    WebElement txtBox;

    @FindBy(name = "submit")
    WebElement submitBtn;

    @FindBy(xpath = "//*[contains(@href,'popup.php')]")
    WebElement popUpBtn;

    @FindBy(name = "emailid")
    WebElement emailBox;

    @FindBy(name = "btnLogin")
    WebElement loginBtn;

    @FindBy(xpath = "//td[.='Home']")
    WebElement link_Home;

    @FindBy(xpath = "//body[1]//tr[1]//tr[1]//tr[1]//tr[1]/td[1]")
    WebElement td_Home;

    public SampleWebPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void alertHandle() {
        txtBox.sendKeys("53920");
        submitBtn.submit();
        // Switching to Alert
        Alert alert = driver.switchTo().alert();
        // Capturing alert message.
        String alertMessage = driver.switchTo().alert().getText();
        // Displaying alert message
        System.out.println(alertMessage);
        // Accepting alert
        alert.accept();
    }

    public void windowsHandle() {
        popUpBtn.click();
        String MainWindow = driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                emailBox.sendKeys("gaurav.3n@gmail.com");
                loginBtn.click();
                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);

    }

    public void mouseHandle() {

        String bgColor = null;
        td_Home.getCssValue("color");
        System.out.println("Before hover: " + bgColor);

        Actions builder = new Actions(driver);
        builder.moveToElement(link_Home).build().perform();

        bgColor = td_Home.getCssValue("color");
        System.out.println("After hover: " + bgColor);
    }
}
