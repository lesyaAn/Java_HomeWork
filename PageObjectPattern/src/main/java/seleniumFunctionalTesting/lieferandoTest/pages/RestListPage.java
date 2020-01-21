package seleniumFunctionalTesting.lieferandoTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

import java.util.ArrayList;
import java.util.List;

public class RestListPage extends PageObject {
    public RestListPage(WebDriver driver) {
            super(driver);
    }

    @FindBy(xpath = "/html/body/header/div[1]/div/div[2]/button")
    private WebElement indexLabel;

    @FindBy(id="irestaurantsearchstring-middle")
    private WebElement search;

    private ArrayList <WebElement> restList;

    //public boolean checkSearch() {   return driver.findElement(By.id("irestaurantsearchstring-middle")).isDisplayed(); }

    public MenuPage selectRest(String name){
        restList = (ArrayList <WebElement>)driver.findElements(By.className("restaurantname"));
        try{

        restList.forEach((x) ->{
            if(x.getText().equals(name)){
                x.click();
            }
        });}
        catch(StaleElementReferenceException e){
            System.out.println("Exception!");
            return new MenuPage(driver);
        }
        return new MenuPage(driver);
    }

    public String checkIndexLabel(){
        return indexLabel.getText();
    }
    public boolean checkSearch() {   return search.isDisplayed(); }



}