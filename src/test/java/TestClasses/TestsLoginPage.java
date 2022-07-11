package TestClasses;
import Pages.LoginPage;
import UtilityClasses.setupCode;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestsLoginPage extends setupCode {
    LoginPage actLP;

    @Test
    @Tag("Login functionality")
    @DisplayName("User can login with valid credentials")
    public void testValidLogin(){
        actLP = new LoginPage(browser);
        actLP.executeValidLogin();
    }
    @Test
    @Tag("Login functionality")
    @DisplayName("User cannot login with invalid username and valid password")
    void testInvalidLoginUsername(){
        actLP = new LoginPage(browser);
        actLP.executeInvalidLoginUsername();
    }
    @Test
    @Tag("Login functionality")
    @DisplayName("User cannot login with valid username and invalid password")
    void testInvalidLoginPassword(){
        actLP = new LoginPage(browser);
        actLP.executeInvalidLoginPassword();
    }
    @Test
    @Tag("Login functionality")
    @DisplayName("Cannot login with empty credentials")
    void testInvalidLoginBlankFields(){
        actLP = new LoginPage(browser);
        actLP.executeInvalidLoginBlankFields();
    }

    @Test
    @Tag("Forgot password functionality")
    @DisplayName("Check all fields on forgot password page")
    void testForgotPasswordLink(){
        actLP = new LoginPage(browser);
        actLP.checkAllForgotPasswordFields();
    }
    @Test
    @Tag("Forgot password functionality")
    @DisplayName("Check that user can cancel the operation")
    void testCancelResetForgotPassword(){
        actLP = new LoginPage(browser);
        actLP.executeCancelResetForgotPassword();
    }

    @Test
    @Tag("Forgot password functionality")
    @DisplayName("Reset password with valid user")
    void testResetForgotPasswordRegisteredUser() throws InterruptedException {
        actLP = new LoginPage(browser);
        actLP.executeResetForgotPasswordAsRegisteredUser();
    }
    @Test
    @Tag("Forgot password functionality")
    @DisplayName("Reset password with invalid user")
    void testResetForgotPasswordNotRegisteredUser() throws InterruptedException {
        actLP = new LoginPage(browser);
        actLP.executeResetForgotPasswordAsNotRegisteredeUser();
    }

}
