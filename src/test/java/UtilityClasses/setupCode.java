package UtilityClasses;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class setupCode {
    public WebDriver browser;
    public Actions action = new Actions((browser));
    public JavascriptExecutor j = (JavascriptExecutor) browser;


    // Manage web-driver browser version
    @BeforeAll
    static void beforeAllTests(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEachTest() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.navigate().to("https://opensource-demo.orangehrmlive.com/");
    }

    // Clear cookies and Kill the browser after finish the test
    @AfterEach
    void afterEach() {
        browser.manage().deleteAllCookies();
        browser.quit();
    }

    // ACTIONS elements
    public void hoverElement(WebElement element){
        action.moveToElement(element).build().perform();
    }
    public void clickElement(WebElement element){
        action.click(element);
    }
    public void doubleClickElement(WebElement element){
        action.doubleClick(element).perform();
    }
    public void clickAndHoldElement(WebElement element){
        action.clickAndHold(element).build().perform();
    }
    public void rightClickMouseElement(WebElement element){
        action.contextClick(element).build().perform();
    }
    public void dragAndDropElement(WebElement source, WebElement target){
        action.dragAndDrop(source, target).build().perform();
    }

    // SCROLLING elements
    public void scrollToPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,arguments[0])",pixels);
    }
    public void scrollToWebElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void scrollEndPage() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    // CHECK visible elements
    public void IsVisibleElement(WebElement element){
        j.executeScript("document.getElementById('displayed-text').style.display='block';");
        //verify element is visible
        boolean trueVisible = element.isDisplayed();
        if(trueVisible){
            System.out.println("Element is visible");
        }else{
            System.out.println("Element is not visible");
        }
    }

}
