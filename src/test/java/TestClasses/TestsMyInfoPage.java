package TestClasses;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.MyInfoPage;
import UtilityClasses.setupCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestsMyInfoPage extends setupCode {
    LoginPage actLP;
    DashboardPage actDashboard;
    MyInfoPage actMyinfo;

    @Test
    @DisplayName("User can edit profile in MyInfo menu")
    public void testEditProfileInfo() throws InterruptedException {
        actLP = new LoginPage(browser);
        actMyinfo = new MyInfoPage(browser);
        actDashboard = new DashboardPage(browser);

        actLP.executeValidLogin();

        actDashboard.clickMenuMyInfo();

        actMyinfo.clickEditButton_PersonalDetails();
        actMyinfo.setFNLN_PersonalDetails("Kiko", "Bikov");
        actMyinfo.clickGender();
        actMyinfo.clickSmoker();
        actMyinfo.setGenNatStat_PersonalDetails();
        actMyinfo.clickSaveButton_PersonalDetails();
        scrollToWebElement(actMyinfo.HeadingCustomFields);
        actMyinfo.clickEditButton_CustomField();
        actMyinfo.selectBloodType();
        actMyinfo.clickSaveButton_CustomField();

    }
}
