package seleniumFunctionalTesting.GitHubNew;

import org.junit.Before;
import org.junit.Test;
import seleniumFunctionalTesting.FunctionalTest;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RepositoryCreatingPageTest extends FunctionalTest {
    private String repoName;
    private GitHubSignInPage gitHubSignInPage;
    private GitHubUserMainPage gitHubUserMainPage;
    private String repositoryNameToBeSearched;

    @Before
    public void init() throws InterruptedException {
        repoName = "SeleniumTestRepository1";
        driver.get("https://github.com/login");
        gitHubSignInPage = new GitHubSignInPage(driver);
        gitHubSignInPage.enterData("lesyaAn", "lesyashaV282726");
        Thread.sleep(2000);
        gitHubUserMainPage = gitHubSignInPage.signUpButtonClick();
    }

    @Test
    public void repositoryCreatingTest() throws InterruptedException {

        RepositoryCreatingPage repositoryCreatingPage = gitHubUserMainPage.newButtonClick();
        assertEquals("Create a new repository", repositoryCreatingPage.isInitialized());
        Thread.sleep(2000);

        repositoryCreatingPage.enterRepositoryName(repoName);
        Thread.sleep(2000);
        repositoryCreatingPage.createRepositoryClick();

        driver.get("https://github.com/");
        gitHubUserMainPage = new GitHubUserMainPage(driver);

        repositoryNameToBeSearched = gitHubUserMainPage.findALink(repoName);
        assertTrue(repositoryNameToBeSearched.contains(repoName));
        Thread.sleep(2000);
    }
    @Test
    public void repositoryDeletingTest() throws InterruptedException {
        driver.get("https://github.com/lesyaAn/"+ repoName +"/settings");
        GitHubDeleteRepositoryPage gitHubDeleteRepositoryPage = new GitHubDeleteRepositoryPage(driver);
        DeleteRepositoryConfirmationPage deleteRepositoryConfirmationPage = gitHubDeleteRepositoryPage.deleteButtonClick();

        deleteRepositoryConfirmationPage.confirmationButtonClick("lesyaAn/" + repoName);
        Thread.sleep(4000);

        driver.get("https://github.com/");
        gitHubUserMainPage = new GitHubUserMainPage(driver);

        repositoryNameToBeSearched = gitHubUserMainPage.findALink(repoName);
        assertFalse(repositoryNameToBeSearched.contains(repoName));
        Thread.sleep(2000);
    }
}
