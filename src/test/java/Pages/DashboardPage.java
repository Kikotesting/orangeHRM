package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver browser;
    public DashboardPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
    }

    @FindBy(id = "txtUsername")
    WebElement usernameInput;
    @FindBy(id = "txtPassword")
    WebElement passwordInput;
    @FindBy(id = "btnLogin")
    WebElement buttonLogin;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/h1")
    WebElement loggedDashboardHeading;
    @FindBy(xpath = "//*[@id=\"panel_resizable_1_0\"]/legend")
    WebElement loggedPanelLegendGraph;
    @FindBy(xpath = "//*[@id=\"welcome\"]")
    WebElement loggedWelcomeUserNav;
    @FindBy(xpath = "//*[@id=\"spanMessage\"]")
    WebElement messageInvalidCredentials;
    @FindBy(id = "forgotPasswordLink")
    WebElement forgotPass;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/h1")
    WebElement forgotPass_Heading;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[3]/div")
    WebElement forgotPass_InfoText;
    @FindBy(id = "securityAuthentication_userName")
    WebElement forgotPass_UsernameLabel;
    @FindBy(xpath = "//*[@id=\"securityAuthentication_userName\"]")
    WebElement forgotPass_UsernameField;
    @FindBy(xpath = "//*[@id=\"btnSearchValues\"]")
    WebElement forgotPass_ResetPasswordButton;

/*    @FindBy(xpath = "//input[contains(@class, 'suggest')].")
    WebElement forgotPass_ValidMessage;
    @FindBy(xpath = "")
    WebElement forgotPass_InvalidMessage;*/




    public void clickUsernameField(){
        Assertions.assertTrue(usernameInput.isDisplayed());
        usernameInput.click();
        System.out.println("Click username field");
    }
    public void setUsername(String username){
        Assertions.assertTrue(usernameInput.isDisplayed());
        usernameInput.clear();
        usernameInput.sendKeys(username);
        System.out.println("set Username");
    }
    public void clickPasswordField(){
        Assertions.assertTrue(passwordInput.isDisplayed());
        passwordInput.click();
        System.out.println("Click on password field");
    }
    public void setPassword(String password){
        Assertions.assertTrue(passwordInput.isDisplayed());
        passwordInput.clear();
        passwordInput.sendKeys(password);
        System.out.println("set Password");
    }
    public void clickLoginButton(){
        Assertions.assertTrue(buttonLogin.isDisplayed());
        buttonLogin.click();
        System.out.println("Click LoginButton");
    }
    public void verifiedLoggedUser(){
        Assertions.assertTrue(loggedDashboardHeading.isDisplayed());
        Assertions.assertTrue(loggedPanelLegendGraph.isDisplayed());
        Assertions.assertTrue(loggedWelcomeUserNav.isDisplayed());
        System.out.println("User is logged!");
    }
    public void checkInvalidMessage(){
        Assertions.assertTrue(messageInvalidCredentials.isDisplayed());
        String invalidCredentials = "Invalid credentials";
        String emptyFields = "Username cannot be empty";
        String actualMessage = messageInvalidCredentials.getText();

        if(actualMessage == invalidCredentials){
            System.out.println(actualMessage);
        }else {
            System.out.println(emptyFields);
        }
        Assertions.assertEquals("For testing purpose!",actualMessage);
    }
    public void clickForgotPassLink(){
        Assertions.assertTrue(forgotPass.isDisplayed());
        forgotPass.click();
        System.out.println("Click forgotPassword Link");
    }
    public void verifiedForgotPasswordForm(){
        Assertions.assertTrue(forgotPass_Heading.isDisplayed());
        Assertions.assertTrue(forgotPass_InfoText.isDisplayed());
        Assertions.assertTrue(forgotPass_UsernameLabel.isDisplayed());
        Assertions.assertTrue(forgotPass_UsernameField.isDisplayed());
        System.out.println("ForgotPassword Form is available to populate text!");
    }
    public void clickForgotUsernameField(){
        forgotPass_UsernameField.click();
    }
    public void setForgotUsername(String forgotUsername){
        forgotPass_UsernameField.clear();
        forgotPass_UsernameField.sendKeys(forgotUsername);
        System.out.println("Set Forgot Username");
    }
    public void clickResetPasswordButton(){
        forgotPass_ResetPasswordButton.click();
    }
/*    public void verifyMessageAfterResetPassword(){
        Assertions.assertTrue(messageInvalidCredentials.isDisplayed());

        String validUsername = "There is a password reset request already in the system.";
        String invalidUsername = "Please contact HR admin in order to reset the password";

        String actualMessage = forgotPass_ValidMessage.getText();

        if(actualMessage == validUsername){
            System.out.println(actualMessage);
        }else {
            System.out.println(invalidUsername);
        }
        Assertions.assertEquals("For testing purpose!",actualMessage);
    }*/
}
