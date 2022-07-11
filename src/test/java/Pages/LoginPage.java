package Pages;

import org.junit.jupiter.api.Assertions;
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

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/h1")
    WebElement loggedDashboardHeading;
    @FindBy(xpath = "//*[@id=\"panel_resizable_1_0\"]/legend")
    WebElement loggedPanelLegendGraph;
    @FindBy(xpath = "//*[@id=\"welcome\"]")
    WebElement loggedWelcomeUserNav;

    @FindBy(xpath = "//*[@id=\"spanMessage\"]")
    WebElement messageInvalidCredentials;
    @FindBy(xpath = "//*[@id=\"forgotPasswordLink\"]/a")
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
    private void clickLoginButton(){
        buttonLogin.click();
    }
    private void verifyLoggedUser(){
        Assertions.assertTrue(loggedDashboardHeading.isDisplayed());
        Assertions.assertTrue(loggedPanelLegendGraph.isDisplayed());
        Assertions.assertTrue(loggedWelcomeUserNav.isDisplayed());
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
    public void executeValidLogin(){
        clickUsernameField();
        setUsername("Admin");
        clickPasswordField();
        setPassword("admin123");
        clickLoginButton();
        verifyLoggedUser();
    }
    public void executeInvalidLoginUsername(){
        clickUsernameField();
        setUsername("Trendi");
        clickPasswordField();
        setPassword("admin123");
        clickLoginButton();
        checkInvalidMessage();
    }
    public void executeInvalidLoginPassword(){
        clickUsernameField();
        setUsername("Admin");
        clickPasswordField();
        setPassword("412chor");
        clickLoginButton();
        checkInvalidMessage();
    }
    public void executeInvalidLoginBlankFields(){
        clickUsernameField();
        setUsername("");
        clickPasswordField();
        setPassword("");
        clickLoginButton();
        checkInvalidMessage();
    }


    private void clickForgotPassLink(){
        forgotPass.click();
    }
    public void verifyForgotPasswordForm(){
        Assertions.assertTrue(forgotPass_Heading.isDisplayed());
        Assertions.assertTrue(forgotPass_InfoText.isDisplayed());
        Assertions.assertTrue(forgotPass_UsernameLabel.isDisplayed());
        Assertions.assertTrue(forgotPass_UsernameField.isDisplayed());
        System.out.println("ForgotPassword Form is available to populate text!");
    }

    private void clickForgotUsernameField(){
        forgotPass_UsernameField.click();
    }
    private void setForgotUsername(String forgotUsername){
        forgotPass_UsernameField.clear();
        forgotPass_UsernameField.sendKeys(forgotUsername);
    }
    private void clickResetPasswordButton(){
        forgotPass_ResetPasswordButton.click();
    }
    private void clickCancelButton(){
        forgotPass_CancelButton.click();
    }

    public void checkAllForgotPasswordFields(){
        clickForgotPassLink();
        verifyForgotPasswordForm();
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
