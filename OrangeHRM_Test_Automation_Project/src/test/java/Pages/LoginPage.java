package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    By loginButton = By.cssSelector(".oxd-button");
    By errorMessage = By.cssSelector(".oxd-form > div:nth-of-type(1) .oxd-text");
    By usernameBox = By.cssSelector("[name='username']");
    By passwordBox = By.cssSelector("[name='password']");

    By errorBox = By.cssSelector(".oxd-alert-content-text");
    By Dashboard = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void gotoPage() {
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void checkMessageAboutUsername(String username) {
    elementHelper.checkVisible(errorMessage);
    }

    public void enterFalseForUsernameField(String username) {
        driver.findElement(usernameBox).click();
        elementHelper.sendKey(usernameBox, "Tester");
    }

    public void enterCorrectForPasswordField(String password) {
        driver.findElement(passwordBox).click();
        elementHelper.sendKey(passwordBox, "admin123");
    }

    public void checkMessageAboutInvalidCredentials(String error) {
        elementHelper.checkVisible(errorBox);
    }

    public void enterCorrectForUsernameField(String correctUsername) {
        driver.findElement(usernameBox).click();
        elementHelper.sendKey(usernameBox, "Admin");
    }

    public void enterFalseForPasswordField(String falsePassword) {
        driver.findElement(passwordBox).click();
        elementHelper.sendKey(passwordBox, "Tester123");
    }

    public void writeCorrectForUsernameField(String username) {
        driver.findElement(usernameBox).click();
        elementHelper.sendKey(usernameBox, "Admin");
    }

    public void writeCorrectForPasswordField(String password) {
        driver.findElement(passwordBox).click();
        elementHelper.sendKey(passwordBox, "admin123");
    }

    public void loginIsSuccesful() {
        WebElement DashboardElement = driver.findElement(Dashboard);
        String DashboardElementText = DashboardElement.getText();
        assertEquals(DashboardElementText,"Dashboard");

    }
}
