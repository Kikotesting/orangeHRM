package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver browser;
    public DashboardPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
    }

    @FindBy(xpath = "//*[@id=\"mainMenuFirstLevelUnorderedList\"]/li[8]")
    WebElement menuDashboard;

    @FindBy(xpath = "//*[@id=\"menu_pim_viewMyDetails\"]")
    WebElement menuMyInfo;
    public void clickMenuMyInfo(){
        menuMyInfo.click();
    }









}
