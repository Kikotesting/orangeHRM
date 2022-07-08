package TestClasses;
import Pages.LoginPage;
import UtilityClasses.setupCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class TestsLoginPage extends setupCode {
    LoginPage actLP;

    @Test
    @Tag("Login functionality")
    @DisplayName("User can login with valid credentials")
    public void testValidLogin(){
        actLP = new LoginPage(browser);
        actLP.clickUsernameField();
        actLP.setUsername("Admin");
        actLP.clickPasswordField();
        actLP.setPassword("admin123");
        actLP.clickLoginButton();
        actLP.verifiedLoggedUser();
    }

    @Test
    @Tag("Login functionality")
    @DisplayName("User cannot login with invalid username and valid password")
    void testInvalidLoginUsername(){
        actLP = new LoginPage(browser);

        actLP.clickUsernameField();
        actLP.setUsername("Pesho");
        actLP.clickPasswordField();
        actLP.setPassword("admin123");
        actLP.clickLoginButton();
        actLP.checkInvalidMessage();
    }

    @Test
    @Tag("Login functionality")
    @DisplayName("User cannot login with valid username and invalid password")
    void testInvalidLoginPassword(){
        actLP = new LoginPage(browser);

        actLP.clickUsernameField();
        actLP.setUsername("Admin");
        actLP.clickPasswordField();
        actLP.setPassword("1221444");
        actLP.clickLoginButton();
        actLP.checkInvalidMessage();
    }

    @Test
    @Tag("Login functionality")
    @DisplayName("Cannot login with empty credentials")
    void testInvalidLoginEmpty(){
        actLP = new LoginPage(browser);

        actLP.clickUsernameField();
        actLP.setUsername("");
        actLP.clickPasswordField();
        actLP.setPassword("");
        actLP.clickLoginButton();
        actLP.checkInvalidMessage();
    }

    @Test
    @Tag("Forgot password functionality")
    @DisplayName("Check all fields on forgot password page")
    void testForgotPasswordLink(){
        actLP = new LoginPage(browser);

        actLP.clickForgotPassLink();
        actLP.verifiedForgotPasswordForm();
    }
    @Test
    @Tag("Forgot password functionality")
    @DisplayName("Reset password with valid credentials")
    void testResetForgotPassword() throws InterruptedException {
        actLP = new LoginPage(browser);

        actLP.clickForgotPassLink();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actLP.clickForgotUsernameField();
        actLP.setForgotUsername("Admin");
        actLP.clickResetPasswordButton();
    }





}
