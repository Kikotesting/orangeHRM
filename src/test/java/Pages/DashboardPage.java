package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(id = "forgotPasswordLink")
    WebElement forgotPassLink;
    @FindBy(xpath = "//*[@id=\"spanMessage\"]")
    WebElement messageInvalidCredentials;

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
        Assertions.assertTrue(forgotPassLink.isDisplayed());
        forgotPassLink.click();
        System.out.println("Click forgotPassword Link");
    }

}
