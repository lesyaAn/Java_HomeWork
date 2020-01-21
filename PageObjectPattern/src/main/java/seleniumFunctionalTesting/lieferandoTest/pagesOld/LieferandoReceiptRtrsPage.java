package seleniumFunctionalTesting.lieferandoTest.pagesOld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class LieferandoReceiptRtrsPage extends PageObject {

    @FindBy(xpath = "/html/body/header/div[1]/div")
    private WebElement header;

    @FindBy(xpath = "//*[@id=\'kitchen-types\']/div/div/div[2]/div")
    private WebElement choosedRestaurant;

    public LieferandoReceiptRtrsPage(WebDriver driver) {
    }

    public WebElement findFirstElement() {

        List<WebElement> restaurants = (List<WebElement>) driver.findElements(By.className("js-restaurant restaurant "));
        return restaurants.get(0);

    }
    public boolean isInitialized(){
        return findFirstElement().isDisplayed();
    }

    public OrderDishesForm submit(){
        choosedRestaurant.click();
        return new OrderDishesForm(driver);
    }


}
