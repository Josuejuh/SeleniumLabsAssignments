package core.pages.orange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangePimPage {

    WebDriver driver;

    @FindBy(id = "empsearch_employee_name_empName")
    WebElement searchName;

    @FindBy(id = "searchBtn")
    WebElement searchBtn;

    @FindBy(xpath = "//td[.='0016']")
    public WebElement resultLabel;



    public OrangePimPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String nameToSearch) {
        Actions action = new Actions(driver);
        action.moveToElement(searchName).perform();
        searchName.sendKeys(nameToSearch);
        searchBtn.click();
    }

}
