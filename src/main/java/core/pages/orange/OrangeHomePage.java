package core.pages.orange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {
    WebDriver driver;
    @FindBy(xpath = "//b[.='Admin']")
    public WebElement adminMenu;

    @FindBy(xpath = "//b[.='PIM']")
    public WebElement PIMMenu;
    @FindBy(id = "searchSystemUser_userName")
    WebElement searchUser;
    @FindBy(id = "searchBtn")
    WebElement searchUserBtn;
    @FindBy(linkText = "User Management")
    public WebElement sbmAdmin01;
    @FindBy(linkText = "Job")
    public WebElement sbmAdmin02;
    @FindBy(linkText = "Organization")
    public WebElement sbmAdmin03;
    @FindBy(linkText = "Qualifications")
    public WebElement sbmAdmin04;
    @FindBy(xpath = "//td[.='No Records Found']")
    public WebElement recordsFound;
    @FindBy(xpath = "//div[@class='inner']/div[1]//fieldset[@class='panel_resizable panel-preview']")
    public WebElement dashboardMenu;
    @FindBy(css = "h1")
    public WebElement dashboardTittle;

    @FindBy(css = "#menu_time_viewTimeModule > b")
    WebElement timeMenu;

    @FindBy(css = "#menu_maintenance_purgeEmployee.firstLevelMenu > b")
    WebElement maintenanceMenu;

    @FindBy(css = "td:nth-of-type(6) > .quickLaunge")
    WebElement dshTimesheet;

    @FindBy(css = ".quickLaungeContainer td:nth-of-type(1) > .quickLaunge")
    WebElement dshAssignLeave;

    @FindBy(css = "canvas:nth-of-type(2)")
    WebElement dshDashboard;

    @FindBy(xpath = "//input[@id='MP_link']")
    WebElement btnMarketplace;

    @FindBy(xpath = "//a[@id='welcome']")
    WebElement btnWelcome;

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
