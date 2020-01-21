package seleniumFunctionalTesting.GitHub;

import org.junit.Before;
import org.junit.Test;
import seleniumFunctionalTesting.FunctionalTest;
import seleniumFunctionalTesting.GitHubNew.RepositoryCreatingPage;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SignUpTestGH extends FunctionalTest {

    private String repoName;
    private PageSignUpGitHub pageSignUpGitHub;
    private ReceiptMainPageGithub receiptMainPageGithub;
    private String repositoryNameToBeSearched;

    @Before
    public void init() throws InterruptedException {
        repoName = "SeleniumTestRepository";
        driver.get("https://github.com/login");
        pageSignUpGitHub = new PageSignUpGitHub(driver);
        pageSignUpGitHub.enterData("lesyaAn", "lesyashaV282726");
        Thread.sleep(2000);
        ReceiptMainPageGithub receiptMainPageGithub = pageSignUpGitHub.submit();

    }

   /* @Test
    public void signUp() throws InterruptedException{
        driver.get("https://github.com/login");

        PageSignUpGitHub pageSignUpGitHub = new PageSignUpGitHub(driver);
        assertTrue(pageSignUpGitHub.isInitialized());

        pageSignUpGitHub.enterLogin("lesyaAn");
        pageSignUpGitHub.enterPassword("lesyashaV282726");
        Thread.sleep(2000);
        ReceiptMainPageGithub receiptMainPageGithub = pageSignUpGitHub.submit();
        assertTrue(receiptMainPageGithub.isInitializedGH());
    } */

    @Test
    public void repositoryCreatingTest() throws InterruptedException{

        ReceiptRepositoryMainPageGithub receiptRepositoryMainPageGithub = receiptMainPageGithub.newButtonClick();
        assertEquals("Create a new repository", receiptRepositoryMainPageGithub.isInitialized());
        Thread.sleep(2000);

        receiptRepositoryMainPageGithub.enterRepositoryName(repoName);
        Thread.sleep(2000);
        receiptRepositoryMainPageGithub.createRepositoryClick();

       driver.get("https://github.com/");
       receiptMainPageGithub = new ReceiptMainPageGithub(driver);

       repositoryNameToBeSearched = receiptMainPageGithub.findALink(repoName);
       Thread.sleep(2000);
    }


}
