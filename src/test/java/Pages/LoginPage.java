package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    public void clickUsernameField(){
        usernameInput.click();
    }
    public void setUsername(String username){
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }
    public void clickPasswordField(){
        passwordInput.click();
    }
    public void setPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        buttonLogin.click();
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
        forgotPass.click();
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
    }
    public void clickResetPasswordButton(){
        forgotPass_ResetPasswordButton.click();
    }

}
