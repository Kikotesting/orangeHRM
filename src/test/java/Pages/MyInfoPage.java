package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

    WebDriver browser;
    public MyInfoPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
    }
    @FindBy(xpath = "//*[@id=\"btnSave\"]")
    WebElement menuMyInfo_EditButton;
    public void clickMyInfoEditButton(){
        menuMyInfo_EditButton.click();
    }

}
