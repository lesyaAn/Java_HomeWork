package seleniumFunctionalTesting.GitHubNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class GitHubSignInPage extends PageObject {
    public GitHubSignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement commitButton;

    public void enterData(String loginField, String password) {

        this.loginField.clear();
        this.loginField.sendKeys(loginField);

        this.password.clear();
        this.password.sendKeys(password);
    }

    public GitHubUserMainPage signUpButtonClick() {
        commitButton.click();
        return new GitHubUserMainPage(driver);
    }

}
