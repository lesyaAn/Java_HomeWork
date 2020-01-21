package seleniumFunctionalTesting.lieferandoTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class MainPage extends PageObject {

    @FindBy(id="imysearchstring")
    private static WebElement search;

    @FindBy(id="submit_deliveryarea")
    private  WebElement submit;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public RestListPage enterAddress(String mainSearch){
        MainPage.search.clear();
        MainPage.search.sendKeys(mainSearch);

        submit.click();
        return new RestListPage(driver);
    }
}
