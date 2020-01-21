package seleniumFunctionalTesting.GitHubNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class DeleteRepositoryConfirmationPage extends PageObject {
    public DeleteRepositoryConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"options_bucket\"]/div[8]/ul/li[4]/details/details-dialog/div[3]/form/p/input")
    WebElement confirmationLine;

    @FindBy(xpath = "//*[@id=\"options_bucket\"]/div[8]/ul/li[4]/details/details-dialog/div[3]/form/button")
    WebElement confirmationButton;

    public void confirmationButtonClick(String repositoryName) {
        confirmationLine.sendKeys(repositoryName);
        if(confirmationButton.isEnabled()) {
            confirmationButton.click();
        }
    }
}


