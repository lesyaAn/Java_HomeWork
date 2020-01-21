package seleniumFunctionalTesting.GitHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.GitHubNew.RepositoryCreatingPage;
import seleniumFunctionalTesting.PageObject;

public class ReceiptMainPageGithub extends PageObject {

    public ReceiptMainPageGithub(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[4]/div/aside[1]/div[2]/div/div/h2/a")
    private WebElement button;

    @FindBy(css = "#dashboard-repos-filter-left")
    private WebElement searchLine;

    @FindBy(xpath = "/html/body/div[4]/div/aside[1]/div[2]/div/div/ul/li[5]/div/a/span[2]")
    private WebElement link;

    public boolean isInitialized() {
        return button.isDisplayed();
    }

    public ReceiptRepositoryMainPageGithub newButtonClick() {
        button.click();
        return new ReceiptRepositoryMainPageGithub(driver);
    }

    public String findALink(String userQuery) {
        searchLine.sendKeys(userQuery);
        return link.getText();
    }

}
