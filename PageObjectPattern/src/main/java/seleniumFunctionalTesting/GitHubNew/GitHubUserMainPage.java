package seleniumFunctionalTesting.GitHubNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class GitHubUserMainPage extends PageObject {

    public GitHubUserMainPage(WebDriver driver) {
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

    public RepositoryCreatingPage newButtonClick() {
        button.click();
        return new RepositoryCreatingPage(driver);
    }

    public String findALink(String userQuery) {
        searchLine.sendKeys(userQuery);
        return link.getText();
    }

}
