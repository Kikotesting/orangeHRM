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


    /**
     * sdgdsgsdgsd
     * gsdgdsgsdgsd
     *
     */
    @FindBy(id = "btnSave")
    WebElement menuMyInfo_EditSaveButtonPersonalDetails;

    @FindBy(xpath = "//*[@id=\"personal_txtEmpFirstName\"]")
    WebElement menuMyInfo_PersonalDetails_FirstName;
    @FindBy(xpath = "//*[@id=\"personal_txtEmpLastName\"]")
    WebElement menuMyInfo_PersonalDetails_LastName;
    @FindBy(xpath = "//*[@id=\"personal_optGender_1\"]")

    WebElement menuMyInfo_PersonalDetails_GenderMale;
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
    @FindBy(xpath = "//*[@id=\"frmEmpCustomFields\"]/ol/li/select")
    WebElement menuMyInfo_CustomFields_BloodType;

    @FindBy(xpath = "//*[@id=\"btnAddAttachment\"]")
    WebElement menuMyInfo_Attachment_AddButton;
    @FindBy(xpath = "//*[@id=\"ufile\"]")
    WebElement menuMyInfo_Attachment_ChooseFile;
    @FindBy(xpath = "//*[@id=\"txtAttDesc\"]")
    WebElement menuMyInfo_Attachment_Comment;

    public void clickEditButton_PersonalDetails(){
        menuMyInfo_EditSaveButtonPersonalDetails.click();
    }
    public void clickSaveButton_PersonalDetails(){
        menuMyInfo_EditSaveButtonPersonalDetails.click();
    }


    public void clickEditButton_CustomField(){
        menuMyInfo_EditSaveButtonCustomFields.click();
    }
    public void clickSaveButton_CustomField(){
        menuMyInfo_EditSaveButtonCustomFields.click();
    }

    public void clickAddButton_Attachments(){
        menuMyInfo_Attachment_AddButton.click();
    }
    public void clickChooseFile_Attachments(){
        menuMyInfo_Attachment_ChooseFile.click();
    }
    public void fillAttachment(){
        menuMyInfo_Attachment_AddButton.click();
        menuMyInfo_Attachment_ChooseFile.click();


    }

}
