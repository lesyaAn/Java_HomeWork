package seleniumFunctionalTesting;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SignUpTest extends FunctionalTest {

    @Test
    public void signUp() throws InterruptedException{
        driver.get("https://kimschiller.com/page-object-pattern-tutorial/index.html");

        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.isInitialized());

        signUpPage.enterName("First", "Last");
        signUpPage.enterAddress("123 Street", "12345");
        Thread.sleep(2000);

        ReceiptPage receiptPage = signUpPage.submit();
        assertTrue(receiptPage.isInitialized());

        assertEquals("Thank you!", receiptPage.confirmationHeader());
    }
}
