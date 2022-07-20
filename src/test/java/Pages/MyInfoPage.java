package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyInfoPage {

    WebDriver browser;
    public MyInfoPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
    }

    @FindBy(id = "btnSave")
    WebElement menuMyInfo_PersonalDetails_EditSaveButton;
    @FindBy(xpath = "//*[@id=\"personal_txtEmpFirstName\"]")
    WebElement menuMyInfo_PersonalDetails_FirstNameField;
    @FindBy(xpath = "//*[@id=\"personal_txtEmpLastName\"]")
    WebElement menuMyInfo_PersonalDetails_LastNameField;
    @FindBy(xpath = "//*[@id=\"personal_optGender_2\"]")
    WebElement menuMyInfo_PersonalDetails_GenderFemale;
    @FindBy(xpath = "//*[@id=\"personal_cmbNation\"]")
    WebElement menuMyInfo_PersonalDetails_Nationality;
    @FindBy(xpath = "//*[@id=\"personal_cmbMarital\"]")
    WebElement menuMyInfo_PersonalDetails_MaritalStatus;
    @FindBy(xpath = "//*[@id=\"personal_chkSmokeFlag\"]")
    WebElement menuMyInfo_PersonalDetails_Smoker;
    @FindBy(id = "btnEditCustom")
    WebElement menuMyInfo_EditSaveButtonCustomFields;
    @FindBy(xpath = "//*[@id=\"employee-details\"]/div[3]/div[1]/h1")
    public WebElement HeadingCustomFields;
    @FindBy(xpath = "//*[@id=\"frmEmpCustomFields\"]/ol/li/select")
    WebElement menuMyInfo_CustomFields_BloodType;


    public void clickEditButton_PersonalDetails(){
        menuMyInfo_PersonalDetails_EditSaveButton.click();
    }
    public void setFNLN_PersonalDetails(String firstname, String lastname){
        menuMyInfo_PersonalDetails_FirstNameField.clear();
        menuMyInfo_PersonalDetails_FirstNameField.sendKeys(firstname);
        menuMyInfo_PersonalDetails_LastNameField.clear();
        menuMyInfo_PersonalDetails_LastNameField.sendKeys(lastname);
    }
    public void clickGender(){
        menuMyInfo_PersonalDetails_GenderFemale.click();
    }
    public void clickSmoker(){
        menuMyInfo_PersonalDetails_Smoker.click();
    }
    public void setGenNatStat_PersonalDetails() throws InterruptedException {
        menuMyInfo_PersonalDetails_Nationality.click();
        Select nat = new Select(menuMyInfo_PersonalDetails_Nationality);
        nat.selectByValue("29");
        menuMyInfo_PersonalDetails_Nationality.click();
        Thread.sleep(2000);
        menuMyInfo_PersonalDetails_MaritalStatus.click();
        Select materialStatus = new Select(menuMyInfo_PersonalDetails_MaritalStatus);
        materialStatus.selectByValue("Married");
        menuMyInfo_PersonalDetails_MaritalStatus.click();
    }
    public void clickSaveButton_PersonalDetails(){
        menuMyInfo_PersonalDetails_EditSaveButton.click();
    }
    public void clickEditButton_CustomField(){
        menuMyInfo_EditSaveButtonCustomFields.click();
    }
    public void selectBloodType(){
        Select bloodType = new Select(menuMyInfo_CustomFields_BloodType);
        bloodType.selectByValue("A+");
        menuMyInfo_CustomFields_BloodType.click();
    }
    public void clickSaveButton_CustomField(){
        menuMyInfo_EditSaveButtonCustomFields.click();
    }

}
