package seleniumFunctionalTesting.GitHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class PageSignUpGitHub extends PageObject {

    @FindBy(id="login_field")
    private WebElement loginField;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(name="commit")
    private WebElement submitButton;

    public PageSignUpGitHub(WebDriver driver) {
        super(driver);
    }

    public void enterData(String loginField, String password){
        this.loginField.clear();
        this.loginField.sendKeys(loginField);

        this.password.clear();
        this.password.sendKeys(password);

    }

    public boolean isInitialized(){
        return loginField.isDisplayed();
    }


    public ReceiptMainPageGithub submit(){
        submitButton.click();
        return new ReceiptMainPageGithub(driver);
    }


}
