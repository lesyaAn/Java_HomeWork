package seleniumFunctionalTesting.GitHubNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class GitHubDeleteRepositoryPage extends PageObject {
    public GitHubDeleteRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"options_bucket\"]/div[8]/ul/li[4]/details/summary")
    private WebElement deleteButton;

    public DeleteRepositoryConfirmationPage deleteButtonClick() {
        deleteButton.click();
        return new DeleteRepositoryConfirmationPage(driver);
    }

}
