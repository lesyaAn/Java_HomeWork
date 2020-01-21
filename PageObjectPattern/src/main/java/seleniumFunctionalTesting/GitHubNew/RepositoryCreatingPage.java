package seleniumFunctionalTesting.GitHubNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class RepositoryCreatingPage extends PageObject {
    public RepositoryCreatingPage(WebDriver driver) {
        super(driver);
    }

    public String isInitialized() {
        return header.getText();
    }

    @FindBy(tagName = "h2")
    private WebElement header;

    @FindBy(xpath = "//*[@id=\"repository_name\"]")
    private WebElement repositoryNameLine;

    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[3]/button")
    private WebElement createRepositoryButton;

    public void enterRepositoryName(String repositoryName) {
        this.repositoryNameLine.clear();
        this.repositoryNameLine.sendKeys(repositoryName);
    }

    public void createRepositoryClick() {
        createRepositoryButton.click();
    }
}
