package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import static org.testng.AssertJUnit.assertEquals;

public class DashboardPage {

    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper = new ElementHelper(driver);}

    By myInfoButton = By.cssSelector("[href='/web/index.php/pim/viewMyDetails'] > .oxd-text");
    By SaveButton = By.cssSelector(".oxd-button[data-v-8c6e0396]");
    By NameAndSurnameTitle = By.cssSelector(".oxd-userdropdown-name");
    public void clickToMyInfo() {
        driver.findElement(myInfoButton).click();
    }

    public void changeNameAndSurname() {
        WebElement Username = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(1) > div:nth-child(2) > input"));
        Username.sendKeys(Keys.CONTROL+"a");
        Username.sendKeys(Keys.DELETE);
        Username.sendKeys("Ruveyda");

        WebElement Surname = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(3) > div:nth-child(2) > input"));
        Surname.sendKeys(Keys.CONTROL+"a");
        Surname.sendKeys(Keys.DELETE);
        Surname.sendKeys("Akçınar");
    }

    public void clickToSaveButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.findElement(SaveButton).click();
    }

    public void checkNameAndSurname() {
        driver.findElement(myInfoButton).click();
        WebElement NewNameAndSurname = driver.findElement(NameAndSurnameTitle);
        String NewNameAndSurnameText = NewNameAndSurname.getText();
        assertEquals(NewNameAndSurnameText,"Ruveyda Akçınar");
    }
}
