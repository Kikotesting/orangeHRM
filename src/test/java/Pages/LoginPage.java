package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    WebDriver browser;
    public LoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
    }

    @FindBy(id = "txtUsername")
    WebElement usernameInput;
    @FindBy(id = "txtPassword")
    WebElement passwordInput;
    @FindBy(id = "btnLogin")
    WebElement buttonLogin;

    @FindBy(xpath = "//*[@id=\"spanMessage\"]")
    public WebElement messageInvalidCredentials;

    @FindBy(xpath = "//*[@id=\"forgotPasswordLink\"]/a")
    WebElement forgotPassword;
    @FindBy(xpath = "//*[@id=\"securityAuthentication_userName\"]")
    public WebElement forgotPassword_UsernameField;
    @FindBy(xpath = "//*[@id=\"btnSearchValues\"]")
    WebElement forgotPass_ResetPasswordButton;
    @FindBy(id = "btnCancel")
    WebElement forgotPass_CancelButton;

    private void clickUsernameField(){
        usernameInput.click();
    }
    private void setUsername(String username){
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }
    private void clickPasswordField(){
        passwordInput.click();
    }
    private void setPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void executeValidLogin(){
        clickUsernameField();
        setUsername("Admin");
        clickPasswordField();
        setPassword("admin123");
        buttonLogin.click();
    }
    public void executeInvalidLoginUsername(){
        clickUsernameField();
        setUsername("Trendi");
        clickPasswordField();
        setPassword("admin123");
        buttonLogin.click();
    }
    public void executeInvalidLoginPassword(){
        clickUsernameField();
        setUsername("Admin");
        clickPasswordField();
        setPassword("412chor");
        buttonLogin.click();
    }
    public void executeInvalidLoginBlankFields(){
        clickUsernameField();
        setUsername("");
        clickPasswordField();
        setPassword("");
        buttonLogin.click();
    }

    private void clickForgotPassLink(){
        forgotPassword.click();
    }
    private void clickForgotUsernameField(){
        forgotPassword_UsernameField.click();
    }
    private void setForgotUsername(String forgotUsername){
        forgotPassword_UsernameField.clear();
        forgotPassword_UsernameField.sendKeys(forgotUsername);
    }
    private void clickResetPasswordButton(){
        forgotPass_ResetPasswordButton.click();
    }
    private void clickCancelButton(){
        forgotPass_CancelButton.click();
    }


    public void executeCancelResetForgotPassword(){
        clickForgotPassLink();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickCancelButton();
    }
    public void executeResetForgotPasswordAsRegisteredUser(){
        clickForgotPassLink();
        clickForgotUsernameField();
        setForgotUsername("Admin");
        clickResetPasswordButton();
    }
    public void executeResetForgotPasswordAsNotRegisteredeUser(){
        clickForgotPassLink();
        clickForgotUsernameField();
        setForgotUsername("Pencho");
        clickResetPasswordButton();
    }

}
