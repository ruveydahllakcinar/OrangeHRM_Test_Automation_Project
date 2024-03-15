package stepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class LoginPageStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    @Given("User at login page")
    public void userAtLoginPage() {
        loginPage.gotoPage();
    }

    //All Empty
    @When("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }
    @Then("Check {string} message about username")
    public void checkMessageAboutUsername(String username) {
        loginPage.checkMessageAboutUsername(username);
    }

    //False Username
    @When("Enter False {string} for username field")
    public void enterFalseForUsernameField(String username) {
        loginPage.enterFalseForUsernameField(username);
    }

    @When("Enter Correct {string} for password field")
    public void enterCorrectForPasswordField(String password) {
        loginPage.enterCorrectForPasswordField(password);
    }

    @Then("Check {string} message about invalid credentials")
    public void checkMessageAboutInvalidCredentials(String error) {
        loginPage.checkMessageAboutInvalidCredentials(error);
    }

    //False password
    @When("Enter Correct {string} for username field")
    public void enterCorrectForUsernameField(String correctUsername) {
        loginPage.enterCorrectForUsernameField(correctUsername);
    }

    @When("Enter False {string} for password field")
    public void enterFalseForPasswordField(String falsePassword) {
        loginPage.enterFalseForPasswordField(falsePassword);
    }

    @When("write Correct {string} for username field")
    public void writeCorrectForUsernameField(String username) {
        loginPage.writeCorrectForUsernameField(username);
    }

    @When("write correct {string} for password field")
    public void writeCorrectForPasswordField(String password) {
        loginPage.writeCorrectForPasswordField(password);
    }

    @Then("Login is succesful")
    public void loginIsSuccesful() {
        loginPage.loginIsSuccesful();
    }

}
