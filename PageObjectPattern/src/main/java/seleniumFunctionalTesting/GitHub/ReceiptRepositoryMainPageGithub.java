package seleniumFunctionalTesting.GitHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class ReceiptRepositoryMainPageGithub extends PageObject {

    public ReceiptRepositoryMainPageGithub(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName="h2")
    private WebElement headerGH;

    @FindBy(xpath = "//*[@id=\"repository_name\"]")
    private WebElement repositoryNameLine;

    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[3]/button")
    private WebElement createRepositoryButton;

    public boolean isInitialized(){
        return headerGH.isDisplayed();
    }

    public void enterRepositoryName(String repositoryName) {
        this.repositoryNameLine.clear();
        this.repositoryNameLine.sendKeys(repositoryName);
    }

    public void createRepositoryClick() {
        createRepositoryButton.click();
    }

}
