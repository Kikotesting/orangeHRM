package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimePage {
    WebDriver browser;
    public TimePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
    }

   @FindBy(xpath = "//*[@id=\"menu_time_Timesheets\"]")
    WebElement subMenu_Timesheets;
    @FindBy(xpath = "//*[@id=\"menu_attendance_Attendance\"]")
    WebElement subMenu_Attendance;
    @FindBy(xpath = "//*[@id=\"menu_time_Reports\"]")
    WebElement subMenu_Reports;
    @FindBy(xpath = "//*[@id=\"menu_admin_ProjectInfo\"]")
    WebElement subMenu_ProjectInfo;

    @FindBy(xpath = "//*[@id=\"employee\"]")
    WebElement menuTime_EmployeeNameField;
    @FindBy(xpath = "//*[@id=\"employee\"]")
    WebElement menuTime_ViewButton;

    public void clickEmployeeField(){
        menuTime_EmployeeNameField.click();
    }
    public void setEmployeeName(String employeeName){
        menuTime_EmployeeNameField.clear();
        menuTime_EmployeeNameField.sendKeys(employeeName);
    }
    public void clickViewButton(){
        menuTime_ViewButton.click();
    }






}
