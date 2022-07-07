package TestClasses;

import Pages.DashboardPage;
import UtilityClasses.setupCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DashboardTests extends setupCode {
    DashboardPage actD;

    @Test
    @Tag("Login functionality")
    @Tag("AC1 - positive")
    @DisplayName("User can login with valid credentials")
    void testValidLogin(){
        actD = new DashboardPage(browser);

        actD.clickUsernameField();
        actD.setUsername("Admin");
        actD.clickPasswordField();
        actD.setPassword("admin123");
        actD.clickLoginButton();
        actD.verifiedLoggedUser();
    }

    @Test
    @Tag("Login functionality")
    @Tag("Negative TC-1")
    @DisplayName("User cannot login with invalid username and valid password")
    void testInvalidLoginUsername(){
        actD = new DashboardPage(browser);

        actD.clickUsernameField();
        actD.setUsername("Pesho");
        actD.clickPasswordField();
        actD.setPassword("admin123");
        actD.clickLoginButton();
        actD.checkInvalidMessage();
    }

    @Test
    @Tag("Login functionality")
    @Tag("Negative TC-2")
    @DisplayName("User cannot login with valid username and invalid password")
    void testInvalidLoginPassword(){
        actD = new DashboardPage(browser);

        actD.clickUsernameField();
        actD.setUsername("Admin");
        actD.clickPasswordField();
        actD.setPassword("1221444");
        actD.clickLoginButton();
        actD.checkInvalidMessage();
    }

    @Test
    @Tag("Login functionality")
    @Tag("Negative TC-3")
    @DisplayName("Cannot login with empty credentials")
    void testInvalidLoginEmpty(){
        actD = new DashboardPage(browser);

        actD.clickUsernameField();
        actD.setUsername("");
        actD.clickPasswordField();
        actD.setPassword("");
        actD.clickLoginButton();
        actD.checkInvalidMessage();
    }

    @Test
    @Tag("Forgot password functionality")
    @Tag("AC-1 positive")
    @DisplayName("Forgot password")
    void testForgotPasswordLink(){
        actD = new DashboardPage(browser);

        actD.clickForgotPassLink();
    }


}
