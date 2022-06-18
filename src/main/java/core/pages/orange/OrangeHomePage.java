package core.pages.orange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {

    WebDriver driver;

    @FindBy(xpath = "//b[.='Admin']")
    WebElement adminMenu;
    @FindBy(id = "searchSystemUser_userName")
    WebElement searchUser;
    @FindBy(id = "searchBtn")
    WebElement searchUserBtn;


    @FindBy(xpath = "//td[.='No Records Found']")
    public WebElement recordsFound;
    @FindBy(xpath = "//div[@class='inner']/div[1]//fieldset[@class='panel_resizable panel-preview']")
    public WebElement dashboardMenu;

    public OrangeHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchOnAdminPanel(String search) {
        adminMenu.click();
        searchUser.sendKeys(search);
        searchUserBtn.click();

    }

}
