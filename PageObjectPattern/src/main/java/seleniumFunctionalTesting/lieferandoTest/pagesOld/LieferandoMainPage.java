package seleniumFunctionalTesting.lieferandoTest.pagesOld;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class LieferandoMainPage extends PageObject {

    @FindBy(id="imysearchstring")
    private static WebElement mainSearch;

    @FindBy(id="submit_deliveryarea")
    private  WebElement submitButton;

    public LieferandoMainPage(WebDriver driver) {
        super(driver);
    }

    public static void enterAddress(String mainSearch){
        LieferandoMainPage.mainSearch.clear();
        LieferandoMainPage.mainSearch.sendKeys(mainSearch);

    }

    public static boolean isInitialized(){
        return mainSearch.isDisplayed();
    }

    public LieferandoReceiptRtrsPage submit(){
        submitButton.click();
        return new LieferandoReceiptRtrsPage(driver);
    }
}
