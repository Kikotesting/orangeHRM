package TestClasses;
import Pages.LoginPage;
import UtilityClasses.setupCode;
import org.junit.jupiter.api.*;

public class TestsLoginPage extends setupCode {
    LoginPage actLP; // if you want to change variable on all places just hold shift+F6

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
        checkInvalidMessage();
    }
    @Test
    @Tag("Login functionality")
    @DisplayName("User cannot login with valid username and invalid password")
    void testInvalidLoginPassword(){
        actLP = new LoginPage(browser);
        actLP.executeInvalidLoginPassword();
        checkInvalidMessage();
    }
    @Test
    @Tag("Login functionality")
    @DisplayName("Cannot login with empty credentials")
    void testInvalidLoginBlankFields(){
        actLP = new LoginPage(browser);
        actLP.executeInvalidLoginBlankFields();
        checkInvalidMessage();
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

    public void checkInvalidMessage(){
        Assertions.assertTrue(actLP.messageInvalidCredentials.isDisplayed());
        String invalidCredentials = "Invalid credentials";
        String emptyFields = "Username cannot be empty";
        String actualMessage = actLP.messageInvalidCredentials.getText();

        if(actualMessage == invalidCredentials){
            System.out.println(actualMessage);
        }else {
            System.out.println(emptyFields);
        }
            Assertions.assertEquals("For testing purpose!",actualMessage);
    }

}
