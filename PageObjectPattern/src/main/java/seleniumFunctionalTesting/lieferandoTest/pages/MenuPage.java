package seleniumFunctionalTesting.lieferandoTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

import java.util.List;

public class MenuPage extends PageObject {

    public MenuPage(WebDriver driver) {

        super(driver);
    }
    @FindBy(xpath = "//*[@id='menu-tab-content']/div[1]/div/div[1]/h1")
    private WebElement restLabel;

    @FindBy(className = "menucard__meals")
    private WebElement menuCard;

    @FindBy(className = "sidedish-checkbox")
    private WebElement addOn;

    @FindBy(xpath = "//*[@id=\"isidedishselectionformOPP3QQPQQ\"]/div[2]/div[2]/button")
    private WebElement checkOutButton;

    @FindBy(xpath = "//*[@id=\"isidedishselectionformOPP3QQPQQ\"]/div[2]/div[1]/div[3]/button")
    private WebElement plusAmountDish;

    @FindBy(xpath = "//*[@id=\"OPP3QQPQQ\"]/div/button[2]")
    private WebElement getPlusAmountDishBasket;

    @FindBy(xpath = "//*[@id=\"ibasket\"]/div[2]/button")
    private WebElement orderButton;

    public void checkOut(){
        checkOutButton.click();
    }

    public boolean checkLabel(){
        return restLabel.isDisplayed();
    }

    public void selectDish(String dishName){
        List<WebElement> spanList = driver.findElements(By.className("meal-name"));
        spanList.forEach((x) -> {
            if (x.getText().contains(dishName))
                x.click();
        });

    }

    public void selectExtras(String extras){
        List<WebElement> spanList = driver.findElements(By.className("checkbox-inline"));
        spanList.forEach((x) -> {
            if (x.getText().contains(extras))
                x.click();
        });
    }
    public void selectPlusDishes(){
        plusAmountDish.click();
        plusAmountDish.click();

    }

    public void selectPlusDishesInBasket(){
        getPlusAmountDishBasket.click();
    }

    public void orderButton(){
        orderButton.click();
    }







}
